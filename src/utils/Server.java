package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Server {
		
		public static Connection conexion;
		
		public static void connectToServer() {
			Credentials cr = new Credentials();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.128:3306?useTimezone=true&serverTimezone=UTC", cr.getUsuario(), cr.getPassword());
				System.out.println("Servidor conectado");
			} catch(SQLException | ClassNotFoundException ex) {
				JOptionPane.showMessageDialog(null,"No se ha podido conectar con la base de datos. " + ex);
			}
		}
		
		public static void closeConnection() {
			try {
				conexion.close();
				System.out.println("La conexión se cerró con éxito");
			} catch (SQLException e) {
				Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		
		public static void createDB (String dbName) {
			try {
				connectToServer();
				String Query = "CREATE DATABASE " + dbName;
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				closeConnection();
				System.out.println("Se ha creado la base de datos con éxito");
			} catch (SQLException e) {
				Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		
		public static void useDB(String dbName) {
			try {
				connectToServer();
				String Query = "USE " + dbName;
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				closeConnection();
				System.out.println("Se ha seleccionado la base de datos exitosamente");
			} catch( SQLException e) {
				Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
			}
		}
	
		public static void createTable(String tableName, String atributos) {			
			
			try {
				connectToServer();
				String Query = "CREATE TABLE " + tableName + atributos;
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("La tabla fue creada exitosamente");
			} catch (SQLException e) {
				Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		
		public static void insertData(String tableName, String atributos, String datos) {
			try {
				connectToServer();
				String Query = "INSERT INTO " + tableName + atributos + " VALUES (" + datos + ");";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Los datos fueron ingresados correctamente");
			} catch (SQLException e) {
				Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		
		public static void printData(String tableName) {
			try {
				connectToServer();
				String Query = "SELECT * FROM " + tableName;
				Statement st = conexion.createStatement();
				java.sql.ResultSet resultSet;
				resultSet = st.executeQuery(Query);
				
				while(resultSet.next()) {
					System.out.println();
				}
			} catch (SQLException e) {
				Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
			}
		}
}
