package com.test.andersen.entity.factory;

import com.test.andersen.entity.Wagon;
import com.test.andersen.entity.enums.WagonType;
import com.test.andersen.entity.info.EmptyData;
import com.test.andersen.entity.info.ManufacturerInfo;
import com.test.andersen.entity.wagons.DiningWagon;
import com.test.andersen.entity.wagons.FreightWagon;
import com.test.andersen.entity.wagons.PassengerWagon;
import com.test.andersen.entity.wagons.SleepingWagon;

public class WagonFactory {

    public static Wagon getWagon(WagonType tp, EmptyData emptyData, ManufacturerInfo manufInfo, int passengers, double loadCapacity) {

        if (tp == WagonType.PASSENGER)
            return new PassengerWagon(emptyData, manufInfo, passengers);

        if (tp == WagonType.SLEEPING)
            return new SleepingWagon(emptyData, manufInfo, passengers);

        if (tp == WagonType.DINING)
            return new DiningWagon(emptyData, manufInfo, passengers);

        if (tp == WagonType.FREIGHT)
            return new FreightWagon(emptyData, manufInfo, loadCapacity);

        return null;
    }
}
