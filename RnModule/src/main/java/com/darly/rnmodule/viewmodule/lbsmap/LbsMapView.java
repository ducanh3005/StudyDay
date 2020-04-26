package com.darly.rnmodule.viewmodule.lbsmap;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.Circle;
import com.amap.api.maps2d.model.CircleOptions;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.amap.api.maps2d.model.Polyline;
import com.amap.api.maps2d.model.PolylineOptions;
import com.darly.rnmodule.R;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import java.util.ArrayList;
import java.util.List;

/**
 * author:zhangyuhui
 * date:2020-04-2416:31
 * description: 通过继承控件布局，设置地图使用信息，提供给React Native使用。
 */
public class LbsMapView extends FrameLayout implements LifecycleEventListener {

    private String LATITUDE = "latitude";
    private String LONGITUDE = "longitude";
    private String TITLE = "title";
    private String RADIUS = "radius";
    private String LOCATION = "location";

    private ThemedReactContext mReactContext;
    private MapView mMapView;
    private AMap aMap;
    private List<Marker> mMarkerList = new ArrayList<>();
    private List<Circle> mCircleList = new ArrayList<>();
    private int zoomLevel = 17;
    //绘制线的管理类
    private List<Polyline> mPolyLine = new ArrayList<>();

    public LbsMapView(@NonNull Context context, ThemedReactContext reactContext) {
        super(context);
        mReactContext = reactContext;
        initView();
    }

