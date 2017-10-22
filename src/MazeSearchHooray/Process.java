package MazeSearchHooray;

public class Process {

    Maze maze;
    char[][] charMaze;
    Square start;
    Square end;

    public Process(){
        //constructor
    }

    public Process(Maze maze){
        this.maze = maze;
        charMaze = maze.getArrayMaze();
    }

    public void findSomething(char findThis){
        int row = maze.getRowSize();
        int col = maze.getColSize();
        for (int roww = 0, coll = 0; roww < row; roww++){
            for (coll = 0; coll < col; coll++){
                if (charMaze[roww][coll] == findThis){
                    if (findThis == '.') {
                        Square newStart = new Square(roww, coll, null, 0, 0, 0);
                        this.start = newStart;
                        start.printStats();
                    }else if (findThis == 'P') {
                        Square newEnd = new Square(roww, coll, null, 0, 0, 0);
                        this.end = newEnd;
                        end.printStats();
                    }
                }
            }
        }    }

}
