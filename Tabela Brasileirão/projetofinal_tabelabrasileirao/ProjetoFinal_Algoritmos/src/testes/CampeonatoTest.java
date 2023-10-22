package testes;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import operacoes.*;
import time.*;


public class CampeonatoTest {

    private Campeonato campeonato;
    private ArrayList<Time> timesLidos;
    @Before
    public void setUp() {
        campeonato = new Campeonato();
        timesLidos = new ArrayList<>();
    }

    @Test
    public void testGravaArquivo() {
        Time time1 = new Time("Time A");
        Time time2 = new Time("Time B");
        campeonato.tabela.add(time1);
        campeonato.tabela.add(time2);

        try {
            campeonato.gravaArquivo();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ArrayList<Time> timesLidos = Campeonato.leArquivo();

            Assert.assertEquals(2, timesLidos.size());
            Assert.assertTrue(timesLidos.contains(time1));
            Assert.assertTrue(timesLidos.contains(time2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLeArquivo() {
        try {
            ArrayList<Time> timesLidos = Campeonato.leArquivo();
            Assert.assertNotNull(timesLidos);
            Assert.assertFalse(timesLidos.isEmpty());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOrdenaTabela() {
        // Arrange
        Time time1 = new Time("Time A", 9, 2, 2, 0, 5, 6, -8, 9,1.00);
        Time time2 = new Time("Time B", 0, 0, 0, 0, 5, 6, -8, 9,1.00);
        Time time3 = new Time("Time C", 3, 1, 1, 0, 5, 6, -8, 9,1.00);
        campeonato.tabela.add(time2);
        campeonato.tabela.add(time1);
        campeonato.tabela.add(time3);

        campeonato.ordenaTabela();

        ArrayList<Time> tabelaOrdenada = campeonato.tabela;
        Assert.assertEquals(time1, tabelaOrdenada.get(0));
        Assert.assertEquals(time2, tabelaOrdenada.get(1));
        Assert.assertEquals(time3, tabelaOrdenada.get(2));
    }
}
