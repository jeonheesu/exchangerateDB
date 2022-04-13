package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExDB {

	public boolean overlap(String eID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbURL = "jdbc:mysql://127.0.0.1:3306/exchangerateDB?useSSL=false";
		String dbID = "root";
		String dbPW = "rootroot";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);

			String sql = "SELECT mID from exchangerate where eID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eID);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("중복되는 아이디가 존재합니다.");
			} else {
				System.out.println("중복되는 아이디가 없습니다.");
				return false;

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public void insert(String eID , String ePW) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String dbURL = "jdbc:mysql://127.0.0.1:3306/exchangerateDB?useSSL=false";
		String dbID = "root";
		String dbPW = "rootroot";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);

			String sql = "insert into exchangerate(eID, ePW) " + " values (?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eID);
			pstmt.setString(2, ePW);
			pstmt.executeUpdate();

			System.out.println("exchangerate insert() 메서드 실행 완료");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public int login(String eID , String ePW) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbURL = "jdbc:mysql://127.0.0.1:3306/exchangerateDB?useSSL=false";
		String dbID = "root";
		String dbPW = "rootroot";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);

			String sql = "SELECT eID, ePW from exchangerate where eID = ? and ePW = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eID);
			pstmt.setString(2, ePW);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				System.out.println("login 성공");
				return 1000;
			}
			System.out.println("login 실패");
		

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
	
	
	

}
