import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class DataEntry {

    /**
     * This method will take inputs for all measured variables of interest
     * @throws Exception
     */
    static void totalEntry() throws Exception{
        enterSleep();
        enterMood();
        enterCaffeine();
        enterWorkout();
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
