package com.delinquent.telephony;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    public TextView myPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init text view
        myPhoneNumber = (TextView) findViewById(R.id.out);
        myPhoneNumber.setText("Initializing..");
        //This is how to get the sim card number
        TelephonyManager telMgr = (TelephonyManager)
                getApplication().getSystemService(getApplicationContext().TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(getApplicationContext(),"No Permission to read phone state", Toast.LENGTH_LONG).show();
            return;
        }

        String deviceID = telMgr.getDeviceId();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(getApplicationContext(),"No Permission to read phone state", Toast.LENGTH_LONG).show();
            return;
        }

        String simSerialNumber = telMgr.getSimSerialNumber();
        String simLineNumber = telMgr.getLine1Number();

        myPhoneNumber.setText(simLineNumber);
        Toast.makeText(getApplicationContext(),"Phone Number Found", Toast.LENGTH_LONG).show();



        Toast.makeText(getApplicationContext(),"Waiting for SMS",Toast.LENGTH_LONG).show();


    }
}
