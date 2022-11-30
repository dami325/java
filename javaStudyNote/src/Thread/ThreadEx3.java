package Thread;

import javax.swing.JOptionPane;

public class ThreadEx3 {
	// 하나의 쓰레드로 사용자의 입력을 받는 작업과 
	// 숫자를 출력하는 작업을 처리하기 때문에 사용자가 입력을 마치기 전까지는
	// 숫자가 출력되지 않다가 사용자가 입력을 마치고 나서야 화면에 숫자가 출력됨
//	public static void main(String[] args) {
//		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
//		System.out.println("입력하신 값은 " + input + "입니다.");
//		
//		for(int i = 10; i > 0; i--) {
//			System.out.println(i);
//			try {
//				Thread.sleep(1000); // 1초간 시간을 지연한다.
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			
//		}
//	}
	
	
	/*
	 * 	위 예제와는 달리 두개의 쓰레드로 나누어서 처리했기 때문에 입력을 마치지 않아도 화면에 숫자가 출력됨
	 * */
	public static void main(String[] args) {
		ThreadEx3_1 th1 = new ThreadEx3_1();
		th1.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + "입니다.");
		
	}

}

class ThreadEx3_1 extends Thread {
	public void run() {
		for(int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}