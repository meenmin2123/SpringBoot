package com.ss.board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDX")
    private Integer idx;

    @Column(name = "BOARD_NO")
    private int boardNo;

    @Column(name = "WRITER_NO")
    private int writerNo;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "ORIGINAL_FILENAME")
    private String originalFilename;

    @Column(name = "RENAMED_FILENAME")
    private String renamedFilename;

    @Column(name = "STATUS")
    private String status;

    @Column(name="CREATE_DATE")
    private Timestamp create_date;

    @Column(name="MODIFY_DATE")
    private Timestamp modify_date;

}

// 자바에서 사용하는 Date,Calender 타입은 데이터베이스에 시간만 ,날짜만,
// 시간과 날짜를 두개 다 저장할 지 명확하게
// 지정을 하지않으면 예외가 발생할 수있다.
//  @Temporal(TemporalType.TIMESTAMP)
//   TemporalType타입이 3가지
//   date: 날짜만 time : 시간만
//  TIMESTAMP 둘다 저장(yyyy-MM-dd HH:mm:ss)