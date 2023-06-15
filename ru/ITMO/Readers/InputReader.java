package ru.ITMO.Readers;

import ru.ITMO.Utils.Printer;

import java.util.Scanner;

public class InputReader implements ReaderInterface {

    Printer pr = new Printer();

    public InputReader(){
        this.scanner = new Scanner(System.in);
    }

    String string;
    Scanner scanner;

    public Scanner getScanner() {
        return scanner;
    }

    public String read(){
        string = scanner.nextLine().trim();
        return string;
    }

}
