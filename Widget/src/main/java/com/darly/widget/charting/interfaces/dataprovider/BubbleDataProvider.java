package com.darly.widget.charting.interfaces.dataprovider;

import com.darly.widget.charting.data.BubbleData;

public interface BubbleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    BubbleData getBubbleData();
}
