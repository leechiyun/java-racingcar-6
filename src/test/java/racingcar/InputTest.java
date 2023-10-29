package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputTest {
    @Test
    public void 이름입력의_길이가_5보다_클_때_예외() {
        // given
        String input = "veryverylong";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> Application.validateName(input));
    }

    @Test
    public void 이름입력에_스페이스바가_들어있을_때_예외() {
        // given
        String input = " ss ";
        List<String> testList = Arrays.asList(" ", "s ", "   ", " a b");

        // when & then
        assertThrows(IllegalArgumentException.class, () -> Application.validateName(input));

        for (String test : testList) {
            assertThrows(IllegalArgumentException.class, () -> Application.validateName(test));
        }
    }

    @Test
    public void 이름입력이_비어있을_때_예외() {
        // given
        String input = "";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> Application.validateName(input));
    }

    @Test
    public void 시도횟수가_숫자가_아닐_때_예외() {
        // given
        List<String> testList = Arrays.asList("안녕", "huni,jun,lee", "@@!@");

        // when & then
        for (String test : testList) {
            assertThrows(IllegalArgumentException.class, () -> Application.getInteger(test));
        }
    }

    @Test
    public void 시도횟수가_1이상_자연수가_아닐_때_예외() {
        // given
        List<String> testList = Arrays.asList("3.154", "0", "-1");

        // when & then
        for (String test : testList) {
            assertThrows(IllegalArgumentException.class, () -> Application.getInteger(test));
        }
    }

    @Test
    public void 시도횟수_입력이_올바른_경우() {
        // given
        String input = "3";
        int expected = 3;

        // when
        int result = Application.getInteger(input);

        // then
        assertEquals(expected, result);
    }
}
