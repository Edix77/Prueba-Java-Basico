package Servicio;

import java.util.List;

import Modelo.Cliente;

public abstract class Exportador {

	public abstract void exportar(String directorio, String fileName, List<Cliente> listaClientes);
	
	
}
