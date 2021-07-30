package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer=0;// 0=O, 1= X
    int[] gameState={2,2,2,2,2,2,2,2,2,2};
    /*The value of gameState array must be allowed to change so obviously
     we dont put it inside the function called onClick!*/
    int[] xarray={1,1,1,1,1,1,1,1,1};
    int[] yarray={1,1,1,1,1,1,1,1,1};

    public int checkWon(int[] arr)
    {
        if(((arr[0]==0)&&(arr[4]==0)&&(arr[8]==0))||((arr[2]==0)&&(arr[4]==0)&&(arr[6]==0))||((arr[0]==0)&&(arr[1]==0)&&(arr[2]==0))||((arr[3]==0)&&(arr[4]==0)&&(arr[5]==0))||((arr[6]==0)&&(arr[7]==0)&&(arr[8]==0))||((arr[0]==0)&&(arr[3]==0)&&(arr[6]==0))||((arr[1]==0)&&(arr[4]==0)&&(arr[7]==0))||((arr[2]==0)&&(arr[5]==0)&&(arr[8]==0)))
        {
            return 1;
        }
        else
            return 0;
    }







    public void dropIn(View view)
    {
        int flag=1;

        TextView finalText=(TextView)findViewById(R.id.tf);


        ImageView counter=(ImageView)view;
        int tagToRemove= Integer.parseInt(counter.getTag().toString());

        if(gameState[tagToRemove]==2){
            gameState[tagToRemove]=activePlayer;
        if((activePlayer==0)) {
            counter.setImageResource(R.drawable.o);
            counter.animate().rotationBy(720f).alpha(1f).setDuration(2000);
            activePlayer=1;
            gameState[tagToRemove]=0;
            yarray[tagToRemove]=0;//turns an element 0 if o has landed on it
            if(checkWon(yarray)==1) {
                Toast.makeText(this, "O player wins!", Toast.LENGTH_SHORT).show();
                finalText.setText("The player with O has won!");
                showFinalScene();

            }

        }
        else {
            counter.setImageResource((R.drawable.x));
            counter.animate().rotationBy(720f).alpha(1f).setDuration(2000);
            activePlayer=0;
            gameState[tagToRemove]=0;
            xarray[tagToRemove]=0;//turns an element 0 if x has landed on it
            if (checkWon(xarray)==1) {
                Toast.makeText(this, "X player wins!", Toast.LENGTH_SHORT).show();
                finalText.setText("The player with X has won!");
                showFinalScene();
            }
        }}
        else
        {
            flag=1;
            for (int i=1;i<=8;i++)
            {
                if(gameState[i]!=0)
                { flag=0;break;}
            }
            if(flag==1)
            {finalText.setText("It's a Draw!");
            showFinalScene();}


        }





    }

    public void showFinalScene()
    {
        LinearLayout finalScreen=(LinearLayout)findViewById(R.id.linearLayout);
        finalScreen.setVisibility(View.VISIBLE);//initially it was invisible
    }



    public void playAgain(View view) {
         activePlayer = 0;

         for (int i=0;i<=8;i++)
         {
             gameState[i]=2;
             xarray[i]=2;
             yarray[i]=2;
         }

        LinearLayout finalScreen = (LinearLayout) findViewById(R.id.linearLayout);
        finalScreen.setVisibility(View.INVISIBLE);



        ImageView aa=(ImageView)findViewById(R.id.imageView39);
        aa.animate().alpha(0f);
        ImageView bb=(ImageView)findViewById(R.id.imageView40);
        bb.animate().alpha(0f);
        ImageView cc=(ImageView)findViewById(R.id.imageView41);
        cc.animate().alpha(0f);
        ImageView dd=(ImageView)findViewById(R.id.imageView42);
        dd.animate().alpha(0f);
        ImageView ee=(ImageView)findViewById(R.id.imageView43);
        ee.animate().alpha(0f);
        ImageView ff=(ImageView)findViewById(R.id.imageView44);
        ff.animate().alpha(0f);
        ImageView gg=(ImageView)findViewById(R.id.imageView45);
        gg.animate().alpha(0f);
        ImageView hh=(ImageView)findViewById(R.id.imageView46);
        hh.animate().alpha(0f);
        ImageView ii=(ImageView)findViewById(R.id.imageView47);
        ii.animate().alpha(0f);







    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Player with O starts First!", Toast.LENGTH_SHORT).show();
    }
}
