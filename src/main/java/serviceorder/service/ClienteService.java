package serviceorder.service;

import serviceorder.entity.Cliente;

public interface ClienteService {

    public Cliente cadastrar(String cpf, String nome, String telefone);
    public void atualizar(String cpf, String nome, String telefone);
    public void excluir(String cpf);
    public Cliente buscar(String cpf);
}
