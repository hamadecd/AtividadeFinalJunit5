package serviceorder.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import serviceorder.entity.Customer;

import java.util.Arrays;

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
    public void shouldValidateCpf() throws Exception {
        Mockito.when(validaDocumentos.validaCpf("08906191666")).thenReturn(true);
        Customer customer01 = customerService.register("08906191666", "Jose Mauro", "3431-9955");
        assertTrue(customerService.validaCpf("08906191666"));
    }

    @Test
    public void shouldInvalidateCpf() throws Exception {
        Mockito.when(validaDocumentos.validaCpf("0890619166")).thenReturn(true);
        Customer customer01 = customerService.register("0890619166", "Jose Mauro", "3431-9955");
        assertFalse(customerService.validaCpf("0890619166"));
    }

    @Test
    public void shouldRegisterCustomer() throws Exception {
        Mockito.when(validaDocumentos.validaCpf("08906191666")).thenReturn(true);
        Customer customer01 = customerService.register("08906191666", "Jose Mauro", "3431-9955");

        assertTrue(customerService.getClientes().contains(customer01));
        Mockito.verify(validaDocumentos, Mockito.atLeastOnce()).validaCpf("08906191666");
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
        assertEquals("08906191666", customer01.getCpf());
        Mockito.verify(validaDocumentos, Mockito.atLeast(1)).validaCpf("08906191666");
    }

    @Test
    public void shouldFindCustomerByCpf() throws Exception {
        Mockito.when(validaDocumentos.validaCpf("08906191666")).thenReturn(true);
        Customer customer01 = customerService.register("08906191666", "Jose Mauro", "3431-9955");

        assertSame(customer01, customerService.search("08906191666"));
    }

    @Test
    public void shouldThrowExceptionWhenSearchForACpfNotRegistered() throws Exception {
        Mockito.when(validaDocumentos.validaCpf("08906191777")).thenReturn(true);
        Customer customer01 = customerService.register("08906191777", "Jose Mauro", "3431-9955");

        assertThrows(Exception.class, () -> customerService.search("08906191666"));
    }
    @Test
    public void shouldAddTwoCustomers() throws Exception {
        Mockito.when(validaDocumentos.validaCpf("08906191777")).thenReturn(true);
        Mockito.when(validaDocumentos.validaCpf("08906191666")).thenReturn(true);
        Customer customer01 = customerService.register("08906191777", "Jose Mauro", "3431-9955");
        Customer customer02 = customerService.register("08906191666", "Maria Laura", "3431-1218");

        assertEquals(2, customerService.getClientes().size());
        assertSame(customer01, customerService.getClientes().get(0));
        assertSame(customer02, customerService.getClientes().get(1));
        Mockito.verify(validaDocumentos, Mockito.times(1)).validaCpf("08906191777");
        Mockito.verify(validaDocumentos, Mockito.times(1)).validaCpf("08906191666");
    }

    @Test
    public void shouldNotAcceptInvalidCpf() throws Exception {
        Mockito.when(validaDocumentos.validaCpf("0890619166")).thenReturn(false);

        Throwable throwable = assertThrows(Exception.class,
                () -> customerService.register("0890619166", "Chuck Norris", "0000-0000")
        );

        assertEquals("CPF inválido", throwable.getMessage());
        Mockito.verify(validaDocumentos, Mockito.only()).validaCpf("0890619166");
    }
}
