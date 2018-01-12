import java.util.ArrayList;

public class ObjectList {
	public static void main(String[] args) {        
    // Create an ArrayList that can hold multiple object types:
    ArrayList myObjects  = new ArrayList();

    // Create three circles:
    int numCircles = 3;
    System.out.println("Add " + numCircles + " circles to the ArrayList.");

    for (int i = 0; i < numCircles; i++) {
        // Create a circle with a random radius
        final int min = 1;
        final int max = 10;
        int rad = (int)(Math.floor(Math.random() * (max - min)) + min);       
        Circle tmpC = new Circle(rad);

        // Add the circle to the ArrayList
        myObjects.add(tmpC);
    }

    // Add a string to the ArrayList
    System.out.println("Add 1 string to the ArrayList."); 
    String tmpStr = "Sydney";
    myObjects.add(tmpStr);
    
    // Add two matrices to the ArrayList
    System.out.println("Add 2 matrices to the ArrayList."); 
    Matrix tmpM1 = new Matrix(2, 5);
    Matrix tmpM2 = new Matrix(1, 4);
    myObjects.add(tmpM1);
    myObjects.add(tmpM2);
    
    // Add Tic Tac Toe 
    System.out.println("Add 1 Tic-Tac-Toe board to the ArrayList."); 
    TicTacToe tmpT = new TicTacToe();
    myObjects.add(tmpT);

    System.out.println("\nPrint out what is at each index in the ArrayList:"); 


     //Iterate over the ArrayList and print info about the object stored there
    for (int i = 0; i < myObjects.size(); i++) {
        Object currObj = myObjects.get(i);

        System.out.print("  " + i + ": ");
        if (currObj instanceof Circle) {
            String c = ((Circle) currObj).toString();
            System.out.println(c);
        }
        else if (currObj instanceof String) {
            String s = "Sydney";
            System.out.println("String = " + s);
        }
        else if (currObj instanceof Matrix) {
            String  m = currObj.toString();
            System.out.println(m);
        }
        else if (currObj instanceof TicTacToe) {
            String t = currObj.toString();
            System.out.println(t);
        }
        else {
            System.out.println("Error, unexpected type encountered");
        }
    }
}
}

class Circle {
protected int radius;

public Circle(int radius) {
    this.radius = radius;
}

public double getArea() {
    return radius * radius * (double) Math.PI;
}

public String toString() {
    return String.format("Circle radius = " + this.radius + ", area = " + this.getArea());
}
}

class Matrix {
int[][] inputMatrix;

// Constructor that creates the matrix
Matrix(int row, int column) {
    inputMatrix = new int [row][column];
}

public String toString() {
    return inputMatrix.length + " X " + inputMatrix[0].length + " matrix";
}
}

class TicTacToe extends Matrix {       
TicTacToe() {
    super(3, 3);
		}
	}


