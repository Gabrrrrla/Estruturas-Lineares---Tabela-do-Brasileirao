package testes;
import time.Time;

import operacoes.Operacoes;
import org.junit.Assert;
import org.junit.Test;


public class OperacoesTest {
    @Test
    public void testVerificaResultadoPartida_Time1Vence() {
        int gol1 = 2;
        int gol2 = 1;
        Time time1 = new Time("Time A");
        Time time2 = new Time("Time B");

        Operacoes.verificaResultadoPartida(gol1, gol2, time1, time2);

        Assert.assertEquals(1, time1.getNumeroVitorias());
        Assert.assertEquals(0, time1.getNumeroDerrotas());
        Assert.assertEquals(0, time1.getNumeroEmpates());

        Assert.assertEquals(0, time2.getNumeroVitorias());
        Assert.assertEquals(1, time2.getNumeroDerrotas());
        Assert.assertEquals(0, time2.getNumeroEmpates());
    }

    @Test
    public void testVerificaResultadoPartida_Time2Vence() {
        int gol1 = 0;
        int gol2 = 3;
        Time time1 = new Time("Time A");
        Time time2 = new Time("Time B");
        Operacoes.verificaResultadoPartida(gol1, gol2, time1, time2);

        Assert.assertEquals(0, time1.getNumeroVitorias());
        Assert.assertEquals(1, time1.getNumeroDerrotas());
        Assert.assertEquals(0, time1.getNumeroEmpates());

        Assert.assertEquals(1, time2.getNumeroVitorias());
        Assert.assertEquals(0, time2.getNumeroDerrotas());
        Assert.assertEquals(0, time2.getNumeroEmpates());
    }
    @Test
    public void testVerificaResultadoPartida_Empate() {
        // Arrange
        int gol1 = 2;
        int gol2 = 2;
        Time time1 = new Time("Time A");
        Time time2 = new Time("Time B");

        // Act
        Operacoes.verificaResultadoPartida(gol1, gol2, time1, time2);

        // Assert
        Assert.assertEquals(0, time1.getNumeroVitorias());
        Assert.assertEquals(0, time1.getNumeroDerrotas());
        Assert.assertEquals(1, time1.getNumeroEmpates());

        Assert.assertEquals(0, time2.getNumeroVitorias());
        Assert.assertEquals(0, time2.getNumeroDerrotas());
        Assert.assertEquals(1, time2.getNumeroEmpates());
    }
}
