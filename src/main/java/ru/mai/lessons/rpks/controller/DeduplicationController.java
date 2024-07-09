package ru.mai.lessons.rpks.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mai.lessons.rpks.model.Deduplication;
import ru.mai.lessons.rpks.service.deduplication.DeduplicationService;

@Validated
@RestController
@RequestMapping("deduplication")
@RequiredArgsConstructor
public class DeduplicationController {
    private final DeduplicationService deduplicationService;

    @GetMapping("/findAll")
    @Operation(summary = "Получить информацию о всех правилах дедубликации в БД")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Deduplication> getAllDeduplications() {
        return deduplicationService.getAllDeduplication();
    }

    @GetMapping("/findAll/{id}")
    @Operation(summary = "Получить информацию о всех правилах дедубликации в БД по deduplication id")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Deduplication> getAllDeduplicationsByDeduplicationId(@PathVariable long id) {
        return deduplicationService.getAllDeduplicationById(id);
    }

    @GetMapping("/find/{deduplicationId}/{ruleId}")
    @Operation(summary = "Получить информацию о правиле дедубликации по deduplication id и rule id")
    @ResponseStatus(HttpStatus.OK)
    public Deduplication getDeduplicationById(@PathVariable long deduplicationId, @PathVariable long ruleId) {
        return deduplicationService.getDeduplicationById(deduplicationId, ruleId);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Удалить информацию о всех правилах дедубликации")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDeduplication() {
        deduplicationService.deleteDeduplication();
    }
    @Transactional
    @DeleteMapping("/delete/{deduplicationId}/{ruleId}")
    @Operation(summary = "Удалить информацию по конкретному правилу дедубликации с deduplication id и rule id")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDeduplicationById(@PathVariable long deduplicationId, @PathVariable long ruleId) {
        deduplicationService.deleteDeduplicationById(deduplicationId, ruleId);
    }

    @PostMapping("/save")
    @ResponseStatus(value = HttpStatus.CREATED)
    @Operation(summary = "Создать правило дедубликации")
    public void save(@RequestBody @Valid Deduplication deduplication) {
        deduplicationService.save(deduplication);
    }
}
