package com.java.designpatterns._3behavioural.state;

/*
State design pattern is one of the behavioral design pattern.
State design pattern is used when an Object change its behavior based on its internal state.

The benefits of using State pattern to implement polymorphic behavior is clearly visible.
The chances of error are less and it’s very easy to add more states for additional behavior.
Thus making our code more robust, easily maintainable and flexible. Also State pattern helped
in avoiding if-else or switch-case conditional logic in this scenario.

*/
interface State{
    public void doAction();
}

class TvOnState implements State {

    @Override
    public void doAction() {
        System.out.println("TV is turned ON");
    }
}

class TvOffState implements State {

    @Override
    public void doAction() {
        System.out.println("TV is turned OFF");
    }
}

class TVContext implements State{

    private State state;

    public TVContext(State state) {
        this.state = state;
    }

    @Override
    public void doAction() {
        this.state.doAction();
    }
}

public class TVRemote {
    public static void main(String[] args) {
        TVContext tvOnContext = new TVContext(new TvOnState());
        tvOnContext.doAction();
        TVContext tvOffContext = new TVContext(new TvOffState());
        tvOffContext.doAction();
    }
}
