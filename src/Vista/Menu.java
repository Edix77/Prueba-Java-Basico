package Vista;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Modelo.CategoriaEnum;
import Modelo.Cliente;
import Servicio.ClienteServicio;
import Servicio.ExportadorCsv;
import Servicio.ExportadorTxt;
import Utilidades.Utilidad;

public class Menu extends MenuTemplate {
	
	
	Scanner sc = new Scanner(System.in);
	// private ClienteServicio clienteServicio = new ClienteServicio();
	ClienteServicio clienteServicio = new ClienteServicio();
	ExportadorCsv exportadorCsv = new ExportadorCsv();
	ExportadorTxt exportadorTxt = new ExportadorTxt();
	String fileName = "clientes";

	// private List<Cliente> listaClientes = new ArrayList<Cliente>();
	// ArrayList<Cliente> listarCliente = new ArrayList<Cliente>();

	public void menu1() {
		
		
		
		
		Menu menu = new Menu();
		int opcion = 0;
		do {
			System.out.println("Bienvenido al Sistema de Clientes, que desea hacer: ");
			System.out.println();
			System.out.println("1.Listar Cliente");
			System.out.println("2.Agregar Cliente");
			System.out.println("3.Editar Cliente");
			System.out.println("4.Cargar Datos");
			System.out.println("5.Exportar Datos:");
			System.out.println("6.Salir");
			System.out.println();
			System.out.println("Ingrese una opcion");
			System.out.println("Ingrese una opcion");
			opcion = sc.nextInt();
			
			
			

			switch (opcion) {
			case 1:
				menu.listarCliente();
				Utilidades.Utilidad.limpiaPantalla();
				Utilidades.Utilidad.sleep2();
				
				break;
			case 2:
				menu.agregarCliente();
				Utilidad.limpiaPantalla();
				Utilidad.sleep2();
				
				break;
			case 3:
				menu.editarCliente();
				Utilidad.limpiaPantalla();
				Utilidad.sleep2();
				break;
			case 4:
				menu.cargarDatos();
				Utilidad.limpiaPantalla();
				Utilidad.sleep2();
				break;
			case 5:
				menu.exportarDatos();
				Utilidad.limpiaPantalla();
				Utilidad.sleep2();
				break;
			case 6:
				menu.terminarPrograma();
				break;

			default:
				break;
			}

		} while (opcion >= 1 && opcion <= 5);
	}

	@Override
	public void listarCliente() {
		clienteServicio.retornolistarClientes();

		/**
		 * for (Cliente clienteListado : listarCliente) { System.out.println("Datos del
		 * Cliente"); System.out.println(); System.out.println("Run del Cliente " +
		 * clienteListado.getRunCliente()); System.out.println("Nombre del Cliente " +
		 * clienteListado.getNombreCliente()); System.out.println("Apellido del cliente
		 * " + clienteListado.getApellidoCliente()); System.out.println("A�os como
		 * cliente " + clienteListado.getAniosCliente()); System.out.println("Categoria
		 * del cliente " + clienteListado.getNombreCategoria());
		 * System.out.println("\n-------------------------------------");
		 */
	}

	@Override
	public void agregarCliente() {

		System.out.println("Ingrese Run del Cliente: ");
		String runCliente = sc.nextLine();
		// clienteIngresado.setRunCliente(sc.nextLine());
		System.out.println("Ingrese nombre del Cliente: ");
		String nombreCliente = sc.nextLine();
		// clienteIngresado.setNombreCliente(sc.nextLine());
		System.out.println("Ingrese apellido del Cliente: ");
		String apellidoCliente = sc.nextLine();
		// clienteIngresado.setApellidoCliente(sc.nextLine());
		System.out.println("Ingrese a�os como Cliente: ");
		String aniosCliente = sc.nextLine();
		// clienteIngresado.setAniosCliente(sc.nextLine());
		// clienteIngresado.setNombreCategoria(CategoriaEnum.ACTIVO);
		System.out.println("Cliente agregado correctamente");

		clienteServicio.agregarCliente1(runCliente, nombreCliente, apellidoCliente, aniosCliente, CategoriaEnum.ACTIVO);

		// listaCliente.add(clienteIngresado);

		System.out.println();

		listarCliente();

	}

