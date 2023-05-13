package ru.ITMO.Commands;

import ru.ITMO.Collection.CollectionController;
import ru.ITMO.Readers.ReaderInterface;
import ru.ITMO.Utils.Printer;

import java.util.ArrayList;

/**
 *Команда очищает коллекцию
 */
public class ClearCommand implements Command{
    private String description = "clear : очистить коллекцию\n";

    CollectionController cc;

    ReaderInterface reader;

    Printer printer = new Printer();

    public ClearCommand(CollectionController сс, ReaderInterface reader)
    {
        this.cc = сс;
        this.reader = reader;

    }

    /**
     * @param arguments
     * Список полученных агрументов.
     */
    @Override
    public void execute(ArrayList<String> arguments) {
        printer.print("Эта команда очищает коллекцию, вы точно хотите это сделать?");
        String input = reader.read().toLowerCase();
        if (input.equals("да") || input.equals("yes")){
            cc.clear();
            printer.print("Коллекция очищена");
        } else {printer.print("Очистка коллекции отменена.");}
    }

}
