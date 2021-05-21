package com.example.ian.simpleblackjack;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.res.Resources;
import android.graphics.Canvas;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BlackJack {

    private Context context;
    private String[] userHand;
    private String[] dealerHand;
    private int userSize;
    private int dealerSize;
    private ArrayList<String> deck;

    private int deckSize;


    public BlackJack(Context con){
        context = con;
        userHand = new String[]{"00","00","00","00","00"};
        dealerHand = new String[]{"00","00","00","00","00"};
        deck = new ArrayList<String>(Arrays.asList(
                "SA", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "SJ", "SQ", "SK",
                "CA", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "CJ", "CQ", "CK",
                "HA", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "HJ", "HQ", "HK",
                "DA", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "DJ", "DQ", "DK"));
        deckSize = 52;
        startUserHand( );
        startDealerHand();
    }

    public void startUserHand( ){
        userHand[0] = drawCard();
        userHand[1] = drawCard();
        userSize = 2;
    }

    public String drawCard( ){
        int randomCard = (int)(Math.random() * (deckSize - 1));
        String card = deck.get(randomCard);
        deck.remove(randomCard);
        deckSize--;
        return card;
    }

    public void startDealerHand( ){
        dealerHand[0] = drawCard();
        dealerHand[1] = drawCard();
        dealerSize = 2;
    }

    public void drawCardUser( int i)
    {
        String card = drawCard();
        userHand[i] = card;
        userSize++;
    }

    public void drawCardDealer( int i)
    {
        String card = drawCard();
        dealerHand[i] = card;
        dealerSize++;
    }


    public int checkBlackJack( )
    {
        if( (calculateWorthOfCard(userHand[0],true) + calculateWorthOfCard(userHand[1],true) == 21) && (calculateWorthOfCard(dealerHand[0],true) + calculateWorthOfCard(dealerHand[1],true) == 21) )
            return 3;
        else if ( (calculateWorthOfCard(userHand[0],true) + calculateWorthOfCard(userHand[1],true) == 21) )
            return 2;
        else if ( (calculateWorthOfCard(dealerHand[0],true) + calculateWorthOfCard(dealerHand[1],true) == 21) )
            return 1;
        else
            return 0;
    }

    //if true, aces worth 11
    public int calculateWorthOfCard( String card, boolean worthMore )
    {
        char s = card.charAt(1);
        if ((s == 'J') || (s=='Q') || (s=='K') || (s=='1'))
            return 10;
        else if ( (s=='A') && (worthMore==false) )
            return 1;
        else if (s=='A')
            return 11;
        else
            return Character.getNumericValue(s);
    }

    public int calculateWorthOfHand( String[] hand )
    {
        int j = 1;
        int total = 0;
        for( int i=0; i<hand.length;i++)
            total += calculateWorthOfCard(hand[i],true);
        while(total > 21)
        {
            total = 0;
            for(int k=0; k < hand.length - j; k++)
                total += calculateWorthOfCard(hand[k],true);
            for(int m=(hand.length - j); m < hand.length; m++)
                total += calculateWorthOfCard(hand[m], false);
            j++;
            if (j==hand.length+1)
                break;
        }
        return total;
    }

    public int getUserSize( )
    {
        return userSize;
    }

    public int getDealerSize( )
    {
        return dealerSize;
    }

    public String[] getUserHand( )
    {
        return userHand;
    }

    public String[] getDealerHand( )
    {
        return dealerHand;
    }

}
