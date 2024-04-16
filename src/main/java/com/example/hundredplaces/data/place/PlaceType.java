package com.example.hundredplaces.data.place;

public enum PlaceType {
    MUSEUM("MUSEUM"),
    PEAK("PEAK"),
    GALLERY("GALLERY"),
    CAVE("CAVE"),
    CHURCH("CHURCH"),
    SANCTUARY("SANCTUARY"),
    FORTRESS("FORTRESS"),
    TOMB("TOMB"),
    MONUMENT("MONUMENT"),
    WATERFALL("WATERFALL"),
    OTHER("OTHER");

    private final String code;

    private PlaceType(String code) { this.code = code; }

    public String getCode() { return code; }
}
