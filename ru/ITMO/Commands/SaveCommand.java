package ru.ITMO.Commands;

import ru.ITMO.Collection.CollectionClass;
import ru.ITMO.Collection.CollectionController;
import ru.ITMO.Utils.PojoToXml;

import java.util.ArrayList;

/**
 *Команда охраняет объекты коллекции в файл
 */
public class SaveCommand implements Command{

    public SaveCommand(CollectionClass collectionClass){
        this.collectionClass = collectionClass;
    }

    CollectionClass collectionClass;

    /**
     * @param arguments
     */
    @Override
    public void execute(ArrayList<String> arguments) {
        PojoToXml ptx = new PojoToXml(System.getenv("lab5"));

        ptx.serialize(collectionClass);
        System.out.println("Коллекция сохранена в файл " + System.getenv("lab5"));
    }
}
