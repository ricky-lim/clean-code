import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {
    @Test
    @DisplayName("given a limit, it should generate prime numbers up to the given limit")
    void givenALimitItShouldGeneratePrimeNumbersUpToTheGivenLimit() {
        List<Integer> result = PrimeGenerator.generate(30);

        assertEquals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29), result);
    }

    @Test
    @DisplayName("given a limit of less than two, it should generate an empty list")
    void givenALimitOfLessThanTwoItShouldGenerateAnEmptyList() {
        List<Integer> result = PrimeGenerator.generate(1);
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    @DisplayName("given a limit of two, it should generate an empty list")
    void givenALimitOfTwoItShouldGenerateAnEmptyList() {
        List<Integer> result = PrimeGenerator.generate(1);
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    @DisplayName("given a limit of three, it should generate a list of two")
    void givenALimitOfThreeItShouldGenerateAListOfTwo() {
        List<Integer> result = PrimeGenerator.generate(3);
        assertEquals(List.of(2), result);
    }


}