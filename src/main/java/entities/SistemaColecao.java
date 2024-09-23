package entities;

import exception.ItemInexistenteException;
import exception.ItemJaExistenteException;
import exception.ItemOuListaNulaException;

import java.time.LocalDate;
import java.util.Collection;

public interface SistemaColecao {
    void cadastrarItem(String id, String nomeItem, Condicao condicao, LocalDate dataAquisicao) throws ItemJaExistenteException, ItemOuListaNulaException;
    void removerItem(String id) throws ItemInexistenteException;
    ItemColecao pesquisarItemPorId(String id) throws ItemInexistenteException;
    Collection<ItemColecao> pesquisarItensPorCondicao(Condicao condicao) throws ItemOuListaNulaException;
    Collection<ItemColecao> pesquisarItensPorDataAquisicao(LocalDate dataAquisicao) throws ItemOuListaNulaException;
    Collection<ItemColecao> exibirColecaoCompleta() throws ItemOuListaNulaException;


}
