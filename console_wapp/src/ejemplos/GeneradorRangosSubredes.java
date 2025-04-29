package ejemplos;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class GeneradorRangosSubredes extends ApplicationFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GeneradorRangosSubredes(String title) {
        super(title);
        ChartPanel chartPanel = createChartPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
    }
    
    private ChartPanel createChartPanel() {
        String chartTitle = "Restricción: 2x + 3y <= 6";
        String xAxisLabel = "x";
        String yAxisLabel = "y";
        
        // Crear el conjunto de datos
        DefaultXYDataset dataset = new DefaultXYDataset();
        double[][] data = {{0, 2, 6/3.0}, {6/2.0, 0, 0}};
        dataset.addSeries("Restricción", data);
        
        // Crear el gráfico
        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, xAxisLabel, yAxisLabel, dataset);
        
        // Obtener el plot y modificar el renderizado
        XYPlot plot = chart.getXYPlot();
        XYShapeRenderer renderer = new XYShapeRenderer();
        renderer.setSeriesPaint(0, Color.GREEN);
        plot.setRenderer(renderer);
        
        // Crear el panel de gráfico y regresarlo
        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }
    
    public static void main(String[] args) {
        GeneradorRangosSubredes demo = new GeneradorRangosSubredes("Restricción");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
