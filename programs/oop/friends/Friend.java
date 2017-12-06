import java.util.Date;
import java.util.Objects;

public class Friend {
	
	private String name;
	private String phoneNumber;
	private Date birthday;
	private String emailAddress;
	
	public Friend(String name, String phoneNumber, Date birthday, String emailAddress) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.emailAddress = emailAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@Override
	public String toString() {
		return name + ": \n" +
	           "Phone Number: " + phoneNumber + "\n" +
			   "Birthday: " + birthday + "\n" +
	           "Email: " + emailAddress;
	}

}
