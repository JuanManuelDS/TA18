package ejercicio2;

import utils.Server;

public class Ejercicio2 {

	public Ejercicio2() {
		Server server1 = new Server();
		server1.createDB("TA18_EX2");
		server1.createTable("departamentos", "(codigo INT PRIMARY KEY, nombre VARCHAR(100), presupuesto INT);");
		server1.createTable("empleados", "(dni VARCHAR(8) PRIMARY KEY, nombre VARCHAR(100), apellidos VARCHAR(100), departamento INT REFERENCES departamentos(codigo) ON UPDATE CASCADE ON DELETE CASCADE);");
		server1.insertData("departamentos", "codigo, nombre, presupuesto", "(1, 'Finanzas', 15000),(2, 'Marketing', 450000),(3, 'IT', 255000),(4, 'Recursos humanos', 10000), (5, 'Ventas', 50000)");
		server1.insertData("empleados", "dni, nombre, apellidos, departamento", "('12345678', 'Juan', 'Perez', 3),('23445678', 'Maria', 'Gomez', 3),('34545678', 'Pepe', 'Perez', 3), "
				+ "('23456789', 'Angel', 'Di Maria', 2),('34567891', 'Leo', 'Paredes', 2),('45678912', 'Roberto', 'Messi', 1)");
		String[] atributos = {"dni", "nombre", "apellidos", "departamento"};
		server1.printData("empleados", atributos);
		server1.dropDatabase("TA18_EX2");
		
	}
	
}
