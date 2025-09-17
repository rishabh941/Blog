package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blogs")
public class BlogController {

	@Autowired
	BlogRepository blogRepository;


    @GetMapping()
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @PostMapping("/addblogs")
    public void createBlog(@RequestBody Blog blog) {
         blogRepository.save(blog);
    }
    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable Long id, @RequestBody Blog newBlog) {
    	Blog oldBlogs = blogRepository.findById(id).orElse(null);
    	
    	
    		if(oldBlogs != null) {
    			if(newBlog.getTopic() != null && !newBlog.getTopic().isEmpty()) {
    				oldBlogs.setTopic(newBlog.getTopic());
    			}
    			if (newBlog.getContent() != null && !newBlog.getContent().isEmpty()) {
    	             oldBlogs.setContent(newBlog.getContent());
    	        }
    	            if (newBlog.getName() != null && !newBlog.getName().isEmpty()) {
    	                oldBlogs.setName(newBlog.getName());
    	            }

    	            return blogRepository.save(oldBlogs);
    		}
    	return null;
    }
    
    @DeleteMapping("/{id}")
    public String deleteBlog(@PathVariable Long id) {
    	if(blogRepository.existsById(id)) {
    		blogRepository.deleteById(id);
    		return "Blog deleted successfully";
    	}
    	else {
    		return "Blog not found";
    	}
    } 
}
