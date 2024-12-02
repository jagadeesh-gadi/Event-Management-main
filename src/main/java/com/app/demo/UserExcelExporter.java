package com.app.demo;
 
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
 
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.app.demo.model.Booking;
 
public class UserExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Booking> bookings;
     

    private String ev_date;
    private String status;
    public UserExcelExporter(List<Booking> bookings) {
        this.bookings = bookings;
        workbook = new XSSFWorkbook();
    }
 
 
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Bookings");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(12);
        style.setFont(font);
         
        createCell(row, 0, "Booking_Id", style);      
        createCell(row, 1, "User_FullName", style);       
        createCell(row, 2, "User_Email", style);    
        createCell(row, 3, "User_Phoneno", style);
        createCell(row, 4, "User_Address", style);
        createCell(row, 5, "User_Gender", style);
        createCell(row, 6, "EventName", style);
        createCell(row, 7, "HotelName", style);
        createCell(row, 8, "CateringName", style);
        createCell(row, 9, "DecoratorName(Id)", style);
        createCell(row, 10, "PhotographerName(Id)", style);
        createCell(row, 11, "DiscJockeyName(Id)", style);
        createCell(row, 12, "MakeupartistName(Id)", style);
        createCell(row, 13, "Booked on", style);
        createCell(row, 14, "Event Date", style);
        createCell(row, 15, "Number of guest", style);
        createCell(row, 16, "Event Max time", style);
        createCell(row, 17, "Event Start time", style);
        createCell(row, 18, "Hotel Price", style);
        createCell(row, 19, "Catering Price", style);
        createCell(row, 20, "Total Price", style);
    
       
         
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
     
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(10);
        style.setFont(font);
                 
        for (Booking book : bookings) {
        	
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
           
           
            if(book.getAccept_status()==1) {
            	this.status="Booking Accepted";
            }else if(book.getAccept_status()==2) {
            	this.status="Cancelled By Admin";
            }else {
            	this.status="Cancelled By User";
            }
            Date date = book.getEvent_date();  
            DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");  
            String strDate = dateFormat.format(date);  
            this.ev_date=strDate;
            createCell(row, columnCount++, book.getId(), style);
            createCell(row, columnCount++, book.getUser().getFirstName()+" "+book.getUser().getLastName(), style);
            createCell(row, columnCount++, book.getUser().getEmail(), style);
            createCell(row, columnCount++, book.getUser().getContactno(), style);
            createCell(row, columnCount++, book.getUser().getAddress(), style);
            createCell(row, columnCount++, book.getUser().getGender(), style);
            createCell(row, columnCount++, book.getEvent().getEventname(), style);
            createCell(row, columnCount++, book.getHotel().getHotelName(), style);
            createCell(row, columnCount++, book.getCatering().getCatername(), style);
            createCell(row, columnCount++, book.getDecorator_name_desc(), style);
            createCell(row, columnCount++, book.getPhotographer_name_desc(), style);
            createCell(row, columnCount++, book.getDj_name_desc(), style);
            createCell(row, columnCount++, book.getMakeupartist_name_desc(), style);
            createCell(row, columnCount++, book.getCurrent_date(), style);
            createCell(row, columnCount++, ev_date, style);
            createCell(row, columnCount++, book.getNo_of_guest(), style);
            createCell(row, columnCount++, book.getMax_total_hour()+" hours", style);
            createCell(row, columnCount++, book.getStart_at(), style);
            createCell(row, columnCount++, "Rs."+book.getHotel().getPrice(), style);
            createCell(row, columnCount++, "Rs."+book.getCatering().getCater_price(), style);
            createCell(row, columnCount++, "Rs."+book.getAmount(), style);
            
           
        }
    }
     
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
         
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }
}