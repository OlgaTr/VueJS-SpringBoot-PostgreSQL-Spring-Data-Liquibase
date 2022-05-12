package com.spring.notes.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("notebooks")
public record Notebook(@Column("notebook_id") @Id long id, String theme) {
}
