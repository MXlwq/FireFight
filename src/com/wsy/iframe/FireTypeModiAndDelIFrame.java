package com.wsy.iframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import com.wsy.dao.Dao;
import com.wsy.model.FireType;

//////

public class FireTypeModiAndDelIFrame extends JInternalFrame {

	private JTextField days, TLB, FSDD, GZBH, RSWBH;
	private JTextField RuleId;
	private JComboBox choice;

	private JComboBox comboBox;
	private JTable table;

	DefaultComboBoxModel comboBoxModel;
	String[] array;
	// nady 20141015
	private String[] columnNames = { "������", "ȼ����", "�������", "Ƶ��", "���Ŷ�" };

	DefaultComboBoxModel bookTypeModel;
	DefaultTableModel model;
	Map map;

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

	/**
	 * Create the frame
	 */
	public FireTypeModiAndDelIFrame() {
		super();
		// nady20141014
		setTitle("ά������������");
		setBounds(0, 0, 875, 495);
		((BasicInternalFrameUI) getUI()).setNorthPane(null);
		// setIconifiable(true);
		// setClosable(true);
		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		// panel.setPreferredSize(new Dimension(400, 80));
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

		String[] array0 = { "���������", "ȼ����", "�������" };// ,"�����ҿռ����"
		for (int i = 0; i < array0.length; i++) {
			choice.addItem(array0[i]);

		}
		panel.add(choice);

		final JLabel label_q1 = new JLabel();
		label_q1.setText("������ؼ��֣�");
		panel_0.add(label_q1);

		FSDD = new JTextField(20);
		FSDD.setPreferredSize(new Dimension(10, 20));
		panel.add(FSDD);

		final JButton buttonQue = new JButton();
		buttonQue.setText("��ѯ");
		buttonQue.addActionListener(new ButtonAddListener());
		panel.add(buttonQue);

		// //////////////////////////////////////////

		final JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout());
		getContentPane().add(panel_1);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(0, 200));
		// panel_1.add(scrollPane);
		panel_1.add(scrollPane, BorderLayout.NORTH);
		// model=new DefaultTableModel();
		// Object[][] results=getFileStates(Dao.selectBookCategory());
		// model.setDataVector(results,columnNames);

		final DefaultTableModel model = new DefaultTableModel();
		Object[][] results = getFileStates(Dao.selectFireType());// �����˱�������
		model.setDataVector(results, columnNames);

		table = new JTable();
		table.setModel(model);
		table.addMouseListener(new TableListener());
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		final JPanel panel_2 = new JPanel();
		// panel_1.add(panel_2);
		// nady 20141015
		final GridLayout gridLayout = new GridLayout(0, 4);
		gridLayout.setVgap(9);
		gridLayout.setHgap(5);
		panel_2.setLayout(gridLayout);
		panel_2.setPreferredSize(new Dimension(0, 80));
		panel_1.add(panel_2, BorderLayout.SOUTH);

		final JLabel label_BH = new JLabel();
		label_BH.setHorizontalAlignment(SwingConstants.LEFT);
		label_BH.setPreferredSize(new Dimension(0, 0));
		label_BH.setMinimumSize(new Dimension(0, 0));
		panel_2.add(label_BH);
		label_BH.setText("     ��������ţ�");

		GZBH = new JTextField(20);
		GZBH.setPreferredSize(new Dimension(0, 0));
		panel_2.add(GZBH);

		// /RuleId = new JTextField();
		// RuleId.setFocusable(false);
		// panel_2.add(RuleId);

		final JLabel lLB = new JLabel();
		lLB.setText("     ����������ƣ�");
		panel_2.add(lLB);

		// TLB = new JTextField();
		// panel_2.add(TLB);

		choice = new JComboBox();
		// String[] array={"ͼ������","ͼ������"};
		String[] array2 = { "һ�㽨������", "�߲㽨������", "���¿ռ����", "�������", "һ���������",
				"һ���������", "�ж��������", "¶�����", "�������޻���", "��ͨ���߻���", "һ���Ի���" };// ,"�����ҿռ����"
		for (int i = 0; i < array2.length; i++) {
			choice.addItem(array2[i]);

		}
		panel_2.add(choice);

		final JLabel label = new JLabel();
		label.setText("     ȼ�����ţ�");
		panel_2.add(label);

		RSWBH = new JTextField(20);
		RSWBH.setPreferredSize(new Dimension(0, 0));
		panel_2.add(RSWBH);

		/*
		 * choice=new JComboBox(); //String[] array={"ͼ������","ͼ������"}; String[]
		 * array1
		 * ={"שľ�ṹ���ƶ��ṹ�����סլ��ֿ�","���ڶ�ʮ���׵Ľ�����","���������������̳�","ʯ�ͻ�����λ���͹޻��������乤��"
		 * ,"��Ȼ�����͹ܵ�������޻��������乤��"
		 * ,"�������嵥λ","��ʳ�п��ľ�ĳ��򵾲ݳ�","�𳵻򴬲���ɻ�������","������������������"};//,"�����ҿռ����"
		 * for(int i=0;i<array1.length;i++){ choice.addItem(array1[i]);
		 */

		// }
		// panel_2.add(choice);

		final JLabel label_8 = new JLabel();
		label_8.setText("     Ƶ   �ʣ�");
		panel_2.add(label_8);

		// kxd = new JTextField();
		// kxd.setDocument(new MyDocument(30));
		// panel_2.add(kxd);

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

		final JButton buttonMod = new JButton();
		buttonMod.setText("�޸�");
		buttonMod.addActionListener(new ButtonAddListener());
		panel_4.add(buttonMod);

		final JButton buttonDel = new JButton();
		buttonDel.setText("ɾ��");
		buttonDel.addActionListener(new ButtonAddListener());
		panel_4.add(buttonDel);

		final JButton buttonExit = new JButton();
		buttonExit.setText("����");
		buttonExit.addActionListener(new CloseActionListener());
		panel_4.add(buttonExit);
		setVisible(true);
		//

	}

	class TableListener extends MouseAdapter {
		@Override
		public void mouseClicked(final MouseEvent e) {

			/*
			 * int selRow = table.getSelectedRow();
			 * RuleId.setText(table.getValueAt(selRow, 0).toString().trim());
			 * bookTypeModel.setSelectedItem(table.getValueAt(selRow,
			 * 1).toString().trim()); days.setText(table.getValueAt(selRow,
			 * 2).toString().trim()); TLB.setText(table.getValueAt(selRow,
			 * 3).toString().trim());
			 */

		}
	}

	class ButtonAddListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object selectedItem = bookTypeModel.getSelectedItem();

			// int
			// i=Dao.UpdatebookType(RuleId.getText().trim(),selectedItem.toString(),
			// days.getText().trim());//,fk.getText().trim());
			// System.out.println(i);
			// if(i==1){
			// JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
			// Object[][] results=getFileStates(Dao.selectBookCategory());
			// model.setDataVector(results,columnNames);
			// table.setModel(model);

			// }
		}
	}

	class CloseActionListener implements ActionListener { // ��ӹرհ�ť���¼�������
		@Override
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}
}
