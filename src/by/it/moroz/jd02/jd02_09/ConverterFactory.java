package by.it.moroz.jd02.jd02_09;

class ConverterFactory {

    ConverterFactory(){

    }

    Converter getConventer(Direction direction, Class clazz){

        switch (direction){
            case XML_TO_JSON:
                return new ConverterXmlToJson<>(clazz);

            case JSON_TO_XML:
                return new ConverterJsonToXml<>(clazz);
        }
        return null;
    }
}
