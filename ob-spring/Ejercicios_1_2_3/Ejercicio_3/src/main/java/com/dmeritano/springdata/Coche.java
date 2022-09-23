package com.dmeritano.springdata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Coche {

	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String manufacturer;
	private String model;
	private int year;

	public Coche() {
	}

	public Coche(Long id, String manufacturer, String model, int year) {
		this.id = id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.year = year;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", manufacturer=" + manufacturer + ", model=" + model + ", year=" + year + "]";
	}

}
