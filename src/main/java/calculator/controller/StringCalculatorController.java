package calculator.controller;

import calculator.model.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class StringCalculatorController {
    private final StringCalculator stringCalculator;
    private final InputView inputView;
    private final OutputView outputView;

    public StringCalculatorController(
            StringCalculator stringCalculator1, InputView inputView1, OutputView outputView1) {
        this.stringCalculator = stringCalculator1;
        this.inputView = inputView1;
        this.outputView = outputView1;
    }

    public void run() {
        try {
            inputView.printInstriction();
            String input = inputView.readInput();
            int sum = stringCalculator.add(input);
            outputView.printResult(sum);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
