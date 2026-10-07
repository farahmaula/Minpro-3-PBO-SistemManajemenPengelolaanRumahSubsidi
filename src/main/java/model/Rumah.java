/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public abstract class Rumah {
    private final String idRumah;
    private String unit;
    private String tipeRumah;
    private double harga;

    public Rumah(String idRumah, String unit, String tipeRumah, double harga) {
        this.idRumah = idRumah;
        this.unit = unit;
        this.tipeRumah = tipeRumah;
        this.harga = harga;  
    }

    public String getIdRumah() {
        return idRumah;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTipeRumah() {
        return tipeRumah;
    }

    public void setTipeRumah(String tipeRumah) {
        this.tipeRumah = tipeRumah;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
    
    public abstract String getStatusRumah();

    public void tampilkanData() {
        System.out.println("ID Rumah      : " + this.idRumah);
        System.out.println("Unit          : " + this.unit);
        System.out.println("Tipe Rumah    : " + this.tipeRumah);
        System.out.println("Harga         : Rp. " + this.harga);
    }
    
    //Overloading
    public final void cetakDataRumah () {
        System.out.println("Data Rumah Tersimpan");
    }
    
    public final void cetakDataRumah(String keterangan) {
        System.out.println("Data Rumah: " + keterangan);
    }
}
