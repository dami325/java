package Thread;
/*
 * 	은행계좌에서 잔고를 확인하고 임의의 금액을 출금 하는 예제
 * 
 */
public class synchronizedEx1 {

	public static void main(String[] args) {
		Runnable r = new RunnableEx21();
		new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc대상이 아니다.
		new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc대상이 아니다.
	}

}

class Account {
	private int balance = 1000; // private로 해야 동기화가 의미가 있다.
	
	public int getBalance() {
		return balance;
	}
	
	public synchronized void withdraw(int money) {
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance -= money;
		}
	}
}

class RunnableEx21 implements Runnable {
	Account acc = new Account();
	
	@Override
	public void run() {
		while(acc.getBalance() > 0) {
			// 100, 200, 300중의 한 값을 임의로 선택해서 출금(withdraw)
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance:" + acc.getBalance());
		}
	}
}