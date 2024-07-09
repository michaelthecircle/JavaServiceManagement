package ru.mai.lessons.rpks.service.filtering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mai.lessons.rpks.model.Filter;
import ru.mai.lessons.rpks.repository.FilterRepository;

@Service
public class FilterService {
    private final FilterRepository filterRepository;

    @Autowired
    public FilterService(FilterRepository filterRepository) {
        this.filterRepository = filterRepository;
    }

    public Iterable<Filter> getAllFilters() {
        return filterRepository.findAll();
    }
    public Iterable<Filter> getAllFiltersByFilterId(Long filterId) {
        return filterRepository.findAllByFilterId(filterId);
    }
    public Filter getFilterByFilterIdAndRuleId(Long filterId, Long ruleId) {
        return filterRepository.findByFilterIdAndRuleId(filterId, ruleId);
    }
    public void deleteFilters() {
        filterRepository.deleteAll();
    }
    public void deleteFilterByFilterIdAndRuleId(Long filterId, Long ruleId) {
        filterRepository.deleteByFilterIdAndRuleId(filterId, ruleId);
    }
    public void save(Filter filter) {
        filterRepository.save(filter);
    }
}
