package com.wsy;

import java.awt.BorderLayout;
import java.awt.Dimension;
//import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

/////
import com.wsy.iframe.LoginIFrame;
import com.wsy.util.CreatecdIcon;

////Nady

/**
 * ������
 * 
 */
public class FireFighting extends JFrame {
	// Desktop Pane��һ�������Layered pane,����������������(Vitual Desktop).
	// ��������ʾ�������ڶ�Internal Frame֮��Ĳ�ι�ϵ��
	private static final JDesktopPane DESKTOP_PANE = new JDesktopPane();

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new LoginIFrame();// ��¼����
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void addIFame(JInternalFrame iframe) { // ����Ӵ���ķ���
		DESKTOP_PANE.add(iframe);
	}

	public FireFighting() {
		super();

		URL iconURL = getClass().getResource("/logo.png");
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());

		try {
			// ���ڵ�Ƥ��
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}

		setLocationByPlatform(true);

		setTitle("������������֧��ϵͳ");
		setLocationByPlatform(true);
		setSize(880, 600);
		// this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ����ر�ʱ�Ĳ��� �˳�����
		this.setResizable(false);// ������󻯰�ť
		// ���ô����˵����ķ���
		JMenuBar menuBar = createMenu();
		setJMenuBar(menuBar);
		// ���ô����������ķ���
		JToolBar toolBar = createToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);

		final JLabel label = new JLabel();
		label.setBounds(0, 0, 0, 0);
		label.setIcon(null);

		// ���屳��
		DESKTOP_PANE.addComponentListener(new ComponentAdapter() {
			public void componentResized(final ComponentEvent e) {
				Dimension size = e.getComponent().getSize();
				label.setSize(e.getComponent().getSize());
				label.setText("<html><img width=" + size.width + " height="
						+ size.height + " src='"
						+ this.getClass().getResource("/backImg.jpg")
						+ "'></html>");
			}
		});
		DESKTOP_PANE.add(label, new Integer(Integer.MIN_VALUE));
		getContentPane().add(DESKTOP_PANE);
	}

	/**
	 * ����������
	 * 
	 * @return JToolBar
	 */
	private JToolBar createToolBar() { // �����������ķ���
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBorder(new BevelBorder(BevelBorder.RAISED));

		// �ڹ����������ǲ����������Ӱ�ť
		// JButton solutionAddButton=new JButton(MenuActions.SOLUTION_ADD);
		JButton solutionAddButton = new JButton(MenuActions.DECISION_SEARCH);

		// ImageIcon icon=new
		// ImageIcon(FireFighting.class.getResource("/solutionAddtb.png"));//��Ӳ˵���ͼ��
		ImageIcon icon = new ImageIcon(
				FireFighting.class.getResource("/solutionAddtb.png"));// ��Ӳ˵���ͼ��
		solutionAddButton.setIcon(icon);
		solutionAddButton.setHideActionText(true);
		toolBar.add(solutionAddButton);

		// �ڹ�������ӻ�����������Ӱ�ť
		JButton FireTypeAddButton = new JButton(MenuActions.FIRETYPE_ADD);
		ImageIcon bookTypeAddicon = CreatecdIcon.add("fireTypeAddtb.png");// ����ͼ�귽��
		FireTypeAddButton.setIcon(bookTypeAddicon);
		FireTypeAddButton.setHideActionText(true);
		toolBar.add(FireTypeAddButton);

		// �ڹ�������ӻ��ּ�������޸İ�ť
		JButton FiretypeModiAndDelButton = new JButton(
				MenuActions.FIRETYPE_MODIFY);
		ImageIcon FiretypeModiAndDelicon = CreatecdIcon
				.add("firetypeModiAndDeltb.png");// ����ͼ�귽��
		FiretypeModiAndDelButton.setIcon(FiretypeModiAndDelicon);
		FiretypeModiAndDelButton.setHideActionText(true);
		toolBar.add(FiretypeModiAndDelButton);

		// �ڹ�������ӻ��ּ��������Ӱ�ť
		JButton FirelevelAddButton = new JButton(MenuActions.FIRELEVEL_ADD);
		ImageIcon firelevelAddicon = CreatecdIcon.add("firelevelAddtb.png");// ����ͼ�귽��
		FirelevelAddButton.setIcon(firelevelAddicon);
		FirelevelAddButton.setHideActionText(true);
		toolBar.add(FirelevelAddButton);

		// �ڹ�������ӻ��ּ�������޸İ�ť
		JButton FirelevelModiAndDelButton = new JButton(
				MenuActions.FIRELEVEL_MODIFY);
		ImageIcon FirelevelModiAndDelicon = CreatecdIcon
				.add("firelevelModiAndDeltb.png");// ����ͼ�귽��
		FirelevelModiAndDelButton.setIcon(FirelevelModiAndDelicon);
		FirelevelModiAndDelButton.setHideActionText(true);
		toolBar.add(FirelevelModiAndDelButton);

		// �ڹ���������˳���ť
		JButton ExitButton = new JButton(MenuActions.EXIT);
		ImageIcon Exiticon = CreatecdIcon.add("exittb.png");// ����ͼ�귽��
		ExitButton.setIcon(Exiticon);
		ExitButton.setHideActionText(true);
		toolBar.add(ExitButton);
		return toolBar;
	}

	/**
	 * �����˵���
	 */
	private JMenuBar createMenu() { // �����˵����ķ���
		JMenuBar menuBar = new JMenuBar();

		// ��������˵�
		JMenu ruleMenu = new JMenu();

		ruleMenu.setIcon(CreatecdIcon.add("jcsjcd.jpg")); // ���˵�1
		{

			JMenu FireTypeManageMItem = new JMenu("����������");
			FireTypeManageMItem.add(MenuActions.FIRETYPE_ADD);
			FireTypeManageMItem.add(MenuActions.FIRETYPE_MODIFY);

			// FireTypeManageMItem.add(MenuActions.COMBURENT_ADD);

			JMenu FireLevelManagerMItem = new JMenu("���ּ������");
			FireLevelManagerMItem.add(MenuActions.FIRELEVEL_ADD);
			FireLevelManagerMItem.add(MenuActions.FIRELEVEL_MODIFY);

			JMenu Dispathmenu = new JMenu("��ǲ�������");
			Dispathmenu.add(MenuActions.SOLUTION_ADD);
			Dispathmenu.add(MenuActions.SOLUTION_MODIFY);

			ruleMenu.add(FireTypeManageMItem);
			ruleMenu.add(FireLevelManagerMItem);
			ruleMenu.add(Dispathmenu);
			ruleMenu.addSeparator();

			ruleMenu.add(MenuActions.EXIT);
		}

		// ���߹���˵�
		JMenu decisionManageMenu = new JMenu();

		decisionManageMenu.setIcon(CreatecdIcon.add("jyglcd.jpg"));// ���˵�2
		{
			JMenu generateplanmenu = new JMenu("������ǲ����");
			// decisionManageMenu.add(generateplanmenu);
			decisionManageMenu.add(MenuActions.DECISION_SEARCH);

			JMenu auto_rule = new JMenu("�Զ����ɹ���");
			// decisionManageMenu.add(auto_rule);
			decisionManageMenu.add(MenuActions.LEARN);
		}
		// ϵͳά��
		JMenu sysManageMenu = new JMenu();
		sysManageMenu.setIcon(CreatecdIcon.add("jcwhcd.jpg"));

		JMenu userManageMItem = new JMenu("�û�����"); // �û�����
		userManageMItem.add(MenuActions.USER_ADD);
		userManageMItem.add(MenuActions.USER_MODIFY);
		sysManageMenu.add(MenuActions.MODIFY_PASSWORD);
		sysManageMenu.add(userManageMItem);

		menuBar.add(ruleMenu); // ���֪ʶ��������˵�

		menuBar.add(decisionManageMenu); // ��Ӿ��߹���������˵�

		menuBar.add(sysManageMenu); // ���ϵͳ����������˵�

		return menuBar;
	}
}
