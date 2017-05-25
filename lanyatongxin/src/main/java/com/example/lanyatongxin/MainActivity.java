package com.example.lanyatongxin;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button start;
    private Button select;
    private Button stop;
    private BluetoothAdapter mDefaultAdapter;
    private Set<BluetoothDevice> mBondedDevices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        start = (Button) findViewById(R.id.start);
        select = (Button) findViewById(R.id.select);
        stop = (Button) findViewById(R.id.stop);
        start.setOnClickListener(this);
        select.setOnClickListener(this);
        stop.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                mDefaultAdapter = BluetoothAdapter.getDefaultAdapter();
               Intent it=new Intent(mDefaultAdapter.ACTION_CONNECTION_STATE_CHANGED);
                it.putExtra(mDefaultAdapter.EXTRA_DISCOVERABLE_DURATION,300);
                startActivity(it);
                break;
            case R.id.select:
//                BluetoothDevice> mBondedDevices;
                mBondedDevices = mDefaultAdapter.getBondedDevices();
                break;
            case R.id.stop:

                break;
        }
    }
}
