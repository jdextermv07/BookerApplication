package com.pointwest.sakila.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pointwest.sakila.bean.ActorBean;
import com.pointwest.sakila.bean.FilmBean;
import com.pointwest.sakila.repository.ActorDao;
import com.pointwest.sakila.repository.FilmDao;

public class FilmAndActorManager {

	FilmDao newFilmDao = new FilmDao();
	ActorDao newAct = new ActorDao();
	Map<FilmBean, List<ActorBean>> mapFilmAct2 = new HashMap<FilmBean, List<ActorBean>>();
	Map<ActorBean, List<FilmBean>> mapFilmAct1 = new HashMap<ActorBean, List<FilmBean>>();

	public Map<FilmBean, List<ActorBean>> returnTitleSearchResult(String parameter) {
		Map<FilmBean, List<ActorBean>> mapFilmAct2 = new HashMap<FilmBean, List<ActorBean>>();

		for (FilmBean value : newFilmDao.searchByTitle(parameter.toLowerCase())) {
			List<ActorBean> actorsList = newFilmDao.matchingBasisOfFilmActor(value);
			mapFilmAct2.put(value, actorsList);
		}
		return mapFilmAct2;
	}

	public Map<FilmBean, List<ActorBean>> returnGenreSearchResult(String parameter) {
		Map<FilmBean, List<ActorBean>> mapFilmAct2 = new HashMap<FilmBean, List<ActorBean>>();

		for (FilmBean value : newFilmDao.searchByGenre(parameter.toLowerCase())) {
			List<ActorBean> actorsList = newFilmDao.matchingBasisOfFilmActor(value);
			mapFilmAct2.put(value, actorsList);
		}
		return mapFilmAct2;
	}

	

	public Map<ActorBean, List<FilmBean>> returnActorWithTitleUsingLastName(String param){
		Map<ActorBean, List<FilmBean>> mapFilmAct1 = new HashMap<ActorBean, List<FilmBean>>();

		for (ActorBean value : newAct.searchFilmByActorsLastName(param.toLowerCase())) {
			List<FilmBean> actorsList = newAct.matchingOfActorToFilmActorSearch(value);
			mapFilmAct1.put(value, actorsList);
		}
		return mapFilmAct1;
	}
	
	public Map<ActorBean, List<FilmBean>> returnActorWithTitleUsingFirstName(String param){
		Map<ActorBean, List<FilmBean>> mapFilmAct1 = new HashMap<ActorBean, List<FilmBean>>();

		for (ActorBean value : newAct.searchFilmByActorsFirstName(param.toLowerCase())) {
			List<FilmBean> actorsList = newAct.matchingOfActorToFilmActorSearch(value);
			mapFilmAct1.put(value, actorsList);
		}
		return mapFilmAct1;
	}
	public Map<FilmBean, List<ActorBean>> returnTitleByActorLastName(String param){
		Map<FilmBean, List<ActorBean>> mapFilmAct2 = new HashMap<FilmBean, List<ActorBean>>();

		List<String> actorIDHold = newAct.getActorsID(param);
		List<String> filmIDHold = newAct.matchGetFilmID(actorIDHold);
	
		for(FilmBean value : newAct.getFilmBeanListUsingFilmID(filmIDHold)) {
			List<ActorBean> value1 = newFilmDao.matchingBasisOfFilmActor(value);
			mapFilmAct2.put(value, value1);
			
		}
		return mapFilmAct2;
	}

}
