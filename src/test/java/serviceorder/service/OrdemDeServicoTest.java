package serviceorder.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import serviceorder.entity.Customer;
import serviceorder.entity.OrdemDeServico;
import serviceorder.enums.Servico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class OrdemDeServicoTest {

    private OrdemDeServicoServiceImpl service;

    @Mock
    Customer customer;

    @BeforeEach
    public void beforeEach() {
        service = new OrdemDeServicoServiceImpl();
    }

    @Test
    public void validaDataDeEntradaDaOrdemDeServico() {
        // Given
        var ordemDeServico = new OrdemDeServico();

        assertEquals(LocalDate.now(), ordemDeServico.getDataEntrada());
    }

    @Test
    public void validaORegistroDeServicos() {
        // Given
        var ordemDeServico = new OrdemDeServico();
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
        ArrayList<Servico> servicoArrayList = new ArrayList<>(Arrays.asList(
                Servico.FORMATACAO_COM_BACKUP,
                Servico.LIMPEZA_NOTEBOOK)
        );

        // When
        service.registraServicos(ordemDeServico, servicoArrayList);

        // Then
        assertEquals(300.0, service.valorTotal(ordemDeServico));
    }

    @Test
    public void valorDaOrdemDeServicoDeveSerZeroSeNenhumServicoForAdicionado() {
        // Given
        var ordemDeServico = new OrdemDeServico();

        // Then
        assertEquals(0.0, service.valorTotal(ordemDeServico));
    }

}
