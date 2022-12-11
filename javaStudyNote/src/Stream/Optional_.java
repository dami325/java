package Stream;

import java.util.Optional;

public class Optional_ {
    public static void main(String[] args) {
        Optional<String> optStr = Optional.of("abcde");
        Optional<Integer> optInt = optStr.map(String::length);
        System.out.println("optStr=" + optStr.get());
        System.out.println("optInt=" + optInt.get());

        int result1 = Optional.of("123")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt).get();

        int result2 = Optional.of("")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt).orElse(-1);
        System.out.println(result1);
        System.out.println(result2);

        Optional.of("456").map(Integer::parseInt)
                .ifPresent(x -> System.out.printf("result3=%d%n",x));

        int result3 = optStrToInt(Optional.of("123"),0);
        int result4 = optStrToInt(Optional.of(""),0);

        System.out.println(result3);
        System.out.println(result4);

    }

    private static int optStrToInt(Optional<String> optStr, int defaultValue) {
        try {
            return optStr.map(Integer::parseInt).get();
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
