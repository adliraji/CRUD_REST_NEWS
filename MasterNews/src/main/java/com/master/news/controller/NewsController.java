package com.master.news.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.master.news.model.News;
import com.master.news.repository.NewsRepository;

@RestController
@RequestMapping("/news")
public class NewsController {

@Autowired
NewsRepository newsRepository;


@GetMapping("/")
public List<News> getAll(){
return newsRepository.findAll();
}

@PostMapping("/")
public News tambahnews(@Valid @RequestBody News news) {
return newsRepository.save(news);
}

@PutMapping("/{id}")
public ResponseEntity<News> updateNews(@PathVariable(value="id")String id,
@Valid @RequestBody News detailnews){
Optional<News> optionalnews = newsRepository.findById(id);
News news = optionalnews.get();
if(news == null)
return ResponseEntity.notFound().build();
news.setTitle(detailnews.getTitle());
news.setDescription(detailnews.getDescription());
News updatedNews = newsRepository.save(news);
return ResponseEntity.ok(updatedNews);
}

@DeleteMapping("/{id}")
public String deleteNews(@PathVariable (value="id") String id){
Optional<News> news = newsRepository.findById(id);
String result = "";
if(news == null) {
result = "id "+id+" tidak ditemukan";
return result;
}
result = "id "+id+" berhasil di hapus";
newsRepository.deleteById(id);
return result; 
}

@GetMapping("/{id}")
public ResponseEntity<News> getNewsById(@PathVariable(value="id") String id){
Optional<News> optionalnews = newsRepository.findById(id);
News news = optionalnews.get();
if(news == null)
return ResponseEntity.notFound().build();
return ResponseEntity.ok().body(news);
}

@GetMapping("/sortnews")
public List<News> sortnews(@RequestParam(value="title")String title){
return newsRepository.findByTitle(title);
}

@GetMapping("/sortstatus/{description}")
public List<News> sortstatus(@PathVariable(value="Description") String description){
return newsRepository.findByDescription(description);
}


}