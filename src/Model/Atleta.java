package Model;

public class Atleta {
    private String cpf = "";
    private String nome = "";
    private float peso = 0;
    private float altura = 0;
    private int idade = 0;

    public Atleta(String cpf, String nome, float peso, float altura, int idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
