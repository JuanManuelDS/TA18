package ejercicio5;

import utils.Server;

public class Ejercicio5 {
	
	public Ejercicio5() {
		
		Server server1 = new Server();
		server1.createDB("TA18_EX5");
		
		server1.createTable("directores",
				"(dni VARCHAR(8) PRIMARY KEY, nom_apels VARCHAR(100), dni_jefe VARCHAR(8) REFERENCES directores(dni) ON DELETE CASCADE ON UPDATE CASCADE, despacho INT REFERENCES despachos(codigo) ON DELETE CASCADE ON UPDATE CASCADE;");
		
		server1.createTable("despachos",
				"(numero INT PRIMARY KEY, capacidad INT);");
		
		server1.insertData("directores", "dni, nom_apels, dni_jefe, despacho",
				"(\"12345678\", \"Juan Perez\", \"\", 101),(\"12345679\", \"Lautaro Acosta\", \"\", 101),(\"12345670\", \"Pepe Sand\", \"\", 102),(\"12345671\", \"Gustavo Martínez\", \"\", 103),(\"12345672\", \"Cebolla Rodriguez\", \"12345678\", 105)");
		
		server1.insertData("despachos", "numero, capacidad",
				"(1, 10),(2, 20),(3, 11),(4, 50),(5, 1010)");

		String[] atributos = { "numero", "capacidad"};
		server1.printData("despachos", atributos);
		server1.dropDatabase("TA18_EX5");
	}
	
}
