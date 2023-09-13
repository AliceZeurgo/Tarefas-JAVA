import java.util.ArrayList;
import java.util.Scanner;

public class gerenciamento {
    public static void main(String[] args) {
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Olá! Esse é meu programa para te ajudar com suas tarefas!");
            System.out.println("Escolha uma dessas opções:");
            System.out.println("\n ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒Sistema de Gerenciamento de Tarefas▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
            System.out.println(" ➯ 1. Adicionar uma Tarefa");
            System.out.println(" ➯ 2. Listar todas tarefas Pendentes");
            System.out.println(" ➯ 3. Listar todas tarefas Concluídas");
            System.out.println(" ➯ 4. Marcar Tarefa como Concluída");
            System.out.println(" ➯ 5. Sair do programa");


            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Qual o título da tarefa que deseja adicionar? ✍ ");
                    String titulo = scanner.nextLine();
                    Tarefa novaTarefa = new Tarefa(titulo);
                    tarefas.add(novaTarefa);
                    System.out.println(" ✮✭✮ Tarefa adicionada com sucesso! ✭✮✭");
                    break;
                case 2:
                    System.out.println("\n ☹ Tarefas pendentes ☹");
                    listarTarefas(tarefas, false);
                    break;
                case 3:
                    System.out.println("\n ☺ Tarefas concluídas ☺");
                    listarTarefas(tarefas, true);
                    break;
                case 4:
                    System.out.print("Digite o número da tarefa que deseja marcar como concluída: ");
                    int indice = scanner.nextInt();
                    scanner.nextLine();
                    if (indice >= 0 && indice < tarefas.size()) {
                        tarefas.get(indice).marcarConcluida();
                        System.out.println(" ✭✮✭ Tarefa marcada como concluída! ✭✮✭ ");
                    } else {
                        System.out.println("\n ☹ Essa tarefa não foi encontrada. ☹ ");
                    }
                    break;
                case 5:
                    System.out.println("꧁Você saiu! Volte sempre.꧂");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Escolha uma opção válida por gentileza!");
            }
        }
    }

    public static void listarTarefas(ArrayList<Tarefa> tarefas, boolean exibirConcluidas) {
        for (int i = 0; i < tarefas.size(); i++) {
            if (tarefas.get(i).isConcluida() == exibirConcluidas) {
                System.out.println((i + 1) + ". " + tarefas.get(i).toString());
            }
        }
        if (tarefas.isEmpty()) {
            System.out.println("Não encontramos nenhuma tarefa.");
        }
    }
}

