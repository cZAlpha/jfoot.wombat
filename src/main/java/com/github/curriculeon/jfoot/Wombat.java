package com.github.curriculeon.jfoot;

import com.github.git_leon.RandomUtils;

import static com.github.curriculeon.jfoot.Direction.*;

/**
 * Wombat. A Wombat moves forward until it hits the edge of the world, at
 * which point it turns left. If a wombat finds a leaf, it eats it.
 *
 * @author Michael Kölling
 * @version 2.0
 */
public class Wombat extends Herbivore {
    public Wombat() {
        setImage("wombat.png");
    }

    private int count = -1;

    public void act(){
        // If The Wombat Finds A Leaf
        if (this.foundLeaf()) {
            this.eatLeaf();
        // If The Wombat Does Not Find A Leaf But Hasn't Hit a Wall
        } else if (this.canMove()) {
            this.move();
        // If The Wombat Hits a Wall
        } else {
            // Increments count whenever a wall is hit
            count += 1;
            // Even Turns
            if (count % 2 == 0) {
                this.turnLeft();
                this.move();
                this.turnLeft();
            }
            // Odd Turns
            else {
                this.turnRight();
                this.move();
                this.turnRight();
            }
        }
    }

    public void turnLeft() {
        if (this.getDirection() == EAST) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == WEST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == NORTH) {
            this.setDirection(WEST);
        } else {
            this.setDirection(EAST);
        }
    }

    public void turnRight() {
        if (this.getDirection() == EAST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == WEST) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == NORTH) {
            this.setDirection(EAST);
        } else {
            this.setDirection(WEST);
        }
    }
}
