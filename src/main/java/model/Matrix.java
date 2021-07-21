package model;

public class Matrix {
    private Number[][] elements;
    private Number determinant;

    public Matrix(Number[][] elements){
        this.elements = elements;
        if (elements.length==elements[0].length)
            this.determinant = determinantCalculator(elements);
    }

    public static Matrix multiply(Matrix A, Matrix B){
        Number[][] matrixA = A.getElements();
        Number[][] matrixB = B.getElements();
        int rowA = matrixA.length;
        int colARowB = matrixB[0].length;
        int colB = matrixB[0].length;
        Number[][] result = new Number[rowA][colB];
        int x = 0;
        int y = 0;
        Number sum = new Number(0, 0);

        all : for (Number[] numbers : matrixA){
            for (int j = 0; j < colB; j++) {
                for (int k = 0; k < colARowB; k++) {
                    sum = Operations.add(sum, Operations.multiply(numbers[k], matrixB[k][j]));
                }
                result[x][y] = sum;
                sum.setImaginaryPart(0);
                sum.setRealPart(0);
                y++;
                if (y==colB){
                    x++;
                    if (x==rowA){
                        break all;
                    }
                    y = 0;
                }
            }
        }
        return new Matrix(result);
    }

    public static Matrix add(Matrix A, Matrix B){
        Number[][] matrixA = A.getElements();
        Number[][] matrixB = B.getElements();
        Number[][] matrixC = new Number[matrixA.length][matrixA[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                matrixC[i][j] = Operations.add(matrixA[i][j], matrixB[i][j]);
            }
        }
        return new Matrix(matrixC);
    }

    public static Matrix transpose(Matrix A){
        Number[][] matrix = A.getElements();
        int a = matrix.length;
        int b= matrix[0].length;
        Number[][] transpose = new Number[b][a];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return new Matrix(transpose);
    }


    private Number determinantCalculator(Number[][] elements){
        if (elements.length==2){
            return Operations.subtract(Operations.multiply(elements[0][0], elements[1][1]),
                    Operations.multiply(elements[0][1], elements[1][0]));
        }else{
            Number swit = new Number(1, 0);
            Number determinant = new Number(0, 0);

            for (int i = 0; i < elements.length; i++) {
                determinant = Operations.add(determinant,
                        Operations.multiply(Operations.multiply(elements[0][i], determinantCalculator(coFactor(elements, i))), swit));
                swit.setRealPart(-swit.getRealPart());
            }
            return determinant;
        }



    }

    private Number[][] coFactor(Number[][] matrix, int i){
        Number[][] co = new Number[matrix.length-1][matrix.length-1];
        int x = 0;
        int y = 0;
        all: for (int j = 1; j < matrix.length; j++) {
            for (int k = 0; k < matrix.length; k++) {
                if (i!=k){
                    co[x][y] = matrix[j][k];

                    y++;
                    if (y==matrix.length-1){
                        x++;
                        y=0;
                    }
                    if (x==matrix.length-1)
                        break all;
                }
            }
        }
        return co;
}





    public void setElements(Number[][] elements) {
        this.elements = elements;
        this.determinant = determinantCalculator(elements);
    }

    public Number[][] getElements() {
        return elements;
    }

    public Number getDeterminant() {
        return determinant;
    }


}
