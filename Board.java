package com.company.TestCourse;

public class Board {

    public static void main(String[] args){
        Board test = new Board();
        test.getBoard();
        test.getBoard();
    }
    private String[][] board = new String[6][8];
    private int xPos = 0;
    private int yPos = 0;
    private boolean Won;

   public Board(){
       for(int x =0; x < this.board.length;x++){
           for(int y = 0; y < this.board[x].length;y++){
               this.board[x][y] = " ";
           }
       }
       this.Won = false;
   }

   public void refreshBoard(){
       for(int x =0; x < this.board.length;x++){
           for(int y = 0; y < this.board[x].length;y++){
                   System.out.print("|"+this.board[x][y]);
           }
           System.out.println();
       }
   }

   public boolean hasWon(){
       return Won;
   }

   public String[][] getBoard(){
       return this.board;
   }
   public void setWon(boolean x){
       this.Won = x;
   }

   public void diagRight(String color, int xPos, int yPos){
       int numOfColor = 1;
       int OriginalXPos = xPos;
       int OriginalYPos = yPos;
       for(int x = 0; x< 4;x++){
           if(xPos!=0 && yPos!=6){
               xPos--;
               yPos++;
               if(this.board[xPos][yPos].equals(color)){
                   numOfColor++;
               }
               else{
                   break;
               }
           }
           else{
               break;
           }

       }
       for(int x = 0; x< 4;x++){
           if(OriginalXPos!=5 && OriginalYPos!=0){
               OriginalXPos++;
               OriginalYPos--;
               if(this.board[OriginalXPos][OriginalYPos].equals(color)){
                   numOfColor++;
               }
               else{
                   break;
               }
           }
           else{
               break;
           }
       }

       if(numOfColor >=4){
           //System.out.println("Win by Right Diagonal Pattern");
           this.Won = true;
       }
   }
   public void diagLeft(String color, int xPos, int yPos){
       int numOfColor = 1;
       int OriginalXPos = xPos;
       int OriginalYPos = yPos;
       for(int x = 0; x< 4;x++){
           if(xPos!=0 && yPos!=0){
               xPos--;
               yPos--;
               if(this.board[xPos][yPos].equals(color)){
                   numOfColor++;
               }
               else{
                   break;
               }
           }
           else{
               break;
           }

       }
       for(int x = 0; x< 4;x++){
           if(OriginalXPos!=5 && OriginalYPos!=6){
               OriginalXPos++;
               OriginalYPos++;
               if(this.board[OriginalXPos][OriginalYPos].equals(color)){
                   numOfColor++;
               }
               else{
                   break;
               }
           }
           else{
               break;
           }
       }
       if(numOfColor >=4){
           //System.out.println("Win by Left Diagonal Pattern");
           this.Won = true;
       }
   }
   public void checkSides(String color, int xPos, int yPos){
       int numOfColor = 1;
       int OriginalYPos = yPos;
       for(int x = 0; x< 4;x++){
           if(yPos!=0){
               yPos--;
               if(this.board[xPos][yPos].equals(color)){
                   numOfColor++;
               }
               else{
                   break;
               }
           }
           else{
               break;
           }

       }
       for(int x = 0; x< 4;x++){
           if(OriginalYPos!=6){
               OriginalYPos++;
               if(this.board[xPos][OriginalYPos].equals(color)){
                   numOfColor++;
               }
               else{
                   break;
               }
           }
           else{
               break;
           }
       }

       if(numOfColor >=4){
           //System.out.println("Win by Side Pattern");
           this.Won = true;
       }
   }
   public void upDown(String color, int xPos, int yPos){
       int numOfColor = 1;
       int OriginalXPos = xPos;
       for(int x = 0; x< 4;x++){
           if(xPos!=0){
               xPos--;
               if(this.board[xPos][yPos].equals(color)){
                   numOfColor++;
               }
               else{
                   break;
               }
           }
           else{
               break;
           }

       }
       for(int x = 0; x< 4;x++){
           if(OriginalXPos!=5){
               OriginalXPos++;
               if(this.board[OriginalXPos][yPos].equals(color)){
                   numOfColor++;
               }
               else{
                   break;
               }
           }
           else{
               break;
           }
       }
       if(numOfColor >=4){
           //System.out.println("Win by UpDown Pattern");
           this.Won = true;
       }
   }
}
