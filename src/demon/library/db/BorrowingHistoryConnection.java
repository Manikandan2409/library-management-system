package demon.library.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import demon.library.db.config.DBConfig;
import demon.library.entity.BorrowingHistory;

public class BorrowingHistoryConnection {
    private  Connection con = null;
    public BorrowingHistoryConnection(){
        try {
            con = DBConfig.getConnection();
        } catch (Exception e) {
                System.out.println("Error: Failed to connect while Borrowing History");
        }
    }

    // add 
    public void save(BorrowingHistory entity){
        String q="INSERT INTO borrowinghistory (BookID,BorrowerID,BorrowedDate,DueDate) VALUES (?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(q) ) {
            ps.setInt(1, entity.getBookId());
            ps.setInt(2, entity.getBorrowerId());
            ps.setDate(3, new java.sql.Date(entity.getBorrowedDate().getTime()));
            ps.setDate(4, new java.sql.Date(entity.getDueDate().getTime()));
            int status = ps.executeUpdate();
            if (status >0) {
                System.out.println("-- "+status+" record updated --");
            }else{
                System.out.println("No records inserted");
            }
        } catch (Exception e) {
            System.out.println("Error: error occcured while save ");
        }
    }

    // return book
    public void updateById(int bookId, int borrowerId) {
        String selectQuery = "SELECT * FROM borrowinghistory WHERE BookID = ? AND BorrowerID = ?";
        String updateQuery = "UPDATE borrowinghistory SET ReturnedDate = ? WHERE BookID = ? AND BorrowerID = ?";
    
        try (PreparedStatement selectPs = con.prepareStatement(selectQuery)) {
            selectPs.setInt(1, bookId);
            selectPs.setInt(2, borrowerId);
    
            ResultSet rs = selectPs.executeQuery();
            
            if (!rs.next()) {
                System.out.println("--- No record found ---");
                return;
            }
    
            try (PreparedStatement updatePs = con.prepareStatement(updateQuery)) {
                updatePs.setDate(1, new java.sql.Date(System.currentTimeMillis()));
                updatePs.setInt(2, bookId);
                updatePs.setInt(3, borrowerId);
    
                int status = updatePs.executeUpdate();
                System.out.println("--- " + status + " record(s) updated ---");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed: Error while updating");
        }
    }
    
    //view all
    public List<BorrowingHistory> findAll(){
        String q = "SELECT * FROM borrowinghistory";
        List<BorrowingHistory> lists = new LinkedList<>();

        try (PreparedStatement ps = con.prepareStatement(q)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BorrowingHistory bh = new BorrowingHistory();
                bh.setHistoryId(rs.getInt("HistoryID"));
                bh.setBookId(rs.getInt("BookID"));
                bh.setBorrowerId(rs.getInt("BorrowerID"));
                bh.setBorrowedDate(rs.getDate("BorrowedDate"));
                bh.setReturnedDate(rs.getDate("ReturnedDate"));
                bh.setDueDate(rs.getDate("DueDate"));
                lists.add(bh);
            }
           
        } catch (Exception e) {
            System.out.println("--- Failed : Error while selecting Borrowing History ---");
        }
        return lists;
    }

}
