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
import java.io.*;
import java.util.*;

public class PlayerPlaying implements GameState {
	private ArrayList<Character> correctLetters;   // correct guesses
	private ArrayList<Character> incorrectLetters; // incorrect guesses
	private ArrayList<Character> secret_word_arr;	//the secret word converted to array
	private Scanner scan = new Scanner(System.in); // for user input
	private ChooseWord word;
	private	String secretword;

	GameContext c;

		public PlayerPlaying(GameContext c){
			this.c = c;
			word = new ChooseWord();
			secretword = word.getWord();


			this.correctLetters = new ArrayList<Character>();
			for (int i = 0; i < secretword.length(); i++){
				this.correctLetters.add('_');
			}

			this.incorrectLetters = new ArrayList<Character>();

			//creates an arraylist with the letters of the secret word as elements
			this.secret_word_arr = new ArrayList<Character>();
			for(int i = 0; i < secretword.length();i++){
					secret_word_arr.add(secretword.charAt(i));
			}



		}

		public void draw(Graphics g){
			g.setColor(Color.black);
			//g.drawString("Playing palabra:"+secretword,200, 200);
			//g.drawString("Secret word array:"+secret_word_arr,200, 200);

			//g.drawString("Secret word array:"+correctLetters,200, 200);
			g.drawString("Secret word array:",130, 200);

			for (int i = 0; i < this.correctLetters.size(); i++){
				g.drawString("   "+correctLetters.get(i),250+(i*20), 200);
			}

			g.drawString("Misses:",130, 215);

			for (int i = 0; i < this.incorrectLetters.size(); i++){
				g.drawString("   "+incorrectLetters.get(i),250+(i*20), 215);
			}


		}

		public void transit(){
			c.setState(c.getPlayerWaitingState());
		}

		public void processKey(KeyEvent e){
			int keyCode = e.getKeyCode();
			System.out.println("Tecla Presionada "+e.getKeyCode());
			if(keyCode != 0){
				transit();
			}
		}

		public void guess(){}


		public void win(){}


		public void clickMouse(MouseEvent e) {}


		public boolean changeTurn(){
			//if player loose return true transit to wait
			return false;
		}
	//	public void setPlayer (Player p){	}

}
