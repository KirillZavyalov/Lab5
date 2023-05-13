package ru.ITMO.Commands;

import ru.ITMO.Collection.CollectionController;
import ru.ITMO.Utils.Printer;

import java.util.ArrayList;

/**
 *Команда удаляет из коллекции объект с указанным значением id
 */
public class RemoveByIdCommand implements Command{
    Printer printer = new Printer();


    String description = "remove_by_id id : удалить элемент из коллекции по его id\n";
    CollectionController cc;
    public RemoveByIdCommand(CollectionController cc){
        this.cc = cc;
    }

    /**
     * @param arguments
     * Список полученных агрументов.
     */
    @Override
    public void execute(ArrayList<String> arguments) {
        int id;
         try {
             id = Integer.parseInt(arguments.get(0));
             if (cc.findById(id) != null){
                cc.remove(id);
                printer.print("Готово!");
             } else {
                 printer.print("индекс не найден");
             }
         } catch (NumberFormatException e){
             printer.print("Неверный формат id!");
         }
    }

}
