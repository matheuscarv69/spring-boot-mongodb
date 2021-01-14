package com.github.matheuscarv69.services;

import com.github.matheuscarv69.domain.Post;
import com.github.matheuscarv69.repository.PostRepository;
import com.github.matheuscarv69.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
//        return repository.findByTitleContainingIgnoreCase(text);
        return repository.searchTitle(text);
    }

}
