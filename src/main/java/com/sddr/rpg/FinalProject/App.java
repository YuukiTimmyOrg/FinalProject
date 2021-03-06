package com.sddr.rpg.FinalProject;

import com.sddr.rpg.beans.hero.Hero;
import com.sddr.rpg.beans.hero.HeroStats;
import com.sddr.rpg.beans.hero.HeroType;
import com.sddr.rpg.connection.ConnectionProvider;
import com.sddr.rpg.dao.HeroDao;
import com.sddr.rpg.dao.impl.HeroDaoImpl;
import java.util.List;

public class App{

 public static void main (String[] args){

		HeroDao heroDao = new HeroDaoImpl();
		HeroStats baseStats = new HeroStats();
		Hero hero2 = new Hero("Refia", HeroType.SUP, baseStats); 
		heroDao.addHero(new Hero("Lightning", HeroType.ATK, baseStats));
		heroDao.addHero(hero2);
		heroDao.addHero(new Hero("Snow", HeroType.DEF, baseStats));
		
		List<Hero> heroList = heroDao.getAllHero();
		for (Hero hero : heroList) {
			System.out.println(hero.getName());
		}
		
		heroDao.removeHero(hero2);
		
		heroList = heroDao.getAllHero();
		for (Hero hero : heroList) {
			System.out.println(hero.getName());
		}
		ConnectionProvider.closeConnection();
	}}