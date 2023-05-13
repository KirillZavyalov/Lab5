package ru.ITMO.Commands;

import ru.ITMO.Collection.*;

import java.util.ArrayList;

/**
 *Команда добавления элемента в коллекию
 */
public class AddCommand implements  Command{

    String descriprion = "add {element} : добавить новый элемент в коллекцию\n";
    StudyGroup studyGroup;

    CollectionController collection;

    public AddCommand(CollectionController collection, StudyGroup studyGroup){
        this.collection = collection;
        this.studyGroup = studyGroup;
    }

    /**
     * @param arguments
     * Список полученных агрументов.
     */
    @Override
    public void execute (ArrayList<String> arguments){
        collection.add(studyGroup);
        System.out.println("Объект добавлен в коллекцию! Введите 'show' чтобы увидеть содержимое коллекции.");
    }

}
