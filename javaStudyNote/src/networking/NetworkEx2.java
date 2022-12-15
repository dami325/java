package networking;

import java.net.URL;

public class NetworkEx2 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("www.naver.com");

        System.out.println(url.getAuthority());
        System.out.println(url.getContent());
        System.out.println(url.getDefaultPort());
        System.out.println(url.getPort());
        System.out.println(url.getFile());
        System.out.println(url.getHost());
        System.out.println(url.getPath());
        System.out.println(url.getProtocol());
        System.out.println(url.getQuery());
        System.out.println(url.getRef());
        System.out.println(url.getUserInfo());
        System.out.println(url.toExternalForm());
        System.out.println(url.toURI());

    }
}
