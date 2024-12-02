
package com.app.demo.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.demo.UserExcelExporter;
import com.app.demo.model.Booking;
import com.app.demo.model.Catering;
import com.app.demo.model.Event;
import com.app.demo.model.Hotel;
import com.app.demo.model.User;
import com.app.demo.model.Vendor;
import com.app.demo.services.BookingServices;
import com.app.demo.services.CateringServices;
import com.app.demo.services.EventServices;
import com.app.demo.services.HotelServices;
import com.app.demo.services.UserServices;
import com.app.demo.services.VendorServices;

@Controller

public class AdminController {
   @Autowired
   private HotelServices hotelservice;
   @Autowired
   private UserServices userservice;
   @Autowired
   private CateringServices caterservice;
   @Autowired
	private VendorServices vendorservice;
   @Autowired
   private EventServices eventservice;
   @Autowired
   private BookingServices bookingservice;

   public AdminController() {
   }

   @PostMapping({"/register"})
   public ResponseEntity<String> handlePostRequest(@RequestBody User user) {
      this.userservice.save(user);
      return ResponseEntity.ok("registered successfully");
   }
   
   
 //add user 
   //User Registration
   	@RequestMapping(value="/adduserForm",method= RequestMethod.POST)
   	public String UserRegister(@ModelAttribute("registerForm") User user,Model model)
   	{
   			System.out.println(user);
   			
   			model.addAttribute("user",user);
   		
   			userservice.save(user);
   			System.out.println("add user Success");
   			
   			return "redirect:/adminuserdetails";
   		
   	}

  
  
   
   @RequestMapping(
      value = {"/adminuserdetails"},
      method = {RequestMethod.GET}
   )
   public String adminUserDetails(ModelMap model) {
      List<User> user = this.userservice.findAll();
      model.addAttribute("Userlist", user);
      return "AdminUserDetails";
   }

   @RequestMapping(
      value = {"/adminuserSearch"},
      method = {RequestMethod.POST}
   )
   public String adminUserSearch(@RequestParam("valueToSearch") String searchkey, ModelMap model) {
      System.out.println(searchkey);
      List listuser;
      if (searchkey.equals("")) {
         listuser = this.userservice.findAll();
         model.addAttribute("Userlist", listuser);
         return "AdminUserDetails";
      } else {
         model.addAttribute("user_keyword", searchkey);
         listuser = this.userservice.findBykey(searchkey);
         model.addAttribute("Userlist", listuser);
         return "AdminUserDetails";
      }
   }

   @RequestMapping(
      value = {"/admindeleteuser/{email}"},
      method = {RequestMethod.GET}
   )
   public String admindeleteUser(@PathVariable String email) {
      User user = this.userservice.findByEmail(email);
      System.out.println(user);
      if (user.getEmail() != null) {
         this.userservice.deleteUser(user.getId());
         return "redirect:/adminuserdetails";
      } else {
         return "redirect:/adminuserdetails";
      }
   }

   @RequestMapping(
      value = {"userfind/{id}"},
      method = {RequestMethod.GET},
      produces = {"application/json"}
   )
   public ResponseEntity<User> adminEditDetails(@PathVariable("id") int id) {
      try {
         return new ResponseEntity(this.userservice.findById(id), HttpStatus.OK);
      } catch (Exception var3) {
         return new ResponseEntity(HttpStatus.BAD_REQUEST);
      }
   }

   @RequestMapping(
      value = {"/EdituserForm"},
      method = {RequestMethod.POST}
   )
   public String updateUser(@ModelAttribute("userEditForm") User user) {
      System.out.println(user);
      this.userservice.updateUserDetails(user.getEmail(), user.getFirstName(), user.getLastName(), user.getGender(), user.getContactno(), user.getAddress(), user.getRole(), user.getId());
      return "redirect:/adminuserdetails";
   }

   @Controller
	public class HotelController {

	    @RequestMapping(value="/addhotelForm", method=RequestMethod.POST)
	    public String savehotel(@RequestParam("subadmin") String role1,
	                            @RequestParam("superadmin") String role2,
	                            @RequestParam("hotelName") String hotelname,
	                            @RequestParam("hotelDesc") String hotelDesc,
	                            @RequestParam("location") String hotelLoc,
	                            @RequestParam("price") int hotelPrice,
	                            @RequestParam("hotelImg1") MultipartFile file) {

	        hotelservice.savehoteltoDB(file, hotelname, hotelDesc, hotelLoc, hotelPrice);
	        
	        if ("subadmin".equals(role1) && "not".equals(role2)) {
	            return "redirect:/subadminhoteldetails";
	        } else if ("not".equals(role1) && "superadmin".equals(role2)) {
	            return "redirect:/superadminhoteldetails";
	        } else {
	            return "redirect:/adminhoteldetails";
	        }
	    }
	}
   
