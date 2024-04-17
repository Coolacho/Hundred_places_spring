package com.example.hundredplaces.business.objects;

import com.example.hundredplaces.data.place.Place;

import java.util.List;

public class PlaceWithCityAndImages {
    private Place place;
    private String city;
    private List<String> images;

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "PlaceWithCityAndImages{" +
                "place=" + place.toString() +
                ", city='" + city + '\'' +
                ", images=" + images +
                '}';
    }
}
