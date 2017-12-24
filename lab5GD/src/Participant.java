import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Participant extends Thread {
	private int idOfParicipant;
	private int money;
	private int blockCount;
	private boolean isWillBet;
	private boolean isInBlackList;
	private CyclicBarrier toNextLot;
	private Auction auction;
	private Random random;

	Participant(int id, int amountOfMoney, Auction auction, CyclicBarrier toNextLot) {
		this.idOfParicipant = id;
		money = amountOfMoney;
		this.toNextLot = toNextLot;
		this.auction = auction;
		isInBlackList = false;
		random = new Random();
		isWillBet = random.nextBoolean();
	}

	public int getMoney() {
		return money;
	}

	public int getIdOfParticipant() {
		return idOfParicipant;
	}

	public void run() {
		System.out.println("поток " + idOfParicipant + " стартовал");
		while (auction.getSate()) {
			if (!isInBlackList) {
				isWillBet = random.nextBoolean();
				if (isWillBet) {
					System.out.println("Участиник" + idOfParicipant + " будет ставить");
					auction.bet(this);
				}
			} else {
				if (blockCount == 1) {
					isInBlackList = false;
				}
				blockCount--;
			}
			try {
				System.out.println("Участник " + idOfParicipant + " ждет");
				toNextLot.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}

	}

	public void blocked(int blockCount) {
		this.blockCount = blockCount;
		isInBlackList = true;
	}

	public void buy(int price) {
		money -= price;
	}
}
