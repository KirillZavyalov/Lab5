package ru.ITMO.Commands;

import ru.ITMO.Collection.CollectionController;
import ru.ITMO.Collection.ObjectConstructor;
import ru.ITMO.Collection.StudyGroup;
import ru.ITMO.Readers.ReaderInterface;
import ru.ITMO.Utils.Printer;

import java.util.ArrayList;
/**
 *Посчитать количество элементов, у которых вес админа меньше заданого
 */
public class CountLessThanAdmin implements Command {

    CollectionController cc;
    int count = 0;
    Printer printer = new Printer();
    ReaderInterface reader;

    public CountLessThanAdmin(ReaderInterface reader, CollectionController cc) {

        this.cc = cc;
        this.reader = reader;
    }


    /**
     * @param arguments
     */
    @Override
    public void execute(ArrayList<String> arguments) {
        StudyGroup newMember = new ObjectConstructor(reader, cc).createStudyGroup();
        if (cc.getSize() != 0){
            for (StudyGroup sg : cc.getSgcollection()) {

                if (sg.getGroupAdmin().getWeight() < newMember.getGroupAdmin().getWeight()) {
                    count++;
               }
            }
        }
        printer.print(count + " Элементов имеют Group Admin меньше заданного (" + newMember.getGroupAdmin().getWeight() +").");
    }
}
