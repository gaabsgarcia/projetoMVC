package Controller;

import Model.Atleta;

import java.util.ArrayList;

/**
 *
 * @author gabriellagarcia
 */

public class AtletaController {
    private final ArrayList<Atleta> getAll;

    public AtletaController() {
        getAll = new ArrayList<>();
    }

    public void cadastro(String cpf, String nome, float peso, float altura, int idade) {
        Atleta atleta = new Atleta(cpf, nome, peso, altura, idade);
        getAll.add(atleta);
    }

    public ArrayList<Atleta> buscar() {
        return getAll;
    }

    public boolean exclui(String nome){
        boolean excluido = false;
        for(Atleta atleta: getAll) {
            if(nome.equalsIgnoreCase(atleta.getNome())) {
                getAll.remove(atleta);
                excluido = true;
                break;
            }
        }
        return excluido;
    }

    public String maiorAtleta() {
        String alturaAtleta = "";
        int maior = 0;
        for(Atleta atleta: getAll){
            if(atleta.getAltura() > maior){
                alturaAtleta = atleta.getNome();
            }
        }
        return alturaAtleta;
    }

    public float peso() {
        float pesoAtleta = 0;
        for(Atleta atleta: getAll){
            pesoAtleta = pesoAtleta + atleta.getPeso();
        }
        return pesoAtleta;
    }

    public int idadeMaior() {
        int maiorIdade = 0;
        for(Atleta atleta: getAll){
            if(atleta.getIdade() >= 18){
                maiorIdade++;
            }
        }
        return maiorIdade;
    }

    public int idadeMenor() {
        int menorIdade = 0;
        for(Atleta atleta: getAll){
            if(atleta.getIdade() < 18){
                menorIdade++;
            }
        }
        return menorIdade;
    }
}
