/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Agencia;
import util.FabricaConexao;

/**
 *
 * @author mariailsa
 */
public class AgenciaDAO {
    private static final String GET_ALL_AGENCIES = "select * from agencia";
    private static final String GET_AN_AGENCY = "select * from agencia where id = ?";
    public ArrayList<Agencia> getAllAgerncies(){
        ArrayList<Agencia> agencies = new ArrayList<>();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement statement = con.prepareStatement(GET_ALL_AGENCIES);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                Agencia agencia = new Agencia();
                agencia.setId(result.getInt("id"));
                agencia.setNome(result.getString("nome"));
                agencia.setClassificacao(result.getString("classificacao"));
                
                agencies.add(agencia);
            }   
                con.close();
        
        }  catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return agencies;
    }
    
    public Agencia getAgency(Agencia agency){
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement statement = con.prepareStatement(GET_AN_AGENCY);
            statement.setInt(1, agency.getId());
            ResultSet result = statement.executeQuery();
            if(result.next()){
                agency.setNome(result.getString("nome"));
                agency.setClassificacao(result.getString("classificacao"));
            }
            con.close();
        }  catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return agency;
    }
}
