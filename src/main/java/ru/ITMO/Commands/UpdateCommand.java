package ru.ITMO.Commands;

import ru.ITMO.Collection.CollectionController;
import ru.ITMO.Collection.ObjectConstructor;
import ru.ITMO.Utils.InputAnalyzer;
import ru.ITMO.Utils.Printer;
import ru.ITMO.Readers.ReaderInterface;

import java.util.ArrayList;

/**
 *Команда заменяет значение объекта с указанным id на полученное
 */
public class UpdateCommand implements Command {

    CollectionController cc;

    ReaderInterface reader;

    Printer printer = new Printer();

    public UpdateCommand(CollectionController cc, InputAnalyzer ia){
        this.cc = cc;
        this.reader = ia.getReader();
    }

    /**
     * @param arguments
     * Список полученных агрументов.
     */
    @Override
    public void execute(ArrayList<String> arguments) {
        int id = Integer.parseInt(arguments.get(0));
        if (cc.findById(id) != null) {
            new ObjectConstructor(reader, cc).updateStudyGroup(id);
        } else {printer.print("Такой id не найден!");}
        printer.print("Готово! Введите 'show' чтобы просмотреть изменения.");
    }

}
