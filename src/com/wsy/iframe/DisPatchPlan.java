package com.wsy.iframe;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class DisPatchPlan extends javax.swing.JFrame {
	private JTextArea dispatchPlan;

	public DisPatchPlan(final String title) {

		super(title);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		{
			dispatchPlan = new JTextArea();
			dispatchPlan.setText(DecisionIFrame.Plan);
			getContentPane().add(dispatchPlan, BorderLayout.CENTER);
			dispatchPlan.setSize(400, 220);
		}
		this.setSize(400, 220);

	}

	public class JFrame implements WindowListener {
		@Override
		public void windowClosing(WindowEvent w) {
			System.out.print("Window Closing");
			System.exit(0);

		}

		@Override
		public void windowClosed(WindowEvent w) {
			System.exit(0);
		}

		@Override
		public void windowOpened(WindowEvent w) {
		}

		@Override
		public void windowIconified(WindowEvent w) {
		}

		@Override
		public void windowDeiconified(WindowEvent w) {
		}

		@Override
		public void windowActivated(WindowEvent w) {
		}

		@Override
		public void windowDeactivated(WindowEvent w) {
		}
	}

}