package ejercicio7;

import utils.Server;

public class Ejercicio7 {

	public Ejercicio7() {

		Server server1 = new Server();
		server1.createDB("TA18_EX7");
		
		server1.createTable("cientificos",
				"(dni VARCHAR(8) PRIMARY KEY, nom_apels VARCHAR(100));");
		
		server1.createTable("proyectos",
				"(id CHAR(4) PRIMARY KEY, nombre VARCHAR(100), horas INT);");
		
		server1.createTable("asignado_a",
				"(cientifico VARCHAR(8) REFERENCES cientificos(dni) ON DELETE CASCADE ON UPDATE CASCADE, proyecto CHAR(4) REFERENCES proyectos(id) ON "
				+ "DELETE CASCADE ON UPDATE CASCADE, PRIMARY KEY(cientifico, proyecto));");
		
		server1.insertData("cientificos", "dni, nom_apels",
				"(\"12345678\", \"Juan Perez\"),(\"12345679\", \"Lautaro Acosta\"),(\"12345670\", \"Pepe Sand\"),"
				+ "(\"12345671\", \"Gustavo Martínez\"),(\"12345672\", \"Cebolla Rodriguez\")");
		
		server1.insertData("proyectos", "id, nombre, horas",
				"(\"abcd\",\"Cancer\", 10000),(\"abce\",\"VIH\", 100000),(\"abcf\",\"Fisión nuclear\", 200000),(\"abca\",\"Hidrógeno verde\", 250000),"
				+ "(\"abcb\",\"Batería infinita\", 500000)");
		
		server1.insertData("asignado_a", "cientifico, proyecto",
				"(\"12345678\",\"abcd\"),(\"12345679\",\"abcd\"),(\"12345670\",\"abcd\"),(\"12345671\",\"abca\"),(\"12345672\",\"abca\")");

		String[] atributos = { "dni", "nom_apels"};
		server1.printData("cientificos", atributos);
		server1.dropDatabase("TA18_EX7");
	
	}
	
}
