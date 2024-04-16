package com.example.hundredplaces.data.user;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(
            name = "email",
            unique = true,
            nullable = false
    )
    private String email;

    @Column(
            name = "password",
            nullable = false
    )
    private String password;

    @Column(
            name = "hundred_places_visited",
            nullable = false
    )
    private int hundredPlacesVisited = 0;

    @Column(
            name = "museums_visited",
            nullable = false
    )
    private int museumsVisited = 0;

    @Column(
            name = "peaks_visited",
            nullable = false
    )
    private int peaksVisited = 0;

    @Column(
            name = "galleries_visited",
            nullable = false
    )
    private int galleriesVisited = 0;

    @Column(
            name = "caves_visited",
            nullable = false
    )
    private int cavesVisited = 0;

    @Column(
            name = "churches_visited",
            nullable = false
    )
    private int churchesVisited = 0;

    @Column(
            name = "sanctuaries_visited",
            nullable = false
    )
    private int sanctuariesVisited = 0;

    @Column(
            name = "fortresses_visited",
            nullable = false
    )
    private int fortressesVisited = 0;

    @Column(
            name = "tombs_visited",
            nullable = false
    )
    private int tombsVisited = 0;

    @Column(
            name = "monuments_visited",
            nullable = false
    )
    private int monumentsVisited = 0;

    @Column(
            name = "waterfalls_visited",
            nullable = false
    )
    private int waterfallsVisited = 0;

    @Column(
            name = "others_visited",
            nullable = false
    )
    private int othersVisited = 0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHundredPlacesVisited() {
        return hundredPlacesVisited;
    }

    public void setHundredPlacesVisited(int hundredPlacesVisited) {
        this.hundredPlacesVisited = hundredPlacesVisited;
    }

    public int getMuseumsVisited() {
        return museumsVisited;
    }

    public void setMuseumsVisited(int museumsVisited) {
        this.museumsVisited = museumsVisited;
    }

    public int getPeaksVisited() {
        return peaksVisited;
    }

    public void setPeaksVisited(int peaksVisited) {
        this.peaksVisited = peaksVisited;
    }

    public int getGalleriesVisited() {
        return galleriesVisited;
    }

    public void setGalleriesVisited(int galleriesVisited) {
        this.galleriesVisited = galleriesVisited;
    }

    public int getCavesVisited() {
        return cavesVisited;
    }

    public void setCavesVisited(int cavesVisited) {
        this.cavesVisited = cavesVisited;
    }

    public int getChurchesVisited() {
        return churchesVisited;
    }

    public void setChurchesVisited(int churchesVisited) {
        this.churchesVisited = churchesVisited;
    }

    public int getSanctuariesVisited() {
        return sanctuariesVisited;
    }

    public void setSanctuariesVisited(int sanctuariesVisited) {
        this.sanctuariesVisited = sanctuariesVisited;
    }

    public int getFortressesVisited() {
        return fortressesVisited;
    }

    public void setFortressesVisited(int fortressesVisited) {
        this.fortressesVisited = fortressesVisited;
    }

    public int getTombsVisited() {
        return tombsVisited;
    }

    public void setTombsVisited(int tombsVisited) {
        this.tombsVisited = tombsVisited;
    }

    public int getMonumentsVisited() {
        return monumentsVisited;
    }

    public void setMonumentsVisited(int monumentsVisited) {
        this.monumentsVisited = monumentsVisited;
    }

    public int getWaterfallsVisited() {
        return waterfallsVisited;
    }

    public void setWaterfallsVisited(int waterfallsVisited) {
        this.waterfallsVisited = waterfallsVisited;
    }

    public int getOthersVisited() {
        return othersVisited;
    }

    public void setOthersVisited(int othersVisited) {
        this.othersVisited = othersVisited;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", hundredPlacesVisited=" + hundredPlacesVisited +
                ", museumsVisited=" + museumsVisited +
                ", peaksVisited=" + peaksVisited +
                ", galleriesVisited=" + galleriesVisited +
                ", cavesVisited=" + cavesVisited +
                ", churchesVisited=" + churchesVisited +
                ", sanctuariesVisited=" + sanctuariesVisited +
                ", fortressesVisited=" + fortressesVisited +
                ", tombsVisited=" + tombsVisited +
                ", monumentsVisited=" + monumentsVisited +
                ", waterfallsVisited=" + waterfallsVisited +
                ", othersVisited=" + othersVisited +
                '}';
    }
}
