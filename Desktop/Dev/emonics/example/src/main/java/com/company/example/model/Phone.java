package com.company.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "CellPhones")
public class Phone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelName;
    private String brand;
    private String color;
    private int year;
    private Double price;
    private String memory;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public Phone() {
    }

    public Phone(Long id, String modelName, String brand, String color, int year, Double price, String memory) {
        this.id = id;
        this.modelName = modelName;
        this.brand = brand;
        this.color = color;
        this.year = year;
        this.price = price;
        this.memory = memory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @PrePersist
    public void beforeCreate(){
        this.createDate = LocalDateTime.now();
    }

    @PreUpdate
    public void beforeUpdate(){
        this.updateDate = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", memory='" + memory + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
