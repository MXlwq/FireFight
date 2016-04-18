package com.wsy.iframe;

import java.util.List;

import javax.swing.JInternalFrame;

import com.wsy.model.FireType;
import com.wsy.model.Learn;

//////

public class UserAddIFrame extends JInternalFrame {

	private String[] columnNames1 = { "编号", "条件1", "条件2", "频率", "可信度" };
	private String[] columnNames2 = { "编号", "结论1", "结论2", "频率", "可信度" };

	private Object[][] getFileStates(List list) {
		Object[][] results = new Object[list.size()][columnNames1.length];
		for (int i = 0; i < list.size(); i++) {

			FireType firetype = (FireType) list.get(i);
			Learn learn = (Learn) list.get(i);

			results[i][0] = learn.getId();
			results[i][1] = learn.getCondition1();
			results[i][2] = learn.getCondition2();
			results[i][3] = learn.getF();
			results[i][4] = learn.getC();
		}
		return results;

	}

}
