package Thread;

/*
 	새로 생성한 쓰레드에서 고의로 예외를 발생시키고 printStackTrace()를 이용해서 예외가 발생한
 	당시의 호출스택을 출력하는 예제
 	
 	한 쓰레드가 예외가 발생해서 종료되어도 다른 쓰레드의 실행에는 영향을 미치지 않는다.
 	
 	main쓰레드는 이미 종료됨
*/
public class ThreadEx2 {
	public static void main(String[] args) throws Exception {
		ThreadEx2_1 t1 = new ThreadEx2_1();
		t1.start();
	}
}

class ThreadEx2_1 extends Thread {
	@Override
	public void run() {
		throwException();
	}
	
	public void throwException() {
		
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
