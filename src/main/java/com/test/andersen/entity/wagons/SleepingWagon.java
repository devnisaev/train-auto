package com.test.andersen.entity.wagons;

import com.test.andersen.entity.enums.WagonType;
import com.test.andersen.entity.info.EmptyData;
import com.test.andersen.entity.info.ManufacturerInfo;
import com.test.andersen.entity.wagons.live.LiveWagon;

public class SleepingWagon extends LiveWagon {

    private int passengersSleeping;

    public SleepingWagon() {

    }

    public SleepingWagon(EmptyData emptyData, ManufacturerInfo manufInfo, int passengers) {
        super(emptyData, manufInfo, WagonType.SLEEPING, passengers);
        passengersSleeping = passengers;
    }

    public int getPassengersSleeping() {
        return passengersSleeping;
    }

    public void setPassengersSleeping(int passengersSleeping) {
        this.passengersSleeping = passengersSleeping;
    }

    public int getConductorsNum() {
        return getConductors(passengersSleeping);
    }


}
