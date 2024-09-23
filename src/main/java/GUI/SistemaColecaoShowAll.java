package GUI;

import entities.ItemColecao;
import entities.SistemaColecao;
import exception.ItemOuListaNulaException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class SistemaColecaoShowAll implements ActionListener {
    private SistemaColecao sistema;
    private JFrame janelaPrincipal;

    public SistemaColecaoShowAll(SistemaColecao sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            Collection<ItemColecao> todosItens = sistema.exibirColecaoCompleta();
            for(ItemColecao item : todosItens){
                JOptionPane.showMessageDialog(janelaPrincipal, item.toString());
            }

        } catch(ItemOuListaNulaException e){
            JOptionPane.showMessageDialog(janelaPrincipal, e.getMessage());
        }

    }
}
