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

public class WinState implements GameState {
    int i=0;
	  GameContext c;
		Player player;

		public WinState(GameContext c){
			this.c = c;
		}

		public void draw(Graphics g){
      int id;
			i++;
      id=c.getPlayer().getId();
			g.setColor(Color.black);
		  g.drawString("El jugador "+id+" ganó",200, 200);
			if (i>200){
				transit();
			}
		}

		public void transit(){
			c.setState(c.getEndState());
		}

    public int changeTurn(int id){
      return id;
    }

		public void processKey(KeyEvent e){}

		public void clickMouse(MouseEvent e) {}

    public void win(){}

}
