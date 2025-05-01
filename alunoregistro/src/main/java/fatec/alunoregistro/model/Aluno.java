package fatec.alunoregistro.model;

import java.util.Arrays;

public class Aluno {
    private String matricula;
    private String nome;
    private String curso;
    private double[] notas;
    private double[] pesos;

    public Aluno(String matricula, String nome, String curso, double[] notas, double[] pesos) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
        this.notas = notas;
        this.pesos = pesos;
    }

    public String getMatricula() { return matricula; }
    public String getNome() { return nome; }
    public String getCurso() { return curso; }
    public double[] getNotas() { return notas; }
    public double[] getPesos() { return pesos; }

    public void setNome(String nome) { this.nome = nome; }
    public void setCurso(String curso) { this.curso = curso; }
    public void setNotas(double[] notas) { this.notas = notas; }
    public void setPesos(double[] pesos) { this.pesos = pesos; }

    public double calcularMediaPonderada() {
        double somaNotas = 0, somaPesos = 0;
        for (int i = 0; i < notas.length; i++) {
            somaNotas += notas[i] * pesos[i];
            somaPesos += pesos[i];
        }
        return somaPesos == 0 ? 0 : somaNotas / somaPesos;
    }

    @Override
    public String toString() {
        return "\nAluno {" +
                " matrícula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", curso='" + curso + '\'' +
                ", notas=" + Arrays.toString(notas) +
                ", média=" + String.format("%.2f", calcularMediaPonderada()) +
                " }";
    }
}
