package brokers.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * A stake is a pool of asset class that users with similar financial status can buy.
 */

@Document(collection = "stake")
public class Stake extends FinancialAsset {

	@Id
	private ObjectId id;
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

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getMarginCall() {
		return marginCall;
	}

	public void setMarginCall(String marginCall) {
		this.marginCall = marginCall;
	}

	public double getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(double amountDue) {
		this.amountDue = amountDue;
	}

	public boolean isExpired() {
		return isExpired;
	}

	public void setExpired(boolean expired) {
		isExpired = expired;
	}

	public int getNextDueDate() {
		return nextDueDate;
	}

	public void setNextDueDate(int nextDueDate) {
		this.nextDueDate = nextDueDate;
	}
}