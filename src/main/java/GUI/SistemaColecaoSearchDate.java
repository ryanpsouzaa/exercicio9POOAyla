package GUI;

import entities.ItemColecao;
import entities.SistemaColecao;
import exception.ItemOuListaNulaException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class SistemaColecaoSearchDate implements ActionListener {
    private SistemaColecao sistema;
    private JFrame janelaPrincipal;

    public SistemaColecaoSearchDate(SistemaColecao sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(JOptionPane.showInputDialog(janelaPrincipal,
                "Digite a data que deseja ter os itens: "), fmt1);

        try{
            int contador = 0;
            Collection<ItemColecao> listaPesquisada = sistema.pesquisarItensPorDataAquisicao(data);
            for (ItemColecao item : listaPesquisada){
                contador += 1;
                JOptionPane.showMessageDialog(janelaPrincipal,"Item pesquisado #" + contador + "\n" + item.toString());
            }
        } catch(ItemOuListaNulaException e){
            JOptionPane.showMessageDialog(janelaPrincipal, e.getMessage());
        }

    }
}
