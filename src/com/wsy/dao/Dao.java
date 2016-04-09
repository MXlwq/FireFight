package com.wsy.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.wsy.iframe.DecisionIFrame;
import com.wsy.model.Dispatch;
import com.wsy.model.FireLevel;
import com.wsy.model.FireType;
import com.wsy.model.Learn;
//0711
import com.wsy.model.Operater;
import com.wsy.model.SimiMsg;

/*import com.mysql.jdbc.PreparedStatement;
 import com.mysql.jdbc.Statement;
 import com.mysql.jdbc.StatementImpl;*/

public class Dao {
	protected static String dbClassName = "com.mysql.jdbc.Driver";
	protected static String dbUrl = "jdbc:mysql://localhost:3306/firefight";
	// + "DatabaseName=db_library;SelectMethod=Cursor";
	protected static String dbUser = "root";
	protected static String dbPwd = "123456";
	protected static String second = null;
	private static Connection conn = null;

	private Dao() {
		try {
			if (conn == null) {
				Class.forName(dbClassName).newInstance();
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
			} else
				return;
		} catch (Exception ee) {
			ee.printStackTrace();
		}

	}

	private static ResultSet executeQuery(String sql) {
		try {
			if (conn == null)
				new Dao();
			return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE).executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}

	public static void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}

	/* 管理员登录方法 */
	public static Operater check(String name, String password) {
		int i = 0;
		Operater operater = new Operater();
		String sql = "select *  from t_operator where name='" + name
				+ "' and password='" + password + "'and admin=1";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				String names = rs.getString(1);
				operater.setId(rs.getString("id"));
				operater.setName(rs.getString("name"));
				operater.setGrade(rs.getString("admin"));
				operater.setPassword(rs.getString("password"));
				if (names != null) {
					i = 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return operater;

	}

	/* 火灾类别表的显示 */
	public static List selectFireType() {
		List list = new ArrayList();
		String sql = "select *  from t_firetype";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				FireType firetype = new FireType();

				firetype.setFiretypeid(rs.getInt(1));

				firetype.setFiretypeName(rs.getString(2));

				firetype.setComburentId(rs.getString(3));

				firetype.setFrequency(rs.getString(4));

				firetype.setConfidence(rs.getString(5));

				list.add(firetype);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}

	/* 火灾级别表的显示 */

	public static List selectFireLevel() {
		List list = new ArrayList();
		String sql = "select *  from t_firelevel";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				FireLevel fl = new FireLevel();
				fl.setFireLevelId(rs.getInt(1));
				fl.setFireLevelName(rs.getString(2));
				fl.setFrequency(rs.getString(3));
				fl.setConfidence(rs.getString(4));
				fl.setAreaId(rs.getInt(5));
				fl.setVolumeId(rs.getInt(6));
				fl.setCallingTimeId(rs.getInt(7));
				fl.setStageId(rs.getInt(8));
				fl.setFireId(rs.getInt(9));
				fl.setSpreadingId(rs.getInt(10));
				fl.setTrappedpeopleId(rs.getInt(11));
				fl.setInjuredPeolpeId(rs.getInt(12));
				fl.setDeathTollid(rs.getInt(13));
				fl.setDangerid(rs.getInt(14));
				list.add(fl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}

	/* 火灾类别表的显示 */
	public static List selectDispath() {
		List list = new ArrayList();
		String sql = "select *  from t_dispatch";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				Dispatch dp = new Dispatch();

				dp.setDispatchId(rs.getInt(1));
				dp.setTypeId(rs.getString(2));
				dp.setLevelId(rs.getString(3));
				dp.setFireFighterNum(rs.getString(4));
				dp.setEquipment(rs.getString(5));
				dp.setFrequency(rs.getString(6));
				dp.setConfidence(rs.getString(7));

				list.add(dp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}

	/* 学习知识显示 */
	public static List selectLearnMsg() {
		List list = new ArrayList();
		String sql = "select *  from t_learn";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				Learn learn = new Learn();

				learn.setId(rs.getInt(1));

				learn.setCondition1(rs.getInt(2));

				learn.setDescription1(rs.getString(3));

				learn.setCondition2(rs.getInt(4));

				learn.setDescription2(rs.getString(5));

				learn.setF(rs.getInt(6));

				learn.setC(rs.getInt(7));

				list.add(learn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}

	/* 相似知识显示 */
	public static List selectSimiMsg() {
		List list = new ArrayList();
		String sql = "select *  from t_similarity";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				SimiMsg simiMsg = new SimiMsg();

				simiMsg.setId(rs.getInt(1));

				simiMsg.setConclusion1(rs.getInt(2));

				simiMsg.setDescription1(rs.getString(3));

				simiMsg.setConclusion2(rs.getInt(4));

				simiMsg.setDescription2(rs.getString(5));

				simiMsg.setF(rs.getInt(6));

				simiMsg.setC(rs.getInt(7));

				list.add(simiMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}

	/* 派遣方案生成 */

	/*
	 * public static void Dispatch(String addressInput, String fireTypeInput,
	 * String areaInput, String volumeInput, String callTimeInput, String
	 * phaseInput, String situationInput, String spreadInput, String
	 * trapedPeopleInput, String hurtPeopleInput, String deathPeopleInput,
	 * String changeSituationInput,
	 * 
	 * 
	 * 
	 * 
	 * 
	 * String addressConfidence, String fireTypeConfidence, String
	 * areaConfidence, String volumeConfidence,
	 * 
	 * 
	 * String callTimeConfidence, String phaseConfidence, String
	 * situationConfidence, String spreadConfidence, String
	 * trapedPeopleConfidence, String hurtPeopleConfidence, String
	 * deathPeopleConfidence,
	 * 
	 * String changeSituationConfidence
	 * 
	 * ) throws SQLException {
	 */
	public static void Dispatch(
			String addressInput,
			String areaInput,
			String volumeInput,
			// String controlRankInput, //从界面删除20150717
			String spreadInput,
			// String changeSituationInput,
			String deathPeopleInput, String hurtPeopleInput,
			String trapedPeopleInput, String situationInput, String phaseInput,
			String callTimeInput, String fireTypeInput,
			String addressConfidence,
			String areaConfidence,
			String volumeConfidence,
			String spreadConfidence,
			// String controlRankConfidence, //从界面删除20150717
			String callTimeConfidence,
			// String changeSituationConfidence,
			String deathPeopleConfidence, String hurtPeopleConfidence,
			String trapedPeopleConfidence, String situationConfidence,
			String phaseConfidence, String fireTypeConfidence)
			throws SQLException {
		Integer fireTypeId = null;
		Integer areaFireLevelid = null;
		Integer volumeFireLevelid = null;
		Integer callTimeFireLevelid = null;
		Integer phaseFireLevelid = null;
		Integer fireFireLevelid = null;
		Integer spreadFireLevelid = null;
		Integer trapedFireLevelid = null;
		Integer hurtFireLevelid = null;
		Integer deathFireLevelid = null;
		// Integer fireTypeId = null;

		// 清空之前的记录
		if (conn == null)
			new Dao();
		// 触发器-----清空
		CallableStatement cstmt = conn.prepareCall("call clearConclusion()");
		cstmt.executeUpdate();
		cstmt.close();

		Statement stmt0 = (Statement) conn.createStatement();
		String sql0 = "insert into tempLearn select * from t_learn";
		stmt0.execute(sql0);
		sql0 = "insert into tempSimilarity select * from t_similarity";
		stmt0.execute(sql0);

		// 设置小数位数
		DecimalFormat df = new DecimalFormat("0.00");
		

		if ((areaConfidence != null) && (areaInput != null)) {
			// areaInput
			// 插入输入表---------
			float f = Float.parseFloat(areaConfidence.substring(
					areaConfidence.indexOf("(") + 1,
					areaConfidence.indexOf(",")));
			float c = Float.parseFloat(areaConfidence.substring(
					areaConfidence.indexOf(",") + 1,
					areaConfidence.indexOf(")")));

			if (conn == null)
				new Dao();
			Statement stmt = (Statement) conn.createStatement();
			stmt.executeUpdate("insert into t_input(input) ("
					+ "select AreaId  from t_area where AreaName='" + areaInput
					+ "')");
			stmt.executeUpdate("update t_input" + " set f=" + f + ",c=" + c
					+ ",description = '" + areaInput + "' where input in ("
					+ "select AreaId  from t_area where AreaName='" + areaInput
					+ "')");
			// 插入输入表结束-------

			String sql = "select FireLevelid,FireLevelName from t_firelevel where Areaid IN ("
					+ "select AreaId  from t_area where AreaName='"
					+ areaInput
					+ "')";
			ResultSet rs = Dao.executeQuery(sql);
			try {
				while (rs.next()) {
					areaFireLevelid = rs.getInt("FireLevelid");
					String areaFireLevelName = rs.getString("FireLevelName");
					System.out.println("area:" + areaFireLevelName);
					/*
					 * 操作者：那迪 功能：修改了语句的输出形式 时间：2015.07.17
					 */
					DecisionIFrame.ResultStr = DecisionIFrame.ResultStr
							+ "\r\n" + "{" + addressInput + "}" + "*" + "["
							+ areaInput + "]" + "→燃烧面积" + "=> {"
							+ addressInput + "}→" + "(" + areaFireLevelName
							+ ")（" + df.format(1.0 * f) + ","
							+ df.format(0.9 * c) + "）";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			/* 执行插入学习表和相似知识表 */
			sql = "select AreaId  from t_area where AreaName='" + areaInput
					+ "'";
			rs = Dao.executeQuery(sql);
			int Id = 0;
			while (rs.next()) {
				Id = rs.getInt("AreaId");
			}
			learnAndSimi(areaFireLevelid, Id, areaInput);
			/* 插入学习表和相似知识表结束 */
			// 插进中间结论表---------
			Integer newId = areaFireLevelid;

			sql = "select * from mConclusion where conclusion = " + newId;
			ResultSet rs1 = Dao.executeQuery(sql);
			if (rs1.next()) {
				f = (float) (f * 1.0);
				c = (float) (c * 0.9 * 1.0 * f);
				float f1;
				float c1;

				f1 = rs1.getFloat("f");
				c1 = rs1.getFloat("c");

				System.out.println("f=" + f + " c=" + c);
				// revision 规则
				System.out.println("f1:" + f1 + " c1=" + c1);
				f = (f * c * (1 - c1) + f1 * c1 * (1 - c))
						/ (c * (1 - c1) + c1 * (1 - c));
				c = (c * (1 - c1) + c1 * (1 - c))
						/ (c * (1 - c1) + c1 * (1 - c) + (1 - c) * (1 - c1));
				stmt.executeUpdate("update mConclusion" + " set f=" + f + ",c="
						+ c + " where conclusion = " + newId);

			} else {
				stmt.executeUpdate("insert into mConclusion(conclusion) values("
						+ newId + ")");

				f = (float) (f * 1.0);
				c = (float) (c * 0.9 * 1.0 * f);
				stmt.executeUpdate("update mConclusion" + " set f=" + f + ",c="
						+ c + " where conclusion = " + newId);
			}

			// 插入中间结论结束---------
			Write wr = new Write();
			wr.data = Float.toString(areaFireLevelid);
			wr.write();
			wr.data = Float.toString(f);
			wr.write();
			wr.data = Float.toString(c);
			wr.write();
		}

		// volumeInput
		// bug修改
		if ((volumeConfidence != "") && (volumeInput != "")) {
			// 插入输入表---------
			String newInput = volumeInput;
			String newConfidence = volumeConfidence;

			float f = Float
					.parseFloat(newConfidence.substring(
							newConfidence.indexOf("(") + 1,
							newConfidence.indexOf(",")));
			float c = Float
					.parseFloat(newConfidence.substring(
							newConfidence.indexOf(",") + 1,
							newConfidence.indexOf(")")));
			if (conn == null)
				new Dao();
			Statement stmt = (Statement) conn.createStatement();
			stmt.executeUpdate("insert into t_input(input) ("
					+ "select VolumeId  from t_volume where VolumeName='"
					+ newInput + "')");
			stmt.executeUpdate("update t_input" + " set f=" + f + ",c=" + c
					+ ",description = '" + newInput + "' where input in ("
					+ "select VolumeId  from t_volume where VolumeName='"
					+ newInput + "')");
			// 插入输入表结束-------

			String sql = "select FireLevelid,FireLevelName from t_firelevel where VolumeId IN ("
					+ "select VolumeId  from t_volume where VolumeName='"
					+ volumeInput + "')";
			ResultSet rs = Dao.executeQuery(sql);
			try {
				while (rs.next()) {
					volumeFireLevelid = rs.getInt("FireLevelid");
					String volumeFireLevelName = rs.getString("FireLevelName");
					System.out.println("volume:" + volumeFireLevelName);
					DecisionIFrame.ResultStr = DecisionIFrame.ResultStr
							+ "\r\n" + "{" + addressInput + "}" + "*" + "["
							+ volumeInput + "]" + "→燃烧容积" + "=> {"
							+ addressInput + "}→" + "(" + volumeFireLevelName
							+ ")（" + df.format(1.0 * f) + ","
							+ df.format(0.9 * c) + "）";

					/* ----- 执行插入学习表和相似知识表 */
					sql = "select VolumeId  from t_volume where VolumeName='"
							+ volumeInput + "'";
					rs = Dao.executeQuery(sql);
					int Id = 0;
					while (rs.next()) {
						Id = rs.getInt("VolumeId");
					}
					learnAndSimi(volumeFireLevelid, Id, newInput);
					// 插进中间结论表---------
					Integer newId = volumeFireLevelid;

					sql = "select * from mConclusion where conclusion = "
							+ newId;
					ResultSet rs1 = Dao.executeQuery(sql);
					if (rs1.next()) {

						float f1 = rs1.getFloat("f");
						float c1 = rs1.getFloat("c");

						System.out.println("f=" + f + " c=" + c);
						// revision 规则
						System.out.println("f1:" + f1 + " c1=" + c1);
						f = (f * c * (1 - c1) + f1 * c1 * (1 - c))
								/ (c * (1 - c1) + c1 * (1 - c));
						c = (c * (1 - c1) + c1 * (1 - c))
								/ (c * (1 - c1) + c1 * (1 - c) + (1 - c)
										* (1 - c1));
						stmt.executeUpdate("update mConclusion" + " set f=" + f
								+ ",c=" + c + " where conclusion = " + newId);

					} else {
						stmt.executeUpdate("insert into mConclusion(conclusion) values("
								+ newId + ")");

						f = (float) (f * 1.0);
						c = (float) (c * 0.9 * 1.0 * f);
						stmt.executeUpdate("update mConclusion" + " set f=" + f
								+ ",c=" + c + " where conclusion = " + newId);
					}

					// 插入中间结论结束---------
					Write wr = new Write();
					wr.data = Float.toString(volumeFireLevelid);
					wr.write();
					wr.data = Float.toString(f);
					wr.write();
					wr.data = Float.toString(c);
					wr.write();

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// callTimeInput
		if ((callTimeConfidence != "") && (callTimeInput != "")) {
			// 插入输入表---------
			String newInput = callTimeInput;
			String newConfidence = callTimeConfidence;

			float f = Float
					.parseFloat(newConfidence.substring(
							newConfidence.indexOf("(") + 1,
							newConfidence.indexOf(",")));
			float c = Float
					.parseFloat(newConfidence.substring(
							newConfidence.indexOf(",") + 1,
							newConfidence.indexOf(")")));
			if (conn == null)
				new Dao();

			System.out.println("f=" + f + " c=" + c);
			Statement stmt = (Statement) conn.createStatement();
			stmt.executeUpdate("insert into t_input(input) ("
					+ "select CallingTimeId  from t_callingtime where CallingTimeName='"
					+ newInput + "')");
			System.out.println("insert end");
			stmt.executeUpdate("update t_input"
					+ " set f="
					+ f
					+ ",c="
					+ c
					+ " where input in ("
					+ "select CallingTimeId  from t_callingtime where CallingTimeName='"
					+ newInput + "')");
			System.out.println("update end");
			// 插入输入表结束-------
			String sql = "select FireLevelid,FireLevelName from t_firelevel where CallingTimeId IN ("
					+ "select CallingTimeId  from t_callingtime where CallingTimeName='"
					+ callTimeInput + "')";
			ResultSet rs = Dao.executeQuery(sql);
			try {
				float f3 = 0, c3 = 0;
				while (rs.next()) {
					callTimeFireLevelid = rs.getInt("FireLevelid");
					String callTimeFireLevelName = rs
							.getString("FireLevelName");
					System.out.println("calltime:" + callTimeFireLevelName);
					DecisionIFrame.ResultStr = DecisionIFrame.ResultStr
							+ "\r\n" + "{" + addressInput + "}" + "*" + "["
							+ callTimeInput + "]" + "→呼叫次数" + "=> {"
							+ addressInput + "}→" + "(" + callTimeFireLevelName
							+ ")（" + df.format(1.0 * f) + ","
							+ df.format(0.9 * c) + "）";

					/* ----- 执行插入学习表和相似知识表 */
					sql = "select CallingTimeId  from t_callingtime where CallingTimeName='"
							+ callTimeInput + "'";
					rs = Dao.executeQuery(sql);
					int Id = 0;
					while (rs.next()) {
						Id = rs.getInt("CallingTimeId");
					}
					learnAndSimi(callTimeFireLevelid, Id, newInput);
					// 插进中间结论表---------
					Integer newId = callTimeFireLevelid;
					sql = "select * from mConclusion where conclusion = "
							+ newId;
					ResultSet rs1 = Dao.executeQuery(sql);
					if (rs1.next()) {
						float f1 = (float) (f * 1.0);
						;
						float c1 = (float) (c * 0.9 * 1.0 * f);
						;

						float f2 = rs1.getFloat("f");
						float c2 = rs1.getFloat("c");

						f3 = (f1 * c1 * (1 - c2) + f2 * c2 * (1 - c1))
								/ (c1 * (1 - c2) + c2 * (1 - c1));
						c3 = (c1 * (1 - c2) + c2 * (1 - c1))
								/ (c1 * (1 - c2) + c2 * (1 - c1) + (1 - c1)
										* (1 - c2));
						stmt.executeUpdate("update mConclusion" + " set f="
								+ f3 + ",c=" + c3 + " where conclusion = "
								+ newId);

					} else {
						stmt.executeUpdate("insert into mConclusion(conclusion) values("
								+ newId + ")");

						f3 = (float) (f * 1.0);
						c3 = (float) (c * 0.9 * 1.0 * f);
						stmt.executeUpdate("update mConclusion" + " set f="
								+ f3 + ",c=" + c3 + " where conclusion = "
								+ newId);
					}

					// 插入中间结论结束---------
					Write wr = new Write();
					wr.data = Float.toString(callTimeFireLevelid);
					wr.write();
					wr.data = Float.toString(f3);
					wr.write();
					wr.data = Float.toString(c3);
					wr.write();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// phaseInput
		if ((phaseConfidence != "") && (phaseInput != "")) {
			// 插入输入表---------
			String newInput = phaseInput;
			String newConfidence = phaseConfidence;

			float f = Float
					.parseFloat(newConfidence.substring(
							newConfidence.indexOf("(") + 1,
							newConfidence.indexOf(",")));
			float c = Float
					.parseFloat(newConfidence.substring(
							newConfidence.indexOf(",") + 1,
							newConfidence.indexOf(")")));
			if (conn == null)
				new Dao();
			Statement stmt = (Statement) conn.createStatement();
			stmt.executeUpdate("insert into t_input(input) ("
					+ "select StageId  from t_stage where StageName='"
					+ newInput + "')");
			System.out.println("update t_input" + " set f=" + f + ",c=" + c
					+ ",description = " + newInput + " where input in ("
					+ "select StageId  from t_stage where StageName='"
					+ newInput + "')");
			stmt.executeUpdate("update t_input" + " set f=" + f + ",c=" + c
					+ ",description = '" + newInput + "'  where input in ("
					+ "select StageId  from t_stage where StageName='"
					+ newInput + "')");

			// 插入输入表结束-------

			/* ----- 执行插入学习表和相似知识表 套在整个循环外，由于一个输入可能推出多个结论 */
			String sql = "select StageId  from t_stage where StageName = '"
					+ phaseInput + "'";
			ResultSet rs5 = Dao.executeQuery(sql);
			int Id = 0;
			while (rs5.next()) {
				Id = rs5.getInt("StageId");

				System.out.println("StageId:" + Id);

				sql = "select FireLevelid,FireLevelName from t_firelevel where StageId = "
						+ Id;
				ResultSet rs = Dao.executeQuery(sql);
				try {
					float f3 = 0, c3 = 0;
					while (rs.next()) {
						phaseFireLevelid = rs.getInt("FireLevelid");
						String phaseFireLevelName = rs
								.getString("FireLevelName");
						System.out.println("StageId:" + Id + "stage:"
								+ phaseFireLevelName);
						// DecisionIFrame.ResultStr =
						// DecisionIFrame.ResultStr+'\n'+"$事件→[阶段"+phaseInput+" ] => $事件→("+phaseFireLevelName+")（"+df.format(1.0*f)+","+df.format(0.9*c)+"）";
						DecisionIFrame.ResultStr = DecisionIFrame.ResultStr
								+ "\r\n" + "{" + addressInput + "}" + "*" + "["
								+ phaseInput + "]" + "→所处阶段Dao" + "=> {"
								+ addressInput + "}→" + "("
								+ phaseFireLevelName + ")（"
								+ df.format(1.0 * f) + "," + df.format(0.9 * c)
								+ "）";

						// 插进中间结论表---------
						Integer newId = phaseFireLevelid;
						sql = "select * from mConclusion where conclusion = "
								+ newId;
						ResultSet rs1 = Dao.executeQuery(sql);
						if (rs1.next()) {
							float f1 = (float) (f * 1.0);
							;
							float c1 = (float) (c * 0.9 * 1.0 * f);
							;

							float f2 = rs1.getFloat("f");
							float c2 = rs1.getFloat("c");

							f3 = (f1 * c1 * (1 - c2) + f2 * c2 * (1 - c1))
									/ (c1 * (1 - c2) + c2 * (1 - c1));
							c3 = (c1 * (1 - c2) + c2 * (1 - c1))
									/ (c1 * (1 - c2) + c2 * (1 - c1) + (1 - c1)
											* (1 - c2));
							stmt.executeUpdate("update mConclusion" + " set f="
									+ f3 + ",c=" + c3 + " where conclusion = "
									+ newId);

						} else {
							stmt.executeUpdate("insert into mConclusion(conclusion) values("
									+ newId + ")");

							f3 = (float) (f * 1.0);
							c3 = (float) (c * 0.9 * 1.0 * f);
							stmt.executeUpdate("update mConclusion" + " set f="
									+ f3 + ",c=" + c3 + " where conclusion = "
									+ newId);
						}

						// 插入中间结论结束---------
						Write wr = new Write();
						wr.data = Float.toString(phaseFireLevelid);
						wr.write();
						wr.data = Float.toString(f3);
						wr.write();
						wr.data = Float.toString(c3);
						wr.write();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				learnAndSimi(phaseFireLevelid, Id, newInput);/* 此处才执行插入表的函数 */
			}

		}

		// situationInput
		if ((situationConfidence != "") && (situationInput != "")) {
			// 插入输入表---------
			String newInput = situationInput;
			String newConfidence = situationConfidence;

			float f = Float
					.parseFloat(newConfidence.substring(
							newConfidence.indexOf("(") + 1,
							newConfidence.indexOf(",")));
			float c = Float
					.parseFloat(newConfidence.substring(
							newConfidence.indexOf(",") + 1,
							newConfidence.indexOf(")")));
			if (conn == null)
				new Dao();
			Statement stmt = (Statement) conn.createStatement();
			stmt.executeUpdate("insert into t_input(input) ("
					+ "select fireId  from t_fire where fireName='" + newInput
					+ "')");
			stmt.executeUpdate("update t_input" + " set f=" + f + ",c=" + c
					+ ",description = '" + newInput + "' where input in ("
					+ "select fireId  from t_fire where fireName='" + newInput
					+ "')");
			// 插入输入表结束-------
			String sql = "select FireLevelid,FireLevelName from t_firelevel where FireId IN ("
					+ "select fireId  from t_fire where fireName='"
					+ situationInput + "')";
			ResultSet rs = Dao.executeQuery(sql);
			try {
				float f3, c3;
				while (rs.next()) {
					fireFireLevelid = rs.getInt("FireLevelid");
					String fireFireLevelName = rs.getString("FireLevelName");
					System.out.println("fire:" + fireFireLevelName);
					// DecisionIFrame.ResultStr =
					// DecisionIFrame.ResultStr+'\n'+"$事件→[火势"+situationInput+" ] => $事件→("+fireFireLevelName+")（"+df.format(1.0*f)+","+df.format(0.9*c)+"）";
					DecisionIFrame.ResultStr = DecisionIFrame.ResultStr
							+ "\r\n" + "{" + addressInput + "}" + "*" + "["
							+ situationInput + "]" + "→火势" + "=> {"
							+ addressInput + "}→" + "(" + fireFireLevelName
							+ ")（" + df.format(1.0 * f) + ","
							+ df.format(0.9 * c) + "）";

					sql = "select fireId  from t_fire where fireName='"
							+ situationInput + "'";
					rs = Dao.executeQuery(sql);
					int Id = 0;
					while (rs.next()) {
						Id = rs.getInt("fireId");
					}
					learnAndSimi(fireFireLevelid, Id, situationInput);
					// 插进中间结论表---------
					Integer newId = fireFireLevelid;
					sql = "select * from mConclusion where conclusion = "
							+ newId;
					ResultSet rs1 = Dao.executeQuery(sql);
					if (rs1.next()) {
						float f1 = (float) (f * 1.0);
						;
						float c1 = (float) (c * 0.9 * 1.0 * f);
						;

						float f2 = rs1.getFloat("f");
						float c2 = rs1.getFloat("c");

						f3 = (f1 * c1 * (1 - c2) + f2 * c2 * (1 - c1))
								/ (c1 * (1 - c2) + c2 * (1 - c1));
						c3 = (c1 * (1 - c2) + c2 * (1 - c1))
								/ (c1 * (1 - c2) + c2 * (1 - c1) + (1 - c1)
										* (1 - c2));
						stmt.executeUpdate("update mConclusion" + " set f="
								+ f3 + ",c=" + c3 + " where conclusion = "
								+ newId);

					} else {
						stmt.executeUpdate("insert into mConclusion(conclusion) values("
								+ newId + ")");

						f3 = (float) (f * 1.0);
						c3 = (float) (c * 0.9 * 1.0 * f);
						stmt.executeUpdate("update mConclusion" + " set f="
								+ f3 + ",c=" + c3 + " where conclusion = "
								+ newId);
					}

					// 插入中间结论结束---------
					Write wr = new Write();
					wr.data = Float.toString(fireFireLevelid);
					wr.write();
					wr.data = Float.toString(f3);
					wr.write();
					wr.data = Float.toString(c3);
					wr.write();

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// spreadInput
		if ((spreadConfidence != "") && (spreadInput != "")) {
			// 插入输入表---------
			String newInput = spreadInput;
			String newConfidence = spreadConfidence;

			float f = Float
					.parseFloat(newConfidence.substring(
							newConfidence.indexOf("(") + 1,
							newConfidence.indexOf(",")));
			float c = Float
					.parseFloat(newConfidence.substring(
							newConfidence.indexOf(",") + 1,
							newConfidence.indexOf(")")));
			if (conn == null)
				new Dao();
			Statement stmt = (Statement) conn.createStatement();
			stmt.executeUpdate("insert into t_input(input) ("
					+ "select SpreadingId  from t_spreading where SpreadingName='"
					+ newInput + "')");
			stmt.executeUpdate("update t_input"
					+ " set f="
					+ f
					+ ",c="
					+ c
					+ ",description = '"
					+ newInput
					+ "' where input in ("
					+ "select SpreadingId  from t_spreading where SpreadingName='"
					+ newInput + "')");
			// 插入输入表结束-------

			String sql = "select SpreadingId  from t_spreading where SpreadingName='"
					+ newInput + "'";
			ResultSet rs5 = Dao.executeQuery(sql);
			int Id = 0;
			while (rs5.next()) {
				Id = rs5.getInt("SpreadingId");

				sql = "select FireLevelid,FireLevelName from t_firelevel where SpreadingId = "
						+ Id;
				ResultSet rs = Dao.executeQuery(sql);
				try {
					float f3 = 0, c3 = 0;
					while (rs.next()) {
						spreadFireLevelid = rs.getInt("FireLevelid");
						String spreadFireLevelName = rs
								.getString("FireLevelName");
						System.out.println("SpreadId:" + Id + "spread:"
								+ spreadFireLevelName);
						// DecisionIFrame.ResultStr =
						// DecisionIFrame.ResultStr+'\n'+"$事件→[蔓延情况"+spreadInput+" ] => $事件→("+spreadFireLevelName+")（"+df.format(1.0*f)+","+df.format(0.9*c)+"）";
						DecisionIFrame.ResultStr = DecisionIFrame.ResultStr
								+ "\r\n" + "{" + addressInput + "}" + "*" + "["
								+ spreadInput + "]" + "→蔓延情况" + "=> {"
								+ addressInput + "}→" + "("
								+ spreadFireLevelName + ")（"
								+ df.format(1.0 * f) + "," + df.format(0.9 * c)
								+ "）";
						// 插进中间结论表---------
						Integer newId = spreadFireLevelid;
						sql = "select * from mConclusion where conclusion = "
								+ newId;
						ResultSet rs1 = Dao.executeQuery(sql);
						if (rs1.next()) {
							float f1 = (float) (f * 1.0);
							;
							float c1 = (float) (c * 0.9 * 1.0 * f);
							;

							float f2 = rs1.getFloat("f");
							float c2 = rs1.getFloat("c");

							f3 = (f1 * c1 * (1 - c2) + f2 * c2 * (1 - c1))
									/ (c1 * (1 - c2) + c2 * (1 - c1));
							c3 = (c1 * (1 - c2) + c2 * (1 - c1))
									/ (c1 * (1 - c2) + c2 * (1 - c1) + (1 - c1)
											* (1 - c2));
							stmt.executeUpdate("update mConclusion" + " set f="
									+ f3 + ",c=" + c3 + " where conclusion = "
									+ newId);

						} else {
							stmt.executeUpdate("insert into mConclusion(conclusion) values("
									+ newId + ")");

							f3 = (float) (f * 1.0);
							c3 = (float) (c * 0.9 * 1.0 * f);
							stmt.executeUpdate("update mConclusion" + " set f="
									+ f3 + ",c=" + c3 + " where conclusion = "
									+ newId);
						}

						// 插入中间结论结束---------
						Write wr = new Write();
						wr.data = Float.toString(spreadFireLevelid);
						wr.write();
						wr.data = Float.toString(f3);
						wr.write();
						wr.data = Float.toString(c3);
						wr.write();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				learnAndSimi(spreadFireLevelid, Id, newInput);
			}

		}

		// trapedPeopleInput
		if ((trapedPeopleConfidence != "") && (trapedPeopleInput != "")) {
			// 插入输入表---------
			String newInput = trapedPeopleInput;
			String newConfidence = trapedPeopleConfidence;

			float f = Float
					.parseFloat(newConfidence.substring(
							newConfidence.indexOf("(") + 1,
							newConfidence.indexOf(",")));
			float c = Float
					.parseFloat(newConfidence.substring(
							newConfidence.indexOf(",") + 1,
							newConfidence.indexOf(")")));
			if (conn == null)
				new Dao();
			Statement stmt = (Statement) conn.createStatement();
			stmt.executeUpdate("insert into t_input(input) ("
					+ "select TrappedpeopleId  from t_trappedpeople where TrappedpeopleName='"
					+ newInput + "')");
			stmt.executeUpdate("update t_input"
					+ " set f="
					+ f
					+ ",c="
					+ c
					+ ",description = '"
					+ newInput
					+ "' where input in ("
					+ "select TrappedpeopleId  from t_trappedpeople where TrappedpeopleName='"
					+ newInput + "')");
			// 插入输入表结束-------
			String sql = "select FireLevelid,FireLevelName from t_firelevel where TrappedpeopleId IN ("
					+ "select TrappedpeopleId  from t_trappedpeople where TrappedpeopleName='"
					+ trapedPeopleInput + "')";
			ResultSet rs = Dao.executeQuery(sql);
			try {
				float f3 = 0, c3 = 0;
				while (rs.next()) {
					trapedFireLevelid = rs.getInt("FireLevelid");
					String trapedFireLevelName = rs.getString("FireLevelName");
					System.out.println("traped:" + trapedFireLevelName);
					// DecisionIFrame.ResultStr =
					// DecisionIFrame.ResultStr+'\n'+"$事件→[被困人数"+trapedPeopleInput+" ] => $事件→("+trapedFireLevelName+")（"+df.format(1.0*f)+","+df.format(0.9*c)+"）";
					DecisionIFrame.ResultStr = DecisionIFrame.ResultStr
							+ "\r\n" + "{" + addressInput + "}" + "*" + "["
							+ trapedPeopleInput + "]" + "→被困人数" + "=> {"
							+ addressInput + "}→" + "(" + trapedFireLevelName
							+ ")（" + df.format(1.0 * f) + ","
							+ df.format(0.9 * c) + "）";

					sql = "select TrappedpeopleId  from t_trappedpeople where TrappedpeopleName='"
							+ trapedPeopleInput + "'";
					rs = Dao.executeQuery(sql);
					int Id = 0;
					while (rs.next()) {
						Id = rs.getInt("TrappedpeopleId");
					}
					learnAndSimi(trapedFireLevelid, Id, trapedPeopleInput);
					// 插进中间结论表---------
					Integer newId = trapedFireLevelid;
					sql = "select * from mConclusion where conclusion = "
							+ newId;
					ResultSet rs1 = Dao.executeQuery(sql);
					if (rs1.next()) {
						float f1 = (float) (f * 1.0);
						;
						float c1 = (float) (c * 0.9 * 1.0 * f);
						;

						float f2 = rs1.getFloat("f");
						float c2 = rs1.getFloat("c");

						f3 = (f1 * c1 * (1 - c2) + f2 * c2 * (1 - c1))
								/ (c1 * (1 - c2) + c2 * (1 - c1));
						c3 = (c1 * (1 - c2) + c2 * (1 - c1))
								/ (c1 * (1 - c2) + c2 * (1 - c1) + (1 - c1)
										* (1 - c2));
						stmt.executeUpdate("update mConclusion" + " set f="
								+ f3 + ",c=" + c3 + " where conclusion = "
								+ newId);

					} else {
						stmt.executeUpdate("insert into mConclusion(conclusion) values("
								+ newId + ")");

						f3 = (float) (f * 1.0);
						c3 = (float) (c * 0.9 * 1.0 * f);
						stmt.executeUpdate("update mConclusion" + " set f="
								+ f3 + ",c=" + c3 + " where conclusion = "
								+ newId);
					}

					// 插入中间结论结束---------
					Write wr = new Write();
					wr.data = Float.toString(trapedFireLevelid);
					wr.write();
					wr.data = Float.toString(f3);
					wr.write();
					wr.data = Float.toString(c3);
					wr.write();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// hurtPeopleInput
		if ((hurtPeopleConfidence != "") && (hurtPeopleInput != "")) {
			// 插入输入表---------
			String newInput = hurtPeopleInput;
			String newConfidence = hurtPeopleConfidence;

			float f = Float
					.parseFloat(newConfidence.substring(
							newConfidence.indexOf("(") + 1,
							newConfidence.indexOf(",")));
			float c = Float
					.parseFloat(newConfidence.substring(
							newConfidence.indexOf(",") + 1,
							newConfidence.indexOf(")")));

			if (conn == null)
				new Dao();
			Statement stmt = (Statement) conn.createStatement();
			stmt.executeUpdate("insert into t_input(input) ("
					+ "select InjuredPleopleId  from t_injuredpleople where InjuredPleopleName='"
					+ newInput + "')");
			stmt.executeUpdate("update t_input"
					+ " set f="
					+ f
					+ ",c="
					+ c
					+ ",description = '"
					+ newInput
					+ "' where input in ("
					+ "select InjuredPleopleId  from t_injuredpleople where InjuredPleopleName='"
					+ newInput + "')");
			// 插入输入表结束-------
			String sql = "select FireLevelid,FireLevelName from t_firelevel where InjuredPeolpeId IN ("
					+ "select InjuredPleopleId  from t_injuredpleople where InjuredPleopleName='"
					+ hurtPeopleInput + "')";
			ResultSet rs = Dao.executeQuery(sql);
			try {
				float f3 = 0, c3 = 0;
				while (rs.next()) {
					hurtFireLevelid = rs.getInt("FireLevelid");
					String hurtFireLevelName = rs.getString("FireLevelName");
					System.out.println("hurt:" + hurtFireLevelName);
					// DecisionIFrame.ResultStr =
					// DecisionIFrame.ResultStr+'\n'+"$事件→[受伤人数"+hurtPeopleInput+" ] => $事件→("+hurtFireLevelName+")（"+df.format(1.0*f)+","+df.format(0.9*c)+"）";
					DecisionIFrame.ResultStr = DecisionIFrame.ResultStr
							+ "\r\n" + "{" + addressInput + "}" + "*" + "["
							+ hurtPeopleInput + "]" + "→受伤人数" + "=> {"
							+ addressInput + "}→" + "(" + hurtFireLevelName
							+ ")（" + df.format(1.0 * f) + ","
							+ df.format(0.9 * c) + "）";

					sql = "select InjuredPleopleId  from t_injuredpleople where InjuredPleopleName='"
							+ hurtPeopleInput + "'";
					rs = Dao.executeQuery(sql);
					int Id = 0;
					while (rs.next()) {
						Id = rs.getInt("InjuredPleopleId");
					}
					learnAndSimi(hurtFireLevelid, Id, hurtPeopleInput);
					// 插进中间结论表---------
					Integer newId = hurtFireLevelid;
					sql = "select * from mConclusion where conclusion = "
							+ newId;
					ResultSet rs1 = Dao.executeQuery(sql);
					if (rs1.next()) {
						float f1 = (float) (f * 1.0);
						;
						float c1 = (float) (c * 0.9 * 1.0 * f);
						;

						float f2 = rs1.getFloat("f");
						float c2 = rs1.getFloat("c");

						f3 = (f1 * c1 * (1 - c2) + f2 * c2 * (1 - c1))
								/ (c1 * (1 - c2) + c2 * (1 - c1));
						c3 = (c1 * (1 - c2) + c2 * (1 - c1))
								/ (c1 * (1 - c2) + c2 * (1 - c1) + (1 - c1)
										* (1 - c2));
						stmt.executeUpdate("update mConclusion" + " set f="
								+ f3 + ",c=" + c3 + " where conclusion = "
								+ newId);

					} else {
						stmt.executeUpdate("insert into mConclusion(conclusion) values("
								+ newId + ")");

						f3 = (float) (f * 1.0);
						c3 = (float) (c * 0.9 * 1.0 * f);
						stmt.executeUpdate("update mConclusion" + " set f="
								+ f3 + ",c=" + c3 + " where conclusion = "
								+ newId);
					}

					// 插入中间结论结束---------
					Write wr = new Write();
					wr.data = Float.toString(hurtFireLevelid);
					wr.write();
					wr.data = Float.toString(f3);
					wr.write();
					wr.data = Float.toString(c3);
					wr.write();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// deathPeopleInput
		if ((deathPeopleConfidence != "") && (deathPeopleInput != "")) {
			// 插入输入表---------
			String newInput = deathPeopleInput;
			String newConfidence = deathPeopleConfidence;

			float f = Float
					.parseFloat(newConfidence.substring(
							newConfidence.indexOf("(") + 1,
							newConfidence.indexOf(",")));
			float c = Float
					.parseFloat(newConfidence.substring(
							newConfidence.indexOf(",") + 1,
							newConfidence.indexOf(")")));
			if (conn == null)
				new Dao();
			Statement stmt = (Statement) conn.createStatement();
			stmt.executeUpdate("insert into t_input(input) ("
					+ "select DeathTollId  from t_deathtoll where DeathTollName='"
					+ newInput + "')");
			stmt.executeUpdate("update t_input"
					+ " set f="
					+ f
					+ ",c="
					+ c
					+ ",description = '"
					+ newInput
					+ "' where input in ("
					+ "select DeathTollId  from t_deathtoll where DeathTollName='"
					+ newInput + "')");
			// 插入输入表结束-------
			String sql = "select FireLevelid,FireLevelName from t_firelevel where DeathTollid IN ("
					+ "select DeathTollId  from t_deathtoll where DeathTollName='"
					+ deathPeopleInput + "')";
			ResultSet rs = Dao.executeQuery(sql);
			try {
				while (rs.next()) {
					deathFireLevelid = rs.getInt("FireLevelid");
					String deathFireLevelName = rs.getString("FireLevelName");
					System.out.println("death:" + deathFireLevelName);
					// DecisionIFrame.ResultStr =
					// DecisionIFrame.ResultStr+'\n'+"$事件→[死亡人数"+deathPeopleInput+" ] => $事件→("+deathFireLevelName+")（"+df.format(1.0*f)+","+df.format(0.9*c)+"）";
					DecisionIFrame.ResultStr = DecisionIFrame.ResultStr
							+ "\r\n" + "{" + addressInput + "}" + "*" + "["
							+ deathPeopleInput + "]" + "→死亡人数" + "=> {"
							+ addressInput + "}→" + "(" + deathFireLevelName
							+ ")（" + df.format(1.0 * f) + ","
							+ df.format(0.9 * c) + "）";

					sql = "select DeathTollId  from t_deathtoll where DeathTollName='"
							+ deathPeopleInput + "'";
					rs = Dao.executeQuery(sql);
					int Id = 0;
					while (rs.next()) {
						Id = rs.getInt("DeathTollId");
					}
					learnAndSimi(deathFireLevelid, Id, deathPeopleInput);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// fireTypeId
		if ((fireTypeConfidence != "") && (fireTypeInput != "")) {
			String newInput = fireTypeInput;
			String newConfidence = fireTypeConfidence;

			float f = Float
					.parseFloat(newConfidence.substring(
							newConfidence.indexOf("(") + 1,
							newConfidence.indexOf(",")));
			float c = Float
					.parseFloat(newConfidence.substring(
							newConfidence.indexOf(",") + 1,
							newConfidence.indexOf(")")));

			String sql = "select FireTypeId  from t_firetype where FireTypeName='"
					+ fireTypeInput + "'";
			ResultSet rs = Dao.executeQuery(sql);
			try {
				while (rs.next()) {
					fireTypeId = rs.getInt("FireTypeId");
					System.out.println("type:" + fireTypeInput);
					// DecisionIFrame.ResultStr =
					// DecisionIFrame.ResultStr+'\n'+"$事件→[火灾类别Dao"+fireTypeInput+" ] => $事件→("+fireTypeId+")（"+df.format(1.0*f)+","+df.format(0.9*c)+"）";
					// DecisionIFrame.ResultStr =
					// DecisionIFrame.ResultStr+"\r\n"+"{"+addressInput+"}"+"*"+"["+fireTypeInput+"]"+"→火灾类别dao"+
					// "=> {"+addressInput+"}→"
					// +"("+fireTypeInput+")（"+df.format(1.0*f)+","+df.format(0.9*c)+"）";
					DecisionIFrame.ResultStr = DecisionIFrame.ResultStr
							+ "\r\n" + "{" + addressInput + "}" + "*" + "["
							+ fireTypeInput + "]" + "→火灾类别" + "=> {"
							+ addressInput + "}→" + "(" + fireTypeInput + ")（"
							+ df.format(1.0 * f) + "," + df.format(0.9 * c)
							+ "）";
					System.out.println("f=" + f + " c=" + c);
					/*
					 * //插进中间结论表--------- Integer newId = deathFireLevelid; sql
					 * = "select * from mConclusion where conclusion = "+newId;
					 * ResultSet rs1 = Dao.executeQuery(sql); if (rs1.next()) {
					 * f = (float) (f*1.0); c = (float) (c*0.9*1.0*f); float f1;
					 * float c1;
					 * 
					 * f1 = rs1.getFloat("f"); c1 = rs1.getFloat("c");
					 * 
					 * System.out.println("f="+f+" c="+c);
					 * 
					 * System.out.println("f1:"+f1+" c1="+c1); f =
					 * (f*c*(1-c1)+f1*c1*(1-c))/(c*(1-c1)+c1*(1-c)); c =
					 * (c*(1-c1)+c1*(1-c))/(c*(1-c1)+c1*(1-c)+(1-c)*(1-c1));
					 * stmt.executeUpdate("update mConclusion" +
					 * " set f="+f+",c="+c+" where conclusion = "+newId);
					 * 
					 * 
					 * }else{ stmt.executeUpdate(
					 * "insert into mConclusion(conclusion) values("+newId+")"
					 * );
					 * 
					 * f = (float) (f*1.0); c = (float) (c*0.9*1.0*f);
					 * stmt.executeUpdate("update mConclusion" +
					 * " set f="+f+",c="+c+" where conclusion = "+newId); }
					 * 
					 * 
					 * //插入中间结论结束---------
					 */
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// 获取类别ID
		float f = 0;
		float c = 0;
		if ((fireTypeConfidence != "") && (fireTypeInput != "")) {
			f = Float.parseFloat(fireTypeConfidence.substring(
					fireTypeConfidence.indexOf("(") + 1,
					fireTypeConfidence.indexOf(",")));
			c = Float.parseFloat(fireTypeConfidence.substring(
					fireTypeConfidence.indexOf(",") + 1,
					fireTypeConfidence.indexOf(")")));
			System.out.println("f=" + f + " c=" + c);
			f = (float) (f * 1.0);
			c = (float) (c * 0.9 * 1.0 * f);
		}
		System.out.println("f=" + f + " c=" + c);
		float f1 = f;
		float c1 = c;
		Integer typeId = fireTypeId;
		System.out.println("TypeId=" + typeId);

		// 根据t_similarity进行推理--------------------------------------------
		getConclusionFromMconclusion();

		// 获取级别ID

		float LevelId;
		// 调用存储过程
		cstmt = conn.prepareCall("call findMax()");
		cstmt.executeUpdate();
		cstmt.close();

		String sql = "select * from t_conclusion ";

		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				float f2 = rs.getFloat("f");
				float c2 = rs.getFloat("c");
				LevelId = rs.getInt("conclusion");
				Read re = new Read();
				re.S[0] = rs.getInt("conclusion");
				System.out.println("最终级别：LevelId=" + LevelId);
				// 最终级别已获取，类别已获取

				// 交集运算
				f = f1 * f2;
				c = c1 * c2;

				// 派遣
				sql = "select * from t_dispatch " + "where TypeId = " + typeId
						+ " AND LevelId = " + LevelId + ";";
				// System.out.println("sql="+sql);

				rs = Dao.executeQuery(sql);
				try {
					while (rs.next()) {
						Integer conclu = rs.getInt("DispatchId");
						String FireFighterNum = rs.getString("FireFighterNum");
						String Equipment = rs.getString("Equipment");

						String fireTypeDes = "";
						switch (typeId) {
						case 21:
							fireTypeDes = "一般性建筑火灾";
							break;
						case 22:
							fireTypeDes = "高层建筑火灾";
							break;
						case 23:
							fireTypeDes = "地下空间火灾";
							break;
						case 24:
							fireTypeDes = "油类火灾";
							break;
						case 25:
							fireTypeDes = "一般气体火灾";
							break;
						case 26:
							fireTypeDes = "毒气火灾";
							break;
						case 27:
							fireTypeDes = "露天堆场火灾";
							break;
						case 28:
							fireTypeDes = "交通工具火灾";
							break;
						case 29:
							fireTypeDes = "一般性火灾";
							break;
						default:
							fireTypeDes = "";
						}

						String fireLevelDes = "";
						Integer levelId = (int) LevelId;
						switch (levelId) {
						case 11:
							fireLevelDes = "一级";
							break;
						case 12:
							fireLevelDes = "二级";
							break;
						case 13:
							fireLevelDes = "三级";
							break;
						case 14:
							fireLevelDes = "四级";
							break;
						case 15:
							fireLevelDes = "五级";
							break;
						default:
							fireLevelDes = "";
						}

						DecisionIFrame.ResultStr = DecisionIFrame.ResultStr
								+ '\n' + "{" + addressInput + "}"
								+ "→[火灾类别 " + fireTypeDes + "]+[火灾级别 "
								+ fireLevelDes + "] =>" + "{" + addressInput
								+ "}" + "→(出动人数:" + FireFighterNum + ")+(设备数目:"
								+ Equipment + ")（" + df.format(1.0 * f) + ","
								+ df.format(0.9 * c) + "）";

						DecisionIFrame.Plan = DecisionIFrame.Plan + /*
																	 * "{"+
																	 * addressInput
																	 * +"}DAO"+
																	 * "→[火灾类别 "
																	 * +
																	 * fireTypeDes
																	 * +
																	 * "]+[火灾级别 "
																	 * +
																	 * fireLevelDes
																	 * +
																	 * "] =>"+"{"
																	 * +
																	 * addressInput
																	 * +"}"+
																	 * "→"+
																	 */""
								+ "出动人数:" + FireFighterNum + "\n设备数目:"
								+ Equipment + '\n' + "（频率="
								+ df.format(1.0 * f) + ",可信度="
								+ df.format(0.9 * c) + "）";

						Statement stmt = (Statement) conn.createStatement();
						stmt.executeUpdate("insert into t_conclusion values("
								+ conclu + "," + f + "," + c + ")");
						System.out.println("FireFighterNum=" + FireFighterNum
								+ "Equipment=" + Equipment);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		sql = "select * from t_learn where Condition1 in(select input from t_input) AND Condition2 in(select input from t_input)";
		rs = Dao.executeQuery(sql);
		while (rs.next()) {
			String des1 = rs.getString("Description1");
			String des2 = rs.getString("Description2");
			f = rs.getFloat("Frequency");
			c = rs.getFloat("Confidence");
			DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + '\n'
					+ "{$事件}→([" + des1 + "])=> {$事件}→([" + des2 + "](" + f
					+ "," + c + ")" /* "新习得知识："+des1+"+"+des2+"("+f+","+c+")" */;
		}
		sql = "select * from t_similarity where Level1 in (select conclusion from t_input) AND Level2 in(select conclusion from t_input)";
		rs = Dao.executeQuery(sql);
		while (rs.next()) {
			String des1 = rs.getString("Description1");
			String des2 = rs.getString("Description2");
			f = rs.getFloat("Frequency");
			c = rs.getFloat("Confidence");
			DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + '\n'
					+ "{$事件}→([" + des1 + "]) 火灾) <=>{$事件}→([" + des2
					+ "] 火灾)(" + f + "," + c + ")" /*
													 * "相似性知识："+des1+"+"+des2+"("
													 * +f+","+c+")"
													 */;
		}

		Dao.close();

	}

	private static void getConclusionFromMconclusion() throws SQLException {
		String sql = "select * from mconclusion";
		ResultSet rsSimi = Dao.executeQuery(sql);
		while (rsSimi.next()) {
			Integer mconclu = rsSimi.getInt("conclusion");
			Float f = rsSimi.getFloat("f");// 已有的中间结论的f值
			Float c = rsSimi.getFloat("c");

			sql = "select * from tempSimilarity where Level1=" + mconclu;
			ResultSet rsL1Same = Dao.executeQuery(sql);
			while (rsL1Same.next()) {
				Integer L2 = rsL1Same.getInt("Level2");
				Float tf = rsL1Same.getFloat("Frequency");// 推理根据的规则的f值
				Float tc = rsL1Same.getFloat("Confidence");

				if (tc > 0.5) {
					f = f * tf;// 根据已有中间结论和 中间结论推理规则 计算新的f值
					c = c * tc * f * tf;

					// 插进中间结论表---------
					Integer newId = L2;
					sql = "select * from mConclusion where conclusion = "
							+ newId;
					ResultSet rs1 = Dao.executeQuery(sql);
					if (rs1.next()) {
						float f1 = f;
						float c1 = c;

						float f2 = rs1.getFloat("f");
						float c2 = rs1.getFloat("c");

						float f3 = (f1 * c1 * (1 - c2) + f2 * c2 * (1 - c1))
								/ (c1 * (1 - c2) + c2 * (1 - c1));
						float c3 = (c1 * (1 - c2) + c2 * (1 - c1))
								/ (c1 * (1 - c2) + c2 * (1 - c1) + (1 - c1)
										* (1 - c2));
						Statement stmt = (Statement) conn.createStatement();
						stmt.executeUpdate("update mConclusion" + " set f="
								+ f3 + ",c=" + c3 + " where conclusion = "
								+ newId);

					} else {
						Statement stmt = (Statement) conn.createStatement();
						stmt.executeUpdate("insert into mConclusion(conclusion) values("
								+ newId + ")");

						float f3 = f;
						float c3 = c;
						stmt.executeUpdate("update mConclusion" + " set f="
								+ f3 + ",c=" + c3 + " where conclusion = "
								+ newId);
					}

				}

			}

			sql = "select * from tempSimilarity where Level2=" + mconclu;
			ResultSet rsL2Same = Dao.executeQuery(sql);
			while (rsL2Same.next()) {
				Integer L1 = rsL2Same.getInt("Level1");
				Float tf = rsL2Same.getFloat("Frequency");// 推理根据的规则的f值
				Float tc = rsL2Same.getFloat("Confidence");

				if (tc > 0.5) {
					f = f * tf;// 根据已有中间结论和 中间结论推理规则 计算新的f值
					c = c * tc * f * tf;

					// 插进中间结论表---------
					Integer newId = L1;
					sql = "select * from mConclusion where conclusion = "
							+ newId;
					ResultSet rs1 = Dao.executeQuery(sql);
					if (rs1.next()) {
						float f1 = f;
						float c1 = c;

						float f2 = rs1.getFloat("f");
						float c2 = rs1.getFloat("c");

						float f3 = (f1 * c1 * (1 - c2) + f2 * c2 * (1 - c1))
								/ (c1 * (1 - c2) + c2 * (1 - c1));
						float c3 = (c1 * (1 - c2) + c2 * (1 - c1))
								/ (c1 * (1 - c2) + c2 * (1 - c1) + (1 - c1)
										* (1 - c2));
						Statement stmt = (Statement) conn.createStatement();
						stmt.executeUpdate("update mConclusion" + " set f="
								+ f3 + ",c=" + c3 + " where conclusion = "
								+ newId);

					} else {
						Statement stmt = (Statement) conn.createStatement();
						stmt.executeUpdate("insert into mConclusion(conclusion) values("
								+ newId + ")");

						float f3 = f;
						float c3 = c;
						stmt.executeUpdate("update mConclusion" + " set f="
								+ f3 + ",c=" + c3 + " where conclusion = "
								+ newId);
					}

				}

			}
		}

	}

	private static void learnAndSimi(Integer cid, int id, String str)
			throws SQLException {
		// TODO Auto-generated method stub
		if (conn == null)
			new Dao();
		Statement stmt = (Statement) conn.createStatement();

		// 补全新插入t_input的信息
		stmt.executeUpdate("update t_input" + " set conclusion = " + cid
				+ " where input = " + id);
		System.out.println("###update t_input" + " set conclusion=" + cid
				+ " where input = " + id);
		float f1 = 0, f2 = 0, c1 = 0, c2 = 0;
		String sql2 = "select * from t_input where conclusion =" + cid
				+ " AND input = " + id;
		System.out.println("########sql2=" + sql2);
		ResultSet rs2 = Dao.executeQuery(sql2);
		while (rs2.next()) {
			f1 = rs2.getFloat("f");// 新的输入条件的f值
			c1 = rs2.getFloat("c");
		}
		System.out.println("f1:" + f1 + "c1:" + c1);

		// 在tempLearn中查看是否有可用推理信息
		String sql = "select * from tempLearn where Condition1 = " + id
				+ " or Condition2 = " + id;
		ResultSet rsLearn = Dao.executeQuery(sql);
		while (rsLearn.next()) {
			Integer otherCdt = rsLearn.getInt("Condition2");
			Integer conclusion = rsLearn.getInt("Conclusion");
			Float f = rsLearn.getFloat("Frequency");// t_learn规则的f值
			Float c = rsLearn.getFloat("Confidence");

			if (c > 0.5) {
				f = f1 * f;// f值更新为输入的f值和规则的f值的运算结果
				c = c1 * c * f1 * f;
				// 插入中间结论表
				Integer newId = conclusion;
				sql = "select * from mConclusion where conclusion = " + newId;
				ResultSet rs1 = Dao.executeQuery(sql);
				if (rs1.next()) {
					f1 = f;
					c1 = c;

					f2 = rs1.getFloat("f");
					c2 = rs1.getFloat("c");

					float f3 = (f1 * c1 * (1 - c2) + f2 * c2 * (1 - c1))
							/ (c1 * (1 - c2) + c2 * (1 - c1));
					float c3 = (c1 * (1 - c2) + c2 * (1 - c1))
							/ (c1 * (1 - c2) + c2 * (1 - c1) + (1 - c1)
									* (1 - c2));
					stmt.executeUpdate("update mConclusion" + " set f=" + f3
							+ ",c=" + c3 + " where conclusion = " + newId);

				} else {
					stmt.executeUpdate("insert into mConclusion(conclusion) values("
							+ newId + ")");

					float f3 = f;
					float c3 = c;
					stmt.executeUpdate("update mConclusion" + " set f=" + f3
							+ ",c=" + c3 + " where conclusion = " + newId);
				}
			}

		}

		// 根据t_input添加新的t_learn结论
		sql = "select * from t_input where conclusion = " + cid
				+ " AND description <> '" + str + "'";
		System.out.println("########sql=" + sql);
		ResultSet rs = Dao.executeQuery(sql);
		float f3 = 0, c3 = 0;
		try {
			while (rs.next()) {
				f2 = rs.getFloat("f");
				c2 = rs.getFloat("c");
				f3 = f2;
				c3 = (f1 * c1 * c2) / (f1 * c1 * c2 + 1);
				String sql4 = "select * from t_learn where (Condition1 = "
						+ rs.getInt("input") + " and Condition2 = " + id
						+ ") or (Condition1 = " + id + " and Condition2 = "
						+ rs.getInt("input") + ")";
				ResultSet rs6 = stmt.executeQuery(sql4);
				if (rs6.next()) {
					f1 = f3;
					c1 = c3;
					f2 = rs6.getFloat("Frequency");
					c2 = rs6.getFloat("Confidence");
					f3 = (f1 * c1 * (1 - c2) + f2 * c2 * (1 - c1))
							/ (c1 * (1 - c2) + c2 * (1 - c1));
					c3 = (c1 * (1 - c2) + c2 * (1 - c1))
							/ (c1 * (1 - c2) + c2 * (1 - c1) + (1 - c1)
									* (1 - c2));
					sql4 = "update t_learn set Frequency = " + f3
							+ ",Confidence = " + c3 + " where Condition1 = "
							+ rs6.getInt("Condition1") + " and  Condition2 = "
							+ rs6.getInt("Condition2");
					stmt.execute(sql4);
				} else {
					String sql3 = "insert into t_learn(Condition1,Description1,Condition2,Description2,Conclusion,Frequency,Confidence) "
							+ "values("
							+ rs.getInt("input")
							+ ",'"
							+ rs.getString("description")
							+ "',"
							+ id
							+ ",'"
							+ str + "'," + cid + "," + f3 + "," + c3 + ")";
					stmt.executeUpdate(sql3);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("f3:" + f3 + "c3:" + c3);
		sql = "select * from t_input where conclusion <> " + cid
				+ " AND description = '" + str + "'";
		System.out.println("########sql=" + sql);
		rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				f2 = rs.getFloat("f");
				c2 = rs.getFloat("c");
				f3 = (f1 * f2) / (f1 + f2 - f1 * f2);
				c3 = ((f1 + f2 - f1 * f2) * c1 * c2)
						/ ((f1 + f2 - f1 * f2) * c1 * c2 + 1);
				String des1 = "";
				String des2 = "";
				sql = "select FireLevelName from t_firelevel where FireLevelid = "
						+ rs.getInt("conclusion");
				ResultSet rs4 = Dao.executeQuery(sql);
				while (rs4.next()) {
					des1 = rs4.getString("FireLevelName");
				}
				sql = "select FireLevelName from t_firelevel where FireLevelid = "
						+ cid;
				rs4 = Dao.executeQuery(sql);
				while (rs4.next()) {
					des2 = rs4.getString("FireLevelName");
				}

				// 查看t_similarity是否已有这一条，有则合并
				String sql4 = "select * from t_similarity where (Level1 = "
						+ rs.getInt("conclusion") + " and Level2 = " + cid
						+ ") or (Level1 = " + cid + " and Level2 = "
						+ rs.getInt("conclusion") + ")";
				ResultSet rs6 = stmt.executeQuery(sql4);
				if (rs6.next()) {
					f1 = f3;
					c1 = c3;
					f2 = rs6.getFloat("Frequency");
					c2 = rs6.getFloat("Confidence");
					f3 = (f1 * c1 * (1 - c2) + f2 * c2 * (1 - c1))
							/ (c1 * (1 - c2) + c2 * (1 - c1));
					c3 = (c1 * (1 - c2) + c2 * (1 - c1))
							/ (c1 * (1 - c2) + c2 * (1 - c1) + (1 - c1)
									* (1 - c2));
					sql4 = "update t_similarity set Frequency = " + f3
							+ ",Confidence = " + c3 + " where Level1 = "
							+ rs6.getInt("Level1") + " and  Level2 = "
							+ rs6.getInt("Level2");
					stmt.execute(sql4);
				} else {
					String sql3 = "insert into t_similarity(Level1,Description1,Level2,Description2,Frequency,Confidence) values("
							+ rs.getInt("conclusion")
							+ ",'"
							+ des1
							+ "',"
							+ cid + ",'" + des2 + "'," + f3 + "," + c3 + ")";
					stmt.executeUpdate(sql3);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("f3:" + f3 + "c3:" + c3);

	}
}
