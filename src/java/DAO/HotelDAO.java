/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import model.Hotel;
import util.FabricaConexao;

/**
 *
 * @author mariailsa
 */
public class HotelDAO {
    private static final String GetHotelInfo = "select * from hotel";
    public Hotel getHotelIntel(){
        Hotel hotel = new Hotel();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement statement = con.prepareStatement(GetHotelInfo);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                hotel.setCapacidade(result.getInt("capacidade"));
                hotel.setNome(result.getString("nome"));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException errConn) {
            errConn.getMessage();
            errConn.printStackTrace(); 
        }
        
        return hotel;
    }
}
