<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="./layout/header.jsp"%>

<div>
  <form>
    <div>
      <label for="userId">id</label> <input type="text" placeholder="enter id" id="userId" name="userId" />
    </div>

    <div>
      <label for="userName">user name</label> <input type="text" placeholder="enter name" id="userName" name="userName" />
    </div>

    <div>
      <label for="password">password</label> <input type="password" placeholder="enter password" id="password" name="password" />
    </div>
  </form>
  <button id="signupSubmit" type="submit">submit</button>
</div>
<script>
	$(function() {
		$("#signupSubmit").click(function() {
			const data = {
				userId : $("#userId").val(),
				userName : $("#userName").val(),
				password : $("#password").val(),
			}

			$.ajax({
				type : "POST",
				url : "/api/signup",
				data : JSON.stringify(data),
				contentType : "application/json; charset=utf-8",
				dataType : "json"
			}).done(function(response) {
				console.log("response : ", response);
				location.href = "/";
				alert("회원가입 완료");
			}).fail(function(error) {
				console.log("error : ", error);
				alert("회원가입에 실패");
			});
		})
	})
</script>
<%@ include file="./layout/footer.jsp"%>

