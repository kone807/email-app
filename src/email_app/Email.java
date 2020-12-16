package email_app;

import java.util.*;

public class Email {
	// initialising all the required variables.
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity=100;
	private String alternateMail="";
	private int defaultPasswordlength=10;
	private String companySuffix=".pura.com";
	
	// constructor to receive the firstName and lastName
	public Email(String firstName, String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		// we have to call a method after this which asks for the dept and obviously return it.
		this.department=askDept();
		// now call a method which generates and returns a random password of given length. 
		this.password=generatePassword(defaultPasswordlength);
		while(!isValid(password)) {
			this.password=generatePassword(defaultPasswordlength);
		}
		//combine all the elements to generate the email;
		if(department!="")
		email=firstName.toLowerCase()+"."+ lastName.toLowerCase()+"@"+department+companySuffix;
		else
			email=firstName.toLowerCase()+"."+ lastName.toLowerCase()+"@"+"guest"+companySuffix;
	}
	
	//ask for the department
	private String askDept() {
		System.out.println("DEPARTMENT CODES:\n1. for Sales\n2. for Development\n3. for Accounting\n0. for nothing\nEnter the department code: ");
		Scanner sc=new Scanner(System.in);
		int dept=sc.nextInt();
		while(dept>3) {
			System.out.println("Inappropriate option chosen!/nCHOOSE AGAIN....");
			dept=sc.nextInt();
		}
		switch(dept) {
		case 1: return "sales";
		case 2: return "dev";
		case 3: return "acc";
		default: return "";
		}
	}
	
	// generate a random password
	private String generatePassword(int length) {
		String passwordSet="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#_!";
		char[] password=new char[length];
		for(int i=0;i<length;i++) {
			int rand=(int) (Math.random() * passwordSet.length());
			password[i]=passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	// set the mailBox capacity
	public void setMailBoxCapacity(int capacity) {
		this.mailboxCapacity=capacity;
	}
	
	//set the alternative mail
	public void setAlternativemail() {
		Scanner sc=new Scanner(System.in);
		String altmail=sc.next();
		int n=altmail.length();
		int count=0;
		for(int i=0;i<n;i++)
		{
			if(altmail.charAt(i)=='@' || altmail.charAt(i)=='.') {
			count++;
			}
		}
		if(count!=2) {
			System.out.println("Wrong Email Address added!\nEnter Again:");
			setAlternativemail();
			return;
		}
		this.alternateMail=altmail;
		return;
	}
	//change the password
	public void changePassword(String pswrd) {
		Scanner sc=new Scanner(System.in);
	while(!isValid(pswrd)) {
		System.out.println("INVALID PASSWORD!");
		System.out.println("Enter again!: ");
		pswrd=sc.next();
	}
		this.password=pswrd;
		System.out.println("Your password has been set to :"+this.password);
		sc.close();
		return;
	}
	public int getMailBoxCapacity() {
		return this.mailboxCapacity;
	}
	public String getAlternativeEmail() {
		return this.alternateMail;
	}
	public String getPassword() {
		return this.password;
	}
	public static boolean isValid(String password) 
    { 
        // for checking if password length 
        // is >= 8
        if (!(password.length() >= 8)) { 
            return false; 
        } 
        // to check space 
        if (password.contains(" ")) { 
            return false; 
        } 
        if (true) { 
            int count = 0; 
            // check digits from 0 to 9 
            for (int i = 0; i <= 9; i++) { 
  
                // to convert int to string 
                String str1 = Integer.toString(i); 
  
                if (password.contains(str1)) { 
                    count = 1; 
                } 
            } 
            if (count == 0) { 
                return false; 
            } 
        } 
        // for special characters 
        if (!(password.contains("@") || password.contains("#") 
              || password.contains("!") || password.contains("_"))) { 
            return false; 
        } 
        if (true) { 
            int count = 0; 
  
            // checking capital letters 
            for (int i = 65; i <= 90; i++) { 
  
                // type casting 
                char c = (char)i; 
  
                String str1 = Character.toString(c); 
                if (password.contains(str1)) { 
                    count = 1; 
                } 
            } 
            if (count == 0) { 
                return false; 
            } 
        }
        if (true) { 
            int count = 0; 
            // checking small letters 
            for (int i = 90; i <= 122; i++) { 
  
                // type casting 
                char c = (char)i; 
                String str1 = Character.toString(c); 
  
                if (password.contains(str1)) { 
                    count = 1; 
                } 
            } 
            if (count == 0) { 
                return false; 
            } 
        } 
        // if all conditions fails 
        return true; 
    } 
	public void showInfo() {
		System.out.println("\n|_______________________________________________Welcome to the PURA Company_______________________________________________|");
		System.out.println("\nYour Login Credentials:");
		System.out.println("Full Name: "+ this.firstName +" "+this.lastName);
		System.out.println("Department code of "+this.firstName+" is: "+this.department);
		System.out.println("YOUR EMAIL IS : "+ email);
		System.out.println("Your Password is: "+ getPassword());
		System.out.println("You can have a MailBox capacity of: "+ this.mailboxCapacity);
		System.out.println("Your Alternative Email is: "+ this.getAlternativeEmail());
	}
}
