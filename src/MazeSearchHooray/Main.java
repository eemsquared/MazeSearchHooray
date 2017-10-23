package MazeSearchHooray;

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
		Manhattan manhattan = new Manhattan(file);
        manhattan.processMaze();
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println();
        //StraightLine straightLine = new StraightLine(file);
		//straightLine.processMaze();

	}

}
