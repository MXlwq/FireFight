package com.wsy.iframe;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

//类和类静态成员的导入
import com.wsy.dao.*;

import static com.wsy.dao.Read.S;

public class LineChartDemo extends javax.swing.JFrame {

	public LineChartDemo(final String title) {

		super(title);
		this.setDefaultCloseOperation(LineChartDemo.DISPOSE_ON_CLOSE);

		final CategoryDataset dataset = createDataset();
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(550, 270));
		setContentPane(chartPanel);
		//this.setUndecorated(true);

	}

	public CategoryDataset createDataset() {
		String filePath = "G:\\实验室\\火灾决策辅助系统\\暑假\\0724-gyx\\0717(1)\\FireFightManager\\javaio-appendfile.txt";
		Read re = new Read();
		re.readTxtFile(filePath);
		// row keys...
		final String series1 = "Frequency";
		final String series2 = "Confidence";
		// column keys...

		final String type0 = "0";
		final String type1 = "1";
		final String type2 = "2";
		final String type3 = "3";
		final String type4 = "4";
		final String type5 = "5";
		final String type6 = "6";
		final String type7 = "7";
		final String type8 = "8";
		final String type9 = "9";

		// create the dataset...
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// itemDao ite = new itemDao();

		dataset.addValue(re.S[0], series1, type1);
		dataset.addValue(re.S[2], series1, type2);
		dataset.addValue(re.S[4], series1, type3);
		dataset.addValue(re.S[6], series1, type4);
		dataset.addValue(re.S[8], series1, type5);
		dataset.addValue(re.S[10], series1, type6);
		dataset.addValue(re.S[12], series1, type7);
		dataset.addValue(re.S[14], series1, type8);
		dataset.addValue(re.S[16], series1, type9);

		dataset.addValue(re.S[1], series2, type1);
		dataset.addValue(re.S[3], series2, type2);
		dataset.addValue(re.S[5], series2, type3);
		dataset.addValue(re.S[7], series2, type4);
		dataset.addValue(re.S[9], series2, type5);
		dataset.addValue(re.S[11], series2, type6);
		dataset.addValue(re.S[13], series2, type7);
		dataset.addValue(re.S[15], series2, type8);
		dataset.addValue(re.S[17], series2, type9);
		return dataset;

	}

	private JFreeChart createChart(final CategoryDataset dataset) {

		final JFreeChart chart = ChartFactory.createLineChart("", // chart title
				"Number of Evidence", // domain axis label
				"Truth Value", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, // orientation
				true, // include legend
				true, // tooltips
				false // urls
				);
		final Shape[] shapes = new Shape[3];
		int[] xpoints;
		int[] ypoints;

		// right-pointing triangle
		xpoints = new int[] { -3, 3, -3 };
		ypoints = new int[] { -3, 0, 3 };
		shapes[0] = new Polygon(xpoints, ypoints, 3);

		// vertical rectangle
		shapes[1] = new Rectangle2D.Double(-2, -3, 3, 6);

		// left-pointing triangle
		xpoints = new int[] { -3, 3, 3 };
		ypoints = new int[] { 0, -3, 3 };
		shapes[2] = new Polygon(xpoints, ypoints, 3);

		final DrawingSupplier supplier = new DefaultDrawingSupplier(
				DefaultDrawingSupplier.DEFAULT_PAINT_SEQUENCE,
				DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
				DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
				DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE, shapes);
		final CategoryPlot plot = chart.getCategoryPlot();
		plot.setDrawingSupplier(supplier);

		chart.setBackgroundPaint(Color.white);

		// set the stroke for each series...
		plot.getRenderer().setSeriesStroke(
				0,
				new BasicStroke(2.0f, BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND, 1.0f,
						new float[] { 10.0f, 6.0f }, 0.0f));
		plot.getRenderer().setSeriesStroke(
				1,
				new BasicStroke(2.0f, BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND, 1.0f,
						new float[] { 6.0f, 6.0f }, 0.0f));
		plot.getRenderer().setSeriesStroke(
				2,
				new BasicStroke(2.0f, BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND, 1.0f,
						new float[] { 2.0f, 6.0f }, 0.0f));

		// customise the range axis...
		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setAutoRangeIncludesZero(false);
		rangeAxis.setUpperMargin(0.12);

		return chart;

	}

	public class JFrame implements WindowListener {
		public void windowClosing(WindowEvent w) {
			System.out.print("Window Closing");
			System.exit(0);
			
		}

		public void windowClosed(WindowEvent w) {
			System.exit(0);
		}

		public void windowOpened(WindowEvent w) {
		}

		public void windowIconified(WindowEvent w) {
		}

		public void windowDeiconified(WindowEvent w) {
		}

		public void windowActivated(WindowEvent w) {
		}

		public void windowDeactivated(WindowEvent w) {
		}
	}

}