package com.wsy;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JInternalFrame;

//nady ���߹���
import com.wsy.iframe.DecisionIFrame;
//import com.wsy.iframe.SearchIFrame;
//nady  ֪ʶ�������ּ������
import com.wsy.iframe.FireLevelAddIFrame;
import com.wsy.iframe.FireLevelModiAndDelIFrame;
//nady  ֪ʶ��������������
import com.wsy.iframe.FireTypeAddIFrame;
//import com.wsy.iframe.ComburentAddIFrame;
import com.wsy.iframe.FireTypeModiAndDelIFrame;
////
import com.wsy.iframe.GengGaiMiMa;
//��ǲ����
import com.wsy.iframe.SolutionAddIFrame;
import com.wsy.iframe.SolutionModiAndDelIFrame;
import com.wsy.iframe.UserAddIFrame;
import com.wsy.iframe.UserModiAndDelIFrame;

/**
 * �˵��Ͱ�ť��Action����
 * 
 */
public class MenuActions {
	private static Map<String, JInternalFrame> frames; // �Ӵ��弯��

	// �û�����˵�
	public static PasswordModiAction MODIFY_PASSWORD; // �޸����봰�嶯��
	public static UserModiAction USER_MODIFY; // �޸��û����ϴ��嶯��
	public static UserAddAction USER_ADD; // �û���Ӵ��嶯��

	// ���߹���
	public static SearchAction DECISION_SEARCH;
	public static LearnAction LEARN;// ���嶯��
	public static GiveBackAction GIVE_BACK;

	// �������������
	public static FireTypeModiAction FIRETYPE_MODIFY; // ���嶯��
	public static FireTypeAddAction FIRETYPE_ADD; // ���嶯��

	// ȼ�������
	public static FireTypeModiAction COMBURENT_MODIFY; // ���嶯��
	public static ComburentAddAction COMBURENT_ADD; // ���嶯��

	// ���ּ���������
	public static FireLevelModiAction FIRELEVEL_MODIFY; // ���嶯��
	public static FireLevelAddAction FIRELEVEL_ADD; // ���嶯��

	// ������ǲ�����������
	public static SolutionModiAction SOLUTION_MODIFY; //
	public static SolutionAddAction SOLUTION_ADD; //

	public static ExitAction EXIT; // ϵͳ�˳�����

	static {
		frames = new HashMap<String, JInternalFrame>();

		MODIFY_PASSWORD = new PasswordModiAction();
		USER_MODIFY = new UserModiAction();
		USER_ADD = new UserAddAction();

		DECISION_SEARCH = new SearchAction();
		LEARN = new LearnAction(); // �Զ�ѧϰ�����¼�

		// �������
		FIRETYPE_MODIFY = new FireTypeModiAction();
		FIRETYPE_ADD = new FireTypeAddAction();

		// ȼ����
		FIRETYPE_MODIFY = new FireTypeModiAction();
		COMBURENT_ADD = new ComburentAddAction();

		// ���ּ������
		FIRELEVEL_MODIFY = new FireLevelModiAction();
		FIRELEVEL_ADD = new FireLevelAddAction();

		// ��ǲ��������
		SOLUTION_MODIFY = new SolutionModiAction();
		SOLUTION_ADD = new SolutionAddAction();
		EXIT = new ExitAction();
	}

