package Assignment1;
import java.util.*;

public class Map1 {

	/**
	 * 
	 * @author EECS2030 Team
	 *
	 */

		boolean[][] map;
		private int row;
		private int column;

		/**
		 * This is the constructor that constructs the city map, which is a grid of row
		 * by column.
		 * 
		 * @param row    is the number of east-west streets of the city
		 * @param column is the number of north-south streets of the city
		 */
		public Map1(int row, int column) {
			this.row = row - 1;
			this.column = column - 1;
			map = new boolean[this.row][this.column];

		}

		/**
		 * This method checks the correctness of the input parameters. If the
		 * preconditions are not met an exception is thrown, otherwise depending to the
		 * direction, it calls one of the four recursive functions of goSouthWest,
		 * goSouthEast, goNorthWest and goNorthEast.
		 * 
		 * @param startRow is the starting row of the path
		 * @param startCol is the starting column of the path
		 * @param destRow  is the destination row
		 * @param destCol  is the destination column
		 * @param path     is the path that is constructed while the recursive method is
		 *                 called. In first round, it will be "".
		 * @return returns a string representing the path to the destination. The format
		 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
		 * @pre the integer parameters should be in the range of the city grid.(i.e. [0,
		 *      N) if N is the number of east-west streets and [0, M) if M is the number
		 *      of north-south streets.)
		 * @exception IllegalArgumentException if any of the precondition did not meet.
		 */
		public String getPath(int startRow, int startCol, int destRow, int destCol, String path) {
			String returnedString = "";

			if (startRow > this.row || startRow < 0)
				throw new IllegalArgumentException();
			else if (destRow > this.row || destRow < 0)
				throw new IllegalArgumentException();
			else if (startCol > this.column || startCol < 0)
				throw new IllegalArgumentException();
			else if (destCol > this.column || destCol < 0)
				throw new IllegalArgumentException();
			else {
				if (startRow <= destRow && startCol <= destCol)
					returnedString = goNorthEast(startRow, startCol, destRow, destCol, path);
				else if (startRow <= destRow && startCol >= destCol)
					returnedString = goNorthWest(startRow, startCol, destRow, destCol, path);
				else if (startRow >= destRow && startCol <= destCol)
					returnedString = goSouthEast(startRow, startCol, destRow, destCol, path);
				else
					returnedString = goSouthWest(startRow, startCol, destRow, destCol, path);

//				System.out.print("getPath: " + returnedString);
				return returnedString;
			}

		}

		/**
		 * This method returns a path from the source (startRow, startCol) to the
		 * destination (destRow, destCol). Please note that the returning path does not
		 * include the starting point.
		 * 
		 * @param startRow is the starting row of the path
		 * @param startCol is the starting column of the path
		 * @param destRow  is the destination row
		 * @param destCol  is the destination column
		 * @param path     is the path that is constructed while the recursive method is
		 *                 called. In first round, it will be "".
		 * @return returns a string representing the path to the destination. The format
		 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
		 * @pre <code> startRow >= destRow </code> and
		 *      <code> startCol >= destCol </code>
		 */

		private String goSouthWest(int startRow, int startCol, int destRow, int destCol, String path) {
			if (startRow == destRow && startCol == destCol) {
//				System.out.println(path);
				return path;
			}

			else if (startRow > destRow) {
				path += "(" + (startRow - 1) + "," + startCol + ") ";
				return goSouthWest((startRow - 1), startCol, destRow, destCol, path);
			}

			else {
				path += "(" + startRow + "," + (startCol - 1) + ") ";
				return goSouthWest(startRow, (startCol - 1), destRow, destCol, path);
			}

		}

		/**
		 * This method returns a path from the source (startRow, startCol) to the
		 * destination (destRow, destCol). Please note that the returning path does not
		 * include the starting point.
		 * 
		 * @param startRow is the starting row of the path
		 * @param startCol is the starting column of the path
		 * @param destRow  is the destination row
		 * @param destCol  is the destination column
		 * @param path     is the path that is constructed while the recursive method is
		 *                 called. In first round, it will be "".
		 * @return returns a string representing the path to the destination. The format
		 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
		 * @pre <code> startRow >= destRow </code> and
		 *      <code> startCol <= destCol </code>
		 */
		private String goSouthEast(int startRow, int startCol, int destRow, int destCol, String path) {
			if (startRow == destRow && startCol == destCol) {
//				System.out.println(path);
				return path;
			}

			else if (startRow > destRow) {
				path += "(" + (startRow - 1) + "," + startCol + ") ";
				return goSouthEast((startRow - 1), startCol, destRow, destCol, path);
			}

			else {
				path += "(" + startRow + "," + (startCol + 1) + ") ";
				return goSouthEast(startRow, (startCol + 1), destRow, destCol, path);
			}
		}

