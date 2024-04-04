/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Agencia;
import model.Hospede;
import model.Quarto;
import model.Reserva;
import util.FabricaConexao;

/**
 *
 * @author mariailsa
 */
public class HistoricoDAO {
    private static final String ADD_TO_HISTORICO = "insert into historico "
                                               + "(dia_da_reserva, expiracao, dias_reservados, diaria, despesas_totais, servicos_adicionais, hospede, agencia, quarto) "
                                               + "values(?,?,?,?,?,?,?,?,?,)";
    // esse comando será executado antes de deleatar uma reserva para adicionar ao historico aquela reserva
    private static final String GET_RESERVA = "select * from reserva where hospede = ?";
    // pegando a reserva pelo id do hospede, assim listará a reserva antigas daquele hospede especifico
    
    
    public Reserva getReserva(Hospede hospede){
        Reserva reserva = new Reserva();
        Quarto numeroDoQuarto = new Quarto();
        Agencia agencia = new Agencia();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement statement = con.prepareStatement(GET_RESERVA);
            statement.setInt(1, hospede.getId());
            ResultSet result = statement.executeQuery();
            if(result.next()){
              reserva.setId(result.getLong("id"));
              reserva.setDiaDaReserva(result.getString("dia_da_reserva"));
              reserva.setExpiracao(result.getString("expiracao"));
              reserva.setDiasReservados(result.getInt("dias_reservados"));
              reserva.setServicosAdicionais(result.getByte("servicos_adicionais"));
              reserva.setDespesasTotais(result.getDouble("despesas_totais"));
              numeroDoQuarto.setNumero(result.getInt("quarto"));
              agencia.setId(result.getInt("agencia"));
              
                
            }
            reserva.setQuarto(numeroDoQuarto);
            reserva.setAgencia(agencia);
        con.close();
        } catch (Exception e) {
        }
        
        
        return reserva;
    }
}
