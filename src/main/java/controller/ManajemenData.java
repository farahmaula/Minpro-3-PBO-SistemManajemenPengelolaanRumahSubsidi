/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Rumah;
import model.RumahTersedia;
import model.RumahTerjual;
import model.Rumah;
import model.Pembeli;
import model.Pengajuan;
import model.Dokumen;

/**
 *
 * @author ACER
 */
public class ManajemenData {
    Scanner input = new Scanner(System.in);
    private ValidasiInput validasi = new ValidasiInput();
    ArrayList<Rumah> daftarRumah = new ArrayList<>();
    ArrayList<Pembeli> daftarPembeli = new ArrayList<>();
    ArrayList<Pengajuan> daftarPengajuan = new ArrayList<>();
    ArrayList<Dokumen> daftarDokumen = new ArrayList<>();
    
    public ManajemenData() {
        RumahTersedia rumahDummy = new RumahTersedia(
                "R001", 
                "A01", 
                "3x6", 
                150000000,
                8,
                "Blok Lily");
            daftarRumah.add(rumahDummy);
        
        Pembeli pembeliDummy = new Pembeli(
                "6472056767280002", 
                "Anggita Melastri", 
                5000000, 
                "085612789355", 
                "Tidak");
            daftarPembeli.add(pembeliDummy);
      
        Pengajuan pengajuanDummy = new Pengajuan(
                "P001", 
                "6472056767280002", 
                "R101", 
                "Menunggu Verifikasi");
            daftarPengajuan.add(pengajuanDummy);
            
        Dokumen dokumenDummy = new Dokumen(
                "D001", 
                "6472056767280002", 
                "KTP", 
                "Terverifikasi");
            daftarDokumen.add(dokumenDummy);

}

    // MENU rumah
    
