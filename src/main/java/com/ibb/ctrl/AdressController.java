/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibb.ctrl;

import com.github.javafaker.Faker;
import com.ibb.dao.AdressDao;
import com.ibb.model.Adress;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trainer
 */
public class AdressController {

    private final AdressDao adressDao;

    public AdressController() {
        adressDao = new AdressDao();
//        if(getAllAdresses().size()<10){
//            createAdress();
//        }
    }

    public List<Adress> getAllAdresses() {

        return adressDao.getAdress("A");

    }

    
    public void createAdress(){
        Faker f=new Faker();
        for (int i = 0; i < 10; i++) {
            Adress adress=new Adress(f.address().cityName(), f.address().firstName(), f.address().lastName());
            adressDao.save(adress);
        }
    }
    
    
}
