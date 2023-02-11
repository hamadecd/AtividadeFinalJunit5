package serviceorder.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import serviceorder.entity.Cliente;

public class ClienteServiceTest {

    @Test
    public void validaCadastrarCliente() {
        ClienteServiceImpl clienteService = new ClienteServiceImpl();
        Cliente cliente01 = clienteService.cadastrar("08906191666", "Jose Mauro", "3431-9955");

        assertEquals("08906191666", cliente01.getCpf());
    }

    @Test
    public void validaExcluirCliente() {
        ClienteServiceImpl clienteService = new ClienteServiceImpl();
        Cliente cliente01 = clienteService.cadastrar("08906191666", "Jose Mauro", "3431-9955");

        clienteService.excluir("08906191666");

        assertThrows(RuntimeException.class, () -> clienteService.buscar("08906191666"));
        assertFalse(clienteService.getClientes().contains(cliente01));
    }

    @Test
    public void validaAtualizarCliente() {
        ClienteServiceImpl clienteService = new ClienteServiceImpl();
        Cliente cliente01 = clienteService.cadastrar("08906191666", "Jose Mauro", "3431-9955");

        clienteService.atualizar("08906191666", "Jose Maria", "3431-2023");

        assertEquals("Jose Maria", cliente01.getNome());
        assertEquals("3431-2023", cliente01.getTelefone());
    }

    @Test
    public void validaBuscarClientePorCpf() {
        ClienteServiceImpl clienteService = new ClienteServiceImpl();
        Cliente cliente01 = clienteService.cadastrar("08906191666", "Jose Mauro", "3431-9955");

        assertSame(cliente01, clienteService.buscar("08906191666"));
    }
}
