// package com.app.demo.repository;

// import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Modifying;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;

// import com.app.demo.model.Hotel;

// @Repository
// public interface HotelRepo extends JpaRepository<Hotel,Integer>{
	
// 		@Modifying
//         @Transactional
//         @Query("UPDATE Hotel h SET h.hotelName=?1, h.hotelDesc=?2, h.location=?3, h.price=?4 WHERE h.id=?5")
//         void updateHotel(String hotelName, String hotelDesc, String location, int price, int id);


// 		@Modifying
// 		@Transactional
// 		@Query("Update hotel set hotel_name=?1,hotel_desc=?2,location=?3, price=?4, hotel_img1=?5 where id=?6 ")
// 		public void updateHotelwithImage(String hotelName, String hotelDesc, String location, int price, String image, int id);


// 		@Query("select h from hotel h where hotel_name LIKE %?1% or price LIKE %?1% or location LIKE %?1%")
// 		public List<Hotel> findbykey(String searchkey);

// }
package com.app.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.demo.model.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {

    @Modifying
    @Transactional
    @Query(
        "UPDATE Hotel h SET " +
        "h.hotelName = :hotelName, " +
        "h.hotelDesc = :hotelDesc, " +
        "h.location = :location, " +
        "h.price = :price " +
        "WHERE h.id = :id"
    )
    void updateHotel(
        @Param("hotelName") String hotelName,
        @Param("hotelDesc") String hotelDesc,
        @Param("location") String location,
        @Param("price") int price,
        @Param("id") int id
    );

    @Modifying
    @Transactional
    @Query(
        "UPDATE Hotel h SET " +
        "h.hotelName = :hotelName, " +
        "h.hotelDesc = :hotelDesc, " +
        "h.location = :location, " +
        "h.price = :price, " +
        "h.hotelImg1 = :image " +
        "WHERE h.id = :id"
    )
    void updateHotelwithImage(
        @Param("hotelName") String hotelName,
        @Param("hotelDesc") String hotelDesc,
        @Param("location") String location,
        @Param("price") int price,
        @Param("image") byte[] image,
        @Param("id") int id
    );

    @Query(
        "SELECT h FROM Hotel h " +
        "WHERE h.hotelName LIKE %:key% " +
        "OR h.location LIKE %:key% " +
        "OR CAST(h.price AS string) LIKE %:key%"
    )
    List<Hotel> findbykey(@Param("key") String key);
}


