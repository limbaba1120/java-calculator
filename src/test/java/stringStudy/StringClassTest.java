package stringStudy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringClassTest {


    @DisplayName("'1,2'을 ,로 split 했을 때 1과 2로 잘 분리된다.")
    @Test
    void stringSplitCommaTest() {
        String comma = "1,2";
        String[] splitProblem1 = comma.split(",");

        Assertions.assertThat(splitProblem1).contains("1", "2");
    }


    @DisplayName("'1'을 , 로 split 했을 때 1만 포함되는 배열이 반환된다.")
    @Test
    void stringSplitSingleTest() {
        String single = "1";
        String[] splitProblem2 = single.split(",");

        Assertions.assertThat(splitProblem2).contains("1");
    }
}

