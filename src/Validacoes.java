import java.util.Scanner;

import model.Pessoa;

public class Validacoes {
  private static Scanner scanner = new Scanner(System.in);

  public static boolean validarPalavras(String nome) {
    return nome.matches("^[a-zA-Z\\s]+$");
  }

  public static boolean validarIdade(String idadeStr) {
    return idadeStr.matches("^(?:1[01][0-9]|120|[1-9]?[0-9])$");
  }

  public static boolean validarCPF(String cpf) {
    return cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$");
  }

  public static boolean validarCEP(String cep) {
    return cep.matches("^\\d{5}\\-\\d{3}$") || cep.matches("^\\d{8}$");
  }

  public static boolean validarTelefone(String telefone) {
    return telefone.matches("^(\\d{2})?\\d{4,5}\\-?\\d{4}$");
  }

  public static String coletaNome(Pessoa pessoa) {
    String nome;
    do {
      System.out.print("Informe o nome dessa pessoa: ");
      nome = scanner.nextLine();
      if (!nome.matches(" ") && validarPalavras(nome)) {
        pessoa.setNome(nome);
      } else {
        System.out.println("Informe um nome valido!");
      }
    } while (pessoa.getNome() == "");
    return nome;
  }

  public static int coletaIdade(Pessoa pessoa) {
    String idadeStr;
    int idade = 0;
    do {
      System.out.print("Informe a idade dessa pessoa (0-120): ");
      idadeStr = scanner.nextLine();
      if (!idadeStr.matches(" ") && validarIdade(idadeStr)) {
        idade = Integer.parseInt(idadeStr);
        pessoa.setIdade(idade);
      } else {
        System.out.println("Informe uma idade valida entre 0 e 120 anos.");
      }
    } while (pessoa.getIdade() == 0);
    return idade;
  }

  public static String coletaCPF(Pessoa pessoa) {
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
    return cpf;
  }

  public static void coletaEstado(Pessoa pessoa) {
    do {
      System.out.println("Informe o estado: ");
      String estado = scanner.nextLine();
      if (!estado.matches(" ") && validarPalavras(estado)) {
        pessoa.getEndereco().setEstado(estado);
      } else {
        System.out.println("Estado invalido!");
      }
    } while (pessoa.getEndereco().getEstado() == "");
  }

  public static void coletaCidade(Pessoa pessoa) {
    do {
      System.out.println("Informe a cidade: ");
      String cidade = scanner.nextLine();
      if (!cidade.matches(" ") && validarPalavras(cidade)) {
        pessoa.getEndereco().setCidade(cidade);
      } else {
        System.out.println("Cidade invalida!");
      }
    } while (pessoa.getEndereco().getCidade() == "");
  }

  public static void coletaBairro(Pessoa pessoa) {
    do {
      System.out.println("Informe o bairro: ");
      String bairro = scanner.nextLine();
      if (!bairro.matches(" ") && validarPalavras(bairro)) {
        pessoa.getEndereco().setBairro(bairro);
      } else {
        System.out.println("Bairro invalido!");
      }
    } while (pessoa.getEndereco().getBairro() == "");
  }

  public static void coletaRua(Pessoa pessoa) {
    do {
      System.out.println("Informe a rua: ");
      String rua = scanner.nextLine();
      if (!rua.matches(" ") && validarPalavras(rua)) {
        pessoa.getEndereco().setRua(rua);
      } else {
        System.out.println("Rua invalida!");
      }
    } while (pessoa.getEndereco().getRua() == "");
  }

  public static void coletaCEP(Pessoa pessoa) {
    do {
      System.out.println("Informe o CEP: ");
      String cep = scanner.nextLine();
      if (validarCEP(cep)) {
        pessoa.getEndereco().setCep(cep);
      } else {
        System.out.println("CEP invalido!");
      }
    } while (pessoa.getEndereco().getCep() == "");
  }

  public static void coletaTelefone(Pessoa pessoa) {
    do {
      System.out.println("Informe o telefone: ");
      String telefone = scanner.nextLine();
      if (validarTelefone(telefone)) {
        pessoa.getEndereco().setTelefone(telefone);
      } else {
        System.out.println("Telefone invalido!");
      }
    } while (pessoa.getEndereco().getTelefone() == "");
  }
}
