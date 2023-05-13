package ru.ITMO.Commands;

import ru.ITMO.Collection.CollectionController;
import ru.ITMO.Utils.Printer;

import java.util.ArrayDeque;
import java.util.ArrayList;
/**
 *Команда показывает последние 16 команд
 */
public class HistoryClass implements  Command{

    ArrayDeque adq;
    Printer printer = new Printer();

    public  HistoryClass(ArrayDeque adq){
        this.adq = adq;
    }

    /**
     * @param arguments
     * Список полученных агрументов.
     */
    @Override
    public void execute(ArrayList<String> arguments) {

        printer.print(adq.toString());
        printer.print("Готово!");
    }
}
