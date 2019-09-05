package com.darly.widget.charting.interfaces.dataprovider;

import com.darly.widget.charting.components.YAxis.AxisDependency;
import com.darly.widget.charting.data.BarLineScatterCandleBubbleData;
import com.darly.widget.charting.utils.Transformer;

public interface BarLineScatterCandleBubbleDataProvider extends ChartInterface {

    Transformer getTransformer(AxisDependency axis);
    boolean isInverted(AxisDependency axis);
    
    float getLowestVisibleX();
    float getHighestVisibleX();

    BarLineScatterCandleBubbleData getData();
}
