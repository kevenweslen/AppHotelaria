package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdicionaisDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirAdicionais() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoAdicionais = conndb.prepareStatement("INSERT INTO Adicionais" +
                    "(nome, preco) VALUES (?, ?);");
            //setar os parametros
            novoAdicionais.setString(1, "");
            novoAdicionais.setString(2, "");

            int linhaAfetada = novoAdicionais.executeUpdate();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir Adicionais" + erro);
            return false;
        }
    }

    public boolean alterarAdicionais() throws SQLException {
        Connection conndb = conexao.conectar();
        try {
            PreparedStatement alterAdicionais = conndb.prepareStatement("UPDATE adicionais " +
                    "SET nome = ?, SET preco = ?");

            alterAdicionais.setString(1, "");
            alterAdicionais.setDouble(1, 1);

            int linhaAfetada = alterAdicionais.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar Adicionais" + erro);
            return false;
        }
    }

    public boolean delAdicionais() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement delAdicionais = conndb.prepareStatement("DELETE FROM adicionais WHERE id = ?");
            delAdicionais.setInt(1, 1);

            int linhaAfetada = delAdicionais.executeUpdate();
            return linhaAfetada > 0;

        } catch (
                Exception erro) {
            System.out.println("Erro ao inserir Adicionais" + erro);
            return false;
        }
    }

    public void pesquisarAdicionais() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscarAdicionais = conndb.prepareStatement("SELECT nome, preco FROM adicionais WHERE id = ?");
            buscarAdicionais.setInt(1, 1); // Correção: setInt para ID (não setString e setDouble juntos)
            ResultSet resultado = buscarAdicionais.executeQuery();

            while (resultado.next()) { // Correção: Adicionado resultado.next()
                String nome = resultado.getString("nome"); // Correção: getString (não getNString)
                double preco = resultado.getDouble("preco"); // Correção: Coluna correta "preco"
                System.out.println("Nome: " + nome + " | Preço: " + preco);
            }
            conndb.close(); // Mover para fora do while
        } catch (SQLException erro) { // Correção: Especificar exceção
            System.out.println("Erro ao pesquisar Adicionais: " + erro.getMessage());
        }
    }

}

