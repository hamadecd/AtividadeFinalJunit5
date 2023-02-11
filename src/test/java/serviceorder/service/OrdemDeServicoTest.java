package serviceorder.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import serviceorder.entity.Cliente;
import serviceorder.entity.OrdemDeServico;
import serviceorder.enums.Servico;

import java.util.ArrayList;
import java.util.Arrays;

public class OrdemDeServicoTest {

    @Mock
    Cliente cliente;

    @Test
    public void validaInformacoesDoClienteNaOrdemDeServico() {

    }

    @Test
    public void validaORegistroDeServicos() {
        // Given
        var ordemDeServico = new OrdemDeServico();
        var service = new OrdemDeServicoServiceImpl();
        ArrayList<Servico> servicoArrayList = new ArrayList<>(Arrays.asList(
                Servico.FORMATACAO_SEM_BACKUP)
        );

        // When
        service.registraServicos(ordemDeServico, servicoArrayList);

        // Then
        assertNotNull(ordemDeServico.getServico());
    }

    @Test
    public void validaValorTotalComFormatacaoComBackupELimpezaDeNotebook() {
        // Given
        var ordemDeServico = new OrdemDeServico();
        var service = new OrdemDeServicoServiceImpl();
        ArrayList<Servico> servicoArrayList = new ArrayList<>(Arrays.asList(
                Servico.FORMATACAO_COM_BACKUP,
                Servico.LIMPEZA_NOTEBOOK)
        );

        // When
        service.registraServicos(ordemDeServico, servicoArrayList);

        // Then
        assertEquals(300.0, service.valorTotal(ordemDeServico));
    }

}
