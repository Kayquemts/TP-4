package classes;

import conection.Conect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Lista_De_LeituraDAO {


    public boolean add_lista_de_leitura(Lista_De_Leitura leitura_lista) {
        String sql = "INSERT INTO Lista_De_Leitura(ID_Conta, Nome) VALUES (?, ?)";

        try (Connection con = Conect.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, leitura_lista.getId_conta());
            ps.setString(2, leitura_lista.getNome());

            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar lista de leitura", e);
        }
    }


    public boolean remover_lista_de_leitura(int idLista) {
        String sql = "DELETE FROM Lista_De_Leitura WHERE ID_Lista = ?";

        try (Connection con = Conect.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idLista);

            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover lista de leitura", e);
        }
    }


    public boolean atualizar_lista_de_leitura(Lista_De_Leitura leitura_lista) {
        String sql = "UPDATE Lista_De_Leitura SET ID_Conta = ?, Nome = ? WHERE ID_Lista = ?";

        try (Connection con = Conect.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, leitura_lista.getId_conta());
            ps.setString(2, leitura_lista.getNome());
            ps.setInt(3, leitura_lista.getId_lista());

            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar lista de leitura", e);
        }
    }


    public Lista_De_Leitura pesquisar_lista_de_leitura(int idLista) {
        String sql = "SELECT * FROM Lista_De_Leitura WHERE ID_Lista = ?";
        Lista_De_Leitura leitura_lista = null;

        try (Connection con = Conect.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idLista);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                leitura_lista = new Lista_De_Leitura();
                leitura_lista.setId_lista(rs.getInt("ID_Lista"));
                leitura_lista.setId_conta(rs.getInt("ID_Conta"));
                leitura_lista.setNome(rs.getString("Nome"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar lista de leitura", e);
        }

        return leitura_lista;
    }
}
