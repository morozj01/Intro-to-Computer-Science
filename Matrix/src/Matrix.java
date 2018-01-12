import java.util.Scanner;
public class Matrix {

	public static int numRows=0;
	public static int numColumns=0;
	public static Scanner input =new Scanner(System.in);
	
	public static void main(String[] args) {
		
		 
	//Prompt for #columns and #rows	
		do {
		System.out.print("Enter the number of rows ");
		 numRows= input.nextInt();
	
		System.out.print("Enter the number of columns ");
		 numColumns= input.nextInt();
		 
		}
		while(numRows<1 || numRows>5 || numColumns<1 || numColumns>5);
			
			
	// Create Matrix	
		int[][] matrix1 = new int[numRows][numColumns];
			for (int row=0; row<numRows; row++){
				for (int col=0; col<numColumns; col++){
					String number = Integer.toString(row)+ Integer.toString(col);
					matrix1 [row][col] = Integer.parseInt(number);
				}
			}
			 
		System.out.println("Here is your matrix: ");
		printMatrix(matrix1);
		
		// Ask for next steps
		String finish="";
		while (!finish.equalsIgnoreCase("z")){
			System.out.print("What would you like to do next?: ");
			finish=input.next();
			
			//Call Transpose and Print
			if (finish.equalsIgnoreCase("T")){
				int[][] matrix2=transpose(matrix1);
				System.out.println("Here is your new matrix");
				printMatrix(matrix2);
			}
			
			//Call Sum and print
			else if (finish.equalsIgnoreCase("C")){
				int[] sum = columnSum(matrix1);
				for (int i=0; i<sum.length; i++){
					System.out.print(sum[i]+" ");
				}
			}
			
			//Call Reverse and Print 
			else if(finish.equalsIgnoreCase("r")){
				int[][] matrix2=reverseRows(matrix1);
				printMatrix(matrix2);
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
/* ---------------------- End of Main ---------------------------*/

// Print Matrix Function
	public static void printMatrix(int [][] matrix ){
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix[i].length; j++) {
		        System.out.printf("%4d"+" ", matrix[i][j]);
		    }
		    System.out.println();
		}
		    
	}
	
// Transpose Function	
	public static int[][] transpose(int[][] matrix){
		int[][] matrix1 = new int[numColumns][numRows];
		for (int col=0; col<numColumns; col++){
			for (int row=0; row<numRows; row++){
				String number = Integer.toString(row)+ Integer.toString(col);
				matrix1 [col][row] = Integer.parseInt(number);
			}
		}
		return matrix1;
	}


//Column Sum Function
	public static int [] columnSum(int[][] matrix){
		int[] colSum =new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[i].length; j++){
		        colSum[j] += matrix[i][j];
		    }
		}  
	return colSum;
	} 

//Reversal Function
	public static int [][] reverseRows (int [][] matrix ){
		for(int j = 0; j < matrix.length; j++){
		    for(int i = 0; i < matrix[j].length / 2; i++) {
		        int change = matrix[j][i];
		        matrix[j][i] = matrix[j][matrix[j].length - i - 1];
		        matrix[j][matrix[j].length - i - 1] = change;
		    }
		}
		return matrix;
	}
}















