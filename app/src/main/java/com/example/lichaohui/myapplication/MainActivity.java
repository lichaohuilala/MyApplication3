package com.example.lichaohui.myapplication;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private Sensor defaultSensor;
    private SensorManager sensormanager;
    private MySensoreventListener mySensoreventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        // 传感器经理
//        sensormanager = (SensorManager) getSystemService(SEARCH_SERVICE);
//        // 通话经理 拿到光传感对象
//        defaultSensor = sensormanager.getDefaultSensor(3);
//
//        mySensoreventListener = new MySensoreventListener();
//        sensormanager.registerListener(mySensoreventListener, defaultSensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
    /**
     * 在Activity销毁的生命周期里,解除监听,释放资源.
     */
    //解除光传感器监听,unregisterListener参数监听器对象
    //把自己的传感器监听器=空

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensormanager.unregisterListener(mySensoreventListener);
        mySensoreventListener=null;
    }
}
class MySensoreventListener implements SensorEventListener{
// 传感器数据变化调用的方法
    @Override
    public void onSensorChanged(SensorEvent event) {
        float value = event.values[0];
        Log.d("zzz",value+"光亮度");
    }
    //当传感器精度发生变化的时候调用的方法
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
