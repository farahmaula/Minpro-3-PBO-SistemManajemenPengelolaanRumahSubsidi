/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Scanner;
import controller.ManajemenData;
import controller.ValidasiInput;
import view.SistemView;

/**
 *
 * @author ACER
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ManajemenData manajemen = new ManajemenData();
        SistemView view = new SistemView();
        ValidasiInput validasi = new ValidasiInput();
        int pilihan;

            do {
                System.out.println("\nSISTEM MANAJEMEN PENGELOLAAN RUMAH SUBSIDI");            
                System.out.println("1. Data Rumah Subsidi");
                System.out.println("2. Data Pembeli");
                System.out.println("3. Dokumen Persyaratan");
                System.out.println("4. Pengajuan Rumah Subsidi");
                System.out.println("0. Keluar");
                System.out.print("\nPilih menu: ");
                pilihan = validasi.bacaPilihan(input, 0, 4);

                switch (pilihan) {
                    case 1:
                        manajemen.menuRumah();
                        view.tampilRumah(manajemen.getDaftarRumah());
                        break;

                    case 2:
                        manajemen.menuPembeli();
                        view.tampilPembeli(manajemen.getDaftarPembeli());
                        break;

                    case 3:
                        manajemen.menuDokumen();
                        view.tampilDokumen(manajemen.getDaftarDokumen());
                        break;

                    case 4:
                        manajemen.menuPengajuan();
                        view.tampilPengajuan(manajemen.getDaftarPengajuan());
                        break;

                    case 0:
                        System.out.println("Program selesai.");
                        break;

                    default:
                        System.out.println("Menu tidak tersedia.");
                }
            }
            while (pilihan != 0);
    }
}
