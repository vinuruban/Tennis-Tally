package com.example.tennistally;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int p1Score=0;
    int p2Score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addP1(View view) {
        if (p1Score==0 || p1Score==15) {
            p1Score = p1Score + 15;
        }
        else {
            p1Score = p1Score + 10;
        }
        addScore();
    }

    public void addP2(View view) {
        if (p2Score==0 || p2Score==15) {
            p2Score = p2Score + 15;
        }
        else {
            p2Score = p2Score + 10;
        }
        addScore();
    }

    private void addScore() {
        TextView score = (TextView) findViewById(R.id.textView4);
        TextView results = (TextView) findViewById(R.id.textView5);

        if (p1Score>40 && p2Score<40) {
            results.setText("Player 1 wins!");
        }

        else if (p2Score>40 && p1Score<40) {
            results.setText("Player 2 wins!");
        }

        else if (p1Score>=40 && p2Score>=40) {

            if (p1Score == p2Score) {
                score.setText("Deuce!");
            }

            else if (p1Score - p2Score == 10) {
                score.setText("Adv. to PL1!");
            }

            else if (p1Score - p2Score == 20) {
                results.setText("Player 1 win!");
            }

            else if (p2Score - p1Score == 10) {
                score.setText("Adv. to PL2!");
            }

            else if (p2Score - p1Score == 20) {
                results.setText("Player 2 wins!");
            }
        }

        else {
            score.setText(p1Score + " : " + p2Score);
        }
    }

    public void reset(View view) {
        TextView score = (TextView) findViewById(R.id.textView4);
        TextView results = (TextView) findViewById(R.id.textView5);
        p1Score=0;
        p2Score=0;
        score.setText("0 : 0");
        results.setText("");
    }
}
