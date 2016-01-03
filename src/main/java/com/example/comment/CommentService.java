package com.example.comment;

import org.springframework.data.domain.Page;

public interface CommentService {
    void save(Comment comment);
    Page<Comment> findByPage(int page);
}
