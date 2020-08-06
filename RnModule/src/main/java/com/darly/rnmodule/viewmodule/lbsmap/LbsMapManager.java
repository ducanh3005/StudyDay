package com.darly.rnmodule.viewmodule.lbsmap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.darly.rnmodule.ModuleEnum;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;

/**
 * author:zhangyuhui
 * date:2020-04-0317:11
 * description: 高德地图提供到RN的地图控件
 */
public class LbsMapManager extends SimpleViewManager<LbsMapView> {
    @NonNull
    @Override
    public String getName() {
        return ModuleEnum.LBSMAPMANAGER.getDesc();
    }

    @NonNull
    @Override
    protected LbsMapView createViewInstance(@NonNull ThemedReactContext reactContext) {
        LbsMapView mapView = new LbsMapView(reactContext.getCurrentActivity(), reactContext);
        return mapView;
    }

    // 设置地图来源，100为轨迹，空或者其他值来源其他，这个参数在React Native对应的MapView 中进行配置
    @ReactProp(name = "tag")
    public void setTag(LbsMapView mapView, int tag) {
        mapView.addTag(tag);
    }

    // 更改中心点，这个参数在React Native对应的MapView 中进行配置
    @ReactProp(name = "location")
    public void setLocation(LbsMapView mapView, ReadableMap map) {
        mapView.setLocation(map);
    }

    // 更改缩放级别，这个参数在React Native对应的MapView 中进行配置
    @ReactProp(name = "zoomLevel", defaultInt = 17)
    public void setZoomLevel(LbsMapView mapView, int level) {
        mapView.setZoomLevel(level);
    }

    // 绘制点，这个参数在React Native对应的MapView 中进行配置
    @ReactProp(name = "marker")
    public void setMarker(LbsMapView mapView, ReadableArray array) {
        mapView.addMarker(array);
    }

    // 绘制点以及路径，这个参数在React Native对应的MapView 中进行配置
    @ReactProp(name = "markerAndRoute")
    public void setMarkerAndRoute(LbsMapView mapView, ReadableArray array) {
        mapView.addMarkerAndRoute(array);
    }

    // 绘制圆，这个参数在React Native对应的MapView 中进行配置
    @ReactProp(name = "circle")
    public void setCircle(LbsMapView mapView, ReadableArray array) {
        mapView.addCircle(array);
    }

    // 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false，这个参数在React Native对应的MapView 中进行配置
    @ReactProp(name = "followEnabled", defaultBoolean = false)
    public void setFollowEnabled(LbsMapView mapView, boolean enable) {
        mapView.followEnabled(enable);
    }

    @Nullable
    @Override
    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder()
                .put(
                        "onUpdateUserLocation",
                        MapBuilder.of(
                                "phasedRegistrationNames",
                                MapBuilder.of("bubbled", "onUpdateUserLocation")))
                .build();
    }

    @Override
    public void onDropViewInstance(LbsMapView view) {
        super.onDropViewInstance(view);
        if (view.getMapView() != null) {
            view.getMapView().onDestroy();
        }
        if (view.getReactContext() != null) {
            view.getReactContext().removeLifecycleEventListener(view);
        }
    }
}