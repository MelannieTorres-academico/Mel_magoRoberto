/*
 * StartState.java
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

public class PlayerWaiting implements GameState {

	GameContext c;
	int i;

		public PlayerWaiting(GameContext c){
			this.c = c;
		}

		public void draw(Graphics g){
			g.setColor(Color.black);
		  g.drawString("Player Waiting",200, 200);
		}

		public void transit(){
			i++;
			if(i>200){
				c.setState(c.getPlayerPlayingState());
			}
			//wait a sec, return to playerplaying
		}

		public void processKey(KeyEvent e){}

		public void win(){}

		public void guess(){}

		public void clickMouse(MouseEvent e) {}

		// public void setPlayer (Player p){}


			public boolean changeTurn(){
				return false;
			}

}
