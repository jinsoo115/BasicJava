package j_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC2 {

	public static void main(String[] args) {
		//데이터베이스 접속 정보
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "jinsu";
				String password = "java";

				Connection con = null;
				PreparedStatement ps = null;
				ResultSet rs = null;

				try {
					con = DriverManager.getConnection(url, user, password);

//					String sql = "select * from member where mem_id = ?"; 
//					ps = con.prepareStatement(sql);
//					ps.setString(1, "a001");
//					ps.setInt(parameterIndex, x);
//					ps.setObject(parameterIndex, x);
					
					//select
//					rs = ps.executeQuery();
//					ResultSetMetaData md = rs.getMetaData(); //메타데이터 : 데이터에 대한 데이터
//					int columnCount = md.getColumnCount(); //컬럼 수 
					
					
					//insert, update, delete
					/*String insert = "insert into lprod values(?, ?, ?)";
					ps = con.prepareStatement(insert);
					ps.setInt(1, 11);
					ps.setString(2, "P601");
					ps.setString(3, "식품");*/
					
					String delete = "delete from lprod where lprod_id = ?";
					ps = con.prepareStatement(delete);
					ps.setObject(1, 123);
					int result = ps.executeUpdate();//영향받은 행(row)의 수를 리턴
					
					System.out.println("변경된 row" + result);
//					while(rs.next()){
//						for(int i = 1; i <= columnCount; i++){
//							md.getColumnName(i);
//							System.out.print(rs.getObject(i) + "\t");
//						}
//						System.out.println();
//					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if(rs != null) try{rs.close();} catch(Exception e) {}
					if(ps != null) try{ps.close();} catch(Exception e) {}
					if(con != null) try{con.close();} catch(Exception e) {}
				}
	}

}
