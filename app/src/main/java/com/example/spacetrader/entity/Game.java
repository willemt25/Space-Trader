package com.example.spacetrader.entity;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the model of Space Traders
 */
public class Game implements Serializable {

    private static Game instance = new Game();

    /**
     * Gets game instance
     * @return game instance
     */
    public static Game getInstance() {
        return instance;
    }

    private Player player;
    private final Universe universe;
    private SolarSystem currentSolarSystem;
    private Planet currentPlanet;

    /**
     * Constructor for the game class. Creates a new universe.
     */
    public Game () {
        this.player = new Player();
        this.universe = new Universe();
        this.currentSolarSystem = universe.getOriginSolarSystem();
        this.currentPlanet = universe.getOriginPlanet();
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //Travel Methods
    ///////////////////////////////////////////////////////////////////////////////////////

    /**
     * Travels to the requested solarSystem and planet if allowed. Deducts the necessary
     * fuel from the player's ship.
     * @param solarSystem solar System
     * @param planet planet
     * @return true if successful, false otherwise
     */
    public boolean travel(SolarSystem solarSystem, Planet planet) {
        if (planet.equals(currentPlanet)) {
            Log.e("main", "Game Class: Failed to travel since already at location");
            return false;
        } else if (player.deductFuel((int)(getDistance(solarSystem) + getDistance(planet)))) {
            currentSolarSystem = solarSystem;
            currentPlanet = planet;
            return true;
        }
         return false;
    }

    /**
     * Increments the fuel by one
     */
    public void incrementFuel() {
        player.incrementFuel();
    }

    /**
     * Determines if the requested solarSystem is in range given the player's current
     * fuel and current location
     * @param solarSystem solar System
     * @return true if solarSystem is in range
     */
    public boolean solarSystemInRange(SolarSystem solarSystem) {
        return currentSolarSystem.getDistance(solarSystem) <= getFuel();
    }

    /**
     * Gets the current amount of fuel on the ship
     * @return int fuel on ship
     */
    public int getFuel() {
        return player.getFuel();
    }

    /**
     * Gets the distance between the parameter SolarSystem and the current solarSystem
     * @param solarSystem solar System
     * @return distance
     */
    public double getDistance(SolarSystem solarSystem) {
        return solarSystem.getDistance(currentSolarSystem);
    }

    /**
     * Gets the distance between the parameter planet and the current planet.
     * Ignores solarSystem distance if planets are in different SolarSystems.
     * @param planet planet
     * @return distance
     */
    public int getDistance(Planet planet) {
        if (currentSolarSystem.contains(planet)) {
            return Math.abs(currentSolarSystem.indexOf(planet) -
                    currentSolarSystem.indexOf(currentPlanet));
        } else {
            return planet.getPosition();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //Encounter Methods
    ///////////////////////////////////////////////////////////////////////////////////////

    /**
     * Generates and returns a pirate encounter with the player
     * @return pirateEncounter
     */
    private Encounter pirateEncounter() {
        return new PirateEncounter(player);
    }

    /**
     * Gets a list of encounters while traveling
     * @return list of encounters
     */
    public List<Encounter> getEncounters() {
        List<Encounter> encounters = new ArrayList<>();
        int amount = 1 + (int)(Math.random() * 3);
        for (int i = 0; i < amount; i++) {
            encounters.add(pirateEncounter());
        }
        return encounters;
    }

    /**
     * Gets the ship's health (0, 100]
     * @return ship health
     */
    public int getShipHealth() {
        return player.getShipHealth();
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //Getters for solarSystems and planets
    ///////////////////////////////////////////////////////////////////////////////////////

    /**
     * Gets a list of the planets in the selected solar system in range given current fuel
     * @param parentSolarSystem parent Solar System
     * @return list of planets
     */
    public List<Planet> getPlanetsInRange(SolarSystem parentSolarSystem) {
        List<Planet> planets = new ArrayList<>();
        if (!solarSystemInRange(parentSolarSystem)) {
            return planets;
        }
        int distanceToSolarSystem = (int)getDistance(parentSolarSystem);
        for(Planet p: parentSolarSystem.getPlanets()) {
            if ((getDistance(p) + distanceToSolarSystem) <= player.getFuel()) {
                planets.add(p);
            }
        }
        return planets;
    }

    /**
     * Gets a list of the solar systems in the universe
     * @return solarSystems
     */
    public List<SolarSystem> getSolarSystems() {
        return universe.getSolarSystems();
    }

    /**
     * Gets a list of the solar systems in range given current fuel
     * @return list of solarSystems
     */
    public List<SolarSystem> getSolarSystemsInRange() {
        List<SolarSystem> solarSystems = new ArrayList<>();
        for(SolarSystem s: universe.getSolarSystems()) {
            if (solarSystemInRange(s)) {
                solarSystems.add(s);
            }
        }
        return solarSystems;
    }

    /**
     * Gets the current solarSystem
     * @return solarSystem
     */
    public SolarSystem getCurrentSolarSystem() {
        return currentSolarSystem;
    }

    /**
     * Gets the current planet
     * @return planet
     */
    public Planet getCurrentPlanet() {
        return currentPlanet;
    }

    /**
     * Gets the current solarSystem coordinates
     * @return coordinate
     */
    public Coordinate getCurrentSolarSystemCoordinate() {
        return currentSolarSystem.getCoordinate();
    }

    /**
     * Gets the current solarSystem name
     * @return String name
     */
    public String getCurrentSolarSystemName() {
        return currentSolarSystem.getName();
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //Player Methods
    ///////////////////////////////////////////////////////////////////////////////////////

    /**
     * Sets the player in the game. Used in createPlayer Activity.
     * @param player player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Gets name of the ship
     * @return String name
     */
    public String getPlayerShipName() {
        return player.getShipName();
    }

    /**
     * Gets array with designated points for each skill in each respective index
     * [0] = pilot, [1] = fighter, [2] = trader, [3] = engineer
     * @return int skillPoints Array
     */
    public int [] getPlayerSkillPointsArray() {
        return player.getSkillPointsArray();
    }

    /**
     * Gets the player's name
     * @return String name
     */
    public String getPlayerName() {
        return player.getName();
    }

    /**
     * Gets the player's credits
     * @return int player's credits
     */
    public int getPlayerCredits() {
        return player.getCredits();
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //Market
    ///////////////////////////////////////////////////////////////////////////////////////

    /**
     * Checks if the resource can be bought at the current location given the planet's
     * techLevel and resourceType. Note that even if a resource can be bought, it does
     * not necessarily mean it is available to purchase.
     * @param resource resource
     * @return true if resource can be bought, false otherwise
     */
    public boolean allowedToBuy(Resource resource) {
        return currentPlanet.allowedToBuy(resource);
    }

    /**
     * Checks if the specified resource is available on the planet (i.e. amount > 0)
     * @param resource resource
     * @return true if resource can be bought, false otherwise
     */
    private boolean resourceAvailableToBuy(Resource resource) {
        return currentPlanet.resourceAvailableToBuy(resource);
    }

    /**
     * Checks if the resource can be sold at the current location given the planet's
     * techLevel and resourceType. Note that even if a resource can be sold, it does
     * not necessarily mean it is available to sell (i.e. the player does not have
     * the resource).
     * @param resource resource
     * @return true if resource can be sold, false otherwise
     */
    public boolean allowedToSell(Resource resource) {
        return currentPlanet.allowedToSell(resource);
    }

    /**
     * Gets current location
     * @return current planet's name
     */
    public String getCurrentPlanetName() {
        return currentPlanet.getName();
    }

    /**
     * Gets the current location's resourceType
     * @return String representation of the resourceType
     */
    public String getCurrentPlanetResourceType(){
        return "" + currentPlanet.getResourceType();
    }

    /**
     * Gets the current location's techLevel
     * @return String representation of the techLevel
     */
    public String getCurrentPlanetTechLevel() {
        return "" + currentPlanet.getTechLevel();
    }

    /**
     * Gets the price for the resource at the current planet's market
     * @param resource resource
     * @return int price of the good. -1 if the resource is not available to buy or sell.
     */
    public int getResourcePrice(Resource resource) {
        return currentPlanet.getResourcePrice(resource);
    }

    /**
     * Gets the amount of the specified resource at the current location
     * @param resource resource
     * @return int resource amount
     */
    public int getResourceAmount(Resource resource) {
        return currentPlanet.getResourceAmount(resource);
    }

    /**
     * Gets the string for the current planet's government type
     * @return string government
     */
    public String getGovernmentType() {
        return "" + currentPlanet.getGovernment();
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //Ship Inventory
    ///////////////////////////////////////////////////////////////////////////////////////

    /**
     * Gets the amount of cargo that the player's ship current holds
     * @param resource resource
     * @return int cargo amount
     */
    public int getCargoCount(Resource resource) {
        return player.getCargoCount(resource);
    }

    /**
     * Adds the specified resource to the player's cargo hold.
     * @param resource resource to add
     */
    public void addCargo(Resource resource) {
        if (!allowedToSell(resource)) {
            Log.e("main", "Game Class: Failed to add " + resource + " since it is not allowed to " +
                    "be bought at the market");
        } else if (!resourceAvailableToBuy(resource)) {
            Log.e("main", "Game Class: Failed to add " + resource + " since it is not available " +
                    "at the market");
        } else if (player.addCargo(resource, resource.getPrice(currentPlanet.getTechLevel(),
                currentPlanet.getResourceType(), currentPlanet.getGovernment()))){
            currentPlanet.decrementResourceAmount(resource);
        }
    }

    /**
     * Gets the average price the player will need to get for each resource to break even.
     * @param resource resource
     * @return avg price of resource
     */
    public double getAvgPrice(Resource resource) {
        return player.getAvgPrice(resource);
    }

    /**
     * Removes the specified cargo from the ship's cargo.
     * @param resource resource
     */
    public void removeCargo(Resource resource) {
        if (!allowedToSell(resource)) {
            Log.e("main", "Game Class: Failed to remove " + resource +
                    " since it is not allowed to " +
                    "be sold at the market");
        } else if (player.removeCargo(resource, resource.getPrice(currentPlanet.getTechLevel(),
                currentPlanet.getResourceType(), currentPlanet.getGovernment()))) {
            currentPlanet.incrementResourceAmount(resource);
        }
    }

    /**
     * Dumps the specified cargo from the ship's cargo. No credits are added to player.
     * @param resource resource
     */
    public void dumpCargo(Resource resource) {
        player.dumpCargo(resource);
    }

    /**
     * Gets the max cargo amount that the player's ship can hold
     * @return max cargo
     */
    public int getMaxCargo() {
        return player.getMaxCargo();
    }

    /**
     * Gets current cargo amount on the player's ship
     * @return current cargo
     */
    public int getCurrentCargo() {
        return player.getCurrentCargo();
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //Class methods
    ///////////////////////////////////////////////////////////////////////////////////////

    @Override
    public String toString() {
        return "GAME: " + player.toString();
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //Persistence methods
    ///////////////////////////////////////////////////////////////////////////////////////

    public static final String DEFAULT_BINARY_FILE_NAME = "data.bin";

    /**
     * Loads file
     * @param file file
     */
    public void loadBinary(File file) {
        boolean success = true;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            instance = (Game) in.readObject();
            in.close();
        } catch (IOException e) {
            Log.e("main", "Game Class: Error reading an entry from binary file",e);
            success = false;
        } catch (ClassNotFoundException e) {
            Log.e("main", "Game Class: Error casting a class from the binary file",e);
            success = false;
        }
    }

    /**
     * Saves file
     * @param file file
     */
    public void saveBinary(File file) {
        boolean success = true;
        try {
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(instance);
            out.close();

        } catch (IOException e) {
            Log.e("main", "Game Class: Error writing an entry from binary file",e);
            success = false;
        }
    }


}
