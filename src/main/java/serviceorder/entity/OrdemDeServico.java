package serviceorder.entity;

import serviceorder.enums.Equipamento;
import serviceorder.enums.Servico;

import java.time.LocalDate;
import java.util.List;

public class OrdemDeServico {
    private LocalDate dataEntrada = LocalDate.now();
    private Customer customer;
    private Equipamento equipamento;
    private double valor;
    private List<Servico> servico;

    public OrdemDeServico() {
    }

    public OrdemDeServico(Customer cliente, Equipamento equipamento, List<Servico> servico) {
        this.customer = cliente;
        this.equipamento = equipamento;
        this.valor = 0.0;
        this.servico = servico;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public List<Servico> getServico() {
        return servico;
    }

    public void setServico(List<Servico> servico) {
        this.servico = servico;
    }

    @Override
    public String toString() {
        return "OrdemDeServico{" +
                "dataEntrada=" + dataEntrada +
                ", customer=" + customer +
                ", equipamento=" + equipamento +
                ", valor=" + valor +
                ", servico=" + servico +
                '}';
    }
}
