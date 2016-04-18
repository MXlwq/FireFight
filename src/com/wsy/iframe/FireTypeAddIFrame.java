package com.wsy.iframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
//////
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import com.wsy.dao.Dao;
//import com.wsy.model.Reader;
import com.wsy.model.FireType;

//import com.wsy.model.Comburent;

public class FireTypeAddIFrame extends JInternalFrame {
	// nady 20141015
	// private JFormattedTextField days;
	private JTextField GZBH;// ���������
	private JTextField LBBH;// ��������� ��ѯʱ��
	private JTextField RSWBH;// ȼ����
	private JTextField RSW;// ȼ����

	private JComboBox comboBox1, comboBox2;
	private JTable table, table2;
	private JComboBox choice1, choice2, choice3;

	DefaultComboBoxModel comboBoxModel;
	String[] array;
	// private String[] columnNames={ "���������","ȼ�����ţ�ǰ����",
	// "ȼ���ǰ����","������𣨺����", "Ƶ��", "���Ŷ�"};
	private String[] columnNames = { "���������", "�����������", "ȼ������", "Ƶ��", "���Ŷ�" };

	// ��ʾ��������
	private Object[][] getFileStates(List list) {
		Object[][] results = new Object[list.size()][columnNames.length];
		for (int i = 0; i < list.size(); i++) {

			FireType firetype = (FireType) list.get(i);

			results[i][0] = firetype.getFiretypeid();// ��ȡ���������
			results[i][1] = firetype.getFiretypeName(); // ��ȡ�������

			results[i][2] = firetype.getComburentId(); // ��ȡ����ȼ����
			// results[i][2]=firetype.getComnurentId();//��ȡ�������

			results[i][3] = firetype.getFrequency();// Ƶ��
			results[i][4] = firetype.getConfidence();// ���Ŷ�

		}
		return results;
	}

	// ��ʾ����ȼ�����
	// private Object[][] getFileStates2(List list2){
	// Object[][] results2=new Object[list2.size()][columnNames.length];
	// for(int i=0;i<list2.size();i++){
	// Reader reader=(Reader)list.get(i);
	// FireType firetype=(FireType)list.get(i);
	// Comburent comburent=(Comburent)list2.get(i);

	// results2[i][0]=comburent.getComburentid();//��ȡ���������
	// results2[i][1]=comburent.getComburent(); //��ȡ�������

	// results[i][1]=firetype.getRanshaowu(); //��ȡ����ȼ����
	// results[i][2]=firetype.getHuozaileibie();//��ȡ�������

	// results[i][3]=firetype.getFrequency();//Ƶ��
	// results[i][4]=firetype.getConfidence();//���Ŷ�

	// }
	// return results2;
	// }

	/**
	 * Create the frame
	 */
	public FireTypeAddIFrame() {
		super();

		setTitle("��ӻ���������");
		setBounds(0, 0, 875, 495); // �����˴�С
		// ȥ�����ڵı�����
		((BasicInternalFrameUI) getUI()).setNorthPane(null);

		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		// panel_1.setPreferredSize(new Dimension(80, 80));
		// getContentPane().add(panel_1);
		getContentPane().add(panel, BorderLayout.NORTH);

		final JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout());
		getContentPane().add(panel_1, BorderLayout.CENTER);

