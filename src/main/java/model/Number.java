package model;

public class Number {
    private double realPart;
    private double imaginaryPart;

    public Number(double realPart, double imaginaryPart) {
        if(realPart==-0.0)
             realPart=0;
        if(imaginaryPart==-0.0)
             imaginaryPart=0;



        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public static Number conjugate(Number number){
        return new Number(number.getRealPart(), -number.getImaginaryPart());
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    @Override
    public String toString() {
        return
                " realPart= " + realPart +
                ", imaginaryPart= " + imaginaryPart
                ;
    }
}
