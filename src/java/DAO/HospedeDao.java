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
import model.Hospede;
import model.User;
import util.FabricaConexao;

/**
 *
 * @author mariailsa
 */
public class HospedeDao {
    private static final String getAllHotelguests ="select * from hospede";
    private static final String deleteHotelGuest= "delete from hospede where id = ?";
    private static final String getHotelGuest ="select * from hospede where id = ?";
    private static final String updateHotelGuest = "update hospede set nome = ?, rg = ? where id = ?";
    private static final String insertHotelGuest = "insert into hospede(nome,cpf,rg,nascimento) values (?,?,?,?)";
    private static final String getHotelGuestID = "select * from hospede where cpf = ?";
    
    public ArrayList<Hospede> getAllGuests(){
        ArrayList<Hospede> guests = new ArrayList<Hospede>();
        try {
            
            Connection con = FabricaConexao.getConexao();
            PreparedStatement statement = con.prepareStatement(getAllHotelguests);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                Hospede hospede = new Hospede();
                hospede.setId(result.getInt("id"));
                hospede.setCPF(result.getString("cpf"));
                hospede.setRG(result.getString("rg"));
                hospede.setNascimento(result.getString("nascimento"));
                
                guests.add(hospede);
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return guests;
    }
    public void deleteHospede(Hospede hospede){
        
        try {
             Connection con = FabricaConexao.getConexao();
            PreparedStatement statement = con.prepareStatement(deleteHotelGuest);
            statement.setInt(1,hospede.getId());
            statement.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
       
    }
    public Hospede getHospedeID(Hospede hospede){
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement statement = con.prepareStatement(getHotelGuestID);
            statement.setString(1, hospede.getCPF());
            ResultSet result = statement.executeQuery();
            if(result.next()){
                hospede.setId(result.getInt("id"));
                hospede.setCPF(result.getString("cpf"));
                hospede.setRG(result.getString("rg"));
                hospede.setNascimento(result.getString("nascimento"));
                hospede.setNome(result.getString("nome"));
                
            }
        con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return hospede;
    }
    public Hospede getHospede(Hospede hospede){
        // id vem settado no parâmetro
        Hospede h = new Hospede();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement statement = con.prepareStatement(getHotelGuest);
            statement.setInt(1, hospede.getId());
            ResultSet result = statement.executeQuery();
            if(result.next()){
                h.setId(result.getInt("id"));
                h.setCPF(result.getString("cpf"));
                h.setRG(result.getString("rg"));
                h.setNascimento(result.getString("nascimento"));
                h.setNome(result.getString("nome"));
                
            }
        con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return h;
    }
    public void insertNewHospede(Hospede hospede){
        try{
        Connection con = FabricaConexao.getConexao();
        PreparedStatement statement = con.prepareStatement(insertHotelGuest);
        statement.setString(1, hospede.getNome());
        statement.setString(2, hospede.getCPF());
        statement.setString(3, hospede.getRG());
        statement.setString(4,  hospede.getNascimento());
        
        
        statement.execute();
        con.close();
        }catch(ClassNotFoundException | SQLException e){
             e.getMessage();
            e.printStackTrace();
        }
        
    }
    public void updateHospede(Hospede hospede){
        try{
        Connection con = FabricaConexao.getConexao();
        PreparedStatement statement = con.prepareStatement(updateHotelGuest);
        statement.setString(1, hospede.getNome());
        statement.setString(2, hospede.getRG());
        statement.setInt(3,hospede.getId());
        
        
        statement.execute();
        con.close();
        }catch(ClassNotFoundException | SQLException e){
             e.getMessage();
            e.printStackTrace();
        }
    }
}
