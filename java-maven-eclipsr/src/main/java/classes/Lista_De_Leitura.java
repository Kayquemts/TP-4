package classes;

public class Lista_De_Leitura {

    private int id_conta;
    private String nome;
    private int id_lista;


    public Lista_De_Leitura(int id_conta, String nome){
        this.id_conta = id_conta;
        this.nome = nome;

    }

    public Lista_De_Leitura() {
    }

    public int getId_conta() {
        return id_conta;
    }

    public void setId_conta(int id_conta) {
        this.id_conta = id_conta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_lista() {
        return id_lista;
    }

    public void setId_lista(int id_lista) {
        this.id_lista = id_lista;
    }
}
