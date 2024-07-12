package demon.library.access;


import java.util.List;

import demon.library.db.BorrowerConnection;
import demon.library.entity.Borrower;
import demon.library.utils.Validation;

public class BorrowerAccess {
    
    BorrowerConnection bc = new BorrowerConnection();

    Validation validate = new Validation();

    public void accessBorrower(){
        while (true) {
            System.out.println("\t\t\t ### Borroweer ###");
            System.out.println("\n 1- Add Borrower \n 2- View Borrower \n 4- Delete Borrower \n - 5- Quit Borrower");
            int choice = validate.getNumber();
            switch (choice) {
                case 1:
                    addBorrower();
                    break;
                case 2:
                    viewBorrowers();
                    break;
                case 4:
                    deleteBorrowerById();
                    break;
                case 5:
                System.out.println("\t\t\t.....Qutting Borrower......");
                return;
                default:
                System.out.println("Invalid Option");
                    break;
            }
        }
    }

    // create Borrowe
    private void addBorrower(){
        String name =getName();
        String email=getEmail();
        String phoneNumber=getPhoneNumber();
        String address =getAddress();
       bc.save(new Borrower(name, email,phoneNumber,address));
    }
    //view 
    private void viewBorrowers(){
        List<Borrower> borrowers = bc.findAll();
        printBorrowers(borrowers);
    }
    //Delete Borrower
    public void deleteBorrowerById(){
        viewBorrowers();
        System.out.println(" Borrower id: ");
        int id = validate.getNumber();
        bc.deleteById(id);

    }

    // name
    private String getName(){
        System.out.println("Borrwer Name: ");
        String name = validate.in.nextLine();  
        if (validate.isValidName(name))     return name;
        else  {
            System.out.println("Invalid Name");
            return getName();
        }
    }

    // email
    private String getEmail(){
        System.out.println("Borrower Email : ");
        String email = validate.in.nextLine();
        if (validate.isValidEmail(email))  return email;
        else {
            System.out.println(" ** Invalid email **");
            return getEmail();
        }
    }

    // phone number
    private String getPhoneNumber(){
        System.out.println("Borrowe Mobile Number : ");
        String phoneNumber = validate.in.nextLine();
        if(validate.isValidPhoneNumber(phoneNumber)) return phoneNumber;
        else{
            System.out.println(" *** Invalid Phone Number ***");
            return getPhoneNumber();
        }
    }

    // Address
    private String getAddress(){
        System.out.println("Borrower Address : ");
        String address = validate.in.nextLine();
        if(validate.isValidAddress(address)) return address;
        else {
            System.out.println(" *** Invalid Address ***");
            return getAddress();
        }
    }

    private void printBorrowers(List<Borrower> borrowers){
        System.out.println(Borrower.getColumns());
        borrowers.stream().forEach(System.out::println);
    }
}
