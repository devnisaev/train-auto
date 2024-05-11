package com.test.andersen.entity.wagons;

import com.test.andersen.entity.enums.WagonType;
import com.test.andersen.entity.info.EmptyData;
import com.test.andersen.entity.info.ManufacturerInfo;
import com.test.andersen.entity.wagons.live.LiveWagon;

public class PassengerWagon extends LiveWagon {

    private int passengersSitting;

    public PassengerWagon(EmptyData emptyData, ManufacturerInfo manufInfo, int passengers) {
        super(emptyData, manufInfo, WagonType.PASSENGER, passengers);
        passengersSitting = passengers;
    }

    public int getPassengersSitting() {
        return passengersSitting;
    }


    public int getConductorsNum() {
        return getConductors(passengersSitting);
    }

}
