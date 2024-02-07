package com.server.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.server.models.CityModel;
import com.server.models.ContributionModel;
import com.server.models.MonumentModel;
import com.server.models.UserModel;
import com.server.repos.CityRepo;
import com.server.repos.ContributionRepo;
import com.server.repos.MonumentRepo;
import com.server.repos.UserRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Controller
public class RouteController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    MonumentRepo monumentRepo;

    @Autowired
    ContributionRepo contributionRepo;

    @Autowired
    CityRepo cityRepo;

    @PostMapping("/register")
    public UserModel registerMethod(@RequestBody UserModel userData) {
        try {
            UserModel user = userRepo.save(userData);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/login")
    public UserModel loginMethod(@RequestBody UserModel userData) {
        try {
            UserModel user = userRepo.findByEmail(userData.getEmail());
            if (user.getPassword().equals(userData.getPassword())) {
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/add-location")
    public MonumentModel addLocation(@RequestBody MonumentModel monument){
        

        DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        if (monument.getCity().equals("other")){
            CityModel city = new CityModel();
            city.setName(monument.getNewCity());
            city.setBannerImg(monument.getCityBannerImg());

            cityRepo.save(city);

            monument.setCity(monument.getNewCity());
            
            monumentRepo.save(monument);

            ContributionModel contribution = new ContributionModel();
            contribution.setContributor(monument.getContributor());
            contribution.setContributorId(monument.getContributorId());
            contribution.setMonumentId(monument.get_id());
            contribution.setCity(monument.getCity());
            contribution.setAddress(monument.getAddress());
            contribution.setDate(currentDate.format(now));
            contribution.setContribution("new city & monument added");

            contributionRepo.save(contribution);
        }else{
            monumentRepo.save(monument);

            ContributionModel contribution = new ContributionModel();
            contribution.setContributor(monument.getContributor());
            contribution.setContributorId(monument.getContributorId());
            contribution.setMonumentId(monument.get_id());
            contribution.setCity(monument.getCity());
            contribution.setAddress(monument.getAddress());
            contribution.setDate(currentDate.format(now));

            contribution.setContribution("monument added");


            contributionRepo.save(contribution);
        }

        return monument;
    }

    @GetMapping("/fetch-cities")
    public List<CityModel> fetchCities(){
        return cityRepo.findAll();
    }

    @GetMapping("/fetch-monuments")
    public List<MonumentModel> fetchMonuments(){
        return monumentRepo.findAll();
    }


    @GetMapping("/fetch-monument/{id}")
    public MonumentModel fetchMonument(@PathVariable("id") String id){
        return monumentRepo.findById(id).get();
    }

    @PostMapping("/upload-monument-img/{id}")
    public MonumentModel uploadMonumentImg(@PathVariable("id") String id, @RequestBody MonumentModel monument){
        MonumentModel monumentToUpdate = monumentRepo.findById(id).get();
        List <String> images = monumentToUpdate.getImages();

        images.add(monument.getBannerImg());
        monumentToUpdate.setImages(images);
        monumentRepo.save(monumentToUpdate);


        ContributionModel contribution = new ContributionModel();
        contribution.setContributor(monument.getContributor());
        contribution.setContributorId(monument.getContributorId());
        contribution.setMonumentId(id);
        contribution.setCity(monumentToUpdate.getCity());
        contribution.setAddress(monumentToUpdate.getAddress());
        contribution.setContribution("Image uploaded");

        DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        contribution.setDate(currentDate.format(now));

        contributionRepo.save(contribution);

        return monumentToUpdate;


    }

    @GetMapping("/fetch-contributions")
    public List<ContributionModel> fetchContributions(){
        return contributionRepo.findAll();
    }
    


    
}
