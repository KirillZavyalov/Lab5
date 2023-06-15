package ru.ITMO.Collection;

import java.time.LocalDate;
import java.util.PriorityQueue;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;


public class CollectionClass {

    @JacksonXmlElementWrapper(useWrapping = false)
    private PriorityQueue<StudyGroup> collection;
    private java.time.LocalDate creationDate;



    public CollectionClass(){
        collection = new PriorityQueue<>();
        creationDate = java.time.LocalDate.now();
    }

    public PriorityQueue<StudyGroup> getCollection() {
        return collection;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void sortbyFOE(){

    }

    @Override
    public String toString() {
        return collection.toString();
    }
}
