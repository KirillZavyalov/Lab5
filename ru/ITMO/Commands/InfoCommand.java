package ru.ITMO.Commands;

import ru.ITMO.Collection.CollectionController;
import ru.ITMO.Utils.Printer;

import java.util.ArrayList;

/**
 *Команда выводит в консоль информацию о коллекции
 */
public class InfoCommand implements Command {

    CollectionController cc;

    public InfoCommand(CollectionController cc){
        this.cc = cc;
    }

    /**
     * @param arguments
     * Список полученных агрументов.
     */
    @Override
    public void execute(ArrayList<String> arguments) {
        new Printer().print("Тип коллекции: " + cc.getClassName() + " Дата инициализации: " + cc.getCreationDate() +
                " Количество элементов: " + cc.getSize());
    }

}
