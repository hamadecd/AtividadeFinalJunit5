package serviceorder.service;

import serviceorder.entity.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteServiceImpl implements ClienteService {
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public Cliente cadastrar(String cpf, String nome, String telefone) {
        Cliente cliente = new Cliente(cpf, nome, telefone);
        clientes.add(cliente);
        return cliente;
    }

    @Override
    public void atualizar(String cpf, String nome, String telefone) {
        Cliente cliente = buscar(cpf);
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
    }

    @Override
    public void excluir(String cpf) {
        clientes.removeIf(cliente -> cliente.getCpf().equals(cpf));
    }

    @Override
    public Cliente buscar(String cpf) {
        return clientes.stream().filter(cliente -> cliente.getCpf().equals(cpf)).findFirst()
                .orElseThrow(() -> new RuntimeException("Tente novamente com outro cpf"));
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
