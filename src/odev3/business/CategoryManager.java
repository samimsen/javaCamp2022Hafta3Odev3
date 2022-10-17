package odev3.business;

import java.util.ArrayList;
import java.util.List;

import odev3.core.logging.Logger;
import odev3.dataAccess.CategoryDao;
import odev3.entities.Category;

public class CategoryManager {
	
	private CategoryDao categoryDao;
	private Logger[] loggers;

	List<Category> categories = new ArrayList<>();
	
	public CategoryManager(CategoryDao categoryDao, Logger[] loggers) {
		this.categoryDao = categoryDao;
		this.loggers = loggers;
	}
	
	public void add(Category category) throws Exception {
		
		for (Category currentCategory : categories) {
			if(currentCategory.getCategoryName().equals(category.getCategoryName())) {
				throw new Exception("Kategori ismi tekrar edemez");
			}
		}
		
		categories.add(category);
		this.categoryDao.add(category);
		
		for (Logger logger : loggers) {
			logger.log(category.getCategoryName());
		}
		
	}

}
