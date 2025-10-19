package calculator.view;

public class OutputView {
    private static final String OUTPUT_INSTRUCTION = "결과: ";

    public void printResult(int result) {
        System.out.print(OUTPUT_INSTRUCTION + result);
    }
}
