package com.test.andersen.entity;

import com.test.andersen.entity.abst.Container;
import com.test.andersen.entity.enums.EngineType;
import com.test.andersen.entity.info.EmptyData;
import com.test.andersen.entity.info.ManufacturerInfo;

public abstract class Locomotive extends Container {

    private ManufacturerInfo manufInfo;
    private double tractiveForce;
    private EngineType engineType;

    public Locomotive(EmptyData emptyData, ManufacturerInfo manufInfo, double tractiveForce, EngineType engineType) {
        super(emptyData);

        if (tractiveForce < 0d)
            throw new IllegalArgumentException("Invalid parameter for tractiveForce");

        this.manufInfo = manufInfo;
        this.tractiveForce = tractiveForce;
        this.engineType = engineType;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public ManufacturerInfo getManufInfo() {
        return manufInfo;
    }

    public void setManufInfo(ManufacturerInfo manufInfo) {
        this.manufInfo = manufInfo;
    }

    public double getTractiveForce() {
        return tractiveForce;
    }

    public void setTractiveForce(double tractiveForce) {
        this.tractiveForce = tractiveForce;
    }
}
