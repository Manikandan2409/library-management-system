package demon.library.utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {
    private  final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";
    
    private  final String PHONE_PATTERN = "^\\d{10}$";
    
    private  final String NAME_PATTERN = "^[A-Za-z.]+$";

    private final String ADDRESS_PATTERN = "^[A-Za-z0-9,\\. ]+$";

    public  Scanner in = new Scanner(System.in);
    // validate email
    public  boolean isValidEmail(String email) {
        return Pattern.compile(EMAIL_PATTERN).matcher(email).matches();
    }

    // validate phone number
    public boolean isValidPhoneNumber(String phoneNumber) {
        return Pattern.compile(PHONE_PATTERN).matcher(phoneNumber).matches();
    }

    // validate name
    public boolean isValidName(String name) {
        return Pattern.compile(NAME_PATTERN).matcher(name).matches();
    }

    // validate Address
    public boolean isValidAddress(String address){
         return Pattern.compile(ADDRESS_PATTERN).matcher(address).matches();
    }
    // validate to input as number
    public int getNumber(){
   
        int choice =Integer.MIN_VALUE;
        
        try {
            choice = Integer.parseInt(in.nextLine());
        } catch (Exception e) {
            System.out.println("Enter numbers only");
            
            choice = getNumber();
        }
        return choice;
    }
    
}
