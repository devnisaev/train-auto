package com.test.andersen.entity.wagons.live;

import com.test.andersen.entity.Wagon;
import com.test.andersen.entity.enums.WagonType;
import com.test.andersen.entity.info.EmptyData;
import com.test.andersen.entity.info.ManufacturerInfo;

public class LiveWagon extends Wagon {
    private final double avgPassengerWeight = 0.075;
    private final double avgPassengerLoadWeight = 0.025;

    private WagonType wagonType;
    private int passengers;

    public LiveWagon() {

    }

    public LiveWagon(EmptyData emptyData, ManufacturerInfo manufInfo, WagonType wagonType, int passengers) {
        super(emptyData, manufInfo);

        if (passengers < 0)
            throw new IllegalArgumentException("Invalid parameter for passengers");

        this.wagonType = wagonType;
        this.passengers = passengers;
    }

    public WagonType getWagonType() {
        return wagonType;
    }

    public void setWagonType(WagonType wagonType) {
        this.wagonType = wagonType;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public double getPassengersWeight() {
        return (avgPassengerWeight + avgPassengerLoadWeight) * passengers;
    }

    @Override
    public double getFullWeight() {
        double w1 = getEmptyWeight();
        double w2 = (avgPassengerWeight + avgPassengerLoadWeight) * passengers;
        return w1 + w2;
    }

    protected int getConductors(int passengers) {
        int minGroup = 50;

        if (passengers > 0 && passengers <= minGroup)
            return 1;

        int groups = passengers / minGroup;
        int left = passengers % minGroup;

        if (left == 0)
            return groups;


        return (groups + 1);
    }
}
