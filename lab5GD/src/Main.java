import java.util.concurrent.CyclicBarrier;

public class Main {
	public static void main(String[] args) {

		int COUNT_OF_PARTICIPANT = 3;
		int COUNT_OF_LOTS = 3;

		Auction auction = new Auction(3, COUNT_OF_LOTS);
		CyclicBarrier toNextLot = new CyclicBarrier(COUNT_OF_PARTICIPANT, auction);

		for (int i = 0; i < COUNT_OF_PARTICIPANT; i++) {
			new Participant(i, 9, auction, toNextLot).start();
		}
	}
}
