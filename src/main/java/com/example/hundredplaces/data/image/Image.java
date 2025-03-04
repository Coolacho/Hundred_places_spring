package com.example.hundredplaces.data.image;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(
            name = "image_path",
            unique = true,
            nullable = false
    )
    private String imagePath;

    @Column(
            name = "place_id",
            nullable = false
    )
    private int placeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", imagePath='" + imagePath + '\'' +
                ", placeId=" + placeId +
                '}';
    }
}
