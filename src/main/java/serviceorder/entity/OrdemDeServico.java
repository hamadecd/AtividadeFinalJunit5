package serviceorder.entity;

import serviceorder.enums.Equipamento;
import serviceorder.enums.Servico;

import java.time.LocalDate;
import java.util.List;

public class OrdemDeServico {
    private LocalDate dataEntrada = LocalDate.now();
    private Cliente cliente;
    private Equipamento equipamento;
    private double valor;
    private List<Servico> servico;

    public OrdemDeServico() {
    }

    public OrdemDeServico(Cliente cliente, Equipamento equipamento, List<Servico> servico) {
        this.cliente = cliente;
        this.equipamento = equipamento;
        this.valor = 0.0;
        this.servico = servico;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

//    public double getValor() {
//        double preco = this.servico.forEach(v -> v.getValor());
//        return valor;
//    }
//
//    public void setValor(double valor) {
//        this.valor = valor;
//    }

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
                ", cliente=" + cliente +
                ", equipamento=" + equipamento +
                ", valor=" + valor +
                ", servico=" + servico +
                '}';
    }
}
