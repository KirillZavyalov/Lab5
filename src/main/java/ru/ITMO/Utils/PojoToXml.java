package ru.ITMO.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ru.ITMO.Collection.CollectionController;
import ru.ITMO.Collection.StudyGroup;

import java.io.*;

public class PojoToXml {

    Printer printer = new Printer();

    public PojoToXml(String filepath){
        this.filepath = filepath;
    }

    XmlMapper xmlMapper = new XmlMapper();
    String result;
    String filepath;

    public void serialize(CollectionController cc){
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        for (StudyGroup sg : cc.getSgcollection()) {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JavaTimeModule());
            xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            String xmlString = null;
            try {
                xmlString = xmlMapper.writeValueAsString(sg);
            } catch (JsonProcessingException e) {
                System.out.println(e.getMessage());
            }
            result+=xmlString;
        }
        writeToFile(result.replaceAll("null","").replaceAll("</StudyGroup>", "</StudyGroup><DIVIDER>"));
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
            printer.print("Ошибка при попытке записи в файл.");
        }
        printer.print("Готово!");
    }
}
