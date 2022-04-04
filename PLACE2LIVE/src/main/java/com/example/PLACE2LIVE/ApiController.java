package com.example.PLACE2LIVE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/API")
public class ApiController {

    @Autowired
    private UserRepository userRepository;


    // User Creation

    @PostMapping("/checkLogin")
    public @ResponseBody
    int checkLogin(@RequestBody User user){

        User result = userRepository.findById(user.getUserId()).orElse(null);
        if(result==null || !result.getPassword().equals(user.getPassword())){
            return 0;
        }
        return 1;
    }

    @PostMapping(value = "/createUser",consumes = {"application/json"})
    public @ResponseBody
    int createUser(@RequestBody User user){

        if(userRepository.findById(user.getUserId()).equals(Optional.empty())){
            System.out.println(user);
            userRepository.save(user);
            return 1;
        }

        return 0;

    }


    /// POST related stuff
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/allPosts")
    public @ResponseBody
    Iterable<Post> getAllPosts(){

        return postRepository.findAll();
    }

    @PostMapping("/createPost")
    public @ResponseBody
    int createPost(@RequestBody Post post){
        postRepository.save(post);
        return 1;
    }

    @PostMapping("/editPost/{id}")
    public @ResponseBody
    String editPost(@RequestBody Post post, @PathVariable("id") Long id){
        System.out.println(id);
        Post prevPost = postRepository.findById(id).orElse(null);
        if (prevPost == null)
            return "Post ID does not exist";

        Long currUserID = post.getPosterId();
        Long prevUserID = prevPost.getPosterId();

        if(!currUserID.equals(prevUserID))
            return "You can only edit posts You made";

        if (post.getPostAddress() != null)
            prevPost.setPostAddress(post.getPostAddress());
        if(post.getPostCategory() != null)
            prevPost.setPostCategory(post.getPostCategory());
        postRepository.save(prevPost);
        return "SUCCESS";
    }

}



