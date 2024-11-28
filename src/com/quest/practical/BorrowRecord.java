package com.quest.practical;

import java.time.LocalDateTime;

public class BorrowRecord
{
    private Book book;
    private LocalDateTime borrowedAt;
    private LocalDateTime returnedAt;
    private Student borrowedBy;

    public BorrowRecord(Book book, LocalDateTime borrowedAt, LocalDateTime returnedAt, Student borrowedBy) {
        this.book = book;
        this.borrowedAt = borrowedAt;
        this.returnedAt = returnedAt;
        this.borrowedBy = borrowedBy;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getBorrowedAt() {
        return borrowedAt;
    }

    public void setBorrowedAt(LocalDateTime borrowedAt) {
        this.borrowedAt = borrowedAt;
    }

    public LocalDateTime getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(LocalDateTime returnedAt) {
        this.returnedAt = returnedAt;
    }

    public Student getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(Student borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    @Override
    public String toString() {
        return "BorrowRecord{" +
                "book=" + book +
                ", borrowedAt=" + borrowedAt +
                ", returnedAt=" + returnedAt +
                ", borrowedBy='" + borrowedBy + '\'' +
                '}';
    }
}