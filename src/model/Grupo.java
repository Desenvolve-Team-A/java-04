package model;

import java.util.ArrayList;
import java.util.List;

public class Grupo {

  private static Grupo uniqueInstance;

  private List<Pessoa> listaDePessoas = new ArrayList<>();

  public static synchronized Grupo getInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new Grupo();
    }
    return uniqueInstance;
  }

  public List<Pessoa> getListaDePessoas() {
    return listaDePessoas;
  }

  public void cadastrarPessoa(Pessoa pessoa) {
    if (listaDePessoas.size() < 11) {
      listaDePessoas.add(pessoa);
    } else {
      System.out.println("\nNao e possivel cadastrar mais pessoas.");
    }
  }

  public void excluirPessoa(String nome) {
    Pessoa pessoa = null;
    for (Pessoa p : listaDePessoas) {
      if (p.getNome().equals(nome)) {
        pessoa = p;
        System.out.println("\nPessoa excluida!");
        break;
      }
    }
    if (pessoa != null) {
      listaDePessoas.remove(pessoa);
    } else {
      System.out.println("\nPessoa nao localizada");
    }

  }

  public void mostrarGrupo() {
    System.out.println("** PESSOAS CADASTRADAS **");
    for (Pessoa p : listaDePessoas) {
      System.out.println("\n" + p.getNome());
    }
  }
}
