package MazeSearchHooray;

import java.util.ArrayList;

public class Square {

    private int x;
    private int y;
    private int cost;
    private Square parent;
    private ArrayList<Square> neighbors;

    public Square(){
        //constructor
        x = 0;
        y = 0;
        cost = 0;
        parent = null;
        neighbors = null;
    }

    public Square(int x, int y, Square parent, int partialCost){
        //location
        this.x = x;
        this.y = y;
        //parent
        this.parent = parent;
        //cost
        this.cost = parent.getCost() + partialCost;
    }

    public int getCost(){
        return cost;
    }

    public void addNeighbor(Square neighbor){
        neighbors.add(neighbor);
    }

    public Square getParent(){
        return parent;
    }



}
