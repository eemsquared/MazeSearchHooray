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

    }
}