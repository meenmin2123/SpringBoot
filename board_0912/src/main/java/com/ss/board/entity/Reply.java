package com.ss.board.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
public class Reply {

    @Id
    private int id;
    private String content;
    private Timestamp date;
}
