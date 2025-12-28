// package com.app.demo.services;

// import java.io.IOException;
// import java.util.Base64;
// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.util.StringUtils;
// import org.springframework.web.multipart.MultipartFile;

// import com.app.demo.model.Hotel;
// import com.app.demo.model.User;
// import com.app.demo.repository.HotelRepo;

// @Service
// public class HotelServices {

// 		@Autowired
// 		private HotelRepo hotelrepo;

// 		public HotelRepo getHotelrepo() {
// 			return hotelrepo;
// 		}

// 		public void setHotelrepo(HotelRepo hotelrepo) {
// 			this.hotelrepo = hotelrepo;
// 		}
// 		public void savehoteltoDB(MultipartFile hotelimg1,String hotelName,String hoteldesc, String hotelloc, int hotelPrice ) {
			
// 			Hotel h = new Hotel();
			
// 			h.setHotelName(hotelName);
// 			h.setHotelDesc(hoteldesc);
// 			h.setLocation(hotelloc);
// 			h.setPrice(hotelPrice);
			
// 			try {
// 				h.setHotelImg1(Base64.getEncoder().encodeToString(hotelimg1.getBytes()));
// 			} catch (IOException e) {
// 				// TODO Auto-generated catch block
// 				e.printStackTrace();
// 			}	
// 			hotelrepo.save(h);
// 		}
		
// 		public List<Hotel> findAll(){
// 			return hotelrepo.findAll();
// 		}

		
// 		public Hotel findById(int id) {
// 			return hotelrepo.findById(id).orElse(null);
// 		}
// 		public void deleteHotel(int id)
// 		{
// 			System.out.println("deleting...");
// 			hotelrepo.deleteById(id);
// 		}
// 		public void updateHotelDetails(String hotelname,String hoteldesc, String location,int price,int id) {
// 			hotelrepo.updateHotel(hotelname, hoteldesc, location, price,id);
// 		}
// 		public void updateHotelDetailswithImage(String hotelName, String hotelDesc, String location, int price,MultipartFile file,int id) {
// 			String image="";
// 			try {
				
// 				image= Base64.getEncoder().encodeToString(file.getBytes());
// 			} catch (IOException e) {
// 				// TODO Auto-generated catch block
// 				e.printStackTrace();
// 			}
// 			hotelrepo.updateHotelwithImage(hotelName, hotelDesc,  location, price ,image, id);
			
// 		}

// 		public long hotelCount() {
// 			// TODO Auto-generated method stub
// 			return hotelrepo.count();
// 		}

// 		public List<Hotel> findBykey(String searchkey) {
// 			// TODO Auto-generated method stub
// 			return hotelrepo.findbykey(searchkey);
// 		}
		
// }


package com.app.demo.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.app.demo.model.Hotel;
import com.app.demo.repository.HotelRepo;

@Service
@Transactional
public class HotelServices {

    @Autowired
    private HotelRepo hotelrepo;

    // ===== SAVE HOTEL (WITH IMAGE) =====
    public void savehoteltoDB(MultipartFile hotelimg1,
                              String hotelName,
                              String hoteldesc,
                              String hotelloc,
                              int hotelPrice) {

        Hotel h = new Hotel();
        h.setHotelName(hotelName);
        h.setHotelDesc(hoteldesc);
        h.setLocation(hotelloc);
        h.setPrice(hotelPrice);

        try {
            if (hotelimg1 != null && !hotelimg1.isEmpty()) {
                // ✅ STORE IMAGE AS byte[]
                h.setHotelImg1(hotelimg1.getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException("Image upload failed", e);
        }

        hotelrepo.save(h);
    }

    // ===== GET ALL HOTELS =====
    public List<Hotel> findAll() {
        return hotelrepo.findAll();
    }

    // ===== GET HOTEL BY ID =====
    public Hotel findById(int id) {
        return hotelrepo.findById(id).orElse(null);
    }

    // ===== DELETE HOTEL =====
    public void deleteHotel(int id) {
        hotelrepo.deleteById(id);
    }

    // ===== UPDATE HOTEL (WITHOUT IMAGE) =====
    public void updateHotelDetails(String hotelName,
                                   String hotelDesc,
                                   String location,
                                   int price,
                                   int id) {

        hotelrepo.updateHotel(hotelName, hotelDesc, location, price, id);
    }

    // ===== UPDATE HOTEL (WITH IMAGE) =====
    public void updateHotelDetailswithImage(String hotelName,
                                            String hotelDesc,
                                            String location,
                                            int price,
                                            MultipartFile file,
                                            int id) {

        byte[] imageBytes = null;

        try {
            if (file != null && !file.isEmpty()) {
                // ✅ Convert MultipartFile → byte[]
                imageBytes = file.getBytes();
            }
        } catch (IOException e) {
            throw new RuntimeException("Image upload failed", e);
        }

        hotelrepo.updateHotelwithImage(
                hotelName,
                hotelDesc,
                location,
                price,
                imageBytes,
                id
        );
    }

    // ===== HOTEL COUNT =====
    public long hotelCount() {
        return hotelrepo.count();
    }

    // ===== SEARCH HOTEL =====
    public List<Hotel> findBykey(String searchkey) {
        return hotelrepo.findbykey(searchkey);
    }
}


