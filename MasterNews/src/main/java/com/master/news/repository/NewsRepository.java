package com.master.news.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.master.news.model.News;
@Repository
public interface NewsRepository extends JpaRepository<News, String> {
	List<News> findByTitle (String title);
	List<News> findByDescription(String description);
	
}