   @RequestMapping(
      value = {"/adminhoteldetails"},
      method = {RequestMethod.GET}
   )
   public String adminHotelDetails(ModelMap model) {
      List<Hotel> hotel = this.hotelservice.findAll();
      model.addAttribute("Hotellist", hotel);
      return "AdminHotelDetails";
   }

   @RequestMapping(
      value = {"/adminhotelSearch"},
      method = {RequestMethod.POST}
   )
   public String adminHotelSearch(@RequestParam("valueToSearch") String searchkey, ModelMap model) {
      System.out.println(searchkey);
      List hotel;
      if (searchkey.equals("")) {
         hotel = this.hotelservice.findAll();
         model.addAttribute("Hotellist", hotel);
         return "AdminHotelDetails";
      } else {
         model.addAttribute("hotel_keyword", searchkey);
         hotel = this.hotelservice.findBykey(searchkey);
         model.addAttribute("Hotellist", hotel);
         return "AdminHotelDetails";
      }
   }

   @RequestMapping({"/admindeletehotel/{id}"})
   public String admindeleteHotel(@PathVariable int id) {
      Hotel hotel = this.hotelservice.findById(id);
      System.out.println(hotel);
      if (hotel.getHotelName() != null) {
         this.hotelservice.deleteHotel(id);
         return "redirect:/adminhoteldetails";
      } else {
         return "redirect:/adminhoteldetails";
      }
   }

   @RequestMapping(
      value = {"hotelfind/{id}"},
      method = {RequestMethod.GET},
      produces = {"application/json"}
   )
   public ResponseEntity<Hotel> adminhoteEditDetails(@PathVariable("id") int id) {
      try {
         return new ResponseEntity(this.hotelservice.findById(id), HttpStatus.OK);
      } catch (Exception var3) {
         return new ResponseEntity(HttpStatus.BAD_REQUEST);
      }
   }

   
   @RequestMapping(
      value = {"/EdithotelForm"},
      method = {RequestMethod.POST}
   )
   public String updateHotel(@RequestParam("subadmin") String role1, @RequestParam("superadmin") String role2, @RequestParam("hotelName") String hotelname, @RequestParam("hotelDesc") String hotelDesc, @RequestParam("location") String hotelLoc, @RequestParam("price") int hotelPrice, @RequestParam("hotelImg1") MultipartFile file, @RequestParam("id") int id) {
      if (file.isEmpty()) {
         this.hotelservice.updateHotelDetails(hotelname, hotelDesc, hotelLoc, hotelPrice, id);
      } else {
         this.hotelservice.updateHotelDetailswithImage(hotelname, hotelDesc, hotelLoc, hotelPrice, file, id);
      }

      if (role1.equals("subadmin") && role2.equals("not")) {
         return "redirect:/subadminhoteldetails";
      } else {
         return role1.equals("not") && role2.equals("superadmin") ? "redirect:/superadminhoteldetails" : "redirect:/adminhoteldetails";
      }
   }

   @RequestMapping(
      value = {"/admincateringdetails"},
      method = {RequestMethod.GET}
   )
   public String adminCateringDetails(Model model) {
      List<Catering> cater = this.caterservice.findAll();
      model.addAttribute("caterlist", cater);
      return "AdminCateringDetails";
   }

   @RequestMapping(
      value = {"/admincateringSearch"},
      method = {RequestMethod.POST}
   )
   public String admincaterSearch(@RequestParam("valueToSearch") String searchkey, ModelMap model) {
      System.out.println(searchkey);
      List cater;
      if (searchkey.equals("")) {
         cater = this.caterservice.findAll();
         model.addAttribute("caterlist", cater);
         return "AdminCateringDetails";
      } else {
         model.addAttribute("catering_keyword", searchkey);
         cater = this.caterservice.findBykey(searchkey);
         model.addAttribute("caterlist", cater);
         return "AdminCateringDetails";
      }
   }

