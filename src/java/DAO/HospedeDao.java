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
    private static final String updateHotelGuest = "update hospede set nome = ?, rg = ?, usuario = ? where id = ?";
    private static final String insertHotelGuest = "insert into hospede(nome,cpf,rg,nascimento,usuario) values (?,?,?,?)";
    
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
                // user é atribuido por uma busca na classe userDAO
                con.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return guests;
    }
    public void deleteHospede(Hospede hospede){
        // apos deletar hospede usuário deve ser também deletado
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
    public Hospede getHospede(Hospede hospede){
        // id vem settado no parâmetro
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement statement = con.prepareStatement(getHotelGuest);
            statement.setInt(1, hospede.getId());
            ResultSet result = statement.executeQuery();
            if(result.next()){
                hospede.setCPF(result.getString("cpf"));
                hospede.setRG(result.getString("rg"));
                hospede.setNascimento(result.getString("nascimento"));
                hospede.setNome(result.getString("nome"));
                // se preciso fazer a busca no user
            }
        con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return hospede;
    }
    public void insertNewHospede(Hospede hospede){
        try{
        Connection con = FabricaConexao.getConexao();
        PreparedStatement statement = con.prepareStatement(insertHotelGuest);
        statement.setString(1, hospede.getNome());
        statement.setString(2, hospede.getCPF());
        statement.setString(3, hospede.getRG());
        statement.setString(4,  hospede.getNascimento());
        statement.setString(5, hospede.getUser().getEmail());
        
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
        statement.setString(3, hospede.getUser().getEmail());
        
        statement.execute();
        con.close();
        }catch(ClassNotFoundException | SQLException e){
             e.getMessage();
            e.printStackTrace();
        }
    }
}
