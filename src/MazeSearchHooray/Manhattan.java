package MazeSearchHooray;

public class Manhattan extends Process{

    public Manhattan() {
        //constructor
        super();
    }

    public Manhattan(Maze maze){
        super(maze);
    }

    public void processMaze() {
        findSomething('.'); //done; findStart
        findSomething('P'); // done; findEnd
        setStart();
        //add to closed list
        int i = 0;
        while (i != 15){
            addToClosedList(); //done
            //find adjacent
            findAdjacent(); //done
            //choose new current square
            super.currentSquare = chooseNewSquare(); //done
            deleteFromOpenList(super.currentSquare);
            //print new Square check
             System.out.println("new square: ");
            super.currentSquare.printStats();
            i++;
        }
    }
}