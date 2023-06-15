package ru.ITMO.Commands;

import ru.ITMO.Collection.CollectionController;
import ru.ITMO.Utils.Printer;

import java.util.ArrayList;

/**
 *Команда выводит элементы коллекции
 */
public class ShowCommand implements Command{

    public ShowCommand(CollectionController cc){
        this.cc = cc;
    }

    CollectionController cc;
    Printer printer = new Printer();

    /**
     * @param arguments
     * Список полученных агрументов.
     */
    @Override
    public void execute(ArrayList<String> arguments) {
        printer.print("-Начало вывода коллекции-");
        cc.show();
        printer.print("-Конец вывода коллекции-");
    }

}
