package ru.ITMO.Commands;

import ru.ITMO.Collection.CollectionController;
import ru.ITMO.Collection.StudyGroup;
import ru.ITMO.Utils.Printer;

import java.util.ArrayList;
/**
 *Посчитать количество элементов, у которых вес админа меньше заданого
 */
public class CountLessThanAdmin implements Command {

    CollectionController cc;
    Long count = Long.parseLong("0");
    Printer printer = new Printer();

    public CountLessThanAdmin(CollectionController cc) {
        this.cc = cc;
    }


    /**
     * @param arguments
     */
    @Override
    public void execute(ArrayList<String> arguments) {
        try {
            float target = Float.parseFloat(arguments.get(0));
            for (StudyGroup sg : cc.getSgcollection()) {

                if (cc.getSize() != 0) {
                    if (sg.getGroupAdmin().getWeight() < target) {
                        count++;
                    }
                }
            }
            printer.print(count.toString());
            printer.print("Готово!");
        } catch (NumberFormatException e){printer.print("Неверный формат id!");}
    }
}
