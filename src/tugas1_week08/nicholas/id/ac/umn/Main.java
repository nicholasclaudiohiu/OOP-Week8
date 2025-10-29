package tugas1_week08.nicholas.id.ac.umn;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static ArrayList<Item> ListOfItems = new ArrayList<Item>();
	static ArrayList<Payment> ListOfPayments = new ArrayList<Payment>();
	static Scanner s = new Scanner(System.in);
	
	public static void seedData() {
		ListOfItems.add(new Item("Kulkas", "Elektronik", 4800000));
		ListOfItems.add(new Item("TV", "Elektronik", 1280000));
		ListOfItems.add(new Item("Laptop", "Komputer", 6000000));
		ListOfItems.add(new Item("PC", "Komputer", 12000000));
	}
	
	public static void printItem(Item item) {
		System.out.println("Nama     : "+item.getName());
		System.out.println("Tipe     : "+item.getType());
		System.out.println("Harga    : "+item.getPrice());
	}
	
	public static void main(String[] args) {
		int opt = 0;
		int id = 0;
		seedData();
		do {
			System.out.println("---Program Toko Elektronik---");
			System.out.println("1. Pesan Barang");
			System.out.println("2. Lihat Barang");
			System.out.println("0. Keluar");
			System.out.println("Pilih : ");
			opt = s.nextInt();
			if(opt == 1) {
				System.out.println("----Daftar Barang----");
				for(int i = 0; i<ListOfItems.size();i++) {
					System.out.println("No : "+(i+1));
					printItem(ListOfItems.get(i));
					System.out.println("---------------------------");
				}
				System.out.print("Pilih barang (nomor): ");
				id = s.nextInt();
				
				if(id < 1 || id > ListOfItems.size()) {
					System.out.println("Nomor barang tidak valid!");
					continue;
				}
				
				Item chosenItem = ListOfItems.get(id - 1);

				System.out.println("Pilih metode pembayaran:");
				System.out.println("1. Cash");
				System.out.println("2. Credit");
				System.out.print("Pilihan: ");
				int metode = s.nextInt();
				
				Payment payment;
				
				if(metode == 1) {
					payment = new Cash(chosenItem);
					System.out.println("\n=== Pembayaran CASH ===");
					System.out.println("Total Dibayar: " + payment.pay());
					System.out.println("Status: " + payment.getStatus());
					
				} else if(metode == 2) {
					System.out.print("Masukkan jumlah cicilan maksimal: ");
					int maxCicilan = s.nextInt();
					
					payment = new Credit(chosenItem, maxCicilan);
					System.out.println("\n=== Pembayaran CREDIT ===");
					System.out.println("Bayar cicilan pertama: " + payment.pay());
					System.out.println("Sisa yang harus dibayar: " + payment.getRemainingAmount());
					System.out.println("Status: " + payment.getStatus());
					
				} else {
					System.out.println("Metode tidak valid!");
					continue;
				}
				ListOfPayments.add(payment);
			}
			else if(opt == 2) {
				if(ListOfPayments.isEmpty()) {
					System.out.println("Belum ada transaksi.");
				} else {
					System.out.println("=== Daftar Pembayaran ===");
					for(int i = 0; i < ListOfPayments.size(); i++) {
						Payment p = ListOfPayments.get(i);
						System.out.println("[" + (i+1) + "] " + p.getItemName() + 
								" - Status: " + p.getStatus() + 
								" - Sisa Bayar: " + p.getRemainingAmount());
					}
				}
			}
			
			else if(opt == 0) {
				System.out.println("Terima Kasih");
			}
			else {
				System.out.println("Salah Input");
			}
		}while(opt!=0);
	}

}