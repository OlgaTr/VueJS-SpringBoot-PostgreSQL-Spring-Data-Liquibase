package com.spring.notes.services;

import com.spring.notes.records.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteJdbcService implements NoteService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Note> findAll() {
        String sql = "SELECT * FROM notes";
        RowMapper<Note> mapper = (rs, rowNum) -> new Note(rs.getLong("id"),
                rs.getString("title"), rs.getString("content"), rs.getDate("date"));
        return jdbcTemplate.query(sql, mapper);
    }
}
