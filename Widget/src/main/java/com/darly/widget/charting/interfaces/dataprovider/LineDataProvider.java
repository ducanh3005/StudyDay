package com.darly.widget.charting.interfaces.dataprovider;

import com.darly.widget.charting.components.YAxis;
import com.darly.widget.charting.data.LineData;

public interface LineDataProvider extends BarLineScatterCandleBubbleDataProvider {

    LineData getLineData();

    YAxis getAxis(YAxis.AxisDependency dependency);
}
