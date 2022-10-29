package ejercicio4;

import utils.Server;

public class Ejercicio4 {

	public Ejercicio4() {
		Server server1 = new Server();
		server1.createDB("TA18_EX4");
		
		server1.createTable("salas",
				"(codigo INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100),pelicula INT REFERENCES pelicula(codigo) ON DELETE CASCADE ON UPDATE CASCADE);");
		
		server1.createTable("peliculas",
				"(codigo INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100), calificacion_edad INT);");
		
		server1.insertData("peliculas", "nombre, calificacion_edad",
				"(\"El señor de los anillos\", 13), (\"Peter Pan\", 3),(\"Guerra mundial Z\", 13),(\"Donnie Darko\", 13),(\"Animales nocturnos\", 16),(\"El padrino\", 16),(\"The big Lebowski\", 13)");
		
		server1.insertData("salas", "nombre, pelicula",
				"(\"Sala 1\", 1),(\"Sala 2\", 2),(\"Sala 3\", 3),(\"Sala 4\", 4),(\"Sala 5\", 5)");

		String[] atributos = { "nombre", "calificacion_edad"};
		server1.printData("peliculas", atributos);
		server1.dropDatabase("TA18_EX4");

	}

}
