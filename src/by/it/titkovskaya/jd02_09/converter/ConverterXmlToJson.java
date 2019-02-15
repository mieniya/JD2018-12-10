package by.it.titkovskaya.jd02_09.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;

class ConverterXmlToJson<Bean> extends Converter<Bean> {

    ConverterXmlToJson(Class<Bean> beanClass) {
        super(beanClass);
    }

    @Override
    String getText() {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        return gson.toJson(getBean());
    }

    @Override
    void load(String json) {
        System.out.println("\n=================== JSON from XML ===================");
        System.out.println(json);
        File jsonFile = new File((new Path()).getPath(Converter.class, "json.json"));
        save(jsonFile, json);

    }
}
