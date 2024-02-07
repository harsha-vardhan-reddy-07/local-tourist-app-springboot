package com.server.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "contributions")
public class ContributionModel {

    public String _id;
    public String monumentId;
    public String contributor;
    public String contributorId;
    public String title;
    public String city;
    public String address;
    public String contribution;
    public String date;

    public ContributionModel() {

    }
    public String get_id() {
        return _id;
    }

    public String getMonumentId() {
        return monumentId;
    }

    public String getContributor() {
        return contributor;
    }

    public String getContributorId() {
        return contributorId;
    }

    public String getTitle() {
        return title;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getContribution() {
        return contribution;
    }

    public String getDate() {
        return date;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setMonumentId(String monumentId) {
        this.monumentId = monumentId;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public void setContributorId(String contributorId) {
        this.contributorId = contributorId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ContributionModel [_id=" + _id + ", monumentId=" + monumentId + ", contributor=" + contributor
                + ", contributorId=" + contributorId + ", title=" + title + ", city=" + city + ", address=" + address
                + ", contribution=" + contribution + ", date=" + date + "]";
    }


    
}
