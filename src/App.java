import java.sql.*;
import java.util.Scanner;

public class App {
    static Connection con;

    public static void main(String[] args) throws Exception {
        Pembelian beli = new Pembelian(0, null, null, 0);
        Queue antrian = new Queue(10);
        Scanner input = new Scanner(System.in);
        boolean lanjutkan = true;
        int pilihan;
        int a = 0;

        String url = "jdbc:mysql://localhost:3306/tugasbesarpbo";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "");
            System.out.println("Database Terhubung!");

            while (lanjutkan) {//Perulangan
                System.out.println("");
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("        PROGRAM PEMBELIAN KONSOL GAME        ");
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("1. Masukan Data Konsol");
                System.out.println("2. Masuk Antrian Pelanggan");
                System.out.println("3. Keluar Antrian Pelanggan");
                System.out.println("4. Cek Antrian");
                System.out.println("5. Pembelian");
                System.out.println("6. Ubah Data");
                System.out.println("7. Cek Data Konsol");
                System.out.println("8. Cek Data Pembelian");
                System.out.println("9. Hapus Data Konsol");
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("");
                System.out.print("Masukkan Pilihan : ");
                pilihan = input.nextInt();

                switch (pilihan) {//Percabangan
                    case 1:
                        beli.idKonsol();
                        beli.merk();
                        beli.tipe();
                        beli.hargaKonsol();
                        beli.InsertDbKonsol();
                        break;

                    case 2:
                        antrian.CreateQueue();
                        antrian.displayQue();
                        a++;
                        break;
                
                    case 3:
                        antrian.removeQueue();
                        antrian.displayQue();
                        break;

                    case 4:
                        antrian.displayQue();
                        break;

                    case 5:
                        beli.Tampil();
                        beli.beli();
                        beli.totalharga();
                        beli.Tanggal();
                        beli.insertDBBeli();
                        break;

                    case 6:
                        beli.Tampil();
                        beli.ubah();
                        break;

                    case 7:
                        beli.Tampil();
                        break;

                    case 8:
                        beli.Tampil2();
                        break;

                    case 9:
                        beli.delete();
                        break;
                }

            }

        } catch (ClassNotFoundException ex) {
            System.err.println("Driver eror");
            System.exit(0);
        } catch (SQLException e) {
            System.err.println("Tidak berhasil Koneksi");
        }

    }
}
