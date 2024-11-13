import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        //new computation object
        Computation comp = new Computation();
        //new scanner object
        Scanner sc = new Scanner(System.in);

        // File writers for each text field
        PrintWriter sleepWriter = new PrintWriter(new FileWriter("sleep.csv", true));
        PrintWriter moodWriter = new PrintWriter(new FileWriter("mood.csv", true));

        //ask whether user wants to input values or get averages
        System.out.println("Choose Option:");
        System.out.println("(1) Input values");
        System.out.println("(2) Get averages");

        String decisionPath = sc.nextLine();

        //if they want to input values
        if (decisionPath.equals("1")) { //enter inputs

            //report sleep
            System.out.print("Sleep (Hours): ");
            sleepWriter.println(sc.nextInt());
            sleepWriter.close();

            //report mood
            System.out.print("Mood (1-10): ");
            moodWriter.println(sc.nextInt());
            moodWriter.close();

            comp.addDayAndReport();

            sc.close();

            System.exit(0);
        } else { //report averages
            comp.moodAverage();
            comp.sleepAverage();

            sc.close();

            System.exit(0);
        }
    }
}