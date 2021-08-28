package com.onlinemarketmaker.entities;

import java.time.LocalTime;
import java.util.Objects;

public class Demand {

	String id;
	LocalTime time;
	String vegetable;
	int pricePerKg;
	int qtyRequired;

	@Override
	public String toString() {
		return "Demand [id=" + id + ", time=" + time + ", vegetable=" + vegetable + ", pricePerKg=" + pricePerKg
				+ ", qtyRequired=" + qtyRequired + "]";
	}

	public Demand(String id, LocalTime time, String vegetable, int pricePerKg, int qtyRequired) {
		this.id = id;
		this.time = time;
		this.vegetable = vegetable;
		this.pricePerKg = pricePerKg;
		this.qtyRequired = qtyRequired;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getVegetable() {
		return vegetable;
	}

	public void setVegetable(String vegetable) {
		this.vegetable = vegetable;
	}

	public int getPricePerKg() {
		return pricePerKg;
	}

	public void setPricePerKg(int pricePerKg) {
		this.pricePerKg = pricePerKg;
	}

	public int getQtyRequired() {
		return qtyRequired;
	}

	public void setQtyAvailable(int qtyRequired) {
		this.qtyRequired = qtyRequired;
	}

}