<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--  -->
<%@ include file="../layout/header.jsp"%>

<div>
  <h1>post create</h1>

  <c:choose>
    <c:when test="${empty sessionScope.principal }">
      <span>로그인 필요</span>
    </c:when>
    <c:otherwise>
      <form id="form" method="post" enctype="multipart/form-data">
        <input type="text" name="title" placeholder="title" />
        <br />
        <input type="text" name="content" placeholder="content" />
        <br />
        <input type="file" name="file" multiple />
        <br />
        <input type="submit" />
      </form>
    </c:otherwise>
  </c:choose>
</div>
<script src="/js/post/create.js"></script>

<%@ include file="../layout/footer.jsp"%>
