package com.exercise.manager;

import java.util.List;

import com.exercise.bean.FilmBean;
import com.exercise.dao.FilmDao;

public class FilmManager {

	FilmDao filmDao = new FilmDao();
	
	
	
	public List<FilmBean> getFilmList(){
		return filmDao.getFilm();
	}
	
	public int addFilm(FilmBean film) {
		
		return filmDao.addFilm(film);
	}
	
	public FilmBean searchFilm(int FilmId) {
		return filmDao.searchFilm(FilmId);
	}
	
	public int updateFilm(FilmBean film) {
		return filmDao.updateFilm(film);
	}
	
	public int deleteFilm(int filmID) {
		return filmDao.deleteFilm(filmID);
	}
}
