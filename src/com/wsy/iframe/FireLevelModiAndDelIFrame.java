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
	// private String[] columnNames={ "燃烧面积", "燃烧容积", "呼叫次数", "燃烧物","被困人数",
	// "火灾级别"};
	private String[] columnNames = { "级别编号", "级别名称", "频率", "可信度", "燃烧面积编号",
			"燃烧容积编号", "呼叫次数编号", "所处阶段编号", "火势编号", "蔓延速度编号", "被困人数编号", "重伤人数编号",
			"死亡人数编号", "突变险情编号" };
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
		setTitle("维护火灾级别");
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
		label_q.setText("请选择查询类别：");
		panel.add(label_q);

		choice = new JComboBox();

		String[] array0 = { "火灾级别编号", "火灾级别" };// ,"地下室空间火灾"
		for (int i = 0; i < array0.length; i++) {
			choice.addItem(array0[i]);

		}
		panel.add(choice);

		final JLabel label_q1 = new JLabel();
		label_q1.setText("请输入关键字：");
		panel.add(label_q1);

		HZJB = new JTextField(20);
		HZJB.setPreferredSize(new Dimension(10, 20));
		panel.add(HZJB);

		final JButton buttonQue = new JButton();
		buttonQue.setText("查询");
		// buttonQue.addActionListener(new ButtonAddListener());
		panel.add(buttonQue);

		// //////////////////////////////////////////

		final JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout());
		getContentPane().add(panel_1);
		// 需要加载到JTable的容器
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(400, 130));
		panel_1.add(scrollPane, BorderLayout.NORTH);

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
		table.setEnabled(false); // nady添加，使表格不可编辑
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

		final JLabel LRSW = new JLabel();
		LRSW.setText("     所处阶段（前件）：");
		panel_2.add(LRSW);

		TRSW = new JTextField();
		TRSW.setDocument(new MyDocument(30));
		panel_2.add(TRSW);

		final JLabel LHJCS = new JLabel();
		LHJCS.setText("     呼叫次数（前件）：");
		panel_2.add(LHJCS);

		THJCS = new JTextField();
		THJCS.setDocument(new MyDocument(30));
		panel_2.add(THJCS);

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

		zy = new JTextField();
		zy.setDocument(new MyDocument(30));
		panel_2.add(zy);

		final JLabel label_8 = new JLabel();
		label_8.setText("     频   率：");
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
		label_7.setText("     可信程度：");
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
		button.setText("修改");
		button.addActionListener(new ModiButtonListener(model));

		final JButton buttonDel = new JButton();
		panel_4.add(buttonDel);
		buttonDel.setText("删除");
		buttonDel.addActionListener(new DelButtonListener(model));
		setVisible(true);

		final JButton buttonExit = new JButton();
		buttonExit.setText("返回");
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
			JOptionPane.showMessageDialog(null, "删除成功");
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
		JOptionPane.showMessageDialog(null, "燃烧面积文本框不可为空");
		return;
		// }
		// if(age.getText().length()==0){
		// JOptionPane.showMessageDialog(null, "规则前件文本框不可为空");
		// return;
		// }

		// if(zy.getText().length()==0){
		// JOptionPane.showMessageDialog(null, "规则后件文本框不可为空");
		// return;
		// }

		// if(maxnumber.getText().length()==0){
		// JOptionPane.showMessageDialog(null, "火灾级别文本框不可为空");
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
	// JOptionPane.showMessageDialog(null, "修改成功");
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
		String numStr = "0123456789" + (char) 8;// 只允许输入数字与退格键
		if (numStr.indexOf(e.getKeyChar()) < 0) {
			e.consume();
		}
		// if(keepmoney.getText().length()>2||keepmoney.getText().length()<0){
		e.consume();
		// }
	}
}

class CloseActionListener implements ActionListener { // 添加关闭按钮的事件监听器
	@Override
	public void actionPerformed(final ActionEvent e) {
		// doDefaultCloseAction();
	}
}

// }
