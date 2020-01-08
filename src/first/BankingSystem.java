package first;

public interface BankingSystem {
	
	public void show_info();
	public void join(String name,String address,String phone,int age,int password,int account);
	public void input_money(int money);
	public void withdraw_money(int money);
	
}
