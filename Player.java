/*
 * Player.java
 *
 * Copyright 2016 Edgar Daniel Fernández Rodríguez <edgar.fernandez@me.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 *
 *
 */


public class Player {

    private GameState playing;
    private GameState waiting;
    private GameState currentState;
    private boolean winner;
    private String lastKeyword;
    private String answer;

    public Player (){
        winner = false;
      //  lastKeyword = "";
      //  answer = "";
        /*playing = new PlayerPlaying(this);
        waiting = new PlayerWaiting(this);*/
        currentState = waiting;
    }

  /*  public void setState(PlayerState newState){
        currentState = newState;
    }*/

  /*  public GameState getState() {
		return currentState;
	}

    public GameState getPlaying(){
        return playing;
    }*/

  /*  public void setAnswer(String x){
    	answer = x;
    }

    public String getAnswer(){
        return answer;
    }
*/
    /*public GameState getWaiting(){
        return waiting;
    }*/

  /*  public String getLastKeyword(){
        return lastKeyword;
    }

    public void setLastKeyword(String keyword){
        lastKeyword = keyword;
    }*/

    public void setWinner(boolean win){
        winner = win;
    }

    public boolean getWinner(){
        return winner;
    }

    public void playing(){
        currentState=playing;
    }

    public void waiting(){
        currentState=waiting;
    }
}
