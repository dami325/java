package Stream;

import java.io.File;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class map {
    /*
        변환 - map()
        스트림 요소에 저장된 값 중에서 원하는 필드만 뽑아내거나 특정 형태로 변환해야할 때 사용
        Stream<R> map(Function<? super T,? extends R> mapper)
        매개변수로 T타입을 R타입으로 변환해서 반환하는 함수를 지정해야한다.
    */
    public static void main(String[] args) throws Exception{
        // File의 스트림에서 파일의 이름만 뽑아서 출력하고 싶을때
        Stream<File> fileStream = Stream.of(new File("Ex1.java"), new File("Ex1"),
                new File("Ex1.bak"), new File("Ex2.java"),new File("Ex1.txt"));

        // map()으로 Stream<File>을 Stream<String> 으로 변환
//        Stream<String> filenameStream = fileStream.map(File::getName);
//        filenameStream.forEach(System.out::println);

        // map()도 filter()처럼 하나의 스트림에 여러 번 적용 가능

        /*fileStream.map(File::getName) // Stream<File> -> Stream<String>
                .filter(s -> s.indexOf('.') != -1) // 확장자가 없는건 제외
                .map(s -> s.substring(s.indexOf('.') + 1))
                .map(s -> s.toUpperCase()) // 모두 대문자로 변환 (String::toUpperCase)
                .distinct()
                .forEach(s -> System.out.print(s));*/

        fileStream.map(File::getName) // Stream<File> -> Stream<String>
                .filter(s -> s.indexOf('.') != -1) // 확장자가 없는건 제외
                .peek(s -> System.out.printf("filename =%s%n",s)) // 파일명을 출력한다.
                .map(s -> s.substring(s.indexOf('.') + 1)) // 확장자만 추출
                .peek(s -> System.out.printf("extension =%s%n", s)) // 확장자를 출력한다.
                .forEach(System.out::println);

        /*
            로또번호를 생성해서 출력하는 코드, mapToObj()를 이용해 IntStream을 Stream<String>으로 변환
         */
        IntStream intStream = new Random().ints(1,46); // 1~45사이의 정수 46은 포함안됨
        Stream<String> lottoStream = intStream.distinct().limit(6).sorted()
                .mapToObj(i -> i+","); // 정수를 문자열로 변환
        lottoStream.forEach(System.out::print);

    }
}
