package com.test.andersen.entity;

import com.test.andersen.entity.enums.WagonType;
import com.test.andersen.entity.wagons.FreightWagon;
import com.test.andersen.entity.wagons.PassengerWagon;
import com.test.andersen.entity.wagons.SleepingWagon;
import com.test.andersen.entity.wagons.live.LiveWagon;

import java.util.List;

public class Train {
    private Locomotive locomotiveForward;
    private Locomotive locomotiveBackward;

    private List<LiveWagon> liveWagons;
    private List<FreightWagon> freightWagons;

    public Train(Locomotive locomotiveForward, List<LiveWagon> liveWagons, List<FreightWagon> freightWagons, Locomotive locomotiveBackward) {
        this.locomotiveForward = locomotiveForward;
        this.liveWagons = liveWagons;
        this.freightWagons = freightWagons;
        this.locomotiveBackward = locomotiveBackward;
    }

    public Train(Locomotive locomotiveForward, List<LiveWagon> liveWagons, List<FreightWagon> freightWagons) {
        this.locomotiveForward = locomotiveForward;
        this.liveWagons = liveWagons;
        this.freightWagons = freightWagons;
        this.locomotiveBackward = null;
    }

    public Train(Locomotive locomotiveForward, List<LiveWagon> liveWagons, Locomotive locomotiveBackward) {
        this.locomotiveForward = locomotiveForward;
        this.liveWagons = liveWagons;
        this.freightWagons = null;
        this.locomotiveBackward = locomotiveBackward;
    }

    public Train(Locomotive locomotiveForward, List<FreightWagon> freightWagons) {
        this.locomotiveForward = locomotiveForward;
        this.liveWagons = null;
        this.freightWagons = freightWagons;
        this.locomotiveBackward = null;
    }

    public Train(Locomotive locomotiveForward) {
        this.locomotiveForward = locomotiveForward;
        this.liveWagons = null;
        this.freightWagons = null;
        this.locomotiveBackward = null;
    }

    public double getWholeTrainEmptyWeight() {
        double w1 = locomotiveForward.getEmptyWeight();
        double w2 = locomotiveBackward != null ? locomotiveBackward.getEmptyWeight() : 0d;
        double w3 = getEmptyWeightLiveWagons();
        double w4 = getEmptyWeightFreightWagons();

        return (w1 + w2 + w3 + w4);
    }

    public int getWholeTrainMaxPassengers() {
        return getMaxPassengersLiveWagons();
    }

    public double getWholeTrainMaxFreightWeight() {
        double sm = 0d;
        if (freightWagons != null) {
            for (FreightWagon wagon : freightWagons) {
                sm += wagon.getFullWeight();
            }
        }
        return sm;
    }

    public double getWholeTrainMaxPassengersWeight() {
        double sm = 0d;
        if (liveWagons != null) {
            for (LiveWagon wagon : liveWagons) {
                sm += wagon.getPassengersWeight();
            }
        }
        return sm;
    }

    public double getWholeTrainMaxPassengersWeightFull() {
        double sm = 0d;
        if (liveWagons != null) {
            for (LiveWagon wagon : liveWagons) {
                sm += wagon.getFullWeight();
            }
        }
        return sm;
    }

    public double getWholeTrainFullWeight() {
        double w1 = locomotiveForward.getFullWeight();
        double w2 = locomotiveBackward != null ? locomotiveBackward.getFullWeight() : 0d;
        double w3 = getWholeTrainMaxFreightWeight();
        double w4 = getWholeTrainMaxPassengersWeightFull();

        return (w1 + w2 + w3 + w4);
    }

    public double getWholeTrainFullLength() {
        double len1 = locomotiveForward.getLength();
        double len2 = locomotiveBackward != null ? locomotiveBackward.getLength() : 0;
        double len3 = getLengthLiveWagons();
        double len4 = getLengthFreightWagons();

        return (len1 + len2 + len3 + len4);
    }

    public boolean isTrainMoving() {
        int num = getWholeTrainMaxPassengers();
        return (num > 0);
    }

    public boolean isTrainCanPullLoad() {
        double maxPullForce = locomotiveForward.getTractiveForce();
        double maxWeight = getWholeTrainFullWeight();
        return (maxPullForce > maxWeight);
    }

    public double getTrainMaxCanPullWeight() {
        return locomotiveForward.getTractiveForce();
    }

    public double getWholeTrainMaxConductors() {
        int sm = 0;
        if (liveWagons != null) {
            for (LiveWagon wagon : liveWagons) {
                if (wagon.getWagonType() == WagonType.PASSENGER) {
                    sm += ((PassengerWagon) wagon).getConductorsNum();
                }
                if (wagon.getWagonType() == WagonType.SLEEPING) {
                    sm += ((SleepingWagon) wagon).getConductorsNum();
                }
            }
        }
        return sm;
    }

    public Locomotive getLocomotiveForward() {
        return locomotiveForward;
    }

    public Locomotive getLocomotiveBackward() {
        return locomotiveBackward;
    }

    public List<LiveWagon> getLiveWagons() {
        return liveWagons;
    }

    public List<FreightWagon> getFreightWagons() {
        return freightWagons;
    }


    private double getEmptyWeightLiveWagons() {
        double sm = 0d;
        if (liveWagons != null) {
            for (LiveWagon wagon : liveWagons) {
                sm += wagon.getEmptyWeight();
            }
        }
        return sm;
    }

    private double getEmptyWeightFreightWagons() {
        double sm = 0d;
        if (freightWagons != null) {
            for (FreightWagon wagon : freightWagons) {
                sm += wagon.getEmptyWeight();
            }
        }
        return sm;
    }

    private int getMaxPassengersLiveWagons() {
        int sm = 0;
        if (liveWagons != null) {
            for (LiveWagon wagon : liveWagons) {
                sm += wagon.getPassengers();
            }
        }
        return sm;
    }

    private double getLengthLiveWagons() {
        double sm = 0;
        if (liveWagons != null) {
            for (LiveWagon wagon : liveWagons) {
                sm += wagon.getLength();
            }
        }
        return sm;
    }

    private double getLengthFreightWagons() {
        double sm = 0;
        if (freightWagons != null) {
            for (FreightWagon wagon : freightWagons) {
                sm += wagon.getLength();
            }
        }
        return sm;
    }
}
