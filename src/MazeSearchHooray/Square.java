package MazeSearchHooray;

import javafx.scene.Parent;

import java.util.ArrayList;

public class Square {

    private int x;
    private int y;
    private int cost;
    private int totalCost;
    private Square parent;
    private ArrayList<Square> neighbors;

    public Square(){
        //constructor
        x = 0;
        y = 0;
        cost = 0;
        totalCost = 0;
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
        if (parent != null)
            this.cost = parent.getCost() + partialCost;
        else
            this.cost = 0;
    }

    public ArrayList<Square> getNeighbors(){
        return neighbors;
    }

    public void setTotalCost(int totalCost){
        this.totalCost = totalCost;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setParent(Square parent){
        this.parent = parent;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getCost(){
        return cost;
    }

    public int getTotalCost(){
        return totalCost;
    }

    public void addNeighbor(Square neighbor){
        neighbors.add(neighbor);
    }

    public Square getParent(){
        return parent;
    }



}
