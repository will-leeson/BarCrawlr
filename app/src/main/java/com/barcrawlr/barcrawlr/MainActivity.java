package com.barcrawlr.barcrawlr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import link.fls.swipestack.SwipeStack;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private SwipeStack cardStack;
    private CardAdapter cardAdapter;
    private ArrayList<CardInfo> cdInfo;
    private int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardStack = (SwipeStack) findViewById(R.id.container);

        setCardStackAdapter();
        currentPosition = 0;

        cardStack.setListener(new SwipeStack.SwipeStackListener() {
            @Override
            public void onViewSwipedToLeft(int position) {

                if (currentPosition == (cdInfo.size()-1)){
                    cardStack.resetStack();
                    currentPosition = 0;
                }
                currentPosition = position + 1;
            }

            @Override
            public void onViewSwipedToRight(int position) {

                Bundle extras = new Bundle();
               // Intent intent = new Intent(MainActivity.this,BarInfoPage.class);
                extras.putString("NAME",cardAdapter.getItem(position).getName());
                extras.putString("LOCATION",cardAdapter.getItem(position).getLocation());
                extras.putString("PRICE",cardAdapter.getItem(position).getPrice());
                //extras.putByte(cardAdapter.decode);
                //intent.putExtras(extras);
                //startActivity(intent);
                if (currentPosition == (cdInfo.size()-1)){
                    cardStack.resetStack();
                    currentPosition = 0;
                }
                currentPosition = position + 1;
            }

            @Override
            public void onStackEmpty() {

            }
        });

    }

    private void setCardStackAdapter() {
        cdInfo = new ArrayList<>();

        cdInfo.add(new CardInfo(R.drawable.ingersolltap,"Ingersoll Tap","Distance Away","$$"));
        cdInfo.add(new CardInfo(R.drawable.junipermoon,"Juniper Moon","Distance Away","$$"));
        cdInfo.add(new CardInfo(R.drawable.starbar,"Star Bar","Distance Away","$$"));
        cdInfo.add(new CardInfo(R.drawable.zimms,"Zimm's Food and Spirits","Distance Away","$$"));
        cdInfo.add(new CardInfo(R.drawable.wellmanspub,"Wellman's Pub","Distance Away","$$"));

        cardAdapter = new CardAdapter(this,cdInfo);
        cardStack.setAdapter(cardAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.barlistbutton, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.barlist) {
            Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
            startActivity(intent);
            return true;
                }
        return super.onOptionsItemSelected(item);
        }
    }
