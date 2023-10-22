package time;

import java.util.Comparator;

public class TimeComparator implements Comparator<Time> {
    @Override
    public int compare(Time t1, Time t2) {
        if (t1.getPontos() == t2.getPontos()){
            if (t1.getNumeroVitorias() == t2.getNumeroVitorias()){
                if (t1.getSaldoGols() == t2.getSaldoGols())
                    return 0;
                else if (t1.getSaldoGols() > t2.getSaldoGols())
                    return -1;
                else
                    return 1;
            }
            else if (t1.getNumeroVitorias() > t2.getNumeroVitorias())
                return -1;
            else
                return 1;
        }
        else if (t1.getPontos() > t2.getPontos())
            return -1;
        else
            return 1;
    }
}
