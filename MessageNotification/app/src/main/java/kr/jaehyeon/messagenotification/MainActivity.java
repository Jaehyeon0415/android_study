package kr.jaehyeon.messagenotification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Person;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // MessageNotification은 안드로이드 9.0 이상부터 지원가능하다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn1Method(View view) {
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        NotificationChannel channel = new NotificationChannel("message", "Message Style", NotificationManager.IMPORTANCE_HIGH);
        channel.enableLights(true);
        channel.setLightColor(Color.RED);
        channel.enableVibration(true);
        manager.createNotificationChannel(channel);

        Notification.Builder builder = new Notification.Builder(this, "message");
        builder.setContentTitle("Message Style");
        builder.setContentText("Message Style Notification");
        builder.setSmallIcon(android.R.drawable.ic_menu_agenda);

        Person.Builder builder1 = new Person.Builder();
        Icon icon1 = Icon.createWithResource(this, android.R.drawable.ic_menu_call);
        builder1.setIcon(icon1);
        builder1.setName("홀길동");
        Person user1 = builder1.build();

        Person.Builder builder2 = new Person.Builder();
        Icon icon2 = Icon.createWithResource(this, android.R.drawable.ic_menu_camera);
        builder2.setIcon(icon2);
        builder2.setName("최길동");
        Person user2 = builder2.build();

        Notification.MessagingStyle style = new Notification.MessagingStyle(user1);

        style.addMessage("첫 번째 메시지", System.currentTimeMillis(), user1);
        style.addMessage("두 번째 메시지", System.currentTimeMillis(), user2);
        style.addMessage("세 번째 메시지", System.currentTimeMillis(), user1);
        style.addMessage("네 번째 메시지", System.currentTimeMillis(), user2);

        builder.setStyle(style);

        Notification notification = builder.build();
        manager.notify(10, notification);
    }
}