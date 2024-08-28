package br.com.will.dao;

import br.com.will.domain.Pessoa;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PessoaMapDAO implements IPessoaDAO{

    private Map<Long, Pessoa>map;

    public PessoaMapDAO(){
        this.map = new HashMap<>();
    }


    @Override
    public Boolean cadastrar(Pessoa pessoa) {
        if(this.map.containsKey(pessoa.getId())){
            return false;
        }
        this.map.put(pessoa.getId(), pessoa);
        return true;
    }

    @Override
    public void excluir(Long id) {
        Pessoa pessoaCadastrada = this.map.get(id);
        if(pessoaCadastrada != null){
            this.map.remove(pessoaCadastrada.getId(), pessoaCadastrada);
        }
    }

    @Override
    public void alterar(Pessoa pessoa) {
        Pessoa pessoaCadastrada = map.get(pessoa.getId());
        if(pessoaCadastrada != null){
            pessoaCadastrada.setNome(pessoa.getNome());
            pessoaCadastrada.setCondiçãoSaude(pessoa.getCondiçãoSaude());
        }

    }

    @Override
    public Pessoa consultar(Long id) {
        return this.map.get(id);
    }

    @Override
    public Collection<Pessoa> buscarTodos() {
        return this.map.values();
    }


}