	@Override
	public void editarCliente() {

		int opcion = 0;

		System.out.println("---------------Editar Cliente------------");
		System.out.println();
		System.out.println("Seleccione que desea hacer: ");
		System.out.println("1- Cambiar el estado del cliente");
		System.out.println("2- Editar los datos ingresados al cliente");
		System.out.println();
		System.out.println("Ingrese una opcion");
		System.out.println("-----------------------------------------");
		opcion = sc.nextInt();
		sc.nextLine();

		if (opcion == 1) {
			System.out.println("Ingrese Run del cliente a Editar");
			String run1 = sc.nextLine();
			for (Cliente clienteAEditar : clienteServicio.getListaClientes()) {
				if (run1.equalsIgnoreCase(clienteAEditar.getRunCliente())) {
					System.out.println("----Actualizando estado del cliente----");
					System.out.println();

					System.out.println("El estado actual es Activo : " + clienteAEditar.getNombreCategoria());
					System.out.println("1.-Si desea cambiar el estado del Cliente a Inactivo");
					System.out.println("2.-Si desea mantener el estado del Cliente Activo");
					opcion = sc.nextInt();

					switch (opcion) {
					case 1:
						clienteAEditar.setNombreCategoria(CategoriaEnum.INACTIVO);
						System.out.println("Estado actualizado a Inactivo:  " + clienteAEditar.getNombreCategoria());

						break;
					case 2:
						clienteAEditar.setNombreCategoria(CategoriaEnum.ACTIVO);
						System.out.println("Estado del cliente sin cambios " + clienteAEditar.getNombreCategoria());

						break;

					default:
						break;
					}
				}
			}
		} else {
			System.out.println("Ingrese Run del cliente a Editar");
			String run = sc.nextLine();

			for (Cliente clienteAEditar : ((ClienteServicio) clienteServicio).getListaClientes()) {
				if (run.equalsIgnoreCase(clienteAEditar.getRunCliente())) {
					System.out.println("----Actualizando datos del Cliente---");
					System.out.println();
					System.out.println("1- El Run del Cliente es: " + clienteAEditar.getRunCliente());
					System.out.println("2- El Nombre del Cliente es: " + clienteAEditar.getNombreCliente());
					System.out.println("3- El Apellido del Cliente es: " + clienteAEditar.getApellidoCliente());
					System.out.println("4- Los A�os como Cliente son: " + clienteAEditar.getAniosCliente());
					System.out.println();
					System.out.println("Ingrese opcion a editar de los datos del Cliente");
					int opcionEditar = sc.nextInt();
					sc.nextLine();

					if (opcionEditar == 1) {
						System.out.println("1- Ingrese nuevo Run del Cliente");
						String runEditar = sc.nextLine();
						clienteAEditar.setRunCliente(runEditar);
						System.out.println("Datos cambiados con exito");
						System.out.println();

					}
					if (opcionEditar == 2) {
						System.out.println("1- Ingrese nuevo Nombre  del Cliente");
						String nombreEditar = sc.nextLine();
						clienteAEditar.setNombreCliente(nombreEditar);
						System.out.println("Datos cambiados con exito");
						System.out.println();

					}
					if (opcionEditar == 3) {
						System.out.println("1- Ingrese nuevo Apellido  del Cliente");
						String apellidoEditar = sc.nextLine();
						clienteAEditar.setApellidoCliente(apellidoEditar);
						System.out.println("Datos cambiados con exito");
						System.out.println();

					}
					if (opcionEditar == 4) {
						System.out.println("1- Ingrese A�os como Cliente");
						String aniosEditar = sc.nextLine();
						clienteAEditar.setAniosCliente(aniosEditar);
						System.out.println("Datos cambiados con exito");
						System.out.println();

					}

				}
			}
		}

	}

