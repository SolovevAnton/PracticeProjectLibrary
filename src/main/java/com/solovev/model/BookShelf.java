package com.solovev.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BookShelf {
    private int num;
    private final List<Book> books = new ArrayList<>();

    public BookShelf() {
    }

    public BookShelf(int num) {
        this.num = num;
    }

    /** method adds books to the BookShelf
     * @return true if a book was successfully added, false otherwise
     */
    public boolean add(Book book){
        return books.add(book);
    }

    /** methods tries to find object of a book
     *
     * @return index of a Book in a Bookshelf, or -1 if it wasn't found
     */
    public int search(Book book) {return books.indexOf(book);}
    /** method that Book in a Bookshelf by name
     * @return Optional<Book> , or empty Optional if nothing was found
     */
    public Optional<Book> search(String bookName){
        return books
                .stream()
                .filter(b -> b.getName().equals(bookName))
                .findFirst();
    }

    /** method that finds all books written by author
     *
     * @return array of books written by that author, or empty array if nothing was found
     */
    public Book[] getBooksAuthor (String author){
        return (Book[]) books
                .stream()
                .filter(b -> b.getAuthor().equals(author))
                .toArray();
    }

    /** Method that deletes first find Book by object
     *
     * @return True if book was successfully deleted false otherwise
     */
    public boolean delete(Book book){
        return books.remove(book);
    }
    /** Method that deletes Book by index
     *
     * @return deletedBook
     */
    public Book delete(int index){
        return books.remove(index);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookShelf bookShelf = (BookShelf) o;

        if (num != bookShelf.num) return false;
        return Objects.equals(books, bookShelf.books);
    }

    @Override
    public int hashCode() {
        int result = num;
        result = 31 * result + (books != null ? books.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookShelf{" +
                "num=" + num +
                ", books=" + books +
                '}';
    }
}
