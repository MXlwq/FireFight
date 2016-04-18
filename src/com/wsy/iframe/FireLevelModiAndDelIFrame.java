package com.wsy.iframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import com.wsy.dao.Dao;
import com.wsy.model.FireLevel;
import com.wsy.util.MyDocument;

//////

public class FireLevelModiAndDelIFrame extends JInternalFrame {

	private JTextField keepmoney, GBBH;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	private JTextField ISBN;
	private JTextField zy;
	private JTextField tel;
	private JTextField date;
	private JTextField maxnumber;
	private JTextField bztime;
	private JTextField zjnumber;
	private JComboBox comboBox;
	private JTextField age;
	private JTextField TMJ;
	private JTextField TRJ;
	private JTextField TRSW;
	private JTextField THJCS;
	private JTextField TBKRS;
	private JTextField HZJB;
	private JTextField readername;
	private JRadioButton JRadioButton1;
	private JRadioButton JRadioButton2;
	DefaultComboBoxModel comboBoxModel;
	private JComboBox choice;
	// nady 20141014
	// private String[] columnNames={ "ȼ�����", "ȼ���ݻ�", "���д���", "ȼ����","��������",
	// "���ּ���"};
	private String[] columnNames = { "������", "��������", "Ƶ��", "���Ŷ�", "ȼ��������",
			"ȼ���ݻ����", "���д������", "�����׶α��", "���Ʊ��", "�����ٶȱ��", "�����������", "�����������",
			"�����������", "ͻ��������" };
	String[] array;
	String id;

	/**
	 * Create the frame
	 */
	private Object[][] getFileStates(List list) {
		Object[][] results = new Object[list.size()][columnNames.length];
		for (int i = 0; i < list.size(); i++) {
			FireLevel firelevel = (FireLevel) list.get(i);

			results[i][0] = firelevel.getFireLevelId();
			results[i][1] = firelevel.getFireLevelName(); //
			results[i][2] = firelevel.getFrequency();//
			results[i][3] = firelevel.getConfidence();//
			results[i][4] = firelevel.getAreaId();//
			results[i][5] = firelevel.getVolumeId();//
			results[i][6] = firelevel.getCallingTimeId();//
			results[i][7] = firelevel.getStageId();//
			results[i][8] = firelevel.getFireId();//
			results[i][9] = firelevel.getSpreadingId();//
			results[i][10] = firelevel.getTrappedpeopleId();//
			results[i][11] = firelevel.getInjuredPeolpeId();//
			results[i][12] = firelevel.getDeathTollid();//
			results[i][13] = firelevel.getDangerid();//

		}
		return results;

	}

