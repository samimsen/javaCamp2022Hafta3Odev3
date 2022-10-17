package odev3.dataAccess;

import odev3.entities.Category;

public class JdbcCategoryDao implements CategoryDao {
	
	public void add(Category category) {
		System.out.println("JDBC ile veritabanına eklendi");
	}

	

}
