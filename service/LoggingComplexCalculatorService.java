package service;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import model.ComplexNumber;

public class LoggingComplexCalculatorService implements CalculatorService<ComplexNumber> {
    private static final Logger LOGGER = Logger.getLogger(LoggingComplexCalculatorService.class.getName());
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

    @Override
    public ComplexNumber add(ComplexNumber a, ComplexNumber b) {
        ComplexNumber result = complexNumberService.add(a, b);
        LOGGER.log(Level.INFO, "Суммирование ", new Object[]{a, b, result});
        return result;
    }

    @Override
    public ComplexNumber subtract(ComplexNumber a, ComplexNumber b) {
        ComplexNumber result = complexNumberService.subtract(a, b);
        LOGGER.log(Level.INFO, "Вычитание", new Object[]{a, b, result});
        return result;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber a, ComplexNumber b) {
        ComplexNumber result = complexNumberService.multiply(a, b);
        LOGGER.log(Level.INFO, "Умножение", new Object[]{a, b, result});
        return result;
    }

    @Override
    public ComplexNumber divide(ComplexNumber a, ComplexNumber b) {
        ComplexNumber result = complexNumberService.divide(a, b);
        LOGGER.log(Level.INFO, "Деление", new Object[]{a, b, result});
        return result;
    }
}