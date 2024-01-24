package com.bv.annakshetra;

public class DonorData {

    public DonorData(String nameOfHotel, String nameOfDonor, String phonenum, String hotelAddress, String mapLink, String foodNum, String foodTime) {
        NameOfHotel = nameOfHotel;
        NameOfDonor = nameOfDonor;
        Phonenum = phonenum;
        HotelAddress = hotelAddress;
        MapLink = mapLink;
        FoodNum = foodNum;
        FoodTime = foodTime;
    }

    public String getNameOfHotel() {
        return NameOfHotel;
    }

    public String getNameOfDonor() {
        return NameOfDonor;
    }

    public String getPhonenum() {
        return Phonenum;
    }

    public String getHotelAddress() {
        return HotelAddress;
    }

    public String getMapLink() {
        return MapLink;
    }

    public String getFoodNum() {
        return FoodNum;
    }

    public String getFoodTime() {
        return FoodTime;
    }

    String NameOfHotel;
    String NameOfDonor;
    String Phonenum;
    String HotelAddress;
    String MapLink;
    String FoodNum ;
    String FoodTime;


}
