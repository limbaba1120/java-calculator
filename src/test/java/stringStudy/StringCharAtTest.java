package stringStudy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCharAtTest {

    @DisplayName("charAt() 메소드를 활용해 특정 위치 문자 가져오기")
    @Test
    void charAtTest_success() {
        String str = "abc";
        char charAt = str.charAt(2);

        Assertions.assertThat(charAt).isEqualTo('c');
    }

    @DisplayName("charAt() 메소드를 활용해 특정 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생")
    @Test
    void charAtTest_fail() {
        StringIndex strIndex = new StringIndex("abc");

        assertThatThrownBy( () -> {
            char findChar = strIndex.findCharAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }


}
