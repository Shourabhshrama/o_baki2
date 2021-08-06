package com.kuberkings.obaki.screens.bottomview.orders;

public class Order {
   private String name;
  private   String address;
 private   String  status;
 private   String purhcaseDate;
 private   String cat;
  private String numberOfPersons;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPurhcaseDate() {
        return purhcaseDate;
    }

    public void setPurhcaseDate(String purhcaseDate) {
        this.purhcaseDate = purhcaseDate;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(String numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }
}
