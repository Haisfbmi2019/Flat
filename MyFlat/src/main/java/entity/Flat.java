package entity;

public class Flat {
    private String flatID;
    private String district;
    private String address;
    private double area;
    private int roomNumber;
    private int price;

    public Flat(String flatID, String district,String address, double area, int roomNumber, int price) {
        this.flatID = flatID;
        this.district = district;
        this.address = address;
        this.area = area;
        this.roomNumber = roomNumber;
        this.price = price;
    }


    public Flat() {
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFlatID() {
        return flatID;
    }

    public void setFlatID(String flatID) {
        this.flatID = flatID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "entity.Flat{" +
                "flatID='" + flatID + '\'' +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", area=" + area +
                ", roomNumber=" + roomNumber +
                ", price=" + price +
                '}';
    }
}
