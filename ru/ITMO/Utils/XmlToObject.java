package ru.ITMO.Utils;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ru.ITMO.Collection.CollectionClass;
import ru.ITMO.Collection.CollectionController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XmlToObject {

    CollectionController cc;

    public XmlToObject(String filePath, CollectionController cc){
        this.filePath = filePath;
        this.cc = cc;
    }

    Printer printer = new Printer();

    XmlMapper xmlMap = new XmlMapper();

    String filePath;

    CollectionClass collectionClass;

    public void toObj(String xmlString) {
        xmlMap.registerModule(new JavaTimeModule());
        xmlMap.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            collectionClass = xmlMap.readValue(xmlString, CollectionClass.class);
        } catch (Exception e) {
            printer.print("Ошибка при чтении файла!" + e.getMessage());
            return;
        }

        cc.setCollectionClass(collectionClass);
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
            printer.print("Файл \"" + path + "\" для сохранения не найден!");
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
