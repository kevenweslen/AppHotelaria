package dao;

import model.Reserva;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservaDAO {
    private Conexao conexao = new Conexao();

    public boolean alterarReserva(Reserva reserva) {

        try{
            Connection conndb = conexao.conectar();
            PreparedStatement alterarReserva = conndb.prepareStatement("UPDATE Reserva SET (pedido_id, Quarto_id, Adicional_id)  VALUES (?, ?, ?)WHERE Reserva id = ?;");
            alterarReserva.setInt(1,1);
            alterarReserva.setInt(1,1);
            alterarReserva.setInt(1,1);
            int linhaAfetada = alterarReserva.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }catch (Exception erro) {
            System.out.println("Erro ao alterar reserva: " + erro);
            return false;
        }
    }
    public boolean delreserva(Reserva reserva) throws SQLException {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement delReserva = conndb.prepareStatement("DELETE FROM reservas WHERE id =?;");
            delReserva.setInt(1, 1);

            int linhaAfetada = delReserva.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }catch (Exception erro) {
            System.out.println("Erro ao deletar reserva: " + erro);
            return false;
        }
    }
}
