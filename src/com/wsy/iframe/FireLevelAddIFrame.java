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
import javax.swing.JFormattedTextField;
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

public class FireLevelAddIFrame extends JInternalFrame {

	private JTextField GBBH;
	// private JTable table;
	private ButtonGroup buttonGroup = new ButtonGroup();
	// private JFormattedTextField keepmoney;
	private JTextField tel;
	private JFormattedTextField date;
	private JFormattedTextField maxnumber;
	private JFormattedTextField bztime;
	private JTextField zjnumber;
	private JComboBox comboBox;
	private JTextField jibie;
	private JTextField TMJ;
	private JTextField TRJ;
	private JTextField TRSW;
	private JTextField THJCS;
	private JTextField TBKRS;
	// private JTextField age;
	private JTextField kxd;
	private JTextField readername;
	DefaultComboBoxModel comboBoxModel;
	private JTable table, table2;
	private JComboBox choice;
	String[] array;
	private String[] columnNames = { "级别编号", "级别名称", "频率", "可信度", "燃烧面积编号",
			"燃烧容积编号", "呼叫次数编号", "所处阶段编号", "火势编号", "蔓延速度编号", "被困人数编号", "重伤人数编号",
			"死亡人数编号", "突变险情编号" };
	DefaultComboBoxModel bookTypeModel;

	// DefaultTableModel model;

	/**
	 * Create the frame
	 */

	/**
	 * Create the frame
	 */
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

	public FireLevelAddIFrame() {
		super();
		// nady 20141014
		this.setTitle("添加火灾级别规则");
		// 设置窗体可关闭－－－必须
		// 设置窗体标题－－－必须
		this.setBounds(0, 0, 875, 495);
		((BasicInternalFrameUI) getUI()).setNorthPane(null);
		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		getContentPane().add(panel, BorderLayout.NORTH);

		final JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout());
		getContentPane().add(panel_1, BorderLayout.CENTER);

