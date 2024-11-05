/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibb.ctrl;

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
    }

    public List<Adress> getAllAdresses() {

        return adressDao.getAdress("where");

    }

    
    
    
}
