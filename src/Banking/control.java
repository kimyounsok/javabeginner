package Banking;
public class control implements BankingSystem {
	
	String name;
	String address;
	String phone;
	int account;
	int age;
	int money;
	int password;
	public void show_info() {
		System.out.println("Name =" + this.name );
		System.out.println("Address =" + this.address);
		System.out.println("phone =" + this.phone);
		System.out.println("age =" + this.age);
		System.out.println("money =" + this.money);
	}
	public void join(String name, String address, String phone, int age,int password,int account) {
		this.name=name;
		this.address=address;
		this.phone=phone;
		this.age=age;
		this.password=password;
		this.account=account;
	}
	public void input_money(int money) {
		this.money+=money;
	}
	public void withdraw_money(int money) {
		this.money-=money;
	}

}
