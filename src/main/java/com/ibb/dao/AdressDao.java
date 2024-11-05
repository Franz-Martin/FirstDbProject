/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibb.dao;

import com.ibb.model.Adress;
import com.ibb.util.GConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trainer
 */
public class AdressDao extends GConnection{
    
    
    
    public List<Adress> getAdress(String where) {
        List<Adress> listAdress=new ArrayList<>();
        ResultSet rs = null;
         try {
            // Ausführen eines SQL-Statements via JDBC
            Statement stmt = getConnection().createStatement();
            rs = stmt.executeQuery("Select ort ,vorname ,nachname ,email from adress");

            // Iterieren Über die Ergebnismenge des SQL-Statements
            while (rs.next()) {
              listAdress.add(new Adress(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4)));
            }

         } catch (SQLException ex) {
            Logger.getLogger(FoodDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdressDao.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        return listAdress;
    }
    
}
