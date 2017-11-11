/*
 * GameContext.java
 *
 * Copyright 2017 Edgar Daniel Fernández Rodríguez <edgar.fernandez@me.com>
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
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameContext {

	GameState start;
	GameState load;
	GameState playerplaying;
	GameState playerwaiting;
	GameState win;
	GameState end;
	GameState currentState;
	Player player;

	public GameContext(){

		start	  			= (GameState) new StartState(this);
		load  				= (GameState) new LoadState(this);
		playerplaying = (GameState) new PlayerPlaying(this);
		playerwaiting = (GameState) new PlayerWaiting(this);
		win 					= (GameState) new WinState(this);
		end 					= (GameState) new EndState(this);
		currentState  = start;
	}


	public GameState getStartState(){
		return this.start;
	}

	public GameState getLoadState(){
		return this.load;
	}

	public GameState getPlayerPlayingState(){
		return this.playerplaying;
	}

	public GameState getPlayerWaitingState(){
		return this.playerwaiting;
	}

	public GameState getWinState(){
		return this.win;
	}

	public GameState getEndState(){
		return this.end;
	}

	public void setState(GameState s){
		this.currentState = s;
	}

	public void setPlayer (Player p){
		player=p;
	}

	public Player getPlayer (){
		return player;
	}

	public void processKey(KeyEvent e){
		currentState.processKey(e);
	}
	public void clickMouse(MouseEvent e) {
		currentState.clickMouse(e);
	}
	public void draw(Graphics g){
		currentState.draw(g);
	}

	public int changeTurn(int id){
		return currentState.changeTurn(id);
	}
	public void win(){
		 currentState.win();
	}
}
