package ru.mai.lessons.rpks.service.enrichment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mai.lessons.rpks.model.Enrichment;
import ru.mai.lessons.rpks.repository.EnrichmentRepository;

@Service
public class EnrichmentService {
    private final EnrichmentRepository enrichmentRepository;

    @Autowired
    public EnrichmentService(EnrichmentRepository enrichmentRepository) {
        this.enrichmentRepository = enrichmentRepository;
    }
    public Iterable<Enrichment> getEnrichments() {
        return enrichmentRepository.findAll();
    }
    public Iterable<Enrichment> getEnrichmentsByEnrichmentId(long id) {
        return enrichmentRepository.findAllByEnrichmentId(id);
    }
    public Enrichment getEnrichmentById(long enrichmentId, long ruleId) {
        return enrichmentRepository.getEnrichmentByEnrichmentIdAndRuleId(enrichmentId, ruleId);
    }
    public void deleteEnrichments() {
        enrichmentRepository.deleteAll();
    }
    public void deleteEnrichmentByEnrichmentId(long enrichmentId, long ruleId) {
        enrichmentRepository.deleteEnrichmentByEnrichmentIdAndRuleId(enrichmentId, ruleId);
    }
    public void save(Enrichment enrichment) {
        enrichmentRepository.save(enrichment);
    }
}
