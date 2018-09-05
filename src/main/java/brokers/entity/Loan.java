package brokers.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "loan")
public class Loan extends FinancialAsset {
	@Id
	private ObjectId id;

	private double amountDue;
	private int nextDueDate;
	private boolean isExpired;

	public void apply() {
		// TODO - implement Loan.apply
		throw new UnsupportedOperationException();
	}

	public void setInterestRate() {
		// TODO - implement Loan.setInterestRate
		throw new UnsupportedOperationException();
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public double getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(double amountDue) {
		this.amountDue = amountDue;
	}

	public int getNextDueDate() {
		return nextDueDate;
	}

	public void setNextDueDate(int nextDueDate) {
		this.nextDueDate = nextDueDate;
	}

	public boolean isExpired() {
		return isExpired;
	}

	public void setExpired(boolean expired) {
		isExpired = expired;
	}
}