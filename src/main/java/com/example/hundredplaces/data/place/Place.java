package com.example.hundredplaces.data.place;

import jakarta.persistence.*;

@Entity
@Table(name = "places")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(
            name = "name",
            unique = true,
            nullable = false
    )
    private String name;

    @Column(
            name = "latitude",
            nullable = false
    )
    private double latitude;

    @Column(
            name = "longitude",
            nullable = false
    )
    private double longitude;

    @Column(
            name = "type",
            nullable = false
    )
    private PlaceType type;

    @Column(
            name = "rating",
            nullable = false
    )
    private double rating = 0.0;

    @Column(
            name = "description_path",
            nullable = false
    )
    private String descriptionPath;

    @Column(
            name = "is_100_places",
            nullable = false
    )
    private boolean is100Places;

    @Column(
            name = "city_id",
            nullable = false
    )
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public PlaceType getType() {
        return type;
    }

    public void setType(PlaceType type) {
        this.type = type;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDescriptionPath() {
        return descriptionPath;
    }

    public void setDescriptionPath(String descriptionPath) {
        this.descriptionPath = descriptionPath;
    }

    public boolean getIs100Places() {
        return is100Places;
    }

    public void setIs100Places(boolean is100Places) {
        this.is100Places = is100Places;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", type=" + type +
                ", rating=" + rating +
                ", descriptionPath='" + descriptionPath + '\'' +
                ", is100Places=" + is100Places +
                ", cityId=" + cityId +
                '}';
    }
}
