package Thread;




/*
 * 		데몬 쓰레드(daemon thread)
 * 		일반 쓰레드의 작업을 돕는 보조적인 역할
 * 		일반 쓰레드가 모두 종료되면 데몬 쓰레드는 강제적으로 자동 종료됨
 * 		(일반 쓰레드의 보조 역할을 수행하므로 조냊의 의미가 없기 때문)
 * 		무한 루프와 조건문을 이용해서 실행 후 대기하고 있다가 특정 조건이 만족되면 작업을 수행하고 다시 대기하도록 작성한다.
 * 
 * 		setDaemon메서드는 반드시 start()를 호출하기 전에 실행되어야 한다. 안그러면 예외를 발생함 ㅜㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
 * 	
 */
public class daemonThread implements Runnable {
	static boolean autoSave = false;
	
	
	public static void main(String[] args) {
		Thread t = new Thread(new daemonThread());
		t.setDaemon(true);
		t.start();
		
		for(int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			System.out.println(i);
			
			if(i==5)autoSave = true;
		}
		System.out.println("프로그램을 종료합니다.");
	}


	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3 * 1000); // 3초마다
			} catch (InterruptedException e) {}
			//autoSave의 값이 true이면 autoSave()를 호출한다.
			if(autoSave) { // true일때
				autoSave();
			}
		}
	}
	
	public void autoSave() {
		System.out.println("작업파일이 자동저장되었습니다.");
	}
}
