package ru.mai.lessons.rpks.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mai.lessons.rpks.model.Filter;
import ru.mai.lessons.rpks.service.filtering.FilterService;

@Validated
@RestController
@RequestMapping("filter")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class FilterController {
    private final FilterService filterService;

    @GetMapping("/findAll")
    @Operation(summary = "Получить информацию о всех фильтрах в БД")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Filter> getAllFilters() {
        return filterService.getAllFilters();
    }

    @GetMapping("/findAll/{id}")
    @Operation(summary = "Получить информацию о всех фильтрах в БД по filter id")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Filter> getAllFiltersByFilterId(@PathVariable long id) {
        return filterService.getAllFiltersByFilterId(id);
    }

    @GetMapping("/find/{filterId}/{ruleId}")
    @Operation(summary = "Получить информацию о фильтре по filter id и rule id")
    @ResponseStatus(HttpStatus.OK)
    public Filter getFilterByFilterIdAndRuleId(@PathVariable long filterId, @PathVariable long ruleId) {
        return filterService.getFilterByFilterIdAndRuleId(filterId, ruleId);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Удалить информацию о всех фильтрах")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFilter() {
        filterService.deleteFilters();
    }

    @Transactional
    @DeleteMapping("/delete/{filterId}/{ruleId}")
    @Operation(summary = "Удалить информацию по конкретному фильтру filter id и rule id")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFilterById(@PathVariable long filterId, @PathVariable long ruleId) {
        filterService.deleteFilterByFilterIdAndRuleId(filterId, ruleId);
    }

    @PostMapping("/save")
    @Operation(summary = "Создать фильтр")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid Filter filter) {
        filterService.save(filter);
    }
}
