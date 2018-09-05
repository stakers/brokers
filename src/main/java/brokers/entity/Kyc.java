package brokers.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "kyc")
public class Kyc {
	@Id
	private ObjectId id;
	@Indexed(unique = true)
	private User userid;
	private String participantType;
	private String homeAddress;
	private boolean verfied;
	private String profileImage;
	@Indexed(unique = true)
	private String identityID;
	private String registeredIDBook;
	private String firstname;
	private String lastname;

	public void verify() {
		// TODO - implement Kyc.verify
		throw new UnsupportedOperationException();
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public String getParticipantType() {
		return participantType;
	}

	public void setParticipantType(String participantType) {
		this.participantType = participantType;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public boolean isVerfied() {
		return verfied;
	}

	public void setVerfied(boolean verfied) {
		this.verfied = verfied;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getIdentityID() {
		return identityID;
	}

	public void setIdentityID(String identityID) {
		this.identityID = identityID;
	}

	public String getRegisteredIDBook() {
		return registeredIDBook;
	}

	public void setRegisteredIDBook(String registeredIDBook) {
		this.registeredIDBook = registeredIDBook;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}