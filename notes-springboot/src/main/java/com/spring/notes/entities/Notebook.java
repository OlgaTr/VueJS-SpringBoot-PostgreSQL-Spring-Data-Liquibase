package com.spring.notes.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("notebooks")
public record Notebook(@Id long notebookId, String theme) {
}
