
import controller.CalculatorController;
import model.ComplexNumber;
import service.CalculatorService;
import service.LoggingComplexCalculatorService;
import view.CalculatorView;

public class Main {
    public static void main(String[] args) {
        CalculatorService<ComplexNumber> calculatorService = new LoggingComplexCalculatorService();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(calculatorService, view);
        controller.start();
    }
}