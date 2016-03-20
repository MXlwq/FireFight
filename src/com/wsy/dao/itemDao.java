package com.wsy.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import com.wsy.iframe.DecisionIFrame;

public class itemDao {
	protected static String dbClassName = "com.mysql.jdbc.Driver";
	protected static String dbUrl = "jdbc:mysql://localhost:3306/firefight";
	// + "DatabaseName=db_library;SelectMethod=Cursor";
	protected static String dbUser = "root";
	protected static String dbPwd = "123456";
	protected static String second = null;
	private static Connection conn = null;

	private itemDao() {
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
				new itemDao();
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

	public static void Dispatch(String addressInput, String areaInput,
			String volumeInput, String controlRankInput, String spreadInput,
			String changeSituationInput, String deathPeopleInput,
			String hurtPeopleInput, String trapedPeopleInput,
			String situationInput, String phaseInput, String callTimeInput,
			String fireTypeInput,

			String addressConfidence, String areaConfidence,
			String volumeConfidence, String spreadConfidence,
			String controlRankConfidence, String callTimeConfidence,
			String changeSituationConfidence, String deathPeopleConfidence,
			String hurtPeopleConfidence, String trapedPeopleConfidence,
			String situationConfidence, String phaseConfidence,
			String fireTypeConfidence) throws SQLException {

		Integer areaFireLevelid = null;
		Integer volumeFireLevelid = null;
		Integer callTimeFireLevelid = null;
		Integer phaseFireLevelid = null;
		Integer fireFireLevelid = null;
		Integer spreadFireLevelid = null;
		Integer trapedFireLevelid = null;
		Integer hurtFireLevelid = null;
		Integer deathFireLevelid = null;
		Integer fireTypeId = null;

		// ���֮ǰ�ļ�¼
		if (conn == null)
			new itemDao();
		CallableStatement cstmt = conn.prepareCall("call clearConclusion()");
		cstmt.executeUpdate();
		cstmt.close();

		// ����С��λ��
		DecimalFormat df = new DecimalFormat("0.00");

		// areaInput
		// ���������---------
		float f = Float.parseFloat(areaConfidence.substring(
				areaConfidence.indexOf("(") + 1, areaConfidence.indexOf(",")));
		float c = Float.parseFloat(areaConfidence.substring(
				areaConfidence.indexOf(",") + 1, areaConfidence.indexOf(")")));

		if (conn == null)
			new itemDao();
		Statement stmt = (Statement) conn.createStatement();
		stmt.executeUpdate("insert into t_input(input) ("
				+ "select AreaId  from t_area where AreaName='" + areaInput
				+ "')");
		stmt.executeUpdate("update t_input" + " set f=" + f + ",c=" + c
				+ " where input in ("
				+ "select AreaId  from t_area where AreaName='" + areaInput
				+ "')");
		// ������������-------

		String sql = "select FireLevelid,FireLevelName from t_firelevel where Areaid IN ("
				+ "select AreaId  from t_area where AreaName='"
				+ areaInput
				+ "')";
		ResultSet rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				areaFireLevelid = rs.getInt("FireLevelid");
				String areaFireLevelName = rs.getString("FireLevelName");
				System.out.println("area:" + areaFireLevelName);
				DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + "\r\n"
						+ "$�¼���[���" + areaInput + " ] => $�¼���("
						+ areaFireLevelName + ")��" + df.format(1.0 * f) + ","
						+ df.format(0.9 * c) + "��";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ����м���۱�---------
		stmt.executeUpdate("insert into mConclusion(conclusion) values("
				+ areaFireLevelid + ")");

		f = (float) (f * 1.0);
		c = (float) (c * 0.9 * 1.0 * f);
		stmt.executeUpdate("update mConclusion" + " set f=" + f + ",c=" + c
				+ " where conclusion = " + areaFireLevelid);
		// �����м���۽���---------

		// volumeInput

		// ���������---------
		String newInput = volumeInput;
		String newConfidence = volumeConfidence;

		f = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf("(") + 1, newConfidence.indexOf(",")));
		c = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf(",") + 1, newConfidence.indexOf(")")));
		if (conn == null)
			new itemDao();
		// stmt = (Statement) conn.createStatement();
		stmt.executeUpdate("insert into t_input(input) ("
				+ "select VolumeId  from t_volume where VolumeName='"
				+ newInput + "')");
		stmt.executeUpdate("update t_input" + " set f=" + f + ",c=" + c
				+ " where input in ("
				+ "select VolumeId  from t_volume where VolumeName='"
				+ newInput + "')");
		// ������������-------

		sql = "select FireLevelid,FireLevelName from t_firelevel where VolumeId IN ("
				+ "select VolumeId  from t_volume where VolumeName='"
				+ volumeInput + "')";
		rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				volumeFireLevelid = rs.getInt("FireLevelid");
				String volumeFireLevelName = rs.getString("FireLevelName");
				System.out.println("volume:" + volumeFireLevelName);
				DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + "\r\n"
						+ "$�¼���[�ݻ�" + volumeInput + " ] => $�¼���("
						+ volumeFireLevelName + ")��" + df.format(1.0 * f) + ","
						+ df.format(0.9 * c) + "��";

				// ����м���۱�---------
				Integer newId = volumeFireLevelid;
				sql = "select * from mConclusion where conclusion = " + newId;
				ResultSet rs1 = itemDao.executeQuery(sql);
				if (rs1.next()) {
					f = (float) (f * 1.0);
					c = (float) (c * 0.9 * 1.0 * f);
					float f1;
					float c1;

					f1 = rs1.getFloat("f");
					c1 = rs1.getFloat("c");

					System.out.println("f=" + f + " c=" + c);

					System.out.println("f1:" + f1 + " c1=" + c1);
					f = (f * c * (1 - c1) + f1 * c1 * (1 - c))
							/ (c * (1 - c1) + c1 * (1 - c));
					c = (c * (1 - c1) + c1 * (1 - c))
							/ (c * (1 - c1) + c1 * (1 - c) + (1 - c) * (1 - c1));
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

				// �����м���۽���---------

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// callTimeInput
		// ���������---------
		newInput = callTimeInput;
		newConfidence = callTimeConfidence;

		f = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf("(") + 1, newConfidence.indexOf(",")));
		c = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf(",") + 1, newConfidence.indexOf(")")));
		if (conn == null)
			new itemDao();

		System.out.println("f=" + f + " c=" + c);
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
		// ������������-------
		sql = "select FireLevelid,FireLevelName from t_firelevel where CallingTimeId IN ("
				+ "select CallingTimeId  from t_callingtime where CallingTimeName='"
				+ callTimeInput + "')";
		rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				callTimeFireLevelid = rs.getInt("FireLevelid");
				String callTimeFireLevelName = rs.getString("FireLevelName");
				System.out.println("calltime:" + callTimeFireLevelName);
				DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + '\n'
						+ "$�¼���[���д���" + callTimeInput + " ] => $�¼���("
						+ callTimeFireLevelName + ")��" + df.format(1.0 * f)
						+ "," + df.format(0.9 * c) + "��";

				// ����м���۱�---------
				Integer newId = callTimeFireLevelid;
				sql = "select * from mConclusion where conclusion = " + newId;
				ResultSet rs1 = itemDao.executeQuery(sql);
				if (rs1.next()) {
					float f1 = (float) (f * 1.0);

					float c1 = (float) (c * 0.9 * 1.0 * f);

					float f2 = rs1.getFloat("f");
					float c2 = rs1.getFloat("c");

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

					float f3 = (float) (f * 1.0);
					float c3 = (float) (c * 0.9 * 1.0 * f);
					stmt.executeUpdate("update mConclusion" + " set f=" + f3
							+ ",c=" + c3 + " where conclusion = " + newId);
				}

				// �����м���۽���---------

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// phaseInput

		// ���������---------
		newInput = phaseInput;
		newConfidence = phaseConfidence;

		f = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf("(") + 1, newConfidence.indexOf(",")));
		c = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf(",") + 1, newConfidence.indexOf(")")));
		if (conn == null)
			new itemDao();
		// stmt = (Statement) conn.createStatement();
		stmt.executeUpdate("insert into t_input(input) ("
				+ "select StageId  from t_stage where StageName='" + newInput
				+ "')");
		stmt.executeUpdate("update t_input" + " set f=" + f + ",c=" + c
				+ " where input in ("
				+ "select StageId  from t_stage where StageName='" + newInput
				+ "')");
		// ������������-------
		sql = "select FireLevelid,FireLevelName from t_firelevel where StageId IN ("
				+ "select StageId  from t_stage where StageName='"
				+ phaseInput
				+ "')";
		rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				phaseFireLevelid = rs.getInt("FireLevelid");
				String phaseFireLevelName = rs.getString("FireLevelName");
				System.out.println("stage:" + phaseFireLevelName);
				DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + '\n'
						+ "$�¼���[�׶�" + phaseInput + " ] => $�¼���("
						+ phaseFireLevelName + ")��" + df.format(1.0 * f) + ","
						+ df.format(0.9 * c) + "��";

				// ����м���۱�---------
				Integer newId = phaseFireLevelid;
				sql = "select * from mConclusion where conclusion = " + newId;
				ResultSet rs1 = itemDao.executeQuery(sql);
				if (rs1.next()) {
					float f1 = (float) (f * 1.0);
					;
					float c1 = (float) (c * 0.9 * 1.0 * f);
					;

					float f2 = rs1.getFloat("f");
					float c2 = rs1.getFloat("c");

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

					float f3 = (float) (f * 1.0);
					float c3 = (float) (c * 0.9 * 1.0 * f);
					stmt.executeUpdate("update mConclusion" + " set f=" + f3
							+ ",c=" + c3 + " where conclusion = " + newId);
				}

				// �����м���۽���---------

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// situationInput
		// ���������---------
		newInput = situationInput;
		newConfidence = situationConfidence;

		f = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf("(") + 1, newConfidence.indexOf(",")));
		c = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf(",") + 1, newConfidence.indexOf(")")));
		if (conn == null)
			new itemDao();
		// stmt = (Statement) conn.createStatement();
		stmt.executeUpdate("insert into t_input(input) ("
				+ "select fireId  from t_fire where fireName='" + newInput
				+ "')");
		stmt.executeUpdate("update t_input" + " set f=" + f + ",c=" + c
				+ " where input in ("
				+ "select fireId  from t_fire where fireName='" + newInput
				+ "')");
		// ������������-------
		sql = "select FireLevelid,FireLevelName from t_firelevel where FireId IN ("
				+ "select fireId  from t_fire where fireName='"
				+ situationInput + "')";
		rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				fireFireLevelid = rs.getInt("FireLevelid");
				String fireFireLevelName = rs.getString("FireLevelName");
				System.out.println("fire:" + fireFireLevelName);
				DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + '\n'
						+ "$�¼���[����" + situationInput + " ] => $�¼���("
						+ fireFireLevelName + ")��" + df.format(1.0 * f) + ","
						+ df.format(0.9 * c) + "��";

				// ����м���۱�---------
				Integer newId = fireFireLevelid;
				sql = "select * from mConclusion where conclusion = " + newId;
				ResultSet rs1 = itemDao.executeQuery(sql);
				if (rs1.next()) {
					float f1 = (float) (f * 1.0);
					;
					float c1 = (float) (c * 0.9 * 1.0 * f);
					;

					float f2 = rs1.getFloat("f");
					float c2 = rs1.getFloat("c");

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

					float f3 = (float) (f * 1.0);
					float c3 = (float) (c * 0.9 * 1.0 * f);
					stmt.executeUpdate("update mConclusion" + " set f=" + f3
							+ ",c=" + c3 + " where conclusion = " + newId);
				}

				// �����м���۽���---------

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// spreadInput
		// ���������---------
		newInput = spreadInput;
		newConfidence = spreadConfidence;

		f = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf("(") + 1, newConfidence.indexOf(",")));
		c = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf(",") + 1, newConfidence.indexOf(")")));
		if (conn == null)
			new itemDao();
		// stmt = (Statement) conn.createStatement();
		stmt.executeUpdate("insert into t_input(input) ("
				+ "select SpreadingId  from t_spreading where SpreadingName='"
				+ newInput + "')");
		stmt.executeUpdate("update t_input" + " set f=" + f + ",c=" + c
				+ " where input in ("
				+ "select SpreadingId  from t_spreading where SpreadingName='"
				+ newInput + "')");
		// ������������-------
		sql = "select FireLevelid,FireLevelName from t_firelevel where SpreadingId IN ("
				+ "select SpreadingId  from t_spreading where SpreadingName='"
				+ spreadInput + "')";
		rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				spreadFireLevelid = rs.getInt("FireLevelid");
				String spreadFireLevelName = rs.getString("FireLevelName");
				System.out.println("spread:" + spreadFireLevelName);
				DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + '\n'
						+ "$�¼���[�������" + spreadInput + " ] => $�¼���("
						+ spreadFireLevelName + ")��" + df.format(1.0 * f) + ","
						+ df.format(0.9 * c) + "��";

				// ����м���۱�---------
				Integer newId = spreadFireLevelid;
				sql = "select * from mConclusion where conclusion = " + newId;
				ResultSet rs1 = itemDao.executeQuery(sql);
				if (rs1.next()) {
					float f1 = (float) (f * 1.0);
					;
					float c1 = (float) (c * 0.9 * 1.0 * f);
					;

					float f2 = rs1.getFloat("f");
					float c2 = rs1.getFloat("c");

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

					float f3 = (float) (f * 1.0);
					float c3 = (float) (c * 0.9 * 1.0 * f);
					stmt.executeUpdate("update mConclusion" + " set f=" + f3
							+ ",c=" + c3 + " where conclusion = " + newId);
				}

				// �����м���۽���---------

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// trapedPeopleInput
		// ���������---------
		newInput = trapedPeopleInput;
		newConfidence = trapedPeopleConfidence;

		f = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf("(") + 1, newConfidence.indexOf(",")));
		c = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf(",") + 1, newConfidence.indexOf(")")));
		if (conn == null)
			new itemDao();
		// stmt = (Statement) conn.createStatement();
		stmt.executeUpdate("insert into t_input(input) ("
				+ "select TrappedpeopleId  from t_trappedpeople where TrappedpeopleName='"
				+ newInput + "')");
		stmt.executeUpdate("update t_input"
				+ " set f="
				+ f
				+ ",c="
				+ c
				+ " where input in ("
				+ "select TrappedpeopleId  from t_trappedpeople where TrappedpeopleName='"
				+ newInput + "')");
		// ������������-------
		sql = "select FireLevelid,FireLevelName from t_firelevel where TrappedpeopleId IN ("
				+ "select TrappedpeopleId  from t_trappedpeople where TrappedpeopleName='"
				+ trapedPeopleInput + "')";
		rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				trapedFireLevelid = rs.getInt("FireLevelid");
				String trapedFireLevelName = rs.getString("FireLevelName");
				System.out.println("traped:" + trapedFireLevelName);
				DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + '\n'
						+ "$�¼���[��������" + trapedPeopleInput + " ] => $�¼���("
						+ trapedFireLevelName + ")��" + df.format(1.0 * f) + ","
						+ df.format(0.9 * c) + "��";

				// ����м���۱�---------
				Integer newId = trapedFireLevelid;
				sql = "select * from mConclusion where conclusion = " + newId;
				ResultSet rs1 = itemDao.executeQuery(sql);
				if (rs1.next()) {
					float f1 = (float) (f * 1.0);
					;
					float c1 = (float) (c * 0.9 * 1.0 * f);
					;

					float f2 = rs1.getFloat("f");
					float c2 = rs1.getFloat("c");

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

					float f3 = (float) (f * 1.0);
					float c3 = (float) (c * 0.9 * 1.0 * f);
					stmt.executeUpdate("update mConclusion" + " set f=" + f3
							+ ",c=" + c3 + " where conclusion = " + newId);
				}

				// �����м���۽���---------

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// hurtPeopleInput
		// ���������---------
		newInput = hurtPeopleInput;
		newConfidence = hurtPeopleConfidence;

		f = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf("(") + 1, newConfidence.indexOf(",")));
		c = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf(",") + 1, newConfidence.indexOf(")")));
		if (conn == null)
			new itemDao();
		// stmt = (Statement) conn.createStatement();
		stmt.executeUpdate("insert into t_input(input) ("
				+ "select InjuredPleopleId  from t_injuredpleople where InjuredPleopleName='"
				+ newInput + "')");
		stmt.executeUpdate("update t_input"
				+ " set f="
				+ f
				+ ",c="
				+ c
				+ " where input in ("
				+ "select InjuredPleopleId  from t_injuredpleople where InjuredPleopleName='"
				+ newInput + "')");
		// ������������-------
		sql = "select FireLevelid,FireLevelName from t_firelevel where InjuredPeolpeId IN ("
				+ "select InjuredPleopleId  from t_injuredpleople where InjuredPleopleName='"
				+ hurtPeopleInput + "')";
		rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				hurtFireLevelid = rs.getInt("FireLevelid");
				String hurtFireLevelName = rs.getString("FireLevelName");
				System.out.println("hurt:" + hurtFireLevelName);
				DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + '\n'
						+ "$�¼���[��������" + hurtPeopleInput + " ] => $�¼���("
						+ hurtFireLevelName + ")��" + df.format(1.0 * f) + ","
						+ df.format(0.9 * c) + "��";

				// ����м���۱�---------
				Integer newId = hurtFireLevelid;
				sql = "select * from mConclusion where conclusion = " + newId;
				ResultSet rs1 = itemDao.executeQuery(sql);
				if (rs1.next()) {
					float f1 = (float) (f * 1.0);
					;
					float c1 = (float) (c * 0.9 * 1.0 * f);
					;

					float f2 = rs1.getFloat("f");
					float c2 = rs1.getFloat("c");

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

					float f3 = (float) (f * 1.0);
					float c3 = (float) (c * 0.9 * 1.0 * f);
					stmt.executeUpdate("update mConclusion" + " set f=" + f3
							+ ",c=" + c3 + " where conclusion = " + newId);
				}

				// �����м���۽���---------

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// deathPeopleInput
		// ���������---------
		newInput = deathPeopleInput;
		newConfidence = deathPeopleConfidence;

		f = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf("(") + 1, newConfidence.indexOf(",")));
		c = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf(",") + 1, newConfidence.indexOf(")")));
		if (conn == null)
			new itemDao();
		// stmt = (Statement) conn.createStatement();
		stmt.executeUpdate("insert into t_input(input) ("
				+ "select DeathTollId  from t_deathtoll where DeathTollName='"
				+ newInput + "')");
		stmt.executeUpdate("update t_input" + " set f=" + f + ",c=" + c
				+ " where input in ("
				+ "select DeathTollId  from t_deathtoll where DeathTollName='"
				+ newInput + "')");
		// ������������-------
		sql = "select FireLevelid,FireLevelName from t_firelevel where DeathTollid IN ("
				+ "select DeathTollId  from t_deathtoll where DeathTollName='"
				+ deathPeopleInput + "')";
		rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				deathFireLevelid = rs.getInt("FireLevelid");
				String deathFireLevelName = rs.getString("FireLevelName");
				System.out.println("death:" + deathFireLevelName);
				DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + '\n'
						+ "$�¼���[��������" + deathPeopleInput + " ] => $�¼���("
						+ deathFireLevelName + ")��" + df.format(1.0 * f) + ","
						+ df.format(0.9 * c) + "��";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// fireTypeId
		newInput = fireTypeInput;
		newConfidence = fireTypeConfidence;

		f = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf("(") + 1, newConfidence.indexOf(",")));
		c = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf(",") + 1, newConfidence.indexOf(")")));

		sql = "select FireTypeId  from t_firetype where FireTypeName='"
				+ fireTypeInput + "'";
		System.out.println("���sql=" + sql);
		rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				fireTypeId = rs.getInt("FireTypeId");
				System.out.println("type:" + fireTypeInput);
				DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + '\n'
						+ "$�¼���[�������" + fireTypeInput + " ] => $�¼���("
						+ fireTypeId + ")��" + df.format(1.0 * f) + ","
						+ df.format(0.9 * c) + "��";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ��ȡ���ID
		float f1 = f;
		float c1 = c;
		Integer typeId = fireTypeId;
		System.out.println("TypeId=" + typeId);

		// ��ȡ����ID

		Integer LevelId = null;
		cstmt = conn.prepareCall("call findMax()");
		cstmt.executeUpdate();
		cstmt.close();

		sql = "select * from t_conclusion ";

		rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				float f2 = rs.getFloat("f");
				float c2 = rs.getFloat("c");
				LevelId = rs.getInt("conclusion");
				System.out.println("���ռ���LevelId=" + LevelId);
				// ���ռ����ѻ�ȡ������ѻ�ȡ
				// ��ȡ����
				f = f1 * f2;
				c = c1 * c2;

				// ��ǲ
				sql = "select * from t_dispatch " + "where TypeId = " + typeId
						+ " AND LevelId = " + LevelId + ";";
				// System.out.println("sql="+sql);

				rs = itemDao.executeQuery(sql);
				try {
					while (rs.next()) {
						Integer conclu = rs.getInt("DispatchId");
						String FireFighterNum = rs.getString("FireFighterNum");
						String Equipment = rs.getString("Equipment");
						DecisionIFrame.ResultStr = DecisionIFrame.ResultStr
								+ '\n' + "$�¼���[�������" + typeId + " ]+[���ּ��� "
								+ LevelId + " ] => $�¼���(��������:" + FireFighterNum
								+ ")+(�豸��Ŀ:" + Equipment + ")��"
								+ df.format(1.0 * f) + "," + df.format(0.9 * c)
								+ "��";

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

		itemDao.close();

	}

	/*
	 * ������:Nady ���ܣ������˲���String addressInput�������ڽ�������ʾ��������
	 */

	// ����ȫ�޸ģ���f��ָ���޸ģ��������Ϊ0�Ľ��
	public static void typeDispatch(String addressInput, String fireTypeInput,
			String fireTypeConfidence) {

		Integer areaFireLevelid = null;
		// ����С��λ��
		DecimalFormat df = new DecimalFormat("0.00");

		float f = Float.parseFloat(fireTypeConfidence.substring(
				fireTypeConfidence.indexOf("(") + 1,
				fireTypeConfidence.indexOf(",")));
		float c = Float.parseFloat(fireTypeConfidence.substring(
				fireTypeConfidence.indexOf(",") + 1,
				fireTypeConfidence.indexOf(")")));
		// Write wr = new Write();

		String sql = "select FireTypeid,FireTypeName from t_firetype where FireTypeName ='"
				+ fireTypeInput + "'";
		System.out.println(sql);
		ResultSet rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				// fireTypeInput = rs.getInt("FireLevelid");
				String FireTypeName = rs.getString("FireTypeName");
				System.out.println("firetype:" + FireTypeName);
				// ������ʾ
				// NewJFrame.ResultStr =
				// NewJFrame.ResultStr+"\r\n"+"{"+addressInput+"}"+"*"+"["+areaInput+"]"+"��ȼ�����"+
				// "=> $�¼���("+areaFireLevelName+")��"+df.format(1.0*f)+","+df.format(0.9*c)+"��";
				DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + "\r\n"
						+ "{" + addressInput + "}" + "*" + "[" + fireTypeInput
						+ "]" + "���������" + "=> {" + addressInput + "}��" + "("
						+ fireTypeInput + ")(" + df.format(1.0 * f) + ","
						+ df.format(0.9 * c) + ")";
				System.out.println("ResultStr=" + DecisionIFrame.ResultStr);

			}

			// wr.data = Float.toString(f);
			// wr.write();
			// wr.data = Float.toString(c);
			// wr.write();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * ������:Nady ���ܣ������˲���String addressInput�������ڽ�������ʾ��������
	 */
	public static void areaDispatch(String addressInput, String areaInput,
			String areaConfidence) {

		Integer areaFireLevelid = null;
		// ����С��λ��
		DecimalFormat df = new DecimalFormat("0.00");

		float f = Float.parseFloat(areaConfidence.substring(
				areaConfidence.indexOf("(") + 1, areaConfidence.indexOf(",")));
		float c = Float.parseFloat(areaConfidence.substring(
				areaConfidence.indexOf(",") + 1, areaConfidence.indexOf(")")));
		// Write wr = new Write();
		String sql = "select FireLevelid,FireLevelName from t_firelevel where Areaid IN ("
				+ "select AreaId  from t_area where AreaName='"
				+ areaInput
				+ "')";
		ResultSet rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				areaFireLevelid = rs.getInt("FireLevelid");
				String areaFireLevelName = rs.getString("FireLevelName");
				System.out.println("area:" + areaFireLevelName);

				// DecisionIFrame.ResultStr =
				// DecisionIFrame.ResultStr+"\r\n"+"$�¼���[���"+areaInput+" ] => $�¼���("+areaFireLevelName+")��"+df.format(1.0*f)+","+df.format(0.9*c)+"��";
				/**
				 * ������:Nady ���ܣ��޸��˽�����ʾ
				 */
				DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + "\r\n"
						+ "{" + addressInput + "}" + "*[" + areaInput
						+ "]�����itemDao=>" + "{" + addressInput + "}" + "->"
						+ areaFireLevelName;
				System.out.println("ResultStr=" + DecisionIFrame.ResultStr);

			}
			// wr.data = Float.toString(f);
			// wr.write();
			// wr.data = Float.toString(c);
			// wr.write();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * ������:Nady ���ܣ������˲���String addressInput�������ڽ�������ʾ��������
	 */
	public static void volumeDispatch(String addressInput, String volumeInput,
			String volumeConfidence) {
		// ����С��λ��
		DecimalFormat df = new DecimalFormat("0.00");

		Integer volumeFireLevelid = null;
		String newInput = volumeInput;
		String newConfidence = volumeConfidence;
		float f = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf("(") + 1, newConfidence.indexOf(",")));
		float c = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf(",") + 1, newConfidence.indexOf(")")));
		// Write wr = new Write();
		String sql = "select FireLevelid,FireLevelName from t_firelevel where VolumeId IN ("
				+ "select VolumeId  from t_volume where VolumeName='"
				+ volumeInput + "')";
		ResultSet rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				volumeFireLevelid = rs.getInt("FireLevelid");
				String volumeFireLevelName = rs.getString("FireLevelName");
				System.out.println("volume:" + volumeFireLevelName);
				// DecisionIFrame.ResultStr =
				// DecisionIFrame.ResultStr+"\r\n"+"$�¼���[�ݻ�"+volumeInput+" ] => $�¼���("+volumeFireLevelName+")��"+df.format(1.0*f)+","+df.format(0.9*c)+"��";
				DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + "\r\n"
						+ "{" + addressInput + "}" + "*[" + volumeInput
						+ "]���ݻ�itemDao=>" + "{" + addressInput + "}" + "->"
						+ volumeFireLevelName;

			}
			// wr.data = Float.toString(f);
			// wr.write();
			// wr.data = Float.toString(c);
			// wr.write();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * ������:Nady ���ܣ������˲���String addressInput�������ڽ�������ʾ��������
	 */
	public static void callTimeDispatch(String addressInput,
			String callTimeInput, String callTimeConfidence) {
		Integer callTimeFireLevelid = null;
		// ����С��λ��
		DecimalFormat df = new DecimalFormat("0.00");

		float f = Float.parseFloat(callTimeConfidence.substring(
				callTimeConfidence.indexOf("(") + 1,
				callTimeConfidence.indexOf(",")));
		float c = Float.parseFloat(callTimeConfidence.substring(
				callTimeConfidence.indexOf(",") + 1,
				callTimeConfidence.indexOf(")")));
		// Write wr = new Write();
		String sql = "select FireLevelid,FireLevelName from t_firelevel where CallingTimeId IN ("
				+ "select CallingTimeId  from t_callingtime where CallingTimeName='"
				+ callTimeInput + "')";
		ResultSet rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				callTimeFireLevelid = rs.getInt("FireLevelid");
				String callTimeFireLevelName = rs.getString("FireLevelName");
				System.out.println("calltime:" + callTimeFireLevelName);
				// DecisionIFrame.ResultStr =
				// DecisionIFrame.ResultStr+'\n'+"$�¼���[���д���"+callTimeInput+" ] => $�¼���("+callTimeFireLevelName+")��"+df.format(1.0*f)+","+df.format(0.9*c)+"��";
				DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + "\r\n"
						+ "{" + addressInput + "}" + "*[" + callTimeInput
						+ "]�����д���itemDao=>" + "{" + addressInput + "}" + "->"
						+ callTimeFireLevelName;

			}
			// wr.data = Float.toString(f);
			// wr.write();
			// wr.data = Float.toString(c);
			// wr.write();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * ������:Nady ���ܣ������˲���String addressInput�������ڽ�������ʾ��������
	 */
	public static void phaseDispatch(String addressInput, String phaseInput,
			String phaseConfidence) {
		// TODO Auto-generated method stub
		Integer phaseFireLevelid = null;
		// ����С��λ��
		DecimalFormat df = new DecimalFormat("0.00");

		String newConfidence = phaseConfidence;
		float f = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf("(") + 1, newConfidence.indexOf(",")));
		float c = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf(",") + 1, newConfidence.indexOf(")")));
		// Write wr = new Write();
		String sql = "select FireLevelid,FireLevelName from t_firelevel where StageId IN ("
				+ "select StageId  from t_stage where StageName='"
				+ phaseInput
				+ "')";
		ResultSet rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				phaseFireLevelid = rs.getInt("FireLevelid");
				String phaseFireLevelName = rs.getString("FireLevelName");
				System.out.println("stage:" + phaseFireLevelName);
				// DecisionIFrame.ResultStr =
				// DecisionIFrame.ResultStr+'\n'+"$�¼���[�׶�"+phaseInput+" ] => $�¼���("+phaseFireLevelName+")��"+df.format(1.0*f)+","+df.format(0.9*c)+"��";
				DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + "\r\n"
						+ "{" + addressInput + "}" + "*[" + phaseInput
						+ "]�������׶�itemDao=>" + "{" + addressInput + "}" + "->"
						+ phaseFireLevelName;

			}
			// wr.data = Float.toString(f);
			// wr.write();
			// wr.data = Float.toString(c);
			// wr.write();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * ������:Nady ���ܣ������˲���String addressInput�������ڽ�������ʾ��������
	 */
	public static void situationDispatch(String addressInput,
			String situationInput, String situationConfidence) {
		// TODO Auto-generated method stub
		Integer fireFireLevelid = null;
		// ����С��λ��
		DecimalFormat df = new DecimalFormat("0.00");

		String newConfidence = situationConfidence;
		float f = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf("(") + 1, newConfidence.indexOf(",")));
		float c = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf(",") + 1, newConfidence.indexOf(")")));
		// Write wr = new Write();
		String sql = "select FireLevelid,FireLevelName from t_firelevel where FireId IN ("
				+ "select fireId  from t_fire where fireName='"
				+ situationInput + "')";
		ResultSet rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				fireFireLevelid = rs.getInt("FireLevelid");
				String fireFireLevelName = rs.getString("FireLevelName");
				System.out.println("fire:" + fireFireLevelName);
				// DecisionIFrame.ResultStr =
				// DecisionIFrame.ResultStr+'\n'+"$�¼���[����"+situationInput+" ] => $�¼���("+fireFireLevelName+")��"+df.format(1.0*f)+","+df.format(0.9*c)+"��";
				DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + "\r\n"
						+ "{" + addressInput + "}" + "*[" + situationInput
						+ "]������itemDao=>" + "{" + addressInput + "}" + "->"
						+ fireFireLevelName;

			}
			// wr.data = Float.toString(f);
			// wr.write();
			// wr.data = Float.toString(c);
			// wr.write();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * ������:Nady ���ܣ������˲���String addressInput�������ڽ�������ʾ��������
	 */
	public static void spreadDispatch(String addressInput, String spreadInput,
			String spreadConfidence) {
		// TODO Auto-generated method stub
		Integer spreadFireLevelid = null;
		// ����С��λ��
		DecimalFormat df = new DecimalFormat("0.00");

		String newConfidence = spreadConfidence;
		float f = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf("(") + 1, newConfidence.indexOf(",")));
		float c = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf(",") + 1, newConfidence.indexOf(")")));
		// Write wr = new Write();
		String sql = "select FireLevelid,FireLevelName from t_firelevel where SpreadingId IN ("
				+ "select SpreadingId  from t_spreading where SpreadingName='"
				+ spreadInput + "')";
		ResultSet rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				spreadFireLevelid = rs.getInt("FireLevelid");
				String spreadFireLevelName = rs.getString("FireLevelName");
				System.out.println("spread:" + spreadFireLevelName);
				// DecisionIFrame.ResultStr =
				// DecisionIFrame.ResultStr+'\n'+"$�¼���[�������"+spreadInput+" ] => $�¼���("+spreadFireLevelName+")��"+df.format(1.0*f)+","+df.format(0.9*c)+"��";
				DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + "\r\n"
						+ "{" + addressInput + "}" + "*" + "[" + spreadInput
						+ "]" + "���������itemDao" + "=> {" + addressInput + "}��"
						+ "(" + spreadFireLevelName + ")(" + df.format(1.0 * f)
						+ "," + df.format(0.9 * c) + ")";

			}
			// wr.data = Float.toString(f);
			// wr.write();
			// wr.data = Float.toString(c);
			// wr.write();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * ������:Nady ���ܣ������˲���String addressInput�������ڽ�������ʾ��������
	 */
	public static void trapedPeopleDispatch(String addressInput,
			String trapedPeopleInput, String trapedPeopleConfidence) {
		// TODO Auto-generated method stub
		Integer trapedFireLevelid = null;
		// ����С��λ��
		DecimalFormat df = new DecimalFormat("0.00");

		String newConfidence = trapedPeopleConfidence;
		float f = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf("(") + 1, newConfidence.indexOf(",")));
		float c = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf(",") + 1, newConfidence.indexOf(")")));
		// Write wr = new Write();
		String sql = "select FireLevelid,FireLevelName from t_firelevel where TrappedpeopleId IN ("
				+ "select TrappedpeopleId  from t_trappedpeople where TrappedpeopleName='"
				+ trapedPeopleInput + "')";
		ResultSet rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				trapedFireLevelid = rs.getInt("FireLevelid");
				String trapedFireLevelName = rs.getString("FireLevelName");
				System.out.println("traped:" + trapedFireLevelName);
				// DecisionIFrame.ResultStr =
				// DecisionIFrame.ResultStr+'\n'+"$�¼���[��������"+trapedPeopleInput+" ] => $�¼���("+trapedFireLevelName+")��"+df.format(1.0*f)+","+df.format(0.9*c)+"��";
				DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + "\r\n"
						+ "{" + addressInput + "}" + "*" + "["
						+ trapedPeopleInput + "]" + "����������" + "=> {"
						+ addressInput + "}��" + "(" + trapedFireLevelName
						+ ")(" + df.format(1.0 * f) + "," + df.format(0.9 * c)
						+ ")";

			}
			// wr.data = Float.toString(f);
			// wr.write();
			// wr.data = Float.toString(c);
			// wr.write();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * ������:Nady ���ܣ������˲���String addressInput�������ڽ�������ʾ��������
	 */
	public static void hurtPeopleDispatch(String addressInput,
			String hurtPeopleInput, String hurtPeopleConfidence) {
		// TODO Auto-generated method stub
		Integer hurtFireLevelid = null;
		// ����С��λ��
		DecimalFormat df = new DecimalFormat("0.00");

		String newConfidence = hurtPeopleConfidence;
		float f = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf("(") + 1, newConfidence.indexOf(",")));
		float c = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf(",") + 1, newConfidence.indexOf(")")));
		// Write wr = new Write();
		String sql = "select FireLevelid,FireLevelName from t_firelevel where InjuredPeolpeId IN ("
				+ "select InjuredPleopleId  from t_injuredpleople where InjuredPleopleName='"
				+ hurtPeopleInput + "')";
		ResultSet rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				hurtFireLevelid = rs.getInt("FireLevelid");
				String hurtFireLevelName = rs.getString("FireLevelName");
				System.out.println("hurt:" + hurtFireLevelName);
				// DecisionIFrame.ResultStr =
				// DecisionIFrame.ResultStr+'\n'+"$�¼���[��������"+hurtPeopleInput+" ] => $�¼���("+hurtFireLevelName+")��"+df.format(1.0*f)+","+df.format(0.9*c)+"��";
				DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + "\r\n"
						+ "{" + addressInput + "}" + "*" + "["
						+ hurtPeopleInput + "]" + "����������" + "=> {"
						+ addressInput + "}��" + "(" + hurtFireLevelName + ")��"
						+ df.format(1.0 * f) + "," + df.format(0.9 * c) + "��";

			}
			// wr.data = Float.toString(f);
			// wr.write();
			// wr.data = Float.toString(c);
			// wr.write();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * ������:Nady ���ܣ������˲���String addressInput�������ڽ�������ʾ��������
	 */
	public static void deathPeopleDispatch(String addressInput,
			String deathPeopleInput, String deathPeopleConfidence) {
		// TODO Auto-generated method stub
		Integer deathFireLevelid = null;
		// ����С��λ��
		DecimalFormat df = new DecimalFormat("0.00");

		String newConfidence = deathPeopleConfidence;
		float f = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf("(") + 1, newConfidence.indexOf(",")));
		float c = Float.parseFloat(newConfidence.substring(
				newConfidence.indexOf(",") + 1, newConfidence.indexOf(")")));
		// Write wr = new Write();
		String sql = "select FireLevelid,FireLevelName from t_firelevel where DeathTollid IN ("
				+ "select DeathTollId  from t_deathtoll where DeathTollName='"
				+ deathPeopleInput + "')";
		ResultSet rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				deathFireLevelid = rs.getInt("FireLevelid");
				String deathFireLevelName = rs.getString("FireLevelName");
				System.out.println("death:" + deathFireLevelName);
				// DecisionIFrame.ResultStr =
				// DecisionIFrame.ResultStr+'\n'+"$�¼���[��������"+deathPeopleInput+" ] => $�¼���("+deathFireLevelName+")��"+df.format(1.0*f)+","+df.format(0.9*c)+"��";
				DecisionIFrame.ResultStr = DecisionIFrame.ResultStr + "\r\n"
						+ "{" + addressInput + "}" + "*" + "["
						+ deathPeopleInput + "]" + "����������" + "=> {"
						+ addressInput + "}��" + "(" + deathFireLevelName + ")("
						+ df.format(1.0 * f) + "," + df.format(0.9 * c) + ")";

			}
			// wr.data = Float.toString(f);
			// wr.write();
			// wr.data = Float.toString(c);
			// wr.write();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
