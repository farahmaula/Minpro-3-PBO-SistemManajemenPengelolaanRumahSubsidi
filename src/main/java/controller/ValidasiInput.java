/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class ValidasiInput {
    
    // Validasi teks tidak boleh kosong
    public boolean isTeksValid(String teks) {
        if (teks == null) {
            return false;
        }
        if (teks.trim().length() == 0) {
            return false;
        }
        
        return true;
    }
    
    // Validasi hanya berisi angka
    public boolean isAngka(String teks) {
        if (!isTeksValid(teks)) {
            return false;
        }
        teks = teks.trim();
        for (int i = 0; i < teks.length(); i++) {
            char karakter = teks.charAt(i);
            if (karakter < '0' || karakter > '9') {
                return false;
            }
        }
        return true;
    }
    
    //Validasi Menu
    public boolean isPilihanValid(String teks) {
        return isAngka(teks);
    }

    // Validasi NIK 
    public boolean isNikValid(String teks) {
        if (!isAngka(teks)) {
            return false;
        }

        teks = teks.trim();
        return teks.length() == 16;
    }

    // Validasi nomor HP
    public boolean isNoHPValid(String teks) {
        if (!isAngka(teks)) {
            return false;
        }

        teks = teks.trim();
        if (!teks.startsWith("08")) {
            return false;
        }

        if (teks.length() < 10 || teks.length() > 13) {
            return false;
        }

        return true;
    }

    // Validasi ID Rumah
    public boolean isIdRumahValid(String teks) {
        if (!isTeksValid(teks)) {
            return false;
        }

        teks = teks.trim().toUpperCase();
        if (teks.length() != 4) {
            return false;
        }

        if (teks.charAt(0) != 'R') {
            return false;
        }

        String angka = teks.substring(1);
        return isAngka(angka);
    }

    // Validasi ID Dokumen
    public boolean isIdDokumenValid(String teks) {
        if (teks == null || teks.trim().isEmpty()) {
            return false;
        }

        for (char angka : teks.toCharArray()) {
            if (!Character.isDigit(angka)) {
                return false;
            }
        }
        return true;
    }

    // Validasi ID Pengajuan
    public boolean isIdPengajuanValid(String teks) {
        if (!isTeksValid(teks)) {
            return false;
        }

        teks = teks.trim().toUpperCase();
        if (teks.length() != 4) {
            return false;
        }

        if (teks.charAt(0) != 'P') {
            return false;
        }

        String angka = teks.substring(1);
        return isAngka(angka);
    }

    // Validasi angka lebih dari 0
    public boolean isAngkaPositif(String teks) {
        if (!isAngka(teks)) {
            return false;
        }

    try {
            double nilai = Double.parseDouble(teks.trim());
            return nilai > 0;
        } catch (NumberFormatException e) {
            return false; // Mengembalikan false jika dimasukkan huruf/simbol
        }
    }

    // Overload method jika parameter yang dikirim sudah berupa double
    public boolean isAngkaPositif(double nilai) {
        return nilai > 0;
    }
    
    // ERROR HANDLING INPUT ANGKA
    // Membaca input integer dengan validasi
    public int bacaInt(Scanner input) {

        while (true) {

            String teks = input.nextLine();

            if (isAngka(teks)) {
                return Integer.parseInt(teks.trim());
            }

            System.out.print(
                "Input harus berupa angka bulat. "
                + "Silakan masukkan lagi: "
            );
        }
    }

    // Membaca integer yang harus lebih dari 0
    public int bacaIntPositif(Scanner input) {

        while (true) {

            String teks = input.nextLine();

            if (isAngka(teks)) {

                int nilai = Integer.parseInt(teks.trim());

                if (nilai > 0) {
                    return nilai;
                }
            }

            System.out.print(
                "Input harus berupa angka lebih dari 0. "
                + "Silakan masukkan lagi: "
            );
        }
    }

    // Membaca double yang harus lebih dari 0
    public double bacaDoublePositif(Scanner input) {

        while (true) {

            String teks = input.nextLine();

            if (isAngkaPositif(teks)) {
                return Double.parseDouble(teks.trim());
            }

            System.out.print(
                "Input harus berupa angka lebih dari 0. "
                + "Silakan masukkan lagi: "
            );
        }
    }

    // Membaca pilihan tertentu, misalnya 1 sampai 2
    public int bacaPilihan(Scanner input, int min, int max) {

        while (true) {

            String teks = input.nextLine();

            if (isAngka(teks)) {

                int pilihan = Integer.parseInt(teks.trim());

                if (pilihan >= min && pilihan <= max) {
                    return pilihan;
                }
            }

            System.out.print(
                "Pilihan tidak valid. "
                + "Masukkan angka " + min + " sampai " + max + ": "
            );
        }
    }
}
