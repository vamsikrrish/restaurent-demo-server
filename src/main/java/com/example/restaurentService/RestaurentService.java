package com.example.restaurentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@Service
public class RestaurentService {

	public List<Restaurent> getRestaurents(Map<String, String[]> parameterMap) throws IOException{
		//This service will access and fetch restaurants from the database
		Reader reader = Resources.getResourceAsReader("mybattisConfig.xml");
	      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
	      SqlSession session = sqlSessionFactory.openSession();
	      Map<String,String> parameters=getStringMapFromParameters(parameterMap);
	       List<Restaurent> restaurentList = session.selectList("Restaurent.getAllRestaurents",parameters); 
	      session.commit();
	      session.close();
	      return restaurentList;
		
	}
	
	private Map<String,String> getStringMapFromParameters( Map<String, String[]> parameterMap){
		/*
		 * This method will convert the parameter map into the preferred format of mybatis
		 * */
		 Map<String,String> stringParameterMap=new HashMap<>(); 
		if (parameterMap.containsKey("searchTerm")) {
			final String value = parameterMap.get("searchTerm")[0];
			stringParameterMap.put("searchTerm", value);
		}
		if (parameterMap.containsKey("category")) {
			final String value = parameterMap.get("category")[0];
			stringParameterMap.put("category", value);
		}
		if (parameterMap.containsKey("sortBy")) {
			final String value = parameterMap.get("sortBy")[0];
			stringParameterMap.put("sortBy", value);
		}
		if (parameterMap.containsKey("minPrice")) {
			final String value = parameterMap.get("minPrice")[0];
			stringParameterMap.put("minPrice", value);
		}
		if (parameterMap.containsKey("maxPrice")) {
			final String value = parameterMap.get("maxPrice")[0];
			stringParameterMap.put("maxPrice", value);
		}
		if (parameterMap.containsKey("rating")) {
			final String value = parameterMap.get("rating")[0];
			stringParameterMap.put("rating", value);
		}
		if (parameterMap.containsKey("sortyBy")) {
			final String value = parameterMap.get("sortyBy")[0];
			stringParameterMap.put("sortyBy", value);
		}
		if (parameterMap.containsKey("limit")) {
			final String value = parameterMap.get("limit")[0];
			stringParameterMap.put("limit", value);
		}
		if (parameterMap.containsKey("offset")) {
			final String value = parameterMap.get("offset")[0];
			stringParameterMap.put("offset", value);
		}
		return stringParameterMap;
	}

	public List<Category> getCategoriesService() {
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybattisConfig.xml");
		      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
		      SqlSession session = sqlSessionFactory.openSession();
		      System.out.println("Fetching data");
		       List<Category> categoriesList = session.selectList("Restaurent.getAllCategories"); 
		      session.commit();
		      session.close();
		      return categoriesList;	
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	      
	}
	
	
}
