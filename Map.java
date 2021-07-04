
/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
 READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS


BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Rohit Prabhakaran

Course Section:
*/

package Assignment1;
import java.util.*;

/**
 * 
 * 
 *
 */

public class Map {
	boolean [][] map; 
	private int row;
	private int column;
	private int[][] grid;
	private int dist;
	/**
	 * This is the constructor that constructs the city map, 
	 * which is a grid of row by column.
	 * @param row is the number of east-west streets of the city
	 * @param column is the number of north-south streets of the city
	 */
	public Map(int row, int column) {
		// Please implement the constructor
		this.row=row;
		this.column=column;
		map = new boolean[this.row][this.column];
	}
	/**
	 * This method checks the correctness of the input parameters. If the preconditions are not met 
	 * an exception is thrown, otherwise depending to the direction, it calls 
	 * one of the four recursive functions of goSouthWest, goSouthEast, goNorthWest and goNorthEast.
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre the integer parameters should be in the range of the city grid.(i.e. [0, N) if N is the number of east-west streets and [0, M) if 
	 * M is the number of north-south streets.) 
	 * @exception IllegalArgumentException if any of the precondition did not meet.
	 */
	public String getPath (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(startRow<0 ){
			throw new IllegalArgumentException();
		}
		if(startRow>this.row){
			throw new IllegalArgumentException();
		}
		if(startCol<0 ){
			throw new IllegalArgumentException();
		}
		if(startCol>this.column){
			throw new IllegalArgumentException();
		}
		if(destRow<0){
			throw new IllegalArgumentException();
		}
		if(destRow>this.row){
			throw new IllegalArgumentException();
		}
		if(destCol<0){
			throw new IllegalArgumentException();
		}
		if(destCol>this.column){
			throw new IllegalArgumentException();
		}
		
        if(destRow<=startRow && destCol<=startCol){
			return goSouthWest(startRow, startCol, destRow, destCol, path);
		}
		if(destRow<=startRow && destCol>=startCol){
			return goSouthEast(startRow, startCol, destRow, destCol, path);
		}
		if(destRow>=startRow && destCol>=startCol){
			return goNorthEast(startRow, startCol, destRow, destCol, path);
		}
		if(destRow>=startRow && destCol<=startCol) {
			return goNorthWest(startRow, startCol, destRow, destCol, path);
		}
		
		return null;
		 
	}
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point.  
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol >= destCol </code>
	 */
	
	private String goSouthWest (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
			if(startRow==destRow && startCol==destCol){
				return "";
			}
			else if(startCol!=destCol){
				return "(" + startRow + "," + (startCol-1) + ") " + goSouthWest(startRow,startCol-1,destRow,destCol,path);
			}
			else if(startRow!=destRow){
				return "(" + (startRow-1) + "," + startCol + ") " + goSouthWest(startRow-1,startCol,destRow,destCol,path);
			}
			return null;
	}
	
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol <= destCol </code>
	 */
	private String goSouthEast (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(startRow==destRow && startCol==destCol){
			return "";
		}
		else if(startCol!=destCol){
			return "(" + startRow + "," + (startCol+1) + ") " + goSouthEast(startRow,startCol+1,destRow,destCol,path);
		}
		else if(startRow!=destRow){
			return "(" + (startRow-1) + "," + startCol + ") " + goSouthEast(startRow-1,startCol,destRow,destCol,path);
		}
		return null;
	}
	
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow <= destRow </code> and <code> startCol >= destCol </code>
	 */
	private String goNorthEast (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(startRow==destRow && startCol==destCol){
			return "";
		}
		else if(startCol!=destCol){
			return "(" + startRow + "," + (startCol+1) + ") " + goNorthEast(startRow,startCol+1,destRow,destCol,path);
		}
		else if(startRow!=destRow){
			return "(" + (startRow+1) + "," + startCol + ") " + goNorthEast(startRow+1,startCol,destRow,destCol,path);
		}
		return null;
	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol <= destCol </code>
	 */
	private String goNorthWest (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(startRow==destRow && startCol==destCol){
			return "";
		}
		else if(startCol!=destCol){
			return "(" + startRow + "," + (startCol-1) + ") " + goNorthWest(startRow,startCol-1,destRow,destCol,path);
		}
		else if(startRow!=destRow){
			return "(" + (startRow+1) + "," + startCol + ") " + goNorthWest(startRow+1,startCol,destRow,destCol,path);
		}
		return null;
	}
	
	/**
	 * This method find a path from (startRow, startCol) to a border point of the city. 
	 * Please note that the starting point should be included in the path.
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @return is a path from (starting row, staring col) to a border point of the city. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 */
	public String findPath (int startRow, int startCol){
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		  map[startRow][startCol] = true;
		  String path = "";

	        // generates a random path
	        path = findPathHelper(startRow, startCol, path);
	        System.out.println(" returned path: " + path);
	        return path;
	
	}
	
	/**This the findPathHelper method to generate random path from (startRow, startCol) to a border point of the city. 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @param String path returns path 
	 * @return a random path out of the city
	 */
	private String findPathHelper(int startRow, int startCol,String path) {
		
		 Random rand=new Random(); //to generate random path
	        int n=rand.nextInt(4);
	        if (startRow == 0) {
	        	return "(" + startRow + "," + startCol + ") ";              
	        }
	        else if (startRow+1 == this.row) {
	        	return "(" + startRow + "," + startCol + ") ";                
	        }
	        else if (startCol == 0 ) {
	        	return "(" + startRow + "," + startCol + ") ";               
	        }
	        else if (startCol+1 == this.column) {
	        	return "(" + startRow + "," + startCol + ") ";                
	        }else {
				if(savePathchecker(startRow, startCol)==true)
				{
					if(n==0) {
						return "(" + startRow + "," + startCol + ") " + findPathHelper(startRow+1,startCol, path);
					}
					else if(n==1) {
						return "(" + (startRow) + "," + startCol + ") " + findPathHelper(startRow-1,startCol,path);
					}
					else if(n==2) {
						return "(" + startRow + "," + startCol + ") " + findPathHelper(startRow,startCol+1,path);
					}
						else {
						return "(" + startRow + "," + startCol + ") " + findPathHelper(startRow,startCol-1,path);
					}
				}
				else{
					 return findPathHelper(startRow, startCol, path);
				}
	}      
	}
	
	
	/**To check if the police car catches the self driving car
	 * @param row is the starting row of the path
	 * @param column is the starting column of the path
	 */
	
	public boolean savePathchecker(int row, int column){
		if(this.map[row][column]==true){
			return true;
		}
		else{
			this.map[row][column]=true;
			return false;
		}
	}
	
	
}// end of class
