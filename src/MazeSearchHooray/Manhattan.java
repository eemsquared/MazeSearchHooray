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
        findSomething('P'); //done; findStart
        findSomething('.'); // done; findEnd
        setStart();
        //add to closed list
        deleteFromOpenList(start);
        int i = 0;
        while (i != 20){
            addToClosedList();//done
            //find adjacent
            findAdjacent(); //done
            //choose new current square
            super.currentSquare = chooseNewSquare(); //done
            //print new Square check
             System.out.println("new square: ");
            super.currentSquare.printStats();
            i++;
        }
    }
}