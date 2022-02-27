package com.example.sbjpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // User 클래스가 dbms에 테이블이 생성됨
// @DynamicInsert // insert 시 null 값인 필드 제외
// @DynamicUpdate
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 30, unique = true)
	private String userId;

	@Column(nullable = false, length = 30, unique = true)
	private String userName;

	@Column(nullable = false, length = 255)
	private String password;

	// @ColumnDefault("'user'") // 칼럼의 default value 지정
	// private String role;
	//
	@Enumerated(EnumType.STRING)
	private RoleType role;

	@CreationTimestamp
	private Timestamp createdAt;

	// @CreatedDate - 스프링 프레임워크 제공, @EnableJpaAuditing 추가작업 필요
	// @CreationTimestamp - jpa 표준이 아니라 하이버네이트에서 제공
}
