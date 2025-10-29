package tugas1_week08.nicholas.id.ac.umn;

public class Credit extends Payment {
	private int installment;
	private int maxInstallmentAmount;

	public Credit(Item item, int maxInstallmentAmount) {
		super(item);
		this.maxInstallmentAmount = maxInstallmentAmount;
		this.installment = 0;
	}

	@Override
	public int pay() {
		if (isPaidOff) {
			return 0; 
		}

		int perCicilan = item.getPrice() / maxInstallmentAmount;

		installment++;

		if (installment >= maxInstallmentAmount) {
			isPaidOff = true;
		}

		return perCicilan;
	}

	@Override
	public int getRemainingAmount() {
		if (isPaidOff) {
			return 0; 
		}

		int totalHarga = item.getPrice();
		int sudahDibayar = (item.getPrice() / maxInstallmentAmount) * installment;

		return totalHarga - sudahDibayar;
	}

	public int getInstallment() {
		return installment;
	}

	public int getMaxInstallmentAmount() {
		return maxInstallmentAmount;
	}

	public String getClassName() {
		return "Credit";
	}
}
