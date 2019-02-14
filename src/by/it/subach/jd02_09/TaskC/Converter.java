package by.it.subach.jd02_09.TaskC;

import java.io.*;

public abstract class Converter<Bean> {

    protected Bean bean;
    protected Class beanClass;

    Converter(Bean beanClass) {
        bean = beanClass;
    }

    Bean getBean(){
        return bean;
    }


    public abstract String getText();

    public abstract void load(String fileName);



    public void save(File file){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(File file){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
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
