package ru.ITMO.Readers;

import ru.ITMO.Utils.Printer;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FromFileReader implements ReaderInterface{

    Printer pr = new Printer();

    String fileName;
    Path path;
    Scanner scanner;

    public FromFileReader(String fileName) throws IOException {

        try {
            this.fileName = fileName;
            this.path = Paths.get(fileName);
            this.scanner = new Scanner(path);
            scanner.useDelimiter(System.getProperty("line.separator"));
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public Scanner getScanner() {
        return scanner;
    }

    public String read(){
        if (scanner.hasNext()){
            String line = scanner.next();
            return line;
        } else {
            return "";
        }

    }
}
