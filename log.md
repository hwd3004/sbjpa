라이브러리

devtools
lombok
jpa
mysql driver
security
spring web

pom.xml에 jsp, jstl 추가

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