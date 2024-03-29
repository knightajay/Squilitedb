package com.example.squilitedb;

public class Employ {
    public Employ(int sno,String name,double increment){

    }
    private int sno;
    private String  name;
    private  double increment;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncrement() {
        return increment;
    }

    public void setIncrement(double increment) {
        this.increment = increment;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }
}
