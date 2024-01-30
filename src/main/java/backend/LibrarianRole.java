package backend;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import constants.FileNames;


public class LibrarianRole {
    StudentBookDatabase sBDatabase;
    BookDatabase booksDatabase;

    public LibrarianRole() throws IOException {
        this.booksDatabase=new BookDatabase(FileNames.BOOKS_FILENAME);
        this.sBDatabase=new StudentBookDatabase(FileNames.STUDENTSBOOKS_FILENAME);
        booksDatabase.readFromFile();
        sBDatabase.readFromFile();

    }

    public void addBook(String ID, String title, String authorName, String publisherName, int Quantity){

        Book b=new Book(ID,title,authorName,publisherName,Quantity);
        booksDatabase.insertRecord(b);

    }
    public Book[] getListOfBooks() {
        Book [] arrayusers = new Book[booksDatabase.records.size()];
        return booksDatabase.records.toArray(arrayusers);
    }

    public StudentBook[] getListOfBorrowingOperations() {
        StudentBook [] arrayusers = new StudentBook[sBDatabase.records.size()];
        return sBDatabase.records.toArray(arrayusers);
    }

    public int borrowBook(String studentId, String bookId, LocalDate borrowdate) throws IOException {

        Book b = (Book) booksDatabase.getRecord(bookId);
        if (sBDatabase.contains(studentId+","+bookId))
            return 1;
        if (b.getQuantity()==0)
            return 0;
        b.setQuantity(b.getQuantity()-1);
        StudentBook s= new StudentBook(studentId,bookId,borrowdate);
       sBDatabase.insertRecord(s);
        sBDatabase.saveToFile();
        return 2;
    }

    public double returnBook(String studentId,String bookId,LocalDate returnDate) throws IOException{

        Book b = (Book) booksDatabase.getRecord(bookId);
        b.setQuantity(b.getQuantity()+1);
        StudentBook s = (StudentBook) sBDatabase.getRecord(studentId+","+bookId);
        sBDatabase.deleteRecord(studentId + "," + bookId);
        sBDatabase.saveToFile();
        Period p = Period.between(s.getBorrowDate(),returnDate);
        long days=p.getDays()+p.getMonths()*30;
        if (days > 7)
            return (days - 7) * 0.5;
        else
            return 0;
    }
    public void logout()
    {
        sBDatabase.saveToFile();
        booksDatabase.saveToFile();
    }

}
