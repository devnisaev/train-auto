package com.test.andersen.entity;

import com.test.andersen.entity.abst.Container;
import com.test.andersen.entity.info.EmptyData;
import com.test.andersen.entity.info.ManufacturerInfo;

public abstract class Wagon extends Container {
    private ManufacturerInfo manufInfo;

    public Wagon() {

    }

    public Wagon(EmptyData emptyData, ManufacturerInfo manufInfo) {
        super(emptyData);
        this.manufInfo = manufInfo;
    }

    public ManufacturerInfo getManufInfo() {
        return manufInfo;
    }

    public void setManufInfo(ManufacturerInfo manufInfo) {
        this.manufInfo = manufInfo;
    }
}
