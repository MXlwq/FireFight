package com.wsy.iframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


/////Nady
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.plaf.basic.BasicInternalFrameUI;
//////


import com.wsy.JComPz.Item;
import com.wsy.dao.Dao;
import com.wsy.iframe.FireTypeModiAndDelIFrame.CloseActionListener;
import com.wsy.model.Learn;
import com.wsy.model.SimiMsg;
import com.wsy.model.user;
import com.wsy.util.MyDocument;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class UserModiAndDelIFrame extends JInternalFrame {
	
	private JTable table;
	private String[] columnNames1={"编号","条件1","描述", "条件2","描述", "频率", "可信度"};
	private String[] columnNames2={"编号","结论1","描述", "结论2","描述", "频率", "可信度"};
	
	private Object[][] getFileStates(List list){
		Object[][] results=new Object[list.size()][columnNames1.length];
		for(int i=0;i<list.size();i++){
		
			Learn learn  = (Learn)list.get(i);
			
			results[i][0]=learn.getId();
			results[i][1]=learn.getCondition1();
			results[i][2]=learn.getDescription1();
			results[i][3]=learn.getCondition2();
			results[i][4]=learn.getDescription2();
			results[i][5]=learn.getF();
			results[i][6]=learn.getC();
		}
		return results;
	         		
	}
	
	private Object[][] getFileStates2(List list){
		Object[][] results=new Object[list.size()][columnNames2.length];
		for(int i=0;i<list.size();i++){
		
			SimiMsg simiMsg  = (SimiMsg)list.get(i);
			
			results[i][0]=simiMsg.getId();
			results[i][1]=simiMsg.getConclusion1();
			results[i][2]=simiMsg.getDescription1();
			results[i][3]=simiMsg.getConclusion2();
			results[i][4]=simiMsg.getDescription2();
			results[i][5]=simiMsg.getF();
			results[i][6]=simiMsg.getC();
		}
		return results;
	         		
	}
	
		public UserModiAndDelIFrame() {
		
		super();
		//nady20141014
		setTitle("学习知识");
		setBounds(0, 0, 875,495);
		((BasicInternalFrameUI)getUI()).setNorthPane(null);
		//setIconifiable(true);
		//setClosable(true);
		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		//panel.setPreferredSize(new Dimension(400, 80));
		getContentPane().add(panel, BorderLayout.NORTH);

		
		final JPanel panel_0 = new JPanel();
		panel_0.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, false));
		//getContentPane().add(panel_0, BorderLayout.SOUTH);
		final FlowLayout flowLayout0 = new FlowLayout();
		flowLayout0.setVgap(20);
		flowLayout0.setHgap(30);
		flowLayout0.setAlignment(FlowLayout.CENTER);
		panel.setLayout(flowLayout0);
	
		final JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout());
		getContentPane().add(panel_1);
		
		
	
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new java.awt.Dimension(193, 200));
		panel_1.add(scrollPane, BorderLayout.NORTH);


		final DefaultTableModel model=new DefaultTableModel();
		Object[][] results=getFileStates(Dao.selectLearnMsg());//设置了表格的内容
		model.setDataVector(results,columnNames1);
		
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);
		table.setEnabled(false); 
		final JPanel panel_2 = new JPanel();

		/*final GridLayout gridLayout = new GridLayout(0,4);
		gridLayout.setVgap(9);
		gridLayout.setHgap(5);
		panel_2.setLayout(gridLayout);
		panel_2.setPreferredSize(new Dimension(0,80));
		panel_1.add(panel_2, BorderLayout.SOUTH);*/
		
		final JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setPreferredSize(new java.awt.Dimension(193, 200));
		panel_1.add(scrollPane2, BorderLayout.SOUTH);
		
		final DefaultTableModel model2=new DefaultTableModel();
		Object[][] results2=getFileStates2(Dao.selectSimiMsg());//设置了表格的内容
		model2.setDataVector(results2,columnNames2);
		
		table = new JTable();
		table.setModel(model2);
		scrollPane2.setViewportView(table);
		table.setEnabled(false); 
		final JPanel panel_3 = new JPanel();

		/*final GridLayout gridLayout2 = new GridLayout(0,4);
		gridLayout2.setVgap(9);
		gridLayout2.setHgap(5);
		panel_3.setLayout(gridLayout2);
		panel_3.setPreferredSize(new Dimension(0,80));
		panel_1.add(panel_3, BorderLayout.SOUTH);*/
		
		
		
		//设置返回按钮的位置
		final JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, false));
		getContentPane().add(panel_4, BorderLayout.SOUTH);
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setVgap(2);
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_4.setLayout(flowLayout);
		
		//返回按钮
		final JButton buttonExit = new JButton();
		buttonExit.setText("返回");
		buttonExit.addActionListener(new CloseActionListener());
		panel_4.add(buttonExit);
		setVisible(true);
		
		setVisible(true);
	
	}
		
		class CloseActionListener implements ActionListener {			// 添加关闭按钮的事件监听器
			public void actionPerformed(final ActionEvent e) {
				doDefaultCloseAction();
			}
		}
		
}
