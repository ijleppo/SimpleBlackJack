package com.example.ian.simpleblackjack;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private BlackJack game;
    private int aiThreshold = 20;
    private int offset = 140;
    private int hitLimit;
    private int[] deckPNG = {                         //Spades, Clubs, Hearts, Diamonds, Ace to King , respectively
            R.drawable.ace_of_spades,
            R.drawable.two_of_spades,
            R.drawable.three_of_spades,
            R.drawable.four_of_spades,
            R.drawable.five_of_spades,
            R.drawable.six_of_spades,
            R.drawable.seven_of_spades,
            R.drawable.eight_of_spades,
            R.drawable.nine_of_spades,
            R.drawable.ten_of_spades,
            R.drawable.jack_of_spades,
            R.drawable.queen_of_spades,
            R.drawable.king_of_spades,
            R.drawable.ace_of_clubs,
            R.drawable.two_of_clubs,
            R.drawable.three_of_clubs,
            R.drawable.four_of_clubs,
            R.drawable.five_of_clubs,
            R.drawable.six_of_clubs,
            R.drawable.seven_of_clubs,
            R.drawable.eight_of_clubs,
            R.drawable.nine_of_clubs,
            R.drawable.ten_of_clubs,
            R.drawable.jack_of_clubs,
            R.drawable.queen_of_clubs,
            R.drawable.king_of_clubs,
            R.drawable.ace_of_hearts,
            R.drawable.two_of_hearts,
            R.drawable.three_of_hearts,
            R.drawable.four_of_hearts,
            R.drawable.five_of_hearts,
            R.drawable.six_of_hearts,
            R.drawable.seven_of_hearts,
            R.drawable.eight_of_hearts,
            R.drawable.nine_of_hearts,
            R.drawable.ten_of_hearts,
            R.drawable.jack_of_hearts,
            R.drawable.queen_of_hearts,
            R.drawable.king_of_hearts,
            R.drawable.ace_of_diamonds,
            R.drawable.two_of_diamonds,
            R.drawable.three_of_diamonds,
            R.drawable.four_of_diamonds,
            R.drawable.five_of_diamonds,
            R.drawable.six_of_diamonds,
            R.drawable.seven_of_diamonds,
            R.drawable.eight_of_diamonds,
            R.drawable.nine_of_diamonds,
            R.drawable.ten_of_diamonds,
            R.drawable.jack_of_diamonds,
            R.drawable.queen_of_diamonds,
            R.drawable.king_of_diamonds,
            R.drawable.back,
            R.drawable.back_twox};
    private ArrayList<String> orderedDeck = new ArrayList<String>(Arrays.asList(
            "SA", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "SJ", "SQ", "SK",
            "CA", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "CJ", "CQ", "CK",
            "HA", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "HJ", "HQ", "HK",
            "DA", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "DJ", "DQ", "DK"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hitLimit = 2;

        game = new BlackJack(this);
        drawFaceUp(0, false);
        drawFaceUp(1, false);

        drawFaceUp(0, true);
        drawFaceUp(1, true);

        if (game.checkBlackJack() == 3)
            bothWin();
        if (game.checkBlackJack() == 2)
            userWin();
        if (game.checkBlackJack() == 1)
            dealerWin();
    }

    //if true   - dealer card drawn
    //if false    -user card drawn
    public void drawFaceUp(int index, boolean cond) {
        if (cond == true) {
            switch (index) {
                case 0:
                    ImageView image0 = (ImageView) findViewById(R.id.imageView1);
                    image0.setImageResource(deckPNG[orderedDeck.indexOf(game.getDealerHand()[index])]);
                    image0.setX(20);
                    image0.setY(170);
                    break;
                case 1:
                    ImageView image1 = (ImageView) findViewById(R.id.imageView2);
                    image1.setImageResource(deckPNG[orderedDeck.indexOf(game.getDealerHand()[index])]);
                    image1.setX(20 + (offset * index));
                    image1.setY(170);
                    break;
                case 2:
                    ImageView image2 = (ImageView) findViewById(R.id.imageView3);
                    image2.setImageResource(deckPNG[orderedDeck.indexOf(game.getDealerHand()[index])]);
                    image2.setX(20 + (offset * index));
                    image2.setY(170);
                    break;
                case 3:
                    ImageView image3 = (ImageView) findViewById(R.id.imageView4);
                    image3.setImageResource(deckPNG[orderedDeck.indexOf(game.getDealerHand()[index])]);
                    image3.setX(20 + (offset * index));
                    image3.setY(170);
                    break;
                case 4:
                    ImageView image4 = (ImageView) findViewById(R.id.imageView5);
                    image4.setImageResource(deckPNG[orderedDeck.indexOf(game.getDealerHand()[index])]);
                    image4.setX(20 + (offset * index));
                    image4.setY(170);
                    break;
            }
        } else {
            switch (index) {
                case 0:
                    ImageView image5 = (ImageView) findViewById(R.id.imageView6);
                    image5.setImageResource(deckPNG[orderedDeck.indexOf(game.getUserHand()[index])]);
                    image5.setX(20 + (offset * index));
                    image5.setY(680);
                    break;
                case 1:
                    ImageView image6 = (ImageView) findViewById(R.id.imageView7);
                    image6.setImageResource(deckPNG[orderedDeck.indexOf(game.getUserHand()[index])]);
                    image6.setX(20 + (offset * index));
                    image6.setY(680);
                    break;
                case 2:
                    ImageView image7 = (ImageView) findViewById(R.id.imageView8);
                    image7.setImageResource(deckPNG[orderedDeck.indexOf(game.getUserHand()[index])]);
                    image7.setX(20 + (offset * index));
                    image7.setY(680);
                    break;
                case 3:
                    ImageView image8 = (ImageView) findViewById(R.id.imageView9);
                    image8.setImageResource(deckPNG[orderedDeck.indexOf(game.getUserHand()[index])]);
                    image8.setX(20 + (offset * index));
                    image8.setY(680);
                    break;
                case 4:
                    ImageView image9 = (ImageView) findViewById(R.id.imageView10);
                    image9.setImageResource(deckPNG[orderedDeck.indexOf(game.getUserHand()[index])]);
                    image9.setX(20 + (offset * index));
                    image9.setY(680);
                    break;
            }
        }

    }

    public void bothWin() {
        TextView tv = (TextView) findViewById(R.id.textGameOver);
        tv.setText("Tie! User: " + game.calculateWorthOfHand(game.getUserHand()) + " Dealer: " + game.calculateWorthOfHand(game.getDealerHand())  );
        Button stopButton = (Button) findViewById(R.id.buttonStop);
        Button hitButton = (Button) findViewById(R.id.buttonHit);
        stopButton.setEnabled(false);
        hitButton.setEnabled(false);
    }

    public void userWin() {
        TextView tv = (TextView) findViewById(R.id.textGameOver);
        tv.setText("You win! User: " + game.calculateWorthOfHand(game.getUserHand()) + " Dealer: " + game.calculateWorthOfHand(game.getDealerHand()));
        Button stopButton = (Button) findViewById(R.id.buttonStop);
        Button hitButton = (Button) findViewById(R.id.buttonHit);
        stopButton.setEnabled(false);
        hitButton.setEnabled(false);
    }

    public void dealerWin() {
        TextView tv = (TextView) findViewById(R.id.textGameOver);
        tv.setText("You lose! User: " + game.calculateWorthOfHand(game.getUserHand()) + " Dealer: " + game.calculateWorthOfHand(game.getDealerHand()) );
        Button stopButton = (Button) findViewById(R.id.buttonStop);
        Button hitButton = (Button) findViewById(R.id.buttonHit);
        stopButton.setEnabled(false);
        hitButton.setEnabled(false);
    }

    public void userHit(View v) {
        hitLimit++;
        int size = game.getUserSize();
        if (size < 5) {
            game.drawCardUser(size);
            drawFaceUp(size, false);
        }
        if (game.calculateWorthOfHand(game.getUserHand()) > 21)
            dealerWin();
        if( hitLimit == game.getUserHand().length )
        {
            Button stopButton = (Button) findViewById(R.id.buttonStop);
            stopButton.performClick( );
        }
    }

    public void userStop( View v)
    {
        int limit = (game.getDealerHand().length - game.getDealerSize() );
        int size = game.getDealerSize();
        for( int i=0; (i<limit) && ( game.calculateWorthOfHand( game.getDealerHand()) <= aiThreshold ); i++)
        {
            game.drawCardDealer( size );
            drawFaceUp(size, true);
        }
        int userSum = game.calculateWorthOfHand(game.getUserHand());
        int dealerSum = game.calculateWorthOfHand(game.getDealerHand());
        if( (dealerSum>21) || ((userSum<22) && (userSum>dealerSum) && (dealerSum < 22)) )
            userWin();
        if( (userSum>21) || ((userSum<22) && (dealerSum>userSum) && (dealerSum < 22)) )
            dealerWin();
        if(  (userSum<22) && (dealerSum==userSum) && (dealerSum < 22)      )
            bothWin();
    }

    public void newGame(View v) {
        finish();
        startActivity(getIntent());
    }
}
