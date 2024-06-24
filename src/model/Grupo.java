package model;

import java.util.ArrayList;
import java.util.List;

public class Grupo {

  private static Grupo uniqueInstance;

  private List<Pessoa> grupo = new ArrayList<>();

  public static synchronized Grupo getInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new Grupo();
    }
    return uniqueInstance;
  }

  public List<Pessoa> getGrupo() {
    return grupo;
  }

  public void cadastrarPessoa(Pessoa pessoa) {
    if (grupo.size() < 11) {
      grupo.add(pessoa);
    } else {
      System.out.println("Não é possível cadastrar mais pessoas.");
    }
  }

  public void excluirPessoa(String nome) {
    Pessoa pessoa = null;
    for (Pessoa p : grupo) {
      if (p.getNome().equals(nome)) {
        pessoa = p;
        break;
      }
    }
    if (pessoa != null) {
      grupo.remove(pessoa);
    } else {
      System.out.println("Pessoa não cadastrada.");
    }
  }

  public void mostrarGrupo() {
    System.out.println("** PESSOAS CADASTRADAS **");
    for (Pessoa p : grupo) {
      System.out.println("\n" + p.getNome());
    }
  }
}
