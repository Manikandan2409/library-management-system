package demon.library.entity;

public class Borrower {
    private int borrowerId;
    private String name;
    private String email;
    private String phone;
    private String address;

    public Borrower(){}

    public static String getColumns(){
        return "| BookID| Name\t| Email\t\t\t| PhoneNumber\t | Address "+"\n====================================================================";
    }
    @Override
    public String toString() {
        return "| "+borrowerId+"\t| "+name+" \t| "+email+"\t| "+phone+" |\t"+address;
    }
    public Borrower(  String name, String email, String phone, String address) {
       
        this.name= name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(int borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
