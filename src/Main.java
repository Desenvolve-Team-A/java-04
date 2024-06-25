import model.Grupo;
import model.Pessoa;

import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Instanciando Singleton
    Grupo grupo = Grupo.getInstance();
    List<Pessoa> listaDePessoas = grupo.getListaDePessoas();

    for (int i = 0; i < 2; i++) {
      System.out.println("\n***** CADASTRO DE PESSOA " + (i + 1) + " *****");

      Pessoa pessoa = Pessoa.criarPessoaVazio();

      Validacoes.coletaNome(pessoa);
      Validacoes.coletaIdade(pessoa);
      Validacoes.coletaCPF(pessoa);

      grupo.cadastrarPessoa(pessoa);
    }

    for (int i = 0; i < listaDePessoas.size(); i++) {
      System.out.println("\n***** DADOS DA PESSOA *****");

      System.out.println("\nSeu nome e " + listaDePessoas.get(i).getNome() + " tem " + listaDePessoas.get(i).getIdade()
          + " anos e seu CPF e " + listaDePessoas.get(i).getCPF());
    }

    boolean manterPrograma = true;

    while (manterPrograma) {
      System.out.println("\n***** MENU DE CADASTRO *****");
      System.out.println("\nPressione a tecla de acordo com a opcao desejada:");
      System.out.println("[1] - Para cadastrar uma pessoa.");
      System.out.println("[2] - Para excluir uma pessoa.");
      System.out.println("[3] - Para ver as pessoas cadastradas.");
      System.out.println("[4] - Para sair do sistema");
      System.out.print("Opcao escolhida: ");

      while (!scanner.hasNextInt()) {
        System.out.println("Opcao invalida!");
        System.out.print("Escolha novamente: ");
        scanner.next();
      }

      int resposta = scanner.nextInt();

      if (resposta > 0 && resposta < 5) {
        switch (resposta) {
          case 1:
            Pessoa pessoa = Pessoa.criarPessoaVazio();

            Validacoes.coletaNome(pessoa);
            Validacoes.coletaIdade(pessoa);
            Validacoes.coletaCPF(pessoa);
            Validacoes.coletaEstado(pessoa);
            Validacoes.coletaCidade(pessoa);
            Validacoes.coletaBairro(pessoa);
            Validacoes.coletaRua(pessoa);
            Validacoes.coletaCEP(pessoa);
            Validacoes.coletaTelefone(pessoa);

            grupo.cadastrarPessoa(pessoa);
            break;

          case 2:
            Scanner scanner2 = new Scanner(System.in);
            System.out.print("\nQual nome da pessoa que voce deseja excluir? ");
            String nomeExcluir = scanner2.nextLine();

            grupo.excluirPessoa(nomeExcluir);
            break;

          case 3:
            grupo.mostrarGrupo();
            break;

          case 4:
            manterPrograma = false;
            scanner.close();
            System.out.println("\n|| Voce saiu do programa! ||");
        }
      } else {
        System.out.println("Opcao invalida!");
      }

    }
  }
}
