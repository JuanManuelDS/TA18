package ejercicio9;

import utils.Server;

public class Ejercicio9 {

	public Ejercicio9() {
		Server server1 = new Server();
		server1.createDB("TA18_EX9");

		server1.createTable("facultad", "(codigo INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100));");

		server1.createTable("investigadores",
				"(dni VARCHAR(8) PRIMARY KEY, nom_apels VARCHAR(100), facultad INT REFERENCES facultad(codigo) ON DELETE CASCADE ON UPDATE CASCADE);");

		server1.createTable("equipos",
				"(num_serie CHAR(4) PRIMARY KEY,nombre VARCHAR(100), facultad INT REFERENCES facultad(codigo) ON DELETE CASCADE ON UPDATE CASCADE);");

		server1.createTable("reserva",
				"(investigador VARCHAR(8) REFERENCES investigadores(dni) ON DELETE CASCADE ON UPDATE CASCADE,"
						+ "equipo CHAR(4) REFERENCES equipos(num_serie) ON DELETE CASCADE ON UPDATE CASCADE,"
						+ "comienzo DATETIME, fin DATETIME, PRIMARY KEY(investigador, equipo));");

		server1.insertData("facultad", "nombre",
				"('Universidad de Salamanca'),('CALTECH'),('UBA'),('Universidad Complutense de Madrid'),('Universidad de Florencia')");

		server1.insertData("equipos", "num_serie, nombre, facultad",
				"('AAAA', 'Tortilla de papas', 1),('AAAB', 'Lasagna', 1),('AAAC', 'Pizza', 1),('AAAD', 'Power Rangers', 5),('AAAE', 'Supercampeones', 6)");

		server1.insertData("investigadores", "dni, nom_apels, facultad",
				"('24562789', 'Juan Pérez', 1),('12345678', 'María Gomez', 1),('56325486', 'Francisco Algo', 1),"
						+ "('85214796', 'Alma Otracosa', 8),('32165498', 'Pepe Gimenez', 8)");

		server1.insertData("reserva", "investigador, equipo",
				"('24562789', 'AAAA'),('12345678', 'AAAA'),('56325486', 'AAAA'),('32165498', 'AAAF'),('85214796', 'AAAF')");

		String[] atributos = { "dni", "nom_apels", "facultad" };
		server1.printData("investigadores", atributos);
		server1.dropDatabase("TA18_EX9");

	}

}
