package com.wsy.iframe;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

//import com.wsy.model.Reader;
import com.wsy.JComPz.Item;
import com.wsy.dao.Dao;
//import com.wsy.model.BookType;
import com.wsy.util.MyDocument;
import com.wsy.util.CreatecdIcon;

import com.wsy.model.Dispatch;
/**
 * 名称：图书添加窗体
 * 
 */


public class SolutionAddIFrame extends JInternalFrame {
	
	private JComboBox publisher;
	private JTable table;
	private JTextField   price,PQBH,FABH;
	private JFormattedTextField pubDate;
	private JTextField TRY;
	private JTextField TCL;
	private JTextField writer;
	private JTextField ISBN;
	private JTextField bookName;
	private JComboBox comboBox;
	private JComboBox bookType;
	private JButton buttonadd;
	private JButton buttonclose;
	private JComboBox choice;
	private String[] columnNames={ "派遣方案编号","火灾级别", "火灾类别", "派遣人员数量", "派遣车辆类型和数量", "频率", "可信度"};
	DefaultComboBoxModel bookTypeModel;
	DefaultComboBoxModel comboBoxModel;
	
	Map map=new HashMap();
	private Object[][] getFileStates(List list){
		Object[][] results=new Object[list.size()][columnNames.length];
		for(int i=0;i<list.size();i++){
			Dispatch dp=(Dispatch)list.get(i);
			
			//results[i][0]=reader.getId();
			results[i][0]=dp.getDispatchId();  //
		
			results[i][1]=dp.getTypeId();//
			results[i][2]=dp.getLevelId();//
		
			results[i][3]=dp.getFireFighterNum();//
			
			results[i][4]=dp.getEquipment();//
			
			results[i][5]=dp.getFrequency();//
			results[i][6]=dp.getConfidence();//
		
			
		}
		return results;
	}
	public SolutionAddIFrame() {
		super();
		
		
	
		setTitle("添加派遣方案规则");						// 设置窗体标题－－－必须
		this.setBounds(0, 0, 875,495);
		((BasicInternalFrameUI)getUI()).setNorthPane(null);			// 设置窗体位置和大小－－－必须

		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		//panel.setPreferredSize(new Dimension(400, 80));
		getContentPane().add(panel, BorderLayout.NORTH);
		
		final JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout());
		//getContentPane().add(panel_1);
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
      //需要加载到JTable的容器
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(0,40));
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		
		///nady 201500601
		final JPanel panel_0 = new JPanel();
		panel_0.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, false));
		//getContentPane().add(panel_0, BorderLayout.SOUTH);
		//getContentPane().add(panel_0, BorderLayout.SOUTH);
		panel.add(panel_0, BorderLayout.NORTH);
		final FlowLayout flowLayout0 = new FlowLayout();
		flowLayout0.setVgap(20);
		flowLayout0.setHgap(30);
		flowLayout0.setAlignment(FlowLayout.CENTER);
		panel_0.setLayout(flowLayout0);

		final JLabel label_q = new JLabel();
		label_q .setText("请选择查询类别：");
		panel_0.add(label_q);
		
		choice=new JComboBox();
		
		
        String[] array0={"派遣方案编号"};//,"地下室空间火灾"
		for(int i=0;i<array0.length;i++){
			choice.addItem(array0[i]);

		}
		panel_0.add(choice); 
		
		final JLabel label_q1 = new JLabel();
		label_q1 .setText("请输入关键字：");
		panel_0.add(label_q1);
		
		PQBH= new JTextField(20);
		PQBH.setPreferredSize(new Dimension(10,20));
		panel_0.add(PQBH);
		
		final JButton buttonQue = new JButton();
		buttonQue.setText("查询");
		//buttonQue.addActionListener(new ButtonAddListener());
		panel_0.add(buttonQue);
		
		////////////////////////////////////////////
		
		final JPanel panel_2 = new JPanel();
		// nady 20141014
		final GridLayout gridLayout2 = new GridLayout(0,4);
		gridLayout2.setVgap(9);
		panel_2.setLayout(gridLayout2);
		panel_2.setPreferredSize(new Dimension(0, 100));
		panel_1.add(panel_2, BorderLayout.SOUTH);
		
		final DefaultTableModel model=new DefaultTableModel();
		Object[][] results=getFileStates(Dao.selectDispath());//设置了表格的内容
		model.setDataVector(results,columnNames);
   
		
	
		//nady 20141014
		table = new JTable();//表格的参数是空的
		table.setModel(model);
		scrollPane.setViewportView(table);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		

