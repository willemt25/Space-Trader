package com.example.spacetrader.entity;

import android.util.Log;

import java.io.Serializable;

/**
 * Game class to store all information regarding the gameplay.
 *
 */
public class Game implements Serializable {

    private Player player;
    private Universe universe;

    public Game (Player player) {
        this.player = player;
        this.universe = new Universe();
        Log.d("main", universe.toString());//will remove later.
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //Player Methods
    ///////////////////////////////////////////////////////////////////////////////////////

    public String getPlayerShipName() {
        return player.getShipName();
    }

    public int [] getPlayerSkillPointsArray() {
        return player.getSkillPointsArray();
    }

    public String getPlayerName() {
        return player.getName();
    }

    public int getPlayerCredits() {
        return player.getCredits();
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //Ship Inventory
    ///////////////////////////////////////////////////////////////////////////////////////

    public Resource[] getCargo() {
        return player.getCargo();
    }

    public void addCargo(Resource cargo) {
        player.addCargo(cargo);
    }

    public void removeCargo(Resource cargo) {
        player.removeCargo(cargo);
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //Class methods
    ///////////////////////////////////////////////////////////////////////////////////////

    public String toString() {
        return "GAME: " + player.toString();
    }

}
