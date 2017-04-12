package com.yaoc.inclassassignment10_yaoc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toActivity(View view){
        switch (((Button) view).getText().toString()){
            case "object":
                startActivity(new Intent(this, ObjectActivity.class));
                break;
            case "list":
                startActivity(new Intent(this, ListActivity.class));
                break;
            case "camera":
                startActivity(new Intent(this, CameraActivity.class));
                break;
            case "storage":
                startActivity(new Intent(this, StorageActivity.class));
                break;
        }

    }
}
