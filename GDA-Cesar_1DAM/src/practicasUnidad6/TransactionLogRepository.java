package practicasUnidad6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionLogRepository {
	private static final String LOG_FILE_PATH = "logs/transaction_log.txt";
	private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public void logTransaction(String transactionId, double amount) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {

			String timestamp = LocalDateTime.now().format(TIME_FORMATTER);
			String logEntry = String.format("[%s] TXN_ID: %s | AMOUNT: $%.2f", timestamp, transactionId, amount);

			writer.write(logEntry);
			writer.newLine();

		} catch (IOException e) {
			throw new IllegalArgumentException("Failed ti wrute transaction log for ID: " + transactionId, e);
		}
	}

	public static void main(String[] args) {
		

	}
}
