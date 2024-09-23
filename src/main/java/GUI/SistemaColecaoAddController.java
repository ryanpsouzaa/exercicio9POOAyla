package GUI;

import entities.Condicao;
import entities.SistemaColecao;
import exception.ItemJaExistenteException;
import exception.ItemOuListaNulaException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SistemaColecaoAddController implements ActionListener {
    private SistemaColecao sistema;
    private JFrame janelaPrincipal;

    public SistemaColecaoAddController(SistemaColecao sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String id = JOptionPane.showInputDialog(janelaPrincipal,
                "Digite o ID: ");

        String nomeItem = JOptionPane.showInputDialog(janelaPrincipal,
                "Digite o nome do item: ");

        Condicao [] listaCondicao = {Condicao.LACRADO, Condicao.USADO, Condicao.DANIFICADO};
        Condicao condicao = (entities.Condicao) JOptionPane.showInputDialog(janelaPrincipal,
                "Selecione a Condição do item: ", "Condição do item", JOptionPane.QUESTION_MESSAGE,
                null, listaCondicao, listaCondicao[0]);

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataAquisicao = LocalDate.parse(JOptionPane.showInputDialog(janelaPrincipal,
                "Digite a Data de Aquisição (dd/mm/aaaa): "), fmt1);

        try {
            sistema.cadastrarItem(id, nomeItem, condicao, dataAquisicao);
            JOptionPane.showMessageDialog(janelaPrincipal, "ID: " + id + "\n" + "Cadastro realizado com sucesso");
        } catch (ItemJaExistenteException | ItemOuListaNulaException e) {
            JOptionPane.showMessageDialog(janelaPrincipal, e.getMessage());
        }

    }
}
