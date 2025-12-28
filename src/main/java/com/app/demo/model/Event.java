// package com.app.demo.model;

// import java.util.List;

// import javax.annotation.Generated;
// import javax.persistence.CascadeType;
// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.FetchType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.OneToMany;

// import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

// @Entity(name="event")
// public class Event {
	
// 	@GeneratedValue(strategy = GenerationType.AUTO)
// 	@Id
// 	private int id;
	
// 	@Column(name="event_name")
// 	private String eventname;
	
// 	@Column(name="event_desc")
// 	private String event_desc;
	
// 	@Column(name="event_img",columnDefinition = "longblob")
// 	private String event_img;

	
// 	@OneToMany(mappedBy="event",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
// 	private List<Booking> booking;
	
// 	public int getId() {
// 		return id;
// 	}

	

// 	public void setId(int id) {
// 		this.id = id;
// 	}

// 	public String getEventname() {
// 		return eventname;
// 	}

// 	public void setEventname(String eventname) {
// 		this.eventname = eventname;
// 	}

// 	public String getEvent_desc() {
// 		return event_desc;
// 	}

// 	public void setEvent_desc(String event_desc) {
// 		this.event_desc = event_desc;
// 	}

// 	public String getEvent_img() {
// 		return event_img;
// 	}

// 	public void setEvent_img(String event_img) {
// 		this.event_img = event_img;
// 	}
// 	@Override
// 	public String toString() {
// 		return "Event [id=" + id + ", eventname=" + eventname + ", event_desc=" + event_desc + ", event_img="
// 				+ event_img + "]";
// 	}
	

// }


package com.app.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_desc", columnDefinition = "text")
    private String eventDesc;

    @Lob
    @Column(name = "event_img")
    private byte[] eventImg;

    @JsonIgnore
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Booking> booking;

    // ===== Getters & Setters =====

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public byte[] getEventImg() {
        return eventImg;
    }

    public void setEventImg(byte[] eventImg) {
        this.eventImg = eventImg;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Event [id=" + id +
                ", eventName=" + eventName +
                ", eventDesc=" + eventDesc + "]";
    }
}

