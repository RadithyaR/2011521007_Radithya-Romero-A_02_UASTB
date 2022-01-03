import java.util.Scanner;
import java.sql.*;

public class Konsol implements Gim { // Superclass
  static Connection con;
  String url = "jdbc:mysql://localhost:3306/tugasbesarpbo";
  String merk, tipe;
  Integer id, harga, total, jumlah;
  Scanner input = new Scanner(System.in);

  public Konsol(Integer id, String merk, String tipe, Integer harga) {//Constructor
    this.id = id;
    this.merk = merk;
    this.tipe = tipe;
    this.harga = harga;
  }

  @Override
  public void idKonsol() {
    System.out.print("Masukan ID Konsol\t:");
    id = input.nextInt();
  }

  @Override
  public void merk() {
    System.out.print("Masukan Merk Konsol\t:");
    merk = input.next();
  }

  @Override
  public void tipe() {
    System.out.print("Masukan Tipe Konsol\t:");
    tipe = input.next();
  }
  
  @Override
  public void hargaKonsol() {
    System.out.print("Masukan harga Konsol\t:");
    harga = input.nextInt();
  }

  public void InsertDbKonsol() throws SQLException {
    String sql = "INSERT INTO konsolfix (idGame,Merk,Tipe,Harga) VALUES ('" + id + "', '" + merk + "','" + tipe + "','" + harga + "')";
    con = DriverManager.getConnection(url, "root", "");
    Statement statement = con.createStatement();
    statement.execute(sql);
    System.out.println("\nDATA BERHASIL DI INPUT !!!");
  }  
  public void beli() {}

  public void totalharga() {}
}

