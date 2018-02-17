package by.epam.bikerent.domain;

import java.math.BigDecimal;

public class Bicycle {

	private Producer producer;
	private String model;
	private Integer year;
	private BigDecimal rentPrice;
	private RentPoint rentPoint;

	public Bicycle() {
	}

	public Bicycle(Producer producer, String model, Integer year, BigDecimal rentPrice, RentPoint rentPoint) {
		this.producer = producer;
		this.model = model;
		this.year = year;
		this.rentPrice = rentPrice;
		this.rentPoint = rentPoint;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public BigDecimal getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(BigDecimal rentPrice) {
		this.rentPrice = rentPrice;
	}

	public RentPoint getRentPoint() {
		return rentPoint;
	}

	public void setRentPoint(RentPoint rentPoint) {
		this.rentPoint = rentPoint;
	}

	@Override
	public String toString() {
		return "Bicycle [producer=" + producer + ", model=" + model + ", year=" + year + ", rentPrice=" + rentPrice
				+ ", rentPoint=" + rentPoint + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((producer == null) ? 0 : producer.hashCode());
		result = prime * result + ((rentPoint == null) ? 0 : rentPoint.hashCode());
		result = prime * result + ((rentPrice == null) ? 0 : rentPrice.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		if (!(obj instanceof Bicycle)) {
			return false;
		}
		Bicycle other = (Bicycle) obj;
		if (model == null) {
			if (other.model != null) {
				return false;
			}
		} else if (!model.equals(other.model)) {
			return false;
		}
		if (producer == null) {
			if (other.producer != null) {
				return false;
			}
		} else if (!producer.equals(other.producer)) {
			return false;
		}
		if (rentPoint == null) {
			if (other.rentPoint != null) {
				return false;
			}
		} else if (!rentPoint.equals(other.rentPoint)) {
			return false;
		}
		if (rentPrice == null) {
			if (other.rentPrice != null) {
				return false;
			}
		} else if (!rentPrice.equals(other.rentPrice)) {
			return false;
		}
		if (year == null) {
			if (other.year != null) {
				return false;
			}
		} else if (!year.equals(other.year)) {
			return false;
		}
		return true;
	}

}
