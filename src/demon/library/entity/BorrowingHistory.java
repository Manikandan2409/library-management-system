package demon.library.entity;

import java.util.Calendar;
import java.util.Date;

public class BorrowingHistory {

    private int historyId;
    private int bookId;
    private int borrowerId;
    private Date borrowedDate;
    private Date returnedDate;
    private Date dueDate;

    @Override
    public String toString() {
        return 
       "| "+ historyId+"\t| "+bookId +"\t| "+borrowerId +"\t\t| "+borrowedDate+"\t| "+returnedDate+"\t| "+dueDate;
    }
    public  static String getColumns(){
        return "| "+ "Id"+"\t| "+"BookId"+"| "+"BorrowerID"+"\t| "+"BorrowedDate"+"\t| "+"ReturnedDate"+"\t| "+"DueDate"+"|";
    }

    public BorrowingHistory(){}
    public BorrowingHistory( int bookId, int borrowerId) {
        this.bookId = bookId;
        this.borrowerId = borrowerId;
        this.borrowedDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 20);
        this.dueDate = cal.getTime();
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(int borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
