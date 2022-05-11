<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./layout/header.jsp"%>

<div>
	<h1>log in</h1>
	<div>
		<form method="post">
			<div>
				<label for="userId">id</label> <input type="text" placeholder="enter id" id="userId" name="userId" />
			</div>
			<div>
				<label for="password">password</label> <input type="password" placeholder="enter password" id="password" name="password" />
			</div>

			<button type="submit">submit</button>
		</form>
	</div>
</div>

<script src="/js/login.js"></script>
<%@ include file="./layout/footer.jsp"%>
