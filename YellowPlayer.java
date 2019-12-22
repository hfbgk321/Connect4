package com.company.TestCourse;

public class YellowPlayer extends Player {
    public YellowPlayer(String name){
        super(name);
    }

    @Override
    public String getOutcome(){
        return super.getOutcome() + this.getName() +", Outcome: "+ this.getWin();
    }
}
