import java.util.*;

public class Queue {//Antrian
  public static String queue[] = new String[25];
  public static int a = 0;

  Scanner antri = new Scanner(System.in);

  // Constructure Kosong
  public Queue (int i){

    }

  public boolean queueStorage() {
    if (a < queue.length) {
      return true;
    } else {
      return false;
    }
  }

  public void CreateQueue() {
    String nama;
    System.out.print("Masukkan Nama : ");
    nama = antri.nextLine();
    queue[a] = nama;
    a++;
  }

  public void removeQueue() {
    a--;
    for (int i = 0; i < a; i++) {
      queue[i] = queue[i + 1];
    }
  }

  public void displayQue() {
    System.out.println("Daftar Antrian : ");
    for (int i = 0; i < a; i++) {
      System.out.println(+i + 1 + "." + queue[i]);
    }
    System.out.println("");
  }
}
