package ru.ITMO.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

    public Location(
                        Float x,
    float y,
    String name) {

        this.x = x;
        this.y = y;
        this.name = name;

    }

    public Location(){

    }
    private Float x; //Поле не может быть null
    private float y;
    private String name; //Поле может быть null



    public Float getX() {
        return x;
    }


    public float getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                '}';
    }
}
