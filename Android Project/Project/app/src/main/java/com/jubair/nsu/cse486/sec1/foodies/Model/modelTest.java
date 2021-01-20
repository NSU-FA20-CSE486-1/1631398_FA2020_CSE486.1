package com.jubair.nsu.cse486.sec1.foodies.Model;

public class modelTest {
    String Menu,CustomerName,EventDate,Quantity,CustomerPhone ;
    String TotalAmount;

    public modelTest() {
    }

    public modelTest(String Menu, String CustomerName,String EventDate,String Quantity, String CustomerPhone) {
        this.Menu = Menu;
        this.CustomerName = CustomerName;
        this.TotalAmount = TotalAmount;
        this.EventDate = EventDate;
        this.Quantity = Quantity;
        this.CustomerPhone = CustomerPhone;
    }


    public String getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        TotalAmount = totalAmount;
    }


    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getCustomerPhone() {
        return CustomerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        CustomerPhone = customerPhone;
    }

    public String getEventDate() {
        return EventDate;
    }

    public void setEventDate(String eventDate) {
        EventDate = eventDate;
    }


    public String getMenu() {
        return Menu;
    }

    public void setMenu(String menu) {
        Menu = menu;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }
}
