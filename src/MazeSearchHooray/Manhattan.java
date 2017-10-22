package MazeSearchHooray;

public class Manhattan extends Process{

    public Manhattan() {
        //constructor
        super();
    }

    public Manhattan(Maze maze){
        super(maze);
    }

    public void process() {
        findSomething('.'); //done; findStart
        findSomething('P'); // done; findEnd
        currentSquare = start;
        //add to closed list
        int i = 0;
        while (i != 15){
            addToClosedList(); //done
            //find adjacent
            findAdjacent(); //done
            //choose new current square
            currentSquare = chooseNewSquare(); //done
            deleteFromOpenList(currentSquare);
            //print new Square check
            System.out.println("new square: ");
            currentSquare.printStats();
            i++;
        }
    }
}