package com.example.spacetrader.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.spacetrader.R;
import com.example.spacetrader.entity.Game;
import com.example.spacetrader.entity.Resource;

/**
 * Activity deals with inventory menu
 */
public class InventoryActivity extends AppCompatActivity {

    private Game game;
    private TextView creditsTextView;
    private TextView cargoTextView;

    private TextView waterTextView;
    private TextView fursTextView;
    private TextView foodTextView;
    private TextView oreTextView;
    private TextView gamesTextView;
    private TextView firearmsTextView;
    private TextView medicineTextView;
    private TextView machinesTextView;
    private TextView narcoticsTextView;
    private TextView robotsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        game = Game.getInstance();

        creditsTextView = findViewById(R.id.credits_text);
        cargoTextView = findViewById(R.id.cargo_text);

        waterTextView = findViewById(R.id.water_text);
        fursTextView = findViewById(R.id.furs_text);
        foodTextView = findViewById(R.id.food_text);
        oreTextView = findViewById(R.id.ore_text);
        gamesTextView = findViewById(R.id.games_text);
        firearmsTextView = findViewById(R.id.firearms_text);
        medicineTextView = findViewById(R.id.medicine_text);
        machinesTextView = findViewById(R.id.machines_text);
        narcoticsTextView = findViewById(R.id.narcotics_text);
        robotsTextView = findViewById(R.id.robots_text);

        updateText();
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //Dump Buttons
    ///////////////////////////////////////////////////////////////////////////////////////

    /**
     * DumpWater clicked
     * @param v View
     */
    public void onClickDumpWater(View v) {
        game.dumpCargo(Resource.WATER);
        updateText();
    }

    /**
     * DumpFurs clicked
     * @param v View
     */
    public void onClickDumpFurs(View v) {
        game.dumpCargo(Resource.FURS);
        updateText();
    }

    /**
     * DumpFood clicked
     * @param v View
     */
    public void onClickDumpFood(View v) {
        game.dumpCargo(Resource.FOOD);
        updateText();
    }

    /**
     * DumpOre clicked
     * @param v View
     */
    public void onClickDumpOre(View v) {
        game.dumpCargo(Resource.ORE);
        updateText();
    }

    /**
     * DumpGames clicked
     * @param v View
     */
    public void onClickDumpGames(View v) {
        game.dumpCargo(Resource.GAMES);
        updateText();
    }

    /**
     * DumpFirearms clicked
     * @param v View
     */
    public void onClickDumpFirearms(View v) {
        game.dumpCargo(Resource.FIREARMS);
        updateText();
    }

    /**
     * DumpMedicine clicked
     * @param v View
     */
    public void onClickDumpMedicine(View v) {
        game.dumpCargo(Resource.MEDICINE);
        updateText();
    }

    /**
     * DumpMachines clicked
     * @param v View
     */
    public void onClickDumpMachines(View v) {
        game.dumpCargo(Resource.MACHINES);
        updateText();
    }

    /**
     * DumpNarcotics clicked
     * @param v View
     */
    public void onClickDumpNarcotics(View v) {
        game.dumpCargo(Resource.NARCOTICS);
        updateText();
    }

    /**
     * DumpRobots clicked
     * @param v View
     */
    public void onClickDumpRobots(View v) {
        game.dumpCargo(Resource.ROBOTS);
        updateText();
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //Back Buttons
    ///////////////////////////////////////////////////////////////////////////////////////

    /**
     * Back clicked
     * @param v View
     */
    public void onClickBackInventory(View v) {
        finish();
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //Update text
    ///////////////////////////////////////////////////////////////////////////////////////

    private void updateText() {
        creditsTextView.setText("Credits: " + game.getPlayerCredits());
        cargoTextView.setText("Cargo: " + game.getCurrentCargo() + " / " + game.getMaxCargo());

        waterTextView.setText(generateResourceText(Resource.WATER));
        fursTextView.setText(generateResourceText(Resource.FURS));
        foodTextView.setText(generateResourceText(Resource.FOOD));
        oreTextView.setText(generateResourceText(Resource.ORE));
        gamesTextView.setText(generateResourceText(Resource.GAMES));
        firearmsTextView.setText(generateResourceText(Resource.FIREARMS));
        medicineTextView.setText(generateResourceText(Resource.MEDICINE));
        machinesTextView.setText(generateResourceText(Resource.MACHINES));
        narcoticsTextView.setText(generateResourceText(Resource.NARCOTICS));
        robotsTextView.setText(generateResourceText(Resource.ROBOTS));
    }

    private String generateResourceText(Resource resource) {
        if (game.getCargoCount(resource) > 0) {
            return "" + resource + ": " + game.getCargoCount(resource) + "   " +
                    "(" + game.getAvgPrice(resource) +
                    "/ unit)";
        } else {
            return "" + resource + ": " + game.getCargoCount(resource);
        }
    }
}
