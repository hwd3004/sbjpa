package com.example.sbjpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@DynamicInsert
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    private String content;

    @ColumnDefault("0")
    private int count;

    @ManyToOne
    @JoinColumn(name = "userIdx")
    private User user; // DB는 오브젝트 저장 불가, 자바는 가능

    // mappedBy - 연관관계가 아님을 의미(Fk가 아님을 의미), DB예 칼럼 생성 안함
    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    private List<Reply> reply;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    private List<Storage> storage;

    @CreationTimestamp
    private Timestamp createdAt;

    // 글의 그룹
    @ColumnDefault("0")
    private int ref;

    // 글의 순서
    @ColumnDefault("0")
    private int reStep;

    // 글의 레벨
    @ColumnDefault("0")
    private int reLevel;

}
