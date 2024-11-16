import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;

/**
 * This program is designed to capture mood and sleep data over time.
 * The user will be given the ability to derive insights from the collected data.
 *
 * @author Joshua Cochran
 * @version 0.2 adds ability to track dates
 */

public class Main {
    public static void main(String[] args) throws Exception {


        //new computation object
        Computation comp = new Computation();
        //new scanner object
        Scanner sc = new Scanner(System.in);
        //capture date
        //would like to have a checker, to only allow data once a day
        String date = String.valueOf(LocalDate.now());

        // File writers for each text field
        PrintWriter sleepWriter = new PrintWriter(new FileWriter("sleep.csv", true));
        PrintWriter moodWriter = new PrintWriter(new FileWriter("mood.csv", true));

        //controller for while loop
        boolean lightSwitch = false;

        while (!lightSwitch){

            //ask whether user wants to input values or get averages
            System.out.println("Choose Option:");
            System.out.println("(1) Input values");
            System.out.println("(2) Get metrics");

            String decisionPath = sc.nextLine();

            //if they want to input values
            if (decisionPath.equals("1")) { //enter inputs

                //report sleep
                System.out.print("Sleep (Hours): ");
                double input = sc.nextDouble();
                //print into separate columns
                sleepWriter.println(input + " , " + date);
                //needed to flush buffer
                sleepWriter.close();

                //report mood
                System.out.print("Mood (1-10): ");
                input = sc.nextDouble();
                moodWriter.println(input + " , " + date);
                //needed to flush buffer
                moodWriter.close();

                //report how many days worth of data has been collected
                comp.addDay();

                sc.close();

                lightSwitch = true; //exit loop

            } else if (decisionPath.equals("2")) { //report averages
                comp.moodAverage();
                comp.sleepAverage();
                comp.reportDay();

                sc.close();

                lightSwitch = true; //exit loop
            }
        }
    }
}