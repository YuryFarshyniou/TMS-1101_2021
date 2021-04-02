package tasks.lesson_18.by.yurachel.library.service;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class Validator {
    // Проверяем на валидность наш XML файл

    public boolean validateXML() {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File("resources\\lesson_18\\Library.xsd"));
            javax.xml.validation.Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File("resources\\lesson_18\\Library.xml")));
        } catch (IOException | SAXException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
}
