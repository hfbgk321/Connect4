package com.company.TestCourse;

public class Player{
    private String name;
    private String win;

    public Player(String name){
        this.name = name;
    }

    public Player(){
        this("John Doe");
    }

    public String getName(){
        return this.name;
    }

    public void win(){
        this.win = "Won";
    }

    public void lose(){
        this.win = "Lost";
    }

    public String getWin(){
        return this.win;
    }


    public String getOutcome(){
        return "Player: ";
    }

}
