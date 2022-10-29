package ejercicio3;

import utils.Server;

public class Ejercicio3 {

	public Ejercicio3() {
		Server server1 = new Server();
		server1.createDB("TA18_EX3");
		server1.createTable("almacenes", "(codigo INT AUTO_INCREMENT PRIMARY KEY, lugar VARCHAR(100), capacidad INT);");
		server1.createTable("cajas",
				"(num_referencia CHAR(5) PRIMARY KEY, contenido VARCHAR(100), valor INT,  almacen INT REFERENCES almacenes(codigo) ON UPDATE CASCADE ON DELETE CASCADE);");
		server1.insertData("almacenes", "lugar, capacidad",
				"('Barcelona',15000),('Reus',1000),('Tarragona',550),('Valencia', 1500),('Granada', 2700), ('Madrid',0)");
		server1.insertData("cajas", "num_referencia, contenido, valor, almacen",
				"(\"abcde\", \"Globos\", 1500, 1),(\"abctr\", \"Vasos\", 2500, 2),(\"abcfg\", \"Gorras\", 5500, 2),(\"ggggg\", \"Arroz\", 200, 2)"
						+ ",(\"jjjj\", \"Maicena\", 50, 1)");
		
		String[] atributos = { "num_referencia", "contenido", "valor", "almacen" };
		server1.printData("cajas", atributos);
		server1.dropDatabase("TA18_EX3");

	}
}
