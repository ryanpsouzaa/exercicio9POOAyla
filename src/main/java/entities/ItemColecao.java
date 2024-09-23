package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class ItemColecao {

    private String id;
    private String nomeItem;
    private Condicao condicao;
    private LocalDate dataAquisicao;

    public ItemColecao(String id, String nomeItem, Condicao condicao, LocalDate dataAquisicao) {
        this.id = id;
        this.nomeItem = nomeItem;
        this.condicao = condicao;
        this.dataAquisicao = dataAquisicao;
    }

    public ItemColecao(){
        this("","",null,null);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public Condicao getCondicao() {
        return condicao;
    }

    public void setCondicao(Condicao condicao) {
        this.condicao = condicao;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemColecao that = (ItemColecao) o;
        return Objects.equals(id, that.id) && Objects.equals(nomeItem, that.nomeItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeItem);
    }

    DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String toString(){
        return "ID: " + getId() + "\n" +
                "Nome do item: " + getNomeItem() + "\n" +
                "Data de aquisição: " + getDataAquisicao().format(fmt1) + "\n" +
                "Condição: " + getCondicao() + "\n";
    }
}
