package com.test.andersen.entity.wagons;

import com.test.andersen.entity.Wagon;
import com.test.andersen.entity.enums.WagonType;
import com.test.andersen.entity.info.EmptyData;
import com.test.andersen.entity.info.ManufacturerInfo;

public class FreightWagon extends Wagon {

    private double loadCapacity;
    private WagonType wagonType = WagonType.FREIGHT;


    public FreightWagon(EmptyData emptyData, ManufacturerInfo manufInfo, double loadCapacity) {
        super(emptyData, manufInfo);

        if (loadCapacity < 0d)
            throw new IllegalArgumentException("Invalid parameter for loadCapacity");

        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double getFullWeight() {
        return getEmptyWeight() + loadCapacity;
    }

    public WagonType getWagonType() {
        return wagonType;
    }


}
