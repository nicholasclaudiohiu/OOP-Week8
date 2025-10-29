package week08.nicholas.id.ac.umn;

public class main {

	public static void main(String[] args) {
		// Membuat objek untuk setiap metode pembayaran
		Payment creditCardPayment = new CreditCardPayment(100.0, "1234-5678-9012-3456");
		Payment bankTransferPayment = new BankTransferPayment(300.0, "9876543210");
		
		// Memproses setiap pembayaran
		creditCardPayment.paymentDetails();
		creditCardPayment.processPayment();
		
		bankTransferPayment.paymentDetails();
		bankTransferPayment.processPayment();
	}

}