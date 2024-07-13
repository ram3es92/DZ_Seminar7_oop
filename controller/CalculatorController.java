package controller;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import model.ComplexNumber;
import service.CalculatorService;
import service.ComplexNumberService;
import view.CalculatorView;

public class CalculatorController {
    private static final Logger LOGGER = Logger.getLogger(CalculatorController.class.getName());
    private final ComplexNumberService complexNumberService = new ComplexNumberService();

    static {
        try {
            FileHandler fileHandler = new FileHandler("calculator.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
            LOGGER.setUseParentHandlers(false);
        } catch (Exception e) {
            LOGGER.severe("Ошибка инициализации журнала.");
        }
    }

    private final CalculatorService<ComplexNumber> calculatorService;
    private final CalculatorView view;

    public CalculatorController(CalculatorService<ComplexNumber> calculatorService, CalculatorView view) {
        this.calculatorService = calculatorService;
        this.view = view;
    }

    public void start() {
        try {
            ComplexNumber num1 = view.getComplexNumber("Введите первое комплексное число вида (x+yi):");
            ComplexNumber num2 = view.getComplexNumber("Введите второе комплексное число вида (x+yi):");
            String operation = view.getOperation();

            ComplexNumber result = null;
            switch (operation) {
                case "+":
                    result = calculatorService.add(num1, num2);
                    break;
                case "-":
                    result = calculatorService.subtract(num1, num2);
                    break;
                case "*":
                    result = calculatorService.multiply(num1, num2);
                    break;
                case "/":
                    result = calculatorService.divide(num1, num2);
                    break;
                default:
                    view.showError("Ошибка операции");
                    return;
            }

            view.showResult(result);
            LOGGER.info("Операция " + operation + " выполнено с результатом: " + result);
        } catch (Exception e) {
            view.showError("Произошла ошибка: " + e.getMessage());
        }
    }
}