package es.unican.is2;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;

import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

public class VistaAgenteIT extends AssertJSwingJUnitTestCase {

    private FrameFixture window;
    private GestionSeguros negocio;

    @Override
    protected void onSetUp() throws Exception {
        FailOnThreadViolationRepaintManager.install();
        reiniciaBaseDeDatos();
        negocio = new GestionSeguros(new ClientesDAO(), new SegurosDAO());
        VistaAgente vista = GuiActionRunner.execute(() -> new VistaAgente(negocio, negocio, negocio));
        window = new FrameFixture(robot(), vista);
        window.show();
    }

    @Override
    protected void onTearDown() {
        if (window != null) {
            window.cleanUp();
        }
        reiniciaBaseDeDatos();
        BasicRobot.robotWithCurrentAwtHierarchy().cleanUp();
    }

    @Test
    public void consultaClienteMuestraNombreTotalYSegurosDelCliente() {
        consultaCliente("11111111A");

        window.textBox("txtNombreCliente").requireText("Juan");
        window.textBox("txtTotalCliente").requireText("1820.0");
        assertThat(window.list("listSeguros").contents()).containsExactly("1111AAA TERCEROS", "1111BBB TODO_RIESGO", "1111CCC TERCEROS");
    }

    @Test
    public void consultaClienteSinSegurosMuestraListaVaciaYTotalCero() {
        consultaCliente("33333333A");

        window.textBox("txtNombreCliente").requireText("Luis");
        window.textBox("txtTotalCliente").requireText("0.0");
        assertThat(window.list("listSeguros").contents()).isEmpty();
    }

    private void consultaCliente(String dni) {
        GuiActionRunner.execute(() -> window.textBox("txtDNICliente").target().setText(dni));
        GuiActionRunner.execute(() -> window.button("btnBuscar").target().doClick());
        robot().waitForIdle();
    }

    private void reiniciaBaseDeDatos() {
        if (H2ServerConnectionManager.connection != null) {
            try {
                H2ServerConnectionManager.connection.close();
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
            H2ServerConnectionManager.connection = null;
        }
    }
}
