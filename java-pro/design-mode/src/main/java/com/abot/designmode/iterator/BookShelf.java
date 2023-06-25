package com.abot.designmode.iterator;

import lombok.ToString;

/**
 * 书架
 * @author weibao
 */
@ToString
public class BookShelf implements Aggregate{
    private final Book[] books;
    private int last;

    public BookShelf(int maxSize){
        this.books = new Book[maxSize];
    }

    public Book getBookAt(int idx){
        return books[idx];
    }

    public void appendBook(Book book) {
        this.books[last++] = book;
    }

    public int getLength(){
        return last;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
