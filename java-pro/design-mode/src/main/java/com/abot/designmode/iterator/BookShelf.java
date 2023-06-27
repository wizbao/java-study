package com.abot.designmode.iterator;

import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

/**
 * 书架
 * @author weibao
 */
@ToString
public class BookShelf implements Aggregate{
    private final List<Book> books;
    private int last;

    public BookShelf(int maxSize){
        books = new ArrayList<>(maxSize);
    }

    public Book getBookAt(int idx){
        return books.get(idx);
    }

    public void appendBook(Book book) {
        books.add(book);
    }

    public int getLength(){
        return books.size();
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
