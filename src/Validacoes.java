public class Validacoes {
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
    return cep.matches("^\\d{5}\\-\\d{3}$");
  }

  public static boolean validarTelefone(String cpf) {
    return cpf.matches("^\\d{5}\\-\\d{4}$");
  }

}
