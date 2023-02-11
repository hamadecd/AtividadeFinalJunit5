package serviceorder.service;

import serviceorder.entity.OrdemDeServico;
import serviceorder.enums.Servico;

import java.util.List;

public class OrdemDeServicoServiceImpl implements OrdemDeServicoService {

    @Override
    public double valorTotal(OrdemDeServico ordemDeServico) {
        double valorTotal = 0.0;
        for (int i = 0; i < ordemDeServico.getServico().size(); i++) {
            valorTotal += ordemDeServico.getServico().get(i).getValor();
        }
        return valorTotal;
    }

    @Override
    public void registraServicos(OrdemDeServico ordemDeServico, List<Servico> servicos) {
        ordemDeServico.setServico(servicos);
    }

}
