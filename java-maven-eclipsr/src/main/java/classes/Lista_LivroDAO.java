package classes;

import conection.Conect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Lista_LivroDAO {


    public boolean add_lista_livro(Lista_Livro livro_lista) {
        String sql = "INSERT INTO Lista_Livro(ID_Lista, ID_Livro) VALUES (?, ?)";

        try (Connection con = Conect.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, livro_lista.getId_lista());
            ps.setInt(2, livro_lista.getId_livro());

            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar lista livro", e);
        }
    }

    public boolean remover_lista_livro(int idLista, int idLivro) {
        String sql = "DELETE FROM Lista_Livro WHERE ID_Lista = ? AND ID_Livro = ?";

        try (Connection con = Conect.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idLista);
            ps.setInt(2, idLivro);

            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover lista livro", e);
        }
    }





    public Lista_Livro pesquisar_lista_livro(int idLista, int idLivro) {
        String sql = "SELECT * FROM Lista_Livro WHERE ID_Lista = ? AND ID_Livro = ?";
        Lista_Livro livro_lista = null;

        try (Connection con = Conect.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idLista);
            ps.setInt(2, idLivro);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                livro_lista = new Lista_Livro();
                livro_lista.setId_lista(rs.getInt("ID_Lista"));
                livro_lista.setId_livro(rs.getInt("ID_Livro"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar lista livro", e);
        }

        return livro_lista;
    }
}
