package tasks.lesson_17.by.yurachel.task_1.entity;

import tasks.lesson_17.by.yurachel.task_1.entity.books.Book;

import java.util.List;


public class Client {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client(String name) {
        this.name = name;
    }

    public void takeBookForReading(List<Book> books) {
        try {
            StringBuffer stringBuffer = new StringBuffer("");
            if (books.size() != 0) {

                for (int i = 0; i < books.size(); i++) {
                    if (books.size() > 1 && i != books.size() - 1) {
                        stringBuffer.append(books.get(i).getBookName()).append(",");
                    } else {
                        stringBuffer.append(books.get(i).getBookName());
                    }
                }

                System.out.println(name + " of the " + Thread.currentThread().getName() + " is taking books " + stringBuffer + " for reading.");
                Thread.sleep(5000);
                System.out.println(name + " of the " + Thread.currentThread().getName() + " is returning books " + stringBuffer + " to the library.");
            } else {
                System.out.println(name + " of the " + Thread.currentThread().getName() + " took nothing,and with sadness in his eyes went to home.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
