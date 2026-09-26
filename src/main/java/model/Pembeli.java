/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class Pembeli {
    private String nik;
    private String nama;
    private double penghasilan;
    private String noHP;
    private String statusPunyaRumah;

    public Pembeli(String nik, String nama, double penghasilan, String noHP, String statusPunyaRumah){
        this.nik = nik;
        this.nama = nama;
        this.penghasilan = penghasilan;
        this.noHP = noHP;
        this.statusPunyaRumah = statusPunyaRumah;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getPenghasilan() {
        return penghasilan;
    }

    public void setPenghasilan(double penghasilan) {
        this.penghasilan = penghasilan;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }
    
    public String getStatusPunyaRumah() {
        return statusPunyaRumah;
    }

    public void setStatusPunyaRumah(String statusPunyaRumah) {
        this.statusPunyaRumah = statusPunyaRumah;
    }    

    public void tampilkanData() {
        System.out.println("NIK         : " + nik);
        System.out.println("Nama        : " + nama);
        System.out.println("Penghasilan : Rp. " + penghasilan);
        System.out.println("No HP       : " + noHP);
        System.out.println("Sudah Punya Rumah  : " + statusPunyaRumah);
    }
}
