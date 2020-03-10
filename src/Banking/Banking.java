package Banking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet; 
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Banking{
public	static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	menu sm=new menu();
	test t=new test();
	int choice;
	
	while(true) {
		
		sm.Showmenu();
		choice=input.nextInt();
		
		switch(choice){

		case 1:
			t.input_money();
			break;
		case 2:
			t.withdraw_money();
			break;
		case 3:
			t.join();
			break;
		case 4:
			t.show_info();
			break;
		case 0:
			System.out.println("exit the banking program, thank you for using banking program!");
			System.exit(0);
		default :
			System.out.println("you choice wrong number!");
			break;
			
		}
		
	}

}
}
