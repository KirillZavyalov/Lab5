package ru.ITMO.Commands;

import ru.ITMO.Collection.CollectionController;
import ru.ITMO.Utils.Printer;

import java.util.ArrayList;
import java.util.Collection;

/**
 *Команда выводит значения поля formOfEducation всех элементов в порядке убывания
 */
public class PrintDescendingFOECommand implements Command{

    CollectionController cc;
    Printer printer = new Printer();


    public PrintDescendingFOECommand(CollectionController cc){
        this.cc = cc;
    }

    /**
     * @param arguments
     */
    @Override
    public void execute(ArrayList<String> arguments) {
        cc.sortByFOE();
    }
}
