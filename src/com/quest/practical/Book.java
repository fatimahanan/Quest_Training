package com.quest.practical;

public class Book implements Cloneable
{
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String bookId, String title, String author, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean isBookValid() //to check if data from database is not null
    {
        if(this.getBookId() != null && this.getTitle() != null && this.getAuthor() != null && this.isAvailable())
            return true;
        else
            return false;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
//        Object object=super.clone();
//        Book clonedBook=(Book)object;
        Book clonedBook=(Book)super.clone(); //shallow copy - referencing from same memory
//        String originalAuthor=this.getAuthor();
//        String clonedAuthor=new String(originalAuthor);
//        clonedBook.setAuthor(clonedAuthor);
        //deep copy
        clonedBook.setBookId(new String(this.getBookId()));
        clonedBook.setTitle(new String(this.getTitle()));
        clonedBook.setAuthor(new String(this.getAuthor()));
        clonedBook.setAvailable(this.isAvailable);
        return clonedBook;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}