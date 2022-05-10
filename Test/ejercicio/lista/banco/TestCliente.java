package ejercicio.lista.banco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class TestCliente {

	@Test
	public void pruebaQueCreaUnCliente() {

		Cliente miCliente = new Cliente(30333444, "juan", "Perez");
		Assert.assertEquals(30333444, miCliente.getDni(), 0.01);

	}

	@Test
	public void testQueAgregaClienteAunaCuenta() {

		Cliente cliente = new Cliente(22, "juan", "perez");

		Cuenta cuenta = new Cuenta(1, 1000.0, cliente);

		Integer id = 2;
		Double saldo = 2000.0;
		Integer dni = 33;
		String nombre = "roberto";
		String apellido = "garcia";

		Cuenta cuenta2 = new Cuenta(id, saldo, dni, nombre, apellido);
		assertEquals(22, cuenta.getCliente().getDni(), 0.0);
	}

	@Test
	public void testQueVerificaQueUnaRealizaUnaExtracion() {
		Cliente cliente = new Cliente(22, "juan", "perez");

		Cuenta cuenta = new Cuenta(1, 1000.0, cliente);

		cuenta.extraer(300.0);
		assertEquals(700.0, cuenta.getSaldo(), 0.0);
	}

	@Test
	public void testQueVerificaQueUnaRealizaUnadeposito() {
		Cliente cliente = new Cliente(22, "juan", "perez");

		Cuenta cuenta = new Cuenta(1, 1000.0, cliente);

		cuenta.depositar(300.0);
		assertEquals(1300.0, cuenta.getSaldo(), 0.0);
	}

	@Test
	public void testQueagregaUnaCuentaAlBanco() {

		Cliente cliente = new Cliente(22, "juan", "perez");

		Cuenta cuenta = new Cuenta(1, 1000.0, cliente);

		Banco banco = new Banco("UnlamBank");

		assertTrue(banco.agregarCuenta(cuenta));

	}

	public void testQueagregaUnaCuentaAlBancoOtraForma() {

		Cliente cliente = new Cliente(22, "juan", "perez");

		Cuenta cuenta = new Cuenta(1, 1000.0, cliente);

		Banco banco = new Banco("UnlamBank");

		banco.agregarCuenta(cuenta);

		assertEquals(1, banco.getCuentas().size());
		assertTrue(banco.getCuentas().contains(cuenta));
	}

	@Test
	public void testQueBuscaUnaCuentaPorId() {

		Cliente cliente = new Cliente(22, "juan", "perez");
		Cuenta cuenta = new Cuenta(1, 1000.0, cliente);
		Cuenta cuenta2 = new Cuenta(2, 6000.0, cliente);
		Banco banco = new Banco("UnlamBank");
		banco.agregarCuenta(cuenta);
		banco.agregarCuenta(cuenta2);

		Cuenta cuentaEncontrada = banco.buscarCuentaPorId(2);
		assertEquals(2, cuentaEncontrada.getId().intValue());
	}

	@Test
	public void testQueVerificaUnaTransferenciaExistosEntre2Cuentas() {
		Cliente cliente2 = new Cliente(22, "luis", "garcia");
		Cliente cliente = new Cliente(11, "juan", "perez");
		Cuenta cuenta = new Cuenta(1, 1000.0, cliente);
		Cuenta cuenta2 = new Cuenta(2, 6000.0, cliente2);
		Banco banco = new Banco("UnlamBank");
		banco.agregarCuenta(cuenta);
		banco.agregarCuenta(cuenta2);

		Integer idCuentaOrigen = 1;
		Integer idCuentaDestino = 2;
		Double monto = 200.0;
		assertTrue(banco.transferir(idCuentaOrigen, idCuentaDestino, monto));

		assertEquals(800.00, cuenta.getSaldo(), 0.01);
		assertEquals(6200.00, cuenta2.getSaldo(), 0.01);

	}

	@Test
	public void testQueBuscaUnaCuentaPorIdIterator() {

		Cliente cliente = new Cliente(22, "juan", "perez");
		Cuenta cuenta = new Cuenta(1, 1000.0, cliente);
		Cuenta cuenta2 = new Cuenta(2, 6000.0, cliente);
		Banco banco = new Banco("UnlamBank");
		banco.agregarCuenta(cuenta);
		banco.agregarCuenta(cuenta2);

		Cuenta cuentaEncontrada = banco.buscarCuentaConIterator(2);
		assertEquals(2, cuentaEncontrada.getId().intValue());
	}

	@Test
	public void testQueEliminaUnaCuenta() {

		Cliente cliente = new Cliente(22, "juan", "perez");
		Cuenta cuenta = new Cuenta(1, 1000.0, cliente);
		Cuenta cuenta2 = new Cuenta(2, 6000.0, cliente);
		Banco banco = new Banco("UnlamBank");
		banco.agregarCuenta(cuenta);
		banco.agregarCuenta(cuenta2);

		assertTrue(banco.eliminarCuentaPorId(2));
		assertEquals(null, banco.buscarCuentaPorId(2));

	}
}