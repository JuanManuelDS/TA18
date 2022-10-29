package ejercicio6;

import utils.Server;

public class Ejercicio6 {

	public Ejercicio6() {
		Server server1 = new Server();
		server1.createDB("TA18_EX6");
		
		server1.createTable("piezas",
				"(codigo INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100));");
		
		server1.createTable("proveedores",
				"(id CHAR(4) PRIMARY KEY, nombre VARCHAR(100));");
		
		server1.createTable("suministra",
				"(codigo_pieza INT REFERENCES piezas(codigo) ON DELETE CASCADE ON UPDATE CASCADE, proveedor CHAR(4) REFERENCES proveedores(id) ON DELETE"
				+ " CASCADE ON UPDATE CASCADE, precio INT, PRIMARY KEY(codigo_pieza, proveedor));");
		
		server1.insertData("piezas", "nombre",
				"(\"Zapatillas\"),(\"Coca Cola Zero\"),(\"Maiz\"),(\"Harina\"),(\"Garbanzos\"),(\"Remeras\")");
		
		server1.insertData("proveedores", "id, nombre",
				"(\"abcd\",\"Mercadona\"),(\"abce\",\"Valor\"),(\"abcf\",\"Carrefour\"),(\"abca\",\"Esclat\"),(\"abcb\",\"Adidas\")");
		
		server1.insertData("suministra", "codigo_pieza, proveedor, precio",
				"(1,\"abcc\", 250), (2,\"abch\", 5), (3,\"abcd\",2), (4,\"abcd\",6),(5,\"abcd\",2.20)");

		String[] atributos = { "nombre"};
		server1.printData("piezas", atributos);
		server1.dropDatabase("TA18_EX6");
	}
}
