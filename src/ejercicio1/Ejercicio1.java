package ejercicio1;

import utils.Server;

public class Ejercicio1 {
	
	public Ejercicio1() {
		Server server1 = new Server();
		server1.createDB("TA18_EX1");
		server1.createTable("fabricantes", "(codigo INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100));");
		server1.createTable("articulos", "(codigo INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100), precio INT, fabricante INT REFERENCES fabricantes(codigo) ON UPDATE CASCADE ON DELETE CASCADE);");
		server1.insertData("fabricantes", "nombre", "('Hacendado'),('Valor'), ('Decathlon'), ('Coca Cola'), ('Pepsi')");
		server1.insertData("articulos", "nombre, precio, fabricante", "('Pan', 5, 1),"
				+ "('Caviar', 25, 1),"
				+ "('Langosta', 20, 1),"
				+ "('Salmón', 15, 2),"
				+ "('Arroz', 3, 2),"
				+ "('Bolsa Arroz', 3,1)");
		String[] atributos = {"nombre", "precio", "fabricante"};
		server1.printData("articulos", atributos);
		server1.dropDatabase("TA18_EX1");
	}
	
}
