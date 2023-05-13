package ru.ITMO.Collection;

import java.time.LocalDate;
import java.util.PriorityQueue;

public class CollectionClass {

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
}
