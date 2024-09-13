package com.ss.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("Board")
public class Board {

    private int idx;
    private int writerNo;
    private String title;
    private String content;
    private String type;
    private String originalFilename;
    private String renamedFilename;
    private String status;
    private Timestamp create_date;
    private Timestamp modify_date;

}
