package j_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import e_oop.ScanUtil;

public class JDBC {
	public static void main(String[] args) {
		JDBCUtil jdbc = JDBCUtil.getInstance();
		
		
		String sql = "select * from member where mem_id between ? and ?";
		List<Object> param = new ArrayList<>();
		param.add("a001");
		param.add("c001");
		param.add("b001");

		List<Map<String, Object>> list = jdbc.selectList(sql, param);
		
		System.out.println(list);
		
		
		sql = "select * from member where mem_id = 100";
		param = new ArrayList<>();
		param.add("a001");
		Map<String, Object> map = jdbc.selectOne(sql, param);
		System.out.println(map.get("MEM_NAME-+"));
		System.out.println(map);
	
		
		/*
		 * JDBC(Java Database Connectivity)
		 * - 자바와 데이터베이스를 연결해주는 라이브러리
		 * - ojdbc : 오라클JDBC
		 * 
		 * JDBC 작성 단계
		 * 1. Connection 생성
		 * 2. Statement 생성(쿼리)
		 * 3. Query 실행
		 * 4. ResultSet에서 결과 추출(select인 경우)
		 * 5. ResultSet, Statement, Connection 닫기
		 */

		//데이터베이스 접속 정보
		/*String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jinsu";
		String password = "java";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;*/

		/*try {
			con = DriverManager.getConnection(url, user, password);

			String sql = "select * from member"; 
			ps = con.prepareStatement(sql);

			//select
			rs = ps.executeQuery();

			//insert, update, delete
			//int result = ps.executeUpdate();//영향받은 행(row)의 수를 리턴
			while(rs.next()){
				String memid = rs.getString(1);//인덱스로 값을 가져오기(인덱스는 1부터 시작)
				String memPass = rs.getString("MEM_PASS");//컬럼명으로 값을 가져오기
				System.out.println("MEM_ID : " + memid + " / MEM_PASS : " + memPass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try{rs.close();} catch(Exception e) {}
			if(ps != null) try{ps.close();} catch(Exception e) {}
			if(con != null) try{con.close();} catch(Exception e) {}
		}*/
		/*String s = "prod_id";
		
		String s1 = ScanUtil.nextLine();
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "select * from prod where prod_name =" + "'"+s1+"'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String prodid = rs.getString(s);
				String prodname = rs.getString("prod_name");
				System.out.println("prod_id : " + prodid + " / prod_name : " + prodname);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try{
				rs.close();
			} catch (Exception e) {}
			if(ps != null) try{
				ps.close();
			} catch (Exception e) {}
			if(con != null) try{
				con.close();
			} catch (Exception e) {}
		}*/
		
	}

}
