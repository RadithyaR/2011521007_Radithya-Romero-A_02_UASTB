import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.util.zip.DataFormatException;
import java.sql.*;

public class Pembelian extends Konsol { //Subclass

  String url = "jdbc:mysql://localhost:3306/tugasbesarpbo";
  
  Integer noBeli;

  public Pembelian(Integer id, String merk, String tipe, Integer harga) {
    super(id, merk, tipe, harga);
  }

  @Override
  public void beli() {
    System.out.print("\n\nInputkan Pembelian!!!");
    System.out.print("\nMasukan Nomor Pembelian\t:");
    noBeli = input.nextInt();
    idKonsol();
    merk();
    tipe();
    hargaKonsol();
  }
  
  @Override
  public void totalharga() {
    System.out.print("Masukan Jumlah Konsol yang Dibeli :");
    jumlah = input.nextInt();
    total = jumlah * harga;
    System.out.print("Harga Total : " + total + "\n");
  }

  public String Tanggal() {//date
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    return dateFormat.format(date);
  }

  public void insertDBBeli() throws SQLException {
    String sql = "INSERT INTO transaksifix (Nomor_Pembelian,idGame,merk,tipe,jumlah,hargaTotal,Tanggal) VALUES ('"+ noBeli + "','"  + id + "','" + merk + "','" + tipe + "','" + jumlah + "','"  + total + "','" + Tanggal() + "')";
    con = DriverManager.getConnection(url, "root", "");
    Statement statement = con.createStatement();
    statement.execute(sql);
    System.out.println("\nDATA BERHASIL DI INPUT !!!");
  }

  public void Tampil() throws SQLException {
    String sql = "SELECT idGame, Merk, Tipe, Harga FROM konsolfix";
    con = DriverManager.getConnection(url, "root", "");
    Statement statement = con.createStatement();
    ResultSet result = statement.executeQuery(sql);

    while (result.next()) {
      System.out.println("\n");
      System.out.print("Konsol yang Tersedia :");
      System.out.print("\nId Konsol\t :");
      System.out.print(result.getInt("idGame"));
      System.out.print("\nMerk Konsol\t:");
      System.out.print(result.getString("Merk"));
      System.out.print("\nTipe Konsol\t:");
      System.out.print(result.getString("Tipe"));
      System.out.print("\nHarga Konsol\t:");
      System.out.print(result.getInt("Harga"));
    }
  }

  public void Tampil2() throws SQLException {
    String sql = "SELECT Nomor_Pembelian, idGame, Merk, Tipe, jumlah, hargaTotal, Tanggal FROM transaksifix";
    con = DriverManager.getConnection(url, "root", "");
    Statement statement = con.createStatement();
    ResultSet result = statement.executeQuery(sql);

    while (result.next()) {
      System.out.println("\n");
      System.out.print("Nomor Pembelian\t :");
      System.out.print(result.getInt("Nomor_Pembelian"));
      System.out.print("\nID Konsol\t: ");
      System.out.print(result.getInt("idGame"));
      System.out.print("\nMerk Konsol\t: ");
      System.out.print(result.getString("Merk"));
      System.out.print("\nTipe Konsol\t: ");
      System.out.print(result.getString("Tipe"));
      System.out.print("\nJumlah\t\t:");
      System.out.print(result.getString("jumlah"));
      System.out.print("\nHarga total\t: ");
      System.out.print(result.getString("hargaTotal"));
      System.out.print("\nTanggal Pembelian : ");
      System.out.print(result.getString("Tanggal"));
    }
  }

  public void ubah() throws SQLException {
    try {
      System.out.print("Masukkan ID Konsol untuk mengubah data Konsol: ");
      id = 0;
      id = input.nextInt();
      input.nextLine();

      String sql = "SELECT idGame, Merk, Tipe, Harga FROM konsolfix  WHERE idGame = '" + id + "'";
      con = DriverManager.getConnection(url, "root", "");
      Statement statement = con.createStatement();
      ResultSet result = statement.executeQuery(sql);

      if (result.next()) {
        System.out.print("Id Konsol [" + result.getInt("idGame") + "]\t :");
        id = input.nextInt();

        System.out.print("Merk Konsol [" + result.getString("Merk") + "]\t :");
        merk = input.next();

        System.out.print("Tipe Konsol [" + result.getString("Tipe") + "]\t :");
        tipe = input.next();

        System.out.print("Harga [" + result.getString("Harga") + "]\t :");
        harga = input.nextInt();

   

        sql = "UPDATE konsolfix SET idGame ='" + id + "', Merk='" + merk + "', Tipe='" + tipe + "', Harga='" + harga + "' WHERE idGame='" + id + "'";

        if (statement.executeUpdate(sql) > 0) {
          System.out.println("Berhasil memperbaharui data ");
        }
      }
      statement.close();
    } catch (SQLException e) {
      System.err.println("Terjadi kesalahan dalam mengedit data");
      System.err.println(e.getMessage());
    }

  }

  public void delete() {
    String text4 = "\nHapus Daftar  Konsol";
    System.out.println(text4.toUpperCase());

    try {
      Tampil();
      System.out.print("\n\nMasukan Konsol yang akan dihapus : ");
      Integer id = Integer.parseInt(input.nextLine());

      String sql = "DELETE FROM konsolfix WHERE idGame = " + id;
      con = DriverManager.getConnection(url, "root", "");
      Statement statement = con.createStatement();

      if (statement.executeUpdate(sql) > 0) {
        System.out.println("Berhasil menghapus data");
      }
    } catch (SQLException e) {
      System.out.println("Terjadi kesalahan dalam menghapus data");
    } catch (Exception e) {
      System.out.println("masukan data yang benar");
    }
  }
}
