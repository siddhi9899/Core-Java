package com.mockito;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;



@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Mock
    Player player;
    
    @Mock
    Country country;

    @InjectMocks
    Game game;
    
    @Mock
    ArrayList mockedList;
    
    @Spy
    ArrayList spyList;

    @Test
    public void attackWithSwordTest() throws Exception {
        /*System.out.println("1 In attackWithSwordTest Test:"+country+"=="+player+"=="+game);
    	Mockito.when(player.getWeapon()).thenReturn("Sword");
    	Mockito.when(player.getCountry()).thenReturn(country);
    	
    	System.out.println("2 In attackWithSwordTest Test:"+country.getName()+" "+country.getCode()+" language: "+country.getLanguage());
    	Mockito.when(country.getName()).thenReturn("India");
    	Mockito.when(country.getLanguage()).thenReturn("English");
    	assertEquals("Player country:India and attack with: Sword English", game.info());
        */
    	
    	/*mockedList.add("one");
        Mockito.verify(mockedList).add("one");
     
        assertEquals(1, mockedList.size());*/
        
        spyList.add("one");
        Mockito.verify(spyList).add("one");
     
        assertEquals(0, spyList.size());
    }

}
 class Game {

    private Player player;
    
    private Game() {
    }
    
    /*private Game(Player player) {
        this.player = player;
    }*/

    public String info() {
        return "Player country:"+player.getCountry().getName()+" and attack with: " + player.getWeapon()+ " "+player.getCountry().getLanguage();
    }

}

class Player {

    private String weapon;
    private Country country;
    
    private Player(){
    	
    }

    /*public Player(String weapon, Country country) {
        this.weapon = weapon;
        this.country = country;
    }*/

    String getWeapon() {
        return weapon;
    }

	public Country getCountry() {
		return country;
	}

}

class Country
{
	private String name;
	private String code;
	public final String language = "English"; 
	
	public Country(String name, String code)
	{
		this.name = name;
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public String getLanguage() {
		return language;
	}
	
	
}