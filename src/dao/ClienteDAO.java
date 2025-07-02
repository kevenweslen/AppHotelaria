package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirCliente() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novocliente = conndb.prepareStatement("INSERT INTO clientes" + "SET (nome, email, telefone, cpf) VALUES (?, ?, ?, ?);");
            //setar os parametros
            novocliente.setString(1, "");
            novocliente.setString(2, "");
            novocliente.setString(3, "");
            novocliente.setString(4, "");


            int linhaAfetada = novocliente.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir Cliente" + erro);
            return false;
        }
    }

    public boolean alterarClientes() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterCliente = conndb.prepareStatement("UPDATE clientes SET nome = ?, email = ?, telefone = ?, cpf = ? WHERE id = ?;");
            alterCliente.setString(1, "");
            alterCliente.setString(2, "");
            alterCliente.setString(3, "");
            alterCliente.setString(4, "");
            alterCliente.setInt(5, 1);

            int linhaAfetada = alterCliente.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar Quarto" + erro);
            return false;
        }
    }

    public boolean delcliente() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement delCliente = conndb.prepareStatement("DELETE FROM clientes WHERE id = ?.");
            delCliente.setInt(1, 1);

            int linhaAfetada = delCliente.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir Cliente" + erro);
            return false;
        }
    }
    public void pesquisarCliente() {
        try{
            Connection conndb = conexao.conectar();
            PreparedStatement pesquisarCliente = conndb.prepareStatement("SELECT nome, email, telefone, cpf FROM clientes WHERE id = ?;");
            pesquisarCliente.setInt(1, 1);
            ResultSet resultado = pesquisarCliente.executeQuery();

            while(resultado.next()) {
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                String telefone = resultado.getString("telefone");
                String cpf = resultado.getString("cpf");
                System.out.println("Nome: " + nome + " | Email: " + email + " | Telefone: " + telefone + " | CPF: " + cpf);
                conndb.close();
            }
        }catch(Exception erro){
            System.out.println("Erro ao pesquisar Cliente" + erro);
        }
    }
}
