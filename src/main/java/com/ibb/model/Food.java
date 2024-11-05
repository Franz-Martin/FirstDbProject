/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibb.model;

/**
 *
 * @author trainer
 */
public class Food {
    
    private int foodNo;
    private String name;
    private double price;

    public Food() {
    }

    
    
    
    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    
    

    public int getFoodNo() {
        return foodNo;
    }

    public void setFoodNo(int foodNo) {
        this.foodNo = foodNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
    
    
    
}
