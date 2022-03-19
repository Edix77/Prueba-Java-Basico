package Main;

import Vista.Menu;

public class Main {

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.menu1();
		menu.listarCliente();
		menu.agregarCliente();
		menu.editarCliente();
		menu.cargarDatos();
		menu.exportarDatos();
		menu.terminarPrograma();
		
		
	}

}
