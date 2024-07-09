package ru.mai.lessons.rpks.metric;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import ru.mai.lessons.rpks.repository.EnrichmentRepository;

@Component
@RequiredArgsConstructor
public class EnrichmentCountMetrics implements InfoContributor {
    private final EnrichmentRepository enrichmentRepository;

    @Override
    public void contribute(Info.Builder builder) {
        val countEnrichment = enrichmentRepository.count();
        builder.withDetail("countEnrichments", countEnrichment);
    }
}
