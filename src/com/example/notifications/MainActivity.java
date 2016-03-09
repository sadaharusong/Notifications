package com.example.notifications;

import android.R.integer;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Notification.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity implements android.view.View.OnClickListener{
	NotificationManager manager;
	int notification_ID;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		findViewById(R.id.btn_send).setOnClickListener(this);
		findViewById(R.id.btn_cancle).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_send:
			sendNotification();
			break;
		case R.id.btn_cancle:
			manager.cancel(notification_ID);
			break;
		
		}
	}

	private void sendNotification()
	{
		Intent intent = new Intent(this,MainActivity.class);
		PendingIntent pintent = PendingIntent.getActivity(this, 0, intent, 0);
		Builder builder = new Notification.Builder(this);
		builder.setSmallIcon(R.drawable.ic_launcher);
		builder.setTicker("�޽ڲ���ʾ");
		builder.setWhen(System.currentTimeMillis());
		builder.setContentTitle("������");
		builder.setContentText("���繷");
		builder.setContentIntent(pintent);
		
		builder.setDefaults(Notification.DEFAULT_ALL);
		Notification notification = builder.build();
		//builder.getNotification();
		manager.notify(notification_ID,notification);
	}

	
}
