package serviceorder.service;

import serviceorder.entity.Customer;

public interface CustomerService {

    public Customer register(String cpf, String nome, String telefone) throws Exception;
    public void update(String cpf, String nome, String telefone);
    public void delete(String cpf);
    public Customer search(String cpf);
}
