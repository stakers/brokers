package brokers.model;

import java.io.Serializable;
import java.util.Date;

public class AuditLog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1624286094182212955L;
	
	private String eventDesc;
    private String eventSrc;
    private String userName;
    private String serverIp;
    private long transRef;
    private Date dateCreated;

   

	public long getTransRef() {
		return transRef;
	}

	public void setTransRef(long transRef) {
		this.transRef = transRef;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getEventSrc() {
        return eventSrc;
    }

    public void setEventSrc(String eventSrc) {
        this.eventSrc = eventSrc;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

}
