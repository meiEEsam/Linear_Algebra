package model;

public class Operations {
    public Operations() {}

    public static Number multiply(Number firstNumber,Number secondNumber)
    {
//(a+b*i)(x+y*i)=ax-by+(ay+bx)*i

     double realPart=(firstNumber.getRealPart()*secondNumber.getRealPart())-(firstNumber.getImaginaryPart() *secondNumber.getImaginaryPart());
     double imaginaryPart=(firstNumber.getRealPart()*secondNumber.getImaginaryPart())+(firstNumber.getImaginaryPart()*secondNumber.getRealPart());

       return new Number(realPart,imaginaryPart);
    }

    public static Number add(Number number1, Number number2){
        return new Number(number1.getRealPart()+number2.getRealPart(),
                number1.getImaginaryPart()+number2.getImaginaryPart());
    }

    public static Number subtract(Number number1, Number number2){
        return new Number(number1.getRealPart()-number2.getRealPart(),
                number1.getImaginaryPart()-number2.getImaginaryPart());
    }




}
