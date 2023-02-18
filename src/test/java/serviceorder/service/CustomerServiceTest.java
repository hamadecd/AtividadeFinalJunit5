package serviceorder.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import serviceorder.entity.Customer;
@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private ValidaDocumentos validaDocumentos;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldRegisterCustomer() throws Exception {
        String cpf = "algumaCoisa";
        Mockito.when(validaDocumentos.validaCpf(null)).thenReturn(true);
        Customer customer01 = customerService.register(null, "Jose Mauro", "3431-9955");

        assertTrue(customerService.getClientes().contains(customer01));
        Mockito.verify(validaDocumentos).validaCpf(null);
        Mockito.verify(validaDocumentos, Mockito.atLeastOnce()).validaCpf(null);
    }

    @Test
    public void shouldDeleteCustomer() throws Exception {
        Mockito.when(validaDocumentos.validaCpf("08906191666")).thenReturn(true);
        Customer customer01 = customerService.register("08906191666", "Jose Mauro", "3431-9955");

        customerService.delete("08906191666");

        assertFalse(customerService.getClientes().contains(customer01));
        Mockito.verify(validaDocumentos, Mockito.times(1)).validaCpf("08906191666");
    }

    @Test
    public void shouldUpdateCustomer() throws Exception {
        Mockito.when(validaDocumentos.validaCpf("08906191666")).thenReturn(true);
        Customer customer01 = customerService.register("08906191666", "Jose Mauro", "3431-9955");

        customerService.update("08906191666", "Jose Maria", "3431-2023");

        assertEquals("Jose Maria", customer01.getName());
        assertEquals("3431-2023", customer01.getPhoneNumber());
    }

    @Test
    public void shouldFindCustomerByCpf() throws Exception {
        Mockito.when(validaDocumentos.validaCpf("08906191666")).thenReturn(true);
        Customer customer01 = customerService.register("08906191666", "Jose Mauro", "3431-9955");

        assertSame(customer01, customerService.search("08906191666"));

    }

    @Test
    public void shouldThrowExceptionWhenSearchForACpfNotRegistered() throws Exception {
        Mockito.when(validaDocumentos.validaCpf("08906191666")).thenReturn(true);
        Customer customer01 = customerService.register("08906191777", "Jose Mauro", "3431-9955");

        assertThrows(RuntimeException.class, () -> customerService.search("08906191666"));
    }

    @Test
    public void shouldNotAcceptInvalidCpf() throws Exception {
        Mockito.when(validaDocumentos.validaCpf("0890619166")).thenReturn(false);
        Customer customer01;

        Throwable throwable = assertThrows(Exception.class,
                () -> customerService.register("0890619166", "Jose Mauro", "3431-9955")
        );

        assertEquals("CPF inválido", throwable.getMessage());

//        assertNull(cliente01);
//        assertSame(cliente01, clienteService.search("0890619166"));
    }
}
