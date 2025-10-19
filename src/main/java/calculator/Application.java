package calculator;

import calculator.controller.StringCalculatorController;
import calculator.model.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        StringCalculatorController controller = new StringCalculatorController(stringCalculator, inputView, outputView);
        controller.run();
    }
}
