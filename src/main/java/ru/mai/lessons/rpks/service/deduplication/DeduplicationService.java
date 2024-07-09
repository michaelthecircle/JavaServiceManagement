package ru.mai.lessons.rpks.service.deduplication;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mai.lessons.rpks.model.Deduplication;
import ru.mai.lessons.rpks.repository.DeduplicationRepository;

@Service
@NoArgsConstructor
public class DeduplicationService {
    @Autowired
    private DeduplicationRepository deduplicationRepository;

    public Iterable<Deduplication> getAllDeduplication() {
        return deduplicationRepository.findAll();
    }
    public Iterable<Deduplication> getAllDeduplicationById(long id) {
        return deduplicationRepository.findAllByDeduplicationId(id);
    }
    public Deduplication getDeduplicationById(long deduplicationId, long ruleId) {
        return deduplicationRepository.findByDeduplicationIdAndRuleId(deduplicationId, ruleId);
    }
    public void deleteDeduplication() {
        deduplicationRepository.deleteAll();
    }
    public void deleteDeduplicationById(long deduplicationId, long ruleId) {
        deduplicationRepository.deleteDeduplicationByDeduplicationIdAndRuleId(deduplicationId, ruleId);
    }
    public void save(Deduplication deduplication) {
        deduplicationRepository.save(deduplication);
    }
}