    public void menuRumah() {
        int pilihan;

        do {
            System.out.println("\nMANAJEMEN DATA RUMAH");
            System.out.println("1. Tambah Rumah");
            System.out.println("2. Lihat Rumah");
            System.out.println("3. Ubah Rumah");
            System.out.println("4. Hapus Rumah");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tambahRumah();
                    break;

                case 2:
                    tampilRumah();
                    break;

                case 3:
                    ubahRumah();
                    break;

                case 4:
                    hapusRumah();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }
        } while (pilihan != 0);

    }

    public void tambahRumah() {
        System.out.println("Contoh ID Rumah : R000");
        System.out.println("=======================\n");
        System.out.print("ID Rumah: ");
        String id = input.nextLine();
        
        if (!validasi.isIdRumahValid(id)) {
            System.out.println("ID Rumah Tidak Valid");
            return;
        }

        for (Rumah rumah : daftarRumah) {
            if (rumah.getIdRumah().equalsIgnoreCase(id)) {
                System.out.println("ID Rumah sudah tersedia.");
                return;
            }
        }

        System.out.println("Contoh Unit : A1");
        System.out.println("==================\n");
        System.out.print("Unit: ");
        String unit = input.nextLine();
        
        if (!validasi.isTeksValid(unit)) {
            System.out.println("Unit tidak boleh kosong");
            return;
        }
        
        System.out.println("Contoh Tipe Rumah : 3x5");
        System.out.println("=======================\n");
        System.out.print("Tipe Rumah: ");
        String tipe = input.nextLine();
        
        if (!validasi.isTeksValid(tipe)) {
            System.out.println("Tipe rumah tidak boleh kosong.");
            return;
        }
        
        System.out.println("Contoh Harga : 1000000");
        System.out.println("=======================\n");
        System.out.print("Harga: ");
        double harga = input.nextDouble();
        input.nextLine();

        if (harga <= 0) {
            System.out.println("Harga tidak valid.");
            return;
        }
        
        System.out.println("Contoh Jumlah Unit : 10");
        System.out.println("========================\n");
        System.out.print("Jumlah Unit: ");
        int jumlahUnit = input.nextInt();
        input.nextLine();

        if (jumlahUnit <= 0) {
            System.out.println("Jumlah unit harus lebih dari 0.");
            return;
        }
        
        System.out.println("Contoh Blok Rumah : Blok Mawar");
        System.out.println("=======================\n");
        System.out.print("Blok Rumah: ");
        String blokRumah = input.nextLine();

        if (blokRumah.trim().isEmpty()) {
            System.out.println("Blok rumah tidak boleh kosong.");
            return;
        }
        
        // Polymorphic Collection: ArrayList bertipe Superclass (Rumah)
        Rumah rumahBaru = new RumahTersedia(id, unit, tipe, harga, jumlahUnit, blokRumah);
        daftarRumah.add(rumahBaru);

        System.out.println("Rumah subsidi berhasil ditambahkan.");
    }

    public void tampilRumah() {
        System.out.println("\nDAFTAR RUMAH");
        if (daftarRumah.isEmpty()) {
            System.out.println("Data rumah masih kosong.");
            return;
        }

        //Panggil Method Overide
        for (Rumah rumah : daftarRumah) {
            System.out.println("\n==== Rumah Subsidi ====");            
            rumah.tampilkanData();
            System.out.println("=========================");
        }
    }

    public void ubahRumah() {
        System.out.println("Contoh ID Rumah : R000");
        System.out.println("=======================\n");
        System.out.print("Masukkan ID Rumah: ");
        String id = input.nextLine();
        
        if (!validasi.isIdRumahValid(id)) {
            System.out.println("ID Rumah Tidak Valid");
            return;
        }

        for (Rumah rumah : daftarRumah) {
            if (rumah.getIdRumah().equalsIgnoreCase(id)) {
                System.out.println("Contoh Unit : A1");
                System.out.println("=======================\n");
                System.out.print("Jumlah Unit Baru: ");
                String unit = input.nextLine();
                if (!validasi.isTeksValid(unit)) {
                    System.out.println("Unit tidak boleh kosong");
                    return;
                }
                
                System.out.println("Contoh Tipe Rumah : 3x5");
                System.out.println("=======================\n");
                System.out.print("Tipe Rumah Baru: ");
                String tipe = input.nextLine();
                if (!validasi.isTeksValid(tipe)) {
                    System.out.println("Tipe rumah tidak boleh kosong.");
                    return;
                }
                
                System.out.println("Contoh Harga : 2000000");
                System.out.println("=======================\n");
                System.out.print("Harga Baru: ");
                double harga = input.nextDouble();
                input.nextLine();

                if (harga <= 0) {
                    System.out.println("Harga tidak valid.");
                    return;
                }

                rumah.setUnit(unit);
                rumah.setTipeRumah(tipe);
                rumah.setHarga(harga);
                System.out.println("Data rumah berhasil diubah.");
                return;
            }
        }
        System.out.println("ID Rumah tidak ditemukan.");
    }

    public void hapusRumah() {
        System.out.println("Contoh : R000");
        System.out.println("=======================\n");
        System.out.print("Masukkan ID Rumah: ");
        String id = input.nextLine();
        if (!validasi.isIdRumahValid(id)) {
            System.out.println("ID Rumah Tidak Valid");
            return;
        }

        for (int i = 0; i < daftarRumah.size(); i++) {
            if (daftarRumah.get(i).getIdRumah().equalsIgnoreCase(id)) {
                daftarRumah.remove(i);
                System.out.println("Data rumah berhasil dihapus.");
                return;
            }
        }
        System.out.println("ID Rumah tidak ditemukan.");
    }
    
    // MENU Pembeli

    public void menuPembeli() {
        int pilihan;

        do {
            System.out.println("\nMANAJEMEN DATA PEMBELI");
            System.out.println("1. Tambah Pembeli");
            System.out.println("2. Lihat Pembeli");
            System.out.println("3. Ubah Pembeli");
            System.out.println("4. Hapus Pembeli");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tambahPembeli();
                    break;

                case 2:
                    tampilPembeli();
                    break;

                case 3:
                    ubahPembeli();
                    break;

                case 4:
                    hapusPembeli();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }
        } while (pilihan != 0);
    }

    public void tambahPembeli() {
        System.out.println("Contoh NIK : 6472056767280002");
        System.out.println("==============================\n");
        System.out.print("NIK: ");
        String nik = input.nextLine();
        if (!validasi.isNikValid(nik)) {
            System.out.println("NIK harus 16 digit");
            return;
        }

        for (Pembeli pembeli : daftarPembeli) {
            if (pembeli.getNik().equals(nik)) {
                System.out.println("NIK sudah terdaftar.");
                return;
            }
        }

        if (nik.length() != 16) {
            System.out.println("NIK harus 16 digit.");
            return;
        }

        System.out.println("Contoh Nama : Anggita Melastri");
        System.out.println("===============================\n");
        System.out.print("Nama: ");
        String nama = input.nextLine();
        if (!validasi.isTeksValid(nama)) {
            System.out.println("Nama tidak boleh kosong");
            return;
        }
        
        System.out.println("Contoh Penghasilan: 2000000");
        System.out.println("=======================\n");
        System.out.print("Penghasilan: ");
        String inputPenghasilan = input.nextLine();
        if (!validasi.isAngkaPositif(inputPenghasilan)) {
            System.out.println("Penghasilan berupa angka dan lebih dari 0");
            return;
        }
        double penghasilan = Double.parseDouble(inputPenghasilan);
        
        System.out.println("Contoh No HP: 085612789355");
        System.out.println("=======================\n");
        System.out.print("No HP: ");
        String noHP = input.nextLine();
        if (!validasi.isNoHPValid(noHP)){
            System.out.println("No HP tidak boleh kosong");
            return;
        }
        
        System.out.println("Sudah memiliki rumah?");
        System.out.println("1. Ya");
        System.out.println("2. Tidak");
        System.out.print("Pilih: ");
        int pilihan = input.nextInt();
        input.nextLine();
        String statusRumah;

        if (pilihan == 1) {
            statusRumah = "Ya";
        } else if (pilihan == 2) {
            statusRumah = "Tidak";
        } else {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        Pembeli pembeliBaru = new Pembeli(nik, nama, penghasilan, noHP, statusRumah);
        daftarPembeli.add(pembeliBaru);
        System.out.println("Pembeli berhasil ditambahkan.");
    }

    public void tampilPembeli() {
        System.out.println("\nDAFTAR PEMBELI");
        
        if (daftarPembeli.isEmpty()) {
            System.out.println("Data pembeli masih kosong.");
            return;
        }

        for (Pembeli pembeli : daftarPembeli) {
            System.out.println("\n=========================");
            pembeli.tampilkanData();
            System.out.println("=========================");
        }
    }

    public void ubahPembeli() {
        System.out.println("Contoh NIK : 6472056767280002");
        System.out.println("=============================\n");
        System.out.print("Masukkan NIK: ");
        String nik = input.nextLine();
        if (!validasi.isNikValid(nik)) {
            System.out.println("NIK harus 16 digit");
            return;
        }

        for (Pembeli pembeli : daftarPembeli) {
            if (pembeli.getNik().equals(nik)) {
                System.out.println("Contoh Penghasilan : 2000000");
                System.out.println("=======================\n");
                System.out.print("Penghasilan Baru: ");
                double penghasilan = input.nextDouble();
                input.nextLine();
                if (!validasi.isAngkaPositif(penghasilan)) {
                    System.out.println("Penghasilan berupa angka dan lebih dari 0");
                    return;
                }
                
                System.out.println("Contoh No HP : 085612789355");
                System.out.println("=======================\n");
                System.out.print("No HP Baru: ");
                String noHP = input.nextLine();
                if (!validasi.isNoHPValid(noHP)){
                    System.out.println("No HP tidak boleh kosong");
                    return;
                }
                
                pembeli.setPenghasilan(penghasilan);
                pembeli.setNoHP(noHP);
                System.out.println("Data pembeli berhasil diubah.");
                return;
            }
        }
        System.out.println("NIK tidak ditemukan.");
    }

    public void hapusPembeli() {
        System.out.println("Contoh NIK : 6472056767280002");
        System.out.println("=======================\n");
        System.out.print("Masukkan NIK: ");
        String nik = input.nextLine();
        if (!validasi.isNikValid(nik)) {
            System.out.println("NIK harus 16 digit");
            return;
        }

        for (int i = 0; i < daftarPembeli.size(); i++) {
            if (daftarPembeli.get(i).getNik().equals(nik)) {
                daftarPembeli.remove(i);
                System.out.println("Data pembeli berhasil dihapus.");
                return;
            }
        }
        System.out.println("NIK tidak ditemukan.");
    }

    // MENU pengajuan

    public void menuPengajuan() {
        int pilihan;

        do {
            System.out.println("\nMANAJEMEN PENGAJUAN");
            System.out.println("1. Tambah Pengajuan");
            System.out.println("2. Lihat Pengajuan");
            System.out.println("3. Proses Pengajuan");
            System.out.println("4. Pembayaran");
            System.out.println("5. Hapus Pengajuan");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();
            switch (pilihan) {
                case 1:
                    tambahPengajuan();
                    break;

                case 2:
                    tampilPengajuan();
                    break;

                case 3:
                    prosesPengajuan();
                    break;

                case 4:
                    pembayaran();
                    break;
                    
                case 5:
                    hapusPengajuan();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }
        } while (pilihan != 0);
    }

    public void tambahPengajuan() {
        System.out.println("Contoh : P000");
        System.out.println("=======================\n");
        System.out.print("ID Pengajuan: ");
        String idPengajuan = input.nextLine();
        if (validasi.isIdDokumenValid(idPengajuan)){
            System.out.println("Sesuaikan Format ID Dokumen Seperti Contoh");
            return;
        }

        for (Pengajuan pengajuan : daftarPengajuan) {
            if (pengajuan.getIdPengajuan().equalsIgnoreCase(idPengajuan)) {
                System.out.println("ID Pengajuan sudah tersedia.");
                return;
            }
        }

        System.out.println("Contoh NIK : 6472056767280002");
        System.out.println("=======================\n");
        System.out.print("NIK Pembeli: ");
        String nik = input.nextLine();
        Pembeli pembeliDipilih = null;
        if (!validasi.isNikValid(nik)) {
            System.out.println("NIK harus 16 digit");
            return;
        }

        for (Pembeli pembeli : daftarPembeli) {
            if (pembeli.getNik().equals(nik)) {
                pembeliDipilih = pembeli;
                break;
            }
        }

        if (pembeliDipilih == null) {
            System.out.println("Pembeli tidak ditemukan.");
            return;
        }

        if (pembeliDipilih.getPenghasilan() < 2000000) {
            System.out.println("Pengajuan tidak dapat dibuat.");
            System.out.println("Penghasilan pembeli kurang dari Rp2.000.000.");
            System.out.println("Penghasilan belum memadai untuk mengajukan rumah subsidi.");
            return;
        }
        
        System.out.println("Contoh ID Rumah : R000");
        System.out.println("=======================\n");
        System.out.print("ID Rumah: ");
        String idRumah = input.nextLine();
        boolean rumahTersedia = false;
        if (!validasi.isIdRumahValid(idRumah)) {
            System.out.println("ID Rumah Tidak Valid");
            return;
        }

        for (Rumah rumah : daftarRumah) {
            if (rumah.getIdRumah().equalsIgnoreCase(idRumah)) {
                rumahTersedia = true;
                break;
            }
        }

        if (!rumahTersedia) {
            System.out.println("Rumah tidak ditemukan atau tidak tersedia.");
            return;
        }

        Pengajuan pengajuanBaru = new Pengajuan(idPengajuan, nik, idRumah, "Menunggu Verifikasi");
        daftarPengajuan.add(pengajuanBaru);
        System.out.println("Pengajuan berhasil dibuat.");
        System.out.println("Status: Menunggu Verifikasi");
    }

    public void tampilPengajuan() {
        if (daftarPengajuan.isEmpty()) {
            System.out.println("Data pembayaran masih kosong.");
            return;
        }

        for (Pengajuan pembayaran : daftarPengajuan) {
            System.out.println("\n=========================");
            pembayaran.tampilkanData();
            System.out.println("=========================");
        }
    }

    public void prosesPengajuan() {
        System.out.println("Contoh ID Pengajuan : P000");
        System.out.println("=======================\n");
        System.out.print("Masukkan ID Pengajuan: ");
        String id = input.nextLine();
        if (validasi.isIdDokumenValid(id)){
            System.out.println("Sesuaikan Format ID Dokumen Seperti Contoh");
            return;
        }

        for (Pengajuan pengajuan : daftarPengajuan) {
            if (pengajuan.getIdPengajuan().equalsIgnoreCase(id)) {
                System.out.println("\nDATA PENGAJUAN");
                pengajuan.tampilkanData();
                System.out.print("\nApakah data pengajuan sudah sesuai? (y/t): ");
                String konfirmasi = input.nextLine();

                if (!konfirmasi.equalsIgnoreCase("y")) {
                    System.out.println("Proses pengajuan dibatalkan.");
                    return;
                }

                Pembeli pembeliDipilih = null;

                for (Pembeli pembeli : daftarPembeli) {
                    if (pembeli.getNik().equals(
                            pengajuan.getNikPembeli())) {

                        pembeliDipilih = pembeli;
                        break;
                    }
                }

                if (pembeliDipilih == null) {
                    System.out.println("Data pembeli tidak ditemukan.");
                    return;
                }

                if (pembeliDipilih.getPenghasilan() < 2000000) {
                    pengajuan.setStatusPengajuan("Ditolak");

                    System.out.println("Pengajuan DITOLAK.");
                    System.out.println(
                            "Penghasilan pembeli kurang dari Rp2.000.000.");
                    System.out.println(
                            "Penghasilan belum memadai untuk pengajuan.");
                    return;
                }

                if (pembeliDipilih.getStatusPunyaRumah()
                        .equalsIgnoreCase("Ya")) {

                    pengajuan.setStatusPengajuan("Ditolak");

                    System.out.println("Pengajuan DITOLAK.");
                    System.out.println(
                            "Pembeli sudah memiliki rumah.");
                    return;
                }

                boolean ktp = false;

                for (Dokumen dokumen : daftarDokumen) {

                    if (dokumen.getNikPembeli().equals(pengajuan.getNikPembeli()) && dokumen.getStatusVerifikasi().equalsIgnoreCase("Terverifikasi")) {
                        if (dokumen.getNamaDokumen().equalsIgnoreCase("KTP")) {
                            ktp = true;
                        }
                    }
                }

                if (!ktp) {
                    System.out.println("Pengajuan belum dapat disetujui.");
                    System.out.println("Dokumen pembeli belum lengkap atau belum terverifikasi.");
                    System.out.println("\nDokumen yang belum terpenuhi:");

                    if (!ktp) {
                        System.out.println("- KTP");
                    }
                    return;
                }

                pengajuan.setStatusPengajuan("Disetujui");

                System.out.println("\nPengajuan DISETUJUI.");
                System.out.println(
                        "Seluruh persyaratan telah terpenuhi.");
                return;
            }
        }
        System.out.println("ID Pengajuan tidak ditemukan.");
    }
    
    public void pembayaran() {
        System.out.println("Contoh ID Pengajuan : P000");
        System.out.println("=======================\n");
        System.out.print("Masukkan ID Pengajuan: ");
        String id = input.nextLine();
        if (!validasi.isIdPengajuanValid(id)){
            System.out.println("Sesuaikan Format ID Pengajuan Seperti Contoh");
            return;
        }

        boolean ditemukanPengajuan = false;
        for (Pengajuan pengajuan : daftarPengajuan) {
            if (pengajuan.getIdPengajuan().equalsIgnoreCase(id)) {
                ditemukanPengajuan = true;
                if (!pengajuan.getStatusPengajuan().equalsIgnoreCase("Disetujui")) {
                    System.out.println("Pembayaran tidak dapat dilakukan.");
                    System.out.println("Pengajuan belum disetujui.");
                    return;
                }
                
                if (pengajuan.getMetodePembayaran() != null
                    && !pengajuan.getMetodePembayaran()
                    .equalsIgnoreCase("Belum Ada")
                    && !pengajuan.getMetodePembayaran().isEmpty()
                    && pengajuan.getJumlahBayar() > 0) {


                System.out.println(
                "Pembayaran sudah dilakukan."
                );


                System.out.println(
                "Metode Pembayaran : "
                + pengajuan.getMetodePembayaran()
                );


                System.out.println(
                "Jumlah Bayar : Rp. "
                + pengajuan.getJumlahBayar()
                );


                return;

            }

                
                System.out.println("Metode Pembayaran:");
                System.out.println("1. Cash");
                System.out.println("2. Cicilan");
                System.out.print("Pilih: ");
                String pilihan = input.nextLine();
                if (!validasi.isPilihanValid(pilihan)){
                    System.out.println("Pilihan berupa angka");
                    return;
                }

                if (pilihan.equals("1")) {
                    System.out.println("Contoh : 1000000");
                    System.out.print("Jumlah Bayar: ");
                    double jumlah = input.nextDouble();
                    input.nextLine();
                    if (!validasi.isAngkaPositif(jumlah)){
                        System.out.println("Harus lebih dari 0");
                        return;
                    }

                    if (jumlah <= 0) {
                        System.out.println("Jumlah pembayaran tidak valid.");
                        return;
                    }

                    pengajuan.setMetodePembayaran("Cash");
                    pengajuan.setJumlahBayar(jumlah);
                    System.out.println("Pembayaran cash berhasil disimpan.");
                }
                
                else if (pilihan.equals("2")) {
                    Pembeli pembeliDipilih = null;

                    for (Pembeli pembeli : daftarPembeli) {
                        if (pembeli.getNik().equals(pengajuan.getNikPembeli())) {
                            pembeliDipilih = pembeli;
                            break;
                        }
                    }

                    if (pembeliDipilih == null) {
                        System.out.println("Data pembeli tidak ditemukan.");
                        return;
                    }

                    double cicilan = pembeliDipilih.getPenghasilan() * 0.30;
                    pengajuan.setMetodePembayaran("Cicilan");
                    pengajuan.setJumlahBayar(cicilan);
                    System.out.println("\nPembayaran cicilan berhasil ditentukan.");
                    System.out.println("Penghasilan Pembeli : Rp. " + pembeliDipilih.getPenghasilan());
                    System.out.println("Persentase Cicilan  : 30%");
                    System.out.println("Cicilan Per Bulan   : Rp. " +  cicilan);

                }
                else {
                    System.out.println("Pilihan metode pembayaran tidak valid.");
                }
                
                System.out.println("\n=== DATA PENJUALAN RUMAH ===");
                System.out.println("Contoh tanggal: 21 Juni 2030");
                System.out.print("Tanggal Jual: ");
                String tanggalJual = input.nextLine();

                if (tanggalJual.trim().isEmpty()) {
                    System.out.println("Tanggal jual tidak boleh kosong.");
                    return;
                }
                
                boolean ditemukan = false;
                for (int i = 0; i < daftarRumah.size(); i++) {
                    Rumah rumah = daftarRumah.get(i);

                    if (rumah.getIdRumah().equalsIgnoreCase(pengajuan.getIdRumah())) {
                
                        RumahTerjual rumahLaku = new RumahTerjual(rumah.getIdRumah(), rumah.getUnit(), rumah.getTipeRumah(), rumah.getHarga(), tanggalJual);
                        daftarRumah.set(i, rumahLaku);
                        System.out.println("Rumah Telah TERJUAL.");
                        ditemukan = true;
                        break;
                    }
                }
            }
        }
        if (!ditemukanPengajuan) {
            System.out.println("ID Pengajuan tidak ditemukan.");
        }
    }

    public void hapusPengajuan() {
        System.out.println("Contoh : P000");
        System.out.println("=======================\n");
        System.out.print("Masukkan ID Pengajuan: ");
        String id = input.nextLine();
        if (validasi.isIdPengajuanValid(id)){
            System.out.println("Sesuaikan Format ID Dokumen Seperti Contoh");
            return;
        }

        for (int i = 0; i < daftarPengajuan.size(); i++) {
            if (daftarPengajuan.get(i).getIdPengajuan().equalsIgnoreCase(id)) {
                daftarPengajuan.remove(i);
                System.out.println("Pengajuan berhasil dihapus.");
                return;
            }
        }
        System.out.println("ID Pengajuan tidak ditemukan.");
    }

    // MENU Dokumen

    public void menuDokumen() {
        int pilihan;

        do {
            System.out.println("\nMANAJEMEN DOKUMEN");
            System.out.println("1. Tambah Dokumen");
            System.out.println("2. Lihat Dokumen");
            System.out.println("3. Verifikasi Dokumen");
            System.out.println("4. Hapus Dokumen");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tambahDokumen();
                    break;

                case 2:
                    tampilDokumen();
                    break;

                case 3:
                    verifikasiDokumen();
                    break;

                case 4:
                    hapusDokumen();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }
        } while (pilihan != 0);
    }

    public void tambahDokumen() {
        System.out.println("Contoh ID Dokumen : D000");
        System.out.println("=======================\n");
        System.out.print("ID Dokumen: ");
        String id = input.nextLine();
        if (validasi.isIdDokumenValid(id)){
            System.out.println("Sesuaikan Format ID Dokumen Seperti Contoh");
            return;
        }

        for (Dokumen dokumen : daftarDokumen) {
            if (dokumen.getIdDokumen().equalsIgnoreCase(id)) {
                System.out.println("ID Dokumen sudah tersedia.");
                return;
            }
        }

        System.out.println("Contoh NIK : 6472056767280002");
        System.out.println("=======================\n");
        System.out.print("NIK Pembeli: ");
        String nik = input.nextLine();
        boolean pembeliAda = false;
        if (!validasi.isNikValid(nik)) {
            System.out.println("NIK harus 16 digit");
            return;
        }

        for (Pembeli pembeli : daftarPembeli) {
            if (pembeli.getNik().equals(nik)) {
                pembeliAda = true;
                break;
            }
        }

        if (!pembeliAda) {
            System.out.println("Pembeli tidak ditemukan.");
            return;
        }

        System.out.println("Jenis Dokumen:");
        System.out.println("1. KTP");
        System.out.println("2. Surat Keterangan Belum Memiliki Rumah");
        System.out.print("Pilih: ");
        int pilihan = input.nextInt();
        input.nextLine();
        String jenis;
        switch (pilihan) {
            case 1:
                jenis = "KTP";
                break;

            case 2:
                jenis = "Surat Keterangan Belum Memiliki Rumah";
                break;

            default:
                System.out.println("Jenis dokumen tidak valid.");
                return;
        }

        Dokumen dokumenBaru = new Dokumen(id, nik, jenis, "Belum Terverifikasi");
        daftarDokumen.add(dokumenBaru);
        System.out.println("Dokumen berhasil ditambahkan.");
    }

    public void tampilDokumen() {
        if (daftarDokumen.isEmpty()) {
            System.out.println("Data dokumen masih kosong.");
            return;
        }

        for (Dokumen dokumen : daftarDokumen) {
            System.out.println("\n=========================");
            dokumen.tampilkanData();
            System.out.println("=========================");
        }
    }

    public void verifikasiDokumen() {
        System.out.println("Contoh ID Dokumen : D000");
        System.out.println("=======================\n");
        System.out.print("Masukkan ID Dokumen: ");
        String id = input.nextLine();
        if (validasi.isIdDokumenValid(id)){
            System.out.println("Sesuaikan Format ID Dokumen Seperti Contoh");
            return;
        }

        for (Dokumen dokumen : daftarDokumen) {
            if (dokumen.getIdDokumen().equalsIgnoreCase(id)) {
                dokumen.setStatusVerifikasi("Terverifikasi");
                System.out.println("Dokumen berhasil diverifikasi.");
                return;
            }
        }
        System.out.println("ID Dokumen tidak ditemukan.");
    }

    public void hapusDokumen() {
        System.out.println("Contoh ID Dokumen : D000");
        System.out.println("=======================\n");
        System.out.print("Masukkan ID Dokumen: ");
        String id = input.nextLine();
        if (validasi.isIdDokumenValid(id)){
            System.out.println("Sesuaikan Format ID Dokumen Seperti Contoh");
            return;
        }

        for (int i = 0; i < daftarDokumen.size(); i++) {
            if (daftarDokumen.get(i).getIdDokumen().equalsIgnoreCase(id)) {
                daftarDokumen.remove(i);
                System.out.println("Dokumen berhasil dihapus.");
                return;
            }
        }
        System.out.println("ID Dokumen tidak ditemukan.");
    }
    
    public ArrayList<Rumah> getDaftarRumah(){
        return daftarRumah;
    }

    public ArrayList<Pembeli> getDaftarPembeli(){
        return daftarPembeli;
    }

    public ArrayList<Pengajuan> getDaftarPengajuan(){
        return daftarPengajuan;
    }

    public ArrayList<Dokumen> getDaftarDokumen(){
        return daftarDokumen;
    }


}
