package ru.mai.lessons.rpks.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "filter_rules")
@JsonSerialize
public class Filter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Min(value = 1)
    private long filterId;
    @Min(value = 1)
    private long ruleId;
    @NotBlank
    private String fieldName;
    @NotBlank
    @Pattern(regexp = "^(equals|contains|not_equals|not_contains)$")
    private String filterFunctionName;
    @NotBlank
    private String filterValue;
}
