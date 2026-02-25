package es.unican.is2;

import es.unican.is2.exceptions.DataAccessException;
import es.unican.is2.exceptions.OperacionNoValida;
import es.unican.is2.interfaces.IClientesDAO;
import es.unican.is2.interfaces.IGestionClientes;
import es.unican.is2.interfaces.IGestionSeguros;
import es.unican.is2.interfaces.IInfoSeguros;
import es.unican.is2.interfaces.ISegurosDAO;
import es.unican.is2.model.Cliente;
import es.unican.is2.model.Seguro;

public class GestionSeguros implements IGestionClientes, IGestionSeguros, IInfoSeguros {

	private IClientesDAO clientesDAO;
	private ISegurosDAO segurosDAO;

	public GestionSeguros(IClientesDAO clientesDAO, ISegurosDAO segurosDAO) {
		this.clientesDAO = clientesDAO;
		this.segurosDAO = segurosDAO;
	}

	@Override
	public Cliente nuevoCliente(Cliente c) throws DataAccessException {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public Cliente bajaCliente(String dni) throws OperacionNoValida, DataAccessException {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public Seguro nuevoSeguro(Seguro s, String dni) throws OperacionNoValida, DataAccessException {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public Seguro bajaSeguro(String matricula, String dni) throws OperacionNoValida, DataAccessException {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public Seguro anhadeConductorAdicional(String matricula, String conductor) throws DataAccessException {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public Cliente cliente(String dni) throws DataAccessException {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public Seguro seguro(String matricula) throws DataAccessException {
		throw new UnsupportedOperationException("Not implemented yet");
	}
}
