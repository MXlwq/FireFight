package com.wsy.iframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

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

import org.jfree.ui.RefineryUtilities;

import com.wsy.dao.Dao;
import com.wsy.dao.clear;
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
	static String[] strings = { "有火灾类别的信息吗?必须输入火灾类别信息",
			"有火灾面积的信息吗?有请输入，忽略该问题请回车", "有火灾容积的信息吗?有请输入，忽略该问题请回车",
			"有呼叫次数的信息吗?有请输入，忽略该问题请回车", "有所处阶段的信息吗?有请输入，忽略该问题请回车",
			"有火灾火势的信息吗?有请输入，忽略该问题请回车", "有蔓延状态的信息吗?有请输入，忽略该问题请回车",
			"有被困人数的信息吗?有请输入，忽略该问题请回车", "有受伤人数的信息吗?有请输入，忽略该问题请回车",
			"有死亡人数的信息吗?有请输入，忽略该问题请回车" };
	private JButton btnBack;
	private JTextArea command;
	private JScrollPane jScrollPane1;
	static int[] array = new int[10];
	public int i = 0;
	public static int t = 0;
	static String content0;
	static String content1;
	static String content2;
	static String addressInput;
	static String fireTypeInput = "一般性建筑火灾";
	static String areaInput = "少于-100-平米";
	static String volumeInput = "少于-1000-立方米";
	static String spreadInput = "无";
	static String deathPeopleInput = "0";
	static String hurtPeopleInput = "0";
	static String trapedPeopleInput = "0";
	static String situationInput = "较小";
	static String phaseInput = "初期";
	static String callTimeInput = "少于3次";
	static String addressConfidence = "(1.0,0.900)";
	static String fireTypeConfidence = "肯定(1.0,0.9)";
	static String areaConfidence = "肯定(1.0,0.9)";
	static String volumeConfidence = "肯定(1.0,0.9)";
	static String spreadConfidence = "肯定(1.0,0.9)";
	static String callTimeConfidence = "肯定(1.0,0.9)";
	static String deathPeopleConfidence = "肯定(1.0,0.9)";
	static String hurtPeopleConfidence = "肯定(1.0,0.9)";
	static String trapedPeopleConfidence = "肯定(1.0,0.9)";
	static String situationConfidence = "肯定(1.0,0.9)";
	static String phaseConfidence = "肯定(1.0,0.9)";

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

	public void submitMsg() {
		// 存储界面输入值

		ResultStr = "";
		Plan = "";
		try {
			Dao.Dispatch(addressInput, areaInput, volumeInput, spreadInput,
					deathPeopleInput, hurtPeopleInput, trapedPeopleInput,
					situationInput, phaseInput, callTimeInput, fireTypeInput,
					addressConfidence, areaConfidence, volumeConfidence,
					spreadConfidence, callTimeConfidence,
					deathPeopleConfidence, hurtPeopleConfidence,
					trapedPeopleConfidence, situationConfidence,
					phaseConfidence, fireTypeConfidence);

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
			clear c1 = new clear();
			c1.cl();
			ResultStr = "";
			command.setText(ResultStr);
		}
	}

	class CustomKeyListener implements KeyListener {
		public void keyTyped(KeyEvent e) {

		}

		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				getContent(t);// 健壮性带添加
				int sum = 0;
				try {
					for (int i = 0; i < 10; i++) {
						if (array[i] == 0) {
							System.out.println("i:"+i);
							JOptionPane.showMessageDialog(null, strings[i]);
							break;
						}
						sum += array[i];
						if (sum == 10) {
							submitMsg();
							command.setText(ResultStr);
//							DisPatchPlan plan = new DisPatchPlan(
//									"派遣方案");
//							RefineryUtilities.centerFrameOnScreen(plan);
//							plan.setVisible(true);// 可见
//							plan.pack();// 窗口大小适应
							JOptionPane.showMessageDialog(null, DecisionIFrame.Plan);
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		}

		public void keyReleased(KeyEvent e) {
		}
	}

	private void getContent(int b) {
		t=b;
		try {
			boolean flag = false;
			int index1, index2, index3, index4, index5, index6, index7;
			String content = command.getText();
			if (content.charAt(content.length() - 1) == '\n') {
				System.out.println("有换行");
				content = content.substring(0, content.length() - 1);
				command.setText(content);
				if (t != 0) {
					JOptionPane.showMessageDialog(null, "已忽略该问题");
					array[t] = 1;
					System.out.println("t:"+t);
					t++;
				} else {
					if (array[0] == 0)
						JOptionPane.showMessageDialog(null, "必须输入火灾类别，请输入");
					else {
						t++;
					}
				}

				flag = true;
			}
			else {
				
			
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
				addressInput = content0;
				content1 = contentNeed.substring(index3 + 1, index4);
				content2 = contentNeed.substring(index6, index7 + 1);
				switchString = contentNeed.substring(index5 + 1, index6);
				whichSwitch(switchString, content);
			} catch (Exception e) {
				// TODO: handle exception
				if (flag == false)
					JOptionPane.showMessageDialog(null,
							"输入格式有问题，请按{}*[]→(,)格式输入！");
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "结束");
		}

		/*
		 * {事件1}*[少于3次]→呼叫次数(1.0,0.900) {北京}*[少于-1000-立方米]→火灾容积(0.7,0.500)
		 * content0火灾发生地点 content1火灾的类别选择 content2火灾的置信度
		 */

	}

	public void whichSwitch(String s, String content) {
		
		System.out.println("heheeh");
		if (s.compareTo("火灾类别") == 0) {
			fireTypeInput = content1;
			fireTypeConfidence = content2;
			itemDao.areaDispatch(content0, content1, content2);
			array[0] = 1;t++;
		} else if (s.compareTo("火灾面积") == 0) {
			areaInput = content1;
			areaConfidence = content2;
			itemDao.areaDispatch(content0, content1, content2);
			array[1] = 1;t++;
		} else if (s.compareTo("火灾容积") == 0) {
			volumeInput = content1;
			volumeConfidence = content2;
			itemDao.volumeDispatch(content0, content1, content2);
			array[2] = 1;t++;
		} else if (s.compareTo("呼叫次数") == 0) {
			callTimeInput = content1;
			callTimeConfidence = content2;
			itemDao.callTimeDispatch(content0, content1, content2);
			array[3] = 1;t++;
		} else if (s.compareTo("所处阶段") == 0) {
			phaseInput = content1;
			phaseConfidence = content2;
			itemDao.phaseDispatch(content0, content1, content2);
			array[4] = 1;t++;
		} else if (s.compareTo("火灾火势") == 0) {

			situationInput = content1;
			situationConfidence = content2;
			itemDao.situationDispatch(content0, content1, content2);
			array[5] = 1;t++;
		} else if (s.compareTo("蔓延状态") == 0) {
			spreadInput = content1;
			spreadConfidence = content2;
			itemDao.spreadDispatch(content0, content1, content2);
			array[6] = 1;t++;
		} else if (s.compareTo("被困人数") == 0) {
			trapedPeopleInput = content1;
			trapedPeopleConfidence = content2;
			itemDao.trapedPeopleDispatch(content0, content1, content2);
			array[7] = 1;t++;
		} else if (s.compareTo("受伤人数") == 0) {
			hurtPeopleInput = content1;
			hurtPeopleConfidence = content2;
			itemDao.hurtPeopleDispatch(content0, content1, content2);
			array[8] = 1;t++;
		} else if (s.compareTo("死亡人数") == 0) {
			deathPeopleInput = content1;
			deathPeopleConfidence = content2;
			itemDao.deathPeopleDispatch(content0, content1, content2);
			array[9] = 1;t++;
		} else {
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
