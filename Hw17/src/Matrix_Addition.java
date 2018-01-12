
import java.util.Scanner;

public class Matrix_Addition {
	 public static void main(String[] args){
	        
	        Scanner input = new Scanner(System.in);
	        int rows;
	        int cols;
	        boolean badInputs = false;
	        
	        do {
	            badInputs = false;
	            System.out.println("\nHow many rows in your matrix? (Between 1 and 5 rows).\n");
	            rows = input.nextInt();
	            
	            System.out.println("How many columns in your matrix? (Between 1 and 5 columns).");
	            cols = input.nextInt();
	            
	            if (rows < 1 || rows > 5 || cols < 1 || cols > 5) {
	                badInputs = true;
	                System.out.println("\nThe number of rows and/or the number of columns is < 1 or > 5. Please try again.\n");
	            }
	        } while (badInputs);
	            
	        Matrix m1 = new Matrix(rows, cols);
	        m1.printMatrix();

	        String userInput = " ";
	        do {
	            printMenu();
	            userInput = input.next().toUpperCase();

	            switch(userInput) {
	            case("T"): 
	                m1.transpose();
	                break; 
	            case("C"): 
	                m1.columnSum();
	                break; 
	            case("R"): 
	                m1.reverseRows();
	                break; 
	            case("P"): 
	                m1.printMatrix();
	                break;
	            case("AR"): 
	                m1.add(m1.reverseRows());
	                break;
	            case("AN"):
	                System.out.println("Enter the integer value to add to each element of the Matrix: ");
	                int numToAdd = input.nextInt();
	                input.nextLine();
	                m1.setNum(numToAdd);
	                m1.add();
	                break;
	            case("Q"): 
	                input.close();
	                break;
	            default:
	                System.out.println("\nError, invalid input. Enter: T, C, R, P, or Q\n");
	                break;
	            }
	        } while (!userInput.equals("Q"));
	    }
	    
	    public static void printMenu() {
	        System.out.println("\n");
	        System.out.println("T  transpose   - Rows become colums (and vice versa)");
	        System.out.println("C  columnSum   - Caclulate the sum of the values in each column");
	        System.out.println("R  reverseRows - Reverse all elements in every row of the matrix");
	        System.out.println("P  printMatrix - Print the original matrix");
	        System.out.println("AR addReverse  - Add reverse of matrix to original matrix");
	        System.out.println("AN addNum      - Add a number to each element of the original matrix");
	        System.out.println("Q quit         - Exit the program");
	        System.out.println("\n");
	    }    
	}

	class Matrix  {
		int[] sum;
	    int[][] inputMatrix;
	    private int numToAdd = 0; 
	    
	    // Constructor that initializes the matrix to 0 1 2, then 10 11 12, then 20 21 22, ...
	    Matrix(int row, int column) {
	    	int[][] Matrix = new int[row][column];
	    	for (int rows=0; rows<row; rows++){
	    		for (int col=0; col<column; col++){
	    			String number = Integer.toString(rows)+ Integer.toString(col);
	    			Matrix [rows][col] = Integer.parseInt(number);
	    		}
	    	}
	    	this.inputMatrix = Matrix;
	    }
	    
	 
	    // Setter for numToAdd
	    void setNum(int num) {
	      numToAdd = num;
	    }
	    
	    public int getNum(){
	    	return numToAdd;
	    }
	    
	    void printMatrix() {
	        for (int i = 0; i < inputMatrix.length; i++) {
	            System.out.println();
	            for (int j = 0; j < inputMatrix[i].length ; j++) {
	                System.out.printf("%5d", inputMatrix[i][j]);
	            }
	        }
	        System.out.println();
	    }

	    void transpose() {
	        Matrix mtran = new Matrix(inputMatrix[0].length, inputMatrix.length);
	        for (int col=0; col<inputMatrix[0].length; col++){
				for (int row=0; row<inputMatrix.length; row++){
					String number = Integer.toString(row)+ Integer.toString(col);
					mtran.inputMatrix[col][row] = Integer.parseInt(number);
				}
			}
			mtran.printMatrix();
		}

	    void columnSum() {
	        Matrix columnSum = new Matrix(1, inputMatrix[0].length);
			for (int i = 0; i < inputMatrix.length; i++){
				for (int j = 0; j < inputMatrix[0].length; j++){
					 columnSum.inputMatrix[0][j] += inputMatrix[i][j];
			    }
			} 
	        columnSum.printMatrix();
	    }

	    Matrix reverseRows() {
	        Matrix mrev = new Matrix(inputMatrix.length, inputMatrix[0].length);
	        for(int j = 0; j < inputMatrix.length; j++){
			    for(int i = 0; i < inputMatrix[j].length / 2; i++) {
			        int change = inputMatrix[j][i];
			        mrev.inputMatrix[j][i] = inputMatrix[j][inputMatrix[j].length - i - 1];
			        mrev.inputMatrix[j][mrev.inputMatrix[j].length - i - 1] = change;
			    }
			}
	        mrev.printMatrix();
	        return mrev;
	        // TODO: return the reversed matrix
	    }
	    
	    // Note the overloaded add() method:
	    void add(Matrix mat) {
	        Matrix sum = new Matrix(inputMatrix.length, inputMatrix[0].length);
	        for(int i = 0; i<sum.inputMatrix.length; i++){
	        	for(int j = 0; j<sum.inputMatrix[0].length; j++){
	        				sum.inputMatrix[i][j]+= mat.inputMatrix[i][j];
	        			}
	        		}
	        sum.printMatrix();
	    }
	    
	    void add() {
	        Matrix inc = new Matrix(inputMatrix.length, inputMatrix[0].length);
	        inc.numToAdd = getNum();
	        for (int i=0; i<inc.inputMatrix.length; i++){
	        	for (int j=0; j<inc.inputMatrix[0].length; j++){
	        		inc.inputMatrix[i][j]+=inc.numToAdd;
	        	}
	        }
	        inc.printMatrix();
	    }	

}	 