	private static class PasswordModiAction extends AbstractAction {
		PasswordModiAction() {
			putValue(Action.NAME, "���Ŀ���");
			putValue(Action.LONG_DESCRIPTION, "�޸ĵ�ǰ�û�����");
			putValue(Action.SHORT_DESCRIPTION, "��������"); // �ڡ����Ŀ����ʾ����ʾ������

		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("��������") || frames.get("��������").isClosed()) {
				GengGaiMiMa iframe = new GengGaiMiMa();
				frames.put("��������", iframe);
				FireFighting.addIFame(frames.get("��������"));
			}
		}
	}

	private static class UserModiAction extends AbstractAction {
		UserModiAction() {
			super("�û���Ϣά��", null);
			putValue(Action.LONG_DESCRIPTION, "�û���Ϣά��");
			putValue(Action.SHORT_DESCRIPTION, "�û���Ϣά��");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("�û���Ϣά��")
					|| frames.get("�û���Ϣά��").isClosed()) {
				UserModiAndDelIFrame iframe = new UserModiAndDelIFrame();
				frames.put("�û���Ϣά��", iframe);
				FireFighting.addIFame(frames.get("�û���Ϣά��"));
			}
		}
	}

	private static class LearnAction extends AbstractAction {
		LearnAction() {
			super("�Զ����ɹ���", null);
			putValue(Action.LONG_DESCRIPTION, "�Զ����ɹ���");
			putValue(Action.SHORT_DESCRIPTION, "�Զ����ɹ���");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("�Զ����ɹ���")
					|| frames.get("�Զ����ɹ���").isClosed()) {
				UserModiAndDelIFrame iframe = new UserModiAndDelIFrame();
				frames.put("�Զ����ɹ���", iframe);
				FireFighting.addIFame(frames.get("�Զ����ɹ���"));
			}
		}
	}

	private static class UserAddAction extends AbstractAction {
		UserAddAction() {
			super("�û����", null);
			putValue(Action.LONG_DESCRIPTION, "����µ��û�");
			putValue(Action.SHORT_DESCRIPTION, "�û����");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("�û���Ϣ���")
					|| frames.get("�û���Ϣ���").isClosed()) {
				UserAddIFrame iframe = new UserAddIFrame();
				frames.put("�û���Ϣ���", iframe);
				FireFighting.addIFame(frames.get("�û���Ϣ���"));
			}

		}
	}

	// ������ǲ����
	private static class SearchAction extends AbstractAction {
		SearchAction() {

			super("������ǲ����", null);

		}

		public void actionPerformed(ActionEvent e) {

			if (!frames.containsKey("������ǲ����")
					|| frames.get("������ǲ����").isClosed()) {
				DecisionIFrame iframe = new DecisionIFrame();
				frames.put("������ǲ����", iframe);

				FireFighting.addIFame(frames.get("������ǲ����"));

			}
		}
	}

	private static class GiveBackAction extends AbstractAction {
		GiveBackAction() {
			super("���ּ����ж�", null);
			putValue(Action.LONG_DESCRIPTION, "ά�����ֵ�������");
			putValue(Action.SHORT_DESCRIPTION, "ά������������");

		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("����ж�����")
					|| frames.get("����ж�����").isClosed()) {
				DecisionIFrame iframe = new DecisionIFrame();
				frames.put("����ж�����", iframe);
				FireFighting.addIFame(frames.get("����ж�����"));
			}
		}
	}

	// �������\�������������\����������
	private static class FireTypeModiAction extends AbstractAction {
		FireTypeModiAction() {
			super("ά������������", null);
			putValue(Action.LONG_DESCRIPTION, "ά�����ֵ�������");
			putValue(Action.SHORT_DESCRIPTION, "ά������������");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("ά������������")
					|| frames.get("ά������������").isClosed()) {
				FireTypeModiAndDelIFrame iframe = new FireTypeModiAndDelIFrame();
				frames.put("ά������������", iframe);
				FireFighting.addIFame(frames.get("ά������������"));
			}
		}
	}

	// �������\�������������\����������
	private static class FireTypeAddAction extends AbstractAction {
		FireTypeAddAction() {
			super("��ӻ���������", null);
			putValue(Action.LONG_DESCRIPTION, "����µĻ���������");
			putValue(Action.SHORT_DESCRIPTION, "��ӻ���������");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("��ӻ���������")
					|| frames.get("��ӻ���������").isClosed()) {
				FireTypeAddIFrame iframe = new FireTypeAddIFrame();
				frames.put("��ӻ���������", iframe);
				FireFighting.addIFame(frames.get("��ӻ���������"));
			}
		}
	}

	private static class ComburentAddAction extends AbstractAction {
		ComburentAddAction() {
			super("���ȼ�������", null);
			putValue(Action.LONG_DESCRIPTION, "���ȼ�������");
			putValue(Action.SHORT_DESCRIPTION, "���ȼ�������");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("���ȼ�������")
					|| frames.get("���ȼ�������").isClosed()) {
				// ComburentAddIFrame iframe=new ComburentAddIFrame();
				// frames.put("���ȼ�������", iframe);
				FireFighting.addIFame(frames.get("���ȼ�������"));
			}
		}
	}

	// �������\���ּ���������\���ּ����޸�
	private static class FireLevelModiAction extends AbstractAction {
		FireLevelModiAction() {
			super("ά�����ּ������", null);
			putValue(Action.LONG_DESCRIPTION, "ά�����ּ������");
			putValue(Action.SHORT_DESCRIPTION, "ά�����ּ���");
		}

		public void actionPerformed(ActionEvent e) {

			if (!frames.containsKey("ά�����ּ������")
					|| frames.get("ά�����ּ������").isClosed()) {
				FireLevelModiAndDelIFrame iframe = new FireLevelModiAndDelIFrame();
				frames.put("ά�����ּ������", iframe);
				FireFighting.addIFame(frames.get("ά�����ּ������"));
			}
		}
	}

	// �������\���ּ���������\���ּ������
	private static class FireLevelAddAction extends AbstractAction {
		FireLevelAddAction() {
			super("��ӻ��ּ������", null);
			putValue(Action.LONG_DESCRIPTION, "��ӻ��ּ������");
			putValue(Action.SHORT_DESCRIPTION, "��ӻ��ּ������");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("��ӻ��ּ������")
					|| frames.get("��ӻ��ּ�����ع���").isClosed()) {
				FireLevelAddIFrame iframe = new FireLevelAddIFrame();
				frames.put("��ӻ��ּ������", iframe);
				FireFighting.addIFame(frames.get("��ӻ��ּ������"));
			}
		}
	}

	// �������\��ǲ�����������\���ּ����޸�
	private static class SolutionModiAction extends AbstractAction {
		SolutionModiAction() {
			super("ά����ǲ��������", null);
			putValue(Action.LONG_DESCRIPTION, "ά����ǲ��������");
			putValue(Action.SHORT_DESCRIPTION, "ά����ǲ��������");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("ά����ǲ��������")
					|| frames.get("ά����ǲ��������").isClosed()) {
				SolutionModiAndDelIFrame iframe = new SolutionModiAndDelIFrame(); // ��ܵ�����
				frames.put("ά����ǲ��������", iframe);
				FireFighting.addIFame(frames.get("ά����ǲ��������"));
			}
		}
	}

	// �������\��ǲ�����������\���ּ������
	private static class SolutionAddAction extends AbstractAction { // ͼ����Ϣ��ӣ������Ѿ�ʵ�֣������
		SolutionAddAction() {

			super("�����ǲ��������", null);
			// super();
			putValue(Action.LONG_DESCRIPTION, "�����ǲ��������");
			putValue(Action.SHORT_DESCRIPTION, "�����ǲ��������");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("�����ǲ��������")
					|| frames.get("�����ǲ��������").isClosed()) {
				SolutionAddIFrame iframe = new SolutionAddIFrame();
				frames.put("�����ǲ��������", iframe);
				FireFighting.addIFame(frames.get("�����ǲ��������"));
			}
		}
	}

	private static class ExitAction extends AbstractAction { // �˳�ϵͳ����
		public ExitAction() {
			super("�˳�ϵͳ", null);
			putValue(Action.LONG_DESCRIPTION, "�˳�ϵͳ");
			putValue(Action.SHORT_DESCRIPTION, "�˳�ϵͳ");
		}

		public void actionPerformed(final ActionEvent e) {
			System.exit(0);
		}
	}

	private MenuActions() {
		super();
	}

}
