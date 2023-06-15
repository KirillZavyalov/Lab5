package ru.ITMO.Commands;

import ru.ITMO.Collection.*;
import ru.ITMO.Readers.FromFileReader;
import ru.ITMO.Readers.ReaderInterface;
import ru.ITMO.Utils.Printer;
import ru.ITMO.Utils.PrinterInterface;
import ru.ITMO.Utils.SilentPrinter;

import java.util.ArrayList;

/**
 *Команда добавления элемента в коллекию
 */
public class AddCommand implements  Command{

    String descriprion = "add {element} : добавить новый элемент в коллекцию\n";
    StudyGroup studyGroup;

    CollectionController collection;

    PrinterInterface printer;

    public AddCommand(CollectionController collection, StudyGroup studyGroup, boolean script){
        this.collection = collection;
        this.studyGroup = studyGroup;
        if (script){
            this.printer = new SilentPrinter();
        } else{
            this.printer = new Printer();
        }
    }

    /**
     * @param arguments
     * Список полученных агрументов.
     */
    @Override
    public void execute (ArrayList<String> arguments){
        collection.add(studyGroup);
        printer.print("Объект добавлен в коллекцию! Введите 'show' чтобы увидеть содержимое коллекции.");
    }

}
