package backend;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentBook implements Record{
    private String studentId;
    private String bookId;
    private LocalDate borrowDate;


    public StudentBook(String studentId, String bookId, LocalDate borrowDate) {
        this.studentId=studentId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }
    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    @Override
    public String lineRepresentation(){
      String represent = studentId+","+bookId+","+borrowDate;
        return represent;
    }
    @Override
    public String getSearchKey(){
        return String.join(",",studentId,bookId);
    }


}
