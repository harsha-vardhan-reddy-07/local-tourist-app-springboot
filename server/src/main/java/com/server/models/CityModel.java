package com.server.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "cities")
public class CityModel {

    public String _id;
    public String name;
    public String bannerImg;
    
    public CityModel() {

    }

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getBannerImg() {
        return bannerImg;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public CityModel(String _id, String name, String bannerImg) {
        this._id = _id;
        this.name = name;
        this.bannerImg = bannerImg;
    }

    @Override
    public String toString() {
        return "CityModel [_id=" + _id + ", name=" + name + ", bannerImg=" + bannerImg + "]";
    }
}
