package NongSan.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCategory implements RowMapper<Category>{

	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category categorys = new Category();
		categorys.setId(rs.getInt("id"));
		categorys.setName(rs.getString("name"));
		categorys.setDescription(rs.getString("description"));
		return categorys;
	}
}
