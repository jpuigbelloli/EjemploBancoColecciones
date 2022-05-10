package ejercicio.lista.banco;

public class Cuenta {

	private Integer id;
	private Double saldo;
	private Cliente cliente;

	public Cuenta(Integer id, Double saldo, Cliente cliente) {
		this.id = id;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	public Cuenta(Integer id, Double saldo, Integer dni, String nombre, String apellido) {
		this.id = id;
		this.saldo = saldo;
		this.cliente = new Cliente(dni, nombre, apellido);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void extraer(Double monto) {

		if (this.saldo >= monto && monto > 0.0)
			this.saldo -= monto;

	}

	public void depositar(Double monto) {

		this.saldo += monto;

		// TODO Auto-generated method stub

	}

}
