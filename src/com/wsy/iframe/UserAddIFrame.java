package com.wsy.iframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.wsy.dao.Dao;
import com.wsy.model.FireType;
import com.wsy.model.Learn;
import com.wsy.util.MyDocument;




/////Nady
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;

import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;

//////

public class UserAddIFrame extends JInternalFrame {
	
	private String[] columnNames1={"编号","条件1", "条件2", "频率", "可信度"};
	private String[] columnNames2={"编号","结论1", "结论2", "频率", "可信度"};
	
	private Object[][] getFileStates(List list){
		Object[][] results=new Object[list.size()][columnNames1.length];
		for(int i=0;i<list.size();i++){
		
			FireType firetype=(FireType)list.get(i);
			Learn learn  = (Learn)list.get(i);
			
			results[i][0]=learn.getId();
			results[i][1]=learn.getCondition1();
			results[i][2]=learn.getCondition2();
			results[i][3]=learn.getF();
			results[i][4]=learn.getC();
		}
		return results;
	         		
	}
	
}
