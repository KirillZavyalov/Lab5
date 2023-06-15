package ru.ITMO.Collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

    public Person(
                  String name,
                  float weight,
                  Color eyeColor,
                  Color hairColor,
                  Country nationality,
                  Location location) {

        this.name = name;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }

    public Person(){

    }

    private String name; //Поле не может быть null, Строка не может быть пустой
    private float weight; //Значение поля должно быть больше 0
    private Color eyeColor; //Поле не может быть null
    private Color hairColor; //Поле не может быть null
    private Country nationality; //Поле может быть null
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

    @Override
    public String toString() {
        if(this.equals(null)){return "null";}
        else {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", weight=" + weight +
                    ", eyeColor=" + eyeColor +
                    ", hairColor=" + hairColor +
                    ", nationality=" + nationality +
                    ", location=" + location +
                    '}';
        }
    }
}
