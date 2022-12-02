package Thread;

public class suspend_resume_stop {

	public static void main(String[] args) {
		RunImpl th1 = new RunImpl("AAA");
		RunImpl th2 = new RunImpl("BBB");
		RunImpl th3 = new RunImpl("CCC");
		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(1000);
			th1.suspend();
			Thread.sleep(3000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume();
			Thread.sleep(3000);
			th1.stop();
			th2.stop();
			Thread.sleep(3000);
			th3.stop();
		} catch (InterruptedException e) {
			
		}
		
	}

}

class RunImpl implements Runnable {
	// volatile = 변수를 Main Memory에 저장하겠다라는 것을 명시하는 것,
	// Main Memory에 read & write를 보장하는 키워드.
	// 하나의 Thread가 write하고 나머지 Thread가 읽는 상황.
	// 변수의 값이 최신의 값으로 읽어와야 하는 경우.
	volatile boolean suspended = false; 
	volatile boolean stopped   = false;
	
	Thread th;
	
	public RunImpl(String name) {
		th = new Thread(this, name); // Thread(Runnable r, String name)
	}
	
	@Override
	public void run() {
		while(!stopped) { // false인 동안 반복
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
				}
			}
		}
		System.out.println(Thread.currentThread().getName() + " - stopped");
	}
	
	public void suspend() {
		suspended = true;
	}
	public void resume() {
		suspended = false;
	}
	public void stop() {
		stopped = true;
	}
	public void start() {
		th.start();
	}
}