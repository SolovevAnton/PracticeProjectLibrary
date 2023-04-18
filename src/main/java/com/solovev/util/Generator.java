package com.solovev.util;

import com.solovev.model.Book;
import com.solovev.model.BookShelf;
import com.solovev.model.Library;

import java.util.Random;

/** Class for random generation of books and bookshelves
 *
 */
public class Generator {
    /**generates number from a inclusively tob exclusively
      * @return generated number
     */
    private static int generateNum(int a, int b){
        Random rand = new Random();
        return rand.nextInt(a,b);
    }
    /** method to generate number from 0 to given number
    */
    private static int generateNum(int b){
        int startingNumber = 0;
        return generateNum(startingNumber,b);
    }

    /** generates Book with random author year and name, taken from Lists.class
     * @return generated Book
     */
    public static Book generateBook(){
        return new Book(
                Lists.NAME[generateNum(Lists.NAME.length - 1)],
                Lists.AUTHOR[generateNum(Lists.AUTHOR.length - 1)],
                Lists.YEAR[generateNum(Lists.YEAR.length - 1)]
        );
    }
    /** method generates BookShelf with random books and random number of them, and random number
     * @param maxBooks that can be generated for that shelf, exclusively
     * @return generated bookShelf
     */
    public static BookShelf generateShelf(int maxBooks){
        BookShelf bs = new BookShelf(generateNum(Integer.MAX_VALUE));
        for(int i =0; i < maxBooks; i++){
            bs.add(generateBook());
        }
        return bs;
    }

    /** Method generates random Library with random books. Library will have Name Random# + randomValue, and address: "randomValue.lib"
     * @param maxShelves - max Shelves generated for this library
     * @param maxBooks - max Books on each shelf
     * @return generated library
     */
    public static Library generateLibrary(int maxShelves,int maxBooks){
        int libNumber = generateNum(Integer.MAX_VALUE);
        Library lb = new Library("Random#"+libNumber,libNumber + ".lib");
        for(int i =0; i < maxShelves; i++){
            lb.add(generateShelf(maxBooks));
        }
        return lb;
    }
}
