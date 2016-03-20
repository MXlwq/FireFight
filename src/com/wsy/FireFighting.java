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
 * 主窗体
 * 
 */
public class FireFighting extends JFrame {
	// Desktop Pane是一种特殊的Layered pane,用来建立虚拟桌面(Vitual Desktop).
	// 它可以显示并管理众多Internal Frame之间的层次关系。
	private static final JDesktopPane DESKTOP_PANE = new JDesktopPane();

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new LoginIFrame();// 登录窗口
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void addIFame(JInternalFrame iframe) { // 添加子窗体的方法
		DESKTOP_PANE.add(iframe);
	}

	public FireFighting() {
		super();

		URL iconURL = getClass().getResource("/logo.png");
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());

		try {
			// 窗口的皮肤
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}

		setLocationByPlatform(true);

		setTitle("城市消防决策支持系统");
		setLocationByPlatform(true);
		setSize(880, 600);
		// this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 窗体关闭时的操作 退出程序
		this.setResizable(false);// 禁用最大化按钮
		// 调用创建菜单栏的方法
		JMenuBar menuBar = createMenu();
		setJMenuBar(menuBar);
		// 调用创建工具栏的方法
		JToolBar toolBar = createToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);

		final JLabel label = new JLabel();
		label.setBounds(0, 0, 0, 0);
		label.setIcon(null);

		// 窗体背景
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
	 * 创建工具栏
	 * 
	 * @return JToolBar
	 */
	private JToolBar createToolBar() { // 创建工具栏的方法
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBorder(new BevelBorder(BevelBorder.RAISED));

		// 在工具栏添加派遣方案规则添加按钮
		// JButton solutionAddButton=new JButton(MenuActions.SOLUTION_ADD);
		JButton solutionAddButton = new JButton(MenuActions.DECISION_SEARCH);

		// ImageIcon icon=new
		// ImageIcon(FireFighting.class.getResource("/solutionAddtb.png"));//添加菜单栏图标
		ImageIcon icon = new ImageIcon(
				FireFighting.class.getResource("/solutionAddtb.png"));// 添加菜单栏图标
		solutionAddButton.setIcon(icon);
		solutionAddButton.setHideActionText(true);
		toolBar.add(solutionAddButton);

		// 在工具栏添加火灾类别规则添加按钮
		JButton FireTypeAddButton = new JButton(MenuActions.FIRETYPE_ADD);
		ImageIcon bookTypeAddicon = CreatecdIcon.add("fireTypeAddtb.png");// 创建图标方法
		FireTypeAddButton.setIcon(bookTypeAddicon);
		FireTypeAddButton.setHideActionText(true);
		toolBar.add(FireTypeAddButton);

		// 在工具栏添加火灾级别规则修改按钮
		JButton FiretypeModiAndDelButton = new JButton(
				MenuActions.FIRETYPE_MODIFY);
		ImageIcon FiretypeModiAndDelicon = CreatecdIcon
				.add("firetypeModiAndDeltb.png");// 创建图标方法
		FiretypeModiAndDelButton.setIcon(FiretypeModiAndDelicon);
		FiretypeModiAndDelButton.setHideActionText(true);
		toolBar.add(FiretypeModiAndDelButton);

		// 在工具栏添加火灾级别规则添加按钮
		JButton FirelevelAddButton = new JButton(MenuActions.FIRELEVEL_ADD);
		ImageIcon firelevelAddicon = CreatecdIcon.add("firelevelAddtb.png");// 创建图标方法
		FirelevelAddButton.setIcon(firelevelAddicon);
		FirelevelAddButton.setHideActionText(true);
		toolBar.add(FirelevelAddButton);

		// 在工具栏添加火灾级别规则修改按钮
		JButton FirelevelModiAndDelButton = new JButton(
				MenuActions.FIRELEVEL_MODIFY);
		ImageIcon FirelevelModiAndDelicon = CreatecdIcon
				.add("firelevelModiAndDeltb.png");// 创建图标方法
		FirelevelModiAndDelButton.setIcon(FirelevelModiAndDelicon);
		FirelevelModiAndDelButton.setHideActionText(true);
		toolBar.add(FirelevelModiAndDelButton);

		// 在工具栏添加退出按钮
		JButton ExitButton = new JButton(MenuActions.EXIT);
		ImageIcon Exiticon = CreatecdIcon.add("exittb.png");// 创建图标方法
		ExitButton.setIcon(Exiticon);
		ExitButton.setHideActionText(true);
		toolBar.add(ExitButton);
		return toolBar;
	}

	/**
	 * 创建菜单栏
	 */
	private JMenuBar createMenu() { // 创建菜单栏的方法
		JMenuBar menuBar = new JMenuBar();

		// 规则库管理菜单
		JMenu ruleMenu = new JMenu();

		ruleMenu.setIcon(CreatecdIcon.add("jcsjcd.jpg")); // 主菜单1
		{

			JMenu FireTypeManageMItem = new JMenu("火灾类别管理");
			FireTypeManageMItem.add(MenuActions.FIRETYPE_ADD);
			FireTypeManageMItem.add(MenuActions.FIRETYPE_MODIFY);

			// FireTypeManageMItem.add(MenuActions.COMBURENT_ADD);

			JMenu FireLevelManagerMItem = new JMenu("火灾级别管理");
			FireLevelManagerMItem.add(MenuActions.FIRELEVEL_ADD);
			FireLevelManagerMItem.add(MenuActions.FIRELEVEL_MODIFY);

			JMenu Dispathmenu = new JMenu("派遣规则管理");
			Dispathmenu.add(MenuActions.SOLUTION_ADD);
			Dispathmenu.add(MenuActions.SOLUTION_MODIFY);

			ruleMenu.add(FireTypeManageMItem);
			ruleMenu.add(FireLevelManagerMItem);
			ruleMenu.add(Dispathmenu);
			ruleMenu.addSeparator();

			ruleMenu.add(MenuActions.EXIT);
		}

		// 决策管理菜单
		JMenu decisionManageMenu = new JMenu();

		decisionManageMenu.setIcon(CreatecdIcon.add("jyglcd.jpg"));// 主菜单2
		{
			JMenu generateplanmenu = new JMenu("生成派遣方案");
			// decisionManageMenu.add(generateplanmenu);
			decisionManageMenu.add(MenuActions.DECISION_SEARCH);

			JMenu auto_rule = new JMenu("自动生成规则");
			// decisionManageMenu.add(auto_rule);
			decisionManageMenu.add(MenuActions.LEARN);
		}
		// 系统维护
		JMenu sysManageMenu = new JMenu();
		sysManageMenu.setIcon(CreatecdIcon.add("jcwhcd.jpg"));

		JMenu userManageMItem = new JMenu("用户管理"); // 用户管理
		userManageMItem.add(MenuActions.USER_ADD);
		userManageMItem.add(MenuActions.USER_MODIFY);
		sysManageMenu.add(MenuActions.MODIFY_PASSWORD);
		sysManageMenu.add(userManageMItem);

		menuBar.add(ruleMenu); // 添加知识库管理主菜单

		menuBar.add(decisionManageMenu); // 添加决策管理管理主菜单

		menuBar.add(sysManageMenu); // 添加系统管理管理主菜单

		return menuBar;
	}
}
