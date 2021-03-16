package tasks.lesson_16.by.yurachel.main;

import org.xml.sax.SAXException;
import tasks.lesson_16.by.yurachel.service.Valid;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, SAXException {
//        System.out.println(Valid.validateXML());

//        Valid.StAXParse();
        Valid.SAXParser();
//        Valid.DOMParser();
    }
}
