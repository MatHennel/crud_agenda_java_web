package services;

import entidade.Contato;

import java.util.List;

public interface ContatoService {
    public Contato save(Contato contatos);

    public List<Contato> getContatos();
}