   @RequestMapping({"/admindeletecater/{id}"})
   public String admindeleteCater(@PathVariable int id) {
      Catering c = this.caterservice.findById(id);
      if (c.getCatername() != null) {
         this.caterservice.deletecater(id);
         return "redirect:/admincateringdetails";
      } else {
         return "redirect:/admincateringdetails";
      }
   }

// Add Catering
	@Controller
	public class CateringController {

		@RequestMapping(value = "/addcaterForm", method = RequestMethod.POST)
		public String saveCater(@RequestParam("subadmin") String role1, @RequestParam("superadmin") String role2,
				@RequestParam("catername") String catername, @RequestParam("cater_desc") String caterDesc,
				@RequestParam("cater_location") String caterLoc, @RequestParam("cater_price") int caterprice,
				@RequestParam("cater_img") MultipartFile file) {

			// Assuming your service method to save cater is implemented correctly.
			caterservice.savecatertoDB(file, catername, caterDesc, caterLoc, caterprice);

			if ("subadmin".equals(role1) && "not".equals(role2)) {
				return "redirect:/subadmincateringdetails";
			} else if ("not".equals(role1) && "superadmin".equals(role2)) {
				return "redirect:/superadmincateringdetails";
			} else {
				return "redirect:/admincateringdetails";
			}
		}
	}
   
   @RequestMapping(
      value = {"caterfind/{id}"},
      method = {RequestMethod.GET},
      produces = {"application/json"}
   )
   public ResponseEntity<Catering> admincaterEditDetails(@PathVariable("id") int id) {
      try {
         return new ResponseEntity(this.caterservice.findById(id), HttpStatus.OK);
      } catch (Exception var3) {
         return new ResponseEntity(HttpStatus.BAD_REQUEST);
      }
   }

   @RequestMapping(
      value = {"/EditcaterForm"},
      method = {RequestMethod.POST}
   )
   public String updateCater(@RequestParam("subadmin") String role1, @RequestParam("superadmin") String role2, @RequestParam("catername") String catername, @RequestParam("cater_desc") String caterdesc, @RequestParam("cater_location") String caterloc, @RequestParam("cater_price") int caterprice, @RequestParam("cater_img") MultipartFile file, @RequestParam("id") int id) {
      if (file.isEmpty()) {
         this.caterservice.updateCaterDetails(catername, caterdesc, caterloc, caterprice, id);
      } else {
         this.caterservice.updateCaterDetailswithImage(catername, caterdesc, caterloc, caterprice, file, id);
      }

      if (role1.equals("subadmin") && role2.equals("not")) {
         return "redirect:/subadmincateringdetails";
      } else {
         return role1.equals("not") && role2.equals("superadmin") ? "redirect:/superadmincateringdetails" : "redirect:/admincateringdetails";
      }
   }

   @RequestMapping(
      value = {"/adminvendordetails"},
      method = {RequestMethod.GET}
   )
   public String adminVendorDetails(ModelMap model) {
      List<Vendor> vendor = this.vendorservice.findAll();
      model.addAttribute("vendorlist", vendor);
      return "AdminVendorDetails";
   }

   @RequestMapping(
      value = {"/adminvendorSearch"},
      method = {RequestMethod.POST}
   )
   public String adminvendorSearch(@RequestParam("valueToSearch") String searchkey, ModelMap model) {
      System.out.println(searchkey);
      List vendor;
      if (searchkey.equals("")) {
         vendor = this.vendorservice.findAll();
         model.addAttribute("vendorlist", vendor);
         return "AdminVendorDetails";
      } else {
         model.addAttribute("vendor_keyword", searchkey);
         vendor = this.vendorservice.findBykey(searchkey);
         model.addAttribute("vendorlist", vendor);
         return "AdminVendorDetails";
      }
   }

   @RequestMapping({"/admindeletevendor/{id}"})
   public String admindeleteVendor(@PathVariable int id) {
      Vendor v = this.vendorservice.findById(id);
      System.out.println(v);
      this.vendorservice.deletevendor(id);
      return "redirect:/adminvendordetails";
   }

   @RequestMapping(
      value = {"vendorfind/{id}"},
      method = {RequestMethod.GET},
      produces = {"application/json"}
   )
   public ResponseEntity<Vendor> adminvendorEditDetails(@PathVariable("id") int id) {
      try {
         return new ResponseEntity(this.vendorservice.findById(id), HttpStatus.OK);
      } catch (Exception var3) {
         return new ResponseEntity(HttpStatus.BAD_REQUEST);
      }
   }

