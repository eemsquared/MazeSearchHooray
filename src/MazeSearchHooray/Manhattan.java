package MazeSearchHooray;

import java.util.ArrayList;

public class Manhattan {

    private char[][] partial;
    private Square start = null;
    private Square end = null;
    private ArrayList<Square> openList;
    private ArrayList<Square> closedList;

    public Manhattan(){
        //constructor
    }

    public void process(){

        partial = new char[7][7];
        for (int i = 0; i < 7; i++){
            partial[i][0] = '%';
        }
        for (int i = 0; i < 7; i++){
            partial[0][i] = '%';
        }
        for (int i = 0; i < 7; i++) {
            partial[6][i] = '%';
        }
        for (int i = 0; i < 7; i++){
            partial[i][6] = '%';
        }

        for (int i = 1; i < 6; i++){
            if (i != 5){
                partial[i][1] = ' ';
            }else{
                partial[i][1] = 'P';
            }
        }

        for (int i = 1; i < 6; i++){
            if (i == 2 || i == 3 || i == 4){
                partial[i][2] = '%';
            }else{
                partial[i][2] = ' ';
            }
        }

        for (int i = 1; i < 6; i++){
            if (i == 3){
                partial[i][3] = '%';
            }else{
                partial[i][3] = ' ';
            }
        }

        for (int i = 1; i < 6; i++){
            if (i == 1 || i == 5){
                partial[i][4] = '%';
            }else{
                partial[i][4] = ' ';
            }
        }
        for (int i = 1; i < 6; i++){
            if (i == 1){
                partial[i][5] = '.';
            }else if (i == 3 || i == 4 || i == 5){
                partial[i][5] = '%';
            }else{
                partial[i][5] = ' ';
            }
        }


        //print array

        for (int i = 0, j = 0;j < 7; j++){
            for (i = 0; i < 7; i++){
                System.out.print(partial[i][j]);
            }
            System.out.println();
        }

        startProcess();
    }

    public void startProcess(){

        //first step: Find P
        this.start = findStart();
        this.end = findGoal();
        //start loop
        Square currentSquare = new Square();
        currentSquare = this.start;
        closedList.add(currentSquare);

        while (partial[currentSquare.getX()][currentSquare.getY()] != '.'){
            int curX = currentSquare.getX();
            int curY = currentSquare.getY();
            //UP
            if (partial[curX][curY-1] != '%'){
                Square square = new Square(curX, curY-1, currentSquare, currentSquare.getCost()+10);
                //find distance cost
                square.setTotalCost(square.getCost()+findDistanceCost(curX,curY-1));
                currentSquare.addNeighbor(square);
                openList.add(square);
            }
            //DOWN
            if (partial[curX][curY+1] != '%'){
                Square square = new Square(curX, curY+1, currentSquare, currentSquare.getCost()+10);
                //find distance cost
                square.setTotalCost(square.getCost()+findDistanceCost(curX,curY+1));
                currentSquare.addNeighbor(square);
                openList.add(square);
            }
            //LEFT
            if (partial[curX-1][curY] != '%'){
                Square square = new Square(curX-1, curY, currentSquare, currentSquare.getCost()+10);
                //find distance cost
                square.setTotalCost(square.getCost()+findDistanceCost(curX-1,curY));
                currentSquare.addNeighbor(square);
                openList.add(square);
            }
            //RIGHT
            if (partial[curX+1][curY] != '%'){
                Square square = new Square(curX+1, curY, currentSquare, currentSquare.getCost()+10);
                //find distance cost
                square.setTotalCost(square.getCost()+findDistanceCost(curX+1,curY));
                currentSquare.addNeighbor(square);
                openList.add(square);
            }
            //DIAGONAL UPPER LEFT

        }


    }

    public int findDistanceCost(int curX, int curY){
        return Math.abs((curX - end.getX())+ (curY - end.getY()));
    }

    public Square findStart(){
        Square partialStart = new Square();
        for (int i = 0, j = 0;j < 7; j++){
            for (i = 0; i < 7; i++){
                if (partial[i][j] == 'P'){
                    partialStart.setX(i);
                    partialStart.setY(j);
                    partialStart.setParent(null);
                    return partialStart;
                }
            }
        }
        return partialStart;
    }

    public Square findGoal(){
        Square partialEnd = new Square();

        for (int i = 0, j = 0;j < 7; j++){
            for (i = 0; i < 7; i++){
                if (partial[i][j] == '.'){
                    partialEnd.setX(i);
                    partialEnd.setY(j);
                    partialEnd.setParent(null);
                    return partialEnd;
                }
            }
        }
        return partialEnd;
    }
}