package com.test.andersen.entity.factory;

import com.test.andersen.entity.Locomotive;
import com.test.andersen.entity.enums.EngineType;
import com.test.andersen.entity.info.EmptyData;
import com.test.andersen.entity.info.ManufacturerInfo;
import com.test.andersen.entity.locomotives.DieselLocomotive;
import com.test.andersen.entity.locomotives.ElectricLocomotive;
import com.test.andersen.entity.locomotives.SteamLocomotive;

public class LocomotiveFactory {

    public static Locomotive geLocomotive(EngineType tp, EmptyData emptyData, ManufacturerInfo manufInfo, double tractiveForce) {

        if (tp == EngineType.DIESEL)
            return new DieselLocomotive(emptyData, manufInfo, tractiveForce);

        if (tp == EngineType.STEAM)
            return new SteamLocomotive(emptyData, manufInfo, tractiveForce);

        if (tp == EngineType.ELECTRIC)
            return new ElectricLocomotive(emptyData, manufInfo, tractiveForce);

        return null;
    }
}
