package com.example.iecsensor;

import java.util.ArrayList;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IECSensor extends Activity
{
	private MenuItem mMenu;
	
	private EditText mPollingRate;
	private Button mPollingButton;
	private TextView mSensorLabel;
	private TextView mPotText;
	private TextView mSensorText;
	private TextView mADCText;
	private TextView mTempText;
	private TextView mHumidityText;
	
	private BluetoothAdapter mBluetoothAdapter;
	
	private ArrayList<Double> mPot = new ArrayList<Double>();
	private ArrayList<Double> mSensor = new ArrayList<Double>();
	private ArrayList<Double> mADC = new ArrayList<Double>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.iecsensor_layout);
	
		mPollingRate = (EditText) findViewById(R.id.pollingText);
		mPollingButton = (Button) findViewById(R.id.pollingButton);
		
		mPotText = (TextView) findViewById(R.id.potResistReadings);
		mSensorText = (TextView) findViewById(R.id.sensorResistReadings);
		mADCText = (TextView) findViewById(R.id.adcVoltReadings);
		mTempText = (TextView) findViewById(R.id.tempReadings);
		mHumidityText = (TextView) findViewById(R.id.humidityReadings);
		
		mSensorLabel = (TextView) findViewById(R.id.sensorLabel);
		
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if(!mBluetoothAdapter.isEnabled())
		{
			Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableBluetooth, 0);
		}
		
		mPollingButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				/** 
				 * Parse polling rate
				 * Send command
				 * Change button text
				 * Set ready receive mode
				 */
			}
		});
		
		mSensorLabel.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				/**
				 * Change label text
				 * Change data point values
				 */
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.iecsensor_menu, menu);
		mMenu = menu.getItem(0);
		mMenu.setTitle(R.string.connect);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if(item.getItemId() == R.id.connect)
		{
			if(mBluetoothAdapter.isEnabled())
			{
				Intent serverIntent = new Intent(this, DeviceListActivity.class);
				startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE);
			}
			/** Do bluetooth connection stuff here **/
		}
		return true;
	}

}
