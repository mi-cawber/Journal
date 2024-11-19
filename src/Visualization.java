import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class Visualization {

    public JFreeChart BarChart() {
        // Create a dataset for the chart
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(5, "Category 1", "A");
        dataset.addValue(7, "Category 1", "B");
        dataset.addValue(3, "Category 1", "C");

        // Create the chart using ChartFactory
        JFreeChart chart = ChartFactory.createBarChart(
                "Sample Bar Chart",    // Chart title
                "Category",            // X-Axis label
                "Value",               // Y-Axis label
                dataset                // Dataset
        );

        return chart;
    }
}