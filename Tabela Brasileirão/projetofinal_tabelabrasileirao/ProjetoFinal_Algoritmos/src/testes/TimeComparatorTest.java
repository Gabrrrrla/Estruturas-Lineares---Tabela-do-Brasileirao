package testes;

import time.Time;
import org.junit.Assert;
import org.junit.Test;
import time.TimeComparator;

public class TimeComparatorTest {

    @Test
    public void testCompare_SamePointsAndVictories_SameGoalDifference() {
        // Arrange
        Time time1 = new Time("Time A");
        time1.setPontos(10);
        time1.setNumeroVitorias(5);
        time1.setSaldoGols(0);

        Time time2 = new Time("Time B");
        time2.setPontos(10);
        time2.setNumeroVitorias(5);
        time2.setSaldoGols(0);

        TimeComparator comparator = new TimeComparator();

        int result = comparator.compare(time1, time2);

        Assert.assertEquals(0, result);
    }

    @Test
    public void testCompare_SamePointsAndVictories_DifferentGoalDifference() {
        // Arrange
        Time time1 = new Time("Time A");
        time1.setPontos(10);
        time1.setNumeroVitorias(5);
        time1.setSaldoGols(2);

        Time time2 = new Time("Time B");
        time2.setPontos(10);
        time2.setNumeroVitorias(5);
        time2.setSaldoGols(5);

        TimeComparator comparator = new TimeComparator();

        int result = comparator.compare(time1, time2);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testCompare_SamePoints_DifferentVictories() {
        Time time1 = new Time("Time A");
        time1.setPontos(10);
        time1.setNumeroVitorias(3);
        time1.setSaldoGols(10);

        Time time2 = new Time("Time B");
        time2.setPontos(10);
        time2.setNumeroVitorias(5);
        time2.setSaldoGols(5);

        TimeComparator comparator = new TimeComparator();

        int result = comparator.compare(time1, time2);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testCompare_DifferentPoints() {
        Time time1 = new Time("Time A");
        time1.setPontos(15);
        time1.setNumeroVitorias(7);
        time1.setSaldoGols(10);

        Time time2 = new Time("Time B");
        time2.setPontos(10);
        time2.setNumeroVitorias(5);
        time2.setSaldoGols(5);

        TimeComparator comparator = new TimeComparator();

        int result = comparator.compare(time1, time2);

        Assert.assertEquals(-1, result);
    }
}
