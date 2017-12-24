import java.util.Random;

public class Auction implements Runnable {
	private int startPrice;
	private int currentPrice;
	private int countOfLots;
	private boolean state;
	private Participant leader;

	Auction(int startPrice, int countOfLots) {
		this.startPrice = startPrice;
		this.countOfLots = countOfLots;
		state = true;
		nextLot();
	}

	public boolean getSate() {
		return state;
	}

	public int getCurrentPrice() {
		return currentPrice;
	}

	public synchronized void bet(Participant p) {
		Random random = new Random();
		currentPrice += random.nextInt(25);
		leader = p;
	}

	public void nextLot() {
		System.out.println("\nЛот номер:" + countOfLots);
		currentPrice = startPrice;
		leader = null;
	}

	@Override
	public void run() {
		if (leader != null) {
			if (leader.getMoney() < currentPrice) {
				leader.blocked(2);
				System.out.println("Участник " + leader.getIdOfParticipant() + "заблокирован");
			} else {
				leader.buy(currentPrice);
				System.out.println("Участник " + leader.getIdOfParticipant() + "выкупил лот за " + currentPrice);
			}
			if (countOfLots > 0) {
				countOfLots--;
				nextLot();
			} else {
				System.out.println("Аукцион завершен");
				state = false;
			}
		} else {
			System.out.println("Лот не продан");
		}
	}
}
