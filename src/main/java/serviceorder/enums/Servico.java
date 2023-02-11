package serviceorder.enums;

public enum Servico {
    FORMATACAO_COM_BACKUP(150.0),
    FORMATACAO_SEM_BACKUP(100.0),
    LIMPEZA_DESKTOP(120.0),
    LIMPEZA_NOTEBOOK(150.0);
    private double valor;

    Servico(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return this.valor;
    }
}