		// 需要加载到JTable的容器
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(400, 130));
		panel_1.add(scrollPane, BorderLayout.CENTER);

		// 此处定义了JTable的属性值
		final DefaultTableModel model = new DefaultTableModel();
		Object[][] results = getFileStates(Dao.selectFireLevel());// 设置了表格的内容
		model.setDataVector(results, columnNames);

		// Nady 20141014
		table = new JTable();// 表格的参数是空的
		table.setModel(model);
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.addMouseListener(new TableListener());

		/*
		 * for(Object X: results) System.out.println(X);
		 */
		/*
		 * for(int i=0;i<results.length;i++){ for(int
		 * j=0;j<results[i].length;j++){ System.out.print(results[i][j]+" "); }
		 * System.out.println(); }
		 */

		/*
		 * model.setDataVector(results,columnNames);
		 * 
		 * System.out.println(Arrays.toString(columnNames));
		 */

		// ////////////////////////////
		final JPanel panel_0 = new JPanel();
		panel_0.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1,
				false));

		panel_1.add(panel_0, BorderLayout.NORTH);
		final FlowLayout flowLayout0 = new FlowLayout();
		flowLayout0.setVgap(20);
		flowLayout0.setHgap(30);
		flowLayout0.setAlignment(FlowLayout.CENTER);
		panel_0.setLayout(flowLayout0);

		final JLabel label_q = new JLabel();
		label_q.setText("请选择查询类别：");
		panel_0.add(label_q);

		choice = new JComboBox();

		String[] array0 = { "火灾级别编号", "火灾级别" };// ,"地下室空间火灾"
		for (int i = 0; i < array0.length; i++) {
			choice.addItem(array0[i]);

		}
		panel_0.add(choice);

		final JLabel label_q1 = new JLabel();
		label_q1.setText("请输入关键字：");
		panel_0.add(label_q1);

		GBBH = new JTextField(20);
		GBBH.setPreferredSize(new Dimension(10, 20));
		panel_0.add(GBBH);

		final JButton buttonQue = new JButton();
		buttonQue.setText("查询");
		// buttonQue.addActionListener(new ButtonAddListener());
		panel_0.add(buttonQue);

		/*
		 * //此处定义了JTable的属性值 final DefaultTableModel model=new
		 * DefaultTableModel(); Object[][]
		 * results=getFileStates(Dao.selectFireLevel());//设置了表格的内容
		 * model.setDataVector(results,columnNames);
		 * 
		 * 
		 * 
		 * //nady 20141014 table = new JTable();//表格的参数是空的
		 * table.setModel(model); scrollPane.setViewportView(table);
		 * table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		 */
		// //////////////////////////////////////////

		final JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		// nady 20141014
		final GridLayout gridLayout2 = new GridLayout(0, 4);
		gridLayout2.setVgap(9);
		panel_2.setLayout(gridLayout2);
		panel_2.setPreferredSize(new Dimension(0, 250));
		// table1.addMouseListener(new TableListener());

		// ///////////////////////////////////////////////////////////////////////////////////

		final JLabel label_BH = new JLabel();
		// label_BH .setHorizontalAlignment(SwingConstants.LEFT);

		label_BH.setPreferredSize(new Dimension(0, 0));
		label_BH.setMinimumSize(new Dimension(0, 0));
		panel_2.add(label_BH);
		label_BH.setText("     火灾级别编号：");

		GBBH = new JTextField(20);
		GBBH.setPreferredSize(new Dimension(0, 0));
		panel_2.add(GBBH);

		final JLabel LMJ = new JLabel();
		LMJ.setText("     火灾面积（前件）：");
		panel_2.add(LMJ);

		TMJ = new JTextField();
		TMJ.setDocument(new MyDocument(30));
		panel_2.add(TMJ);

		final JLabel LRJ = new JLabel();
		LRJ.setText("     火灾容积（前件）：");
		panel_2.add(LRJ);

		TRJ = new JTextField();
		TRJ.setDocument(new MyDocument(30));
		panel_2.add(TRJ);

		final JLabel LHJCS = new JLabel();
		LHJCS.setText("     所处阶段（前件）：");
		panel_2.add(LHJCS);

		THJCS = new JTextField();
		THJCS.setDocument(new MyDocument(30));
		panel_2.add(THJCS);

		final JLabel LBKRS = new JLabel();
		LBKRS.setText("     呼叫次数（前件）：");
		panel_2.add(LBKRS);

		TBKRS = new JTextField();
		TBKRS.setDocument(new MyDocument(30));
		panel_2.add(TBKRS);

		final JLabel HS = new JLabel();
		HS.setText("     火灾火势（前件）：");
		panel_2.add(HS);

		TBKRS = new JTextField();
		TBKRS.setDocument(new MyDocument(30));
		panel_2.add(TBKRS);

		final JLabel MYZK = new JLabel();
		MYZK.setText("     蔓延状况（前件）：");
		panel_2.add(MYZK);

		TBKRS = new JTextField();
		TBKRS.setDocument(new MyDocument(30));
		panel_2.add(TBKRS);

		final JLabel BKRS = new JLabel();
		BKRS.setText("     被困人数（前件）：");
		panel_2.add(BKRS);

		TBKRS = new JTextField();
		TBKRS.setDocument(new MyDocument(30));
		panel_2.add(TBKRS);

		final JLabel ZSRS = new JLabel();
		ZSRS.setText("     重伤人数（前件）：");
		panel_2.add(ZSRS);

		TBKRS = new JTextField();
		TBKRS.setDocument(new MyDocument(30));
		panel_2.add(TBKRS);

		final JLabel SWRS = new JLabel();
		SWRS.setText("     死亡人数（前件）：");
		panel_2.add(SWRS);

		TBKRS = new JTextField();
		TBKRS.setDocument(new MyDocument(30));
		panel_2.add(TBKRS);

		final JLabel TBXQ = new JLabel();
		TBXQ.setText("     突变险情（前件）：");
		panel_2.add(TBXQ);

		TBKRS = new JTextField();
		TBKRS.setDocument(new MyDocument(30));
		panel_2.add(TBKRS);

		final JLabel KKJB = new JLabel();
		KKJB.setText("     可控级别（前件）：");
		panel_2.add(KKJB);

		TBKRS = new JTextField();
		TBKRS.setDocument(new MyDocument(30));
		panel_2.add(TBKRS);

		final JLabel label_5 = new JLabel();
		label_5.setText("     火灾级别（后件）：");
		panel_2.add(label_5);

		jibie = new JTextField();
		jibie.setDocument(new MyDocument(30));
		panel_2.add(jibie);

		final JLabel label_18 = new JLabel();
		label_18.setHorizontalAlignment(SwingConstants.LEFT);
		// label_8 .setPreferredSize(new Dimension(0, 0));
		// label_8 .setMinimumSize(new Dimension(0, 0));
		label_18.setText("  ");
		panel_2.add(label_18);

		/*
		 * final JPanel panel_5 = new JPanel(); panel_5.setBorder(new
		 * LineBorder(SystemColor.activeCaptionBorder, 1, false));
		 * panel_2.add(panel_5, BorderLayout.SOUTH);
		 * //getContentPane().add(panel_2, BorderLayout.SOUTH); final FlowLayout
		 * flowLayout5 = new FlowLayout(); flowLayout5.setVgap(10);
		 * flowLayout5.setHgap(5); flowLayout5.setAlignment(FlowLayout.RIGHT);
		 * panel_5.setLayout(flowLayout5);
		 */

		final JLabel label_121 = new JLabel();
		label_121.setText("         ");
		panel_2.add(label_121);

		final JLabel label_11 = new JLabel();
		label_11.setText("     频   率：");
		panel_2.add(label_11);

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

		final JLabel label_12 = new JLabel();
		label_12.setText("     可信度：");
		panel_2.add(label_12);

		comboBox = new JComboBox();
		comboBoxModel = (DefaultComboBoxModel) comboBox.getModel();
		comboBox.setModel(new DefaultComboBoxModel(array));
		panel_2.add(comboBox);
		array = new String[] { "1.0---非常确定", "0.9---确定", "0.8---比较确定", "0.7",
				"0.6", "0.5", "0.4", "0.3", "0.2", "0.1", "0.0" };
		for (int i = 1; i < array.length; i++) {
			comboBox.setSelectedIndex(i);
			comboBox.setSelectedItem(array);
		}
		array = new String[] { "0.9", "0.8", "0.7", "0.6", "0.5", "0.4", "0.3",
				"0.2", "0.1" };
		for (int i = 1; i < array.length; i++) {
			comboBox.setSelectedIndex(i);
			comboBox.setSelectedItem(array);
		}

		final JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1,
				false));
		getContentPane().add(panel_4, BorderLayout.SOUTH);
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setVgap(2);
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.CENTER);
		panel_4.setLayout(flowLayout);

		final JButton save = new JButton();
		panel_4.add(save);
		save.setText("保存");

		final JButton back = new JButton();
		panel_4.add(back);
		back.setText("返回");
		back.addActionListener(new CloseActionListener());

		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				doDefaultCloseAction();
			}
		});
		setVisible(true);
		//
	}

	class DateListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if (bztime.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "时间格式请使用\"2007-05-10\"格式");
			}
		}
	}

	class NumberListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			String numStr = "0123456789" + (char) 8;
			if (numStr.indexOf(e.getKeyChar()) < 0) {
				e.consume();
			}
		}
	}

	class TableListener extends MouseAdapter {
		@Override
		public void mouseClicked(final MouseEvent e) {

			/*
			 * //int selRow = table.getSelectedRow();
			 * RuleId.setText(table.getValueAt(selRow, 0).toString().trim());
			 * bookTypeModel.setSelectedItem(table.getValueAt(selRow,
			 * 1).toString().trim()); days.setText(table.getValueAt(selRow,
			 * 2).toString().trim()); TLB.setText(table.getValueAt(selRow,
			 * 3).toString().trim());
			 */

		}
	}

	class ButtonAddListener implements ActionListener {
		private final JRadioButton button1;

		ButtonAddListener(JRadioButton button1) {
			this.button1 = button1;
		}

		@Override
		public void actionPerformed(final ActionEvent e) {

			if (TMJ.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "规则前件文本框不可为空");
				return;
			}

			if (jibie.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "规则后件文本框不可为空");
				return;
			}
			if (jibie.getText().length() > 20) {

			}
			if (maxnumber.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "火灾级别文本框不可为空");
				return;
			}

			String zj = String.valueOf(comboBox.getSelectedIndex());
			System.out.println(comboBox.getSelectedIndex());

			// int i=Dao.InsertReader(readername.getText().trim(), sex.trim(),
			// age.getText().trim(),zjnumber.getText().trim(),
			// Date.valueOf(date.getText().trim()),
			// maxnumber.getText().trim(),tel.getText().trim(),
			// Double.valueOf(keepmoney.getText().trim()),zj,zy.getText().trim(),Date.valueOf(bztime.getText().trim()),ISBN.getText().trim());
			// int i=Dao.InsertReader(readername.getText().trim(),
			// /TMJ.getText().trim(),jibie.getText().trim(),zj,zjnumber.getText().trim(),
			// maxnumber.getText().trim());
			// System.out.println(i);
			// if(i==1){
			// JOptionPane.showMessageDialog(null, "添加成功！");
			// doDefaultCloseAction();
		}

	}
	// }
	// class TelListener extends KeyAdapter {
	// public void keyTyped(KeyEvent e) {
	// String numStr="0123456789-"+(char)8;
	// if(numStr.indexOf(e.getKeyChar())<0){
	// e.consume();
	// }
}
// }
// class CloseActionListener implements ActionListener { // 添加关闭按钮的事件监听器
// public void actionPerformed(final ActionEvent e) {
// doDefaultCloseAction();
// }
// }

// }
