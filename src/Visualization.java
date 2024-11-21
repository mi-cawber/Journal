import com.mitchtalmadge.asciidata.graph.ASCIIGraph;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Visualization {

    public void caffeineGraph() throws IOException {
        Scanner sc = new Scanner(new File("caffeine.csv"));
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

        for (int j = 0; j < testArray.length; j++){
            System.out.println(testArray[j]);
        }

        System.out.println(ASCIIGraph.fromSeries(testArray).withNumRows(5).plot());

    }
}