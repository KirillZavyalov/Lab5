package ru.ITMO.Commands;

import ru.ITMO.Collection.CollectionController;
import ru.ITMO.Readers.FromFileReader;
import ru.ITMO.Utils.InputAnalyzer;
import ru.ITMO.Utils.Printer;

import java.io.IOException;
import java.util.ArrayList;
/**
 *Команда вызывает выполнение скрипта из файла
 */
public class ExecuteScript implements Command{

    private CollectionController cc;

    public ExecuteScript(InputAnalyzer ia, CollectionController cc){
        this.ia = ia;
        this.cc = cc;
    }

    String description = "execute_script file_name : считать и исполнить скрипт из указанного файла. " +
            "В скрипте содержатся команды в таком же виде, " +
            "в котором их вводит пользователь в интерактивном режиме.\n";

    InputAnalyzer ia;

    Printer printer = new Printer();

    /**
     * @param arguments
     * Список полученных агрументов.
     */
    @Override
    public void execute(ArrayList<String> arguments) {

        String fileName = arguments.get(0);
            try {


                FromFileReader fReader = new FromFileReader(fileName);
                InputAnalyzer fAnalyzer = new InputAnalyzer(fReader, cc);


                while (fReader.getScanner().hasNext()) {
                    fAnalyzer.analyze(fReader.read());
                }
            } catch (IOException e){
                printer.print("Файл не найден!");
            }


//execute_script C:\Users\1\Desktop\script.txt
    }



}
