/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 William Zheng
 */

import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();
        String Num1 = myApp.readPrinciple();
        String Num2 = myApp.readRate();
        String Num3 = myApp.readYears();
        String Num4 = myApp.readCompoundPerYear();
        double principle = Double.parseDouble(Num1);
        double rate = Double.parseDouble(Num2);
        int years = Integer.parseInt(Num3);
        int compoundRate = Integer.parseInt(Num4);
        double convertRate = myApp.convertRate(rate);
        double finalInterest = myApp.calcInterest(principle, convertRate, years, compoundRate);
        String outputString = myApp.generateOutputString(principle, rate, years, compoundRate, finalInterest);
        myApp.printOutput(outputString);
    }

    public void printOutput(String outputString) {
        System.out.println(outputString);
    }

    public String readPrinciple(){
        System.out.print("What is the principal amount? ");
        return in.nextLine();
    }

    public String readRate(){
        System.out.print("What is the rate? ");
        return in.nextLine();
    }

    public String readYears(){
        System.out.print("What is the number of years? ");
        return in.nextLine();
    }

    public String readCompoundPerYear(){
        System.out.print("What is the number of times the interest is compounded per year? ");
        return in.nextLine();
    }

    public double convertRate(double rate){
        return (rate/100);
    }

    public double calcInterest(double principle, double rate, int years, int compoundRate){
        return principle * Math.pow((1 + (rate/compoundRate)), (compoundRate * years));
    }

    public String generateOutputString(double principle, double rate, int years, int compoundRate, double finalInterest){
        return String.format("$%.2f invested at %s%%, for %d years compounded %d times per year is $%.2f.", principle, rate, years, compoundRate, finalInterest);
    }
}
