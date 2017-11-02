package com.output;
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
  
//JFreeChart Line Chart（折线图）     
public class JfreechartAverage {  
    /** 
     * 创建JFreeChart Line Chart（折线图） 
     */  
    public JfreechartAverage(double[] puma, double[] hare){  
        // 步骤1：创建CategoryDataset对象（准备数据）  
        CategoryDataset dataset = createDataset(puma, hare);  
        // 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置  
        JFreeChart freeChart = createChart(dataset);  
        // 步骤3：将JFreeChart对象输出到文件，Servlet输出流等  
        saveAsFile(freeChart, "D:\\avg.jpg", 2000, 2000);  
    }  
  
    // 保存为文件  
    public static void saveAsFile(JFreeChart chart, String outputPath,  
            int weight, int height) {  
        FileOutputStream out = null;  
        try {  
            File outFile = new File(outputPath);  
            if (!outFile.getParentFile().exists()) {  
                outFile.getParentFile().mkdirs();  
            }  
            out = new FileOutputStream(outputPath);  
            // 保存为PNG  
            // ChartUtilities.writeChartAsPNG(out, chart, 600, 400);  
            // 保存为JPEG  
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
                    // do nothing  
                }  
            }  
        }  
    }  
  
    // 根据CategoryDataset创建JFreeChart对象  
    public static JFreeChart createChart(CategoryDataset categoryDataset) {  
        // 创建JFreeChart对象：ChartFactory.createLineChart  
        JFreeChart jfreechart = ChartFactory.createLineChart("density of puma and hare", // 标题  
                "generation", // categoryAxisLabel （category轴，横轴，X轴标签）  
                "density", // valueAxisLabel（value轴，纵轴，Y轴的标签）  
                categoryDataset, // dataset  
                PlotOrientation.VERTICAL, true, // legend  
                false, // tooltips  
                false); // URLs  
        // 使用CategoryPlot设置各种参数。以下设置可以省略。  
        CategoryPlot plot = (CategoryPlot)jfreechart.getPlot();  
        // 背景色 透明度  
        plot.setBackgroundAlpha(0.5f);  
        // 前景色 透明度  
        plot.setForegroundAlpha(0.5f);  
        // 其他设置 参考 CategoryPlot类  
        LineAndShapeRenderer renderer = (LineAndShapeRenderer)plot.getRenderer();  
        renderer.setBaseShapesVisible(true); // series 点（即数据点）可见  
        renderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见  
        renderer.setUseSeriesOffset(true); // 设置偏移量  
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());  
        renderer.setBaseItemLabelsVisible(true); 
        renderer.setSeriesPaint(0, new Color(127, 128, 0));  
        
        
        return jfreechart;  
    }  
  
    /** 
     * 创建CategoryDataset对象 
     *  
     */  
    public static CategoryDataset createDataset(double[] puma, double[] hare) {  
        String[] rowKeys = {"puma","hare"};  
        String[] colKeys = {"0", "100", "200", "300", "400", "500",  
                "600", "700", "800", "900", "1000", "1100", "1200",  
                "1250"};  
        double[][] data = {{puma[0],puma[1],puma[2],puma[3],puma[4],puma[5],
        	puma[6],puma[7],puma[8],puma[9],puma[10],puma[11],puma[12],puma[13]},
        	{hare[0],hare[1],hare[2],hare[3],hare[4],hare[5],hare[6],hare[7],hare[8],
        		hare[9],hare[10],hare[11],hare[12],hare[13]}};  
        // 或者使用类似以下代码  
        // DefaultCategoryDataset categoryDataset = new  
        // DefaultCategoryDataset();  
        // categoryDataset.addValue(10, "rowKey", "colKey");  
        return DatasetUtilities.createCategoryDataset(rowKeys, colKeys, data);  
    }  
}  
