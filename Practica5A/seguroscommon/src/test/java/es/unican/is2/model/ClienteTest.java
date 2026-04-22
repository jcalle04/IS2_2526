package es.unican.is2.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

public class ClienteTest {

    @Test
    public void totalSegurosDevuelveCeroSiElClienteNoTieneSeguros() {
        Cliente cliente = new Cliente();

        assertEquals(0.0, cliente.totalSeguros(), 0.01);
    }

    @Test
    public void totalSegurosSumaElPrecioDeTodosLosSegurosActivos() {
        Cliente cliente = new Cliente();
        cliente.setSeguros(List.of(
                creaSeguro(Cobertura.TERCEROS, 80, LocalDate.now().minusYears(2)),
                creaSeguro(Cobertura.TERCEROS_LUNAS, 120, LocalDate.now().minusYears(2))));

        assertEquals(1120.0, cliente.totalSeguros(), 0.01);
    }

    @Test
    public void totalSegurosAplicaDescuentoPorMinusvalia() {
        Cliente cliente = new Cliente();
        cliente.setMinusvalia(true);
        cliente.setSeguros(List.of(
                creaSeguro(Cobertura.TERCEROS, 80, LocalDate.now().minusYears(2)),
                creaSeguro(Cobertura.TODO_RIESGO, 100, LocalDate.now().minusYears(2))));

        assertEquals(1087.5, cliente.totalSeguros(), 0.01);
    }

    private Seguro creaSeguro(Cobertura cobertura, int potencia, LocalDate fechaInicio) {
        Seguro seguro = new Seguro();
        seguro.setCobertura(cobertura);
        seguro.setPotencia(potencia);
        seguro.setFechaInicio(fechaInicio);
        return seguro;
    }
}
