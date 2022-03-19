package Servicio;

import java.util.ArrayList;
import java.util.List;

import Modelo.CategoriaEnum;
import Modelo.Cliente;

public class ClienteServicio {

	private List<Cliente> listaClientes = new ArrayList<Cliente>();

	public ClienteServicio() {
		super();
	}

	public ClienteServicio(List<Cliente> listaClientes) {
		super();
		this.listaClientes = listaClientes;
	}
	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void retornolistarClientes() {
		for (Cliente clienteTemporal : listaClientes) {

			System.out.println("------------  Datos del Cliente  ------------");
			System.out.println();

			System.out.println("RUN del Cliente: " + clienteTemporal.getRunCliente());
			System.out.println("Nombre del Cliente: " + clienteTemporal.getNombreCliente());
			System.out.println("Apellido del Cliente: " + clienteTemporal.getApellidoCliente());
			System.out.println("Años como Cliente: " + clienteTemporal.getAniosCliente());
			System.out.println("Categoría del Cliente: " + clienteTemporal.getNombreCategoria());
			System.out.println();
			System.out.println("--------------------------------------------");
		}

	}

	public void agregarCliente1(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum activo) {

		Cliente clienteTemp = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente,
				CategoriaEnum.ACTIVO);

		if (clienteTemp != null) {
			listaClientes.add(clienteTemp);
		}

	}
	
	public void editarCliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum nombreCategoria) {
		
	}

	

}
