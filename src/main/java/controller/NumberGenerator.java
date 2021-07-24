package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Number;

public class NumberGenerator {

 private Pattern  realNumberInput;
 private Pattern  imaginaryNumberInput;
 private Pattern  complexNumberInput1;
 private Pattern  complexNumberInput2;

 private Matcher   realNumberInputMatcher;
 private Matcher   imaginaryNumberInputMatcher;
 private Matcher   complexNumberInput1Matcher;
 private Matcher   complexNumberInput2Matcher;

    public NumberGenerator() {
       realNumberInput=Pattern.compile("^\\s*(\\d+)\\s*(\\.\\s*\\d+)?\\s*$");
       imaginaryNumberInput=Pattern.compile("^\\s*(\\d+)\\s*(\\.\\s*\\d+)?\\s*[i|I|j|J]\\s*$");
       complexNumberInput1=Pattern.compile("^\\s*(\\d+)\\s*(\\.\\s*\\d+)?\\s*[i|I|j|J]\\s*\\+\\s*(\\d+)\\s*(\\.\\s*\\d+)?\\s*$");
       complexNumberInput2=Pattern.compile("^\\s*(\\d+)\\s*(\\.\\s*\\d+)?\\s*\\+\\s*(\\d+)\\s*(\\.\\s*\\d+)?\\s*[i|I|j|J]\\s*$");



    }

    public  Number number(String input) {

          
        
        realNumberInputMatcher=realNumberInput.matcher(input);
        imaginaryNumberInputMatcher=imaginaryNumberInput.matcher(input);
        complexNumberInput1Matcher=complexNumberInput1.matcher(input);
        complexNumberInput2Matcher=complexNumberInput2.matcher(input);
        
        if(realNumberInputMatcher.find())
        {


            String a="",b=".0";
            a=realNumberInputMatcher.group(1);

            try {
                b=realNumberInputMatcher.group(2); 
                a=a+b;
                b=".0";

            }
            catch (Exception e)
            {
                System.out.println("hey");
                a=a+b;   
                
            }


           return new Number(Double.parseDouble(a),0);
           }

        if(imaginaryNumberInputMatcher.find())
        {

            String a="",b=".0";
            a=imaginaryNumberInputMatcher.group(1);
            try {
                b=imaginaryNumberInputMatcher.group(2);
                a=a+b;
            }
            catch (Exception e)
            {
                a=a+b;

            }



            return new Number(0,Double.parseDouble(a));
        }

        if(complexNumberInput1Matcher.find())
        {

            String a="",b=".0",c="",d=".0";
            a=complexNumberInput1Matcher.group(1);
            try {
                b=complexNumberInput1Matcher.group(2);
                a=a+b;
            }
            catch (Exception e)
            {
                a=a+b;

            }
            c=complexNumberInput1Matcher.group(3);
            try {
                d=complexNumberInput1Matcher.group(4);
                c=c+d;
            }
            catch (Exception e)
            {
                c=c+d;

            }

            return new Number(Double.parseDouble(c),Double.parseDouble(a));
        }
        if(complexNumberInput2Matcher.find())
        {

            String a="",b=".0",c="",d=".0";
            a=complexNumberInput2Matcher.group(1);
            try {
                b=complexNumberInput2Matcher.group(2);
                a=a+b;
            }
            catch (Exception e)
            {
                a=a+b;

            }
            c=complexNumberInput2Matcher.group(3);
            try {
                d=complexNumberInput2Matcher.group(4);
                c=c+d;
            }
            catch (Exception e)
            {
                c=c+d;

            }

            return new Number(Double.parseDouble(a),Double.parseDouble(c));
        }









        return null;
    }

}
