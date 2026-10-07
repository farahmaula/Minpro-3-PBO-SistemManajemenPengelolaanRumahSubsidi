/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class RumahTersedia extends Rumah implements DapatSurvey {
    private int jumlahUnit;
    private String blokRumah;
    
    public RumahTersedia(String idRumah, String unit, String tipeRumah, double harga, int jumlahUnit, String blokRumah){
        super(idRumah, unit, tipeRumah, harga);
        
        setJumlahUnit(jumlahUnit);
        setBlokRumah(blokRumah);
    }
    
    public int getJumlahUnit() {
        return jumlahUnit;
    }

    public void setJumlahUnit(int jumlahUnit) {
        if (jumlahUnit > 0) {
            this.jumlahUnit = jumlahUnit;
        } else {
            System.out.println(">> Semua Unit Terjual!");
            this.jumlahUnit = 0;
        }
    }
    
    public String getBlokRumah() {
        return blokRumah;
    }
    
    public void setBlokRumah(String blokRumah) {
        this.blokRumah = blokRumah;
    }
    
    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("Jumlah Unit Rumah     : " + jumlahUnit);
        System.out.println("Blok Rumah Tersedia :" + blokRumah);
        System.out.println("Status     : " + getStatusRumah());
        cetakDataRumah();
    }
    
    @Override 
    public String getStatusRumah() {
        return "Tersedia";
    }
    
    @Override
    public void survey() {
        System.out.println("Dapat melakukan survey rumah unit " + getUnit() + " pada " + getBlokRumah());
    }
}
