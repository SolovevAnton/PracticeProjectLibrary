package com.solovev;

import com.solovev.model.Book;
import com.solovev.model.BookShelf;
import com.solovev.model.Library;
import com.solovev.util.Generator;
import com.solovev.util.Lists;

public class Main {
    public static void main(String[] args) {
        int maxShelvs = 5;
        int maxBooks = 3;
        Library lb = Generator.generateLibrary(maxShelvs,maxBooks);
        System.out.println(lb);

        //add stuff to searchFor
        Book b= new Book("False blindness","P. Watts",2006);
        BookShelf bs = Generator.generateShelf(maxBooks);
        //tests
        System.out.println("4.exp:true: " + bs.add(b));
        System.out.println("4.exp:true: " + lb.add(bs) + " exp:false:" + lb.add(bs));
        System.out.println("5.exp:2: " + bs.search(b));
        System.out.println("5.exp:-1 " + bs.search(new Book()));
        System.out.println("5.exp:Optional<Book>: " + bs.search(b.getName()));
        System.out.println("5.exp:Optional.empty " + bs.search("NotABook"));
        System.out.println("6.exp:notEmpty Book[]: " + bs.getBooksAuthor(Lists.AUTHOR[0]));
        System.out.println("6.exp: empty Book[]: " + bs.getBooksAuthor("author"));
        System.out.println("7.exp: Optional<BookShelf>" + lb.search(0));
        System.out.println("7.exp: Optional.empty: " + lb.search(maxShelvs + 1));
        System.out.println("7.exp: int:" + lb.search(bs));
        System.out.println("7.exp: -1:" + lb.search(new BookShelf()));
        System.out.println("8.exp: Optional<Book>:" + lb.search(b.getName()));
        System.out.println("8.exp: Optional.empty:" + lb.search("Crime and Punishment"));
        System.out.println("8.exp: int[x][y]" + lb.search(b));
        System.out.println("8.exp: empty int[][]" + lb.search(new Book()));
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