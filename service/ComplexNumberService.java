package service;

import model.ComplexNumber;

public class ComplexNumberService {

    public double getReal(ComplexNumber complexNumber) {
        return complexNumber.getReal();
    }

    public void setReal(ComplexNumber complexNumber, double real) {
        complexNumber.setReal(real);
    }

    public double getImaginary(ComplexNumber complexNumber) {
        return complexNumber.getImaginary();
    }

    public void setImaginary(ComplexNumber complexNumber, double imaginary) {
        complexNumber.setImaginary(imaginary);
    }

    public ComplexNumber add(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.getReal() + b.getReal(), a.getImaginary() + b.getImaginary());
    }

    public ComplexNumber subtract(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.getReal() - b.getReal(), a.getImaginary() - b.getImaginary());
    }

    public ComplexNumber multiply(ComplexNumber a, ComplexNumber b) {
        double real = a.getReal() * b.getReal() - a.getImaginary() * b.getImaginary();
        double imaginary = a.getReal() * b.getImaginary() + a.getImaginary() * b.getReal();
        return new ComplexNumber(real, imaginary);
    }

    public ComplexNumber divide(ComplexNumber a, ComplexNumber b) {
        double denominator = b.getReal() * b.getReal() + b.getImaginary() * b.getImaginary();
        double real = (a.getReal() * b.getReal() + a.getImaginary() * b.getImaginary()) / denominator;
        double imaginary = (a.getImaginary() * b.getReal() - a.getReal() * b.getImaginary()) / denominator;
        return new ComplexNumber(real, imaginary);
    }
}