package com.wsy.iframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import com.wsy.dao.itemDao;
import com.wsy.iframe.UserModiAndDelIFrame.CloseActionListener;

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
public class DecisionIFrame extends JInternalFrame {

	public static String ResultStr = "";
	public static String Plan = "";
	public final LineChartDemo demo = new LineChartDemo("信念曲线图");
	String[] strings = { "有火灾面积的信息吗?有请输入，否则请回车", "有火灾容积的信息吗?有请输入，否则请回车",
			"有呼叫次数的信息吗?有请输入，否则请回车", "有所处阶段的信息吗?有请输入，否则请回车",
			"有火灾火势的信息吗?有请输入，否则请回车", "有蔓延状态的信息吗?有请输入，否则请回车",
			"有被困人数的信息吗?有请输入，否则请回车", "有受伤人数的信息吗?有请输入，否则请回车",
			"有死亡人数的信息吗?有请输入，否则请回车" };
	private JButton btnBack;
	private JTextArea command;
	private JScrollPane jScrollPane1;
	int[] array = new int[9];
	public int i = 0;
	static String content0;
	static String content1;
	static String content2;

	/**
	 * } Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {

		try {
			// 皮肤管理

			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				DecisionIFrame inst = new DecisionIFrame();
				// inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});

	}

	public DecisionIFrame() {
		super();

		// 李文全修改，使界面风格样式和windows一样
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception err) {
			System.out.println("xp:" + err);
		}

		((BasicInternalFrameUI) getUI()).setNorthPane(null);
		initGUI();
		setTitle("城市消防决策支持系统");
		this.setBounds(0, 0, 875, 495);
		((BasicInternalFrameUI) getUI()).setNorthPane(null);

		final JPanel panel = new JPanel();
		getContentPane().add(panel);
		final BorderLayout borderLayout = new BorderLayout();
		panel.setLayout(borderLayout);
		setVisible(true);

		panel.setBorder(new TitledBorder(null, "结果信息",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));
		panel.setPreferredSize(new Dimension(790, 495));// 调整panel的大小的函数
		panel.setLayout(null);
		{
			btnBack = new JButton();
			panel.add(btnBack);
			btnBack.setText("返回");
			btnBack.addActionListener(new CloseActionListener());
			btnBack.setBounds(44, 445, 699, 31);
		}
		{
			jScrollPane1 = new JScrollPane();
			panel.add(jScrollPane1);
			jScrollPane1.setBounds(44, 32, 699, 407);
			{
				command = new JTextArea();
				command.addKeyListener(new CustomKeyListener());
				jScrollPane1.setViewportView(command);
			}
		}

		final FlowLayout flowLayout5 = new FlowLayout();
		flowLayout5.setVgap(2);
		flowLayout5.setHgap(30);
		flowLayout5.setAlignment(FlowLayout.LEFT);

	}

	class CloseActionListener implements ActionListener { // 添加关闭按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}

	class CustomKeyListener implements KeyListener {
		public void keyTyped(KeyEvent e) {
		}
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				getContent();// 健壮性带添加
				for (int t = 0; t < 9; t++) {
					if (array[t] == 0){
						JOptionPane.showMessageDialog(null, strings[t]);
						break;
					}
					
				}
			}
		}

		public void keyReleased(KeyEvent e) {
		}
	}

	private void getContent() {
		int index1, index2, index3, index4, index5, index6, index7;
		String content = command.getText().toString();
		String[] destString = content.split("\n");
		String switchString;
		String contentNeed = destString[destString.length - 1];
		index1 = contentNeed.indexOf('{');
		index2 = contentNeed.indexOf('}');
		index3 = contentNeed.indexOf('[');
		index4 = contentNeed.indexOf(']');
		index5 = contentNeed.indexOf('→');
		index6 = contentNeed.indexOf('(');
		index7 = contentNeed.indexOf(')');
		try {
			content0 = contentNeed.substring(index1 + 1, index2);
			content1 = contentNeed.substring(index3 + 1, index4);
			content2 = contentNeed.substring(index6, index7 + 1);
			switchString = contentNeed.substring(index5 + 1, index6);
			whichSwitch(switchString, content);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "输入格式有问题，请重新输入！");
		}
		
		

		/*
		 * {事件1}*[少于3次]→呼叫次数(1.0,0.900) {北京}*[少于-1000-立方米]→火灾容积(0.7,0.500)
		 * content0火灾发生地点 content1火灾的类别选择 content2火灾的置信度
		 */

	}

	public void whichSwitch(String s, String content) {
		if (s.compareTo("火灾面积") == 0) {
			itemDao.areaDispatch(content0, content1, content2);
			array[0] = 1;
		} else if (s.compareTo("火灾容积") == 0) {
			itemDao.volumeDispatch(content0, content1, content2);
			array[1] = 1;
		} else if (s.compareTo("呼叫次数") == 0) {
			itemDao.callTimeDispatch(content0, content1, content2);
			array[2] = 1;
		} else if (s.compareTo("所处阶段") == 0) {
			itemDao.phaseDispatch(content0, content1, content2);
			array[3] = 1;
		} else if (s.compareTo("火灾火势") == 0) {
			itemDao.situationDispatch(content0, content1, content2);
			array[4] = 1;
		} else if (s.compareTo("蔓延状态") == 0) {
			itemDao.spreadDispatch(content0, content1, content2);
			array[5] = 1;
		} else if (s.compareTo("被困人数") == 0) {
			itemDao.trapedPeopleDispatch(content0, content1, content2);
			array[6] = 1;
		} else if (s.compareTo("受伤人数") == 0) {
			itemDao.hurtPeopleDispatch(content0, content1, content2);
			array[7] = 1;
		} else if (s.compareTo("死亡人数") == 0) {
			itemDao.deathPeopleDispatch(content0, content1, content2);
			array[8] = 1;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "输入格式有问题，请重新输入！");
		}
		// 20160307修改，保留原用户输入
		command.setText(content + ResultStr);
	}

	private void initGUI() {

		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
