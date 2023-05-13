package ru.ITMO;

import ru.ITMO.Collection.CollectionController;
import ru.ITMO.Readers.InputReader;
import ru.ITMO.Utils.InputAnalyzer;
import ru.ITMO.Utils.Printer;

public class Main {
    public static void main(String[] args) {

        {
            System.setProperty("savepath","amogus");
            System.out.println(System.getProperty("savepath"));
        }
        Printer printer = new Printer();

        InputReader cReader = new InputReader();
        InputAnalyzer cAnalyzer = new InputAnalyzer(cReader, new CollectionController());

        printer.print("Started!");

        Boolean finish = false;
        while (!finish) {
            try {
                cAnalyzer.analyze(cReader.read());
            } catch (Exception e){
                System.out.println("");
            }
        }

    }
}