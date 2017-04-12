package com.yaoc.inclassassignment10_yaoc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class ObjectActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference postsRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);

        database = FirebaseDatabase.getInstance();
        postsRef = database.getReference("posts");
    }

    public void save(View view){
        EditText titleField = (EditText)findViewById(R.id.title);
        EditText bodyField = (EditText)findViewById(R.id.body);
        long currenTime = Calendar.getInstance().getTimeInMillis();

        String title = titleField.getText().toString();
        String body = bodyField.getText().toString();
        String time = String.valueOf(currenTime);

        BlogPost post = new BlogPost(title,body,time);

//        postRef.setValue(post);
        postsRef.push().setValue(post);

        TextView statusView = (TextView)findViewById(R.id.displayPost);
        statusView.setVisibility(view.VISIBLE);

        titleField.setText("");
        bodyField.setText("");
        statusView.setText(post.toString());
    }
}
