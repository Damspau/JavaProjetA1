package entity;

import java.io.FileWriter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <h1>The Class DB.</h1>
 *
 * @author Damiens, Benoît D et Maxime G
 */
public class DB {

	public static void lireEnBase() throws IOException {

		String url = "jdbc:mysql://localhost:3306/maps?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		ResultSet rs = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, passwd);

			String query = "{CALL Map2()}";

			java.sql.CallableStatement stmt = cn.prepareCall(query);

			rs = stmt.executeQuery(query);

			FileWriter map = new FileWriter("map.txt");

			while (rs.next()) {
				String map1 = rs.getString("MapLines");
				map.write(map1);
				map.write("\r\n");
				System.out.println(map1);

			}
			map.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
