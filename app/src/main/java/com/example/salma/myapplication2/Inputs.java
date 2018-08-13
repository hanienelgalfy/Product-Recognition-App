package com.example.salma.myapplication2;

public class Inputs {

    String input1;
    String input2;
    String input3;
    String timestamp ;


    public Inputs(){

    }

    public Inputs(String input1, String input2, String input3 ,String timestamp) {
        this.input1 = input1;
        this.input2 = input2;
        this.input3 = input3;

        this.timestamp =timestamp ;

    }

    public String getInput1() {
        return input1;
    }

    public String getInput2() {
        return input2;
    }

    public String getInput3() {
        return input3;
    }


}