   @RequestMapping(
      value = {"/EditvendorForm"},
      method = {RequestMethod.POST}
   )
   public String updatevendor(@RequestParam("subadmin") String role1, @RequestParam("superadmin") String role2, @RequestParam("vendorname") String vendorname, @RequestParam("vendor_desc") String vendordesc, @RequestParam("vendor_location") String vendorloc, @RequestParam("vendor_price") int vendorprice, @RequestParam("vendor_img") MultipartFile file, @RequestParam("id") int id) {
      if (file.isEmpty()) {
         this.vendorservice.updatevendorDetails(vendorname, vendordesc, vendorloc, vendorprice, id);
      } else {
         this.vendorservice.updateVendorDetailswithImage(vendorname, vendordesc, vendorloc, vendorprice, file, id);
      }

      if (role1.equals("subadmin") && role2.equals("not")) {
         return "redirect:/subadminvendordetails";
      } else {
         return role1.equals("not") && role2.equals("superadmin") ? "redirect:/superadminvendordetails" : "redirect:/adminvendordetails";
      }
   }
// Add Vendor
	@Controller
	public class VendorController {
	@RequestMapping(value = "/addvendorForm")
	public String saveVendor(@RequestParam("subadmin") String role1, @RequestParam("superadmin") String role2,
			@RequestParam("vendorname") String vendorname, @RequestParam("vendor_desc") String vendorDesc,
			@RequestParam("vendor_location") String vendorLoc, @RequestParam("vendor_price") int vendorprice,
			@RequestParam("vendor_img") MultipartFile file) {
		vendorservice.savevendortodb(file, vendorname, vendorDesc, vendorLoc, vendorprice);
		if (role1.equals("subadmin") && role2.equals("not")) {
			return "redirect:/subadminvendordetails";
		} else if (role1.equals("not") && role2.equals("superadmin")) {
			return "redirect:/superadminvendordetails";
		} else {
			return "redirect:/adminvendordetails";
		}

	}
	}

   @RequestMapping(
      value = {"/adminbookingdetails"},
      method = {RequestMethod.GET}
   )
   public String adminBookingDetails(ModelMap model) {
      List<Booking> booking = this.bookingservice.findAll();
      model.addAttribute("admin_booking", booking);
      return "AdminBookingDetails";
   }

   @RequestMapping(
      value = {"/adminaccount"},
      method = {RequestMethod.GET}
   )
   public String adminAccount(HttpSession session) {
      System.out.println(session.getAttribute("Admin_email"));
      return "AdminAccount";
   }

   @RequestMapping(
      value = {"/editadminprofile"},
      method = {RequestMethod.POST}
   )
   public String updateAdminProfile(@ModelAttribute("adminEditProfile") User admin, HttpSession session) {
      System.out.println(admin);
      this.userservice.updateUserProfile(admin.getEmail(), admin.getFirstName(), admin.getLastName(), admin.getGender(), admin.getContactno(), admin.getAddress(), admin.getRole(), admin.getPassword(), admin.getConfirmPassword(), admin.getId());
      session.setAttribute("Admin_firstname", admin.getFirstName());
      session.setAttribute("Admin_lastname", admin.getLastName());
      session.setAttribute("Admin_email", admin.getEmail());
      session.setAttribute("Admin_phone", admin.getContactno());
      session.setAttribute("Admin_address", admin.getAddress());
      session.setAttribute("Admin_gender", admin.getGender());
      session.setAttribute("Admin_id", admin.getId());
      session.setAttribute("Admin_role", admin.getRole());
      session.setAttribute("Admin_cpassword", admin.getConfirmPassword());
      session.setAttribute("Admin_password", admin.getPassword());
      return "redirect:/adminaccount";
   }
   
// Add event
	@Controller
	public class EventController {
	    @RequestMapping(value = "/addeventForm", method = RequestMethod.POST)
	    public String saveevent(@RequestParam("subadmin") String role1, @RequestParam("superadmin") String role2,
	            @RequestParam("eventname") String eventname, @RequestParam("event_desc") String eventDesc,
	            @RequestParam("event_img") MultipartFile file) {
	        eventservice.saveeventtoDB(file, eventname, eventDesc);
	        
	        if (role1.equals("subadmin") && role2.equals("not")) {
	            return "redirect:/subadmineventdetails";
	        } else if (role1.equals("not") && role2.equals("superadmin")) {
	            return "redirect:/superadmineventdetails";
	        } else {
	            return "redirect:/admineventdetails";
	        }
	    }
	}

