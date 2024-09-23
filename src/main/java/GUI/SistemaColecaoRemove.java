package GUI;

import entities.SistemaColecao;
import exception.ItemInexistenteException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaColecaoRemove implements ActionListener {
    private SistemaColecao sistema;
    private JFrame janelaPrincipal;

    public SistemaColecaoRemove(SistemaColecao sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String id = JOptionPane.showInputDialog(janelaPrincipal,"Digite o ID do item que deseja remover: ");
        try{
            sistema.removerItem(id);
            JOptionPane.showMessageDialog(janelaPrincipal, "Remoção do do item de ID: " + id + " realizada com sucesso");
        } catch(ItemInexistenteException e){
            JOptionPane.showMessageDialog(janelaPrincipal, e.getMessage());
        }

    }
}
