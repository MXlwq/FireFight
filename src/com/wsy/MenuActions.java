package com.wsy;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JInternalFrame;

//nady 决策管理
import com.wsy.iframe.DecisionIFrame;
//import com.wsy.iframe.SearchIFrame;
//nady  知识库管理火灾级别管理
import com.wsy.iframe.FireLevelAddIFrame;
import com.wsy.iframe.FireLevelModiAndDelIFrame;
//nady  知识库管理火灾类别管理
import com.wsy.iframe.FireTypeAddIFrame;
//import com.wsy.iframe.ComburentAddIFrame;
import com.wsy.iframe.FireTypeModiAndDelIFrame;
////
import com.wsy.iframe.GengGaiMiMa;
//派遣方案
import com.wsy.iframe.SolutionAddIFrame;
import com.wsy.iframe.SolutionModiAndDelIFrame;
import com.wsy.iframe.UserAddIFrame;
import com.wsy.iframe.UserModiAndDelIFrame;

/**
 * 菜单和按钮的Action对象
 * 
 */
public class MenuActions {
	private static Map<String, JInternalFrame> frames; // 子窗体集合

	// 用户管理菜单
	public static PasswordModiAction MODIFY_PASSWORD; // 修改密码窗体动作
	public static UserModiAction USER_MODIFY; // 修改用户资料窗体动作
	public static UserAddAction USER_ADD; // 用户添加窗体动作

	// 决策管理
	public static SearchAction DECISION_SEARCH;
	public static LearnAction LEARN;// 窗体动作
	public static GiveBackAction GIVE_BACK;

	// 火灾类别规则管理
	public static FireTypeModiAction FIRETYPE_MODIFY; // 窗体动作
	public static FireTypeAddAction FIRETYPE_ADD; // 窗体动作

	// 燃烧物管理
	public static FireTypeModiAction COMBURENT_MODIFY; // 窗体动作
	public static ComburentAddAction COMBURENT_ADD; // 窗体动作

	// 火灾级别规则管理
	public static FireLevelModiAction FIRELEVEL_MODIFY; // 窗体动作
	public static FireLevelAddAction FIRELEVEL_ADD; // 窗体动作

	// 火灾派遣方案规则管理
	public static SolutionModiAction SOLUTION_MODIFY; //
	public static SolutionAddAction SOLUTION_ADD; //

	public static ExitAction EXIT; // 系统退出动作

	static {
		frames = new HashMap<String, JInternalFrame>();

		MODIFY_PASSWORD = new PasswordModiAction();
		USER_MODIFY = new UserModiAction();
		USER_ADD = new UserAddAction();

		DECISION_SEARCH = new SearchAction();
		LEARN = new LearnAction(); // 自动学习规则事件

		// 火灾类别
		FIRETYPE_MODIFY = new FireTypeModiAction();
		FIRETYPE_ADD = new FireTypeAddAction();

		// 燃烧物
		FIRETYPE_MODIFY = new FireTypeModiAction();
		COMBURENT_ADD = new ComburentAddAction();

		// 火灾级别管理
		FIRELEVEL_MODIFY = new FireLevelModiAction();
		FIRELEVEL_ADD = new FireLevelAddAction();

		// 派遣方案管理
		SOLUTION_MODIFY = new SolutionModiAction();
		SOLUTION_ADD = new SolutionAddAction();
		EXIT = new ExitAction();
	}

