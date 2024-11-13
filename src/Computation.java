import java.io.File;
import java.io.*;
import java.util.Scanner;
public class Computation {

    //needed vars for operations
    int sum = 0;
    int divisor = 0;
    int average = 0;
    int days = 0;

    public void moodAverage() {

        try (Scanner sc = new Scanner(new File("mood.csv"))) {

            //iterate through file and add numbers
            while (sc.hasNextLine()) { //while new line exists

                //cap input, turn into int
                sum = sum + Integer.parseInt(sc.nextLine());
                //increment divisor counter
                divisor++;
            }

            //calculate average
            average = sum / divisor;

            System.out.println("Your average mood (1-10): " + average);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sleepAverage() {
        try (Scanner sc = new Scanner(new File("sleep.csv"))) {

            //iterate through file and add numbers
            while (sc.hasNextLine()) { //while new line exists

                //cap input, turn into int
                sum = sum + Integer.parseInt(sc.nextLine());
                //increment divisor counter
                divisor++;
            }

            //calculate average
            average = sum / divisor;

            System.out.println("Your average hours of sleep: " + average);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addDayAndReport() throws IOException {

        PrintWriter daysWriter = new PrintWriter(new FileWriter("days.csv", true));

        try (Scanner sc = new Scanner(new File("days.csv"))) {

            while (sc.hasNextLine()) {
                //find last line for days
                days = Integer.parseInt(sc.nextLine());
            }
            days += 1; //add +1 to days
            daysWriter.println(days); //write into file
            daysWriter.close(); //close to release from buffer

            System.out.println("You have tracked " + days + " days of data.");

        } catch (IOException e) { //necessary
            e.printStackTrace();
        }
    }
}