   @RequestMapping(
      value = {"/admineventdetails"},
      method = {RequestMethod.GET}
   )
   public String adminEventDetails(ModelMap model) {
      List<Event> event = this.eventservice.findAll();
      model.addAttribute("eventlist", event);
      return "AdminEventDetails";
   }

   @RequestMapping(
      value = {"/admineventSearch"},
      method = {RequestMethod.POST}
   )
   public String adminEventSearch(@RequestParam("valueToSearch") String searchkey, ModelMap model) {
      System.out.println(searchkey);
      List event;
      if (searchkey.equals("")) {
         event = this.eventservice.findAll();
         model.addAttribute("eventlist", event);
         return "AdminEventDetails";
      } else {
         model.addAttribute("event_keyword", searchkey);
         event = this.eventservice.findBykey(searchkey);
         model.addAttribute("eventlist", event);
         return "AdminEventDetails";
      }
   }

   @RequestMapping({"/admindeleteevent/{id}"})
   public String admindeleteEvent(@PathVariable int id) {
      Event v = this.eventservice.findById(id);
      System.out.println(v);
      this.eventservice.deleteevent(id);
      return "redirect:/admineventdetails";
   }

   @RequestMapping(
      value = {"eventfind/{id}"},
      method = {RequestMethod.GET},
      produces = {"application/json"}
   )
   public ResponseEntity<Event> admineventEditDetails(@PathVariable("id") int id) {
      try {
         return new ResponseEntity(this.eventservice.findById(id), HttpStatus.OK);
      } catch (Exception var3) {
         return new ResponseEntity(HttpStatus.BAD_REQUEST);
      }
   }

   @RequestMapping(
      value = {"/EditeventForm"},
      method = {RequestMethod.POST}
   )
   public String updateevent(@RequestParam("subadmin") String role1, @RequestParam("superadmin") String role2, @RequestParam("eventname") String eventname, @RequestParam("event_desc") String eventdesc, @RequestParam("event_img") MultipartFile file, @RequestParam("id") int id) {
      if (file.isEmpty()) {
         this.eventservice.updateeventDetails(eventname, eventdesc, id);
      } else {
         this.eventservice.updateeventDetailswithImage(eventname, eventdesc, file, id);
      }

      if (role1.equals("subadmin") && role2.equals("not")) {
         return "redirect:/subadmineventdetails";
      } else {
         return role1.equals("not") && role2.equals("superadmin") ? "redirect:/superadmineventdetails" : "redirect:/admineventdetails";
      }
   }

   @RequestMapping(
      value = {"/bookcancelbyadmin"},
      method = {RequestMethod.POST}
   )
   public String UserBookingCancelAdmin(@RequestParam("booking_id") int booking_id) {
      this.bookingservice.bookingcancelByAdmin(booking_id);
      return "redirect:/adminbookingdetails";
   }

   @RequestMapping(
      value = {"/bookacceptbyadmin"},
      method = {RequestMethod.POST}
   )
   public String UserBookingAcceptAdmin(@RequestParam("booking_id") int booking_id) {
      this.bookingservice.bookingacceptByAdmin(booking_id);
      return "redirect:/adminbookingdetails";
   }

   @GetMapping({"/downloadExcel"})
   public void exportToExcel(HttpServletResponse response) throws IOException {
      response.setContentType("application/octet-stream");
      DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
      String currentDateTime = dateFormatter.format(new Date());
      String headerKey = "Content-Disposition";
      String headerValue = "attachment; filename=BookingDetails_" + currentDateTime + ".xlsx";
      response.setHeader(headerKey, headerValue);
      List<Booking> bookings = this.bookingservice.findAllandSortBy();
      UserExcelExporter excelExporter = new UserExcelExporter(bookings);
      excelExporter.export(response);
   }

   @RequestMapping(
      value = {"/adminlogout"},
      method = {RequestMethod.GET}
   )
   public String adminlogout(HttpSession session) {
      if (session != null) {
         session.removeAttribute("Admin_firstname");
         session.removeAttribute("Admin_lastname");
         session.removeAttribute("Admin_email");
         session.removeAttribute("Admin_phone");
         session.removeAttribute("Admin_address");
         session.removeAttribute("Admin_gender");
         session.removeAttribute("Admin_id");
         session.removeAttribute("Admin_cpassword");
         session.removeAttribute("Admin_password");
         session.removeAttribute("Admin_role");
      }

      return "redirect:/signin";
   }
}
