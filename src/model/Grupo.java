package model;

import java.util.ArrayList;
import java.util.List;

public class Grupo {

  public Grupo() {

  }

  private List<Pessoa> grupo = new ArrayList<>();

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
      }
    }

    if (grupo.contains(pessoa)) {
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
