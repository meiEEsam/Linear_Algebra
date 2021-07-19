package model;

public class Multiply {
    public Multiply() {}

    public Number multiply(Number firstNumber,Number secondNumber)
    {
//(a+b*i)(x+y*i)=ax-by+(ay+bx)*i

     double realPart=(firstNumber.getRealPart()*secondNumber.getRealPart())-(firstNumber.getImaginaryPart() *secondNumber.getImaginaryPart());
     double imaginaryPart=(firstNumber.getRealPart()*secondNumber.getImaginaryPart())+(firstNumber.getImaginaryPart()*secondNumber.getRealPart());



       return new Number(realPart,imaginaryPart);
    }



}
