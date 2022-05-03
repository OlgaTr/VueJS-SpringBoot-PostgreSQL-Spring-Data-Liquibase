package com.spring.notes.records;

import java.util.Date;

public record Note(long id, String title, String content, Date date) {
}
