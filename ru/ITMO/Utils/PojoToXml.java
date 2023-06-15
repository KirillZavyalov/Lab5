package ru.ITMO.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ru.ITMO.Collection.CollectionClass;

import java.io.*;

public class PojoToXml {

    Printer printer = new Printer();

    public PojoToXml(String filepath){
        this.filepath = filepath;
    }

    XmlMapper xmlMapper = new XmlMapper();
    String result;
    String filepath;

    public void serialize(CollectionClass collectionClass){
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JavaTimeModule());
            xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            String xmlString = null;
            try {
                xmlString = xmlMapper.writeValueAsString(collectionClass);
            } catch (JsonProcessingException e) {
                System.out.println(e.getMessage());
            }
            result = xmlString;
            writeToFile(result);
    }

    private void writeToFile(String output){
        OutputStream os = null;
        try {
            os = new FileOutputStream(filepath);
        } catch (FileNotFoundException e) {
            printer.print("Файл не найден.");
        }
        Writer osr = new OutputStreamWriter(os);
        try {
            osr.write(output);
            osr.close();
        } catch (IOException e) {
            printer.print("Ошибка при попытке записи в файл." + e.getMessage());
        }
        printer.print("Готово!");
    }
}
