package com.dmeritano.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "laptops")
public class Laptop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String brand;
	private String model;
	private String screenSize;
	private String color;
	private String hardDisk;
	private String memory;
	private Double price;

	public Laptop() {
	}

	public Laptop(Long id, String brand, String model, String screenSize, String color, String hardDisk, String memory,
			Double price) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.screenSize = screenSize;
		this.color = color;
		this.hardDisk = hardDisk;
		this.memory = memory;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getHardDisk() {
		return hardDisk;
	}

	public void setHardDisk(String hardDisk) {
		this.hardDisk = hardDisk;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Laptop [brand=" + brand + ", model=" + model + ", screenSize=" + screenSize + ", color=" + color
				+ ", hardDisk=" + hardDisk + ", memory=" + memory + ", price=" + price + "]";
	}

}
