package be.kdg.prog3.upvote.persistence;

import be.kdg.prog3.upvote.model.QuestionAnswer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface QuestionAnswerRepository extends CrudRepository<QuestionAnswer, Long> {
    List<QuestionAnswer> findTop10ByParentIsNullOrderByTimestampDesc();
    List<QuestionAnswer> findAnswersByParentOrderByTimestampAsc(QuestionAnswer parent);
}
