package com.example.maverickbazaar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Text extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        EditText TextMessage = (EditText) findViewById(R.id.TextMsgRegion);
        ImageButton SendTextMsg = (ImageButton) findViewById(R.id.SubmitText);
        Button ReturnHomeScreen = (Button) findViewById(R.id.ReturnHome);
        RecyclerView MessageListView = (RecyclerView) findViewById(R.id.MessagesList);
        RecyclerView.Adapter mAdapter;
        //ArrayList<MessageInfo>mMessages;

        //now make the things do things:

        //go back 2 home screen
        ReturnHomeScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View r) {
                startActivity(new Intent(Text.this, MainActivity.class));
            }
        });
        //onClick for img button to take
        SendTextMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FullMessage = TextMessage.getText().toString();
                HashMap<String,String> MessagesMap = new HashMap<>();
                MessagesMap.put("Message",FullMessage);
                //clear out register -DO THIS LAST
                TextMessage.getText().clear();
                //now to put the shit in the arrayList
                //mAdapter=new TextAdapter(mMessages);

                //MessagesSent.add(FullMessage);
                //add arraylist to the recycleview


            }
        });
    }
}
