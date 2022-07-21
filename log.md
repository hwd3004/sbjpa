라이브러리

devtools
lombok
jpa
mysql driver
security
spring web

pom.xml에 jsp, jstl 추가

<hr/>

```xml
<!-- 시큐리티 태그 라이브러리 -->
<dependency>
  <groupId>org.springframework.security</groupId>
  <artifactId>spring-security-taglibs</artifactId>
</dependency>

<!-- JSP 템플릿 엔진 -->
<dependency>
  <groupId>org.apache.tomcat.embed</groupId>
  <artifactId>tomcat-embed-jasper</artifactId>
</dependency>

<!-- JSTL -->
<dependency>
  <groupId>javax.servlet</groupId>
  <artifactId>jstl</artifactId>
</dependency>
```

gradle 사용시

```java
	// 추가 라이브러리
	implementation 'javax.servlet:jstl'	// JSTL
	implementation 'org.apache.tomcat.embed:tomcat-embed-jasper'	// JSP 탬플릿 엔진
	implementation 'org.springframework.security:spring-security-taglibs'	// Security 태그 라이브러리
```

<hr/>

스프링으로 사용자가 업로드한 파일 다운로드

https://jforj.tistory.com/135

https://rockdrumy.tistory.com/1215 - UTF-8 인코딩

https://goodteacher.tistory.com/351

https://velog.io/@pyo-sh/Spring-Boot-파일이미지-업로드-구현하기

docker run -itd --name some-mariadb --env MARIADB_USER=demouser --env MARIADB_PASSWORD=1234 --env MARIADB_ROOT_PASSWORD=1234 -p 3306:3306  mariadb:latest