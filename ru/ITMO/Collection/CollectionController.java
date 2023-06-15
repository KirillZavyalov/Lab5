package ru.ITMO.Collection;


import ru.ITMO.Utils.Printer;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;


public class CollectionController {

    PriorityQueue<StudyGroup> sgcollection;
    ArrayList arrCollection;

    CollectionClass collectionClass;

    HashSet<Long> idSet = new HashSet<Long>();

    private void fillIdSet(){
        for (StudyGroup sg : sgcollection){
            idSet.add(sg.getId());
        }
    }

    public void setCollectionClass(CollectionClass collectionClass) {
        this.collectionClass = collectionClass;
        this.sgcollection = collectionClass.getCollection();
        fillIdSet();
    }

    Printer printer = new Printer();

    public CollectionController() {
        this.collectionClass = new CollectionClass();
        this.sgcollection = collectionClass.getCollection();
        idSet = new HashSet<Long>();
    }

    public void show() {
        for (StudyGroup sg : sgcollection){
            printer.print(sg.toString());
        }
    }

    public void show(PriorityQueue<StudyGroup> pq) {
        for (StudyGroup sg : pq){
            printer.print(sg.toString());
        }
    }

    public StudyGroup findById(int id){
        for (StudyGroup sg : sgcollection){
            if (sg.getId() == id){
                return sg;
            }
        }
        return null;
    }


    public StudyGroup findById(Long id){
        for (StudyGroup sg : sgcollection){
            if (sg.getId() == id){
                return sg;
            }
        }
        return null;
    }

    public void add(StudyGroup sg){
        long nId = 1;
        while (idSet.add(nId) != true){
            nId += 1;
        }
        idSet.add(nId);
        sg.setId(nId);
        sgcollection.add(sg);
    }

    public void remove(Long id){
        System.out.println("remove id" + id);
        sgcollection.remove(findById(id));
        idSet.remove(id);
    }

    public void removeIf(Predicate<StudyGroup> predicate){
        sgcollection.removeIf(predicate);
    }

    public  void clear(){
        sgcollection.clear();
        idSet.clear();
    }

    public PriorityQueue<StudyGroup> getSgcollection() {
        return sgcollection;
    }

    public int getSize() {
        return sgcollection.size();
    }

    public LocalDate getCreationDate(){
        return collectionClass.getCreationDate();
    }
    public String getClassName(){
        return sgcollection.getClass().getName();
    }

    public StudyGroup getMax() {
        return Collections.max(sgcollection);
    }

    public CollectionClass getCollectionClass() {
        return collectionClass;
    }

    public void sortByFOE(){
       ArrayList<StudyGroup> arrCollection= new ArrayList(sgcollection);
       Collections.sort(arrCollection);
       Collections.reverse(arrCollection);

        for (StudyGroup sg : arrCollection){
            printer.print("--> Id=" + Long.toString(sg.getId()) + " FoE: " + sg.getFormOfEducation());
        }

    }

    public void reorder() {
        arrCollection= new ArrayList(sgcollection);
        Collections.reverse(arrCollection);
        show(new PriorityQueue(arrCollection));
    }

    public String showArr(){
        return arrCollection.toString();
    }

    public StudyGroup getMin() {
        return Collections.min(sgcollection);
    }

}