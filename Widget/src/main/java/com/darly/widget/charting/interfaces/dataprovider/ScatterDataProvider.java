package com.darly.widget.charting.interfaces.dataprovider;

import com.darly.widget.charting.data.ScatterData;

public interface ScatterDataProvider extends BarLineScatterCandleBubbleDataProvider {

    ScatterData getScatterData();
}
