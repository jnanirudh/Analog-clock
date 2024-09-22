package anirudhj.analogclock;
//import java.util.Calendar;
import java.util.Scanner;


import javax.swing.*;

public class AnalogClockLauncher {

    public static void main(String[] args){

        /*Scanner sc = new Scanner(System.in);
        System.out.print("Set Minute time: ");
        int i = sc.nextInt();*/

        System.out.println("My Analog clock starting...");

        JFrame frame = new JFrame("clock hand line");
        AnalogClock ac1 = new anirudhj.analogclock.AnalogClock();

        frame.add(ac1);

        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}