package com.solovev.model;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Library {
    private String name;
    private String address;
    private LinkedHashSet<BookShelf> bookShelves = new LinkedHashSet<>();

    public Library() {
    }

    public Library(String name, String address) {
        this.name = name;
        this.address = address;
    }
    /** method adds BookShelf to the Library
     * @return true if BookShelf was successfully added, false otherwise
     */
    public boolean add(BookShelf bookShelf){ return bookShelves.add(bookShelf);}

    /** method searches BookShelf by number
     *
     * @return First BookShelf if it was found empty optional otherwise
     */
    public Optional<BookShelf> search(int num){
        return bookShelves
                .stream()
                .filter(bs -> bs.getNum() == num)
                .findFirst();
    }
    /** method searches BookShelf by Object
     *
     * @return index of a first found bookshelf if it was found -1 otherwise
     */
    public int search(BookShelf bookShelf){
        int index = 0;
        for(BookShelf bs : bookShelves) {
            if(bookShelf.equals(bs)) { return index; }
            index++;
        }
        return -1;
    }

    /** method searches Book in Library by name
     *
     * @return Optional<Book> of the first found book, or Empty optional, if not found
     */
    public Optional<Book> search(String bookName){
        Optional<Optional<Book>> whatWasFound =
                bookShelves
                .stream()
                .map(bs -> bs.search(bookName))
                .filter(Optional::isPresent)
                .findFirst();
        return whatWasFound.orElseGet(Optional::empty);
    }

    /** Method finds Book by the object
     *
     * @return array with indexOfShelf where the first book was found and book index; empty array if nothing was found
     */
    public int[] search(Book book){
        int bookShelfCount = 0;
        for(BookShelf bs : bookShelves) {
            int bookIndex = bs.search(book);
            if(bookIndex != -1) {return new int[]{bookShelfCount,bookIndex};}
            bookShelfCount++;
        }
        return new int[0];
    }

    /** Method to delete BookShelf by object
     *
     * @return true if it was successfully deleted
     */
    public boolean delete(BookShelf bookShelf){
        return bookShelves.remove(bookShelf);
    }
    /** Method to delete BookShelf by index
     *
     * @return deleted Bookshelf
     */
    public BookShelf delete(int index){
        AtomicInteger counter = new AtomicInteger();
        Predicate<BookShelf> filterFromIndex = bs -> counter.incrementAndGet() != index;
        BookShelf deleted = (BookShelf) bookShelves.toArray()[index];
        bookShelves =
                bookShelves
                .stream()
                .filter(filterFromIndex)
                .collect(Collectors.toCollection(LinkedHashSet<BookShelf>::new));
        return deleted;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Library library = (Library) o;

        if (!name.equals(library.name)) return false;
        if (!address.equals(library.address)) return false;
        return bookShelves.equals(library.bookShelves);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + bookShelves.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", bookShelves=" + bookShelves +
                '}';
    }
}
