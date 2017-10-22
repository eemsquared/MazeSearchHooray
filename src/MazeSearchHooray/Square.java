package MazeSearchHooray;

import java.util.ArrayList;

public class Square {

    private int roww;
    private int coll;
    private int gCost;
    private int hCost;
    private int totalCost;
    private Square parent;
    private ArrayList<Square> neighbors = new ArrayList<>();

    public Square(){
        //constructor
        roww = 0;
        coll = 0;
        gCost = 0;
        hCost = 0;
        totalCost = 0;
        parent = null;
    }

    public Square(int x, int y, Square parent, int gCost, int hCost, int totalCost){
        //location
        this.roww = x;
        this.coll = y;
        //parent
        this.parent = parent;
        //cost
        this.gCost = gCost;
        this.hCost = hCost;
        this.totalCost = totalCost;
        /*
        if (parent != null)
            this.gCost = parent.getgCost() + partialCost;
        else
            this.gCost = 0;
        */
    }

    public void printStats(){
        System.out.println("Row: "+roww+"\nColumn: "+coll+"\nG(x): "+gCost+"\nH(x): "+hCost+"\nTotal Cost: "+totalCost);
        if (parent != null){
            System.out.println("Parent: "+parent.getRoww()+", "+parent.getColl());
        }
    }
    public ArrayList<Square> getNeighbors(){
        return neighbors;
    }

    public void setTotalCost(int totalCost){
        this.totalCost = totalCost;
    }

    public void setRoww(int roww){
        this.roww = roww;
    }

    public void setColl(int coll){
        this.coll = coll;
    }

    public void setParent(Square parent){
        this.parent = parent;
    }

    public int getRoww(){
        return roww;
    }

    public int getColl(){
        return coll;
    }

    public int getgCost(){
        return gCost;
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
