package kr.domaindriven.comment;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

import static org.springframework.data.domain.Sort.Direction.DESC;

@Service
public class CommentServiceImpl implements CommentService {
    private static final int SIZE_PER_PAGE = 5;
    @Autowired
    CommentRepository repository;

    // 테스트 용도 데이터 생성
    @PostConstruct
    public void addSampleData() {
        Lorem lorem = LoremIpsum.getInstance();
        for (int idx = 0; idx < 30; idx++)
            repository.save(new Comment(lorem.getName(), lorem.getWords(4, 10), new Date()));
    }

    @Override
    public void save(Comment comment) {
        comment.setDate(new Date());
        repository.save(comment);
    }

    @Override
    public Page<Comment> findByPage(int page) {
        return repository.findAll(
                new PageRequest(page, SIZE_PER_PAGE, DESC, "id")
        );
    }

}
