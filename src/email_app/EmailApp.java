package email_app;

//package emailApp;
import java.util.*;
public class EmailApp {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("                                                              --------------------------------------                                                             ");
		System.out.println("-------------------------------------------------------------| WELCOME TO THE EMAIL GENERATION MENU |-------------------------------------------------------------");
		System.out.println("                                                              --------------------------------------                                                             ");
		System.out.println("Enter Your First Name: ");
		String firstName=sc.next();
		System.out.println("Enter Your Last Name: ");
		String lastName=sc.next();
		Email em=new Email(firstName,lastName);
		System.out.println("Enter a alternative email address: ");
		em.setAlternativemail();
		em.showInfo();
		System.out.println("\nDo You want to change the Password(Yes(Y)/No(N) ?): ");
		char choice=sc.next().charAt(0); 
		if(choice=='Y') {
			System.out.println("RULES FOR CREATING A PASSWORD:");
			System.out.println("Password much have at least 8 characters ");
			System.out.println("Password must contain atleast one upper case letter,one lower case letter and one digit");
			System.out.println("Password must contain one of '@','#','_' or '!' ");
			System.out.println("Enter the new Password: ");
			String pswrd=sc.next();
			em.changePassword(pswrd);
		}
		else {
			//nothing to be done.
		}
		sc.close();
	}

}

