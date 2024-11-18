import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;

/**
 * This program is designed to capture mood and sleep data over time.
 * The user will be given the ability to derive insights from the collected data.
 *
 * @author Joshua Cochran
 * @version 0.3
 * See changelog.txt for detailed version information.
 */

public class Main {

    Scanner sc = new Scanner(System.in);
   
    //would like to have a checker, to only allow data once a day
    String date = String.valueOf(LocalDate.now());
    String dateChecker; //variable to tell whether user has entered data already today


    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Computation comp = new Computation();


        //controller for while loop
        boolean decisionPath = false;

        while (!decisionPath) {

            //ask whether user wants to input values or get averages
            System.out.println("Choose Option:");
            System.out.println("(1) Input values");
            System.out.println("(2) Get metrics");

            String decisionInput = sc.nextLine();

            //if they want to input values
            if (decisionInput.equals("1")) { //enter inputs

                enterSleep();

                enterMood();

                enterCaffeine();

                enterWorkout();

                comp.addDay(); //+1 to days collected tracker

                decisionPath = true; //exit loop

            } else if (decisionInput.equals("2")) { //report averages
                comp.moodAverage();
                comp.sleepAverage();
                comp.caffeineAverage();
                comp.reportDay();

                sc.close(); //close scanner

                decisionPath = true; //exit loop
            }
        }
    }


    /**
     * This method allows user to enter hours of sleep for the last night,
     * and records this on a .csv file, along with the current date.
     * @throws Exception
     */
    static void enterSleep() throws Exception {
        //print writer object
        PrintWriter sleepWriter = new PrintWriter(new FileWriter("sleep.csv", true));
        //new scanner
        Scanner sc = new Scanner(System.in);
        //capture date
        String date = String.valueOf(LocalDate.now());

        //enter sleep
        System.out.print("Sleep (Hours): ");
        double doubleInput = sc.nextDouble();
        //print into separate columns
        sleepWriter.println(doubleInput + " , " + date);
        //needed to flush buffer
        sleepWriter.close();
    }

    /**
     * This method allows user to enter a mood score for the day,
     * and records this on a .csv file, along with the current date.
     * @throws Exception
     */
    static void enterMood() throws Exception {
        PrintWriter moodWriter = new PrintWriter(new FileWriter("mood.csv", true));
        //new scanner
        Scanner sc = new Scanner(System.in);
        //capture date
        String date = String.valueOf(LocalDate.now());

        //enter mood
        System.out.print("Mood (1-10): ");
        double doubleInput = sc.nextDouble();
        moodWriter.println(doubleInput + " , " + date);
        //needed to flush buffer
        moodWriter.close();
    }

    /**
     * This method allows user to enter mgs of caffeine ingested for the day,
     * and records this on a .csv file, along with the current date.
     * @throws Exception
     */
    static void enterCaffeine() throws Exception{
        PrintWriter caffeineWriter = new PrintWriter(new FileWriter("caffeine.csv", true));
        //new scanner
        Scanner sc = new Scanner(System.in);
        //capture date
        String date = String.valueOf(LocalDate.now());

        //enter caffeine
        System.out.print("Caffeine (Milligrams): ");
        double doubleInput = sc.nextDouble();
        caffeineWriter.println(doubleInput + " , " + date); //write mgs
        caffeineWriter.close();
    }

    /**
     * This method allows user to enter whether they exercised that day,
     * and records this on a .csv file, along with the current date.
     * @throws Exception
     */
    static void enterWorkout() throws Exception{
        PrintWriter workoutWriter = new PrintWriter(new FileWriter("workout.csv", true));
        //new scanner
        Scanner sc = new Scanner(System.in);
        //capture date
        String date = String.valueOf(LocalDate.now());

        //enter workout
        System.out.print("Workout?\n(0) No\n(1) Yes\n");
        int intInput = sc.nextInt();
        workoutWriter.println(intInput + " , " + date);
        workoutWriter.close();
    }
}