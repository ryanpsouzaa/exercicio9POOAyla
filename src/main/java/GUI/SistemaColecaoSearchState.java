package GUI;

import entities.Condicao;
import entities.ItemColecao;
import entities.SistemaColecao;
import exception.ItemOuListaNulaException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class SistemaColecaoSearchState implements ActionListener {
    private SistemaColecao sistema;
    private JFrame janelaPrincipal;

    public SistemaColecaoSearchState(SistemaColecao sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        Condicao [] listaCondicao = {Condicao.LACRADO, Condicao.USADO, Condicao.DANIFICADO};
        Condicao condicao = (Condicao) JOptionPane.showInputDialog(janelaPrincipal, "Selecione a Condição que deseja pesquisar: ",
                "Selecione a Condição",JOptionPane.QUESTION_MESSAGE, null, listaCondicao, listaCondicao[0]);

        try{
            Collection<ItemColecao> listaPesquisada = sistema.pesquisarItensPorCondicao(condicao);
            int contador = 0;
            for (ItemColecao item : listaPesquisada){
                contador += 1;
                JOptionPane.showMessageDialog(janelaPrincipal, "Item pesquisado #" + contador + "\n" + item.toString());
            }
        } catch (ItemOuListaNulaException e){
            JOptionPane.showMessageDialog(janelaPrincipal, e.getMessage());
        }
    }
}
