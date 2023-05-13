package ru.ITMO.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

    public Location(    @JsonProperty("x")
                        Float x,     @JsonProperty("y")
    float y,     @JsonProperty("name")
    String name) {

        this.x = x;
        this.y = y;
        this.name = name;

    }
    @JsonProperty("x")
    private Float x; //Поле не может быть null
    @JsonProperty("y")
    private float y;
    @JsonProperty("name")
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
}
