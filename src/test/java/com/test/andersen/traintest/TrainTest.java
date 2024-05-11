package com.test.andersen.traintest;

import com.test.andersen.entity.Locomotive;
import com.test.andersen.entity.Train;
import com.test.andersen.entity.abst.Container;
import com.test.andersen.entity.enums.EngineType;
import com.test.andersen.entity.enums.WagonType;
import com.test.andersen.entity.info.EmptyData;
import com.test.andersen.entity.info.ManufacturerInfo;
import com.test.andersen.entity.locomotives.DieselLocomotive;
import com.test.andersen.entity.wagons.SleepingWagon;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class TrainTest {

    Logger logger = LoggerFactory.getLogger(TrainTest.class);


    @Test
    public void Test_Container() {
        EmptyData ed = new EmptyData(10d, 20d);
        Container ctr = new Container(ed);

        assert (ctr.getInitData().equals(ed));

        assert (ctr.getFullWeight() == 10d);

        assert (ctr.getInitData().getLength() == 20d);
    }

    @Test
    public void Test_Container_Exceptions() {
        try {
            EmptyData edata = new EmptyData(-10d, -20d);
            Container ctr = new Container(edata);
        } catch (Exception t) {
            assert (t instanceof IllegalArgumentException);
        }
    }

    @Test
    public void Test_Enum_EngineType() {
        EngineType engineType = EngineType.DIESEL;

        assert (engineType.name().equals("DIESEL"));
        assert (EngineType.values().length == 3);
        assert (EngineType.values()[1] == EngineType.STEAM);
    }


    @Test
    public void Test_WagonType() {
        WagonType wagonType = WagonType.PASSENGER;

        assert (!wagonType.name().equals("passenger"));
        assert (wagonType.values().length == 4);
        assert (wagonType.values()[2] == WagonType.DINING);
    }


    @Test
    public void Should_Pass_All_EmptyData_Tests_Using_All_Testers() {
        EmptyData emptyData = Mockito.spy(new EmptyData());
        emptyData.getLength();
        emptyData.getEmptyWeight();
        emptyData.setLength(20d);
        emptyData.setEmptyWeight(50d);
        assertEquals(emptyData.getLength(), 20d);
    }

    @Test
    public void Should_Pass_All_ManufInfo_Using_All_Testers() {
        ManufacturerInfo manInfo = Mockito.spy(getManufacturerData());

        assertEquals(manInfo.getConstructionYear(), 2010);
        assertEquals(manInfo.getManufacturer(), "SpainRails");
        assertEquals(manInfo.getSerialNo(), "XX-DF65-67FG");
    }

    @Test
    public void Should_Check_Locomotive_Data() {
        EmptyData emptyData = getInitData();
        ManufacturerInfo manufInfo = getManufacturerData();
        try {
            Locomotive loc = new DieselLocomotive(emptyData, manufInfo, -100d);
        } catch (Exception t) {
            assert (t instanceof IllegalArgumentException);
        }
    }


    @Test
    public void Should_Pass_All_SleepingWagon_Using_All_Testers() {

        EmptyData initData = getInitData();

        ManufacturerInfo manInfo = getManufacturerData();

        SleepingWagon wagon = Mockito.spy(new SleepingWagon(initData, manInfo, 100));

        assertEquals(wagon.getInitData().getEmptyWeight(), 20d);
        assertEquals(wagon.getManufInfo().getConstructionYear(), 2010);
        assertEquals(wagon.getManufInfo().getManufacturer(), "SpainRails");
        assertEquals(wagon.getPassengers(), 100);
        assertEquals(wagon.getWagonType(), WagonType.SLEEPING);
        assertEquals(wagon.getConductorsNum(), 2);
    }


    @Test
    public void Should_Pass_All_FreightWagon_Using_All_Testers() {

        EmptyData initData = getInitData();

        ManufacturerInfo manInfo = getManufacturerData();

        SleepingWagon wagon = Mockito.spy(new SleepingWagon(initData, manInfo, 100));

        assertEquals(wagon.getInitData().getEmptyWeight(), 20d);
        assertEquals(wagon.getManufInfo().getConstructionYear(), 2010);
        assertEquals(wagon.getManufInfo().getManufacturer(), "SpainRails");
        assertEquals(wagon.getPassengers(), 100);
        assertEquals(wagon.getWagonType(), WagonType.SLEEPING);
        assertEquals(wagon.getConductorsNum(), 2);
    }

    @Test
    public void Should_Pass_All_Train_Using_All_Testers() {
        TrainBuilderTest tb = new TrainBuilderTest();
        Train train = Mockito.spy(tb.getCustomTrain(EngineType.DIESEL, true, 5, 5, 10, 2000));

        assertNotEquals(train.getLocomotiveBackward(), null);
        assertEquals(train.getLocomotiveForward().getEngineType(), EngineType.DIESEL);
        assertEquals(train.getLocomotiveBackward().getEngineType(), EngineType.DIESEL);

        assertEquals(train.getWholeTrainMaxPassengers(), (5 + 5) * 50);
        assertEquals(train.getWholeTrainMaxConductors(), 10);

        assertEquals(train.getLiveWagons().size(), 10);
        assertEquals(train.getFreightWagons().size(), 10);
    }

    @Test
    public void Should_Print_All_Train_Data() {

        TrainBuilderTest tb = new TrainBuilderTest();
        Train train = Mockito.spy(tb.getCustomTrain(EngineType.STEAM, true, 5, 5, 10, 2005));

        assertEquals(train.getLiveWagons().size(), 10);
        assertEquals(train.getFreightWagons().size(), 10);

        String meas = " [tons]";

        logger.info("Locomotive 1 Weight: " + train.getLocomotiveForward().getFullWeight() + meas);
        logger.info("Locomotive 2 Weight: " + train.getLocomotiveBackward().getFullWeight() + meas);
        logger.info("TrainEmptyWeight: " + train.getWholeTrainEmptyWeight() + meas);
        logger.info("TrainMaxPassengers: " + train.getWholeTrainMaxPassengers());
        logger.info("TrainMaxPassengersWeight: " + train.getWholeTrainMaxPassengersWeight() + meas);
        logger.info("TrainMaxPassengersWeightFull: " + train.getWholeTrainMaxPassengersWeightFull() + meas + " (passengers + wagons)"); //passengers + wagons
        logger.info("MaxFreightWeight: " + train.getWholeTrainMaxFreightWeight() + meas);

        logger.info("TrainFullWeight: " + train.getWholeTrainFullWeight() + meas);
        logger.info("TrainMaxCanPullWeight: " + train.getTrainMaxCanPullWeight() + meas);
        logger.info("TrainFullLength: " + train.getWholeTrainFullLength() + " meters");
        logger.info("IsTrainMoving: " + train.isTrainMoving());
        logger.info("IsTrainCanPullLoad: " + train.isTrainCanPullLoad());
        logger.info("TrainMaxConductors: " + train.getWholeTrainMaxConductors());

    }

    private EmptyData getInitData() {
        return new EmptyData(20d, 50d);
    }

    private ManufacturerInfo getManufacturerData() {
        ManufacturerInfo manInfo = new ManufacturerInfo("WW-AB7-DT8-235", "SpainRails", "XX-DF65-67FG", 2010);
        return manInfo;
    }
}
