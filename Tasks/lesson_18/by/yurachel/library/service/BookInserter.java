package tasks.lesson_18.by.yurachel.library.service;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import tasks.lesson_18.by.yurachel.library.entity.Book;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class BookInserter {

    // При завершении работы с книгами записываем их обратно в XML файл.

    public void addBooksToXML(Document document, List<Book> library) {

        Node root2 = document.getDocumentElement();
        while (root2.hasChildNodes()) {
            Node r = root2.getFirstChild();
            root2.removeChild(r);
        }


        int count = 1;
        for (Book book1 : library) {
            Element book = document.createElement("Book");
            book.setAttribute("Id", "Id-" + count);

            Element name = document.createElement("bookName");
            name.setTextContent(book1.getBookName());


            Element author = document.createElement("Author");

            for (int i = 0; i < book1.getAuthors().size(); i++) {
                Element bookAuthor = document.createElement("AuthorName");
                bookAuthor.setTextContent(book1.getAuthors().get(i).toString());

                author.appendChild(bookAuthor);
            }


            Element genre = document.createElement("Genre");

            for (int i = 0; i < book1.getGenre().size(); i++) {
                Element bookGenre = document.createElement("BookGenre");
                bookGenre.setTextContent(book1.getGenre().get(i));
                genre.appendChild(bookGenre);
            }


            Element price = document.createElement("Price");
            price.setTextContent(Integer.toString(book1.getPrice()));

            Element numberOfPages = document.createElement("numberOfPages");
            numberOfPages.setTextContent(Integer.toString(book1.getNumberOfPages()));

            // Добавляем внутренние элементы книги в элемент <Book>

            book.appendChild(name);
            book.appendChild(author);
            book.appendChild(genre);
            book.appendChild(price);
            book.appendChild(numberOfPages);

            // Заменяем элементы при записи.

            Node root = document.getDocumentElement();
            root.appendChild(book);
            count++;
        }
        writeDocument(document);
    }


    private void writeDocument(Document document) throws TransformerFactoryConfigurationError {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer tr = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream("resources\\lesson_18\\Library.xml");
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