    public LbsMapView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public LbsMapView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mReactContext.addLifecycleEventListener(this);
        mMapView = new MapView(getContext());
        mMapView.onCreate(new Bundle());
        aMap = mMapView.getMap();
        aMap.getUiSettings().setZoomControlsEnabled(false);
        addView(mMapView);
    }

    public MapView getMapView() {
        return mMapView;
    }

    public ThemedReactContext getReactContext() {
        return mReactContext;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    private int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    // 更改中心点
    public void setLocation(ReadableMap map) {
        if (aMap != null && map != null && map.hasKey(LONGITUDE) && map.hasKey(LATITUDE)) {
            double longitude = Double.parseDouble(map.getString(LONGITUDE));
            double latitude = Double.parseDouble(map.getString(LATITUDE));
            CameraUpdate mCameraUpdate = CameraUpdateFactory.changeLatLng(new LatLng(latitude, longitude));
            aMap.moveCamera(mCameraUpdate);
            aMap.moveCamera(CameraUpdateFactory.zoomTo(zoomLevel));
        }
    }

    // 更改缩放级别
    public void setZoomLevel(int level) {
        if (aMap != null) {
            CameraUpdate mCameraUpdate = CameraUpdateFactory.zoomTo(level);
            aMap.moveCamera(mCameraUpdate);
            zoomLevel = level;
        }
    }

    /**
     * 绘制点
     *
     * @param array 至少包含longitude，latitude，title
     */
    public void addMarker(ReadableArray array) {
        for (Marker marker : mMarkerList) {
            marker.remove();
        }
        mMarkerList.clear();
        if (aMap != null && array != null && array.size() > 0) {
            int length = array.size();
            for (int i = 0; i < length; i++) {
                ReadableMap map = array.getMap(i);
                if (map != null && map.hasKey(LONGITUDE) && map.hasKey(LATITUDE) && map.hasKey(TITLE)) {
                    double longitude = Double.parseDouble(map.getString(LONGITUDE));
                    double latitude = Double.parseDouble(map.getString(LATITUDE));
                    String title = map.getString(TITLE);
                    ImageView imageView = new ImageView(getReactContext());
                    if (mMapView.getTag()!=null&&mMapView.getTag() instanceof Integer&&Integer.parseInt(mMapView.getTag().toString()) == 100){
                        //轨迹过来使用的位置信息。
                        if (i==0){
                            //开始位置
                            int width = dip2px(getReactContext(), 24);
                            int height = dip2px(getReactContext(), 24);
                            LayoutParams params = new LayoutParams(width, height);
                            imageView.setLayoutParams(params);
                            imageView.setImageResource(R.mipmap.ic_maproute_start);
                        }else if (i == length-1){
                            //结束位置
                            int width = dip2px(getReactContext(), 24);
                            int height = dip2px(getReactContext(), 24);
                            LayoutParams params = new LayoutParams(width, height);
                            imageView.setLayoutParams(params);
                            imageView.setImageResource(R.mipmap.ic_maproute_end);
                        }else {
                            int width = dip2px(getReactContext(), 14);
                            int height = dip2px(getReactContext(), 14);
                            LayoutParams params = new LayoutParams(width, height);
                            imageView.setLayoutParams(params);
                            imageView.setImageResource(R.mipmap.ic_maproute_point);
                        }
                    }else {
                        //其他地图信息
                        int width = dip2px(getReactContext(), 34);
                        int height = dip2px(getReactContext(), 39);
                        LayoutParams params = new LayoutParams(width, height);
                        imageView.setLayoutParams(params);
                        imageView.setImageResource(R.mipmap.ic_marker);
                    }
                    LatLng latLng = new LatLng(latitude, longitude);
                    MarkerOptions markerOption = new MarkerOptions();
                    markerOption.position(latLng).title(title).anchor(0.5f, 0.45f)
                            .icon(BitmapDescriptorFactory.fromView(imageView));
                    Marker newMarker = aMap.addMarker(markerOption);
                    mMarkerList.add(newMarker);
                }
            }
        }
    }
    // 设置地图来源，100为轨迹，空或者其他值来源其他
    public void addTag(int tag) {
        mMapView.setTag(tag);
    }
    /**
     * 绘制点以及路径轨迹
     *
     * @param array 至少包含longitude，latitude，title
     */
    public void addMarkerAndRoute(ReadableArray array) {
        for (Polyline marker : mPolyLine) {
            marker.remove();
        }
        mPolyLine.clear();
        if (aMap != null && array != null && array.size() > 0) {
            List<LatLng> list = new ArrayList<>();
            int length = array.size();
            for (int i = 0; i < length; i++) {
                ReadableMap map = array.getMap(i);
                if (map != null && map.hasKey(LONGITUDE) && map.hasKey(LATITUDE) && map.hasKey(TITLE)) {
                    double longitude = Double.parseDouble(map.getString(LONGITUDE));
                    double latitude = Double.parseDouble(map.getString(LATITUDE));
                    LatLng latLng = new LatLng(latitude, longitude);
                    list.add(latLng);
                }
            }
            //根据所有点位进行轨迹绘制
            Polyline line =  aMap.addPolyline((new PolylineOptions())
                    .addAll(list)//线的宽度
                    .width(10).setDottedLine(false)
                    //颜色
                    .color(Color.argb(255,78,128,245)));
            mPolyLine.add(line);
        }
    }


    /**
     * 绘制圆
     *
     * @param array 至少包含longitude，latitude，radius
     */
    public void addCircle(ReadableArray array) {
        if (aMap != null && array != null && array.size() > 0) {
            for (Circle circle : mCircleList) {
                circle.remove();
            }
            mCircleList.clear();
            for (int i = 0; i < array.size(); i++) {
                ReadableMap map = array.getMap(i);
                if (map != null && map.hasKey(LONGITUDE) && map.hasKey(LATITUDE) && map.hasKey(RADIUS)) {
                    double longitude = Double.parseDouble(map.getString(LONGITUDE));
                    double latitude = Double.parseDouble(map.getString(LATITUDE));
                    String radius = map.getString(RADIUS);
                    String fillColor = "#339B9EA7";
                    if (map.hasKey("fillColor")) {
                        fillColor = map.getString("fillColor");
                    }
                    String strokeColor = "#339B9EA7";
                    if (map.hasKey("strokeColor")) {
                        strokeColor = map.getString("strokeColor");
                    }

                    LatLng latLng = new LatLng(latitude, longitude);
                    CircleOptions circleOptions = new CircleOptions();
                    circleOptions.center(latLng).radius(Double.parseDouble(radius))
                            .fillColor(Color.parseColor(fillColor))
                            .strokeColor(Color.parseColor(strokeColor))
                            .strokeWidth(3);
                    Circle newCircle = aMap.addCircle(circleOptions);
                    mCircleList.add(newCircle);
                }
            }
        }
    }

    private boolean isCenter;

    // 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
    public void followEnabled(boolean enable) {
        if (aMap != null ) {
            if (enable) {
                MyLocationStyle myLocationStyle = new MyLocationStyle();
                myLocationStyle.interval(5000);
                myLocationStyle.showMyLocation(true);
                ImageView imageView = new ImageView(getReactContext());
                int width = dip2px(getReactContext(), 40);
                LayoutParams params = new LayoutParams(width, width);
                imageView.setLayoutParams(params);
                imageView.setImageResource(R.mipmap.ic_location);
                myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromView(imageView));
                myLocationStyle.strokeColor(Color.TRANSPARENT);
                myLocationStyle.radiusFillColor(Color.TRANSPARENT);
                myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_FOLLOW_NO_CENTER);
                aMap.setMyLocationStyle(myLocationStyle);
                aMap.setMyLocationEnabled(true);
                aMap.setOnMyLocationChangeListener(onMyLocationChangeListener);
            }else {
                aMap.setOnMyLocationChangeListener(null);
            }
        }
    }

    private AMap.OnMyLocationChangeListener onMyLocationChangeListener = new AMap.OnMyLocationChangeListener() {
        @Override
        public void onMyLocationChange(Location location) {
            if (!isCenter) {
                CameraUpdate mCameraUpdate = CameraUpdateFactory.changeLatLng(new LatLng(location.getLatitude(), location.getLongitude()));
                aMap.moveCamera(mCameraUpdate);
                isCenter = true;
            }
            // 向RN发送location
            WritableMap object = Arguments.createMap();
            object.putString(LATITUDE, String.valueOf(location.getLatitude()));
            object.putString(LONGITUDE, String.valueOf(location.getLongitude()));
            WritableMap event = Arguments.createMap();
            event.putMap(LOCATION, object);
            mReactContext.getJSModule(RCTEventEmitter.class).receiveEvent(getId(), "onUpdateUserLocation", event);
        }
    };

    @Override
    public void onHostResume() {
        if (mMapView != null) {
            mMapView.onResume();
        }
    }

    @Override
    public void onHostPause() {
        if (mMapView != null) {
            mMapView.onPause();
        }
    }

    @Override
    public void onHostDestroy() {
        if (mMapView != null) {
            mMapView.onDestroy();
        }
    }
}
