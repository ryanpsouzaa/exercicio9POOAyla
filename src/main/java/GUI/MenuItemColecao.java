package GUI;

import entities.MeuSistemaColecao;

import javax.swing.*;
import java.awt.*;

public class MenuItemColecao extends JFrame {
    JLabel linha1, linha2, linha3, linha4, linha5, linha6;
    MeuSistemaColecao sistema = new MeuSistemaColecao();
    JMenuBar barraMenu = new JMenuBar();

    public MenuItemColecao(){
        setTitle("Minha Coleção");

        setSize(1100, 600);
        setLocation(150, 150);
        setResizable(false);
        setBackground(Color.lightGray);

        linha1 = new JLabel("Minha Coleção", JLabel.CENTER);
        linha1. setForeground(Color.BLACK);
        linha1.setFont(new Font("SansSerif", Font.BOLD, 24));

        linha2 = new JLabel("   - Esse sistema foi criado para o gerenciamento e organização da sua coleção;");
        linha2.setForeground(Color.darkGray);
        linha2.setFont(new Font("SansSerif", Font.BOLD, 14));

        linha3 = new JLabel("   - Cadastre seus itens na coleção, como seus filmes antigos, jogos eletrônicos, livros, estátuas e etc;");
        linha3.setForeground(Color.darkGray);
        linha3.setFont(new Font("SansSerif", Font.BOLD, 14));

        linha4 = new JLabel( "  - Também é possível remover itens cadastrados, basta passar o ID do item para poder remove-lo de sua coleção;");
        linha4.setForeground(Color.darkGray);
        linha4.setFont(new Font("SansSerif", Font.BOLD, 14));

        linha5 = new JLabel( "  - Após o cadastramento dos itens, é possível pesquisa-los de 3 formas possíveis: ID, condição do item e data de aquisição;");
        linha5.setForeground(Color.darkGray);
        linha5.setFont(new Font("SansSerif", Font.BOLD, 14));

        linha6 = new JLabel("   - Para ter uma dimensão do tamanho de sua coleção basta acessar o menu de COLEÇÃO e exibir toda a sua coleção com os itens já cadastrados.");
        linha6.setForeground(Color.darkGray);
        linha6.setFont(new Font("SansSerif", Font.BOLD, 14));

        setLayout(new GridLayout(7, 1));
        add(linha1);
        add(linha2);
        add(linha3);
        add(linha4);
        add(linha5);
        add(linha6);

        add(new JLabel());
        JMenu menuColecao = new JMenu("Coleção");
        JMenuItem cadastrarItem = new JMenuItem("Cadastrar item");
        JMenuItem removerItem = new JMenuItem("Remover item");
        JMenuItem exibirTodos = new JMenuItem("Exibir todos os itens");
        menuColecao.add(cadastrarItem);
        menuColecao.add(removerItem);
        menuColecao.add(exibirTodos);

        JMenu menuPesquisa = new JMenu("Pesquisa");
        JMenuItem pesquisaId = new JMenuItem("Pesquisar por ID");
        JMenuItem pesquisaCondicao = new JMenuItem("Pesquisar por Condição");
        JMenuItem pesquisaData = new JMenuItem("Pesquisar por Data de Aquisição");
        menuPesquisa.add(pesquisaId);
        menuPesquisa.add(pesquisaCondicao);
        menuPesquisa.add(pesquisaData);

        //adicionando as ações
        cadastrarItem.addActionListener(new SistemaColecaoAddController(sistema, this));
        removerItem.addActionListener(new SistemaColecaoRemove(sistema, this));
        exibirTodos.addActionListener(new SistemaColecaoShowAll(sistema, this));

        pesquisaId.addActionListener(new SistemaColecaoSearchId(sistema, this));
        pesquisaCondicao.addActionListener(new SistemaColecaoSearchState(sistema, this));
        pesquisaData.addActionListener(new SistemaColecaoSearchDate(sistema, this));

        //adicionando na barra de menu
        barraMenu.add(menuColecao);
        barraMenu.add(menuPesquisa);
        setJMenuBar(barraMenu);

    }
    public static void main(String[] args) {
        JFrame janela = new MenuItemColecao();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
