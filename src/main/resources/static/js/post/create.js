$(() => {
	// document.getElementById("form").addEventListener("submit", function (event) {
	//   event.preventDefault();
	// });

	$("#form").submit(function(e) {
		e.preventDefault();

		const formdata = new FormData(this);

		console.log(formdata);

		$.ajax({
			url: `/api${window.location.pathname}`,
			type: "POST",
			data: formdata,
			cache: false,
			contentType: false,
			processData: false,
			success: (response) => {
				console.log(response);
				if (response.data == 1) {
					location.href = "/";
				}

				if (response.data == -1) {
					alert("로그인이 필요합니다.");
				}
			},
			error: (error) => {
				alert("에러");
				console.log(error);
			},
		});
	});
});
