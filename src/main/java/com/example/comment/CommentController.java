package com.example.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class CommentController {

    @Autowired
    CommentRepository repository;
    @Autowired
    CommentService service;

    // /comments?page=1
    @RequestMapping("/comments")
    public String comments(
            Model model,
            @RequestParam(defaultValue = "1") int page) {

        Page<Comment> commentPage = service.findByPage(page - 1);

        model.addAttribute("totalPageNumber", commentPage.getTotalPages());
        model.addAttribute("currentPageNumber", commentPage.getNumber() + 1);
        model.addAttribute("comments", commentPage.getContent());

        return "page/comment/list";
    }

    // FIXME URL명명규칙 이야기 필요
    // 하나의 커멘트를 추가한다는 뜻으로 /comment/add로 정했으나, comments를 다른곳에서 사용중이므로, 일관성이 없음.
    @RequestMapping(value = "/comment/add", method = GET)
    public String viewAddComment() {
        return "page/comment/add";
    }

    @RequestMapping(value = "/comment/add", method = POST)
    public String submitAddComment(Comment comment) {
        service.save(comment);
        return "redirect:/comments";
    }

    @RequestMapping(value = "/comments/{id}/modify", method = GET)
    public String viewModifyComment(@PathVariable Long id, Model model) {
        model.addAttribute("comment", repository.getOne(id));
        return "page/comment/modify";
    }

    @RequestMapping(value = "/comments/{id}/modify", method = POST)
    public String submitModifyComment(Comment comment) {
        service.save(comment);
        return "redirect:/comments";
    }

    @RequestMapping(value = "/comments/{id}", method = DELETE)
    @ResponseBody
    public ResponseEntity deleteComment(@PathVariable Long id) {
        repository.delete(id);
        return ResponseEntity.ok(true);
    }
}
