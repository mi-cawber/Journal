import java.io.File;
import java.io.*;
import java.util.Scanner;

/**
 * This class carries out the appropriate calculations for the program.
 *
 * @author Joshua Cochran
 */
public class Computation {

    //needed vars for operations
    double sum = 0;
    double divisor = 0;
    double average = 0;
    int days = 0;

    /**
     *Calculates average of scores from mood.csv
     */
    public void moodAverage() {

        try (Scanner sc = new Scanner(new File("mood.csv"))) {

            //iterate through file and add numbers
            while (sc.hasNextLine()) { //while new line exists

               //read first token (first column)
                sum = sum + Double.parseDouble(sc.next());
                //skips next column
                sc.nextLine();
                //increment divisor counter
                divisor++;
            }

            //calculate average
            average = sum / divisor;

            System.out.printf("Your average mood (1-10): %.1f\n", average);

            //reset the variables
            sum = 0;
            divisor = 0;
            average = 0;
        } catch (IOException e) {
            e.printStackTrace(); //for error reporting
        }
    }

    /**
     * Calculates average of scores from sleep.csv
     */
    public void sleepAverage() {
        try (Scanner sc = new Scanner(new File("sleep.csv"))) {

            //iterate through file and add numbers
            while (sc.hasNextLine()) { //while new line exists

                //caps first column
                sum = sum + Double.parseDouble(sc.next());
                //skips next column
                sc.nextLine();
                //increment divisor counter
                divisor++;
            }

            //calculate average
            average = sum / divisor;

            System.out.printf("Your average hours of sleep: %.1f\n", average);

            //reset the variables
            sum = 0;
            divisor = 0;
            average = 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calculates average caffeine intake in mg from caffeine.csv
     */
    public void caffeineAverage() {
        try (Scanner sc = new Scanner(new File("caffeine.csv"))) {

            //iterate through file and add numbers
            while (sc.hasNextLine()) { //while new line exists

                //caps first column
                sum = sum + Double.parseDouble(sc.next());
                //skips next column
                sc.nextLine();
                //increment divisor counter
                divisor++;
            }

            //calculate average
            average = sum / divisor;

            System.out.printf("Your average caffeine intake: %.1f milligrams\n", average);

            //reset the variables
            sum = 0;
            divisor = 0;
            average = 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * this method tracks how many days worth of data has been collected
     * @throws IOException
     */
    public void addDay() throws IOException {

        PrintWriter daysWriter = new PrintWriter(new FileWriter("days.csv", true));

        try (Scanner sc = new Scanner(new File("days.csv"))) {

            while (sc.hasNextLine()) {
                //find last line for days
                days = Integer.parseInt(sc.nextLine());
            }
            days += 1; //add +1 to days
            daysWriter.println(days); //write into file
            daysWriter.close(); //close to release from buffer

        } catch (IOException e) { //necessary
            e.printStackTrace();
        }
    }

    /**
     * This method just reports how many
     * days worth of data has been collected
     */
    public void reportDay() throws IOException {

        try (Scanner sc = new Scanner(new File("days.csv"))) {

            //capture the last line on days
            while (sc.hasNextLine()) {
                //find last line for days
                days = Integer.parseInt(sc.nextLine());
            }

            System.out.println(days + " days of data collected.");


        } catch (IOException e) { //necessary
            e.printStackTrace();
        }
    }
}

