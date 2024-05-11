package com.test.andersen.entity.info;

public class ManufacturerInfo {

    private String type;
    private String manufacturer;
    private String serialNo;
    private int constructionYear;

    public ManufacturerInfo() {

    }

    public ManufacturerInfo(String type, String manufacturer, String serialNo, int constructionYear) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.serialNo = serialNo;
        this.constructionYear = constructionYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public int getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(int constructionYear) {
        this.constructionYear = constructionYear;
    }
}
