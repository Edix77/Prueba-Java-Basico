package Vista;

import java.util.ArrayList;

import Modelo.Cliente;
import Utilidades.Utilidad;

public abstract class MenuTemplate {
	
	
	
	
	public abstract void listarCliente();
	public abstract void agregarCliente();
	public abstract void editarCliente();
	public abstract ArrayList<Cliente> cargarDatos();
	public abstract void exportarDatos();
	public abstract void terminarPrograma();
	
	
	
	public void menu1() {
		
	}


}
