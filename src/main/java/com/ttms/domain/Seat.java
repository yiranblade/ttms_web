package com.ttms.domain;

/** 
 * @author  作者:yiranblade E-mail: 
 * @date 创建时间：2016年12月14日 下午2:49:10 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class Seat {
    private int seat_id;
    private boolean seat_status=true;
    private boolean is_sell=false;
    private int row;
    private int col;
    
    public int getSeat_id() {
        return seat_id;
    }
    
    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }
    
    public boolean isSeat_status() {
        return seat_status;
    }
    
    public void setSeat_status(boolean seat_status) {
        this.seat_status = seat_status;
    }
    
    public boolean isIs_sell() {
        return is_sell;
    }
    
    public void setIs_sell(boolean is_sell) {
        this.is_sell = is_sell;
    }
    
    public int getRow() {
        return row;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
    
    public int getCol() {
        return col;
    }
    
    public void setCol(int col) {
        this.col = col;
    }
    
    
}
