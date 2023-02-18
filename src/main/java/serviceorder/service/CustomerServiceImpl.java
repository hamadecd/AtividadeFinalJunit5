package serviceorder.service;

import serviceorder.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService, ValidaDocumentos {
    private List<Customer> clientes = new ArrayList<>();
    private ValidaDocumentos validaDocumentos;

    @Override
    public Customer register(String cpf, String name, String phoneNumber) throws Exception {
        if (!validaDocumentos.validaCpf(cpf)) {
            throw new Exception("CPF inválido");
        }
        Customer cliente = new Customer(cpf, name, phoneNumber);
        clientes.add(cliente);
        return cliente;
    }

    @Override
    public void update(String cpf, String name, String phoneNumber) {
        Customer cliente = search(cpf);
        cliente.setName(name);
        cliente.setPhoneNumber(phoneNumber);
    }

    @Override
    public void delete(String cpf) {
        clientes.removeIf(cliente -> cliente.getCpf().equals(cpf));
    }

    @Override
    public Customer search(String cpf) {
        return clientes.stream().filter(cliente -> cliente.getCpf().equals(cpf)).findFirst()
                .orElseThrow(() -> new RuntimeException("Tente novamente com outro cpf"));
    }

    public List<Customer> getClientes() {
        return clientes;
    }

    @Override
    public boolean validaCpf(String cpf) throws Exception {
        if (cpf.length() == 11) {
            return true;
        }
        return false;
    }
}
