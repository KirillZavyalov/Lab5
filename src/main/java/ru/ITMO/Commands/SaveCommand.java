package ru.ITMO.Commands;

import ru.ITMO.Collection.CollectionController;
import ru.ITMO.Utils.PojoToXml;
import ru.ITMO.Utils.XmlToObject;

import java.io.*;
import java.util.ArrayList;

/**
 *Команда охраняет объекты коллекции в файл
 */
public class SaveCommand implements Command{

    public SaveCommand(CollectionController cc){
        this.cc = cc;
    }

    CollectionController cc;

    /**
     * @param arguments
     */
    @Override
    public void execute(ArrayList<String> arguments) {
        PojoToXml ptx = new PojoToXml(System.getProperty("savepath"));

        ptx.serialize(cc);
    }
}
