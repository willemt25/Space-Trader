package com.example.spacetrader.entity;

public class Planet {

    private String name;
    private TechLevel techLevel;
    private ResourceType resourceType;

    /**
     * Planet constructor
     * Will create a random techLevel and resourceType
     * @param name name of the planet
     */
    public Planet(String name) {
        this.name = name;
        this.techLevel = TechLevel.values()[(int)(Math.random() * TechLevel.values().length)];
        this.resourceType = ResourceType.values()[(int)(Math.random() * ResourceType.values().length)];
    }

    @Override
    public String toString() {
        return name;
    }

}