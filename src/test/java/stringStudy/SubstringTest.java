package stringStudy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SubstringTest {


    @DisplayName("'(1,2)' 값에서 substring() 메소드를 활용해 ()을 제거하고 '1,2' 반환한다.")
    @Test
    void subStringTest_success() {
        String str = "(1,2)";
        String substringStr = str.substring(1, 4);

        Assertions.assertThat(substringStr).isEqualTo("1,2");
    }

    @DisplayName("'(1,2)' 값에서 substring() 메소드를 활용해 ()을 제거하고 '1,2' 반환하지 못한다.")
    @Test
    void subStringTest_fail() {
        String str = "(1,2)";
        String substringStr = str.substring(1, 4);

        Assertions.assertThat(substringStr).isEqualTo("1,");
    }



}
