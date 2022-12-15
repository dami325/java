package networking;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
/*
    InetAddress의 주요 메서드들을 활용하는 예제
    getAllByName()을 통해 모든 IP 주소를 얻을 수 있다.

    getLocalHost()를 사용해 호스트명과 IP주소를 알아낼 수 있다.
 */
public class NetworkEx1 {
    public static void main(String[] args) {

        InetAddress ip = null;
        InetAddress[] ipArr = null;

        try {
            ip = InetAddress.getByName("www.naver.com");
            System.out.println("getHostName() : " + ip.getHostName());
            System.out.println("getHostAddress() : " + ip.getHostAddress());
            System.out.println("toString() :" + ip.toString());

            byte[] ipAddr = ip.getAddress();
            System.out.println("getAddress() : " + Arrays.toString(ipAddr));

            String result = "";
            for (int i = 0; i < ipAddr.length; i++) {
                result += (ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i];
                result += ".";
            }
            System.out.println("getAddress() + 256 :" + result);
            System.out.println();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        try {
            ip = InetAddress.getLocalHost();
            System.out.println("getHostName(): " + ip.getHostName());
            System.out.println("getHostAddress() :" + ip.getHostAddress());
            System.out.println();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        try {
            ipArr = InetAddress.getAllByName("www.naver.com");

            for (int i = 0; i < ipArr.length; i++) {
                System.out.println("ipArr["+i+"] :" + ipArr[i]);
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }


    }
}
