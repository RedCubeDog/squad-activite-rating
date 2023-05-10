package ru.redcube.squadrating.entity.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Duration;

@Converter(autoApply = true)
public class DurationAttributeConverter implements AttributeConverter<Duration, String> {

    public static String getFormattedTimeWork(Duration timeWork) {
        return timeWork.getSeconds() / 3600 + "Ч: "
                + timeWork.getSeconds() % 3600 / 60 + "М";
    }

    @Override
    public String convertToDatabaseColumn(Duration duration) {
        if (duration == null) {
            return null;
        }
        long seconds = duration.getSeconds();
        long nanos = duration.getNano();
        boolean negative = duration.isNegative();

        long absSeconds = Math.abs(seconds);
        int hours = (int) (absSeconds / 3600);
        int minutes = (int) ((absSeconds % 3600) / 60);

        String result = String.format("%s%d:%02d", negative ? "-" : "", hours, minutes);
        if (nanos > 0) {
            result += String.format(".%09d", nanos);
        }
        return result;
    }

    @Override
    public Duration convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        boolean negative = dbData.startsWith("-");
        if (negative) {
            dbData = dbData.substring(1);
        }

        String[] parts = dbData.split("\\.");
        String timePart = parts[0];
        String[] timeParts = timePart.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);

        long totalSeconds = hours * 3600L + minutes * 60L;
        long nanos = 0;
        if (parts.length > 1) {
            String nanosPart = parts[1];
            nanos = Long.parseLong(nanosPart);
            int numDigits = nanosPart.length();
            if (numDigits < 9) {
                int scalingFactor = (int) Math.pow(10, 9 - numDigits);
                nanos *= scalingFactor;
            }
        }

        return Duration.ofSeconds(negative ? -totalSeconds : totalSeconds, nanos);
    }
}
