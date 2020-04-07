package com.darly.rnmodule.viewmodule;

import android.view.View;

import androidx.annotation.NonNull;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
import com.darly.rnmodule.ModuleEnum;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

/**
 * author:zhangyuhui
 * date:2020-04-0317:11
 * description: 高德地图提供到RN的地图控件
 */
public class LbsMapManager extends SimpleViewManager<View> {
    @NonNull
    @Override
    public String getName() {
        return ModuleEnum.LBSMAPMANAGER.getDesc();
    }

    @NonNull
    @Override
    protected View createViewInstance(@NonNull ThemedReactContext reactContext) {
        MapView mapView = new MapView(reactContext);
        return mapView;
    }

    public AMap getMap(MapView mapView){
        if (mapView!=null){
            //初始化地图控制器对象
          return mapView.getMap();
        }
        return null;
    }

    protected void onDestroy(MapView mapView) {
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mapView.onDestroy();
    }
    protected void onResume(MapView mapView) {
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mapView.onResume();
    }
    protected void onPause(MapView mapView) {

        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mapView.onPause();
    }

}