package demon.library.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


import demon.library.db.config.DBConfig;
import demon.library.entity.Borrower;

public class BorrowerConnection {

    private Connection con= null;

    public BorrowerConnection(){
        try {
            con = DBConfig.getConnection();
            System.out.println("Connection Established");
        } catch (SQLException e) {
           System.out.println("Conection failed: Borrower Connection");
        }
    }
    // create Borrower 
    public void save(Borrower borrower){
        String q = "INSERT INTO borrowers (Name,Email,Phone,Address) VALUES (?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(q,PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, borrower.getName());
            ps.setString(2, borrower.getEmail());
            ps.setString(3, borrower.getPhone());
            ps.setString(4, borrower.getAddress());

            int status =ps.executeUpdate();
            if (status >0) {
                System.out.println(status+" borrower added");
            }else System.out.println(status +" rows updated");
        } catch (Exception e) {
            System.out.println("*** Error: while save Borrower ***");
        }
    }

    // View Borrowers
    public List<Borrower> findAll(){
        String q = "SELECT * FROM borrowers";
        List<Borrower> borrowers = new LinkedList<>();
        try (PreparedStatement ps = con.prepareStatement(q)) {
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
                Borrower borrower = new Borrower();
                borrower.setBorrowerId(rs.getInt("BorrowerID"));
                borrower.setName(rs.getString("Name"));
                borrower.setEmail(rs.getString("Email"));
                borrower.setPhone(rs.getString("Phone"));
                borrower.setAddress(rs.getString("Address"));
                borrowers.add(borrower);
            }
        } catch (Exception e) {
            System.out.println("*** Error : Failed while select Borrowers");
        }
        return borrowers;
    }

    //delete by id
    public void deleteById(int id){
        String q="DELETE FROM borrowers WHERE BorrowerID=?";
        try (PreparedStatement ps = con.prepareStatement(q)) {
            ps.setInt(1, id);
            int status = ps.executeUpdate();
            if (status >0) {
                System.out.println("-- "+status +" record deleted --");
            }
        } catch (Exception e) {
           System.out.println("--- Failed :  Error while delete borrower ---"); 
        }
    }
}
