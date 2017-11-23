package com.output;
/**********************************************
* 2017-10-30 FuYu create the class
*
* 2017-10-31 FuYu add the functions 
*
***********************************************/
import java.awt.Color;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
  
 

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;  
import org.jfree.chart.plot.CategoryPlot;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.chart.renderer.category.LineAndShapeRenderer;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.general.DatasetUtilities;  
  
    
public class JfreechartAverage {  

    public JfreechartAverage(double[] puma, double[] hare){  

        CategoryDataset dataset = createDataset(puma, hare);  

        JFreeChart freeChart = createChart(dataset);  
  
        saveAsFile(freeChart, "./outputlist/avg.jpg", 2000, 2000);  
    }  
  
	/**   
	 * 
	 * 
	 * 
	 * @Package: com.output
	 * @author: Fu Yu  
	 * @throws: IOException 
	 * @what: save the chart as a file 
	 * @param: chart jfreechart object
	 * @param: outputPath is the path to save 
	 * @param: weight and height are the size of the file
	 * @return: void
	 * @date: 31/10/2017
	 */
    public static void saveAsFile(JFreeChart chart, String outputPath,  
            int weight, int height) {  
        FileOutputStream out = null;  
        try {  
            File outFile = new File(outputPath);  
            if (!outFile.getParentFile().exists()) {  
                outFile.getParentFile().mkdirs();  
            }  
            out = new FileOutputStream(outputPath);  
 
            ChartUtilities.writeChartAsJPEG(out, chart, 1000, 1000);  
            out.flush();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (out != null) {  
                try {  
                    out.close();  
                } catch (IOException e) {  
                   
                }  
            }  
        }  
    }  
  
    /**   
	 * 
	 * 
	 * 
	 * @Package: com.output
	 * @author: Fu Yu  
	 * @throws: IOException 
	 * @what: create the chart  
	 * @param: CategoryDataset is the dataset of the picture design
	 * @return: a JFreeChart object
	 * @date: 31/10/2017
	 */
    public static JFreeChart createChart(CategoryDataset categoryDataset) {  
      
        JFreeChart jfreechart = ChartFactory.createLineChart("density of puma and hare", // title  
                "generation", 
                "density", 
                categoryDataset,  
                PlotOrientation.VERTICAL, true, 
                false, 
                false); 
        
        CategoryPlot plot = (CategoryPlot)jfreechart.getPlot();  
        
        plot.setBackgroundAlpha(0.5f);  
       
        plot.setForegroundAlpha(0.5f);  
      
        LineAndShapeRenderer renderer = (LineAndShapeRenderer)plot.getRenderer();  
        renderer.setBaseShapesVisible(true); 
        renderer.setBaseLinesVisible(true);   
        renderer.setUseSeriesOffset(true); 
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());  
        renderer.setBaseItemLabelsVisible(true); 
        renderer.setSeriesPaint(0, new Color(127, 128, 0));  
        
        
        return jfreechart;  
    }  
  

    /**   
	 * 
	 * 
	 * 
	 * @Package: com.output
	 * @author: Fu Yu  
	 * @throws: IOException 
	 * @what: create the dataset (the line value we need to show)
	 * @param: puma and hare are the average values we need to draw on the line chart
	 * @return: a CategoryDataset object
	 * @date: 31/10/2017
	 */ 
    public static CategoryDataset createDataset(double[] puma, double[] hare) {  
        String[] rowKeys = {"puma","hare"};  
        String[] colKeys = {"0", "100", "200", "300", "400", "500",  
                "600", "700", "800", "900", "1000", "1100", "1200",  
                "1250"};  
        double[][] data = {puma,
        	hare};  
  
        return DatasetUtilities.createCategoryDataset(rowKeys, colKeys, data);  
    }  
}  
