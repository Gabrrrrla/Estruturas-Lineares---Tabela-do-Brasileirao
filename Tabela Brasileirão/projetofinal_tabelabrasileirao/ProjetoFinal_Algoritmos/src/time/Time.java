package time;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Time {
    private String nome;
    private int pontos;
    private int numeroJogos;
    private int numeroVitorias;
    private int numeroDerrotas;
    private int numeroEmpates;
    private int saldoGols;
    private int golsPro;
    private int golsContra;
    private double percentualRendimento;

    public Time(){};
    public Time(String nome, int pontos, int numeroJogos, int numeroVitorias, int numeroDerrotas, int numeroEmpates, int saldoGols, int golsPro, int golsContra, double percentualRendimento) {
        this.nome = nome;
        this.pontos = pontos;
        this.numeroJogos = numeroJogos;
        this.numeroVitorias = numeroVitorias;
        this.numeroDerrotas = numeroDerrotas;
        this.numeroEmpates = numeroEmpates;
        this.saldoGols = saldoGols;
        this.golsPro = golsPro;
        this.golsContra = golsContra;
        this.percentualRendimento = percentualRendimento;
    }

    public Time(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.numeroJogos = 0;
        this.numeroVitorias = 0;
        this.numeroDerrotas = 0;
        this.numeroEmpates = 0;
        this.saldoGols = 0;
        this.golsPro = 0;
        this.golsContra = 0;
        this.percentualRendimento = 0.00;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getNumeroJogos() {
        return numeroJogos;
    }

    public void setNumeroJogos(int numeroJogos) {
        this.numeroJogos = numeroJogos;
    }

    public int getNumeroVitorias() {
        return numeroVitorias;
    }

    public void setNumeroVitorias(int numeroVitorias) {
        this.numeroVitorias = numeroVitorias;
    }

    public int getNumeroDerrotas() {
        return numeroDerrotas;
    }

    public void setNumeroDerrotas(int numeroDerrotas) {
        this.numeroDerrotas = numeroDerrotas;
    }

    public int getNumeroEmpates() {
        return numeroEmpates;
    }

    public void setNumeroEmpates(int numeroEmpates) {
        this.numeroEmpates = numeroEmpates;
    }

    public int getSaldoGols() {
        return saldoGols;
    }

    public void setSaldoGols(int saldoGols) {
        this.saldoGols = saldoGols;
    }

    public int getGolsPro() {
        return golsPro;
    }

    public void setGolsPro(int golsPro) {
        this.golsPro = golsPro;
    }

    public int getGolsContra() {
        return golsContra;
    }

    public void setGolsContra(int golsContra) {
        this.golsContra = golsContra;
    }

    //rever isso, porque não seta o rendimento em nenhum lugar
    public double getPercentualRendimento() {
        return percentualRendimento;
    }

    public void registrarVitoria(int golsPro, int golsContra){
        this.pontos += 3;
        this.numeroJogos++;
        this.numeroVitorias++;
        this.golsPro += golsPro;
        this.golsContra += golsContra;
        this.saldoGols = this.golsPro - this.golsContra;
        this.percentualRendimento = numeroJogos == 0 ? 0 : (pontos/(numeroJogos*3)*100);
    }

    public void registrarEmpate(int golsPro, int golsContra) {
        this.pontos += 1;
        this.numeroJogos++;
        this.numeroEmpates++;
        this.golsPro += golsPro;
        this.golsContra += golsContra;
        this.saldoGols = this.golsPro - this.golsContra;
        this.percentualRendimento = numeroJogos == 0 ? 0 : (pontos/(numeroJogos*3)*100);

    }

    public void registrarDerrota(int golsPro, int golsContra) {
        this.numeroJogos++;
        this.numeroDerrotas++;
        this.golsPro += golsPro;
        this.golsContra += golsContra;
        this.saldoGols = this.golsPro - this.golsContra;
        this.percentualRendimento = numeroJogos == 0 ? 0 : (pontos/(numeroJogos*3)*100);
    }

    public String toStringFile(){
        return nome + ";" + pontos + ";"
                + numeroJogos + ";" + numeroVitorias + ";"
                + numeroDerrotas + ";" + numeroEmpates + ";"
                + saldoGols + ";" + golsPro + ";" + golsContra + ";"
                + percentualRendimento;
    }
    @Override
    public String toString() {
        return "Time{" +
                "nome='" + nome + '\'' +
                ", pontos=" + pontos +
                ", numeroJogos=" + numeroJogos +
                ", numeroVitorias=" + numeroVitorias +
                ", numeroDerrotas=" + numeroDerrotas +
                ", numeroEmpates=" + numeroEmpates +
                ", saldoGols=" + saldoGols +
                ", golsPro=" + golsPro +
                ", golsContra=" + golsContra +
                ", percentualRendimento=" + percentualRendimento +
                '}';
    }


}
