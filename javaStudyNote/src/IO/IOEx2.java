package IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx2 {
    public static void main(String[] args) {
        /*
        배열을 사용해서 입출력 작업이 보다 효율적으로 이루어지도록 함
        가능하면 입출력 대상에 따라 알맞은 크기의 배열을 사용하는 것이 좋다.
         */
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;
        byte[] temp = new byte[10];

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        input.read(temp, 0, temp.length); // 읽어온 데이터를 배열 temp에 담는다.
        output.write(temp, 5, 5);     // temp[5] 부터 5개의 데이터를 write한다.

        outSrc = output.toByteArray();

        outSrc = output.toByteArray(); // 스트림의 내용을 byte배열로 반환한다.

        System.out.println("Input Source : " + Arrays.toString(inSrc));
        System.out.println("Output Source : " + Arrays.toString(outSrc));
    }
}
