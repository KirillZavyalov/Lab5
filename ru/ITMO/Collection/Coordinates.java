package ru.ITMO.Collection;


public class Coordinates {


    public Coordinates( double x,
                        float y){
        this.x = x;
        this.y = y;
    }

    public Coordinates(){

    }

    private double x;
    private float y;

    public double getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
