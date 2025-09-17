package com.example.demo;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BlogControllertest {

    @Mock
    private BlogRepository blogRepository;

    @InjectMocks
    private BlogController blogController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllBlogs() {
        Blog blog1 = new Blog(1L, "Rishabh", "Spring Boot", "Learning Spring Boot");
        Blog blog2 = new Blog(2L, "Jane", "AOP", "Aspect Oriented Programming in Spring");

        when(blogRepository.findAll()).thenReturn(Arrays.asList(blog1, blog2));

        List<Blog> blogs = blogController.getAllBlogs();

        assertThat(blogs).hasSize(2);
        assertThat(blogs.get(0).getTopic()).isEqualTo("Spring Boot");
    }

    @Test
    void testCreateBlog() {
        Blog blog = new Blog(1L, "Rishabh", "JUnit", "JUnit testing");

        blogController.createBlog(blog);

        verify(blogRepository, times(1)).save(blog);
    }

    @Test
    void testUpdateBlog_Found() {
        Blog existingBlog = new Blog(1L, "Rishabh", "Old Topic", "Old content");
        Blog newBlog = new Blog(null, "Updated Name", "Updated Topic", "Updated content");

        when(blogRepository.findById(1L)).thenReturn(Optional.of(existingBlog));
        when(blogRepository.save(existingBlog)).thenReturn(existingBlog);

        Blog updated = blogController.updateBlog(1L, newBlog);

        assertThat(updated.getTopic()).isEqualTo("Updated Topic");
        assertThat(updated.getContent()).isEqualTo("Updated content");
        assertThat(updated.getName()).isEqualTo("Updated Name");
    }

    @Test
    void testUpdateBlog_NotFound() {
        Blog newBlog = new Blog(null, "Updated Name", "Updated Topic", "Updated content");

        when(blogRepository.findById(99L)).thenReturn(Optional.empty());

        Blog updated = blogController.updateBlog(99L, newBlog);

        assertThat(updated).isNull();
    }

    @Test
    void testDeleteBlog_Found() {
        when(blogRepository.existsById(1L)).thenReturn(true);

        String result = blogController.deleteBlog(1L);

        verify(blogRepository, times(1)).deleteById(1L);
        assertThat(result).isEqualTo("Blog deleted successfully");
    }

    @Test
    void testDeleteBlog_NotFound() {
        when(blogRepository.existsById(99L)).thenReturn(false);

        String result = blogController.deleteBlog(99L);

        assertThat(result).isEqualTo("Blog not found");
    }

    // ---------------- Additional Test Cases ----------------

    @Test
    void testGetAllBlogs_EmptyList() {
        when(blogRepository.findAll()).thenReturn(Arrays.asList());

        List<Blog> blogs = blogController.getAllBlogs();

        assertThat(blogs).isEmpty();
    }

    @Test
    void testCreateBlog_NullBlog() {
        Blog blog = null;

        try {
            blogController.createBlog(blog);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(NullPointerException.class);
        }
    }

    @Test
    void testUpdateBlog_PartialUpdate() {
        Blog existingBlog = new Blog(1L, "Rishabh", "Old Topic", "Old content");
        Blog newBlog = new Blog(null, null, "Updated Topic", null); // only topic updated

        when(blogRepository.findById(1L)).thenReturn(Optional.of(existingBlog));
        when(blogRepository.save(existingBlog)).thenReturn(existingBlog);

        Blog updated = blogController.updateBlog(1L, newBlog);

        assertThat(updated.getTopic()).isEqualTo("Updated Topic");
        assertThat(updated.getContent()).isEqualTo("Old content"); // unchanged
        assertThat(updated.getName()).isEqualTo("Rishabh"); // unchanged
    }

    @Test
    void testDeleteBlog_ThrowsException() {
        when(blogRepository.existsById(1L)).thenReturn(true);
        doThrow(new RuntimeException("DB error")).when(blogRepository).deleteById(1L);

        try {
            blogController.deleteBlog(1L);
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("DB error");
        }
    }

}
