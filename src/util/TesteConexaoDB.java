package util;

import controller.UsuarioController;
import dao.UsuariosDAO;

import java.sql.Connection;

public class TesteConexaoDB {
    public static void main (String[] args) {
        Conexao conexao = new Conexao();
        Connection condb = conexao.conectar();
        UsuarioController usuarioController = new UsuarioController();

         if (condb !=null){
             System.out.println("Conexão estabelecita com sucesso!");
             try {

                 usuarioController.verificarUsuario("pamellapereto@gmail.com", "123");
                 condb.close();
                 System.out.println("Conexão encerrada");
             }catch (Exception erro) {
                 System.out.print("Erro ao encerrar a conexão" + erro.getMessage());

             }
         }else
             System.out.println("Falha ao conectar ao Banco de Dados");
    }
}