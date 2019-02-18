package by.it.subach.jd02_09.TaskC;

class ConvertFactory {

    private ConvertFactory() {
    }

    static ConvertFactory getConvertFactory(){
        return new ConvertFactory();
    }

    Converter getConverter(Direction direction, Class beanClass) {
        switch (direction) {
            case JSON_TO_XML:
                return new ConvertJsonToXml(beanClass);

            case XML_TO_JSON:
                return new ConvertXmlToJson(beanClass);

            default:
                return null;
        }

    }
}
