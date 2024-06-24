import model.Endereco;
import model.Grupo;
import model.Pessoa;

import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Instanciando Singleton
    Grupo grupo = Grupo.getInstance();
    List<Pessoa> listaDePessoas = grupo.getGrupo();

    for (int i = 0; i < 2; i++) {
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

      grupo.cadastrarPessoa(pessoa);
    }

    for (int i = 0; i < listaDePessoas.size(); i++) {
      System.out.println("\n***** DADOS DA PESSOA *****");

      System.out.println("\nSeu nome é " + listaDePessoas.get(i).getNome() + " tem " + listaDePessoas.get(i).getIdade()
          + " anos e seu CPF é " + listaDePessoas.get(i).getCPF());
    }

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
      Scanner novoScanner = new Scanner(System.in);
      switch (resposta) {
        case 1:
          System.out.println("\nInforme o nome: ");
          String nome = novoScanner.nextLine();
          if (nome.matches(" ") || !Validacoes.validarPalavras(nome)) {
            System.out.println("Nome inválido!");
            break;
          }

          System.out.println("Informe a idade: ");
          String idadeStr = novoScanner.nextLine();
          if (idadeStr.matches(" ") || !Validacoes.validarIdade(idadeStr)) {
            System.out.println("Idade inválida!");
            return;
          }
          int idade = Integer.parseInt(idadeStr);

          System.out.println("Informe o cpf: ");
          String cpf = novoScanner.nextLine();
          if (!Validacoes.validarCPF(cpf)) {
            System.out.println("CPF inválido!");
            return;
          }

          Pessoa pessoa = Pessoa.criarPessoaSemEnd(nome, idade, cpf);

          System.out.println("Informe o estado: ");
          String estado = novoScanner.nextLine();
          if (estado.matches(" ") || !Validacoes.validarPalavras(estado)) {
            System.out.println("Estado inválido!");
            return;
          }

          System.out.println("Informe a cidade: ");
          String cidade = novoScanner.nextLine();
          if (cidade.matches(" ") || !Validacoes.validarPalavras(cidade)) {
            System.out.println("Cidade inválida!");
            return;
          }

          System.out.println("Informe o bairro: ");
          String bairro = novoScanner.nextLine();
          if (bairro.matches(" ") || !Validacoes.validarPalavras(bairro)) {
            System.out.println("Bairro inválido!");
            return;
          }

          System.out.println("Informe a rua: ");
          String rua = novoScanner.nextLine();
          if (rua.matches(" ") || !Validacoes.validarPalavras(rua)) {
            System.out.println("Rua inválida!");
            return;
          }

          System.out.println("Informe o CEP: ");
          String cep = novoScanner.nextLine();
          if (!Validacoes.validarCEP(cep)) {
            System.out.println("CEP inválido!");
            return;
          }

          System.out.println("Informe o telefone: ");
          String telefone = novoScanner.nextLine();
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
          novoScanner.close();
          scanner.close();
          System.out.println("|| Você saiu do programa! ||");
          System.exit(0);
      }

    }

  }

}
