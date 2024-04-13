/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author alunos
 */
public class Reserva {
    private long id;
    private Hospede hospede;
    private String diaDaReserva ;
    private String expiracao;
    private int diasReservados;
    private byte servicosAdicionais = 0;
    private double diaria;
    private Agencia agencia;
    private double despesasTotais;
    private Quarto quarto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public String getDiaDaReserva() {
        return diaDaReserva;
    }

    public void setDiaDaReserva(String diaDaReserva) {
        this.diaDaReserva = diaDaReserva;
    }

    public String getExpiracao() {
        return expiracao;
    }

    public void setExpiracao(String expiracao) {
        this.expiracao = expiracao;
    }

    public int getDiasReservados() {
        return diasReservados;
    }

    public void setDiasReservados(int diasReservados) {
        this.diasReservados = diasReservados;
    }

    public byte getServicosAdicionais() {
        return servicosAdicionais;
    }

    public void setServicosAdicionais(byte servicosAdicionais) {
        this.servicosAdicionais = servicosAdicionais;
    }

    public double getDiaria() {
        return diaria;
    }

    public void setDiaria(double diaria) {
        this.diaria = diaria;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public double getDespesasTotais() {
        return despesasTotais;
    }

    public void setDespesasTotais(double despesasTotais) {
        this.despesasTotais = despesasTotais;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
    
    
}
