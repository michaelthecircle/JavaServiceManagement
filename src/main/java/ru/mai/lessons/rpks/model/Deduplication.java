package ru.mai.lessons.rpks.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@JsonSerialize
@Table(name = "deduplication_rules")
@NoArgsConstructor
@AllArgsConstructor
public class Deduplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Min(value = 1)
    private long deduplicationId;
    @Min(value = 1)
    private long ruleId;
    @NotBlank
    private String fieldName;
    private long timeToLiveSec;
    private boolean isActive;
}
