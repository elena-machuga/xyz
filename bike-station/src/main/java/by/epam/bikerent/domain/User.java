package by.epam.bikerent.domain;

public class User {
	private String name;
	private String addres;
	private String phone;
	private String login;
	private String password;
	private Role role;
	private BlockStatus blockStatus;
	private int userID;

	public User() {
	}

	public User(String name, String addres, String phone, String login, String password, Role role, BlockStatus blockStatus, int userID) {
		this.name = name;
		this.addres = addres;
		this.phone = phone;
		this.login = login;
		this.password = password;
		this.role = role;
		this.blockStatus = blockStatus;
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setRole(String role) {
		if ("1".equals(role)) {
			this.role = Role.ADMIN;
		} else if("2".equals(role)) {
			this.role = Role.USER;
		} else {
			this.role = Role.GUEST;
		}

	}

	public BlockStatus getBlockStatus() {
		return blockStatus;
	}

	public void setBlockStatus(String blockStatus) {
		if ("1".equals(blockStatus)) {
			this.blockStatus = BlockStatus.BLOCKED;
		} else if("0".equals(blockStatus)) {
			this.blockStatus = BlockStatus.NOT_BLOCKED;
		}
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", addres=" + addres + ", phone=" + phone + ", login=" + login + ", password="
				+ password + ", role=" + role + ", userID=" + userID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addres == null) ? 0 : addres.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + userID;
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
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (addres == null) {
			if (other.addres != null) {
				return false;
			}
		} else if (!addres.equals(other.addres)) {
			return false;
		}
		if (login == null) {
			if (other.login != null) {
				return false;
			}
		} else if (!login.equals(other.login)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (phone == null) {
			if (other.phone != null) {
				return false;
			}
		} else if (!phone.equals(other.phone)) {
			return false;
		}
		if (role != other.role) {
			return false;
		}
		if (userID != other.userID) {
			return false;
		}
		return true;
	}

}
