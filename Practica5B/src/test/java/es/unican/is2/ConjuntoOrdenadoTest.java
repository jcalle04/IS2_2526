package es.unican.is2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ConjuntoOrdenadoTest {

    private ConjuntoOrdenado<Integer> conjunto;

    @Before
    public void setUp() {
        conjunto = new ConjuntoOrdenado<>();
    }

    @Test
    public void testAddElementoValidoEnConjuntoVacio() {
        assertTrue(conjunto.add(5));
        assertEquals(1, conjunto.size());
        assertEquals(Integer.valueOf(5), conjunto.get(0));
    }

    @Test
    public void testAddMantieneOrdenNatural() {
        conjunto.add(5);
        conjunto.add(1);
        conjunto.add(3);

        assertEquals(3, conjunto.size());
        assertEquals(Integer.valueOf(1), conjunto.get(0));
        assertEquals(Integer.valueOf(3), conjunto.get(1));
        assertEquals(Integer.valueOf(5), conjunto.get(2));
    }

    @Test
    public void testAddNoInsertaDuplicados() {
        assertTrue(conjunto.add(2));

        assertFalse(conjunto.add(2));
        assertEquals(1, conjunto.size());
        assertEquals(Integer.valueOf(2), conjunto.get(0));
    }

    @Test(expected = NullPointerException.class)
    public void testAddNuloLanzaExcepcion() {
        conjunto.add(null);
    }

    @Test
    public void testGetIndicesValidos() {
        conjunto.add(1);
        conjunto.add(3);
        conjunto.add(2);

        assertEquals(Integer.valueOf(1), conjunto.get(0));
        assertEquals(Integer.valueOf(2), conjunto.get(1));
        assertEquals(Integer.valueOf(3), conjunto.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndiceNegativoLanzaExcepcion() {
        conjunto.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndiceIgualATamanioLanzaExcepcion() {
        conjunto.add(4);
        conjunto.get(conjunto.size());
    }

    @Test
    public void testRemoveIndiceValido() {
        conjunto.add(1);
        conjunto.add(2);
        conjunto.add(3);

        assertEquals(Integer.valueOf(2), conjunto.remove(1));
        assertEquals(2, conjunto.size());
        assertEquals(Integer.valueOf(1), conjunto.get(0));
        assertEquals(Integer.valueOf(3), conjunto.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndiceNegativoLanzaExcepcion() {
        conjunto.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndiceIgualATamanioLanzaExcepcion() {
        conjunto.add(7);
        conjunto.remove(conjunto.size());
    }

    @Test
    public void testSizeEnVacioYNoVacio() {
        assertEquals(0, conjunto.size());

        conjunto.add(1);
        conjunto.add(2);

        assertEquals(2, conjunto.size());
    }

    @Test
    public void testClearEliminaTodosLosElementos() {
        conjunto.add(1);
        conjunto.add(2);

        conjunto.clear();

        assertEquals(0, conjunto.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testClearDejaConjuntoSinElementosAccesibles() {
        conjunto.add(9);
        conjunto.clear();
        conjunto.get(0);
    }
}
