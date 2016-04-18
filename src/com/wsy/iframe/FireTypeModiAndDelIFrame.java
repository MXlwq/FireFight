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
	private String[] columnNames = { "规则编号", "燃烧物", "火灾类别", "频率", "可信度" };

	DefaultComboBoxModel bookTypeModel;
	DefaultTableModel model;
	Map map;

	private Object[][] getFileStates(List list) {
		Object[][] results = new Object[list.size()][columnNames.length];
		for (int i = 0; i < list.size(); i++) {

			FireType firetype = (FireType) list.get(i);

			results[i][0] = firetype.getFiretypeid();// 获取火灾类别编号
			results[i][1] = firetype.getFiretypeName(); // 获取火灾类别

			results[i][2] = firetype.getComburentId(); // 获取火灾燃烧物
			// results[i][2]=firetype.getComnurentId();//获取火灾类别

			results[i][3] = firetype.getFrequency();// 频率
			results[i][4] = firetype.getConfidence();// 可信度
		}
		return results;

	}

	/**
	 * Create the frame
	 */
	public FireTypeModiAndDelIFrame() {
		super();
		// nady20141014
		setTitle("维护火灾类别规则");
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
		label_q.setText("请选择查询类别：");
		panel.add(label_q);

		choice = new JComboBox();

		String[] array0 = { "火灾类别编号", "燃烧物", "火灾类别" };// ,"地下室空间火灾"
		for (int i = 0; i < array0.length; i++) {
			choice.addItem(array0[i]);

		}
		panel.add(choice);

		final JLabel label_q1 = new JLabel();
		label_q1.setText("请输入关键字：");
		panel_0.add(label_q1);

		FSDD = new JTextField(20);
		FSDD.setPreferredSize(new Dimension(10, 20));
		panel.add(FSDD);

		final JButton buttonQue = new JButton();
		buttonQue.setText("查询");
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
		Object[][] results = getFileStates(Dao.selectFireType());// 设置了表格的内容
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
		label_BH.setText("     火灾类别编号：");

		GZBH = new JTextField(20);
		GZBH.setPreferredSize(new Dimension(0, 0));
		panel_2.add(GZBH);

		// /RuleId = new JTextField();
		// RuleId.setFocusable(false);
		// panel_2.add(RuleId);

		final JLabel lLB = new JLabel();
		lLB.setText("     火灾类别名称：");
		panel_2.add(lLB);

		// TLB = new JTextField();
		// panel_2.add(TLB);

		choice = new JComboBox();
		// String[] array={"图书名称","图书作者"};
		String[] array2 = { "一般建筑火灾", "高层建筑火灾", "地下空间火灾", "油类火灾", "一般气体火灾",
				"一般气体火灾", "有毒气体火灾", "露天火灾", "油气储罐火灾", "交通工具火灾", "一般性火灾" };// ,"地下室空间火灾"
		for (int i = 0; i < array2.length; i++) {
			choice.addItem(array2[i]);

		}
		panel_2.add(choice);

		final JLabel label = new JLabel();
		label.setText("     燃烧物编号：");
		panel_2.add(label);

		RSWBH = new JTextField(20);
		RSWBH.setPreferredSize(new Dimension(0, 0));
		panel_2.add(RSWBH);

		/*
		 * choice=new JComboBox(); //String[] array={"图书名称","图书作者"}; String[]
		 * array1
		 * ={"砖木结构或闷顶结构或居民住宅或仓库","高于二十四米的建筑物","地铁或隧道或地下商场","石油化工单位或储油罐或油类运输工具"
		 * ,"天然气输送管道或存气罐或气体运输工具"
		 * ,"特殊气体单位","粮食残酷或木材场或稻草场","火车或船舶或飞机或汽车","电器或单体汽车或垃圾"};//,"地下室空间火灾"
		 * for(int i=0;i<array1.length;i++){ choice.addItem(array1[i]);
		 */

		// }
		// panel_2.add(choice);

		final JLabel label_8 = new JLabel();
		label_8.setText("     频   率：");
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

		final JButton buttonMod = new JButton();
		buttonMod.setText("修改");
		buttonMod.addActionListener(new ButtonAddListener());
		panel_4.add(buttonMod);

		final JButton buttonDel = new JButton();
		buttonDel.setText("删除");
		buttonDel.addActionListener(new ButtonAddListener());
		panel_4.add(buttonDel);

		final JButton buttonExit = new JButton();
		buttonExit.setText("返回");
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
			// JOptionPane.showMessageDialog(null, "修改成功");
			// Object[][] results=getFileStates(Dao.selectBookCategory());
			// model.setDataVector(results,columnNames);
			// table.setModel(model);

			// }
		}
	}

	class CloseActionListener implements ActionListener { // 添加关闭按钮的事件监听器
		@Override
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}
}