		/**
		 * This method returns a path from the source (startRow, startCol) to the
		 * destination (destRow, destCol). Please note that the returning path does not
		 * include the starting point.
		 * 
		 * @param startRow is the starting row of the path
		 * @param startCol is the starting column of the path
		 * @param destRow  is the destination row
		 * @param destCol  is the destination column
		 * @param path     is the path that is constructed while the recursive method is
		 *                 called. In first round, it will be "".
		 * @return returns a string representing the path to the destination. The format
		 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
		 * @pre <code> startRow <= destRow </code> and
		 *      <code> startCol <= destCol </code>
		 */
		private String goNorthEast(int startRow, int startCol, int destRow, int destCol, String path) {
			if (startRow == destRow && startCol == destCol) {
//				System.out.println(path);
				return path;
			}

			else if (startRow < destRow) {
				path += "(" + (startRow + 1) + "," + startCol + ") ";
				return goNorthEast((startRow + 1), startCol, destRow, destCol, path);
			}

			else {
				path += "(" + startRow + "," + (startCol + 1) + ") ";
				return goNorthEast(startRow, (startCol + 1), destRow, destCol, path);
			}
		}

		/**
		 * This method returns a path from the source (startRow, startCol) to the
		 * destination (destRow, destCol). Please note that the returning path does not
		 * include the starting point.
		 * 
		 * @param startRow is the starting row of the path
		 * @param startCol is the starting column of the path
		 * @param destRow  is the destination row
		 * @param destCol  is the destination column
		 * @param path     is the path that is constructed while the recursive method is
		 *                 called. In first round, it will be "".
		 * @return returns a string representing the path to the destination. The format
		 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
		 * @pre <code> startRow >= destRow </code> and
		 *      <code> startCol <= destCol </code>
		 */
		private String goNorthWest(int startRow, int startCol, int destRow, int destCol, String path) {
			if (startRow == destRow && startCol == destCol) {
//				System.out.println(path);
				return path;
			}

			else if (startRow < destRow) {
				path += "(" + (startRow + 1) + "," + startCol + ") ";
				return goNorthWest((startRow + 1), startCol, destRow, destCol, path);
			}

			else {
				path += "(" + startRow + "," + (startCol - 1) + ") ";
				return goNorthWest(startRow, (startCol - 1), destRow, destCol, path);
			}
		}

		/**
		 * This method find a path from (startRow, startCol) to a border point of the
		 * city. Please note that the starting point should be included in the path.
		 * 
		 * @param startRow is the starting row of the path
		 * @param startCol is the starting column of the path
		 * @return is a path from (starting row, staring col) to a border point of the
		 *         city. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
		 */

		public String findPath(int startRow, int startCol) {
			boolean duplicate = true;
			String path = "";

			while (duplicate == true) {
				duplicate = false;
				ArrayList<String> intersectionList = new ArrayList<String>();

				// generates a random path
				path = randomPath(startRow, startCol, "");

				// maps each intersection from the path to the array list
				for (int i = 0; i < path.length() / 6; i++) {
					intersectionList.add(path.substring(i * 6, (i * 6) + 6));
				}

				// checks for duplicates
				for (int j = 0; j < intersectionList.size(); j++) {
					for (int k = j + 1; k < intersectionList.size(); k++) {
						if (intersectionList.get(j).equals(intersectionList.get(k))) {
							duplicate = true;
						}
					}
				}

				System.out.println("\n arr: " + intersectionList);
				System.out.println(" p: " + path);
			}

			System.out.println(" returned: " + path);
			return path;

		}

		/**
		 * This is a helper method for findPath that picks a random direction for the
		 * car to go.
		 * 
		 * @param currentRow is the row of the path where the car currently is
		 * @param currentCol is the column of the path where the car currently is
		 * @param path       is the path that is constructed while the recursive method
		 *                   is called
		 * @return is a path from (starting row, staring col) to a border point of the
		 *         city. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
		 */

		private String randomPath(int currentRow, int currentCol, String path) {
			// return if either currentRow or currentCol is on the edge of the map
			if (currentRow == 0 || currentRow == this.row || currentCol == 0 || currentCol == this.column) {
//				System.out.println(path);
				return path;
			}

			// pick a random direction
			else {
				double randomDir = Math.random();

				if (randomDir < 0.25) {
					path += "(" + currentRow + "," + currentCol + ") ";
					return randomPath(currentRow + 1, currentCol, path);
				} else if (randomDir < 0.5) {
					path += "(" + currentRow + "," + currentCol + ") ";
					return randomPath(currentRow - 1, currentCol, path);
				} else if (randomDir < 0.75) {
					path += "(" + currentRow + "," + currentCol + ") ";
					return randomPath(currentRow, currentCol + 1, path);
				} else {
					path += "(" + currentRow + "," + currentCol + ") ";
					return randomPath(currentRow, currentCol - 1, path);
				}
			}

		}

	} // end of class

