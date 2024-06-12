package model;

import java.util.Scanner;

public class Endereco {

    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private long cep;
    private long telefone;

    public Endereco(String estado, String cidade, String bairro, String rua, long cep, long telefone) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.cep = cep;
        this.telefone = telefone;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public long getCep() {
        return cep;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public Endereco cadastraEndereco(){

        Scanner scanner = new Scanner(System.in);

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

        return endereco;
    }
}
