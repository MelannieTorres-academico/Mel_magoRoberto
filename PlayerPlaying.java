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
	private ArrayList<Character> secret_word_arr;	//the secret word converted to array
	private Scanner scan = new Scanner(System.in); // for user input
	private ChooseWord word;
	private	String secretword;
	private String s;
	private int i=0;


	GameContext c;

		public PlayerPlaying(GameContext c){
			this.c = c;
			word = new ChooseWord();
			secretword = word.getWord();
			s="";

			correctLetters = new ArrayList<Character>();
			for (int j = 0; j < secretword.length(); j++){
				correctLetters.add('_'); //fill empty arraylist
			}

			secret_word_arr = new ArrayList<Character>(); //creates an arraylist with the letters of the secret word as elements
			for(int j = 0; j < secretword.length();j++){
					secret_word_arr.add(secretword.charAt(j));
			}

		}

		public void draw(Graphics g){
			g.setColor(Color.black);
			g.drawString("Jugador "+c.getPlayer().getId()+" . Escriba una letra o parte de la palabra que desea adivinar.",15,15);
			g.drawString("Palabra secreta:",130, 200);

			for (int j = 0; j < correctLetters.size(); j++){
				g.drawString("   "+correctLetters.get(j),250+(j*20), 200);
			}

		}

		public void transit(){
			c.setState(c.getPlayerWaitingState());
		}

		public void processKey(KeyEvent e){

			if(i==0){
				s="";
			}
			i++;

			int keyCode = e.getKeyCode();
			System.out.println("Tecla Presionada "+(char)e.getKeyCode());
			System.out.println(secretword);
			if(keyCode == KeyEvent.VK_ENTER){
				guess(s);
				System.out.println(s);

				s="";
			}
			else{
				s+=KeyEvent.getKeyText(keyCode);
			}
		}

		public void guess(String s){
		if(secretword.contains(s)){
			int aux=0;

				for(int j=0;j<s.length();j++){
					for(int k=0; k<secret_word_arr.size();k++){
						if(secret_word_arr.get(k)==s.charAt(j)){
							correctLetters.set(k,s.charAt(j) );
						}
					}

				}
				//did i win?
				for(int j = 0; j < correctLetters.size(); j++){
					if(correctLetters.get(j)=='_'){// no if there is at least one underscore
						aux++;
					}
				}
				if(aux==0){
					win();
				}
			}
			else{
				transit();
			}
		}

		public void win(){ //transit to win state
			c.setState(c.getWinState());
		}

		public int changeTurn(int id){
			return id;
	  }

		public void clickMouse(MouseEvent e) {}

}
