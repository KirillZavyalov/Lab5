package ru.ITMO;

import ru.ITMO.Collection.CollectionController;
import ru.ITMO.Commands.Command;
import ru.ITMO.Commands.LoadXmlCommand;
import ru.ITMO.Readers.InputReader;
import ru.ITMO.Utils.InputAnalyzer;
import ru.ITMO.Utils.Printer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        {
            System.out.println("lab5=" + System.getenv("lab5"));
        }

        Printer printer = new Printer();

        InputReader cReader = new InputReader();

        CollectionController collectionController = new CollectionController();

        InputAnalyzer cAnalyzer = new InputAnalyzer(cReader, collectionController);

        Command load = new LoadXmlCommand(collectionController);

        load.execute(null);

        printer.print("Started!");

        while (cReader.getScanner().hasNextLine()) {
            try {
                cAnalyzer.analyze(cReader.read());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


}