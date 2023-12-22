package br.com.will.dao;

import br.com.will.domain.Pessoa;

import java.util.Collection;

public interface IPessoaDAO {


    public Boolean cadastrar(Pessoa pessoa);
    public void excluir(Long id);
    public void alterar(Pessoa pessoa);
    public Pessoa consultar(Long id);
    public Collection<Pessoa> buscarTodos();

}
