import java.util.Scanner;
import java.time.LocalDate;

/**
 * This program is designed to capture mood and sleep data over time.
 * The user will be given the ability to derive insights from the collected data.
 *
 * @author Joshua Cochran
 * @version 0.4
 * See changelog.txt for detailed version information.
 */

public class Main {
    //would like to have a checker, to only allow data once a day
    String date = String.valueOf(LocalDate.now());
    String dateChecker;


    public static void main(String[] args) throws Exception {

        //new scanner, comp object
        Scanner sc = new Scanner(System.in);
        Computation comp = new Computation();
        Visualization vis = new Visualization();
        DataEntry data = new DataEntry();

        vis.BarChart();



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

                //enter all relevant values
                data.enterSleep();
                data.enterMood();
                data.enterCaffeine();
                data.enterWorkout();

                //+1 to days collected tracker
                comp.addDay();
                //exit loop
                decisionPath = true;

            } else if (decisionInput.equals("2")) {

                //report averages
                comp.moodAverage();
                comp.sleepAverage();
                comp.caffeineAverage();
                comp.reportDay();

                //close scanner
                sc.close();
                //exit loop
                decisionPath = true;
            }
        }
    }
}