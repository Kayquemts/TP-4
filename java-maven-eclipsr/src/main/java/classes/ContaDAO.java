package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conection.Conect;

public class ContaDAO {

    // Adicionar Conta
    public boolean addConta(Conta conta) {
        String sql = "INSERT INTO Conta (ID_Cliente, Tipo_Conta) VALUES ( ?, ?)";
        try (Connection con = Conect.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, conta.getIdCliente());
            ps.setString(2, conta.getTipoConta());

            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Remover Conta baseado no ID
    public boolean removerConta(int idConta) {
        String sql = "DELETE FROM Conta WHERE ID_Conta = ?";
        try (Connection con = Conect.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idConta);

            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Atualizar Conta baseado no ID
    public boolean atualizarConta(Conta conta) {
        String sql = "UPDATE Conta SET ID_Cliente = ?, Tipo_Conta = ? WHERE ID_Conta = ?";
        try (Connection con = Conect.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, conta.getIdCliente());
            ps.setString(3, conta.getTipoConta());
            ps.setInt(4, conta.getIdConta());

            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Pesquisar Conta baseado no ID
    public Conta pesquisarConta(int idConta) {
        String sql = "SELECT * FROM Conta WHERE ID_Conta = ?";
        try (Connection con = Conect.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idConta);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Conta(
                            rs.getInt("ID_Conta"),
                            rs.getString("Tipo_Conta")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Listar todas as Contas
    public List<Conta> listarContas() {
        List<Conta> contas = new ArrayList<>();
        String sql = "SELECT * FROM Conta";
        try (Connection con = Conect.getConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Conta conta = new Conta(
                        rs.getInt("ID_Conta"),
                        rs.getString("Tipo_Conta")
                );
                contas.add(conta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contas;
    }
}