		// ��Ҫ���ص�JTable������
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(0, 40));

		panel_1.add(scrollPane, BorderLayout.CENTER);

		// /nady 201500601
		final JPanel panel_0 = new JPanel();
		panel_0.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1,
				false));

		panel_1.add(panel_0, BorderLayout.NORTH);
		final FlowLayout flowLayout0 = new FlowLayout();
		panel_0.setPreferredSize(new Dimension(80, 80));
		flowLayout0.setVgap(20);
		flowLayout0.setHgap(30);
		flowLayout0.setAlignment(FlowLayout.CENTER);
		panel_0.setLayout(flowLayout0);

		final JLabel label_q = new JLabel();
		label_q.setText("��ѡ���ѯ���");
		panel_0.add(label_q);

		choice1 = new JComboBox();

		String[] array0 = { "���������", "�����������" };// ,"�����ҿռ����"
		for (int i = 0; i < array0.length; i++) {
			choice1.addItem(array0[i]);

		}
		panel_0.add(choice1);

		final JLabel label_q1 = new JLabel();
		label_q1.setText("������ؼ��֣�");
		panel_0.add(label_q1);

		LBBH = new JTextField(20);
		LBBH.setPreferredSize(new Dimension(10, 20));
		panel_0.add(LBBH);

		final JButton buttonQue = new JButton();
		buttonQue.setText("��ѯ");
		// buttonQue.addActionListener(new ButtonAddListener());
		panel_0.add(buttonQue);

		final JPanel panel_2 = new JPanel();
		// nady 20141014
		final GridLayout gridLayout2 = new GridLayout(0, 4);
		gridLayout2.setVgap(9);
		panel_2.setLayout(gridLayout2);
		panel_2.setPreferredSize(new Dimension(0, 80));
		panel_1.add(panel_2, BorderLayout.SOUTH);

		final DefaultTableModel model = new DefaultTableModel();

		// Object[][] results=getFileStates(Dao.selectReader());//�����˱�������
		// 0711
		Object[][] results = getFileStates(Dao.selectFireType());// �����˱�������

		// final DefaultTableModel model2=new DefaultTableModel();

		// Object[][] results2=getFileStates2(Dao.selectComburent());//�����˱�������
		// 0711
		model.setDataVector(results, columnNames);
		// model2.setDataVector(results2,columnNames);
		// nady 20141014

		table = new JTable();// ���Ĳ����ǿյ�
		table.setModel(model);
		scrollPane.setViewportView(table);
		// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setEnabled(false); // nady��ӣ�ʹ��񲻿ɱ༭

		// table2 = new JTable();//���Ĳ����ǿյ�
		// table2.setModel(model2);
		// scrollPane.setViewportView(table2);
		// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		// table2.setEnabled(false); //nady��ӣ�ʹ��񲻿ɱ༭

		final JLabel label_BH = new JLabel();
		label_BH.setHorizontalAlignment(SwingConstants.LEFT);
		label_BH.setPreferredSize(new Dimension(0, 0));
		label_BH.setMinimumSize(new Dimension(0, 0));
		panel_2.add(label_BH);
		label_BH.setText("     ��������ţ�");

		GZBH = new JTextField(20);
		GZBH.setPreferredSize(new Dimension(0, 0));
		panel_2.add(GZBH);

		/*
		 * final JLabel label_3 = new JLabel();
		 * 
		 * label_3.setText("     ȼ����(ǰ��)��"); label_3
		 * .setHorizontalAlignment(SwingConstants.LEFT); label_3
		 * .setPreferredSize(new Dimension(0, 0)); label_3 .setMinimumSize(new
		 * Dimension(0, 0)); panel_2.add(label_3);
		 * 
		 * RSW = new JTextField(20); RSW.setPreferredSize(new Dimension(0, 0));
		 * panel_2.add(RSW);
		 */

		final JLabel label_4 = new JLabel();
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setPreferredSize(new Dimension(0, 0));
		label_4.setMinimumSize(new Dimension(0, 0));
		label_4.setText("     ����������ƣ�");
		panel_2.add(label_4);

		choice3 = new JComboBox();

		String[] array2 = { "һ�㽨������", "�߲㽨������", "���¿ռ����", "�������", "һ���������",
				"�ж��������", "¶�����", "�������޻���", "��ͨ���߻���", "һ���Ի���" };// ,"�����ҿռ����"
		for (int i = 0; i < array2.length; i++) {
			choice3.addItem(array2[i]);

		}
		panel_2.add(choice3);

		final JLabel label_2 = new JLabel();

		label_2.setText("     ȼ�����ţ�");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setPreferredSize(new Dimension(100, 50));
		label_2.setMinimumSize(new Dimension(0, 0));
		panel_2.add(label_2);

		RSWBH = new JTextField(20);
		RSWBH.setPreferredSize(new Dimension(0, 0));
		panel_2.add(RSWBH);
		/*
		 * final JLabel label_18 = new JLabel(); label_18
		 * .setHorizontalAlignment(SwingConstants.LEFT); label_18
		 * .setPreferredSize(new Dimension(0, 0)); label_18 .setMinimumSize(new
		 * Dimension(0, 0)); label_18.setText("  "); panel_2.add(label_18);
		 */

		// final JPanel panel_5 = new JPanel();
		// panel_5.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1,
		// false));
		// panel_2.add(panel_5, BorderLayout.SOUTH);
		// getContentPane().add(panel_2, BorderLayout.SOUTH);
		// final FlowLayout flowLayout5 = new FlowLayout();
		// flowLayout5.setVgap(0);
		// flowLayout5.setHgap(0);
		// flowLayout5.setAlignment(FlowLayout.RIGHT);
		// panel_5.setLayout(flowLayout5);

		final JLabel label_8 = new JLabel();
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		// label_8 .setPreferredSize(new Dimension(0, 0));
		// label_8 .setMinimumSize(new Dimension(0, 0));
		label_8.setText("     Ƶ   �ʣ�");
		panel_2.add(label_8);

		comboBox1 = new JComboBox();
		comboBoxModel = (DefaultComboBoxModel) comboBox1.getModel();
		array = new String[] { "1.0", "0.9", "0.8", "0.7", "0.6", "0.5" };
		comboBox1.setModel(new DefaultComboBoxModel(array));
		for (int i = 1; i < array.length; i++) {
			comboBox1.setSelectedIndex(i);
			comboBox1.setSelectedItem(array);
		}
		panel_2.add(comboBox1);

		//
		final JLabel label_7 = new JLabel();
		// label_7 .setHorizontalAlignment(SwingConstants.RIGHT);
		// label_7 .setPreferredSize(new Dimension(0, 0));
		// label_7 .setMinimumSize(new Dimension(0, 0));
		label_7.setText("     ���Ŷȣ�");
		panel_2.add(label_7);

		comboBox2 = new JComboBox();
		comboBoxModel = (DefaultComboBoxModel) comboBox2.getModel();
		array = new String[] { "0.9", "0.8", "0.7", "0.6", "0.5" };
		comboBox2.setModel(new DefaultComboBoxModel(array));
		for (int i = 1; i < array.length; i++) {
			comboBox2.setSelectedIndex(i);
			comboBox2.setSelectedItem(array);
		}
		panel_2.add(comboBox2);

		final JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1,
				false));
		getContentPane().add(panel_4, BorderLayout.SOUTH);
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		flowLayout.setAlignment(FlowLayout.CENTER);
		panel_4.setLayout(flowLayout);

		final JButton button = new JButton();
		button.setText("����");

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				if (GZBH.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "����������ı��򲻿�Ϊ��");
					return;
				}
				// if(RSW.getText().length()==0){
				// JOptionPane.showMessageDialog(null, "ȼ�����ı��򲻿�Ϊ��");
				// return;
				// }

				// String GZLB=String.valueOf(choice3.getSelectedIndex());
				// System.out.println(choice3.getSelectedIndex());
				String GZBH1 = GZBH.getText().trim();
				int GZBH2 = Integer.parseInt(GZBH1);
				// String HZLB=String.valueOf(choice3.getSelectedIndex());
				// System.out.println(choice3.getSelectedIndex());
				String HZLB = (String) choice3.getSelectedItem();

				// String fre=String.valueOf(comboBox1.getSelectedIndex());
				// System.out.println(comboBox1.getSelectedIndex());
				String fre = (String) comboBox1.getSelectedItem();

				// String con=String.valueOf(comboBox2.getSelectedIndex());
				// System.out.println(comboBox2.getSelectedIndex());
				String con = (String) comboBox2.getSelectedItem();

				// int i=Dao.InsertBookType(bookTypeName.getText().trim(),
				// days.getText().trim());//,Double.valueOf(fakuan.getText().trim())/10);
				// 0711
				/*
				 * //int i=Dao.InsertFireType(GZBH2, HZLB,fre,con); if(i==1){
				 * JOptionPane.showMessageDialog(null, "��ӳɹ���");
				 * doDefaultCloseAction();
				 * 
				 * 
				 * }
				 */

			}
		});
		panel_4.add(button);

		final JButton buttonDel = new JButton();
		buttonDel.setText("����");

		buttonDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				doDefaultCloseAction();
			}
		});
		panel_4.add(buttonDel);
		setVisible(true);
		//
	}

	class CloseActionListener implements ActionListener { // ��ӹرհ�ť���¼�������
		@Override
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}

	class NumberListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			String numStr = "0123456789." + (char) 8;
			if (numStr.indexOf(e.getKeyChar()) < 0) {
				e.consume();
			}
		}
	}
}
