package com.github.curriculeon.jfoot;

import com.github.git_leon.RandomUtils;
import greenfoot.*;  // imports Actor, World, Greenfoot, GreenfootImage

/**
 * A world where wombats live.
 *
 * @author Michael Kölling
 * @version 2.0
 */
public class WombatWorld extends World {
    /**
     * Create a new world with 10x10 cells and
     * with a cell size of 60x60 pixels.
     */
    public WombatWorld() {
        super(10, 10, 60);
        setBackground("cell.jpg");
        setPaintOrder(Wombat.class, Leaf.class);  // draw wombat on top of leaf
    }

    public void act(){
        // 1% chance of spawning leaves on the map
        if (RandomUtils.createBoolean(0.5F)){
            randomLeaves(50);
        }
    }

    /**
     * Populate the world with a fixed scenario of wombats and leaves.
     */
    public void populate() {
        addObject(new Wombat(), 0, getHeight());
        randomLeaves(100);
    }

    /**
     * Place a number of leaves into the world at random places.
     * The number of leaves can be specified.
     */
    public void randomLeaves(int howMany) {
        for (int i = 0; i < howMany; i++) {
            Leaf leaf = new Leaf();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(leaf, x, y);
        }
    }
}