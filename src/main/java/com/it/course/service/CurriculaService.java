package com.it.course.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.it.course.domain.ItemBean;
import com.it.course.domain.PersonProgressBean;
import com.it.course.domain.SectionBean;
import com.it.course.domain.SectionHomeList;
import com.it.utils.JDBCUtils;

@Service
public class CurriculaService {

	/**
	 * 拼装查询学员的sql语句
	 * 
	 * @param personId
	 *            用户名唯一标识
	 * @param primary
	 *            课程所属大类ID
	 * @return sql语句
	 */
	private String getStudentSql(String personId, String primary) {
		String sqlBase = "SELECT * FROM yyol_curricula_person_progress WHERE person_identify = '" + personId
				+ "' AND curricula_primary_id='" + primary + "';";
		return sqlBase;
	}

	/**
	 * 拼装查询课程列表的sql语句
	 * 
	 * @param personId
	 *            用户名唯一标识
	 * @param primary
	 *            课程所属大类ID
	 * @return sql语句
	 */
	private String getSectionListSql(String personId, String primary) {
		String sqlBase = "SELECT l.curricula_section_id sectionId,l.curricula_section_name sectionName,l.curricula_section_img sectionImgPath,t.totalItem,q.finishedItem,q.examScore "
				+ "FROM yyol_curricula_section_list l "
				+ "LEFT JOIN (SELECT	COUNT(i.curricula_item_id) totalItem,i.curricula_section_id sectionId FROM yyol_curricula_item_list i GROUP BY i.curricula_section_id) t "
				+ "ON l.curricula_section_id = t.sectionId LEFT JOIN (SELECT p.curricula_item_finished finishedItem,p.curricula_exam_score examScore,p.curricula_section_id	"
				+ "FROM yyol_curricula_person_progress p WHERE	p.person_identify = '" + personId
				+ "') q ON q.curricula_section_id = l.curricula_section_id WHERE l.curricula_primary_id = '" + primary
				+ "';";
		return sqlBase;
	}

	/**
	 * 获取所有的课程以及课程进度
	 * 
	 * @param sql
	 *            用户标识
	 * @return json格式字符串
	 */
	public String getSectionListFromSql(String sql) {
		boolean isStudent = false;
		// 查询此用户名是否参加了此课程
		String sqlQueryStu = getStudentSql("dingbl", "1");
		List<PersonProgressBean> personProgerss = getListBySql(sqlQueryStu, PersonProgressBean.class);
		if (!personProgerss.isEmpty()) {
			isStudent = true;
		}
		// 根据用户名唯一标识获取课程列表
		String sqlQuerySectionList = getSectionListSql("dingbl", "1");
		List<SectionBean> sectionList = getListBySql(sqlQuerySectionList, SectionBean.class);
		SectionHomeList sectionHomeList = new SectionHomeList(isStudent, sectionList);
		Gson gson = new Gson();
		String resultOfJson = gson.toJson(sectionHomeList);
		System.out.println(resultOfJson);
		return resultOfJson;
	}

	/**
	 * 拼装查询课程内容的sql语句
	 * 
	 * @param item
	 *            课程内容标识
	 * @return sql语句
	 */
	private String getItemInfoOfSql(String item) {
		String itemSql = "SELECT i.curricula_item_img_path itemImgPath,i.curricula_item_audio_path itemAudioPath,i.curricula_item_id itemID,"
				+ "i.curricula_item_remarks itemRemarks,i.curricula_item_name itemName FROM yyol_curricula_item_list i "
				+ "WHERE i.curricula_item_id = '" + item + "';";
		return itemSql;
	}

	/**
	 * 获取课程内容信息
	 * 
	 * @param sql
	 *            用户信息标识
	 * @param sectionID
	 *            课程标识ID
	 * @param item
	 *            课程内容
	 * @return 课程json字符串
	 */
	public String getCurriculaItemFromSql(String sql, String sectionID, int item) {
		String itemSql = getItemInfoOfSql(sectionID + "-" + item);
		List<ItemBean> items = getListBySql(itemSql, ItemBean.class);
		Gson gson = new Gson();
		String jsonItems = gson.toJson(items);
		System.out.println(jsonItems);
		return jsonItems;
	}

	/**
	 * 程序已有
	 */
	public <T> List<T> getListBySql(String sqlstr, Class<T> clazz) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<T> lst = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sqlstr);
			rs = ps.executeQuery();
			lst = buildUpList(rs, clazz);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				rs = null;
				ps.close();
				ps = null;
				conn.close();
				conn = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return lst;
	}

	// 数据集转换列表 程序已有
	private <T> List<T> buildUpList(ResultSet rs, Class<T> clazz)
			throws SQLException, InstantiationException, IllegalAccessException, InvocationTargetException {
		List<T> lst = new ArrayList<T>();
		Field[] fields = clazz.getDeclaredFields();
		ResultSetMetaData metaData = rs.getMetaData();
		HashMap<String, String> filedmap = new HashMap<String, String>();
		for (int i = 0; i < fields.length; i++) {
			filedmap.put(fields[i].getName().toLowerCase().replace("_", ""), fields[i].getName());
		}

		while (rs.next()) {
			T newInstance = clazz.newInstance();
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				String columnlabel = metaData.getColumnLabel(i).toLowerCase().replace("_", "");
				if (filedmap.containsKey(columnlabel)) {

					BeanUtils.copyProperty(newInstance, filedmap.get(columnlabel),
							rs.getObject(metaData.getColumnLabel(i)));
				}

			}
			lst.add(newInstance);
		}
		return lst;
	}

}
