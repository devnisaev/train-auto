package com.test.andersen.entity.wagons;

import com.test.andersen.entity.enums.WagonType;
import com.test.andersen.entity.info.EmptyData;
import com.test.andersen.entity.info.ManufacturerInfo;
import com.test.andersen.entity.wagons.live.LiveWagon;

public class DiningWagon extends LiveWagon {

    private int passengersDining;

    public DiningWagon() {

    }

    public DiningWagon(EmptyData emptyData, ManufacturerInfo manufInfo, int passengers) {
        super(emptyData, manufInfo, WagonType.DINING, passengers);
        passengersDining = passengers;
    }

    public int getPassengersDining() {
        return passengersDining;
    }

}
