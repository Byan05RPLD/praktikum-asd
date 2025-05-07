class MainKRS {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        AntrianKRS antrian = new AntrianKRS(5);
        int pilih;

        do {
            System.out.println(":\n==== Menu Persetujuan KRS ====");
            System.out.println("1. Tambah Mahasiswa ke Antrian");
            System.out.println("2. Proses KRS (2 mahasiswa sekaligus)");
            System.out.println("3. Lihat Semua Antrian");
            System.out.println("4. Lihat Mahasiswa Terdepan");
            System.out.println("5. Lihat Mahasiswa Terakhir");
            System.out.println("6. Cek Jumlah Antrian");
            System.out.println("7. Cek Jumlah Mahasiswa Belum Proses KRS");
            System.out.println("8. Cek Jumlah Mahasiswa");
            System.out.println("9. Kosongkan Antrian");
            System.out.println("0. keluar");
            System.out.print("Pilih menu:");
            pilih = sc.nextInt(); sc.nextLine();

            switch (pilih) {
                case 1: {
                    System.out.print("NIM : "); String nim = sc.nextLine();
                    System.out.print("Nama : "); String nama = sc.nextLine();
                    System.out.print("Prodi : "); String prodi = sc.nextLine();
                    System.out.print("Kelas : "); String kelas = sc.nextLine();
                    antrian.enqueue(new MahasiswaKRS(nim, nama, prodi, kelas));
                    System.out.println(nama + " berhasil masuk ke antrian.");
                    break;
                }
                case 2: 
                    antrian.prosesKRS();
                    break;
                
                case 3: 
                    antrian.tampilkanSemua();
                    break;
                
                case 4: 
                    antrian.tampilkanTerdepan();
                    break;
                
                case 5: 
                    antrian.tampilkanBelakang();
                    break;
                
                case 6: 
                    System.out.println("Jumlah Antrian: " + antrian.getJumlahAntrian());
                    break;
                
                case 7: 
                    System.out.println("Jumlah Mahasiswa Belum Proses KRS: " + antrian.getJumlahDiproses());
                    break;
                
                case 8: 
                    System.out.println("Jumlah Mahasiswa: " + antrian.getSisaMahasiswa());
                    break;
                
                case 9: 
                    antrian.clear();
                    System.out.println("Antrian dikosongkan");
                    break;
                case 0: 
                    System.out.println("Keluar");
                    break;

                default: 
                    System.out.println("Pilihan tidak valid");
                }
            
        } while (pilih != 0);
    }
}