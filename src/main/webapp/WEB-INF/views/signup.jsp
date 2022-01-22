<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="./layout/header.jsp"%>

    <title>sign up</title>
    <script src="/js/signup.js"></script>

<%@ include file="./layout/nav.jsp"%>

<div>
  <form>
    <div class="">
      <label for="userId">id</label>
      <input type="text" placeholder="enter id" id="userId" name="userId" />
    </div>

    <div>
      <label for="userName">user name</label>
      <input type="text" placeholder="enter name" id="userName" name="userName" />
    </div>

    <div>
      <label for="password">password</label>
      <input type="password" placeholder="enter password" id="password" name="password" />
    </div>
  </form>
  <button type="submit">submit</button>
</div>

<%@ include file="./layout/footer.jsp"%>

