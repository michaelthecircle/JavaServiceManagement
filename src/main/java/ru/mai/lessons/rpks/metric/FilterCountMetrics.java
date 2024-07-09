package ru.mai.lessons.rpks.metric;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import ru.mai.lessons.rpks.repository.FilterRepository;

@Component
@RequiredArgsConstructor
public class FilterCountMetrics implements InfoContributor {
    private final FilterRepository filterRepository;

    @Override
    public void contribute(Info.Builder builder) {
        val countFilters = filterRepository.count();
        builder.withDetail("countFilters", countFilters);
    }
}
