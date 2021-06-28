package View;

import Controller.AtletaController;
import Model.Atleta;
import Model.NullException;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AtletaView extends JFrame implements ActionListener {

    private JPanel contentPainel;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_cadastrar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_cpf;
    private javax.swing.JTextField txt_peso;
    private javax.swing.JTextField txt_altura;
    private javax.swing.JTextField txt_idade;
    private javax.swing.JButton btn_media;
    private javax.swing.JButton btn_maiorMenorIdade;
    private javax.swing.JButton btn_calculaAltura;
    private javax.swing.JTextField txt_excluir;
    private JPanel subContentPainelButtons;
    private JPanel painelButtons;
    private JPanel contentTitle;
    private JLabel lbl_excluir;
    private JPanel contentPainelDataBase;
    private JLabel lbl_nome;
    private JLabel lbl_cpf;
    private JLabel lbl_peso;
    private JLabel lbl_altura;
    private JLabel lbl_idade;

    private final AtletaController atletaController;
    private String resultado = "";
    private String cpf = "";
    private String nome = "";
    private float peso = 0;
    private float altura = 0;
    private int idade = 0;

    public AtletaView() {
        setContentPane(contentPainel);
        atletaController = new AtletaController();
        txt_nome.requestFocus();

        btn_excluir.addActionListener((ActionEvent e) -> {
            boolean excluido = atletaController.exclui(txt_excluir.getText());
            if(excluido == true) {
                JOptionPane.showMessageDialog(null, "Atleta excluído");
            } else {
                JOptionPane.showMessageDialog(null, "Atleta não encontrado");
            }

            this.txt_excluir.setText("");
        });

        btn_cadastrar.addActionListener(e -> {
            try {
                nome = txt_nome.getText();
                idade = Integer.parseInt(txt_idade.getText());
                peso = Float.parseFloat(txt_peso.getText());
                altura = Float.parseFloat(txt_altura.getText());
                cpf = txt_cpf.getText();

                atletaController.cadastro(cpf, nome, peso, altura, idade);

                if (nome.equals("") || cpf.equals(""))
                {
                    throw new NullException();
                }
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Esse campo deve ser em números");
                txt_idade.requestFocus();
                txt_altura.requestFocus();
                txt_peso.requestFocus();
            } catch (NullException exception){
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
            limpar();
        });

        btn_buscar.addActionListener(e -> {
            ArrayList<Atleta> getAll = atletaController.buscar();

            for (Atleta atleta: getAll)
            {
                resultado = resultado.concat("\n Nome: " + atleta.getNome()
                        + " Idade: " + atleta.getIdade()
                        + " CPF: " + atleta.getCpf()
                        + " Peso: " + atleta.getPeso()
                        + " Altura: " + atleta.getAltura()
                );
            }
            JOptionPane.showMessageDialog(null, resultado);
        });

        btn_media.addActionListener(e -> {
            ArrayList<Atleta> getAll = atletaController.buscar();
            int tamanho = 0;
            float peso;
            float media;
            for (Atleta ignored : getAll)
            {
                tamanho++;
            }

            peso = atletaController.peso();
            media = peso/tamanho;
            JOptionPane.showMessageDialog(null, media);
        });

        btn_maiorMenorIdade.addActionListener(e -> {
            int maior;
            int menor;
            maior = atletaController.idadeMaior();
            menor = atletaController.idadeMenor();
            JOptionPane.showMessageDialog(null, "Atletas maiores de idade: " + maior
                    + "\nAtletas menores de idade: " + menor);
        });

        btn_calculaAltura.addActionListener(e -> {
            String atletaMaisAlto = atletaController.maiorAtleta();
            JOptionPane.showMessageDialog(null, "O maior atleta cadastrado é: " + atletaMaisAlto);
        });
    }


    private void limpar() {
        this.txt_nome.setText("");
        this.txt_peso.setText("");
        this.txt_altura.setText("");
        this.txt_idade.setText("");
        this.txt_cpf.setText("");
        this.txt_nome.requestFocus();
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> new AtletaView().setVisible(true));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