	@Override
	public ArrayList<Cliente> cargarDatos() {

		System.out.println("Ingresa la ruta donde se encuentra el archivoDBClientes.csv: ");
		System.out.println("Ejemplo: /PruebaJavaBasico/DBClientes.csv ");
		String archivoCsv = sc.nextLine();
		System.out.println();

		ArrayList<Cliente> clientesARetornar = new ArrayList<Cliente>();

		try {
			FileReader fr = new FileReader("DBClientes.Csv");
			BufferedReader br = new BufferedReader(fr);
			String lineaArchivo = br.readLine();

			while (lineaArchivo != null) {

				String[] elementoCliente = lineaArchivo.split(",");

				Cliente clienteTemp = new Cliente(elementoCliente[0], elementoCliente[1], elementoCliente[2],
						elementoCliente[3], CategoriaEnum.valueOf(elementoCliente[4]));
				System.out.println();
				clientesARetornar.add(clienteTemp);

				lineaArchivo = br.readLine();
			}
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(clientesARetornar);
		return clientesARetornar;

	}

	@Override
	public void exportarDatos() {

		System.out.println("-------Exportar Datos--------");
		System.out.println("Selecciona el formato a exportar: ");
		System.out.println();
		System.out.println("1.- Formato csv");
		System.out.println("(El archivo se llamar� Clientes.csv)");
		System.out.println("2.- Formato txt");
		System.out.println("(El archivo se llamar� Clientes.txt)");
		System.out.println("Ingresa una opcion para Exportar: ");
		System.out.println("-----------------------------------");
		System.out.println();
		int opcionFormato = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Por favor indica tu ambiente de trabajo: ");
		System.out.println();
		System.out.println("1.-  Para Linux o Mac.");
		System.out.println("2-.  Para Windows.");
		System.out.println();
		int opcionAmbiente = sc.nextInt();
		sc.nextLine();

		System.out.println("Ingresa el nombre de la carpeta donde deseas guardar el archivo");
		System.out.println("La crear� dentro de PruebaJavaBasico.carpetaDeTrabajo");
		String Carpeta = sc.nextLine();

		while (Carpeta == null || Carpeta.isEmpty() || Carpeta.contains(" ")) {
			System.out.println("El nombre de la carpeta no puede se nulo, estar vac�o o contener espacios en blanco");
			System.out.println();
			System.out.println("Ingresa un nombre v�lido para la carpeta donde deseas dejar el archivo");
			Carpeta = sc.nextLine();
		}

		File directorioLinuxMac = new File("carpetaDeTrabajo/" + Carpeta);
		File directorioWindows = new File("carpetaDeTrabajo\\" + Carpeta);

		if (opcionAmbiente == 1) {
			if (!directorioLinuxMac.exists()) {
				directorioLinuxMac.mkdirs();
				System.out.println("Carpeta creada exitosamente en " + directorioLinuxMac.toString());
				System.out.println();

				if (opcionFormato == 1) {
					exportadorCsv.exportar(directorioLinuxMac.toString(), fileName, clienteServicio.getListaClientes());
				}

				if (opcionFormato == 2) {
					exportadorTxt.exportar(directorioLinuxMac.toString(), fileName, clienteServicio.getListaClientes());
				}
			}
			

		}

		if (opcionAmbiente == 2) {
			if (!directorioWindows.exists()) {
				directorioWindows.mkdirs();
				System.out.println("Carpeta creada exitosamente en : " + directorioWindows.toString());

				if (opcionFormato == 1) {
					exportadorCsv.exportar(directorioWindows.toString(), fileName, clienteServicio.getListaClientes());
				}

				if (opcionFormato == 2) {
					exportadorTxt.exportar(directorioWindows.toString(), fileName, clienteServicio.getListaClientes());
				}

			}

		}

	}

	@Override
	public  void terminarPrograma() {
		
		System.out.println("Hasta la proxima...");
		String bye = sc.nextLine();
		System.out.println();
		
	

	}
}
