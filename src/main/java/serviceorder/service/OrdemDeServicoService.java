package serviceorder.service;

import serviceorder.entity.OrdemDeServico;
import serviceorder.enums.Equipamento;
import serviceorder.enums.Servico;

import java.util.List;

public interface OrdemDeServicoService {

    public double valorTotal(OrdemDeServico ordemDeServico);
    public void registraServicos(OrdemDeServico ordemDeServico, List<Servico> servicos);
}
