package ru.ITMO.Commands;

import ru.ITMO.Collection.CollectionController;
import ru.ITMO.Readers.FromFileReader;
import ru.ITMO.Utils.InputAnalyzer;
import ru.ITMO.Utils.Printer;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Команда вызывает выполнение скрипта из файла
 */
public class ExecuteScript implements Command {

    InputAnalyzer ia;
    Printer printer = new Printer();
    HashSet set;
    private CollectionController cc;
    public ExecuteScript(InputAnalyzer ia, CollectionController cc, HashSet set) {
        this.ia = ia;
        this.cc = cc;
        this.set = set;
    }

    /**
     * @param arguments Список полученных агрументов.
     */
    @Override
    public void execute(ArrayList<String> arguments) {

        String fileName = arguments.get(0);
        try {

            FromFileReader fReader = new FromFileReader(fileName);
            InputAnalyzer fAnalyzer = new InputAnalyzer(fReader, cc, set);
            printer.print("Выполнение скрипта \""+fileName+"\"");
            while (fReader.getScanner().hasNext()) {
                fAnalyzer.analyze(fReader.read());
            }

            set.clear();

        } catch (IOException e) {
            printer.print("Файл не найден!");
        }
    }
}
