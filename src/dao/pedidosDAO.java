package dao;

import model.Pedido;
import util.Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;


public class pedidosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirPedido(Pedido pedido) {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoPedido = conndb.prepareStatement("INSERT INTO pedidos (usuario_id, cliente_id, pagamento) VALUES (?, ?, ?);");
            novoPedido.setInt(1, 1);
            novoPedido.setInt(2, 1);
            novoPedido.setInt(3, 1);

            int limhaafetada = novoPedido.executeUpdate();
            return limhaafetada > 0;
        }catch (Exception erro){
            System.out.println("Erro ao inserir pedido: " + erro);
            return false;
        }
    }

    public  boolean alterarPedido(Pedido pedido) {



        try{
            Connection conndb = conexao.conectar();
            PreparedStatement alterPedido = conndb.prepareStatement("UPDATE pedidos SET (usuario_id, cliente_id, pagamento) VALUES (?, ?, ?) WHERE id = ?");
            alterPedido.setInt(1, 1);
            alterPedido.setInt(2, 1);
            alterPedido.setInt(3, 1);

            int limhaafetada = alterPedido.executeUpdate();
            return limhaafetada > 0;

        }catch (Exception erro){
            System.out.println("Erro ao alterar pedido: " + erro);
            return false;
        }
    }

    public  boolean excluirPedido(Pedido pedido) {
        try{
            Connection conndb = conexao.conectar();
            PreparedStatement delPedido = conndb.prepareStatement("DELETE FROM pedidos WHERE id ?;");
            delPedido.setInt(1,1);

            int linhaAfetada = delPedido.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro){
            System.out.println("Erro ao excluir pedido: " + erro);
            return false;
        }
    }
}
