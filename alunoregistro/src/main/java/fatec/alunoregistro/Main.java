package fatec.alunoregistro;

import java.util.Locale;
import java.util.Scanner;

import fatec.alunoregistro.controller.Turma;
import fatec.alunoregistro.model.Aluno;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        Turma turma = new Turma(5);

        Aluno a1 = new Aluno("001", "Mari", "Computação", new double[]{8.0, 8.5, 9.0, 9.5}, new double[]{2, 2, 3, 3});
        Aluno a2 = new Aluno("002", "Thiago", "Engenharia", new double[]{7.0, 8.0, 6.0, 9.0}, new double[]{2, 2, 3, 3});
        Aluno a3 = new Aluno("003", "Luiz", "Administração", new double[]{9.0, 8.5, 8.0, 7.5}, new double[]{2, 2, 3, 3});
        turma.registrarAluno(a1);
        turma.registrarAluno(a2);
        turma.registrarAluno(a3);

        while (true) {
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║              MENU PRINCIPAL           ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.println("1 - Registrar novo aluno");
            System.out.println("2 - Listar alunos por ordem de inserção");
            System.out.println("3 - Listar alunos ordenados por nome");
            System.out.println("4 - Consultar aluno por matrícula");
            System.out.println("5 - Remover aluno por nome");
            System.out.println("6 - Sair");
            System.out.print("\nEscolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Registrar novo aluno ---");
                    System.out.print("Matrícula: ");
                    String matricula = scanner.nextLine();

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Curso: ");
                    String curso = scanner.nextLine();

                    double[] notas = new double[4];
                    double[] pesos = new double[4];
                    for (int i = 0; i < 4; i++) {
                        System.out.print("Nota " + (i + 1) + ": ");
                        notas[i] = scanner.nextDouble();
                        System.out.print("Peso " + (i + 1) + ": ");
                        pesos[i] = scanner.nextDouble();
                    }
                    scanner.nextLine();

                    Aluno novoAluno = new Aluno(matricula, nome, curso, notas, pesos);
                    if (turma.registrarAluno(novoAluno)) {
                        System.out.println("✅ Aluno registrado com sucesso!");
                    } else {
                        System.out.println("⚠️ Não foi possível registrar o aluno. Matrícula já existente ou turma cheia.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Lista de alunos na ordem de inserção ---");
                    turma.listarAlunosPorOrdemInsercao();
                    break;

                case 3:
                    System.out.println("\n--- Lista de alunos ordenados por nome ---");
                    turma.listarAlunosOrdenadosPorNome();
                    break;

                case 4:
                    System.out.print("\nDigite a matrícula do aluno: ");
                    String matriculaConsulta = scanner.nextLine();
                    Aluno alunoConsultado = turma.buscarAlunoPorMatricula(matriculaConsulta);
                    if (alunoConsultado != null) {
                        System.out.println("Aluno encontrado: " + alunoConsultado);
                    } else {
                        System.out.println("⚠️ Aluno não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("\nDigite o nome do aluno a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    if (turma.removerAlunoPorNome(nomeRemover)) {
                        System.out.println("✅ Aluno removido com sucesso!");
                    } else {
                        System.out.println("⚠️ Não foi possível remover o aluno. Aluno não encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("Saindo... Até logo!");
                    scanner.close();
                    return;

                default:
                    System.out.println("⚠️ Opção inválida! Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }
}
