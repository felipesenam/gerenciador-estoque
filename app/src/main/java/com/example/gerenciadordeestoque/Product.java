package com.example.gerenciadordeestoque;

import androidx.annotation.NonNull;

public class Product {
    private String code;
    private String name;
    private String description;
    private Integer quantity;

    public Product(){

    }

    @NonNull
    @Override
    public String toString() {
        return "{" +
                    "\"code\":\"" + this.code +"\"" +
                    "\"name\":\"" + this.name + "\"" +
                    "\"description\":\"" + this.description +"\"" +
                    "\"quantity\":" + this.quantity.toString() +
                "}";
    }

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Integer getQuantity(){
        return this.quantity;
    }
    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }
}
