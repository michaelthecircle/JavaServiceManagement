package ru.mai.lessons.rpks.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mai.lessons.rpks.model.Enrichment;

@Repository
public interface EnrichmentRepository extends CrudRepository<Enrichment, Long> {
    Iterable<Enrichment> findAllByEnrichmentId(Long enrichmentId);
    Enrichment getEnrichmentByEnrichmentIdAndRuleId(Long enrichmentId, Long ruleId);
    void deleteEnrichmentByEnrichmentIdAndRuleId(Long enrichmentId, Long ruleId);
}