	public FireLevelModiAndDelIFrame() {
		super();
		// setIconifiable(true);
		// setClosable(true);
		// nady 20141014
		setTitle("ά�����ּ���");
		this.setBounds(0, 0, 875, 495);
		((BasicInternalFrameUI) getUI()).setNorthPane(null);

		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		getContentPane().add(panel, BorderLayout.NORTH);

		// /nady 20150513
		final JPanel panel_0 = new JPanel();
		panel_0.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1,
				false));
		// getContentPane().add(panel_0, BorderLayout.SOUTH);
		final FlowLayout flowLayout0 = new FlowLayout();
		flowLayout0.setVgap(20);
		flowLayout0.setHgap(30);
		flowLayout0.setAlignment(FlowLayout.CENTER);
		panel.setLayout(flowLayout0);

		final JLabel label_q = new JLabel();
		label_q.setText("��ѡ���ѯ���");
		panel.add(label_q);

		choice = new JComboBox();

		String[] array0 = { "���ּ�����", "���ּ���" };// ,"�����ҿռ����"
		for (int i = 0; i < array0.length; i++) {
			choice.addItem(array0[i]);

		}
		panel.add(choice);

		final JLabel label_q1 = new JLabel();
		label_q1.setText("������ؼ��֣�");
		panel.add(label_q1);

		HZJB = new JTextField(20);
		HZJB.setPreferredSize(new Dimension(10, 20));
		panel.add(HZJB);

		final JButton buttonQue = new JButton();
		buttonQue.setText("��ѯ");
		// buttonQue.addActionListener(new ButtonAddListener());
		panel.add(buttonQue);

		// //////////////////////////////////////////

		final JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout());
		getContentPane().add(panel_1);
		// ��Ҫ���ص�JTable������
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(400, 130));
		panel_1.add(scrollPane, BorderLayout.NORTH);

		// �˴�������JTable������ֵ
		final DefaultTableModel model = new DefaultTableModel();
		Object[][] results = getFileStates(Dao.selectFireLevel());// �����˱�������
		model.setDataVector(results, columnNames);

		// Nady 20141014
		table = new JTable();// ���Ĳ����ǿյ�
		table.setModel(model);
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.addMouseListener(new TableListener());
		table.setEnabled(false); // nady��ӣ�ʹ��񲻿ɱ༭
		final JPanel panel_2 = new JPanel();
		// nady 20141014
		final GridLayout gridLayout = new GridLayout(0, 4);
		gridLayout.setVgap(9);
		panel_2.setLayout(gridLayout);
		panel_2.setPreferredSize(new Dimension(0, 250));
		panel_1.add(panel_2, BorderLayout.SOUTH);

		final JLabel label_BH = new JLabel();
		label_BH.setPreferredSize(new Dimension(0, 0));
		label_BH.setMinimumSize(new Dimension(0, 0));
		panel_2.add(label_BH);
		label_BH.setText("     ���ּ����ţ�");

		GBBH = new JTextField(20);
		GBBH.setPreferredSize(new Dimension(0, 0));
		panel_2.add(GBBH);

		final JLabel LMJ = new JLabel();
		LMJ.setText("     ���������ǰ������");
		panel_2.add(LMJ);

		TMJ = new JTextField();
		TMJ.setDocument(new MyDocument(30));
		panel_2.add(TMJ);

		final JLabel LRJ = new JLabel();
		LRJ.setText("     �����ݻ���ǰ������");
		panel_2.add(LRJ);

		TRJ = new JTextField();
		TRJ.setDocument(new MyDocument(30));
		panel_2.add(TRJ);

		final JLabel LRSW = new JLabel();
		LRSW.setText("     �����׶Σ�ǰ������");
		panel_2.add(LRSW);

		TRSW = new JTextField();
		TRSW.setDocument(new MyDocument(30));
		panel_2.add(TRSW);

		final JLabel LHJCS = new JLabel();
		LHJCS.setText("     ���д�����ǰ������");
		panel_2.add(LHJCS);

		THJCS = new JTextField();
		THJCS.setDocument(new MyDocument(30));
		panel_2.add(THJCS);

		final JLabel HS = new JLabel();
		HS.setText("     ���ֻ��ƣ�ǰ������");
		panel_2.add(HS);

		TBKRS = new JTextField();
		TBKRS.setDocument(new MyDocument(30));
		panel_2.add(TBKRS);

		final JLabel MYZK = new JLabel();
		MYZK.setText("     ����״����ǰ������");
		panel_2.add(MYZK);

		TBKRS = new JTextField();
		TBKRS.setDocument(new MyDocument(30));
		panel_2.add(TBKRS);

		final JLabel BKRS = new JLabel();
		BKRS.setText("     ����������ǰ������");
		panel_2.add(BKRS);

		TBKRS = new JTextField();
		TBKRS.setDocument(new MyDocument(30));
		panel_2.add(TBKRS);

		final JLabel ZSRS = new JLabel();
		ZSRS.setText("     ����������ǰ������");
		panel_2.add(ZSRS);

		TBKRS = new JTextField();
		TBKRS.setDocument(new MyDocument(30));
		panel_2.add(TBKRS);

		final JLabel SWRS = new JLabel();
		SWRS.setText("     ����������ǰ������");
		panel_2.add(SWRS);

		TBKRS = new JTextField();
		TBKRS.setDocument(new MyDocument(30));
		panel_2.add(TBKRS);

		final JLabel TBXQ = new JLabel();
		TBXQ.setText("     ͻ�����飨ǰ������");
		panel_2.add(TBXQ);

		TBKRS = new JTextField();
		TBKRS.setDocument(new MyDocument(30));
		panel_2.add(TBKRS);

		final JLabel KKJB = new JLabel();
		KKJB.setText("     �ɿؼ���ǰ������");
		panel_2.add(KKJB);

		TBKRS = new JTextField();
		TBKRS.setDocument(new MyDocument(30));
		panel_2.add(TBKRS);

		final JLabel label_5 = new JLabel();
		label_5.setText("     ���ּ��𣨺������");
		panel_2.add(label_5);

		zy = new JTextField();
		zy.setDocument(new MyDocument(30));
		panel_2.add(zy);

		final JLabel label_8 = new JLabel();
		label_8.setText("     Ƶ   �ʣ�");
		panel_2.add(label_8);

		comboBox = new JComboBox();
		comboBoxModel = (DefaultComboBoxModel) comboBox.getModel();
		array = new String[] { "1.0", "0.9", "0.8", "0.7", "0.6", "0.5", "0.4",
				"0.3", "0.2", "0.1", "0.0" };
		comboBox.setModel(new DefaultComboBoxModel(array));
		for (int i = 1; i < array.length; i++) {
			comboBox.setSelectedIndex(i);
			comboBox.setSelectedItem(array);
		}
		panel_2.add(comboBox);

		final JLabel label_7 = new JLabel();
		label_7.setText("     ���ų̶ȣ�");
		panel_2.add(label_7);

		comboBox = new JComboBox();
		comboBoxModel = (DefaultComboBoxModel) comboBox.getModel();
		array = new String[] { "0.9", "0.8", "0.7", "0.6", "0.5", "0.4", "0.3",
				"0.2", "0.1" };
		comboBox.setModel(new DefaultComboBoxModel(array));
		for (int i = 1; i < array.length; i++) {
			comboBox.setSelectedIndex(i);
			comboBox.setSelectedItem(array);
		}
		panel_2.add(comboBox);

		final JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1,
				false));
		getContentPane().add(panel_4, BorderLayout.SOUTH);
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setVgap(2);
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_4.setLayout(flowLayout);

		final JButton button = new JButton();
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		panel_4.add(button);
		button.setText("�޸�");
		button.addActionListener(new ModiButtonListener(model));

		final JButton buttonDel = new JButton();
		panel_4.add(buttonDel);
		buttonDel.setText("ɾ��");
		buttonDel.addActionListener(new DelButtonListener(model));
		setVisible(true);

		final JButton buttonExit = new JButton();
		buttonExit.setText("����");
		buttonExit.addActionListener(new CloseActionListener());
		panel_4.add(buttonExit);
		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				doDefaultCloseAction();
			}
		});
		setVisible(true);
		//
	}

	class TableListener extends MouseAdapter {
		@Override
		public void mouseClicked(final MouseEvent e) {

			int selRow = table.getSelectedRow();

			readername.setText(table.getValueAt(selRow, 0).toString().trim());
			age.setText(table.getValueAt(selRow, 2).toString().trim());
			zy.setText(table.getValueAt(selRow, 9).toString().trim());

		}
	}

	final class NumberListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			String numStr = "0123456789" + (char) 8;
			if (numStr.indexOf(e.getKeyChar()) < 0) {
				e.consume();
			}
		}
	}

	private final class DelButtonListener implements ActionListener {
		private final DefaultTableModel model;

		private DelButtonListener(DefaultTableModel model) {
			this.model = model;
		}

		@Override
		public void actionPerformed(final ActionEvent e) {
			// int i=Dao.DelReader(ISBN.getText().trim());
			// if(i==1){
			JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
			// Object[][] results=getFileStates(Dao.selectReader());
			// model.setDataVector(results,columnNames);
			table.setModel(model);
		}
	}
}

