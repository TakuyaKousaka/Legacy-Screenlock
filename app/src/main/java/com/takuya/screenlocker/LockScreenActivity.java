package com.takuya.screenlocker;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public class LockScreenActivity extends Activity {

	private DevicePolicyManager D; 
	private ComponentName C;  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		D = (DevicePolicyManager)getSystemService(Context.DEVICE_POLICY_SERVICE);  
		C = new ComponentName(this, AdminReceiver.class);  
		L();
		finish();

	}

	private boolean iA(){
		return D.isAdminActive(C); 
	}

	public void L() {
		if (iA()) {  
			D.lockNow();  
		}else{
			Toast.makeText(getApplicationContext(), "I need to be an admin.", Toast.LENGTH_SHORT).show();
		}
	}
}
