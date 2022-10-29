package ejercicio8;

import utils.Server;

public class Ejercicio8 {

	public Ejercicio8() {
		Server server1 = new Server();
		server1.createDB("TA18_EX8");
		
		server1.createTable("cajeros",
				"(codigo INT AUTO_INCREMENT PRIMARY KEY, nom_apels VARCHAR(100));");
		
		server1.createTable("productos",
				"(codigo INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100), precio INT);");
		
		server1.createTable("maquinas_registradoras",
				"(codigo INT AUTO_INCREMENT PRIMARY KEY, piso INT);");
		
		server1.createTable("venta",
				"(cajero INT REFERENCES cajero(codigo) ON DELETE CASCADE ON UPDATE CASCADE, producto INT REFERENCES productos(codigo) ON"
				+ " DELETE CASCADE ON UPDATE CASCADE, maquina INT REFERENCES maquinas_registradoras(codigo) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "PRIMARY KEY(cajero, producto, maquina));");
		
		server1.insertData("cajeros", "nom_apels",
				"(\"Juan Perez\"),( \"Lautaro Acosta\"),(\"Pepe Sand\"),(\"Gustavo Martínez\"),(\"Cebolla Rodriguez\")");
		
		server1.insertData("productos", "nombre, precio",
				"(\"Zapatillas\", 56),(\"Coca Cola Zero\", 3.50),(\"Maiz\", 1.50),(\"Harina\", 2),(\"Garbanzos\", 3)");
		
		server1.insertData("maquinas_registradoras", "piso",
				"(1),(2),(3),(4),(5)");
		
		server1.insertData("venta", "cajero, producto, maquina",
				"(1,2,3),(1,2,2),(1,2,4),(2,5,4),(6,1,1)");

		String[] atributos = { "nombre", "precio"};
		server1.printData("productos", atributos);
		server1.dropDatabase("TA18_EX8");
		
	
	}
	
}
