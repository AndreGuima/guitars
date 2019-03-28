package com.adpguima.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "Guitar")
public class Guitar {

	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	private String brand;
	
	@NotNull
	private String model;
	private Date manufactureDate;

	public Guitar() {

	}
	
	public Guitar(String brand, String model, Date manufactureDate) {
		super();
		this.brand = brand;
		this.model = model;
		this.manufactureDate = manufactureDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	@Override
	public String toString() {
		return "Guitar [id=" + id + ", brand=" + brand + ", model=" + model + ", manufactureDate=" + manufactureDate
				+ "]";
	}

}
