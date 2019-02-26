package by.it.moroz.jd02.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.*;

abstract class Converter<Bean> {

    protected Bean bean;
    Class beanClass;
    Gson gson;
    JAXBContext context;

    Converter(Class<Bean> beanClass){
        this.bean= (Bean) beanClass;
        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().setPrettyPrinting().create();
        try {
            context = JAXBContext.newInstance((Class) beanClass);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    void save(File file){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    abstract String getText();

    abstract void load(String text);

    void load(File file){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            while (reader.ready()){
                sb.append(reader.readLine());
            }
            load(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
