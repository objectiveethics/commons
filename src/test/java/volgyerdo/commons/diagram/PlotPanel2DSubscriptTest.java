package volgyerdo.commons.diagram;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Test class to demonstrate and verify the subscript functionality in PlotPanel2D
 */
public class PlotPanel2DSubscriptTest {
    
    public static void main(String[] args) {
        // Test the subscript rendering functionality
        testSubscriptRendering();
        
        // Create and display a visual test
        SwingUtilities.invokeLater(() -> createVisualTest());
    }
    
    private static void testSubscriptRendering() {
        System.out.println("Testing PlotPanel2D subscript functionality...");
        
        // Create a PlotPanel2D instance
        PlotPanel2D panel = new PlotPanel2D();
        panel.setSize(800, 600);
        
        // Create test data
        List<DataSeries> dataSeriesList = List.of(
            new DataSeries("H_2_O concentration", 
                List.of(
                    new Point2D.Double(1, 10),
                    new Point2D.Double(2, 15),
                    new Point2D.Double(3, 20),
                    new Point2D.Double(4, 25)
                ), Color.BLUE, true, true),
            new DataSeries("CO_2_ levels", 
                List.of(
                    new Point2D.Double(1, 5),
                    new Point2D.Double(2, 8),
                    new Point2D.Double(3, 12),
                    new Point2D.Double(4, 18)
                ), Color.RED, true, true)
        );
        
        panel.setDataSeries(dataSeriesList);
        
        // Set labels with subscript notation
        panel.setPlotTitle("Chemical Concentrations with _subscript_ notation");
        panel.setXAxisLabel("Time (t_0_ + Δt)");
        panel.setYAxisLabel("Concentration (mol/L_solution_)");
        
        // Test width calculation
        Graphics2D g2 = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB).createGraphics();
        g2.setFont(new Font("Arial", Font.PLAIN, 12));
        
        // These are the internal methods we created - we can't test them directly
        // but we can verify that the panel doesn't throw exceptions when rendered
        try {
            panel.paintComponent(g2);
            System.out.println("✓ PlotPanel2D with subscript notation rendered successfully");
        } catch (Exception e) {
            System.out.println("✗ Error rendering PlotPanel2D with subscripts: " + e.getMessage());
            e.printStackTrace();
        } finally {
            g2.dispose();
        }
    }
    
    private static void createVisualTest() {
        JFrame frame = new JFrame("PlotPanel2D Subscript Test");
        PlotPanel2D panel = new PlotPanel2D();
        panel.setPreferredSize(new Dimension(900, 700));
        
        // Create more comprehensive test data
        List<DataSeries> dataSeriesList = List.of(
            new DataSeries("H_2_O (water)", 
                List.of(
                    new Point2D.Double(0, 100),
                    new Point2D.Double(1, 85),
                    new Point2D.Double(2, 72),
                    new Point2D.Double(3, 61),
                    new Point2D.Double(4, 52)
                ), Color.BLUE, true, true),
            new DataSeries("CO_2_ (carbon dioxide)", 
                List.of(
                    new Point2D.Double(0, 20),
                    new Point2D.Double(1, 35),
                    new Point2D.Double(2, 48),
                    new Point2D.Double(3, 59),
                    new Point2D.Double(4, 68)
                ), Color.RED, true, true),
            new DataSeries("N_2_ (nitrogen)", 
                List.of(
                    new Point2D.Double(0, 40),
                    new Point2D.Double(1, 42),
                    new Point2D.Double(2, 44),
                    new Point2D.Double(3, 46),
                    new Point2D.Double(4, 48)
                ), Color.GREEN, true, true)
        );
        
        panel.setDataSeries(dataSeriesList);
        
        // Set comprehensive labels with various subscript patterns
        panel.setPlotTitle("Chemical Reaction: 2H_2_ + O_2_ → 2H_2_O");
        panel.setXAxisLabel("Time (hours from t_0_)");
        panel.setYAxisLabel("Concentration (mol/L_solution_)");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        System.out.println("Visual test window created. Check the display for subscript rendering:");
        System.out.println("- Title should show: Chemical Reaction: 2H₂ + O₂ → 2H₂O");
        System.out.println("- X-axis should show: Time (hours from t₀)");
        System.out.println("- Y-axis should show: Concentration (mol/L_solution)");
        System.out.println("- Legend should show series names with subscripts");
    }
}
