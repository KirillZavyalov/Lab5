package ru.ITMO.Commands;

import ru.ITMO.Collection.CollectionController;
import ru.ITMO.Collection.ObjectConstructor;
import ru.ITMO.Collection.StudyGroup;
import ru.ITMO.Readers.ReaderInterface;
import ru.ITMO.Utils.Printer;

import java.util.ArrayList;
/**
 *Команда добавления элемента если его studentscount превышает значние остальных элементов
 */
public class AddIfMaxCommand implements Command{

    CollectionController cc;
    ReaderInterface reader;
    Printer printer = new Printer();

    public AddIfMaxCommand(ReaderInterface reader, CollectionController cc){
        this.cc = cc;
        this.reader = reader;
    }

    /**
     * @param arguments
     * Список полученных агрументов.
     */
    @Override
    public void execute(ArrayList<String> arguments) {
        StudyGroup newMember = new ObjectConstructor(reader, cc).createStudyGroup();
        if (cc.getSize() != 0) {
            if (cc.getMax().getStudentsCount() < newMember.getStudentsCount()) {
                cc.add(newMember);
                printer.print("Объект добавлен в коллекцию. Готово!");
            } else {
                printer.print("Объект не добавлен в коллекцию.");
            }
        } else {printer.print("Коллекция пуста!");}


    }
}
