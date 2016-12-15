package com.ttms.domain;

import java.util.List;

/** 
 * @author  作者:yiranblade E-mail: 
 * @date 创建时间：2016年12月14日 下午2:49:21 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class Studio {
    private int Studio_id;
    private String Studio_area;
    private int Studio_seat_row;
    private int Studio_seat_colu;
    private List<Seat> seats;
    
    public int getStudio_id() {
        return Studio_id;
    }
    
    public void setStudio_id(int studio_id) {
        Studio_id = studio_id;
    }
    
    public String getStudio_area() {
        return Studio_area;
    }
    
    public void setStudio_area(String studio_area) {
        Studio_area = studio_area;
    }
    
    public int getStudio_seat_row() {
        return Studio_seat_row;
    }
    
    public void setStudio_seat_row(int studio_seat_row) {
        Studio_seat_row = studio_seat_row;
    }
    
    public int getStudio_seat_colu() {
        return Studio_seat_colu;
    }
    
    public void setStudio_seat_colu(int studio_seat_colu) {
        Studio_seat_colu = studio_seat_colu;
    }

    
    public List<Seat> getSeats() {
        return seats;
    }

    
    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
    
    

}
