package com.exercise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.exercise.bean.FilmBean;

public class FilmDao {

	public List<FilmBean> getFilm() {

		List<FilmBean> films = new ArrayList<FilmBean>();

		ConnectionManager conmgr = new ConnectionManager();
		Connection conn = conmgr.connect();

		String query = "select film_id, title, description, rental_rate, rating, special_feature, genre from films";

		try {

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				FilmBean film = new FilmBean();

				film.setFilm_id(rs.getInt("film_id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setRental_rate(rs.getString("rental_rate"));
				film.setRating(rs.getString("rating"));
				film.setSpecial_feature(rs.getString("special_feature"));
				film.setGenre(rs.getString("genre"));

				films.add(film);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return films;

	}

	public int addFilm(FilmBean films) {
		int result = 0;

		ConnectionManager conmgr = new ConnectionManager();
		Connection conn = conmgr.connect();

		String sql = "insert into films(film_id, title, description, rental_rate, rating, special_feature, genre) values (?,?,?,?,?,?,?)";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, films.getFilm_id());
			ps.setString(2, films.getTitle());
			ps.setString(3, films.getDescription());
			ps.setString(4, films.getRental_rate());
			ps.setString(5, films.getRating());
			ps.setString(6, films.getSpecial_feature());
			ps.setString(7, films.getGenre());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;

	}

	public FilmBean searchFilm(int filmID) {

		FilmBean films = new FilmBean();

		ConnectionManager conmgr = new ConnectionManager();
		Connection conn = conmgr.connect();

		String sql = "select film_id, title, description, rental_rate, rating, special_feature, genre from films where film_id = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, filmID);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				FilmBean film = new FilmBean();

				films.setFilm_id(rs.getInt("film_id"));
				films.setTitle(rs.getString("title"));
				films.setDescription(rs.getString("description"));
				films.setRental_rate(rs.getString("rental_rate"));
				films.setRating(rs.getString("rating"));
				films.setSpecial_feature(rs.getString("special_feature"));
				films.setGenre(rs.getString("genre"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return films;

	}

	public int updateFilm(FilmBean films) {
		int result = 0;

		ConnectionManager conmgr = new ConnectionManager();
		Connection conn = conmgr.connect();

		String sql = "update films set title = ?, description = ?, rental_rate = ?, rating = ?, special_feature = ?, genre = ? where film_id = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, films.getTitle());
			ps.setString(2, films.getDescription());
			ps.setString(3, films.getRental_rate());
			ps.setString(4, films.getRating());
			ps.setString(5, films.getSpecial_feature());
			ps.setString(6, films.getGenre());
			ps.setInt(7, films.getFilm_id());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int deleteFilm(int filmID) {
		int result = 0;

		ConnectionManager conmgr = new ConnectionManager();
		Connection conn = conmgr.connect();

		String sql = "delete from films where film_id = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, filmID);

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
