package com.spring.notes.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("notes")
public record Note (@Id long noteId, String title, String content, LocalDate date){
}
