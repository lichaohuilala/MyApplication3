package com.example.my;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private SensorManager senserManager;
    private Myline myline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //通过服务拿到传感器经理.getSystemService(SENSOR_SERVICE),要强类型转换.
        senserManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //通过传感器经理得到方向传感器的对象.getDefaultSensor 参数:3(也就是我给大家表的位置)
        Sensor sensor = senserManager.getDefaultSensor(5);

        //创建一个自己的传感器监听器
        myline = new Myline();

        senserManager.registerListener(myline,sensor,SensorManager.SENSOR_DELAY_GAME);
        //注册传感器监听,registerListener,参数:1.传感器监听器  2.传感器对象   3.决定采样的敏感度.SensorManager.SENSOR_DELAY_NORMAL:正常采样

    }
    /**
     * 在Activity销毁的生命周期里,解除监听,释放资源.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除光传感器监听,unregisterListener参数监听器对象
        //把自己的传感器监听器=空
        senserManager.unregisterListener(myline);
        senserManager=null;
    }
    /**
     * 自定义一个类实现SensorEventListener,做为传感器监听
     *
     */
    class Myline implements SensorEventListener {

        @Override  //当传感器数据变化的调用的方法
        public void onSensorChanged(SensorEvent event) {
          int  value = (int) event.values[0];
            Log.d("zzz",value+"");
           //通过传感器事件,得到方向值(int).event.values[0]
            if (value<90){
                Log.d("zzz","东北");
            }else  if (value>90&& value<180){
                Log.d("zzz","东南");
            }else  if (value>180&& value<270){
                Log.d("zzz","西南");
            }else  if (value>270&& value<360){
                Log.d("zzz","西北");
            }
        }
        //当传感器精度发生变化的时候调用的方法
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    }
}