//Nady 20141025
		final JLabel label_2 = new JLabel();
		
		
		
		final JLabel label = new JLabel();
		
		
		final JLabel label_BH = new JLabel();
		//label_BH .setHorizontalAlignment(SwingConstants.LEFT);
		label_BH .setPreferredSize(new Dimension(0, 0));
		label_BH .setMinimumSize(new Dimension(0, 0));
		panel_2.add(label_BH );
		label_BH .setText("     派遣方案编号：");

		FABH = new JTextField(20);
		FABH.setPreferredSize(new Dimension(0, 0));
		panel_2.add(FABH);
		
		
		label.setText("     火灾级别：");
		panel_2.add(label);

		bookType = new JComboBox();
		bookTypeModel= (DefaultComboBoxModel)bookType.getModel();
		
		//从数据库中取出图书类别
		//Nady   20141015
		///List list=Dao.selectBookCategory();
		//for(int i=0;i<list.size();i++){
			//BookType booktype=(BookType)list.get(i);
			//Item item=new Item();
			//item.setId((String)booktype.getId());
			//nady 20141015
			//item.setName((String)booktype.getTypeName());
			//item.setName((String)booktype.getDays());
			//bookTypeModel.addElement(item);
		//}
		
		
		//panel_2.add(bookType);
	


		//final JLabel label_2_1 = new JLabel();
		//label_2_1.setText("     火灾类别：");
		//panel_2.add(label_2_1);

	//	publisher = new JComboBox();
		//String[]array=new String[]{"一般气体","单体气体","垃圾火灾","重点单位","高层**","地下**","油漆储罐"};
		//publisher.setModel(new DefaultComboBoxModel(array));
		//panel_2.add(publisher);

		//final JLabel label_4 = new JLabel();
		//nady 20141015
		//label_4.setHorizontalAlignment(SwingConstants.CENTER);
		//label_4.setText("     消防方案（人员）：");
		//panel_2.add(label_4);

		TRY = new JTextField();
		TRY.setDocument(new MyDocument(10));
		panel_2.add(TRY);
		
		final JLabel label_6 = new JLabel();
		label_6.setText("     消防方案（车辆）：");
		panel_2.add(label_6);

		TCL= new JTextField();
		TCL.setDocument(new MyDocument(10));
		panel_2.add(TCL);
		
		final JLabel label_11 = new JLabel();
		label_11.setText("     频   率：");
		panel_2.add(label_11);

		
		
		comboBox = new JComboBox();
				comboBoxModel=(DefaultComboBoxModel)comboBox.getModel();
				String[] array=new String[]{"1.0---非常确定","0.9---确定","0.8---比较确定","0.7","0.6","0.5","0.4","0.3","0.2","0.1","0.0"};
				comboBox.setModel(new DefaultComboBoxModel(array));
				for(int i=1;i<array.length;i++){
				comboBox.setSelectedIndex(i);
					comboBox.setSelectedItem(array);
				}
		panel_2.add(comboBox);
		
		
		
		final JLabel label_12 = new JLabel();
		label_12.setText("     可信度：");
		panel_2.add(label_12);

	
		comboBox = new JComboBox();
				comboBoxModel=(DefaultComboBoxModel)comboBox.getModel();
				array=new String[]{"0.9","0.8","0.7","0.6","0.5","0.4","0.3","0.2","0.1"};
				comboBox.setModel(new DefaultComboBoxModel(array));
				for(int i=1;i<array.length;i++){
					comboBox.setSelectedIndex(i);
					comboBox.setSelectedItem(array);
				}
		panel_2.add(comboBox);

	

		final JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, false));
		getContentPane().add(panel_4, BorderLayout.SOUTH);
	final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setVgap(2);
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_4.setLayout(flowLayout);

		buttonadd= new JButton();
		buttonadd.addActionListener(new addBookActionListener());
		buttonadd.setText("添加");
		panel_4.add(buttonadd);

		buttonclose = new JButton();
		buttonclose.addActionListener(new CloseActionListener());
		buttonclose.setText("返回");
		panel_4.add(buttonclose);
         
		
		setVisible(true);											// 显示窗体可关闭－－－必须在添加所有控件之后执行该语句
	}
	class ISBNFocusListener extends FocusAdapter {
		public void focusLost(FocusEvent e){
			//if(!Dao.selectBookInfo(ISBN.getText().trim()).isEmpty()){
				//JOptionPane.showMessageDialog(null, "添加书号重复！");
				//return;
			//}
		}
	}
	class ISBNkeyListener extends KeyAdapter {
		public void keyPressed(final KeyEvent e) {
			if (e.getKeyCode() == 13){
				buttonadd.doClick();
			}
		
		}
	}
	class CloseActionListener implements ActionListener {			// 添加关闭按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}
	class addBookActionListener implements ActionListener {		// 添加按钮的单击事件监听器
		public void actionPerformed(final ActionEvent e) {
			
			if(bookName.getText().length()==0){
				JOptionPane.showMessageDialog(null, "事件名称文本框不可以为空");
				return;
			}
			
			//String ISBNs=ISBN.getText().trim();
			
			//分类
			String bookNames=bookName.getText().trim();
			
			Object selectedItem = bookType.getSelectedItem();
			if (selectedItem == null)
				return;
			Item item = (Item) selectedItem;
			String bookTypes=item.getId();
			
			
			//nady 20141015
			
			
			//String publishers=(String)publisher.getSelectedItem();
			Object selectedItem1=publisher.getSelectedItem();
			if (selectedItem == null)
				return;
			Item item1 = (Item) selectedItem;
			String publishers=item.getId();
			String translators=TRY.getText().trim();
			
			
			//int i=Dao.Insertbook(bookNames, bookTypes, publishers ,translators);	
			//if(i==1){
			
				JOptionPane.showMessageDialog(null, "添加成功");
				doDefaultCloseAction();
			}
		}
	//}
	//class NumberListener extends KeyAdapter {
		//public void keyTyped(KeyEvent e) {
			//String numStr="0123456789."+(char)8;
			//if(numStr.indexOf(e.getKeyChar())<0){
				//e.consume();
			//}
		//}
	}

//}
