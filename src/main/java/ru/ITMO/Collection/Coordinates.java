package ru.ITMO.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coordinates {


    public Coordinates(    @JsonProperty("x")
                           double x,     @JsonProperty("y")
    float y){
        this.x = x;
        this.y = y;
    }

    @JsonProperty("x")
    private double x;
    @JsonProperty("y")
    private float y;

    public double getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
