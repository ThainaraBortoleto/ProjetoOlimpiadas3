package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pais;

public class PaisDAO {
    public int criar(Pais pais) {
        String sqlInsert = "INSERT INTO pais(nome, area, populacao) VALUES (?, ?, ?)";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
             PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
            stm.setString(1, pais.getNome());
            stm.setString(2, pais.getArea());
            stm.setString(3, pais.getpopulacao());
            stm.execute();
            String sqlQuery = "SELECT LAST_INSERT_ID()";
            try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
                 ResultSet rs = stm2.executeQuery();) {
                if (rs.next()) {
                    pais.setId(rs.getInt(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pais.getId();
    }

    public void atualizar(Pais pais) {
        String sqlUpdate = "UPDATE pais SET nome=?, area=?, populacao=? WHERE id=?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
             PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
            stm.setString(1, pais.getNome());
            stm.setString(2, pais.getArea());
            stm.setString(3, pais.getPopulacao());
            stm.setInt(4, pais.getId());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sqlDelete = "DELETE FROM pais WHERE id = ?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
             PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
            stm.setInt(1, id);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pais carregar(int id) {
        Pais pais = new pais();
        pais.setId(id);
        String sqlSelect = "SELECT nome, area, populacao FROM pais WHERE pais.id = ?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
             PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
            stm.setInt(1, pais.getId());
            try (ResultSet rs = stm.executeQuery();) {
                if (rs.next()) {
                    pais.setNome(rs.getString("nome"));
                    pais.setFone(rs.getString("area"));
                    pais.setEmail(rs.getString("populacao"));
                } else {
                    pais.setId(-1);
                    pais.setNome(null);
                    pais.setArea(null);
                    pais.setPopulacao(null);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e1) {
            System.out.print(e1.getStackTrace());
        }
        return pais;
    }

}
