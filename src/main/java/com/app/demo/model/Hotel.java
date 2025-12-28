// package com.app.demo.model;

// import java.util.List;

// import javax.persistence.CascadeType;
// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.FetchType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.OneToMany;
// import javax.persistence.Table;


// @Entity
// @Table(name = "hotel")

// public class Hotel {

//    @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
// 	private int id;
    
//     @Column(name="hotel_name")
// 	private String hotelName;
    
//     @Column(name="hotel_desc")
// 	private String hotelDesc;
    
//     @Column(name="hotel_img1",columnDefinition = "longblob")
// 	private String hotelImg1;

//     @Column(name="price")
//     private int price;
    
//     @Column(name="location")
//     private String location;

//     @OneToMany(mappedBy="hotel",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
// 	private List<Booking> booking;
    
// 	public int getId() {
// 		return this.id;
// 	}

// 	public void setId(int id) {
// 		this.id = id;
// 	}

// 	public String getHotelName() {
// 		return hotelName;
// 	}

// 	public void setHotelName(String hotelName) {
// 		this.hotelName = hotelName;
// 	}

// 	public String getHotelDesc() {
// 		return hotelDesc;
// 	}

// 	public void setHotelDesc(String hotelDesc) {
// 		this.hotelDesc = hotelDesc;
// 	}

// 	public String getHotelImg1() {
// 		return hotelImg1;
// 	}

// 	public void setHotelImg1(String hotelImg1) {
// 		this.hotelImg1 = hotelImg1;
// 	}

// 	public int getPrice() {
// 		return price;
// 	}

// 	public void setPrice(int price) {
// 		this.price = price;
// 	}

// 	public String getLocation() {
// 		return location;
// 	}

// 	public void setLocation(String location) {
// 		this.location = location;
// 	}

// 	@Override
// 	public String toString() {
// 		return "Hotel [Id=" + id + ", hotelName=" + hotelName + ", hotelDesc=" + hotelDesc + ", hotelImg1=" + hotelImg1
// 				+ ", price=" + price + ", location=" + location + "]";
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
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "hotel_desc")
    private String hotelDesc;

    @Lob
    @Column(name = "hotel_img1")
    private byte[] hotelImg1;

    @Column(name = "price")
    private int price;

    @Column(name = "location")
    private String location;

    @JsonIgnore
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Booking> booking;

    // ===== Getters & Setters =====

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelDesc() {
        return hotelDesc;
    }

    public void setHotelDesc(String hotelDesc) {
        this.hotelDesc = hotelDesc;
    }

    public byte[] getHotelImg1() {
        return hotelImg1;
    }

    public void setHotelImg1(byte[] hotelImg1) {
        this.hotelImg1 = hotelImg1;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Hotel [id=" + id +
                ", hotelName=" + hotelName +
                ", hotelDesc=" + hotelDesc +
                ", price=" + price +
                ", location=" + location + "]";
    }
}


