package model;

public class Pessoa {

  private String nome;
  private int idade;
  private String CPF;
  private Endereco endereco;

  public Pessoa(String nome, int idade, String CPF, Endereco endereco) {
    this.nome = nome;
    this.idade = idade;
    this.CPF = CPF;
    this.endereco = endereco;
  }

  public static Pessoa criarPessoaSemEnd(String nome, int idade, String CPF) {
    return new Pessoa(nome, idade, CPF, new Endereco("", "", "", "", "", ""));
  }

  public static Pessoa criarPessoaVazio() {
    return new Pessoa("", 0, "", new Endereco("", "", "", "", "", ""));
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCPF() {
    return CPF;
  }

  public void setCPF(String CPF) {
    this.CPF = CPF;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }
}
