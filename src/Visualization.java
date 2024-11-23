import com.mitchtalmadge.asciidata.graph.ASCIIGraph; //library for simple graphs in terminal

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * this class provides methods to visualize the gathered data for
 * caffeine consumption, mood scores, and sleep scores
 * using ASCIIGraph.
 *
 * @author Joshua Cochran
 *
 */
public class Visualization {

    /**
     * this method creates a graph from the data of a particular file
     * @param filename
     */
    public void makeGraph(String filename){

        try {Scanner sc = new Scanner(new File(filename));
            //make array
            double[] testArray = new double[30];

            int i = 0;

            while (sc.hasNextLine()){
                //read first token (first column)
                testArray[i] = Double.parseDouble(sc.next());
                //skips next column
                sc.nextLine();
                i++;
            }

            System.out.println(ASCIIGraph.fromSeries(testArray).withNumRows(10).plot());

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    //makes graph of caffeine data
    public void caffeineGraph() throws IOException {
        makeGraph("caffeine.csv");
    }

    //makes graph of sleep data
    public void sleepGraph() throws IOException {
        makeGraph("sleep.csv");
    }

    //makes graph of mood data
    public void moodGraph() throws IOException {
        makeGraph("mood.csv");
    }
}