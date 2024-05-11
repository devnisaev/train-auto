package com.test.andersen.entity.locomotives;

import com.test.andersen.entity.Locomotive;
import com.test.andersen.entity.enums.EngineType;
import com.test.andersen.entity.info.EmptyData;
import com.test.andersen.entity.info.ManufacturerInfo;

public class DieselLocomotive extends Locomotive {

    public DieselLocomotive(EmptyData emptyData, ManufacturerInfo manufInfo, double tractiveForce) {
        super(emptyData, manufInfo, tractiveForce, EngineType.DIESEL);
    }
}
