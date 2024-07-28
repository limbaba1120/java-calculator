package collectionStudy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    
    private Set<Integer> numbers;
    
    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size() 메소드를 활용해 Set의 크리를 확인")
    @Test
    void setSizeTest() {
        int setSize = numbers.size();

        // Set 안에는 숫자 [1,2,3]이 들어있다.
        Assertions.assertThat(setSize).isEqualTo(3);
    }

    // 중복 코드 발생 해결
    // assertThat(numbers.contains(1)).isTure();
    // assertThat(numbers.contains(2)).isTure();
    // assertThat(numbers.contains(3)).isTure();
    @DisplayName("contains() 메소드 활용해서 '1,2,3'의 값이 존재하는지 확인 -> ParameterizedTest를 활용해 중복코드 제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsParameterizedTest(int input) {
        assertTrue(numbers.contains(input));
    }


    @DisplayName("'1,2,3' 실행결과 true, '4,5' 실행결과 false")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsCsvSourceParameterizedTest(int input, boolean expected) {
        boolean actualValue = numbers.contains(input);
        assertEquals(expected, actualValue);
    }
}
