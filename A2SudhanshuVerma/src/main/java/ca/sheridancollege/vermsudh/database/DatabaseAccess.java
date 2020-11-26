package ca.sheridancollege.vermsudh.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ca.sheridancollege.vermsudh.beans.Restaurant;

@Repository
public class DatabaseAccess {
	
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public void insertRestroList(Long id, String name, String review, String reviewDate, String reviewTime) {
		MapSqlParameterSource namedParameter = new MapSqlParameterSource();
	
		String query = "INSERT INTO restro(id, name, review, reviewDate, reviewTime ) VALUES(:id, :name, :review, :reviewDate, :reviewTime )";
	
		namedParameter.addValue("id", id);
		namedParameter.addValue("name", name);
		namedParameter.addValue("review", review);
		namedParameter.addValue("reviewDate", reviewDate);
		namedParameter.addValue("reviewTime", reviewTime);
		
		int rowsAffected = jdbc.update(query, namedParameter);
		if (rowsAffected > 0)
			System.out.println("Inserted restro info into Database");
	}
	public List<Restaurant> getRestaurantLists(){	
    	String query = "Select * from restro";
    	List<Restaurant> restroList = jdbc.query(query, new BeanPropertyRowMapper<Restaurant>(Restaurant.class));
		return restroList;
    }
	 public void deleteRestroList(Long id) {
	    	MapSqlParameterSource namedParameter = new MapSqlParameterSource();
	    	String query= "DELETE From restro Where id = :id";
	    	namedParameter.addValue("id", id);
			int rowsAffected = jdbc.update(query, namedParameter);
			if(rowsAffected  >0 )
				System.out.println("Delete this" + id+ "from the database");
	    }
	 public List<Restaurant> getRestaurantsById(Long id) {
			MapSqlParameterSource namedParameter = new MapSqlParameterSource();
			
			String query = "Select * from restro where id = :id";
			namedParameter.addValue("id", id);
			
	    	List<Restaurant> restroList = jdbc.query(query, namedParameter,
	    			new BeanPropertyRowMapper<Restaurant>(Restaurant.class));
	    	
			return restroList;
		}

}
