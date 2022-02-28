<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ include
file="./layout/header.jsp"%>

<div>
  <h1>log in</h1>
  <div>
    <form>
      <div><label for="userId">id</label> <input type="text" placeholder="enter id" id="userId" name="userId" /></div>
      <div>
        <label for="password">password</label>
        <input type="password" placeholder="enter password" id="password" name="password" />
      </div>
    </form>
    <button id="loginSubmit" type="submit">submit</button>
  </div>
</div>

<script>
  $(function () {
    $("#loginSubmit").click(function () {
      const data = {
        userId: $("#userId").val(),
        password: $("#password").val(),
      };

      $.ajax({
        type: "POST",
        url: "/api/login",
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
      })
        .done(function (response) {
          console.log("response : ", response);
          if(response.data == -1){
            alert("아이디 비밀번호 확인 필요");
          } else {
            location.href = "/";
          }
        })
        .fail(function (error) {
          console.log("error : ", error);
          alert("로그인 실패");
        });
    });
  });
</script>

<%@ include file="./layout/footer.jsp"%>
