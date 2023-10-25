package com.example.jankenkamada2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.jankenkamada2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountApp countApp = (CountApp) this.getApplication();
        int count = countApp.getAddCount();

	TextView textView = findViewById(R.id.battle_shout);
        ImageButton img_g = findViewById(R.id.Gu);
        ImageButton img_t = findViewById(R.id.Tyo);
        ImageButton img_p = findViewById(R.id.Pa);

        int gu = 0,tyo = 1,pa = 2;

        if(count > 0){
            String nextTile = getString(R.string.next_title,(count+1));
            text.setText(nextTile);
        }

         Intent intent = new Intent(getApplication(), ResultActivity.class);
        img_g.setOnClickListener(v -> {
            intent.putExtra("hand", gu);
            startActivity(intent);
        });
        img_t.setOnClickListener(v -> {
            intent.putExtra("hand", tyo);
            startActivity(intent);
        });
        img_p.setOnClickListener(v -> {
            intent.putExtra("hand", pa);
            startActivity(intent);
        });
    }
}