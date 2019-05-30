package entity;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {

	public static void lireEnBase() throws IOException {

		String url = "jdbc:mysql://localhost:3306/map?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		ResultSet rs = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, passwd);

			String query = "{CALL Map1()}";

			java.sql.CallableStatement stmt = cn.prepareCall(query);

			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String map1 = rs.getString("MapLines");
				FileWriter map = new FileWriter("src\\main\\map.txt");
				map.write(map1);
				System.out.println(map1);

			}
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
