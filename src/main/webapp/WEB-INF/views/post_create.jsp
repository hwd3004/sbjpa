<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--  -->
<%@ include file="./layout/header.jsp"%>

<div>
  <h1>post create</h1>

  <form id="form" method="post" enctype="multipart/form-data">
    <input type="text" name="title" placeholder="title" />
    <input type="file" name="file" multiple />
    <input type="submit" />
  </form>
</div>
<script src="/js/post/create.js"></script>

<%@ include file="./layout/footer.jsp"%>
