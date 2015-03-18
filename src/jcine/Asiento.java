/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcine;

/**
 *
 * @author Michael
 */
public class Asiento {
    private String name;
    private Integer posX;
    private Integer posY;
    
    public Asiento(String name, Integer posX, Integer posY)
    {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
    }
    


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the posX
     */
    public Integer getPosX() {
        return posX;
    }

    /**
     * @param posX the posX to set
     */
    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    /**
     * @return the posY
     */
    public Integer getPosY() {
        return posY;
    }

    /**
     * @param posY the posY to set
     */
    public void setPosY(Integer posY) {
        this.posY = posY;
    }
}
