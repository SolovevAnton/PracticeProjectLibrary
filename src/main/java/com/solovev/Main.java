package com.solovev;

import com.solovev.model.Book;
import com.solovev.model.BookShelf;
import com.solovev.model.Library;
import com.solovev.util.Generator;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int maxShelvs = 5;
        int maxBooks = 3;
        Library lb = Generator.generateLibrary(maxShelvs,maxBooks);
        System.out.println(lb);

        //add stuff to searchFor
        Book b= new Book("Blindsight","P. Watts",2006);
        Book b1= new Book("Echopraxia","P. Watts",2014);
        BookShelf bs = Generator.generateShelf(maxBooks);
        System.out.println(bs);
        //tests
        bs.add(b1);
        System.out.println("4.exp:true: " + bs.add(b));
        System.out.println("4.exp:true: " + lb.add(bs) + " exp:false:" + lb.add(bs));
        System.out.println("5.exp:int: " + bs.search(b));
        System.out.println("5.exp:-1 " + bs.search(new Book()));
        System.out.println("5.exp:Optional<Book>: " + bs.search(b.getName()));
        System.out.println("5.exp:Optional.empty " + bs.search("NotABook"));
        System.out.println("6.exp: Book[2]: " + Arrays.toString(bs.getBooksAuthor(b.getAuthor())));
        System.out.println("6.exp: empty Book[]: " + Arrays.toString(bs.getBooksAuthor("author")));
        System.out.println("7.exp: Optional<BookShelf>: " + lb.search(bs.getNum()));
        System.out.println("7.exp: Optional.empty: " + lb.search(maxShelvs + 1));
        System.out.println("7.exp: int:" + lb.search(bs));
        System.out.println("7.exp: -1:" + lb.search(new BookShelf()));
        System.out.println("8.exp: Optional<Book>:" + lb.search(b.getName()));
        System.out.println("8.exp: Optional.empty:" + lb.search("Crime and Punishment"));
        System.out.println("8.exp: int[2]" + Arrays.toString(lb.search(b)));
        System.out.println("8.exp: empty int[]: " + Arrays.toString(lb.search(new Book())));
        System.out.println("9.exp: Book: " + bs.delete(0));
        System.out.println("9.exp: true: " + bs.delete(b));
        System.out.println("9.exp: false: " + bs.delete(b));
        System.out.println("9.exp: BookShelf: " + lb.delete(0));
        System.out.println("9.exp: true: " + lb.delete(bs));
        System.out.println("9.exp: false: " + lb.delete(bs));
        System.out.println();
        System.out.println(bs);
        System.out.println(lb);
    }
}