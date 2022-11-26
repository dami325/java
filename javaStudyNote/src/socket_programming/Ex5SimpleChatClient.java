package socket_programming;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// 채팅 클라이언트
public class Ex5SimpleChatClient {
	private JFrame f;
	private JButton btnConnect, btnSend;
	private JTextArea ta;
	private JTextField tf;
	
	private Socket socket;
	private String host = "localhost"; // 서버 주소
	private int port = 59876; // 서버 포트번호
	
	private DataInputStream dis;
	private DataOutputStream dos;

	boolean stopSignal; // 쓰레드 중지 신호
	
	public Ex5SimpleChatClient() {
		showFrame();
	}
	
	// 프레임을 표시하는 showFrame() 메서드 정의
	public void showFrame() {
		// 사용할 폰트 객체 생성
		Font textFont = new Font("맑은 고딕", Font.PLAIN, 14);
		Font btnFont = new Font("맑은 고딕", Font.BOLD, 14);
		
		// JFrame 객체 생성하여 프레임 설정
		f = new JFrame("1:1 채팅 - 클라이언트"); // 프레임 제목표시줄 타이틀 설정
		f.setBounds(800, 400, 400, 300); // 프레임 위치(x, y) 및 크기(width, height) 설정
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 닫기 버튼 동작 설정
		
		// --------------------- 상단 : 버튼 영역 -------------------
		// 상단에 부착할 버튼(JButton) 생성
		btnConnect = new JButton("서버 접속");
		btnConnect.setFont(btnFont);
		// 프레임 상단(BorderLayout - NORTH 영역)에 버튼 부착(추가)
		f.add(btnConnect, BorderLayout.NORTH);
		// -------------------------------
		// 서버 접속 버튼 클릭 이벤트 처리
		// 1) ActionListener 인터페이스 임시 객체 구현을 통해 이벤트 처리하는 방법
//		btnConnect.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				connectServer();
//			}
//		
//		});
		
		// 2) 람다식을 통해 이벤트 처리하는 방법
		btnConnect.addActionListener((e) -> {
			// btnConnect 버튼의 텍스트 판별하여 접속 or 해제 메서드 호출
			// => 버튼의 텍스트는 btnConnect 객체의 getText() 메서드를 호출하거나
//			System.out.println(btnConnect.getText());
//			System.out.println(e.getActionCommand());
			if(e.getActionCommand().equals("서버 접속")) { // 접속 버튼 클릭 시
				connectServer();
			} else { // 접속 해제 버튼 클릭 시
				disconnectServer();
			}
		});
		// -------------------------------
		
		
		// --------------------- 센터 : 메세지 표시 영역 -------------------
		// 센터에 부착할 텍스트 입력창(JTextArea) 생성
		// 단, 센터 영역을 꽉 채우기 위해 JPanel 을 사용하지 않으므로
		// JTextArea 객체 생성 시 rows, columns 값 입력 불필요
		// => 또한, 스크롤바 기능 동작을 위해 JScrollPane 객체 생성 후
		//    프레임에 JScrollPane 객체를 부착하고
		//    JScrollPane 객체에 JTextArea 추가해야함
		JScrollPane scrollPane = new JScrollPane();
		// 프레임 가운데(BorderLayout - CENTER 영역)에 JScrollPane 부착
		f.add(scrollPane, BorderLayout.CENTER); // BorderLayout.CENTER 생략 가능
		
		ta = new JTextArea();
		ta.setFont(textFont); // 폰트 설정
		// JTextArea 내부 여백(Padding) 설정
		ta.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		// JTextArea 텍스트 자동 줄바꿈 설정
		ta.setLineWrap(true);
		// JTextArea 텍스트 입력 방지 설정(= 편집 불가)
		ta.setEditable(false);
		ta.setBackground(Color.LIGHT_GRAY);
		
		// JScrollPane 에 JTextArea 추가(부착)
		scrollPane.setViewportView(ta);
		
		
		// --------------------- 하단 : 메세지 입력 영역 -------------------
		// JTextField 와 JButton 을 하나로 묶어줄 패널(JPanel 객체) 생성
		// => 패널 요소 가운데 정렬을 위해 FlowLayout 객체 생성 시 
		//    파라미터로 FlowLayout.CENTER 상수값 전달
		JPanel pSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));
		// 프레임 하단(BorderLayout - SOUTH 영역)에 패널 부착(추가)
		f.add(pSouth, BorderLayout.SOUTH);
		
		// 텍스트 입력을 위해 JTextField 객체 생성
		tf = new JTextField(25);
		tf.setFont(textFont);
		// 패널에 텍스트필드 부착(추가)
		pSouth.add(tf);
		
		// 접속 상태를 기본값인 해제(false) 로 설정
		changeStatus(false);
		
		// "전송" 버튼(JButton) 생성
		btnSend = new JButton("전송");
		btnConnect.setFont(btnFont);
		// 패널에 버튼 부착
		pSouth.add(btnSend);
		
		// --------------------------
		// 전송 버튼 클릭 이벤트 처리
		btnSend.addActionListener((e) -> {
			sendMessage();
		});
		
		// -----------------------------
		// 텍스트필드 엔터키 이벤트 처리
		tf.addActionListener((e) -> {
			sendMessage();
		});
		
		// ----------------------------------------------------------------
		// 완성된 프레임 표시
		f.setVisible(true);
	}
	
	// 채팅 서버에 접속하는 connectServer() 메서드 정의
	public void connectServer() {
		
		try {
			socket = new Socket(host, port);
			ta.append("채팅 서버 접속완료!\n");
			
			// 접속 상태를 접속(true) 으로 변경
			changeStatus(true);
			
			// 메세지 입출력을 위한 DataXXXStream 객체 생성 및 입출력 스트림 연결
			// => 클라이언트가 접속할 때마다 객체 생성
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			
			// 텍스트 자동 스크롤 설정(임시)
			ta.setCaretPosition(ta.getDocument().getLength());
			
			// 메세지 수신 기능을 별도의 쓰레드(Thread)로 처리
			new Thread(() -> {
				// 서버로부터 전송되는 메세지를 수신 처리를 receiveMessage() 메서드 호출
				receiveMessage();
			}).start();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	// 수신된 메세지를 출력하는 receiveMessage() 메서드 정의 => 멀티쓰레딩
	public void receiveMessage() {
		try {
			// boolean 타입 멤버변수 stopSignal 이 false 일 동안 수신 작업 반복
			while(!stopSignal) {
				// 클라이언트가 전송한 메세지를 입력받아 JTextArea 에 출력
				ta.append("서버 : " + dis.readUTF() + "\n");
				
				// 텍스트 자동 스크롤 설정(맨 아래로 스크롤)
				ta.setCaretPosition(ta.getDocument().getLength());
			}
		} catch (EOFException | SocketException e) {
			// 상대방으로부터 접속이 끊긴 후 자원 접근 시 
			// EOFException, SocketException 등이 발생하므로 자원 반환
			disconnectServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 입력된 메세지를 전송하는 sendMessage() 메서드 정의
	public void sendMessage() {
		try {
			// 입력받은 메세지를 JTextArea 에 출력
			String msg = tf.getText();
			ta.append(msg + "\n");
			
			// 서버에게 메세지 전송 => DataOutputStream - writeUTF()
			dos.writeUTF(msg);
			clearMsg();
			
			// 텍스트 자동 스크롤 설정(맨 아래로 스크롤)
			ta.setCaretPosition(ta.getDocument().getLength());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnectServer() {
		if(!socket.isClosed()) { // 소켓이 닫혀있지 않을 경우
			// JTextArea 에 "채팅 서비스가 종료되었습니다." 출력 후
			// DataInputStream, DataOutputStream, Socket 객체 반환
			ta.append("채팅 서비스가 종료되었습니다.\n");
			
			// 접속 상태를 해제(false)로 변경
			changeStatus(false);
			
			try {
				if(dis != null) { dis.close(); }
				if(dos != null) { dos.close(); }
				if(socket != null) { socket.close(); }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 접속 상태 정보를 표시하는 changeStatus() 메서드 정의
	public void changeStatus(boolean isConnect) {
		// 접속 성공 시 "서버 접속" 버튼의 텍스트를 "서버 접속 해제" 로 변경
		// 접속 해제 시 "서버 접속 해제" 버튼의 텍스트를 "서버 접속" 으로 변경
		if(isConnect) {
			btnConnect.setText("서버 접속 해제");
			
			// 메세지 수신 쓰레드 다시 시작하기 위해 stopSignal 을 false 로 변경
			stopSignal = false;
			
			// 입력창 잠금 해제 및 입력창 초기화 후 포커스 요청
			tf.setEditable(true);
			clearMsg();
		} else {
			btnConnect.setText("서버 접속");
			
			// 메세지 수신 쓰레드 중지 신호 전달하기 위해 stopSignal 을 true 로 변경
			stopSignal = true;
			
			// 입력창 잠금 및 메세지 출력
			tf.setEditable(false);
			tf.setText("상대방 연결 시 채팅창이 활성화됩니다");
		}
	}
	
	// 채팅창 초기화 및 커서 요청을 수행하는 clearMsg() 메서드 정의
	public void clearMsg() {
		tf.setText("");
		tf.requestFocus();
	}
	

	public static void main(String[] args) {
		new Ex5SimpleChatClient();
	}

}












