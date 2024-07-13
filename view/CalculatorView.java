package view;

import java.util.Scanner;
import model.ComplexNumber;

public class CalculatorView {

    private final Scanner scanner = new Scanner(System.in);

    public ComplexNumber getComplexNumber(String prompt) {
        System.out.println(prompt);
        System.out.println("Введите вещественное число (x):");
        double real = scanner.nextDouble();
        System.out.println("Введите мнимую часть (yi):");
        double imaginary = scanner.nextDouble();
        return new ComplexNumber(real, imaginary);
    }

    public String getOperation() {
        System.out.println("Выбирите операцию: +, -, *, /");
        return scanner.next();
    }

    public void showResult(ComplexNumber result) {
        System.out.println("Результат: " + result);
    }

    public void showError(String message) {
        System.out.println("Ошибка: " + message);
    }
}
