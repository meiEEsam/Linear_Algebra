package model;

public class Vector {
    private Number i;
    private Number j;
    private Number k;

    private double length;

    public Vector(Number i, Number j, Number k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    private double getLength(){

        Number i = Operations.multiply(this.getI(), Number.conjugate(this.getI()));
        Number j = Operations.multiply(this.getJ(), Number.conjugate(this.getJ()));
        Number k = Operations.multiply(this.getK(), Number.conjugate(this.getK()));

        return Math.sqrt(i.getRealPart() + j.getRealPart() + k.getRealPart());
    }

    private static Vector getUnitVector(Vector vector){

        return new Vector(new Number(vector.getI().getRealPart()/vector.getLength(), vector.getI().getImaginaryPart()/ vector.getLength()
        ), new Number(vector.getJ().getRealPart()/vector.getLength(), vector.getJ().getImaginaryPart()/ vector.getLength()
        ), new Number(vector.getK().getRealPart()/ vector.getLength(), vector.getK().getImaginaryPart()/ vector.getLength()));
    }

    private static Number dotProduct(Vector vector1, Vector vector2){
        return Operations.add(Operations.add(Operations.multiply(vector1.getI(), vector2.getI()),Operations.multiply(vector1.getJ(), vector2.getJ())),
                Operations.multiply(vector1.getK(), vector2.getK()));
    }

    private static Vector crossProduct(Vector vector1, Vector vector2){
        Number i = Operations.subtract(Operations.multiply(vector1.getJ(), vector2.getK()), Operations.multiply(vector1.getK(), vector2.getJ()));
        Number j = Operations.subtract(Operations.multiply(vector1.getK(), vector2.getI()), Operations.multiply(vector1.getI(), vector2.getK()));
        Number k = Operations.subtract(Operations.multiply(vector1.getI(), vector2.getJ()), Operations.multiply(vector1.getJ(), vector2.getI()));

        return new Vector(i, j, k);
    }



    public Number getI() {
        return i;
    }

    public Number getJ() {
        return j;
    }

    public Number getK() {
        return k;
    }
}
