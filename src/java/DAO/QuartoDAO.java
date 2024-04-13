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
import model.Quarto;
import util.FabricaConexao;

/**
 *
 * @author mariailsa
 */
public class QuartoDAO {
    private static final String GET_ALL_ROOMS = "select * from quarto";
    private static final String GET_AN_ROOM = "select * from quarto where numero = ?";
    private static final String UPDATE_ROOM = "update quarto set disponivel = ? where numero = ?";
    
    public ArrayList<Quarto> getAllRooms(){
        ArrayList<Quarto> rooms = new ArrayList<>();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement statement = con.prepareStatement(GET_ALL_ROOMS);
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Quarto room = new Quarto();
                room.setNumero(result.getInt("numero"));
                room.setClassificacao(result.getString("classificacao"));
                room.setCapacidadePessoas(result.getInt("capacidade"));
                room.setDisponivel(result.getByte("disponivel"));
                
                rooms.add(room);
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return rooms;
    }
    
    public Quarto getRoom(Quarto room){
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement statement = con.prepareStatement(GET_AN_ROOM);
            statement.setInt(1, room.getNumero());
            ResultSet result = statement.executeQuery();
            if(result.next()){
                room.setDisponivel(result.getByte("disponivel"));
                room.setClassificacao(result.getString("classificacao"));
                room.setCapacidadePessoas(result.getInt("capacidade"));
                
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return room;
    }
    
    public void updateStatusRoom(Quarto room){
        try {
          Connection con = FabricaConexao.getConexao();
          PreparedStatement statement = con.prepareStatement(UPDATE_ROOM);
          statement.setByte(1, room.getDisponivel());
          statement.setInt(2, room.getNumero());
          statement.execute();
          con.close();
          
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}
