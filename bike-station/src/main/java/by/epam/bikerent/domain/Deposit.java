package by.epam.bikerent.domain;

import java.math.BigInteger;

public class Deposit {
	
	private Integer depositID;
	private BigInteger totalAmount;
	private BigInteger blockedAmount;

	public Deposit() {
		this.totalAmount = BigInteger.valueOf(0);
		this.blockedAmount = BigInteger.valueOf(0);
	}

	public Integer getDepositID() {
		return depositID;
	}

	public void setDepositID(Integer depositID) {
		this.depositID = depositID;
	}

	public BigInteger getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigInteger totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigInteger getBlockedAmount() {
		return blockedAmount;
	}

	public void setBlockedAmount(BigInteger blockedAmount) {
		this.blockedAmount = blockedAmount;
	}

	@Override
	public String toString() {
		return "Deposit [depositID=" + depositID + ", totalAmount=" + totalAmount + ", blockedAmount=" + blockedAmount
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blockedAmount == null) ? 0 : blockedAmount.hashCode());
		result = prime * result + ((depositID == null) ? 0 : depositID.hashCode());
		result = prime * result + ((totalAmount == null) ? 0 : totalAmount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Deposit)) {
			return false;
		}
		Deposit other = (Deposit) obj;
		if (blockedAmount == null) {
			if (other.blockedAmount != null) {
				return false;
			}
		} else if (!blockedAmount.equals(other.blockedAmount)) {
			return false;
		}
		if (depositID == null) {
			if (other.depositID != null) {
				return false;
			}
		} else if (!depositID.equals(other.depositID)) {
			return false;
		}
		if (totalAmount == null) {
			if (other.totalAmount != null) {
				return false;
			}
		} else if (!totalAmount.equals(other.totalAmount)) {
			return false;
		}
		return true;
	}
	
	

}
