package com.example.blog_system.Service;

import com.example.blog_system.ApiResponse.ApiException;
import com.example.blog_system.Model.Category;
import com.example.blog_system.Model.Post;
import com.example.blog_system.Repository.CategoryRepository;
import com.example.blog_system.Repository.PostRepository;
import com.example.blog_system.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    private  final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public List<Post> getAll(){
        if(postRepository.findAll().isEmpty())throw new ApiException("no post found");
        return postRepository.findAll();
    }

    public void add(Post post){
        if(userRepository.findUserById(post.getUserId())==null)
        throw new ApiException("user id not found");

        if(categoryRepository.findCategoryById(post.getCategoryId())==null)
            throw new ApiException("category id not found");
        post.setPublishDate(LocalDate.now());
        postRepository.save(post);
    }

    public void update(Integer id,Post post){
        Post p=postRepository.findPostById(id);
        if(p==null)throw new ApiException("no post with this id");

        //I think it doesn't make sense to update user id & posted date
        p.setTitle(post.getTitle());
        p.setCategoryId(post.getCategoryId());
        p.setContent(post.getContent());
        postRepository.save(p);
    }


    public void delete(Integer id){
        Post p=postRepository.findPostById(id);
        if(p==null)throw new ApiException("no post found with this id");
        postRepository.delete(p);
    }

    //1 End point
    public List<Post> getAllPostByUser(Integer id){
        List<Post>posts=postRepository.getAllPostByUser(id);
        if(posts.isEmpty())throw  new ApiException("not found posts by user id:"+id);

        return posts;
    }


    //2 End point
    public Post getPostByTitle(String title){
        Post p=postRepository.findPostByTitle(title);
        if(p==null)throw new ApiException("there is no post by this title");
        return p;
    }

    //4 End point
    public List<Post> getPostsBeforeDate(LocalDate date){
        List<Post>posts=postRepository.findPostByPublishDateBefore(date);
        if(posts.isEmpty())throw  new ApiException("not found posts published before this date");
        return posts;

    }

    //5 End point
    public void updateContent(Integer id,String content){
        Post p=postRepository.findPostById(id);
        if(p==null)throw new ApiException("no post with this id");
        p.setContent(content);
        p.setLastUpdate(LocalDate.now());
        postRepository.save(p);
    }

    //6End point
    public List<Post> getPostByCategoryId(Integer id){
        List<Post>posts=postRepository.findPostByCategoryId(id);
        if(posts.isEmpty())throw new ApiException("there is no post in this category");
        return posts;

    }
}
