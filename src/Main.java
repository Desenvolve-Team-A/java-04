import model.Endereco;
import model.Grupo;
import model.Pessoa;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Grupo grupo = new Grupo();
    grupo.grupo
    Pessoa[] pessoas = new Pessoa[2];

    for (int i = 0; i < pessoas.length; i++) {
      Pessoa pessoa = Pessoa.criarPessoaVazio();

      System.out.println("\n***** CADASTRO DE PESSOA " + (i + 1) + " *****");

      String nome;
      do {
        System.out.print("Informe o nome dessa pessoa: ");
        nome = scanner.nextLine();
        if (!nome.matches(" ") && Validacoes.validarPalavras(nome)) {
          pessoa.setNome(nome);
        } else {
          System.out.println("Informe um nome válido!");
        }
      } while (pessoa.getNome() == "");

      String idadeStr;
      int idade;
      do {
        System.out.print("Informe a idade dessa pessoa (0-120): ");
        idadeStr = scanner.nextLine();
        if (!idadeStr.matches(" ") && Validacoes.validarIdade(idadeStr)) {
          idade = Integer.parseInt(idadeStr);
          pessoa.setIdade(idade);
        } else {
          System.out.println("Informe uma idade valida entre 0 e 120 anos.");
        }
      } while (pessoa.getIdade() == 0);

      String cpf;
      do {
        System.out.print("Informe o CPF dessa pessoa, no formato 000.000.000-00: ");
        cpf = scanner.nextLine();
        if (Validacoes.validarCPF(cpf)) {
          pessoa.setCPF(cpf);
        } else {
          System.out.println("Digite o CPF corretamente!");
        }
      } while (pessoa.getCPF() == "");

      pessoas[i] = pessoa;
    }

    for (int i = 0; i < pessoas.length; i++) {
      System.out.println("\n***** DADOS DA PESSOA *****");

      System.out.println("\nSeu nome é " + pessoas[i].getNome() + " tem " + pessoas[i].getIdade()
          + " anos e seu CPF é " + pessoas[i].getCPF());
    }

    Grupo grupo = new Grupo();

    boolean verificacao = true;

    while (verificacao) {
      System.out.println("***** MENU DE CADASTRO *****");
      System.out.println("\nPressione a tecla de acordo com a opção desejada:");
      System.out.println("[1] - Para cadastrar uma pessoa.");
      System.out.println("[2] - Para excluir uma pessoa.");
      System.out.println("[3] - Para ver as pessoas cadastradas.");
      System.out.println("[4] - Para sair do sistema");
      System.out.print("Opção escolhida: ");

      while (!scanner.hasNextInt()) {
        System.out.println("Opção inválida!");
        scanner.nextInt();
      }

      int resposta = scanner.nextInt();

      if (resposta > 0 && resposta < 5) {
        verificacao = false;
      }

      switch (resposta) {
        case 1:
          System.out.println("\nInforme o nome: ");
          String nome = scanner.nextLine();
          if (nome.matches(" ") || !Validacoes.validarPalavras(nome)) {
            System.out.println("Nome inválido!");
            break;
          }

          System.out.println("Informe a idade: ");
          String idadeStr = scanner.nextLine();
          if (idadeStr.matches(" ") || !Validacoes.validarIdade(idadeStr)) {
            System.out.println("Idade inválida!");
            return;
          }
          int idade = Integer.parseInt(idadeStr);

          System.out.println("Informe o cpf: ");
          String cpf = scanner.nextLine();
          if (!Validacoes.validarCPF(cpf)) {
            System.out.println("CPF inválido!");
            return;
          }

          Pessoa pessoa = new Pessoa(nome, idade, cpf);

          System.out.println("Informe o estado: ");
          String estado = scanner.nextLine();
          if (estado.matches(" ") || !Validacoes.validarPalavras(estado)) {
            System.out.println("Estado inválido!");
            return;
          }

          System.out.println("Informe a cidade: ");
          String cidade = scanner.nextLine();
          if (cidade.matches(" ") || !Validacoes.validarPalavras(cidade)) {
            System.out.println("Cidade inválida!");
            return;
          }

          System.out.println("Informe o bairro: ");
          String bairro = scanner.nextLine();
          if (bairro.matches(" ") || !Validacoes.validarPalavras(bairro)) {
            System.out.println("Bairro inválido!");
            return;
          }

          System.out.println("Informe a rua: ");
          String rua = scanner.nextLine();
          if (rua.matches(" ") || !Validacoes.validarPalavras(rua)) {
            System.out.println("Rua inválida!");
            return;
          }

          System.out.println("Informe o CEP: ");
          String cep = scanner.nextLine();
          if (!Validacoes.validarCEP(cep)) {
            System.out.println("CEP inválido!");
            return;
          }

          System.out.println("Informe o telefone: ");
          String telefone = scanner.nextLine();
          if (!Validacoes.validarTelefone(telefone)) {
            System.out.println("Telefone inválido!");
            return;
          }

          Endereco endereco = new Endereco(estado, cidade, bairro, rua, cep, telefone);

          pessoa.setEndereco(endereco);

          grupo.cadastrarPessoa(pessoa);
          break;

        case 2:
          grupo.mostrarGrupo();

          System.out.print("Qual nome da pessoa que você deseja excluir? ");
          String nomeExcluir = scanner.nextLine();

          grupo.excluirPessoa(nomeExcluir);

          grupo.mostrarGrupo();
          break;

        case 3:
          grupo.mostrarGrupo();
          break;

        case 4:
          System.out.println("|| Você saiu do programa! ||");
          System.exit(0);
      }

    }

  }

}
