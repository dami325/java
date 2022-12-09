package Stream;

import java.util.stream.Stream;

public class StreamBase {

    public static void main(String[] args) {
        // String 배열 stream으로 변환 후 합치기
        String[] str1 = {"123", "456", "789"};
        String[] str2 = {"ABC", "abc", "DEF"};

        Stream<String> strs1 = Stream.of(str1);
        Stream<String> strs2 = Stream.of(str2);
        Stream<String> strs3 = Stream.concat(strs1, strs2); // 두 스트림을 하나로 연결 concat()

//		strs3.forEach(s -> System.out.println(s)); // 아래와 같음
        strs3.forEach(System.out::println);           // 메서드 참조
    }

}
