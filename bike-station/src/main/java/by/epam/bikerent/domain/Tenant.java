package by.epam.bikerent.domain;

public class Tenant {

	private User user;
	private Deposit deposit;
	private boolean isBlocked;

	public Tenant() {
	}

	public Tenant(User user) {
		this.user = user;
		this.deposit = new Deposit();
		this.isBlocked = false;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Deposit getDeposit() {
		return deposit;
	}

	public void setDeposit(Deposit deposit) {
		this.deposit = deposit;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	@Override
	public String toString() {
		return "Tenant [user=" + user + ", deposit=" + deposit + ", isBlocked=" + isBlocked + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deposit == null) ? 0 : deposit.hashCode());
		result = prime * result + (isBlocked ? 1231 : 1237);
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (!(obj instanceof Tenant)) {
			return false;
		}
		Tenant other = (Tenant) obj;
		if (deposit == null) {
			if (other.deposit != null) {
				return false;
			}
		} else if (!deposit.equals(other.deposit)) {
			return false;
		}
		if (isBlocked != other.isBlocked) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}


}
