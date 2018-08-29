package core;

/**
 * A stake is a pool of asset class that users with similar financial status can buy.
 */
public class Stake extends FinancialAsset {

	private String marginCall;
	private double amountDue;
	private boolean isExpired;
	private int nextDueDate;

	public void join() {
		// TODO - implement Stake.join
		throw new UnsupportedOperationException();
	}

	public void setMarginCall() {
		// TODO - implement Stake.setMarginCall
		throw new UnsupportedOperationException();
	}

}