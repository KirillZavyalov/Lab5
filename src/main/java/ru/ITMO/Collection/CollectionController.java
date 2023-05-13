package ru.ITMO.Collection;


import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;


public class CollectionController {

    PriorityQueue<StudyGroup> sgcollection;
    ArrayList arrCollection;
    CollectionClass collectionClass;

    private long nexdId = 1;

    public CollectionController() {
        this.collectionClass = new CollectionClass();
        this.sgcollection = collectionClass.getCollection();
    }

    public void show() {
        for (StudyGroup sg : sgcollection){
            System.out.println("Id:" + " " + sg.getId() + " Name: '" + sg.getName() + "' "
                    +"Studs count:  " + sg.getStudentsCount() + " Admin: " + sg.getGroupAdmin().getName());
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

    @Override
    public String toString() {
        return "CollectionController{" +
                "collection=" + sgcollection +
                '}';
    }

    public void add(StudyGroup sg){
        sg.setId(nexdId);
        nexdId = nexdId+1;
        sgcollection.add(sg);
    }

    public void remove(int id){
        StudyGroup element = findById(id);
        sgcollection.remove(element);
    }

    public void remove(Long id){
        StudyGroup element = findById(id);
        sgcollection.remove(element);
    }

    public void removeIf(Predicate<StudyGroup> predicate){
        sgcollection.removeIf(predicate);
    }

    public  void clear(){
        sgcollection.clear();
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

    public void sortByFOE(){
       arrCollection= new ArrayList(sgcollection);
       Collections.sort(arrCollection);
    }

    public void reorder() {
        arrCollection= new ArrayList(sgcollection);
        Collections.reverse(arrCollection);
    }

    public String showArr(){
        return arrCollection.toString();
    }

    public StudyGroup getMin() {
        return Collections.min(sgcollection);
    }

}