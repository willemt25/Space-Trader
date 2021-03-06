package com.example.spacetrader.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import com.example.spacetrader.R;
import com.example.spacetrader.entity.Game;
import com.example.spacetrader.entity.Player;

import java.io.File;

/**
 * Activity deals with player creation on opening screen
 */
public class CreatePlayerActivity extends AppCompatActivity {

    private Player player;

    private TextView counterTextView;
    private TextView pilotCounterTextView;
    private TextView pilotFighterTextView;
    private TextView pilotTraderTextView;
    private TextView pilotEngineerTextView;
    private TextView toastTextView;

    private Game game;

    private EditText myName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_player);

        player = new Player();//player to pass to MainActivity

        counterTextView = findViewById(R.id.total_counter);
        counterTextView.setText("" + player.getRemainingCount());

        pilotCounterTextView = findViewById(R.id.pilot_counter);
        pilotFighterTextView = findViewById(R.id.fighter_counter);
        pilotTraderTextView = findViewById(R.id.trader_counter);
        pilotEngineerTextView = findViewById(R.id.engineer_counter);
        toastTextView = findViewById(R.id.toast);

        myName = findViewById(R.id.editText);

        //populate spinner
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> dataAdapter =
				ArrayAdapter.createFromResource(this, R.array.difficulty, R.layout.my_spinner);
        dataAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinner.setAdapter(dataAdapter);
	}

    ///////////////////////////////////////////////////////////////////////////////////////
    //Pilot
    ///////////////////////////////////////////////////////////////////////////////////////

    /**
     * When Pilot Plus is Clicked
     * @param v View
     */
    public void onClickPilotPlus(View v) {
        player.incrementPilotSkillPoints();
        pilotCounterTextView.setText("" + player.getPilotSkillPoints());
        counterTextView.setText("" + player.getRemainingCount());
    }

    /**
     * When pilot minus is clicked
     * @param v View
     */
    public void onClickPilotMinus(View v) {
        player.decrementPilotSkillPoints();
        pilotCounterTextView.setText("" + player.getPilotSkillPoints());
        counterTextView.setText("" + player.getRemainingCount());
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //Fighter
    ///////////////////////////////////////////////////////////////////////////////////////

    /**
     * When fighter plus is clicked
     * @param v View
     */
    public void onClickFighterPlus(View v) {
        player.incrementFighterSkillPoints();
        pilotFighterTextView.setText("" + player.getFighterSkillPoints());
        counterTextView.setText("" + player.getRemainingCount());
    }

    /**
     * When fighter minus is clicked
     * @param v View
     */
    public void onClickFighterMinus(View v) {
        player.decrementFighterSkillPoints();
        pilotFighterTextView.setText("" + player.getFighterSkillPoints());
        counterTextView.setText("" + player.getRemainingCount());
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //Trader
    ///////////////////////////////////////////////////////////////////////////////////////

    /**
     * Increments Trader Points
     * @param v View
     */
    public void onClickTraderPlus(View v) {
        player.incrementTraderSkillPoints();
        pilotTraderTextView.setText("" + player.getTraderSkillPoints());
        counterTextView.setText("" + player.getRemainingCount());
    }

    /**
     * Decrements Trader Points
     * @param v View
     */
    public void onClickTraderMinus(View v) {
        player.decrementTraderSkillPoints();
        pilotTraderTextView.setText("" + player.getTraderSkillPoints());
        counterTextView.setText("" + player.getRemainingCount());
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //Engineer
    ///////////////////////////////////////////////////////////////////////////////////////

    /**
     * Increments Engineer Points
     * @param v View
     */
    public void onClickEngineerPlus(View v) {
        player.incrementEngineerSkillPoints();
        pilotEngineerTextView.setText("" + player.getEngineerSkillPoints());
        counterTextView.setText("" + player.getRemainingCount());
    }

    /**
     * Decrements Engineer Points
     * @param v View
     */
    public void onClickEngineerMinus(View v) {
        player.decrementEngineerSkillPoints();
        pilotEngineerTextView.setText("" + player.getEngineerSkillPoints());
        counterTextView.setText("" + player.getRemainingCount());
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //Ok
    ///////////////////////////////////////////////////////////////////////////////////////

    /**
     * Checks player conditions, and creates new intent if acceptable
     * @param v View
     */
    public void onClickOK(View v) {
        if (myName.getText().length() == 0) {
            toastTextView.setText("PLEASE ENTER NAME");
        } else if (player.getRemainingCount() != 0) {
            toastTextView.setText("PLEASE ALLOCATE ALL SKILL POINTS");
        } else {
            player.setName(myName.getText().toString());
            toastTextView.setText("PLAYER SUCCESSFULLY CREATED");
            game = Game.getInstance();
            game.setPlayer(player);
            Intent intent = new Intent(CreatePlayerActivity.this, MainActivity.class);
            //intent.putExtra("Player", player);
            startActivity(intent); //goes to MainActivity.
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //Exit
    ///////////////////////////////////////////////////////////////////////////////////////


    ///////////////////////////////////////////////////////////////////////////////////////
    //Load
    ///////////////////////////////////////////////////////////////////////////////////////

    /**
     * Load previous game
     * @param v View
     */
    public void onClickLoad(View v) {
        File file = new File(this.getFilesDir(), Game.DEFAULT_BINARY_FILE_NAME);
        game = new Game();
        game.loadBinary(file);
        game = Game.getInstance();
        Intent intent = new Intent(CreatePlayerActivity.this, MainActivity.class);
        startActivity(intent); //goes to MainActivity.
    }

}
