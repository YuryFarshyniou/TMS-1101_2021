package tasks.lesson_18.by.yurachel.library.main;

import org.xml.sax.SAXException;
import tasks.lesson_18.by.yurachel.library.entity.Library;
import tasks.lesson_18.by.yurachel.library.service.BookInserter;
import tasks.lesson_18.by.yurachel.library.service.DOMParser;
import tasks.lesson_18.by.yurachel.library.service.Utils;
import tasks.lesson_18.by.yurachel.library.service.Validator;
import tasks.lesson_18.by.yurachel.library.view.View;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        Library l = new Library();
        BookInserter bi = new BookInserter();
        DOMParser d = new DOMParser();
        Utils utils = new Utils();
        l.setLibrary(d.writeBooksFromXML(l));
        Validator validator = new Validator();
        System.out.println(validator.validateXML());
        View view = new View(utils,l);
        view.applicationMenu();


    }
}

