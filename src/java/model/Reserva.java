/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
/**
 *
 * @author alunos
 */
public class Reserva {
    private int id;
    private Hospede hospede;
    private Date diaDaReserva ;
    private Date expiracao;
    private int diasReservados;
    private boolean servicosAdicionais = false;
    private double diaria;
    private Agencia agencia;//opcional
    private double despesasTotais;
    private Quarto quarto;
}
