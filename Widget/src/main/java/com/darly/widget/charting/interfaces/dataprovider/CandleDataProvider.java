package com.darly.widget.charting.interfaces.dataprovider;

import com.darly.widget.charting.data.CandleData;

public interface CandleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    CandleData getCandleData();
}
