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
		Cliente existente = clientesDAO.cliente(c.getDni());
		if (existente != null) {
			return null;
		}
		return clientesDAO.creaCliente(c);
	}

	@Override
	public Cliente bajaCliente(String dni) throws OperacionNoValida, DataAccessException {
		Cliente cliente = clientesDAO.cliente(dni);
		if (cliente == null) {
			return null;
		}
		if (!cliente.getSeguros().isEmpty()) {
			throw new OperacionNoValida("Cliente con seguros activos");
		}
		return clientesDAO.eliminaCliente(dni);
	}

	@Override
	public Seguro nuevoSeguro(Seguro s, String dni) throws OperacionNoValida, DataAccessException {
		Cliente cliente = clientesDAO.cliente(dni);
		if (cliente == null) {
			return null;
		}

		Seguro existente = segurosDAO.seguroPorMatricula(s.getMatricula());
		if (existente != null) {
			throw new OperacionNoValida("Seguro ya existente");
		}

		Seguro creado = segurosDAO.creaSeguro(s);
		cliente.getSeguros().add(creado);
		clientesDAO.actualizaCliente(cliente);
		return creado;
	}

	@Override
	public Seguro bajaSeguro(String matricula, String dni) throws OperacionNoValida, DataAccessException {
		Seguro seguro = segurosDAO.seguroPorMatricula(matricula);
		if (seguro == null) {
			return null;
		}

		Cliente cliente = clientesDAO.cliente(dni);
		if (cliente == null) {
			return null;
		}

		boolean pertenece = false;
		for (Seguro s : cliente.getSeguros()) {
			if (s.getId() == seguro.getId()) {
				pertenece = true;
				break;
			}
		}
		if (!pertenece) {
			throw new OperacionNoValida("El seguro no pertenece al cliente");
		}

		Seguro eliminado = segurosDAO.eliminaSeguro(seguro.getId());
		cliente.getSeguros().removeIf(s -> s.getId() == seguro.getId());
		clientesDAO.actualizaCliente(cliente);
		return eliminado;
	}

	@Override
	public Seguro anhadeConductorAdicional(String matricula, String conductor) throws DataAccessException {
		Seguro seguro = segurosDAO.seguroPorMatricula(matricula);
		if (seguro == null) {
			return null;
		}

		seguro.setConductorAdicional(conductor);
		return segurosDAO.actualizaSeguro(seguro);
	}

	@Override
	public Cliente cliente(String dni) throws DataAccessException {
		return clientesDAO.cliente(dni);
	}

	@Override
	public Seguro seguro(String matricula) throws DataAccessException {
		return segurosDAO.seguroPorMatricula(matricula);
	}
}
