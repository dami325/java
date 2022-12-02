package Thread;

import javax.swing.JOptionPane;
/*
 		카운트 다운 도중 사용자의 입력이 들어오면 카운트다운을 종료한다.
 */
public class interrupt {

	public static void main(String[] args) {
		interrupt2 th1 = new interrupt2();
		th1.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
		System.out.println("입력하신 값 : " + input + "입니다.");
		th1.interrupt(); // interrupt()를 호출하면, interrupted상태가 true가 된다.
		System.out.println(th1.isInterrupted());
		
	}

}

class interrupt2 extends Thread{
	
	@Override
	public void run() {
		int i = 10;
		while(i != 0 && !isInterrupted()) {
			System.out.println(i--);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				interrupt();
			}
			System.out.println("카운트가 종료되었습니다.");
		}
	}
}