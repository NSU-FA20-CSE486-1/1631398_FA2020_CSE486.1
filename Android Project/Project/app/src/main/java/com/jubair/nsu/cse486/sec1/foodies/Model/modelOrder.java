package com.jubair.nsu.cse486.sec1.foodies.Model;

public class modelOrder {
    String Menu,TotalAmount,EventDate,Quantity,CustomerName,CustomerAddress,CustomerPhone  ;


    public modelOrder() {
    }

    public modelOrder(String Menu, String TotalAmount,String EventDate,String Quantity, String CustomerName,  String CustomerPhone ) {
        this.Menu = Menu;
        this.TotalAmount = TotalAmount;
        this.EventDate = EventDate;
        this.Quantity = Quantity;
        this.CustomerName = CustomerName;
        this.CustomerPhone = CustomerPhone;
    }

    public String getMenu() {
        return Menu;
    }

    public void setMenu(String menu) {
        Menu = menu;
    }

    public String getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        TotalAmount = totalAmount;
    }

    public String getEventDate() {
        return EventDate;
    }

    public void setEventDate(String eventDate) {
        EventDate = eventDate;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        CustomerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return CustomerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        CustomerPhone = customerPhone;
    }
}
