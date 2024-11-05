/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibb.dao;

import com.ibb.model.Food;
import com.ibb.util.GConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class FoodDao extends GConnection{
    
    
    
    public List<Food> getFoods() throws SQLException{
        List<Food> listFood=new ArrayList<>();
        ResultSet rs = null;
         try {
            // Ausführen eines SQL-Statements via JDBC
            Statement stmt = getConnection().createStatement();
            rs = stmt.executeQuery("Select name, price from foods ");

            // Iterieren Über die Ergebnismenge des SQL-Statements
            while (rs.next()) {
              listFood.add(new Food(rs.getString(1), rs.getDouble(2)));
            }

         } catch (SQLException ex) {
            Logger.getLogger(FoodDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            rs.close();
         }
        return listFood;
    }
    
    public boolean insertFood(Food f){
        try {
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO foodshop.foods( name, price) VALUES (?, ?)");
            stmt.setString(1, f.getName());
            stmt.setDouble(2, f.getPrice());
            
            stmt.executeUpdate();
            
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FoodDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    
}
