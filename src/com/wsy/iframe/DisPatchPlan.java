package com.wsy.iframe;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import javax.swing.JTextArea;

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


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class DisPatchPlan extends javax.swing.JFrame {
	private JTextArea dispatchPlan;

	public DisPatchPlan(final String title) {

		super(title);
		this.setDefaultCloseOperation(LineChartDemo.DISPOSE_ON_CLOSE);
		{
			dispatchPlan = new JTextArea();
			dispatchPlan.setText(DecisionIFrame.Plan);
			getContentPane().add(dispatchPlan, BorderLayout.CENTER);
			dispatchPlan.setSize(400, 220);
		}
		this.setSize(400, 220);

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