package com.example.hundredplaces.data.place;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class PlaceTypeConverter implements AttributeConverter<PlaceType, String> {
    @Override
    public String convertToDatabaseColumn(PlaceType attribute) {
        if (attribute == null) return null;
        return attribute.getCode();
    }

    @Override
    public PlaceType convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        return Stream.of(PlaceType.values())
                .filter(placeType -> placeType.getCode().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
