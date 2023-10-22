package operacoes;
import time.Time;
import time.TimeComparator;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Campeonato {
    public static ArrayList<Time> tabela;

    public Campeonato() {
        tabela = new ArrayList<>();
    }

    public static void gravaArquivo() throws IOException {
        FileWriter arq = new FileWriter("Times.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        ordenaTabela();
        Iterator aux1 = tabela.iterator();


        while(aux1.hasNext()) {
            Time time = (Time)aux1.next();
            gravarArq.println(time.toStringFile());
        }
        arq.close();
    }
    public static ArrayList<Time> leArquivo() throws IOException {
        File objFile = new File("Times.txt");
        FileInputStream is;
        InputStreamReader isr;
        BufferedReader br;
        String[] s;
        String l = "";
        if (objFile.exists()) {
            is = new FileInputStream("Times.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            while (l != null) {
                l = br.readLine();
                if (l == null) break;
                s = l.split(";");
                tabela.add(new Time(s[0], Integer.valueOf(s[1]), Integer.valueOf(s[2]),
                        Integer.valueOf(s[3]), Integer.valueOf(s[4]), Integer.valueOf(s[5]),
                        Integer.valueOf(s[6]), Integer.valueOf(s[7]), Integer.valueOf(s[8]),
                        Double.valueOf(s[9])));
                System.out.println(l);
            }
            br.close();
        }
        return tabela;
    }
    public static void ordenaTabela(){
        tabela.sort(new TimeComparator());
    }
}
