package com.test.andersen.traintest;

import com.test.andersen.entity.Locomotive;
import com.test.andersen.entity.Train;
import com.test.andersen.entity.Wagon;
import com.test.andersen.entity.enums.EngineType;
import com.test.andersen.entity.enums.WagonType;
import com.test.andersen.entity.factory.LocomotiveFactory;
import com.test.andersen.entity.factory.WagonFactory;
import com.test.andersen.entity.info.EmptyData;
import com.test.andersen.entity.info.ManufacturerInfo;
import com.test.andersen.entity.wagons.FreightWagon;
import com.test.andersen.entity.wagons.live.LiveWagon;

import java.util.ArrayList;
import java.util.List;

public class TrainBuilderTest {

    public Train getCustomTrain(EngineType engineType, boolean hasBackLocomotive, int numPassWgns, int numSleepWgns, int numFreightWgns, int manYear) {

        EmptyData initDataLocomotive = new EmptyData(15, 10);
        EmptyData initDataPassWag = new EmptyData(15, 20);
        EmptyData initDataSleepWag = new EmptyData(15, 20);
        EmptyData initDataFreightWag = new EmptyData(15, 20);

        List<Locomotive> listLocomotives = getLocomotives(engineType, true, manYear, initDataLocomotive);
        Locomotive locForward = listLocomotives.get(0);
        Locomotive locBackward = hasBackLocomotive ? listLocomotives.get(1) : null;

        List<LiveWagon> listPassWag = getPassWagons(numPassWgns, manYear, initDataPassWag);

        List<LiveWagon> listSleepWag = getSleepWagons(numSleepWgns, manYear, initDataSleepWag);

        List<FreightWagon> listFreightWag = getFreightWagons(numFreightWgns, manYear, initDataFreightWag);

        List<LiveWagon> allWagonsLive = new ArrayList<LiveWagon>();
        allWagonsLive.addAll(listPassWag);
        allWagonsLive.addAll(listSleepWag);

        return new Train(locForward, allWagonsLive, listFreightWag, locBackward);
    }

    public List<Locomotive> getLocomotives(EngineType tp, boolean hasBackLocomotive, int manYear, EmptyData initData) {
        double tractiveForce = 1000;
        String serialNoPref = "ABCD-000";
        int numLocs = hasBackLocomotive ? 2 : 1;

        ArrayList<Locomotive> list = new ArrayList<Locomotive>();

        for (int i = 1; i <= numLocs; i++) {
            ManufacturerInfo locInfo = new ManufacturerInfo("LOC-" + tp.name(), "STX-Ocean", serialNoPref + i, manYear);
            Locomotive locomotive = LocomotiveFactory.geLocomotive(tp, initData, locInfo, tractiveForce);
            list.add(locomotive);
        }
        return list;
    }

    public List<LiveWagon> getPassWagons(int numPassWgns, int manYear, EmptyData initData) {
        String serialNoPref = "EE-SJF-000";
        double loadCapacity = 0d;

        int num = numPassWgns;

        ArrayList<LiveWagon> list = new ArrayList<LiveWagon>();
        for (int i = 1; i <= num; i++) {
            ManufacturerInfo wagonInfo = new ManufacturerInfo("WGN-PASSENGER", "STX-Ocean", serialNoPref + i, manYear);
            Wagon wgn = WagonFactory.getWagon(WagonType.PASSENGER, initData, wagonInfo, 50, loadCapacity);
            list.add((LiveWagon) wgn);
        }
        return list;
    }

    public List<LiveWagon> getSleepWagons(int numSleepWgns, int manYear, EmptyData initData) {
        String serialNoPref = "FF-SJF-000";
        double loadCapacity = 0d;

        int num = numSleepWgns;

        ArrayList<LiveWagon> list = new ArrayList<LiveWagon>();
        for (int i = 1; i <= num; i++) {
            ManufacturerInfo wagonInfo = new ManufacturerInfo("WGN-SLEEP", "STX-Ocean", serialNoPref + i, manYear);
            Wagon wgn = WagonFactory.getWagon(WagonType.SLEEPING, initData, wagonInfo, 50, loadCapacity);
            list.add((LiveWagon) wgn);
        }
        return list;
    }

    public List<FreightWagon> getFreightWagons(int numFreightWgns, int manYear, EmptyData initData) {
        String serialNoPref = "GG-SJF-000";
        double loadCapacity = 40d;

        int num = numFreightWgns;

        ArrayList<FreightWagon> list = new ArrayList<FreightWagon>();
        for (int i = 1; i <= num; i++) {
            ManufacturerInfo wagonInfo = new ManufacturerInfo("WGN-FREIGHT", "STX-Ocean", serialNoPref + i, manYear);
            Wagon wgn = WagonFactory.getWagon(WagonType.FREIGHT, initData, wagonInfo, 0, loadCapacity);
            list.add((FreightWagon) wgn);
        }
        return list;
    }
}
