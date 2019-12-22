package com.company.TestCourse;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    //private String[][] board = new String[6][7];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Board test = new Board();
        System.out.print("Enter the name of the Red Player: ");
        RedPlayer player1 = new RedPlayer(input.next());
        System.out.print("Enter the name of the Yellow Player: ");
        YellowPlayer player2 = new YellowPlayer(input.next());
        boolean playComplete = false;
        int numOfPlays = 0;
        int maxNumOfPlays = test.getBoard().length * (test.getBoard()[0].length-1);
        //System.out.println(maxNumOfPlays);
//        System.out.println(test.getBoard()[0].length);
//        System.out.println(test.getBoard().length);
        while(numOfPlays < maxNumOfPlays && test.hasWon() == false){
            if(numOfPlays >= maxNumOfPlays){
                //System.out.println("There has been a draw");
                test.setWon(true);
            }
            playComplete = false;
            while(playComplete == false && test.hasWon() == false) {

                if (numOfPlays % 2 == 0) {
                    try {
                        System.out.print(player1.getName() + ", Enter in the Column to which you want to put your Red piece! (1-7)");
                        int col = input.nextInt();
                        if(!(test.getBoard()[0][col - 1].equals(" "))){
                            throw new columnFullException(col);
                        }
                        if(col == 8){
                            throw new IndexOutOfBoundsException();
                        }

                        for (int x = test.getBoard().length - 1; x >= 0; x--) {
                            if (test.getBoard()[x][col - 1].equals(" ")) {
                                test.getBoard()[x][col - 1] = "R";
                                playComplete = true;
                                test.refreshBoard();
                                numOfPlays++;
                                System.out.println("Total number of plays: "+numOfPlays);
                                test.diagLeft("R", x, col - 1);
                                test.diagRight("R", x, col - 1);
                                test.upDown("R", x, col - 1);
                                test.checkSides("R", x, col - 1);
                                break;
                            }


                        }
                    }
                    catch (IndexOutOfBoundsException x) {
                        System.out.println("Choose another column, this one is unavailable!!!");
                        input.nextLine();
                    }
                    catch (InputMismatchException x){
                        System.out.println("Please enter reenter the position as an Integer!!");
                        input.nextLine();
                    }
                    catch(columnFullException x){
                        System.out.print(x.getMessage());
                        input.nextLine();
                    }
                }
                if (numOfPlays % 2 == 1 && test.hasWon() == false) {
                    try {
                        System.out.print(player2.getName() + ", Enter in the Column to which you want to put your Yellow piece! (1-7)");
                        int col2 = input.nextInt();
                        if(!(test.getBoard()[0][col2 - 1].equals(" "))){
                            throw new columnFullException(col2);
                        }
                        if(col2 == 8){
                            throw new IndexOutOfBoundsException();
                        }
                            for (int x = test.getBoard().length - 1; x >= 0; x--) {
                                if (test.getBoard()[x][col2 - 1].equals(" ")) {
                                    test.getBoard()[x][col2 - 1] = "Y";
                                    playComplete = true;
                                    test.refreshBoard();
                                    numOfPlays++;
                                    System.out.println("Total number of play: "+numOfPlays);
                                    test.diagLeft("Y", x, col2 - 1);
                                    test.diagRight("Y", x, col2 - 1);
                                    test.upDown("Y", x, col2 - 1);
                                    test.checkSides("Y", x, col2 - 1);
                                    break;
                                }
                            }
                    }
                    catch (IndexOutOfBoundsException x) {
                        System.out.println("Choose another column, this one is unavailable!!!");
                        input.nextLine();
                    }
                    catch(InputMismatchException x){
                        System.out.println("Please enter reenter the position as an Integer!!");
                        input.nextLine();
                    }
                    catch(columnFullException x){
                        System.out.println(x.getMessage());
                        input.nextLine();
                    }
                }
            }
        }

        if(numOfPlays == maxNumOfPlays){
            System.out.println("There has been a draw!!");
        }
        else if(numOfPlays % 2 == 0){
            player1.win();
            player2.lose();
            System.out.println(player1.getOutcome());
            System.out.println(player2.getOutcome());
            //System.out.print(numOfPlays);
        }
        else{
            player1.lose();
            player2.win();
            System.out.println(player1.getOutcome());
            System.out.print(player2.getOutcome());
            //System.out.print(numOfPlays);
        }
    }
}
class columnFullException extends Exception {
    private int colNum;
    public columnFullException(int colNum){
        super("Column "+colNum+" is full. Please select another column!!!\n");
        this.colNum = colNum;
    }

    public int getColNum(){
        return this.colNum;
    }
}
