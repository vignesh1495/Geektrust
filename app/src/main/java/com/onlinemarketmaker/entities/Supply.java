package com.onlinemarketmaker.entities;

import java.time.LocalTime;

public class Supply {

  String id;
  LocalTime time;
  String vegetable;
  int pricePerKg;
  int qtyAvailable;

  @Override
  public String toString() {
    return "Supply [id=" + id + ", time=" + time + ", vegetable=" + vegetable + ", pricePerKg=" + pricePerKg
        + ", qtyAvailable=" + qtyAvailable + "]";
  }

  public Supply(String id, LocalTime time, String vegetable, int pricePerKg, int qtyAvailable) {
    this.id = id;
    this.time = time;
    this.vegetable = vegetable;
    this.pricePerKg = pricePerKg;
    this.qtyAvailable = qtyAvailable;
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

  public int getQtyAvailable() {
    return qtyAvailable;
  }

  public void setQtyAvailable(int qtyAvailable) {
    this.qtyAvailable = qtyAvailable;
  }

}
