package ru.mai.lessons.rpks.metric;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import ru.mai.lessons.rpks.repository.DeduplicationRepository;

@RequiredArgsConstructor
@Component
public class DeduplicationCountMetrics implements InfoContributor {
    private final DeduplicationRepository deduplicationRepository;

    @Override
    public void contribute(Info.Builder builder) {
        val countDeduplications = deduplicationRepository.count();
        builder.withDetail("countDeduplications", countDeduplications);
    }
}
