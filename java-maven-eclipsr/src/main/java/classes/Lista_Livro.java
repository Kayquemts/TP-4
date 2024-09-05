package classes;

public class Lista_Livro {
    private int id_lista;
    private int id_livro;

    public Lista_Livro(int id_lista, int id_livro) {
        this.id_lista = id_lista;
        this.id_livro = id_livro;
    }

    public Lista_Livro(){}

    public int getId_lista() {
        return id_lista;
    }

    public void setId_lista(int id_lista) {
        this.id_lista = id_lista;
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }
}
