package IO;

import java.io.*;
import java.util.Arrays;

public class IOEx1 {
    public static void main(String[] args) {
        /*
        ByteArrayInputStream/ByteArrayOutputStream을 이용해 바이트배열 inSrc의 데이터를
        outSrc로 복사하는 예제, read()와 write()를 사용하는 가장 기본적인 방법
         */
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        int data = 0;

        while ((data = input.read()) != -1) { // read()를 호출한 반환값을 변수 data에 저장한다.(괄호먼저) 그 후 비교
            output.write(data);         //void write(int b)
        }

        outSrc = output.toByteArray(); // 스트림의 내용을 byte배열로 반환한다.

        System.out.println("Input Source : " + Arrays.toString(inSrc));
        System.out.println("Output Source : " + Arrays.toString(outSrc));
    }
}
