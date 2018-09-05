package brokers.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class FinancialAsset {

	private int grade;
	@Field("fAsset.isExpired")
	private boolean isExpired;

	public void apply() {
		// TODO - implement FinancialAsset.apply
		throw new UnsupportedOperationException();
	}

}