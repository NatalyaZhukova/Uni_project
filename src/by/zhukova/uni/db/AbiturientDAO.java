package by.zhukova.uni.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.zhukova.uni.entity.Abiturient;
import by.zhukova.uni.entity.Entity;

public class AbiturientDAO extends AbstractDAO {

	static Logger logger = Logger.getLogger(AbiturientDAO.class);

	public AbiturientDAO(Connection connection) {
		super(connection);

	}

	@Override
	public List<Abiturient> findAll() {
		List<Abiturient> list = new ArrayList<Abiturient>();
		String query = "SELECT * FROM abiturients";
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				Abiturient ab = new Abiturient();
				ab.setId(res.getInt(1));
				ab.setUsername(res.getString(2));
				ab.setFirstName(res.getString(3));
				ab.setMiddlName(res.getString(4));
				ab.setLastName(res.getString(5));
				ab.setFirstScore(res.getInt(6));
				ab.setSecondScore(res.getInt(7));
				ab.setThirdScore(res.getInt(8));
				ab.setSchoolScore(res.getInt(9));
				ab.setOverallScore(res.getInt(10));
				list.add(ab);
			}
			super.close(pst);

		} catch (SQLException e) {
			logger.error(e);
		}
		return list;

	}

	@Override
	public Abiturient findEntityById(int id) {
		String query = "SELECT * FROM abiturients WHERE id=?";
		PreparedStatement pst;
		Abiturient ab = null;
		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				ab = new Abiturient();
				ab.setId(res.getInt(1));
				ab.setUsername(res.getString(2));
				ab.setFirstName(res.getString(3));
				ab.setMiddlName(res.getString(4));
				ab.setLastName(res.getString(5));
				ab.setFirstScore(res.getInt(6));
				ab.setSecondScore(res.getInt(7));
				ab.setThirdScore(res.getInt(8));
				ab.setSchoolScore(res.getInt(9));
				ab.setOverallScore(res.getInt(10));
			}
			super.close(pst);
		} catch (SQLException e) {
			logger.error(e);
		}

		return ab;
	}

	@Override
	public boolean delete(int id) {
		String query = "DELETE FROM abiturients WHERE id=?";
		PreparedStatement pst;
		boolean result;
		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			int check = pst.executeUpdate();
			if (check == 0) {
				result = false;
			}
			result = true;
			super.close(pst);
		} catch (SQLException e) {
			logger.error(e);
			result = false;
		}
		return result;
	}

	@Override
	public boolean delete(Entity entity) {
		boolean result;
		int id = entity.getId();
		String query = "DELETE FROM abiturients WHERE id=?";
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			int check = pst.executeUpdate();
			if (check == 0) {
				result = false;
			}
			result = true;
			super.close(pst);
		} catch (SQLException e) {
			logger.error(e);
			result = false;
		}
		return result;
	}

	@Override
	public boolean create(Entity entity) {
		boolean result;
		String query = "INSERT INTO abiturients (id, username, first_name, middle_name, last_name, discipline1_score, discipline2_score, "
				+ "discipline3_score, school_score, score_sum) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pst;
		Abiturient ab = (Abiturient) entity;
		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, ab.getId());
			pst.setString(2, ab.getUsername());
			pst.setString(3, ab.getFirstName());
			pst.setString(4, ab.getMiddlName());
			pst.setString(5, ab.getLastName());
			pst.setInt(6, ab.getFirstScore());
			pst.setInt(7, ab.getSecondScore());
			pst.setInt(8, ab.getThirdScore());
			pst.setInt(9, ab.getSchoolScore());
			pst.setInt(10, ab.getOverallScore());
			int check = pst.executeUpdate();
			if (check == 0) {
				result = false;
			}
			result = true;
			super.close(pst);
		} catch (SQLException e) {
			logger.error(e);
			result = false;
		}
		return result;
	}

	@Override
	public boolean update(Entity entity) {
		boolean result;
		Abiturient ab = (Abiturient) entity;
		String query = "UPDATE abiturients SET username=?, first_name=?, middle_name=?, last_name=?, discipline1_score=?, discipline2_score=?, "
				+ "discipline3_score=?, school_score=?, score_sum=?  WHERE id=?";
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement(query);
			pst.setInt(10, ab.getId());
			pst.setString(1, ab.getUsername());
			pst.setString(2, ab.getFirstName());
			pst.setString(3, ab.getMiddlName());
			pst.setString(4, ab.getLastName());
			pst.setInt(5, ab.getFirstScore());
			pst.setInt(6, ab.getSecondScore());
			pst.setInt(7, ab.getThirdScore());
			pst.setInt(8, ab.getSchoolScore());
			pst.setInt(9, ab.getOverallScore());
			int check = pst.executeUpdate();
			if (check == 0) {
				result = false;
			}
			result = true;
			super.close(pst);

		} catch (SQLException e) {
			logger.error(e);
			result = false;
		}
		return result;
	}

}
