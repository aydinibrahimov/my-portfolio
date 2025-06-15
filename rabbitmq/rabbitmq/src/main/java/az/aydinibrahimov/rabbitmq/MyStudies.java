package az.aydinibrahimov.rabbitmq;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

public class MyStudies {

    public static void main(String[] args) {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .parallel()
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);
    }

   static Stream<BigInteger> primes() {

        Stream<BigInteger> c=Stream.iterate(TWO, BigInteger::nextProbablePrime);
        return c;
    }




//    static Stream<BigInteger> primes()
//    {
//        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
//    }
//
//    public static void main(String[] args) {
//        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
//                .filter(mersenne -> mersenne.isProbablePrime(50))
//                .limit(20)
//                .forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));
//    }

    public static void regexString(){
        String text = "Hello, world! How are you today? I'm @coding_java.";
        if (text.matches("[A-Za-z !,?._'@]+")) {
            String[] tokens = text.split("[\\s,!?._'@]+");
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    System.out.println(token);
                }
            }
        } else {
            System.out.println("String doesn't match the required pattern");
        }
    }

    public static List<Integer> maxSubarray(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();

        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int num : arr) {
            maxEndingHere = maxEndingHere + num;

            maxEndingHere = Integer.max(maxEndingHere, num);

            maxSoFar = Integer.max(maxSoFar, maxEndingHere);
        }

        result.add(maxSoFar);

        int maxSubsequence = Integer.MIN_VALUE;
        int sumPositives = 0;
        boolean hasPositive = false;

        for (int num : arr) {
            if (num > 0) {
                sumPositives += num;
                hasPositive = true;
            }
            maxSubsequence = Integer.max(maxSubsequence, num);
        }

        if (hasPositive) {
            result.add(sumPositives);
        } else {
            result.add(maxSubsequence);
        }

        return result;
    }


}












