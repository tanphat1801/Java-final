package NongSan.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import NongSan.Entity.MapperProduct;
import NongSan.Entity.Product;

@Repository
public class ProductDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public List<Product> getDataProduct() {
		List<Product> list = new ArrayList<Product>();
		String sql = "SELECT * FROM products";
		list = _jdbcTemplate.query(sql, new MapperProduct());
		return list;
	}
};