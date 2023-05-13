package ru.ITMO.Commands;

import ru.ITMO.Collection.CollectionController;
import ru.ITMO.Collection.StudyGroup;
import ru.ITMO.Utils.Printer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *Команда удаляет из коллекции объекты с указанным значением studentsCount
 */
public class RemoveAllByStudentsCount implements Command{

    public RemoveAllByStudentsCount(CollectionController cc){
        this.cc = cc;
    }

    Printer printer = new Printer();

    CollectionController cc;
    Long target;

    /**
     * @param arguments
     */
    @Override
    public void execute(ArrayList<String> arguments) {

        try{
            Long.parseLong(arguments.get(0));
            target = Long.parseLong(arguments.get(0));

        } catch (NumberFormatException e){
            printer.print("Неверный формат id!");
        }

        PriorityQueue<StudyGroup> sgcol2 = new PriorityQueue<>(cc.getSgcollection());
        for (StudyGroup sg : sgcol2){
            if (sg.getStudentsCount().equals(target)){
                cc.remove(sg.getId());
            }
        }

    }
}
