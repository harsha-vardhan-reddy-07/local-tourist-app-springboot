package com.server.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "monuments")
public class MonumentModel {

    public String _id;
    public String title;
    public String description;
    public String city;
    public String bannerImg;
    public String address;
    public List<String> images;
    public String otherThings;
    public String contributor;
    public String contributorId;

    public String newCity;
    public String cityBannerImg;




    public String get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCity() {
        return city;
    }

    public String getBannerImg() {
        return bannerImg;
    }

    public String getAddress() {
        return address;
    }

    public List<String> getImages() {
        return images;
    }

    public String getOtherThings() {
        return otherThings;
    }

    public String getContributor() {
        return contributor;
    }

    public String getContributorId() {
        return contributorId;
    }

    public String getNewCity() {
        return newCity;
    }

    public String getCityBannerImg() {
        return cityBannerImg;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setImages(List<String> b) {
        this.images = b;
    }

    public void setOtherThings(String otherThings) {
        this.otherThings = otherThings;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public void setContributorId(String contributorId) {
        this.contributorId = contributorId;
    }

    public void setNewCity(String newCity) {
        this.newCity = newCity;
    }

    public void setCityBannerImg(String cityBannerImg) {
        this.cityBannerImg = cityBannerImg;
    }

    public MonumentModel(String _id, String title, String description, String city, String bannerImg, String address,
            List<String> images, String otherThings, String contributor, String contributorId) {
        this._id = _id;
        this.title = title;
        this.description = description;
        this.city = city;
        this.bannerImg = bannerImg;
        this.address = address;
        this.images = images;
        this.otherThings = otherThings;
        this.contributor = contributor;
        this.contributorId = contributorId;
    }

    @Override
    public String toString() {
        return "MonumentModel [_id=" + _id + ", address=" + address + ", bannerImg=" + bannerImg + ", city=" + city
                + ", contributor=" + contributor + ", contributorId=" + contributorId + ", description=" + description
                 + ", otherThings=" + otherThings + ", title=" + title + "]";
    }
}
