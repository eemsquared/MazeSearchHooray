package MazeSearchHooray;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Maze file = new Maze();
		char[][] arrayFile = file.getArrayFile("smallMaze.txt");
		int row = file.getRowSize();
		int col = file.getColSize();

		for (int roww = 0, coll = 0; roww < row; roww++){
			for (coll = 0; coll < col; coll++){
				System.out.print(arrayFile[roww][coll]);
			}
			System.out.println();
		}

		//comment out the heuristics that will be used

		/*
		Manhattan manhattan = new Manhattan(arrayFile, row, col);
		manhattan.findStart();
		System.out.println();
		manhattan.findGoal();

		while (manhattan.goalNotFound()){
			manhattan.findNeighbors();
			manhattan.chooseNewSquare();
		}

		int size = manhattan.getClosedListSize();
		System.out.println("\nClosed List size: " + size);

		int openList_size = manhattan.getOpenListSize();
		System.out.println("Open List size: " + openList_size);
		*/

		/*
		StraightLine straight = new StraightLine (arrayFile, row, col);
		straight.findStart();
		System.out.println();
		straight.findGoal();

		while (straight.goalNotFound()){
			straight.findNeighbors();
			straight.chooseNewSquare();
		}

		int closedList_size = straight.getClosedListSize();
		System.out.println("\nClosed List size: " + closedList_size);

		int openList_size = straight.getOpenListSize();
		System.out.println("Open List size: " + openList_size);
		*/

		//part 2

        /*
		ManhattanSearch manhattanSearch = new ManhattanSearch(arrayFile, row, col);
		manhattanSearch.findStart();
		System.out.println();
		ArrayList<Square> goals = manhattanSearch.findMultipleGoals();

		for (int z = 0; z < goals.size(); z++){
			manhattanSearch.setCurrentGoal(goals.get(z));
			manhattanSearch.setStart(manhattanSearch.getCurrent());
			manhattanSearch.reset();
			while (manhattanSearch.goalNotFound()){
				manhattanSearch.findNeighbors();
				manhattanSearch.chooseNewSquare();
			}
		}
        */



	}
}
