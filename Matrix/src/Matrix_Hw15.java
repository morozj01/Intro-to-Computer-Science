import java.util.Scanner;

public class Matrix_Hw15 {

	public static void main(String[] args) {
	    int numRows1=0;
		int numColumns1=0;
		Scanner input =new Scanner(System.in);
		 
		//Prompt for #columns and #rows	
			do {
			System.out.print("Enter the number of rows ");
			 numRows1= input.nextInt();
		
			System.out.print("Enter the number of columns ");
			 numColumns1= input.nextInt();
			 
			}
			while(numRows1<1 || numRows1>5 || numColumns1<1 || numColumns1>5);
				
			
			Matrix1 m1 = new Matrix1();
			m1.numColumns = numColumns1;
			m1.numRows = numRows1;
			int[][] matrix1= m1.createMatrix(m1.numColumns, m1.numRows);		
			System.out.println("Here is your matrix: ");
			m1.printMatrix(matrix1);
			
			// Ask for next steps
			printMenu();
			String finish="";
			while (!finish.equalsIgnoreCase("z")){
				System.out.print("What would you like to do next?: ");
				finish=input.next();
				
				//Call Transpose and Print
				if (finish.equalsIgnoreCase("T")){
					System.out.println("Here is your new matrix");
					m1.transpose(matrix1);
				}
				
				//Call Sum and print
				else if (finish.equalsIgnoreCase("C")){
					m1.columnSum(matrix1);
				}
				
				//Call Reverse and Print 
				else if(finish.equalsIgnoreCase("r")){
					m1.reverseRows(matrix1);
				}
				
				//If user enters forbidden value they go back to beginning of loop
				else{
					continue;
				}
			}
			
			//Finish Main
			input.close();
			System.out.println("Thanks come back soon!");

	}
	
	public static void printMenu() {
        System.out.println("\n");
        System.out.println("T transpose   - Rows become colums (and vice versa)");
        System.out.println("C columnSum   - Caclulate the sum of the values in each column");
        System.out.println("R reverseRows - Reverse all elements in every row of the matrix");
        System.out.println("P printMatrix - Print the original matrix");
        System.out.println("Q quit        - Exit the program");
        System.out.println("\n");
    }    
}


/*---------------------- New Class ---------------------*/

class Matrix1 {

int numRows;
int numColumns;


//Create Matrix Function
public int[][] createMatrix(int numColumns, int numRows){
	int[][] matrix1 = new int[numRows][numColumns];
	for (int row=0; row<numRows; row++){
		for (int col=0; col<numColumns; col++){
			String number = Integer.toString(row)+ Integer.toString(col);
			matrix1 [row][col] = Integer.parseInt(number);
		}
	}
	return matrix1;
}

// Print Matrix Function
	public void printMatrix(int [][] matrix ){
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix[i].length; j++) {
		        System.out.printf("%4d"+" ", matrix[i][j]);
		    }
		    System.out.println();
		}
		    
	}
	
// Transpose Function	
	void transpose(int[][] matrix){
		int[][] matrix1 = new int[numColumns][numRows];
		for (int col=0; col<numColumns; col++){
			for (int row=0; row<numRows; row++){
				String number = Integer.toString(row)+ Integer.toString(col);
				matrix1 [col][row] = Integer.parseInt(number);
			}
		}
		printMatrix(matrix1);
	}


//Column Sum Function
	void columnSum(int[][] matrix){
		int[] colSum =new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[i].length; j++){
		        colSum[j] += matrix[i][j];
		    }
		}  
		for (int x=0;x<colSum.length; x++){ 
			int print=colSum[x];
			System.out.print(print+" ");
			
		}
	} 

//Reversal Function
	void reverseRows (int [][] matrix ){
		for(int j = 0; j < matrix.length; j++){
		    for(int i = 0; i < matrix[j].length / 2; i++) {
		        int change = matrix[j][i];
		        matrix[j][i] = matrix[j][matrix[j].length - i - 1];
		        matrix[j][matrix[j].length - i - 1] = change;
		    }
		}
		printMatrix(matrix);
	}
}
