package ru.ITMO.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ru.ITMO.Collection.CollectionController;
import ru.ITMO.Collection.StudyGroup;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class XmlToObject {

    CollectionController cc;

    public XmlToObject(){

    }

    public XmlToObject(String filePath, CollectionController cc){
        this.filePath = filePath;
        this.cc = cc;
    }

    Printer printer = new Printer();

    XmlMapper xmlMap = new XmlMapper();

    String filePath;

    StudyGroup studyGroup;

    public void toObj(String xmlString) {
        xmlMap.registerModule(new JavaTimeModule());
        xmlMap.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            studyGroup = xmlMap.readValue(xmlString, StudyGroup.class);
        } catch (Exception e) {
            printer.print("Ошибка при чтении файла!");
            return;
        }

        cc.add(studyGroup);
        printer.print("Готово!");
    }

    public void readXml(){
        InputStream is = null;
        String returning ="";
        File path = new File(filePath);
        BufferedInputStream bis = null;
        FileInputStream  fis= null;

        try
        {
            fis = new FileInputStream(path);

            bis = new BufferedInputStream(fis);


            while( bis.available() > 0 ){
                returning += ((char)bis.read());
            }

        }catch(FileNotFoundException fnfe)
        {
            printer.print("Файл не найден!");
            return;
        }
        catch(IOException ioe)
        {
            printer.print("I/O Exception" + ioe);
        }
        finally
        {
            try{
                if(bis != null && fis!=null)
                {
                    fis.close();
                    bis.close();
                }
            }catch(IOException ioe)
            {
                printer.print("Error in InputStream close(): " + ioe);
            }
        }
        splitAndMakePOJO(returning);
    }

    public void splitAndMakePOJO(String string){
        ArrayList<String> array = new ArrayList(List.of(string.split("<DIVIDER>")));
        for (String str : array){;
            toObj(str);
        }
    }


}
