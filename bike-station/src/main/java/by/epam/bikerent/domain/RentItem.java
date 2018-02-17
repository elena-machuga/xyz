package by.epam.bikerent.domain;

import java.math.BigDecimal;
import java.util.Calendar;

public class RentItem {

	private Bicycle bicycle;
	private Tenant tenant;
	private boolean inRent;
	private Calendar rentStartDateTime;
	private Calendar rentEndDateTime;
	private Long duration;
	private BigDecimal cost;

	public RentItem() {
	}

	public RentItem(Bicycle bicycle, Tenant tenant, boolean inRent) {
		this.bicycle = bicycle;
		this.tenant = tenant;
		this.inRent = inRent;
	}

	public RentItem(Bicycle bicycle, Tenant tenant, boolean inRent, Calendar rentStartDateTime) {
		this.bicycle = bicycle;
		this.tenant = tenant;
		this.inRent = inRent;
		this.rentStartDateTime = rentStartDateTime;
	}

	@Override
	public String toString() {
		return "RentItem [bicycle=" + bicycle + ", tenant=" + tenant + ", inRent=" + inRent + ", rentStartDateTime="
				+ rentStartDateTime + ", rentEndDateTime=" + rentEndDateTime + ", duration=" + duration + ", cost="
				+ cost + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bicycle == null) ? 0 : bicycle.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + (inRent ? 1231 : 1237);
		result = prime * result + ((rentEndDateTime == null) ? 0 : rentEndDateTime.hashCode());
		result = prime * result + ((rentStartDateTime == null) ? 0 : rentStartDateTime.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
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
		if (!(obj instanceof RentItem)) {
			return false;
		}
		RentItem other = (RentItem) obj;
		if (bicycle == null) {
			if (other.bicycle != null) {
				return false;
			}
		} else if (!bicycle.equals(other.bicycle)) {
			return false;
		}
		if (cost == null) {
			if (other.cost != null) {
				return false;
			}
		} else if (!cost.equals(other.cost)) {
			return false;
		}
		if (duration == null) {
			if (other.duration != null) {
				return false;
			}
		} else if (!duration.equals(other.duration)) {
			return false;
		}
		if (inRent != other.inRent) {
			return false;
		}
		if (rentEndDateTime == null) {
			if (other.rentEndDateTime != null) {
				return false;
			}
		} else if (!rentEndDateTime.equals(other.rentEndDateTime)) {
			return false;
		}
		if (rentStartDateTime == null) {
			if (other.rentStartDateTime != null) {
				return false;
			}
		} else if (!rentStartDateTime.equals(other.rentStartDateTime)) {
			return false;
		}
		if (tenant == null) {
			if (other.tenant != null) {
				return false;
			}
		} else if (!tenant.equals(other.tenant)) {
			return false;
		}
		return true;
	}

}
