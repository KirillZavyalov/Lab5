package ru.ITMO.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

    public Person(@JsonProperty("name")
                  String name, @JsonProperty("weight")
                  float weight, @JsonProperty("eyecolor")
                  Color eyeColor, @JsonProperty("haircolor")
                  Color hairColor, @JsonProperty("nationality")
                  Country nationality, @JsonProperty("location")
                  Location location) {

        this.name = name;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;

    }

    @JsonProperty("name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @JsonProperty("weight")
    private float weight; //Значение поля должно быть больше 0
    @JsonProperty("eyecolor")
    private Color eyeColor; //Поле не может быть null
    @JsonProperty("haircolor")
    private Color hairColor; //Поле не может быть null
    @JsonProperty("nationality")
    private Country nationality; //Поле может быть null
    @JsonProperty("location")
    private Location location; //Поле может быть null

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public Country getNationality() {
        return nationality;
    }


}
