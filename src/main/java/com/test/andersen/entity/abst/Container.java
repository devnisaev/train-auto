package com.test.andersen.entity.abst;

import com.test.andersen.entity.info.EmptyData;

public class Container {
    private EmptyData initData;

    public Container() {
    }

    public Container(EmptyData emptyData) {
        this.initData = emptyData;
    }

    public EmptyData getInitData() {
        return initData;
    }

    public void setInitData(EmptyData initData) {
        this.initData = initData;
    }

    public final double getEmptyWeight() {
        return initData.getEmptyWeight();
    }

    public final double getLength() {
        return initData.getLength();
    }


    public double getFullWeight() {
        return initData.getEmptyWeight();
    }
}


