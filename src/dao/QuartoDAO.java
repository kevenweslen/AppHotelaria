package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuartoDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirQuarto() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoQuarto = conndb.prepareStatement("INSERT INTO quartos" +
                    "(nome, numero, qtn_cama_casal, qtn_cama_solteiro, preco, disponivel) VALUES ?, ?, ?, ?, ?, ?);");
            //setar os parametros
            novoQuarto.setString(1, "");
            novoQuarto.setString(2, "");
            novoQuarto.setInt(3, 1);
            novoQuarto.setInt(4, 2);
            novoQuarto.setInt(5, 3);
            novoQuarto.setInt(6, 4);


            int linhaAfetada = novoQuarto.executeUpdate();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir Quarto" + erro);
            return false;
        }
    }

    public boolean alterarQuarto() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterQuarto = conndb.prepareStatement("UPDATE quartos SET nome = ?, numero = ?, qtn_cama_casal = ?, qtn_cama_solteiro = ?, proco = ?, disponivel = ? WHERE id = ?;");
            alterQuarto.setString(1, "");
            alterQuarto.setString(2, "");
            alterQuarto.setInt(3, 1);
            alterQuarto.setInt(4, 2);
            alterQuarto.setInt(5, 3);
            alterQuarto.setInt(6, 3);
            int linhaAfetada = alterQuarto.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar Quarto" + erro);
            return false;
        }
    }

    public boolean delQuarto() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement delQuarto = conndb.prepareStatement("DELETE FROM quartos WHERE id = ?");
            delQuarto.setInt(1, 1);

            int linhaAfetada = delQuarto.executeUpdate();
            return linhaAfetada > 0;

        } catch (
                Exception erro) {
            System.out.println("Erro ao inserir quarto" + erro);
            return false;
        }
    }
}

