import model.Endereco;
import model.Grupo;
import model.Pessoa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /* PARTE 02 DO EXERCÍCIO.

        Pessoa[] pessoas = new Pessoa[2];

        for (int i = 0; i < pessoas.length; i++) {
            Pessoa pessoa = new Pessoa();

            System.out.println("\n***** CADASTRO DE PESSOA *****");

            System.out.print("Informe o nome dessa pessoa: ");
            String nome = scanner.nextLine();
            pessoa.setNome(nome);

            System.out.print("Informe a idade dessa pessoa: ");
            String idade = scanner.nextLine();
            pessoa.setIdade(Integer.parseInt(idade));

            System.out.print("Informe o CPF dessa pessoa: ");
            String cpf = scanner.nextLine();
            pessoa.setCPF(cpf);

            pessoas[i] = pessoa;
        }

        for (int i = 0; i < pessoas.length; i++) {
            System.out.println("\n***** DADOS DA PESSOA *****");

            System.out.print("Seu nome é " + pessoas[i].getNome() + " tem " + pessoas[i].getIdade()
                            + " anos e seu CPF é " + pessoas[i].getCPF());
        }

        */

        Grupo grupo = new Grupo();

        while (true) {
            System.out.println("***** MENU DE CADASTRO *****");
            System.out.println("\nPressione a tecla de acordo com a opção desejada:");
            System.out.println("[1] - Para cadastrar uma pessoa.");
            System.out.println("[2] - Para excluir uma pessoa.");
            System.out.println("[3] - Para ver as pessoas cadastradas.");
            System.out.println("[4] - Para sair do sistema");

            String resposta = scanner.nextLine();

            switch (resposta){
                case "1":
                    System.out.print("\nInforme o nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("\nInforme a idade: ");
                    int idade = Integer.parseInt(scanner.nextLine());

                    System.out.print("\nInforme o cpf: ");
                    String cpf = scanner.nextLine();

                    Pessoa pessoa = new Pessoa(nome, idade, cpf);

                    System.out.print("\nInforme o estado: ");
                    String estado = scanner.nextLine();

                    System.out.print("\nInforme a cidade: ");
                    String cidade = scanner.nextLine();

                    System.out.print("\nInforme o bairro: ");
                    String bairro = scanner.nextLine();

                    System.out.print("\nInforme a rua: ");
                    String rua = scanner.nextLine();

                    System.out.print("\nInforme o CEP: ");
                    long cep = Long.parseLong(scanner.nextLine());

                    System.out.print("\nInforme o telefone: ");
                    long telefone = Long.parseLong(scanner.nextLine());

                    Endereco endereco = new Endereco(estado, cidade, bairro, rua, cep, telefone);

                    pessoa.setEndereco(endereco);

                    grupo.cadastrarPessoa(pessoa);
                    break;

                case "2":
                    grupo.mostrarGrupo();

                    System.out.print("Qual nome da pessoa que você deseja excluir? ");
                    String nomeExcluir = scanner.nextLine();

                    grupo.excluirPessoa(nomeExcluir);

                    grupo.mostrarGrupo();
                    break;

                case "3":
                    grupo.mostrarGrupo();
                    break;

                default:
                    return;

            }

        }

    }

}
