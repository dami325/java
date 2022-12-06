package Thread;

public class join {
	/*
	   join() - 다른 쓰레드의 작업을 기다린다.
	   쓰레드 자신이 하던 작업을 멈추고 다른 쓰레드가 지정된 시간동안 작업을 수행하도록 할 때 사용
	   sleep과 유사하지만 다른 점은 현재 쓰레드가 아닌 특정 쓰레드에 대해 동작하므로 static메서드가 아님
	 
	 * */
	static long startTime = 0;
	
	public static void main(String[] args) {
		ThreadJoin th1 = new ThreadJoin();
		ThreadJoin2 th2 = new ThreadJoin2();
		
		th1.start();
		th2.start();
		startTime = System.currentTimeMillis();
		
		try {
			th1.join(); // main 쓰레드가 th1의 작업이 끝날 때까지 기다린다.
			th2.join(); // main 쓰레드가 th2의 작업이 끝날 때까지 기다린다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("소요시간 : " + (System.currentTimeMillis() - join.startTime));
	}

}

class ThreadJoin extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("-");
		}
	}
}

class ThreadJoin2 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 300; i ++) {
			System.out.print("|");
		}
	}
}