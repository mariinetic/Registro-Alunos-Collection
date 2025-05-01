package fatec.alunoregistro.controller;

import java.util.*;

import fatec.alunoregistro.model.Aluno;

public class Turma {
    private int capacidade;
    private Map<String, Aluno> alunos;

    public Turma(int capacidade) {
        this.capacidade = capacidade;
        this.alunos = new LinkedHashMap<>();
    }

    public boolean registrarAluno(Aluno aluno) {
        if (alunos.size() >= capacidade || verificarSeMatriculaExiste(aluno.getMatricula())) {
            return false;
        }
        alunos.put(aluno.getMatricula(), aluno);
        return true;
    }

    public boolean atualizarAluno(String matricula, Aluno novoAluno) {
        if (!alunos.containsKey(matricula)) return false;
        alunos.put(matricula, novoAluno);
        return true;
    }

    public Aluno buscarAlunoPorMatricula(String matricula) {
        return alunos.get(matricula);
    }

    public List<Aluno> buscarAlunosPorNome(String nome, boolean retornarTodos) {
        List<Aluno> encontrados = new ArrayList<>();
        for (Aluno a : alunos.values()) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                encontrados.add(a);
                if (!retornarTodos) break;
            }
        }
        return encontrados;
    }

    public boolean removerAlunoPorNome(String nome) {
        String chaveParaRemover = null;
        for (Map.Entry<String, Aluno> entry : alunos.entrySet()) {
            if (entry.getValue().getNome().equalsIgnoreCase(nome)) {
                chaveParaRemover = entry.getKey();
                break;
            }
        }
        if (chaveParaRemover != null) {
            alunos.remove(chaveParaRemover);
            return true;
        }
        return false;
    }

    public void listarAlunosPorOrdemInsercao() {
        alunos.values().forEach(System.out::println);
    }

    public void listarAlunosOrdenadosPorNome() {
        alunos.values().stream()
              .sorted(Comparator.comparing(Aluno::getNome))
              .forEach(System.out::println);
    }

    public boolean verificarSeMatriculaExiste(String matricula) {
        return alunos.containsKey(matricula);
    }
}
