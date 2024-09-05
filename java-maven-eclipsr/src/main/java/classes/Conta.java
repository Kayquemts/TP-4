package classes;

import java.sql.Date;

public class Conta {
    private int idConta;
    private int idCliente;
    private String tipoConta;

    // Construtor padrão
    public Conta() {}

    // Construtor com parâmetros
    public Conta(int idCliente, String tipoConta) {
        this.idCliente = idCliente;
        this.tipoConta = tipoConta;
    }

    // Getters e Setters
    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "idConta=" + idConta +
                ", idCliente=" + idCliente +
                ", tipoConta='" + tipoConta + '\'' +
                '}';
    }
}
