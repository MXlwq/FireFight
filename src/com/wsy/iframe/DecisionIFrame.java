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

import com.wsy.dao.Dao;
import com.wsy.dao.clear;
import com.wsy.dao.itemDao;

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
	String content;
	public static String ResultStr = "";
	public static String Plan = "";
	public final LineChartDemo demo = new LineChartDemo("��������ͼ");
	static String[] strings = { "�л���������Ϣ��?����������������Ϣ",
			"�л����������Ϣ��?�У���ֱ�����룬������س����Ը�����", "�л����ݻ�����Ϣ��?�У���ֱ�����룬������س����Ը�����",
			"�к��д�������Ϣ��?�У���ֱ�����룬������س����Ը�����", "�������׶ε���Ϣ��?�У���ֱ�����룬������س����Ը�����",
			"�л��ֻ��Ƶ���Ϣ��?�У���ֱ�����룬������س����Ը�����", "������״̬����Ϣ��?�У���ֱ�����룬������س����Ը�����",
			"�б�����������Ϣ��?�У���ֱ�����룬������س����Ը�����", "��������������Ϣ��?�У���ֱ�����룬������س����Ը�����",
			"��������������Ϣ��?�У���ֱ�����룬������س����Ը�����" };
	private JButton btnBack;
	private JTextArea command;
	private JScrollPane jScrollPane1;
	static int[] array = new int[10];
	public int i = 0;
	public static int t = 0;
	static String content0;
	static String content1;
	static String content2;
	// 20160418��������Ϊ�����ݿ��е��жϱ�׼�Ǻ�""���Ƚϣ���ˣ��˴�Ӧ��Ĭ�ϳ�ʼ��Ϊ""
	String addressInput = "";
	String fireTypeInput = "";
	String areaInput = "";
	String volumeInput = "";
	String spreadInput = "";
	String deathPeopleInput = "";
	String hurtPeopleInput = "";
	String trapedPeopleInput = "";
	String situationInput = "";
	String phaseInput = "";
	String callTimeInput = "";
	String addressConfidence = "";
	String fireTypeConfidence = "";
	String areaConfidence = "";
	String volumeConfidence = "";
	String spreadConfidence = "";
	String callTimeConfidence = "";
	String deathPeopleConfidence = "";
	String hurtPeopleConfidence = "";
	String trapedPeopleConfidence = "";
	String situationConfidence = "";
	String phaseConfidence = "";

	/**
	 * } Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {

		try {
			// Ƥ������

			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				DecisionIFrame inst = new DecisionIFrame();
				// inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});

	}

	public void submitMsg() {
		// �洢��������ֵ

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

		// ����ȫ�޸ģ�ʹ��������ʽ��windowsһ��
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception err) {
			System.out.println("xp:" + err);
		}

		((BasicInternalFrameUI) getUI()).setNorthPane(null);
		initGUI();
		setTitle("������������֧��ϵͳ");
		this.setBounds(0, 0, 875, 495);
		((BasicInternalFrameUI) getUI()).setNorthPane(null);

		final JPanel panel = new JPanel();
		getContentPane().add(panel);
		final BorderLayout borderLayout = new BorderLayout();
		panel.setLayout(borderLayout);
		setVisible(true);

		panel.setBorder(new TitledBorder(null, "�����Ϣ",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));
		panel.setPreferredSize(new Dimension(790, 495));// ����panel�Ĵ�С�ĺ���
		panel.setLayout(null);
		{
			btnBack = new JButton();
			panel.add(btnBack);
			btnBack.setText("����");
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
				command.setText(strings[0] + "\n");
				jScrollPane1.setViewportView(command);
			}
		}

		final FlowLayout flowLayout5 = new FlowLayout();
		flowLayout5.setVgap(2);
		flowLayout5.setHgap(30);
		flowLayout5.setAlignment(FlowLayout.LEFT);

	}

	class CloseActionListener implements ActionListener { // ��ӹرհ�ť���¼�������
		@Override
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
			clear c1 = new clear();
			c1.cl();
			ResultStr = "";
			command.setText(ResultStr);
		}
	}

	class CustomKeyListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				int sum = 0;

				for (int i = 0; i < 10; i++) {
					if (array[i] == 0) {
						getContent(i);
						content = command.getText();
						if (array[i] == 0) {
							System.out.println("i:" + i + strings[i]);
							command.setText(content + "\n" + strings[i]);
						} else {
							for (int j = i + 1; j < 10; j++) {
								try {
									if (array[j] == 0) {
										System.out.println("j:" + j);
										command.setText(content + "\n"
												+ strings[j]);
										break;
									}
								} catch (Exception e2) {
									// TODO: handle exception
									command.setText(content + "\n" + "�������");
								}

							}
						}
						// JOptionPane.showMessageDialog(null, strings[i]);
						break;
					}
					sum += array[i];

					System.out.println("sum" + sum);
					if (sum >= 10) {
						System.out.println("sum>=10");
						submitMsg();
						command.setText(ResultStr);
						JOptionPane
								.showMessageDialog(null, DecisionIFrame.Plan);
					}
				}

			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	}

	// 20160419�޸ģ�ȡ���Ի���ֻ�����ս���ԶԻ�����ʽ����
	private void getContent(int b) {
		t = b;
		int index1, index2, index3, index4, index5, index6, index7;
		content = command.getText();
		if (content.charAt(content.length() - 1) == '\n') {
			command.setText(content.substring(0, content.length() - 1));
			if (t != 0) {
				command.setText(content + "�Ѻ��Ը�����");
				array[t] = 1;
			} else {
				command.setText(content + "���ܺ��Ը�����");

			}
		} else {
			// System.out.println("���ں�");
			String[] destString = content.split("\n");
			String switchString;
			String contentNeed = destString[destString.length - 1];
			index1 = contentNeed.indexOf('{');
			index2 = contentNeed.indexOf('}');
			index3 = contentNeed.indexOf('[');
			index4 = contentNeed.indexOf(']');
			index5 = contentNeed.indexOf('��');
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
				// JOptionPane.showMessageDialog(null,"�����ʽ�����⣬�밴{}*[]��(,)��ʽ���룡");
				command.setText(content + "\n" + "�����ʽ�����⣬�밴{}*[]��(,)��ʽ���룡");

			}
		}

		/*
		 * {�¼�1}*[����3��]�����д���(1.0,0.900) {����}*[����-1000-������]�������ݻ�(0.7,0.500)
		 * content0���ַ����ص� content1���ֵ����ѡ�� content2���ֵ����Ŷ�
		 */

	}

	public void whichSwitch(String s, String content) {
		String eqString = s;
		if (eqString.equals("�������")) {
			fireTypeInput = content1;
			fireTypeConfidence = content2;
			itemDao.typeDispatch(content0, content1, content2);
			itemDao.close();
			array[0] = 1;

		} else if (eqString.equals("�������")) {
			areaInput = content1;
			areaConfidence = content2;

			itemDao.areaDispatch(content0, content1, content2);
			itemDao.close();
			array[1] = 1;

		} else if (eqString.equals("�����ݻ�")) {
			volumeInput = content1;
			volumeConfidence = content2;
			itemDao.volumeDispatch(content0, content1, content2);
			itemDao.close();
			array[2] = 1;

		} else if (eqString.equals("���д���")) {
			callTimeInput = content1;
			callTimeConfidence = content2;
			itemDao.callTimeDispatch(content0, content1, content2);
			itemDao.close();
			array[3] = 1;

		} else if (eqString.equals("�����׶�")) {
			phaseInput = content1;
			phaseConfidence = content2;
			itemDao.phaseDispatch(content0, content1, content2);
			itemDao.close();
			array[4] = 1;

		} else if (eqString.equals("���ֻ���")) {

			situationInput = content1;
			situationConfidence = content2;
			itemDao.situationDispatch(content0, content1, content2);
			itemDao.close();
			array[5] = 1;

		} else if (eqString.equals("����״̬")) {
			spreadInput = content1;
			spreadConfidence = content2;
			itemDao.spreadDispatch(content0, content1, content2);
			itemDao.close();
			array[6] = 1;

		} else if (eqString.equals("��������")) {
			trapedPeopleInput = content1;
			trapedPeopleConfidence = content2;
			itemDao.trapedPeopleDispatch(content0, content1, content2);
			itemDao.close();
			array[7] = 1;

		} else if (eqString.equals("��������")) {
			hurtPeopleInput = content1;
			hurtPeopleConfidence = content2;
			itemDao.hurtPeopleDispatch(content0, content1, content2);
			itemDao.close();
			array[8] = 1;

		} else if (eqString.equals("��������")) {
			deathPeopleInput = content1;
			deathPeopleConfidence = content2;
			itemDao.deathPeopleDispatch(content0, content1, content2);
			itemDao.close();
			array[9] = 1;

		} else {
			command.setText(content + "\n" + "�����ʽ�����⣬���������룡");
			// JOptionPane.showMessageDialog(null, "�����ʽ�����⣬���������룡");
		}
		// 20160307�޸ģ�����ԭ�û�����
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
