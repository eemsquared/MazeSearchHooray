package MazeSearchHooray;

/**
 * Created by mmcalvarez on 10/23/2017.
 */
public class StraightLine extends Process  {
    public StraightLine(){
        super();
    }

    public StraightLine(Maze maze){
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
            findAdjacentStraight(); //done
            //choose new current square
            super.currentSquare = chooseNewSquare(); //done
            //print new Square check
            System.out.println("new square: ");
            super.currentSquare.printStats();
            i++;
        }
    }


}
