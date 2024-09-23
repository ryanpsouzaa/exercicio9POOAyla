package GUI;

import entities.ItemColecao;
import entities.SistemaColecao;
import exception.ItemInexistenteException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaColecaoSearchId implements ActionListener {
    private SistemaColecao sistema;
    private JFrame janelaPrincipal;

    public SistemaColecaoSearchId(SistemaColecao sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String id = JOptionPane.showInputDialog(janelaPrincipal, "Digite o ID do item que deseja pesquisar: ");

        try{
            JOptionPane.showMessageDialog(janelaPrincipal,"Item pesquisado: \n" + sistema.pesquisarItemPorId(id));
        } catch (ItemInexistenteException e){
            JOptionPane.showMessageDialog(janelaPrincipal, e.getMessage());
        }
    }
}