class ModiButtonListener implements ActionListener {
	private final DefaultTableModel model;

	ModiButtonListener(DefaultTableModel model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		// if(readername.getText().length()==0){
		JOptionPane.showMessageDialog(null, "ȼ������ı��򲻿�Ϊ��");
		return;
		// }
		// if(age.getText().length()==0){
		// JOptionPane.showMessageDialog(null, "����ǰ���ı��򲻿�Ϊ��");
		// return;
		// }

		// if(zy.getText().length()==0){
		// JOptionPane.showMessageDialog(null, "�������ı��򲻿�Ϊ��");
		// return;
		// }

		// if(maxnumber.getText().length()==0){
		// JOptionPane.showMessageDialog(null, "���ּ����ı��򲻿�Ϊ��");
		// return;
	}

	// String zj=String.valueOf(comboBox.getSelectedIndex());
	// System.out.println(comboBox.getSelectedIndex());
	// nady 20141014
	// int i=Dao.UpdateReader(id,readername.getText().trim(),
	// age.getText().trim(),
	// zy.getText().trim(),zj,zjnumber.getText().trim(),maxnumber.getText().trim());
	// System.out.println(i);
	// if(i==1){
	// JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
	// Object[][] results=getFileStates(Dao.selectReader());
	// model.setDataVector(results,columnNames);
	// table.setModel(model);
	// }
}

// }
class TelListener extends KeyAdapter {
	@Override
	public void keyTyped(KeyEvent e) {
		String numStr = "0123456789-" + (char) 8;
		if (numStr.indexOf(e.getKeyChar()) < 0) {
			e.consume();
		}
	}
}

class KeepmoneyListener extends KeyAdapter {
	@Override
	public void keyTyped(KeyEvent e) {
		String numStr = "0123456789" + (char) 8;// ֻ���������������˸��
		if (numStr.indexOf(e.getKeyChar()) < 0) {
			e.consume();
		}
		// if(keepmoney.getText().length()>2||keepmoney.getText().length()<0){
		e.consume();
		// }
	}
}

class CloseActionListener implements ActionListener { // ��ӹرհ�ť���¼�������
	@Override
	public void actionPerformed(final ActionEvent e) {
		// doDefaultCloseAction();
	}
}

// }
