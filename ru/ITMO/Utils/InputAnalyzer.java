package ru.ITMO.Utils;

import ru.ITMO.Collection.CollectionController;
import ru.ITMO.Collection.ObjectConstructor;
import ru.ITMO.Commands.*;
import ru.ITMO.Readers.FromFileReader;
import ru.ITMO.Readers.InputReader;
import ru.ITMO.Readers.ReaderInterface;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class InputAnalyzer {

    ReaderInterface reader;
    ArrayDeque adq = new ArrayDeque<String>(13);
    Printer printer;
    CollectionController cc;
    String[] sargs;
    String input;

    HashSet<String> scriptSet;

    public InputAnalyzer(InputReader reader, CollectionController cc) {

        this.reader = reader;
        this.printer = new Printer();
        this.cc = cc;
        this.scriptSet = new HashSet();
    }

    public InputAnalyzer(FromFileReader reader, CollectionController cc, HashSet set){

        this.reader = reader;
        this.printer = new Printer();
        this.cc = cc;
        this.scriptSet = set;
    }

    public ReaderInterface getReader() {
        return reader;
    }

    public boolean analyze(String string) {
        input = string;
        sargs = string.split(" ");
        adq.addLast(input);
        if (adq.size() > 13) {
            adq.removeFirst();
        }
        ArrayList<String> tokens = new ArrayList<>(Arrays.asList(sargs));

        switch (tokens.get(0)) {
            case ("add") -> {
                tokens.remove(0);
                if (tokens.size() != 0) {
                    printer.print("Неверный формат команды!" + tokens);
                } else {
                    AddCommand addCommand = new AddCommand(cc, new ObjectConstructor(reader, cc).createStudyGroup(), reader instanceof FromFileReader);
                    addCommand.execute(tokens);
                }
            }
            case ("execute_script") -> {

                tokens.remove(0);
                if (tokens.size() != 1) {
                    printer.print("Неверный формат команды!" + tokens);
                } else if (scriptSet.add(tokens.get(0))== false) {
                    printer.print("Рекурсивный скрипт! Чтение скрипта прекращено.");
                } else {
                    scriptSet.add(tokens.get(0));
                    ExecuteScript exScript = new ExecuteScript(this, cc, scriptSet);
                    exScript.execute(tokens);
                }
            }

            case ("help") -> {
                tokens.remove(0);
                if (tokens.size() != 0) {
                    printer.print("Неверный формат команды! " + tokens);
                } else {
                    HelpCommand helpCommand = new HelpCommand();
                    helpCommand.execute(tokens);
                }
            }

            case ("info") -> {
                tokens.remove(0);
                if (tokens.size() != 0) {
                    printer.print("Неверный формат команды! " + tokens);
                } else {
                    InfoCommand ic = new InfoCommand(cc);
                    ic.execute(tokens);
                }
            }

            case ("show") -> {
                tokens.remove(0);
                if (tokens.size() != 0) {
                    printer.print("Неверный формат команды! " + tokens);
                } else {
                    ShowCommand sc = new ShowCommand(cc);
                    sc.execute(tokens);
                }
            }

            case ("update") -> {
                tokens.remove(0);
                if (tokens.size() != 1) {
                    printer.print("Неверный формат команды: " + tokens);
                } else {
                    UpdateCommand updateCommand = new UpdateCommand(cc, this, reader instanceof FromFileReader);
                    try {
                        updateCommand.execute(tokens);
                    } catch (IndexOutOfBoundsException e) {
                        printer.print("Такой индекс не обнаружен.");
                    }
                }
            }
            case ("remove_by_id") -> {

                tokens.remove(0);
                RemoveByIdCommand remove = new RemoveByIdCommand(cc);
                remove.execute(tokens);
            }
            case ("history") -> {

                tokens.remove(0);
                HistoryClass history = new HistoryClass(adq);
                history.execute(tokens);
            }
            case ("clear") -> {

                tokens.remove(0);
                ClearCommand clearCommand = new ClearCommand(cc, reader);
                clearCommand.execute(tokens);
            }
            case ("exit") -> {
                printer.print("Программа остановлена.");
                return true;
            }
            case ("add_if_max") -> {
                tokens.remove(0);
                if (tokens.size() != 0) {
                    printer.print("Неверный формат команды!");
                } else {
                    AddIfMaxCommand addIfMaxCommand = new AddIfMaxCommand(reader, cc);
                    addIfMaxCommand.execute(tokens);
                }
            }
            case ("add_if_min") -> {
                tokens.remove(0);
                if (tokens.size() != 0) {
                    printer.print("Неверный формат команды!");
                } else {
                    AddIfMinCommand addIfMinCommand = new AddIfMinCommand(reader, cc);
                    addIfMinCommand.execute(tokens);
                }
            }
            case ("remove_all_by_students_count") -> {
                tokens.remove(0);
                if (tokens.size() == 1) {
                    RemoveAllByStudentsCount rabsc = new RemoveAllByStudentsCount(cc);
                    rabsc.execute(tokens);
                }
            }
            case ("count_less_than_group_admin") -> {
                tokens.remove(0);
                if (tokens.size() == 0) {
                    CountLessThanAdmin clta = new CountLessThanAdmin(reader, cc);
                    clta.execute(tokens);
                }
            }
            case ("print_field_descending_form_of_education") -> {
                tokens.remove(0);
                if (tokens.size() != 0) {
                    printer.print("Неверный формат команды!");
                } else {
                    PrintDescendingFOECommand printDescendingFOECommand = new PrintDescendingFOECommand(cc);
                    printDescendingFOECommand.execute(tokens);
                }
            }
            case ("save") -> {
                tokens.remove(0);
                if (tokens.size() != 0) {
                    printer.print("Неверный формат команды!\nПомните, что для сохранения и загрузки коллекции используется переменная окружения!");
                } else {
                    SaveCommand saveCommand = new SaveCommand(cc.getCollectionClass());
                    saveCommand.execute(tokens);
                }
            }
            case ("load") -> {
                tokens.remove(0);
                if (tokens.size() != 0) {
                    printer.print("Неверный формат команды!");
                } else {
                    LoadXmlCommand loadXmlCommand = new LoadXmlCommand(cc);
                    loadXmlCommand.execute(tokens);
                }

            }
        }
        return false;
    }
}
