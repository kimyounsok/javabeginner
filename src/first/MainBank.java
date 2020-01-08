package first;

import java.util.Random;
import java.util.Scanner;

public class MainBank {
	public static void main(String[] args) {
		final int MIN_ACCOUNTN=000000;
		final int MAX_ACCOUNTN=999999;
		Scanner input=new Scanner(System.in);
		Random ra=new Random();
		menu show_menu=new menu();
		control[] c=new control[1000];
		for(int i=0;i<c.length;i++) {
			c[i]=new control();
		}
		String name,address,phone;
		int choice,age,paccount,password,money;
		int index=0;
		int account=0;
	
		while(true) {

		show_menu.Showmenu();
		choice=input.nextInt();
		
		if(choice==0) {
			System.out.println("exit the banking programming");
			break;
		}
		
		switch(choice) {
		case 1:
			System.out.println("===========Input the money==========");
			System.out.print("===========input your account number=");
			paccount=input.nextInt();
			
			for(int i=0;i<c.length;i++) {
				if(c[i].account==paccount) {
					System.out.println("Correct, next input your password =");
					password=input.nextInt();
					for(int j=0;j<c.length;j++) {
						if(c[j].password == password) {
							System.out.println("how much you want input money? = ");
							money=input.nextInt();
							c[i].money+=money;
							System.out.println("Process is complete your balance is =" + c[i].money);
						}
					}
					
				}
				else {
					continue;
				}
			}
			break;
		case 2:
			System.out.println("===========withdraw the money==========");
			System.out.print("===========withdraw your account number=");
			paccount=input.nextInt();
			
			for(int i=0;i<c.length;i++) {
				if(c[i].account==paccount) {
					System.out.println("Correct, next input your password =");
					password=input.nextInt();
					for(int j=0;j<c.length;j++) {
						if(c[j].password == password) {
							System.out.println("how much you want withdraw money? = ");
							money=input.nextInt();
							c[i].money-=money;
							System.out.println("Process is complete your balance is =" + c[i].money);
						}
					}
					
				}
				else {
					continue;
				}
			}
		case 3:
			System.out.println("input your name=");
			name=input.next();
			System.out.println("input your address=");
			address=input.next();
			System.out.println("input your phone=");
			phone=input.next();
			System.out.println("input your age=");
			age=input.nextInt();
			System.out.println("Set your password=");
			password=input.nextInt();
			account=(ra.nextInt(MAX_ACCOUNTN)+MIN_ACCOUNTN);
			System.out.println("your accountnumber is " + account);
			c[index++].join(name,address,phone, age,password,account);
			break;
		case 4:
			System.out.print("input your account number=");
			paccount=input.nextInt();
			
			for(int i=0;i<c.length;i++) {
				if(c[i].account==paccount) {
					System.out.println("Correct, next input your password =");
					password=input.nextInt();
					for(int j=0;j<c.length;j++) {
						if(c[j].password == password) {
							System.out.println("your name is=" + c[i].name + "\t your address is=" + c[i].address +"\t your phone is=" + c[i].phone +"\t your age is=" + c[i].age + "\t your account is=" + c[i].account + "\t your balance is=" + c[i].money);
						}
					}
					
				}
				else {
					continue;
				}
			}
			break;
		default:
			System.out.println("You typed wrong number try again");
			break;
			}
		}
	}
}
