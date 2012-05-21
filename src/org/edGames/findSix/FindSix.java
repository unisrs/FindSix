package org.edGames.findSix;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.edGames.cards.Card;
import org.edGames.cards.DeckOfCards;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class FindSix extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	private final String TAG = "FIND_SIX";

	View btnDraw;
	ImageView imgCard1;
	ImageView imgCard2;
	Card card1;
	Card card2;
	DeckOfCards theDeck;
	ArrayList<Move> theMoves;
	long lastMove;
	boolean dirty;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		imgCard1 = (ImageView) findViewById(R.id.imgCard1);
		imgCard2 = (ImageView) findViewById(R.id.imgCard2);
		imgCard1.setOnClickListener(this);
		imgCard2.setOnClickListener(this);
		theMoves = new ArrayList<Move>();
		initGame();
	}

	@Override
	public void onPause() {
		super.onPause();
		writeData();
	}
	@Override
	public void onStop() {
		super.onStop();
		writeData();
	}

	public void onClick(View v) {
		Card c = new Card('n', '0');

		int d;
		if (theDeck.isEmpty()) {
			writeData();
			d = getResources().getIdentifier("n0", "drawable",
					"org.edGames.findSix");
			imgCard1.setImageResource(d);

		} else {
			c = theDeck.removeCard();
			d = getResources().getIdentifier(c.getResourceTag(), "drawable",
					"org.edGames.findSix");
			// Add Logging here.
			theMoves.add(new Move(card1, card2, System.currentTimeMillis()
					- lastMove));
			dirty = true;
		}

		switch (v.getId()) {

		case R.id.imgCard1:
			imgCard1.setImageResource(d);
			card1 = c;
			break;

		case R.id.imgCard2:
			imgCard2.setImageResource(d);
			card2 = c;
			break;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent i;
		switch (item.getItemId()) {
		case R.id.newGame:
			initGame();
			return true;

		case R.id.rules:
			i = new Intent(this, Rules.class);
			startActivity(i);
			return true;

		case R.id.strat:
			i = new Intent(this, Strategies.class);
			startActivity(i);
			return true;
		case R.id.resume:
			return true;
		}
		return false;
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// ignore orientation/keyboard change
		super.onConfigurationChanged(newConfig);
	}

	public void initGame() {
		theDeck = new DeckOfCards();
		theDeck.shuffle();
		imgCard1.setImageResource(R.drawable.b0);
		imgCard2.setImageResource(R.drawable.b0);

		if (theMoves.size() > 0)
			writeData();

		theMoves = new ArrayList<Move>();
		lastMove = System.currentTimeMillis();
	}

	public void writeData() {
		if (dirty) {
			try {
				File root = Environment.getExternalStorageDirectory();
				if (root.canWrite()) {
					File theFile = File.createTempFile("find6-", null, root);
					FileWriter theWriter = new FileWriter(theFile);
					BufferedWriter out = new BufferedWriter(theWriter);

					out.write(Long.toString(System.currentTimeMillis()) + "\n");

					while (theMoves.size() > 0) {
						out.write((theMoves.remove(0)).toString() + " \n");
					}

					out.close();
					dirty = false;
				}
			} catch (IOException e) {
				Log.e(TAG, "Could not write file " + e.getMessage());
			}
		}
	}

}