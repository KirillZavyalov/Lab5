package ru.ITMO.Commands;

import ru.ITMO.Collection.CollectionController;
import ru.ITMO.Utils.PojoToXml;
import ru.ITMO.Utils.XmlToObject;

import java.util.ArrayList;

/**
 *Команда вызывает чтение файла и десериализацию хранящихся в нем объектов в коллекцию
 */
public class LoadXmlCommand implements Command{
    CollectionController cc;

    public LoadXmlCommand(CollectionController cc){
        this.cc = cc;
    }

    /**
     * @param arguments
     */
    @Override
    public void execute(ArrayList<String> arguments) {
        XmlToObject xto = new XmlToObject(System.getenv("lab5"), cc);

        xto.readXml();
    }
}
