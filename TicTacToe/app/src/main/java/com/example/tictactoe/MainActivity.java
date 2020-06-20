package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int turn;
    boolean gameOver;
    int[] position = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int[][] winPosition = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void play(View view){
        int flag = 0, flag2 = 0;
        String message = "";
        ImageView image = (ImageView) view;
        int tag = Integer.parseInt(image.getTag().toString());
        System.out.println(position[tag]);
        if(!gameOver) {

            if (turn == 0 && position[tag] == -1) {
                image.setTranslationY(-3300f);
                image.setImageResource(R.drawable.tico);
                position[tag] = 0;
                turn = 1;
                image.animate().translationYBy(3300f).setDuration(350);
            } else if (turn == 1 && position[tag] == -1) {
                image.setTranslationY(-3300f);
                image.setImageResource(R.drawable.ticx);
                turn = 0;
                position[tag] = 1;
                image.animate().translationYBy(3300f).setDuration(350);
            }


            for (int[] x : winPosition) {
                if (position[x[0]] == position[x[1]] && position[x[2]] == position[x[1]] && position[x[0]] != -1) {
                    if (turn == 1)
                        message = "Player 1 has won.";
                    else
                        message = "Player 2 has won.";

                    gameOver = true;
                    flag2=1;
                    TextView text = (TextView) findViewById(R.id.textView2);
                    Button button = (Button) findViewById((R.id.button));
                    text.setText(message);
                    text.animate().alpha(1f);
                    button.animate().alpha(1f);
                    turn = 0;
                }
            }
            for (int z : position) {
                if (z == -1) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0 && flag2 == 0) {
                gameOver = true;
                message = "It's a draw.";
                TextView text = (TextView) findViewById(R.id.textView2);
                Button button = (Button) findViewById((R.id.button));
                text.setText(message);
                text.animate().alpha(1f);
                button.animate().alpha(1f);
                turn = 0;
            }
        }
    }

    public void playAgain(View view){
        gameOver = false;
        int i = 0;
        Button button = (Button) view;
        TextView text =(TextView)findViewById(R.id.textView2);
        text.animate().alpha(0f);
        button.animate().alpha(0f);
        for(i=0;i<position.length;i++)
            position[i]=-1;
        ImageView image1 = (ImageView)findViewById(R.id.imageView3);
        ImageView image2 = (ImageView)findViewById(R.id.imageView5);
        ImageView image3 = (ImageView)findViewById(R.id.imageView6);
        ImageView image4 = (ImageView)findViewById(R.id.imageView7);
        ImageView image5 = (ImageView)findViewById(R.id.imageView8);
        ImageView image6 = (ImageView)findViewById(R.id.imageView9);
        ImageView image7 = (ImageView)findViewById(R.id.imageView10);
        ImageView image8 = (ImageView)findViewById(R.id.imageView11);
        ImageView image9 = (ImageView)findViewById(R.id.imageView12);

        image1.setImageResource(0);
        image2.setImageResource(0);
        image3.setImageResource(0);
        image4.setImageResource(0);
        image5.setImageResource(0);
        image6.setImageResource(0);
        image7.setImageResource(0);
        image8.setImageResource(0);
        image9.setImageResource(0);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        turn = 0;
    }
}
