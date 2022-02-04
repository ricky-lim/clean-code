import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Number {
    public final int value;
    public boolean isCrossed = false;

    public Number(int value) {
        this.value = value;
    }

    public void cross() {
        isCrossed = true;
    }

    public int square() {
        return value * value;
    }

}

/*
This class generate prime numbers up to a max value (exclusive).
The algorithm used is the Sieve of Eratosthenes.
1) Given a list of integers that are uncrossed, starting at 2
2) It finds the first uncrossed integer and cross out all its multiples
3) Repeat until there are no more multiples in the list.
 */
public class PrimeGenerator {
    private static final int PRIME_START = 2;
    private static List<Number> numbers;
    private static List<Integer> result;

    public static List<Integer> generate(int maxValue) {
        if (maxValue < PRIME_START) {
            return Collections.emptyList();
        }

        generateNumbersUpTo(maxValue);
        crossOutMultiples();
        extractUncrossedIntegers();
        return result;
    }


    private static void generateNumbersUpTo(int maxValue){
        numbers = IntStream.range(PRIME_START, maxValue)
                .mapToObj(Number::new)
                .collect(Collectors.toList());
    }

    private static void crossOutMultiples() {
        for (var number : numbers) {
            if (number.isCrossed){
                continue;
            }
            crossOutMultiplesOf(number);
        }
    }


    private static void crossOutMultiplesOf(Number number) {
        // Multiples less than the square of a number would have been crossed out previously
        // therefore we could skip them
        for (int i = number.square(); i <= numbers.size(); i = i + number.value) {
            Number multipleNumber = numbers.get(i - PRIME_START);
            multipleNumber.cross();
        }
    }

    private static void extractUncrossedIntegers() {
        result = numbers.stream()
                .filter(n -> !n.isCrossed)
                .mapToInt(n -> n.value)
                .boxed()
                .collect(Collectors.toList());
    }

}
