package com.marketplace.Marketplace.Service;

import com.marketplace.Marketplace.Model.Photo;
import com.marketplace.Marketplace.Repository.photoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class photoService {
    @Autowired
    private photoRep pr;

    public List<Photo> getAll(){
        return pr.findAll();
    }
}
