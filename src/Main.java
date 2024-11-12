import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {

        //new scanner
        Scanner sc = new Scanner(System.in);

        //get current date
        LocalDate today = LocalDate.now();

        // File writers for each text field
        PrintWriter sleepWriter = new PrintWriter(new FileWriter("sleep.csv", true));
        PrintWriter moodWriter = new PrintWriter(new FileWriter("mood.csv", true));

        //report sleep
        System.out.print("Sleep (Hours): ");
        sleepWriter.println(sc.nextInt() + ", " + today);
        sleepWriter.close();

        //report mood
        System.out.print("Mood (1-10): ");
        moodWriter.println(sc.nextInt() + ", " + today);
        moodWriter.close();

        //close scanner
        sc.close();

    }
}