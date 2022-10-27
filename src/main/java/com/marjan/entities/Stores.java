package com.marjan.entities;

import jakarta.persistence.*;

@Entity
public class Stores {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "city_id", nullable = false)
    private int cityId;
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Cities citiesByCityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stores stores = (Stores) o;

        if (id != stores.id) return false;
        return cityId == stores.cityId;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + cityId;
        return result;
    }

    public Cities getCitiesByCityId() {
        return citiesByCityId;
    }

    public void setCitiesByCityId(Cities citiesByCityId) {
        this.citiesByCityId = citiesByCityId;
    }
}
