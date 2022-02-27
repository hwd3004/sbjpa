<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ include
file="./layout/header.jsp"%>

<div id="app">
  <h1>index</h1>
  <a href="/post/create">post create</a>

  <br />

  <boards></boards>

  <br />

  <a href="/?page=1"><button>1</button></a>
  <a href="/?page=2"><button>2</button></a>
  <a href="/?page=3"><button>3</button></a>
</div>

<script src="/js/post/index.js"></script>
<%@ include file="./layout/footer.jsp"%>