	private static class PasswordModiAction extends AbstractAction {
		PasswordModiAction() {
			putValue(Action.NAME, "更改口令");
			putValue(Action.LONG_DESCRIPTION, "修改当前用户密码");
			putValue(Action.SHORT_DESCRIPTION, "更换口令"); // 在“更改口令”提示中显示的文字

		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("更改密码") || frames.get("更改密码").isClosed()) {
				GengGaiMiMa iframe = new GengGaiMiMa();
				frames.put("更改密码", iframe);
				FireFighting.addIFame(frames.get("更改密码"));
			}
		}
	}

	private static class UserModiAction extends AbstractAction {
		UserModiAction() {
			super("用户信息维护", null);
			putValue(Action.LONG_DESCRIPTION, "用户信息维护");
			putValue(Action.SHORT_DESCRIPTION, "用户信息维护");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("用户信息维护")
					|| frames.get("用户信息维护").isClosed()) {
				UserModiAndDelIFrame iframe = new UserModiAndDelIFrame();
				frames.put("用户信息维护", iframe);
				FireFighting.addIFame(frames.get("用户信息维护"));
			}
		}
	}

	private static class LearnAction extends AbstractAction {
		LearnAction() {
			super("自动生成规则", null);
			putValue(Action.LONG_DESCRIPTION, "自动生成规则");
			putValue(Action.SHORT_DESCRIPTION, "自动生成规则");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("自动生成规则")
					|| frames.get("自动生成规则").isClosed()) {
				UserModiAndDelIFrame iframe = new UserModiAndDelIFrame();
				frames.put("自动生成规则", iframe);
				FireFighting.addIFame(frames.get("自动生成规则"));
			}
		}
	}

	private static class UserAddAction extends AbstractAction {
		UserAddAction() {
			super("用户添加", null);
			putValue(Action.LONG_DESCRIPTION, "添加新的用户");
			putValue(Action.SHORT_DESCRIPTION, "用户添加");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("用户信息添加")
					|| frames.get("用户信息添加").isClosed()) {
				UserAddIFrame iframe = new UserAddIFrame();
				frames.put("用户信息添加", iframe);
				FireFighting.addIFame(frames.get("用户信息添加"));
			}

		}
	}

	// 生成派遣方案
	private static class SearchAction extends AbstractAction {
		SearchAction() {

			super("生成派遣方案", null);

		}

		public void actionPerformed(ActionEvent e) {

			if (!frames.containsKey("生成派遣方案")
					|| frames.get("生成派遣方案").isClosed()) {
				DecisionIFrame iframe = new DecisionIFrame();
				frames.put("生成派遣方案", iframe);

				FireFighting.addIFame(frames.get("生成派遣方案"));

			}
		}
	}

	private static class GiveBackAction extends AbstractAction {
		GiveBackAction() {
			super("火灾级别判定", null);
			putValue(Action.LONG_DESCRIPTION, "维护火灾的类别规则");
			putValue(Action.SHORT_DESCRIPTION, "维护火灾类别规则");

		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("类别判定管理")
					|| frames.get("类别判定管理").isClosed()) {
				DecisionIFrame iframe = new DecisionIFrame();
				frames.put("类别判定管理", iframe);
				FireFighting.addIFame(frames.get("类别判定管理"));
			}
		}
	}

	// 规则管理\火灾类别规则管理\火灾类别添加
	private static class FireTypeModiAction extends AbstractAction {
		FireTypeModiAction() {
			super("维护火灾类别规则", null);
			putValue(Action.LONG_DESCRIPTION, "维护火灾的类别规则");
			putValue(Action.SHORT_DESCRIPTION, "维护火灾类别规则");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("维护火灾类别规则")
					|| frames.get("维护火灾类别规则").isClosed()) {
				FireTypeModiAndDelIFrame iframe = new FireTypeModiAndDelIFrame();
				frames.put("维护火灾类别规则", iframe);
				FireFighting.addIFame(frames.get("维护火灾类别规则"));
			}
		}
	}

	// 规则管理\火灾类别规则管理\火灾类别添加
	private static class FireTypeAddAction extends AbstractAction {
		FireTypeAddAction() {
			super("添加火灾类别规则", null);
			putValue(Action.LONG_DESCRIPTION, "添加新的火灾类别规则");
			putValue(Action.SHORT_DESCRIPTION, "添加火灾类别规则");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("添加火灾类别规则")
					|| frames.get("添加火灾类别规则").isClosed()) {
				FireTypeAddIFrame iframe = new FireTypeAddIFrame();
				frames.put("添加火灾类别规则", iframe);
				FireFighting.addIFame(frames.get("添加火灾类别规则"));
			}
		}
	}

	private static class ComburentAddAction extends AbstractAction {
		ComburentAddAction() {
			super("添加燃烧物规则", null);
			putValue(Action.LONG_DESCRIPTION, "添加燃烧物规则");
			putValue(Action.SHORT_DESCRIPTION, "添加燃烧物规则");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("添加燃烧物规则")
					|| frames.get("添加燃烧物规则").isClosed()) {
				// ComburentAddIFrame iframe=new ComburentAddIFrame();
				// frames.put("添加燃烧物规则", iframe);
				FireFighting.addIFame(frames.get("添加燃烧物规则"));
			}
		}
	}

	// 规则管理\火灾级别规则管理\火灾级别修改
	private static class FireLevelModiAction extends AbstractAction {
		FireLevelModiAction() {
			super("维护火灾级别规则", null);
			putValue(Action.LONG_DESCRIPTION, "维护火灾级别规则");
			putValue(Action.SHORT_DESCRIPTION, "维护火灾级别");
		}

		public void actionPerformed(ActionEvent e) {

			if (!frames.containsKey("维护火灾级别规则")
					|| frames.get("维护火灾级别规则").isClosed()) {
				FireLevelModiAndDelIFrame iframe = new FireLevelModiAndDelIFrame();
				frames.put("维护火灾级别规则", iframe);
				FireFighting.addIFame(frames.get("维护火灾级别规则"));
			}
		}
	}

	// 规则管理\火灾级别规则管理\火灾级别添加
	private static class FireLevelAddAction extends AbstractAction {
		FireLevelAddAction() {
			super("添加火灾级别规则", null);
			putValue(Action.LONG_DESCRIPTION, "添加火灾级别规则");
			putValue(Action.SHORT_DESCRIPTION, "添加火灾级别规则");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("添加火灾级别规则")
					|| frames.get("添加火灾级别相关规则").isClosed()) {
				FireLevelAddIFrame iframe = new FireLevelAddIFrame();
				frames.put("添加火灾级别规则", iframe);
				FireFighting.addIFame(frames.get("添加火灾级别规则"));
			}
		}
	}

	// 规则管理\派遣方案规则管理\火灾级别修改
	private static class SolutionModiAction extends AbstractAction {
		SolutionModiAction() {
			super("维护派遣方案规则", null);
			putValue(Action.LONG_DESCRIPTION, "维护派遣方案规则");
			putValue(Action.SHORT_DESCRIPTION, "维护派遣方案规则");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("维护派遣方案规则")
					|| frames.get("维护派遣方案规则").isClosed()) {
				SolutionModiAndDelIFrame iframe = new SolutionModiAndDelIFrame(); // 框架的名称
				frames.put("维护派遣方案规则", iframe);
				FireFighting.addIFame(frames.get("维护派遣方案规则"));
			}
		}
	}

	// 规则管理\派遣方案规则管理\火灾级别添加
	private static class SolutionAddAction extends AbstractAction { // 图书信息添加－－－已经实现，请参照
		SolutionAddAction() {

			super("添加派遣方案规则", null);
			// super();
			putValue(Action.LONG_DESCRIPTION, "添加派遣方案规则");
			putValue(Action.SHORT_DESCRIPTION, "添加派遣方案规则");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("添加派遣方案规则")
					|| frames.get("添加派遣方案规则").isClosed()) {
				SolutionAddIFrame iframe = new SolutionAddIFrame();
				frames.put("添加派遣方案规则", iframe);
				FireFighting.addIFame(frames.get("添加派遣方案规则"));
			}
		}
	}

	private static class ExitAction extends AbstractAction { // 退出系统动作
		public ExitAction() {
			super("退出系统", null);
			putValue(Action.LONG_DESCRIPTION, "退出系统");
			putValue(Action.SHORT_DESCRIPTION, "退出系统");
		}

		public void actionPerformed(final ActionEvent e) {
			System.exit(0);
		}
	}

	private MenuActions() {
		super();
	}

}
