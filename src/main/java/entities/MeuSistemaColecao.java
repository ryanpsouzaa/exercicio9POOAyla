package entities;

import exception.ItemInexistenteException;
import exception.ItemJaExistenteException;
import exception.ItemOuListaNulaException;

import javax.swing.*;
import java.time.LocalDate;
import java.util.*;

public class MeuSistemaColecao implements SistemaColecao{

    private Map<String, ItemColecao> sistema;

    public MeuSistemaColecao(){
        this.sistema = new HashMap<>();
    }

    @Override
    public void cadastrarItem(String id, String nomeItem, Condicao condicao, LocalDate dataAquisicao)
            throws ItemJaExistenteException, ItemOuListaNulaException {

        ItemColecao itemElemento = new ItemColecao(id, nomeItem, condicao, dataAquisicao);
        if(this.sistema.containsKey(id)){
            throw new ItemJaExistenteException("Este item já se encontra cadastrado.");
        }
        if(itemElemento == null){
            throw new ItemOuListaNulaException("Este item não foi preenchido conforme o esperado");
        }
        this.sistema.put(id, itemElemento);

    }

    @Override
    public void removerItem(String id) throws ItemInexistenteException {
        if(!this.sistema.containsKey(id)){
            throw new ItemInexistenteException("O item mencionado não foi encontrado");
        }
        this.sistema.remove(id, this.sistema.get(id));

    }

    @Override
    public ItemColecao pesquisarItemPorId(String id) throws ItemInexistenteException {
        if(this.sistema.containsKey(id)){
            return this.sistema.get(id);
        } else {
            throw new ItemInexistenteException("O item mencionado não foi encontrado");
        }
    }

    @Override
    public Collection<ItemColecao> pesquisarItensPorCondicao(Condicao condicao) throws ItemOuListaNulaException {
        Collection<ItemColecao> listaCondicao = new ArrayList<>();
        for (ItemColecao item : this.sistema.values()){
            if(item.getCondicao().equals(condicao)){
                listaCondicao.add(item);
            }
        }
        if(listaCondicao.isEmpty()){
            throw new ItemOuListaNulaException("Não foram encontrados os itens com a condição mencionada");
        } else {
            return listaCondicao;
        }
    }

    @Override
    public Collection<ItemColecao> pesquisarItensPorDataAquisicao(LocalDate dataAquisicao) throws ItemOuListaNulaException {
        Collection<ItemColecao> listaData = new ArrayList<>();
        for(ItemColecao item : this.sistema.values()){
            if(item.getDataAquisicao().equals(dataAquisicao)){
                listaData.add(item);
            }
        }
        if(listaData.isEmpty()){
            throw new ItemOuListaNulaException("Não foram encontrados os itens com a data mencionada");
        } else {
            return listaData;
        }
    }

    @Override
    public Collection<ItemColecao> exibirColecaoCompleta() throws ItemOuListaNulaException {
        if(this.sistema.isEmpty()){
            throw new ItemOuListaNulaException("Não há itens cadastrados para serem exibidos");
        } else {
            return this.sistema.values();
        }


    }
}
