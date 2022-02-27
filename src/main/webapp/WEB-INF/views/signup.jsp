<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ include
file="./layout/header.jsp"%>

<div>
  <form id="form" method="post">
    <div><label for="userId">id</label> <input type="text" placeholder="enter id" id="userId" name="userId" /></div>

    <div>
      <label for="userName">user name</label>
      <input type="text" placeholder="enter name" id="userName" name="userName" />
    </div>

    <div>
      <label for="password">password</label>
      <input type="password" placeholder="enter password" id="password" name="password" />
    </div>

    <button id="signupSubmit" type="submit">submit</button>
  </form>
</div>
<script src="/js/signup.js"></script>
<%@ include file="./layout/footer.jsp"%>
