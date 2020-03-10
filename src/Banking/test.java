package Banking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet; 
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class test {
	int anum;
	int amoney;
	String apassword;
	
    Connection conn = null;
    Statement stmt = null; // sending  SQL 문을 데이터베이스에 보내기위한 객체 
    ResultSet rs = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체
    String SQL = null;
    
	public void join() {
        int balance =0;
		Random ra=new Random();
		Scanner input=new Scanner(System.in);
        
        try{
          Class.forName("com.mysql.jdbc.Driver");
          String url = "jdbc:mysql://localhost/BANKING?serverTimezone=UTC";
           conn = DriverManager.getConnection(url, "root", "rladbstjr1!");
            System.out.println("연결 성공");
            stmt = conn.createStatement();
			
			System.out.println("input your name=");
			String aname=input.next();
			System.out.println("input your address=");
			String aaddress=input.next();
			System.out.println("input your phone=");
			String aphone=input.next();
			System.out.println("input your age=");
			int aage=input.nextInt();
			System.out.println("Set your password=");
			String apassword=input.next();
			int aaccount=(ra.nextInt(999999)+99999);
			System.out.println("your accountnumber is " + aaccount);

	        SQL = "insert into account_info(name,address,phone,age,password,account,money) values('"+aname+"','"+aaddress+"','"+aphone+"',"+aage+",'"+apassword+"',"+aaccount+","+balance+")";

			stmt.executeUpdate(SQL);
			
        }
        catch(ClassNotFoundException e){
            System.out.println("f");
        }
        catch(SQLException e){
            System.out.println("e: " + e);
        }
        finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
	}
	
	public void input_money() {
	    Statement stmt1 = null; // SQL 문을 데이터베이스에 보내기위한 객체 
		Scanner input=new Scanner(System.in);	
		int amoney;

        try{
          Class.forName("com.mysql.jdbc.Driver");
          String url = "jdbc:mysql://localhost/BANKING?serverTimezone=UTC";
           conn = DriverManager.getConnection(url, "root", "rladbstjr1!");
            System.out.println("연결 성공");
            stmt = conn.createStatement();
            stmt1=conn.createStatement();
            
    		System.out.println("===========Input the money==========");
    		System.out.println("===========input your account number=");
			System.out.println("input your account number=");
			anum=input.nextInt();
			
	        SQL = "select * from account_info where account= '" + anum + "'";
			rs=stmt.executeQuery(SQL);
			
			if(rs.next() == false ) {
				System.out.println("fail");
			}
			else {

				System.out.println("Correct, next input your password =");
				apassword=input.next();

				SQL="select * from (select * from account_info where account='" + anum + "') as t ";
				rs=stmt.executeQuery(SQL);
			
				while(rs.next()==true) {
					if(rs.getString(5).equals(apassword)) {
						System.out.println("login success! ");
						System.out.print("How much do you want to deposit?=");
						amoney=input.nextInt();
						
						SQL="UPDATE account_info SET money='"+amoney+"' + money WHERE account='" + anum + "'";
						stmt1.executeUpdate(SQL);
						
						System.out.println("Successfully deposit!");
					}
					else {
						System.out.println("fail");
					}
						
				}
			}
			
        }
        catch(ClassNotFoundException e){
            System.out.println("f");
        }
        catch(SQLException e){
            System.out.println("e: " + e);
        }
        finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
	
	}
	
	public void withdraw_money() {

	    Statement stmt1 = null; // SQL 문을 데이터베이스에 보내기위한 객체 
		Scanner input=new Scanner(System.in);	
		int amoney=0;
		int check;
        try{
          Class.forName("com.mysql.jdbc.Driver");
          String url = "jdbc:mysql://localhost/BANKING?serverTimezone=UTC";
           conn = DriverManager.getConnection(url, "root", "rladbstjr1!");
            System.out.println("연결 성공");
            stmt = conn.createStatement();
            stmt1=conn.createStatement();
            
    		System.out.println("===========withdraw the money==========");
    		System.out.println("===========input your account number=");
			System.out.println("input your account number=");
			anum=input.nextInt();
			
	        SQL = "select * from account_info where account= '" + anum + "'";
			rs=stmt.executeQuery(SQL);
			
			if(rs.next() == false ) {
				System.out.println("fail");
			}
			else {

				System.out.println("Correct, next input your password =");
				apassword=input.next();

				SQL="select * from (select * from account_info where account='" + anum + "') as t ";
				rs=stmt.executeQuery(SQL);
			
				while(rs.next()==true) {
					if(rs.getString(5).equals(apassword)) {
						System.out.println("login success! ");
						System.out.print("How much do you want to withdraw?=");
						amoney=input.nextInt();
						
						check=rs.getInt(7);
						
						if(check > amoney) {
						SQL="UPDATE account_info SET money= money - '"+amoney+"' WHERE account='" + anum + "'";
						stmt1.executeUpdate(SQL);
						System.out.println("Successfully withdraw!");
						}
						else {
							System.out.println("your balance is awful! ");
						}
					}
					else {
						System.out.println("fail");
					}
						
				}
			}
			
        }
        catch(ClassNotFoundException e){
            System.out.println("f");
        }
        catch(SQLException e){
            System.out.println("e: " + e);
        }
        finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
	
	}
	
	public void show_info() {
		
			Scanner input=new Scanner(System.in);	
	        try{
	          Class.forName("com.mysql.jdbc.Driver");
	          String url = "jdbc:mysql://localhost/BANKING?serverTimezone=UTC";
	           conn = DriverManager.getConnection(url, "root", "rladbstjr1!");
	            System.out.println("연결 성공");
	            stmt = conn.createStatement();
	            
	    		System.out.println("===========withdraw the money==========");
	    		System.out.println("===========input your account number=");
				System.out.println("input your account number=");
				anum=input.nextInt();
				
		        SQL = "select * from account_info where account= '" + anum + "'";
				rs=stmt.executeQuery(SQL);
				
				if(rs.next() == false ) {
					System.out.println("fail");
				}
				
				else {

					System.out.println("Correct, next input your password =");
					apassword=input.next();

					SQL="select * from (select * from account_info where account='" + anum + "') as t ";
					rs=stmt.executeQuery(SQL);
				
					while(rs.next()==true) {
						if(rs.getString(5).equals(apassword)) {
							System.out.println("login success! ");

							
							
							String name = rs.getString("name");
				            String address=rs.getString("address");
				            String phone=rs.getString("phone");
				            int age=rs.getInt("age");
				            int account=rs.getInt("account");
				            int money=rs.getInt("money");
				            System.out.println("Your name is = " + name );
				            System.out.println("Your address is = " + address );
				            System.out.println("Your phone number is = " + phone );
				            System.out.println("Your age is = " + age );
				            System.out.println("Your account is = " + account ); 
				            System.out.println("Your balance is = " + money );
							
						}
					}
				}
	        }
			
	        catch(ClassNotFoundException e){
	            System.out.println("f");
	        }
	        catch(SQLException e){
	            System.out.println("e: " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
		
		}
		

	
	
}
