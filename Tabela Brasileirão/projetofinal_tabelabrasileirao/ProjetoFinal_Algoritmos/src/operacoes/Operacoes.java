package operacoes;

import time.Time;

public class Operacoes {
    public static void verificaResultadoPartida(int gol1, int gol2, Time time1, Time time2){
        if(gol1 > gol2){
            time1.registrarVitoria(gol1, gol2);
            time2.registrarDerrota(gol2, gol1);
            System.out.println("Time " + time1.getNome() + " venceu do time " + time2.getNome());
        }
        else if(gol2 > gol1) {
            time1.registrarDerrota(gol2, gol1);
            time2.registrarVitoria(gol1, gol2);
            System.out.println("Time " + time2.getNome() + " venceu do time " + time1.getNome());
        }
        else if (gol1 == gol2){
            time1.registrarEmpate(gol1, gol2);
            time2.registrarEmpate(gol1, gol2);
            System.out.println("Houve um empate entre o times " + time1.getNome() + " e " + time2.getNome());
        }
    }

}
