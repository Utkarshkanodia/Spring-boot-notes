package com.notes.jpa.cardinalities.one_to_many.unidirectional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("client_unideirectional_one_to_many")
public class OneToManyUnidirectionalClient {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PostRepository postRepository;

    public void save() {
        Account account = new Account();
        account.setName("utkarsh");
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post();
        post1.setTitle("Post Title");
        Post post2 = new Post();
        post1.setTitle("Post Title 2");
        posts.add(post1);
        posts.add(post2);
        account.setPosts(posts);
        accountRepository.save(account);
    }
}
