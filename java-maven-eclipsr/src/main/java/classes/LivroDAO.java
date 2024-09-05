package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import conection.Conect;

public class LivroDAO {


    public boolean addLivro(Livro livro_base) {
        boolean sucesso = false; 
        try {
            String add_livro_insert = "INSERT INTO Livro(Titulo, Autor) VALUES(?, ?)";

            Connection con = Conect.getConexao();
            PreparedStatement ps = con.prepareStatement(add_livro_insert);
            ps.setString(1, livro_base.getTitulo());
            ps.setString(2, livro_base.getAutor());

            int linhas_afetadas = ps.executeUpdate();
            if (linhas_afetadas > 0) {
                sucesso = true;
            }

            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sucesso;
    }


    public boolean removerLivro(int idLivro) {
        boolean sucesso = false;
        try {
            String sql = "DELETE FROM Livro WHERE ID_Livro = ?";
            Connection con = Conect.getConexao();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idLivro);

            int linhas_afetadas = ps.executeUpdate();
            if (linhas_afetadas > 0) {
                sucesso = true;
            }

            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sucesso;
    }


    public boolean atualizarLivro(Livro livro_base) {
        boolean sucesso = false;
        try {
            String sql = "UPDATE Livro SET Titulo = ?, Autor = ? WHERE ID_Livro = ?";

            Connection con = Conect.getConexao();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, livro_base.getTitulo());
            ps.setString(2, livro_base.getAutor());
            ps.setInt(4, livro_base.getId());

            int linhas_afetadas = ps.executeUpdate();
            if (linhas_afetadas > 0) {
                sucesso = true;
            }

            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sucesso;
    }


    public Livro pesquisarLivro(int idLivro) {
        Livro livro = null;
        try {
            String sql = "SELECT * FROM Livro WHERE ID_Livro = ?";
            Connection con = Conect.getConexao();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idLivro);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                livro = new Livro();
                livro.setId(rs.getInt("ID_Livro"));
                livro.setTitulo(rs.getString("Titulo"));
                livro.setAutor(rs.getString("Autor"));
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livro;
    }

    public boolean add_muitos_livros(List<Livro> livros) {
        String sql = "INSERT INTO Livro(Titulo, Autor) VALUES (?, ?)";
        boolean sucesso = false;
        Connection con = null;
        try {
            con = Conect.getConexao();
            PreparedStatement ps = con.prepareStatement(sql);
            // Desativa o auto-commit para permitir transações
            con.setAutoCommit(false);

            for (Livro livro : livros) {
                ps.setString(1, livro.getTitulo());
                ps.setString(2, livro.getAutor());
                ps.addBatch(); // Adiciona a instrução ao lote
            }

            int[] linhasAfetadas = ps.executeBatch(); // Executa o lote
            con.commit(); // Confirma a transação

            // Verifica se pelo menos uma linha foi afetada para marcar sucesso
            sucesso = linhasAfetadas.length > 0;

        } catch (SQLException e) {
            // Se houver uma exceção, faz o rollback da transação
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException rollbackEx) {
                throw new RuntimeException("Erro ao fazer rollback da transação", rollbackEx);
            }
            e.printStackTrace(); // Imprime o stack trace para depuração
        }

        return sucesso;
    }

    public List<Livro> buscarLivrosPorTitulo(String busca) {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM Livro WHERE Titulo LIKE ?";

        try (Connection con = Conect.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Define o parâmetro de busca, usando % para buscar qualquer substring
            ps.setString(1, "%" + busca + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("ID_Livro"));
                livro.setTitulo(rs.getString("Titulo"));
                livro.setAutor(rs.getString("Autor"));
                livros.add(livro);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Imprime o stack trace para depuração
        }

        return livros;
    }

}
