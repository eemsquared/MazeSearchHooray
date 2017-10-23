package MazeSearchHooray;

import java.util.ArrayList;

public class Process {

    Maze maze;
    char[][] charMaze;

    Square start;
    Square end;
    Square currentSquare;

    ArrayList<Square> closedList;
    ArrayList<Square> openList;

    public Process(){
        //constructor
    }

    public Process(Maze maze){
        this.maze = maze;
        charMaze = maze.getArrayMaze();
        closedList = new ArrayList<>();
        openList = new ArrayList<>();
    }

    public void setStart(){
        currentSquare = start;
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
                        System.out.print("START: ");
                        start.printStats();
                    }else if (findThis == 'P') {
                        Square newEnd = new Square(roww, coll, null, 0, 0, 0);
                        this.end = newEnd;
                        System.out.print("END: ");
                        end.printStats();
                    }
                }
            }
        }
    }

    public void addToClosedList(){
        closedList.add(currentSquare);
    }

    public void findAdjacent() {

        int currentRow = currentSquare.getRoww();
        int currentColumn = currentSquare.getColl();
        //UP
        if (charMaze[currentRow-1][currentColumn] == ' ') {
            int gCost = currentSquare.getgCost() + 10;
            int hCost = findHCost(currentRow - 1, currentColumn);
            int totalCost = gCost + hCost;
            Square square = new Square(currentRow - 1, currentColumn, currentSquare, gCost, hCost, totalCost);

            if (closedList.contains(square) == false){
                currentSquare.addNeighbor(square);
                openList.add(square);
            }

        }
        //DOWN
        if (charMaze[currentRow+1][currentColumn] == ' ') {
            int gCost = currentSquare.getgCost() + 10;
            int hCost = findHCost(currentRow + 1, currentColumn);
            int totalCost = gCost + hCost;
            Square square = new Square(currentRow + 1, currentColumn, currentSquare, gCost, hCost, totalCost);

            if (closedList.contains(square) == false){
                currentSquare.addNeighbor(square);
                openList.add(square);
            }

        }
        //LEFT
        if (charMaze[currentRow][currentColumn-1] == ' ') {
            int gCost = currentSquare.getgCost() + 10;
            int hCost = findHCost(currentRow, currentColumn-1);
            int totalCost = gCost + hCost;
            Square square = new Square(currentRow, currentColumn-1, currentSquare, gCost, hCost, totalCost);

            if (closedList.contains(square) == false){
                currentSquare.addNeighbor(square);
                openList.add(square);
            }

        }
        //RIGHT
        if (charMaze[currentRow][currentColumn+1] == ' ') {
            int gCost = currentSquare.getgCost() + 10;
            int hCost = findHCost(currentRow, currentColumn+1);
            int totalCost = gCost + hCost;
            Square square = new Square(currentRow, currentColumn + 1, currentSquare, gCost, hCost, totalCost);

            if (closedList.contains(square) == false){
                currentSquare.addNeighbor(square);
                openList.add(square);
            }

        }
        //DIAGONAL UPPER LEFT
        if (charMaze[currentRow-1][currentColumn-1] == ' ') {
            int gCost = currentSquare.getgCost() + 14;
            int hCost = findHCost(currentRow - 1, currentColumn - 1);
            int totalCost = gCost + hCost;
            Square square = new Square(currentRow - 1, currentColumn - 1, currentSquare, gCost, hCost, totalCost);
            if (closedList.contains(square) == false){
                currentSquare.addNeighbor(square);
                openList.add(square);
            }
        }
        //DIAGONAL UPPER RIGHT
        if (charMaze[currentRow-1][currentColumn+1] == ' ') {
            int gCost = currentSquare.getgCost() + 14;
            int hCost = findHCost(currentRow - 1, currentColumn + 1);
            int totalCost = gCost + hCost;
            Square square = new Square(currentRow - 1, currentColumn + 1, currentSquare, gCost, hCost, totalCost);
            if (closedList.contains(square) == false){
                currentSquare.addNeighbor(square);
                openList.add(square);
            }
        }
        //DIAGONAL LOWER LEFT
        if (charMaze[currentRow+1][currentColumn-1] == ' ') {
            int gCost = currentSquare.getgCost() + 14;
            int hCost = findHCost(currentRow + 1, currentColumn - 1);
            int totalCost = gCost + hCost;
            Square square = new Square(currentRow + 1, currentColumn - 1, currentSquare, gCost, hCost, totalCost);
            if (closedList.contains(square) == false){
                currentSquare.addNeighbor(square);
                openList.add(square);
            }
        }
        //DIAGONAL LOWER RIGHT
        if (charMaze[currentRow+1][currentColumn+1] == ' ') {
            int gCost = currentSquare.getgCost() + 14;
            int hCost = findHCost(currentRow + 1, currentColumn + 1);
            int totalCost = gCost + hCost;
            Square square = new Square(currentRow + 1, currentColumn + 1, currentSquare, gCost, hCost, totalCost);
            if (closedList.contains(square) == false){
                currentSquare.addNeighbor(square);
                openList.add(square);
            }
        }

        //check
        System.out.println("Neighbors: ");
        for (Square s: currentSquare.getNeighbors()){
            s.printStats();
        }

    }

    public void deleteFromOpenList(Square s){
        openList.remove(s);
    }

    //TODO
    public Square chooseNewSquare(){
        Square next = new Square();
        for (Square s: currentSquare.getNeighbors()){
            if (openList.contains(s)) {
                if (next.getTotalCost() > s.getTotalCost()){
                    next = s;
                } else if (next.getTotalCost() == s.getTotalCost()){
                    if (next.getRoww() > s.getRoww()){
                        next = s;
                    } else if (next.getColl() > s.getColl()){
                        next = s;
                    }
                }
            }
        }
        return next;
    }

    public int findHCost(int row, int col){
        return Math.abs((row - end.getRoww())+ (col - end.getColl())) * 10;
    }
}




