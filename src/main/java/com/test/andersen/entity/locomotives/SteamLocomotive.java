package com.test.andersen.entity.locomotives;

import com.test.andersen.entity.Locomotive;
import com.test.andersen.entity.enums.EngineType;
import com.test.andersen.entity.info.EmptyData;
import com.test.andersen.entity.info.ManufacturerInfo;

public class SteamLocomotive extends Locomotive {

    public SteamLocomotive(EmptyData emptyData, ManufacturerInfo manufInfo, double tractiveForce) {
        super(emptyData, manufInfo, tractiveForce, EngineType.STEAM);
    }
}
