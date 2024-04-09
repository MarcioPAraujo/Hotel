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
public class UserDAO {
    private static final String GET_USER = "select * from usuario where email = ?";
    private static final String ADD_NEW_USER = "insert into usuario (senha,email,root,hospede) values(?,?,?,?)";
    private static final String DELETE_USER = "delete from usuario where email = ?"; //quando deletar o usuário o hospede continua no sistema, por causa do log
    private static final String UPDATE_PASSWORD = "update usuario set senha = ? where email = ?";
    
    public User getUser(User user){
        /* log in, se bem sucedido deve retornar um objeto user preenchido, exceto pelo hospede,
        que será preenchido na classe controller*/
        Hospede hospede = new Hospede();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement statement = con.prepareStatement(GET_USER);
            statement.setString(1,user.getEmail() );
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                
                
                user.setSenha(result.getString("senha"));
                user.setRoot(result.getByte("root"));
                hospede.setId(result.getInt("hospede"));
            }
            user.setHospede(hospede);
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return user;
    }
    
    public void insertNewUser( User user){
        // no primeiro acessso antes de criar o user deve fazer o cadastro do hospede
        try{
        Connection con = FabricaConexao.getConexao();
        PreparedStatement statement = con.prepareStatement(ADD_NEW_USER);
        statement.setString(1, user.getSenha());
        statement.setString(2,user.getEmail());
        statement.setByte(3,user.isRoot());
        statement.setInt(4,user.getHospede().getId());
        
        statement.execute();
        con.close();
        }catch(ClassNotFoundException | SQLException e){
             e.getMessage();
            e.printStackTrace();
        }
    }
    
    public void updatePassword(User user){
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement statement = con.prepareStatement(UPDATE_PASSWORD);
            statement.setString(1,user.getSenha());
            statement.setString(2,user.getEmail());
            statement.execute();
            con.close();
        }catch(ClassNotFoundException | SQLException e){
             e.getMessage();
            e.printStackTrace();
        }
    }
    
    public void deleteUser(User user){
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement statement = con.prepareStatement(DELETE_USER);
            statement.setString(1,user.getEmail());
            statement.execute();
            con.close();
        }catch(ClassNotFoundException | SQLException e){
             e.getMessage();
            e.printStackTrace();
        }
    }
}
