package operacoes;

import java.util.ArrayList;
import java.util.Scanner;
import time.Time;

import static operacoes.Campeonato.ordenaTabela;
import static operacoes.Campeonato.tabela;


public class Menu {
    private Scanner teclado;
    private Time time;
    private int opcao;

    private Campeonato campeonato;
    private ArrayList<Time> listaTimes;

    public Menu() {
        campeonato = new Campeonato();
        teclado = new Scanner(System.in);
    }

    public void menu() {
        try {
            listaTimes = Campeonato.leArquivo();
            while (opcao != 4) {
                imprimirOpcoes();
                leOpcao();
            }
            Campeonato.gravaArquivo();
        }
        catch(Exception exception){
            System.out.println("Erro encontrado: " + exception.getMessage());
        }
    }

    private void imprimirOpcoes() {
        System.out.println("===  ⚽ Tabela do Brasileirão  ⚽  ===\n" +
                "[1] Inserir time\n" +
                "[2] Registrar partida\n" +
                "[3] Mostrar tabela de classificação\n" +
                "[4] Sair\n");
    }

    private void leOpcao() {
        System.out.println("Digite a opção que deseja: ");
        opcao = teclado.nextInt();
        switch(opcao) {
            case 1:
                inserirTime();
                break;
            case 2:
                registrarPartida();
                break;
            case 3:
                mostrarTabelaClassificacao();
                break;
            case 4:
                break;
            default:
                System.out.println("Essa opção é inválida!");
        }
    }
    public void inserirTime() {
        String nome, sair;
        while (true) {
            Time timeInserido = new Time();
            System.out.println("Digite o nome do time que quer registrar: ");
            nome = teclado.next();
            boolean timeExiste = false;
            for (Time time : listaTimes) {
                if (time.getNome().equalsIgnoreCase(nome)) {
                    timeExiste = true;
                    break;
                }
            }
            while (timeExiste) {
                System.out.println("O time já existe. Digite outro: ");
                nome = teclado.next();
                timeInserido.setNome(nome);
                timeExiste = false;
                for (Time time : listaTimes) {
                    if (time.getNome().equals(nome)) {
                        timeExiste = true;
                        break;
                    }
                }
            }
            timeInserido.setNome(nome);
            listaTimes.add(timeInserido);
            tabela = new ArrayList<>(listaTimes);

            System.out.println("Você deseja adicionar mais algum time? S/N");
            sair = teclado.next();
            if (sair.equalsIgnoreCase("N"))
                break;
        }
    }

    public void registrarPartida(){
        int numero1, numero2, gol1, gol2;

        System.out.println("=== Times ===");
        for(int i = 0; i < listaTimes.size(); i++){
            System.out.println("[" + (i+1) + "] " + listaTimes.get(i).getNome());
        }
        if(listaTimes.isEmpty() || listaTimes.size()<1){
            System.out.println("Não é possível registrar uma partida por falta de times.");
            imprimirOpcoes();
            leOpcao();
        }

        System.out.println("Digite o número do time 1: ");
        numero1 = teclado.nextInt();
        while(((numero1 >= listaTimes.size()+1)||(numero1 <= 0))){
            System.out.println("O time desejado não está cadastrado. Você será redirecionado para o menu.");
            imprimirOpcoes();
            leOpcao();
            break;
        }

        System.out.println("Digite o nome do time 2: ");
        numero2 = teclado.nextInt();
        while(numero2 == numero1){
            System.out.println("Você não pode criar uma partida com os mesmos times.");
            imprimirOpcoes();
            leOpcao();
            break;
        }
        while(((numero2 >= listaTimes.size()+1)||(numero2 <= 0))){
            System.out.println("O time desejado não está cadastrado. Você será redirecionado para o menu.");
            imprimirOpcoes();
            leOpcao();
            break;
        }

        System.out.println("Digite a quantidade de gols do time 1: ");
        gol1 = teclado.nextInt();
        while(gol1 < 0){
            System.out.println("Valor inválido. Digite novamente: ");
            gol1 = teclado.nextInt();
        }

        System.out.println("Digite a quantidade de gols do time 2: ");
        gol2 = teclado.nextInt();
        while(gol2 < 0){
            System.out.println("Valor inválido. Digite novamente: ");
            gol2 = teclado.nextInt();
        }
        Operacoes.verificaResultadoPartida(gol1, gol2, listaTimes.get(numero1-1), listaTimes.get(numero2-1));
    }
    public void mostrarTabelaClassificacao(){
        ordenaTabela();
        System.out.println("==============================================  ⚽ Tabela do Brasileirão  ⚽  ================================================");
        System.out.println("  Time       | Pontos  |   Jogos   | Vitórias | Empates | Derrotas | Saldo  | Gols Pró | Gols Contra | Aproveitamento |");

        for (Time time : tabela) {
            System.out.printf("| %-10s | %-7d | %-8d | %-8d | %-8d | %-8d | %-10d | %-10d | %-10d | %7.2f%% |\n",
                    time.getNome(), time.getPontos(), time.getNumeroJogos(), time.getNumeroVitorias(),
                    time.getNumeroEmpates(), time.getNumeroDerrotas(), time.getSaldoGols(), time.getGolsPro(),
                    time.getGolsContra(), time.getPercentualRendimento());
        }

        System.out.println("===============================================================================================================================");
    }
}
