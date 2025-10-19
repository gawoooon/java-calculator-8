package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_INSTRUCTION = "덧셈할 문자열을 입력해 주세요.";

    public void printInstriction() {
        System.out.println(INPUT_INSTRUCTION);
    }

    public String readInput() {
        return Console.readLine();
    }
}
