package Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import Modelo.CategoriaEnum;
import Servicio.ClienteServicio;

public class ClienteServicioTest {

	ClienteServicio clienteServicio = new ClienteServicio();

	@Test
	public void agrearClienteTest() {
		// Cliente(String runCliente, String nombreCliente, String apellidoCliente,
		// String aniosCliente,CategoriaEnum nombreCategoria)

		// Cliente cliente = new Cliente("1611-1"," Edinson", "Navas", "1",
		// CategoriaEnum.ACTIVO);
		clienteServicio.agregarCliente1("1611-1", " Edinson", "Navas", "1", CategoriaEnum.ACTIVO);
		int resultado = clienteServicio.getListaClientes().size();
		assertEquals(1, resultado);
	}

	@Test
	public void agrearClienteNullTest() {
		clienteServicio.agregarCliente1(null, null, null, null, null);
		String resultado = clienteServicio.getListaClientes().get(0).getRunCliente();
		System.out.println(resultado);
		assertNull(null, resultado);
	}

}
