package BurgerMi_15_15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DB {

	String name;
	Connection conn = null;
	PreparedStatement pstmt = null;

	DB() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/burgermi?serverTimezone=Asia/Seoul&useSSL=false", "root", "mirim2");
			System.out.println("DB 연결 완료");
		} catch (SQLException ex) {
			System.out.println("SQLException:" + ex);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);
		}
	}

	public void Select() {
		try {
			String sql = "SELECT * FROM ranking ORDER BY rank ASC";
			pstmt = conn.prepareStatement(sql);
			ResultSet srs = pstmt.executeQuery();
			while (srs.next()) {
				System.out.print(srs.getString("no") + " ");
				System.out.print(srs.getString("score") + " ");
				System.out.print(srs.getString("name") + " ");
				System.out.print(srs.getString("rank") + " ");
				System.out.println();
			}
		} catch (SQLException ex) {
			System.out.println("Select SQLException:" + ex);
		} catch (Exception ex) {
			System.out.println("Select Exception:" + ex);
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException sqle) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException sqle) {
				}
		}
	}

	public void Insert(int s) {
		int num = 0;
		String rank = null;
		String score = Integer.toString(s);
		boolean update = false;

		name = JOptionPane.showInputDialog("이름을 입력하세요.");

		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet srs = stmt.executeQuery("SELECT * FROM ranking");
			srs.last(); // 커서의 위치를 제일 뒤로 이동
			num = srs.getRow(); // 현재 커서의 Row Index 값을 저장
			String no = Integer.toString(num + 1);
			System.out.println(no);

			String sql = "SELECT * FROM ranking ORDER BY score DESC";
			pstmt = conn.prepareStatement(sql);
			srs = pstmt.executeQuery();

			if (Integer.parseInt(no) <= 1) {
				rank = "1";
			} else {
				while (srs.next()) {
					int dbScore = Integer.parseInt((srs.getString("score")));
					if (s > dbScore) {
						if (srs.getString("rank").equals("1")) {
							System.out.println("rank 1");
							rank = "1";
							if(s == dbScore) break;
						} else {
							rank = Integer.toString(Integer.parseInt(srs.getString("rank")));
						}
						update = true;
						Update(rank);
						break;
					} else if (s == dbScore) {
						rank = Integer.toString(Integer.parseInt(srs.getString("rank")));
						update = true;
						break;
					}
					else{
						rank = Integer.toString(Integer.parseInt(srs.getString("rank")) + 1);						
						update = false;
					}
				}
				if(!update) Update(rank);
			}

			sql = "insert into ranking (no, score, name, rank) values (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.setString(2, score);
			pstmt.setString(3, name);
			pstmt.setString(4, rank);
			System.out.println("insert!!");

			pstmt.executeUpdate();

			Select();

		} catch (SQLException ex) {
			System.out.println("Insert SQLException:" + ex);
		} catch (Exception ex) {
			System.out.println("Insert Exception:" + ex);
		}
	}

	public void Update(String rank) {
		int num, num2=0;
		try {
			System.out.println("update");
			String sql = "SELECT * FROM ranking WHERE rank>=? ORDER BY score ASC";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rank);
			ResultSet srs = pstmt.executeQuery();
			srs.first();
			int rankInt = Integer.parseInt(srs.getString("rank"));
			
			//Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			sql = "SELECT DISTINCT rank FROM ranking WHERE rank>=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rank);
			ResultSet rankSrs = pstmt.executeQuery();
			rankSrs.last(); // 커서의 위치를 제일 뒤로 이동
			num = rankSrs.getRow(); // 현재 커서의 Row Index 값을 저장
			System.out.println("num : " + num);
			rankInt++;
			
			
//			int rankInt = Integer.parseInt(rank);
			do {
				if(num2==num) break;
				else num2++;
				System.out.println("while");
				sql = "UPDATE ranking set rank = ? where rank = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, Integer.toString(rankInt));
				pstmt.setString(2, Integer.toString(--rankInt));
				pstmt.executeUpdate(); // 실행시키는 거
			} while (srs.next());

//			rank = Integer.toString(Integer.parseInt(rank)+1);
		} catch (SQLException ex) {
			System.out.println("Update SQLException:" + ex);
		} catch (Exception ex) {
			System.out.println("Update Exception:" + ex);
		}
	}
}
