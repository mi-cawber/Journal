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
    public static void main(String[] args) throws IOException {


        //new computation object for all my computations
        Computation comp = new Computation();
        //new scanner object
        Scanner sc = new Scanner(System.in);
        //capture date
        //would like to have a checker, to only allow data once a day
        String date = String.valueOf(LocalDate.now());
        String dateChecker; //variable to tell whether user has entered data already today

        // File writers for each text field
        PrintWriter sleepWriter = new PrintWriter(new FileWriter("sleep.csv", true));
        PrintWriter moodWriter = new PrintWriter(new FileWriter("mood.csv", true));
        PrintWriter caffeineWriter = new PrintWriter(new FileWriter("caffeine.csv", true));

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

                //report sleep
                System.out.print("Sleep (Hours): ");
                double doubleInput = sc.nextDouble();
                String stringInput = sc.nextLine();
                //print into separate columns
                sleepWriter.println(doubleInput + " , " + date);
                //needed to flush buffer
                sleepWriter.close();

                //report mood
                System.out.print("Mood (1-10): ");
                doubleInput = sc.nextDouble();
                moodWriter.println(doubleInput + " , " + date);
                //needed to flush buffer
                moodWriter.close();

                //report caffeine
                System.out.print("Caffeine (Y/N): ");
                stringInput = sc.next();

                    //if yes, ask for milligrams
                    if (stringInput.equalsIgnoreCase("y")){
                        System.out.print("Milligrams: ");
                        doubleInput = sc.nextDouble();
                        caffeineWriter.println(doubleInput + " , " + date); //write mgs
                        caffeineWriter.flush();
                    }

                comp.addDay(); //+1 to days collected tracker
                sc.close(); //close scanner
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
}