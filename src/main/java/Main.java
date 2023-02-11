import serviceorder.entity.Cliente;
import serviceorder.entity.OrdemDeServico;
import serviceorder.enums.Equipamento;
import serviceorder.enums.Servico;
import serviceorder.service.OrdemDeServicoService;
import serviceorder.service.OrdemDeServicoServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("123456789123", "Igor", "9999-9999");
        OrdemDeServico ordemDeServico = new OrdemDeServico();
//        ordemDeServico.setCliente(cliente);
        ArrayList<Servico> servicoArrayList = new ArrayList<>();
        servicoArrayList.add(Servico.LIMPEZA_NOTEBOOK);
        servicoArrayList.add(Servico.FORMATACAO_SEM_BACKUP);

        ordemDeServico.setServico(servicoArrayList);

        System.out.println(ordemDeServico.toString());

        OrdemDeServicoServiceImpl service = new OrdemDeServicoServiceImpl();

        double total = service.valorTotal(ordemDeServico);
        System.out.println(total);
    }
}
