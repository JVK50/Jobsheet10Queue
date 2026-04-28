package smt2.jobsheet10;

import java.util.Scanner;

public class MainKRS {

    public static void tampilkanMenu() {
        System.out.println("\n========================================");
        System.out.println("   SISTEM ANTRIAN KRS - DPA             ");
        System.out.println("========================================");
        System.out.println(" 1. Tambah Mahasiswa ke Antrian");
        System.out.println(" 2. Panggil Antrian Proses KRS (2 mhs)");
        System.out.println(" 3. Tampilkan Semua Antrian");
        System.out.println(" 4. Tampilkan 2 Antrian Terdepan");
        System.out.println(" 5. Tampilkan Antrian Paling Akhir");
        System.out.println(" 6. Cek Antrian Kosong");
        System.out.println(" 7. Cek Antrian Penuh");
        System.out.println(" 8. Kosongkan Antrian");
        System.out.println(" 9. Cetak Jumlah Antrian");
        System.out.println("10. Cetak Jumlah Sudah Proses KRS");
        System.out.println("11. Cetak Jumlah Belum Proses KRS");
        System.out.println(" 0. Keluar");
        System.out.println("----------------------------------------");
        System.out.print("Pilih menu: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // max antrian = 10, max mahasiswa ditangani DPA = 30
        AntrianKRS antrian = new AntrianKRS(10, 30);

        int pilihan;

        do {
            tampilkanMenu();
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("NIM   : ");
                    String nim = sc.nextLine();
                    System.out.print("Nama  : ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi : ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas : ");
                    String kelas = sc.nextLine();
                    Mahasiswa mhs = new Mahasiswa(nim, nama, prodi, kelas);
                    antrian.tambahAntrian(mhs);
                    break;

                case 2:
                    antrian.panggilAntrian();
                    break;

                case 3:
                    antrian.tampilkanSemua();
                    break;

                case 4:
                    antrian.tampilkan2Terdepan();
                    break;

                case 5:
                    antrian.lihatAkhir();
                    break;

                case 6:
                    if (antrian.isEmpty()) {
                        System.out.println("Antrian KOSONG.");
                    } else {
                        System.out.println("Antrian TIDAK kosong. Jumlah: " + antrian.getJumlahAntrian());
                    }
                    break;

                case 7:
                    if (antrian.isFull()) {
                        System.out.println("Antrian PENUH.");
                    } else {
                        System.out.println("Antrian BELUM penuh. Jumlah saat ini: " + antrian.getJumlahAntrian());
                    }
                    break;

                case 8:
                    antrian.kosongkanAntrian();
                    break;

                case 9:
                    antrian.cetakJumlahAntrian();
                    break;

                case 10:
                    antrian.cetakSudahKRS();
                    break;

                case 11:
                    antrian.cetakBelumKRS();
                    break;

                case 0:
                    System.out.println("Terima kasih. Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu 0-11.");
            }

        } while (pilihan != 0);

        sc.close();
    }
}
