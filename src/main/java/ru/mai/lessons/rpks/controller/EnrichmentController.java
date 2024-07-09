package ru.mai.lessons.rpks.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mai.lessons.rpks.model.Enrichment;
import ru.mai.lessons.rpks.service.enrichment.EnrichmentService;

@Validated
@RestController
@RequestMapping("enrichment")
@RequiredArgsConstructor
public class EnrichmentController {
    private final EnrichmentService enrichmentService;

    @GetMapping("/findAll")
    @Operation(summary = "Получить информацию о всех правилах обогащения в БД")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Enrichment> getAllEnrichments() {
        return enrichmentService.getEnrichments();
    }

    @GetMapping("/findAll/{id}")
    @Operation(summary = "Получить информацию о всех правилах обогащения в БД по enrichment id")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Enrichment> getAllEnrichmentsByEnrichmentId(@PathVariable long id) {
        return enrichmentService.getEnrichmentsByEnrichmentId(id);
    }

    @GetMapping("/find/{enrichmentId}/{ruleId}")
    @Operation(summary = "Получить информацию о правиле обогащения по enrichment id и rule id")
    @ResponseStatus(HttpStatus.OK)
    public Enrichment getEnrichmentById(@PathVariable long enrichmentId, @PathVariable long ruleId) {
        return enrichmentService.getEnrichmentById(enrichmentId, ruleId);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Удалить информацию о всех правилах обогащения")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEnrichment() {
        enrichmentService.deleteEnrichments();
    }

    @Transactional
    @DeleteMapping("/delete/{enrichmentId}/{ruleId}")
    @Operation(summary = "Удалить информацию по конкретному правилу обогащения с enrichment id и rule id")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEnrichmentById(@PathVariable long enrichmentId, @PathVariable long ruleId) {
        enrichmentService.deleteEnrichmentByEnrichmentId(enrichmentId, ruleId);
    }

    @PostMapping("/save")
    @Operation(summary = "Создать правило обогащения")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void save(@RequestBody @Valid Enrichment enrichment) {
        enrichmentService.save(enrichment);
    }

}
