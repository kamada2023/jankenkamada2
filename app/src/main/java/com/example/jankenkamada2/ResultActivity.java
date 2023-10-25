package com.example.jankenkamada2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.jankenkamada2.databinding.ActivityResultBinding;

import java.util.Random;


public class ResultActivity extends AppCompatActivity {

    private CountApp countApp;
    private ActivityResultBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        long seed = System.currentTimeMillis();
        Random rnd = new Random(seed);
        int cpu = rnd.nextInt(3);

        Intent intent = getIntent();
        int user = intent.getIntExtra("hand",0);

        countApp = (CountApp)this.getApplication();
        countApp.setAddCount(1);

        if (user == cpu) {
            countApp.setDrawCount(1);
            binding.resultDraw.setImageResource(R.drawable.draw);
            binding.result.setText(R.string.draw);
        } else if ((user==2 && cpu==0) || (user+1)==cpu) {
            countApp.setWinCount(1);
            binding.resultDraw.setImageResource(R.drawable.win);
            binding.result.setText(R.string.win);
        } else {
            countApp.setLoseCount(1);
            binding.resultDraw.setImageResource(R.drawable.lose);
            binding.result.setText(R.string.lose);
        }

        if(cpu==0){
            binding.cpuHand.setImageResource(R.drawable.j_gu02);
        } else if (cpu==1) {
            binding.cpuHand.setImageResource(R.drawable.j_ch02);
        }else{
            binding.cpuHand.setImageResource(R.drawable.j_pa02);
        }

        if(user==0){
            binding.userHand.setImageResource(R.drawable.j_gu02);
        } else if (user==1) {
            binding.userHand.setImageResource(R.drawable.j_ch02);
        }else{
            binding.userHand.setImageResource(R.drawable.j_pa02);
        }

        Button button = binding.nextBattle;

        if(countApp.getAddCount() == 1){
            button.setText(R.string.next_battle);
        }else {
            button.setText(R.string.next_scene);
        }

        button.setOnClickListener(v -> ContinueOrEnd());
    }
    private void ContinueOrEnd(){
        Intent intent;
        Intent first = new Intent(getApplication(),MainActivity.class);
        Intent con = new Intent(getApplication(),HalfwayProgressActivity.class);
        Intent end = new Intent(getApplication(),FinalResultActivity.class);

        countApp = (CountApp)this.getApplication();
        int game = countApp.getCount();
        int rounds = countApp.getAddCount();

        if(game == rounds){
            intent = end;
        }else if (game > rounds) {
            if(rounds == 1) {intent = first;}
            else {intent = con;}
        }else {
            countApp.setAddCount(-1);
            countApp.setWinCount(-1);
            intent = end;
        }

        startActivity(intent);
    }
}
