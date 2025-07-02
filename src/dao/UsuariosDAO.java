package dao;

import model.Usuario;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuariosDAO {
    // Objeto que é instancia da classe Conexao para requisitos ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirUsuario() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoUsuario = conndb.prepareStatement("INSERT INTO usuarios" +
                    "SET (nome, email, senha, cargo_id) VALUES (?, ?, md5(?), ?);");
            //setar os parametros
            novoUsuario.setString(1, "Pamella Pereto");
            novoUsuario.setString(2, "pamellapereto@gmail.com");
            novoUsuario.setString(3, "123");
            novoUsuario.setInt(4, 1);


            int linhaAfetada = novoUsuario.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario" + erro);
            return false;
        }
    }

    public boolean alterarUser() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterUser = conndb.prepareStatement("UPDATE usuarios SET nome = ?, email = ?, senha = md5(?), cargo_id = ?, WHERE id = ?;");
            alterUser.setString(1, "Pamella Christini");
            alterUser.setString(2, "pamellachristini@gmail.com");
            alterUser.setString(3, "12345");
            alterUser.setInt(4, 1);

            int linhaAfetada = alterUser.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar Usuario" + erro);
            return false;
        }
    }

    public boolean deleteUser() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeUsuario = conndb.prepareStatement("DELETE FROM usuarios WHERE id = ?;");
            //setar os parametros
            removeUsuario.setInt(1, 1);

            int linhaAfetada = removeUsuario.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuario" + erro);
            return false;
        }
    }

    public boolean altenticarUsuario(Usuario usuario) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement altenticarUsuario = conndb.prepareStatement
                    ("SELECT nome, email FROM usuarios WHERE email = ? AND senha = md5(?)");
            altenticarUsuario.setString(1, usuario.getEmail());
            altenticarUsuario.setString(2, usuario.getSenha());
            ResultSet resultado = altenticarUsuario.executeQuery();

           boolean acessoAutorizado = resultado.next(); {
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                System.out.println("Nome: " + nome + " | Email: " + email);

                conndb.close();
                return acessoAutorizado;
            }
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar usuario" + erro);
            return false;
        }
    }
}
