import java.util.Scanner;
import java.time.LocalDate;

/**
 * This program is designed to capture mood and sleep data over time.
 * The user will be given the ability to derive insights from the collected data.
 *
 * @author Joshua Cochran
 * @version 0.5
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

        //controller for while loop
        boolean decisionPath = false;


        //main decision loop
        while (!decisionPath) {

            //ask whether user wants to input values or get averages
            System.out.printf("Choose Option:\n(1) Input values\n(2) Get metrics\n(3) Get graphs\n");

            String decisionInput = sc.nextLine();

            //to input values
            if (decisionInput.equals("1")) { //enter inputs

                //enter all relevant values
                DataEntry.totalEntry();

                //+1 to days collected tracker
                comp.addDay();
                //exit loop
                decisionPath = true;

            } else if (decisionInput.equals("2")) { //to get averages
                //report all relevant averages
                comp.reportAll();
                //close scanner
                sc.close();
                //exit loop
                decisionPath = true;
            } else if (decisionInput.equals("3")){ //to get graphs
                //prompt for which graphs
                System.out.printf("Which graph:\n(1) Caffeine\n(2) Mood\n(3) Sleep\n");
                //take user input for graph decision
                decisionInput = sc.nextLine();

                    //report relevant graph
                    if (decisionInput.equals("1")){ //caffeine graph
                        vis.caffeineGraph();
                        decisionPath = true; //exit loop

                    } else if (decisionInput.equals("2")){ //mood graph
                        vis.moodGraph();
                        decisionPath = true; //exit loop

                    } else if (decisionInput.equals("3")){ //sleep graph
                        vis.sleepGraph();
                        decisionPath = true; //exit loop

                    }
                }
            }
        }
    }
