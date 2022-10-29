package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Server {

	public Connection conexion;
	private String db;

	public void connectToServer() {
		Credentials cr = new Credentials();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(
					"jdbc:mysql://192.168.1.128:3306?useTimezone=true&serverTimezone=UTC", cr.getUsuario(),
					cr.getPassword());
		} catch (SQLException | ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "No se ha podido conectar con la base de datos. " + ex);
		}
	}

	public void closeConnection() {
		try {
			conexion.close();
		} catch (SQLException e) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public void createDB(String dbName) {
		try {
			connectToServer();
			String Query = "CREATE DATABASE " + dbName;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			closeConnection();
			db = dbName;
			//System.out.println("Se ha creado la base de datos con éxito");
		} catch (SQLException e) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public void useDB() {
		try {
			String Query = "USE " + db;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			//System.out.println("Se ha seleccionado la base de datos exitosamente");
		} catch (SQLException e) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public void createTable(String tableName, String atributos) {

		try {
			connectToServer();
			useDB();
			String Query = "CREATE TABLE " + tableName + atributos;
			Statement st = conexion.createStatement();
			System.out.println(Query);
			st.executeUpdate(Query);
			
			//System.out.println("La tabla fue creada exitosamente");
		} catch (SQLException e) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public void dropDatabase(String db) {
		try {
			connectToServer();
			String Query = "DROP DATABASE " + db;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			//System.out.println("La base de datos fue eliminada correctamente");
		} catch (SQLException e) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public void insertData(String tableName, String atributos, String datos) {
		try {
			connectToServer();
			useDB();
			String Query = "INSERT INTO " + tableName + "(" + atributos + ")" + " VALUES " + datos + ";";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			//System.out.println("Los datos fueron ingresados correctamente");
		} catch (SQLException e) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public void printData(String tableName, String[] atributos) {
		try {
			connectToServer();
			useDB();
			String Query = "SELECT * FROM " + tableName;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			while (resultSet.next()) {
				for (int i = 0; i < atributos.length; i++) {
					if (i == atributos.length - 1) {
						System.out.println(atributos[i] + ": " + resultSet.getString(atributos[i]));
					} else {
						System.out.print(atributos[i] + ": " + resultSet.getString(atributos[i]) + ", ");
					}
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Ha ocurrido algún error al leer los datos");
		}
	}
}
