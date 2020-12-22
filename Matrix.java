// *****    ***
// *** **   ***
// ***  **  ***
// ***   ** ***
// ***    *****

package Matrix;
/**
 *
 * @author 2018-2197
 */
import java.util.Scanner;
public class Matrix{
	public static void main(String[] args) {
  	AddingMatrix addmatrix = new AddingMatrix();
  	
  	
  	Scanner reader = new Scanner (System.in);
  	String choice;
  	do{
      	System.out.println("1 - Adding Matrix\nEnter Your Choice!");
      	int choi = reader.nextInt();
      	
      	if (choi == 1){
         	addmatrix.SetNumberMatrix();
        	
      	}
      	
      	System.out.println("Y/N or y/n");
      	choice = reader.next();  
      	
      	
  	}
  	while(choice == "Y" || choice == "y" );
	}
 
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrix;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author 2018-2197
 */

public class AddingMatrix {
  int numMatrix;
  int [] rows,columns;
  ArrayList <int []> matrices;
 
  public static Scanner reader = new Scanner (System.in);
 
 
  public void SetNumberMatrix(){
 
  System.out.println("Enter the Number of Matrix:"); 
  this.numMatrix = reader.nextInt();
  this.matrices = new ArrayList<int []>(this.numMatrix);
  this.rows = new int [this.numMatrix];
  this.columns = new int[this.numMatrix];
 
  CreateMatrix();
  }
 
 
  public void CreateMatrix(){
	
   int row,column;
   int [] matrix;
  
   for (int i = 0; i < this.numMatrix; i++){
   	System.out.print("\nCreating Matrix" + (i+1));
   	
   	System.out.println("\nEnter the Number of Rows:");
   	row = reader.nextInt();
   	
   	this.rows[i] = row;
   	
   	System.out.println("Enter the Number of Columns");
   	column = reader.nextInt();
   	this.columns[i] = column;
   	
   	
   	matrix = new int [row*column];
   	System.out.print("Input data of the Matrix:");
   	for (int x = 0; x < matrix.length; x++){
       	matrix[x] = reader.nextInt();
   	}
   	
   	
   	System.out.println("\nTable of Matrix" + (i+1)+ ":");
   	for (int y = 0; y < row*column; y+= column){
       	for (int z = 0; z < column; z++){
           	System.out.print(matrix[(y+z)] + "\t");
       	}
       	System.out.println();
   	}
   	this.matrices.add(matrix);
   }
  
   CheckDimension();
  }
 
  public void CheckDimension(){
  	int counter = 1;
  	boolean tester = false;
  	
  	System.out.println("Check if All Matrices had the same dimension\n");
  	
  	while (counter < this.numMatrix){
      	
      	if (this.rows[0] == this.rows[(counter)] && this.columns[0] == this.columns[(counter)]){
        	System.out.print("\nMatrix 1 Dimension:"+ this.rows[0] + "X" +this.columns[0] + " is Equal To " +
        	"Matrix" + (counter+1) + " Dimension:" + this.rows[(counter)] +"X" + this.columns[(counter)]);
        	tester = true;
        	}
      	else{
          	System.out.print("\nMatrix 1 Dimension:"+ this.rows[0] + "X" +this.columns[0] + " is Not Equal To " +
          	"Matrix" + (counter+1) + " Dimension:" + this.rows[counter] +"X" + this.columns[counter]);
          	System.exit(0);
      	}
     	counter ++;
 	
  	}
  	if (tester == true){
          	AddMatrix();
      	}
  	
  }
 
 
  public void AddMatrix(){
 	int [] total = new int [1];
 	
 	total = this.matrices.get(0);
 	this.matrices.remove(0);
 	
 	System.out.print("\nAdding Matrix\n");
 	int counter = 1;
 	while (this.matrices.size() != 0){
     	
     	for (int i = 0; i < total.length; i ++){
       	int [] second = new int [1];
       	second = this.matrices.get(0);
       	total[i] = total[i] + second[i];
     	}
     	System.out.println("Sum"+ counter);
     	
     	for (int x = 0; x < this.rows[0]*this.columns[0]; x+= this.columns[0]){
         	for (int y = 0; y < this.columns[0]; y++){
             	System.out.print(total[(x+y)] +"\t");
         	}
         	System.out.println();
         	
     	}
     	counter++;
     	this.matrices.remove(0);
 	}
  	
 	System.out.println("\nTotal Sum of Matrices");
 	for (int x = 0; x < this.rows[0] * this.columns[0]; x+= this.columns[0]){
     	for (int y = 0; y < this.columns[0]; y++){
         	System.out.print(total[x+y] + "\t");
     	}
     	System.out.println();
 	}
  }
 
}

	
}
