# TL;DR
#### Impliment a broadcast receiver as seen in [SmsListener.java](https://github.com/shivaRamdeen/AndroidRcvSms/blob/master/app/src/main/java/com/delinquent/telephony/SmsListener.java)
``` /app/src/main/java/com/delinquent/telephony/SmsListener.java```
#### Register the broadcast receiver in the [application manifest](https://github.com/shivaRamdeen/AndroidRcvSms/blob/master/app/src/main/AndroidManifest.xml#L21-L24)
```
<receiver android:name=".SmsListener">
    <intent-filter>
        <action android:name="android.provider.Telephony.SMS_RECEIVED" />
    </intent-filter>
</receiver>
```

#### Add the required permissions to listen for/read sms to the [application manifest](https://github.com/shivaRamdeen/AndroidRcvSms/blob/master/app/src/main/AndroidManifest.xml#L5)
```
<uses-permission android:name="android.permission.RECEIVE_SMS" />
```
