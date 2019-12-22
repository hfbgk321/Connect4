package com.company.TestCourse;

public class RedPlayer extends Player {
    public RedPlayer(String name){
        super(name);
    }

    @Override
    public String getOutcome(){
        return super.getOutcome() + this.getName() +", Outcome: "+this.getWin();
    }
}
