$(() => {
	const form = document.querySelector("form");

	form.addEventListener("submit", function(e) {
		e.preventDefault();

		const formdata = new FormData(this);

		$.ajax({
			type: "POST",
			url: "/api/signup",
			data: formdata,
			cache: false,
			contentType: false,
			processData: false,
		})
			.done(function(res) {
				console.log("res : ", res);

				if (res.status == 200) {
					location.href = "/";
				}

				alert(res.data);
			})
			.fail(function(error) {
				console.log("error : ", error);
				alert(error);
			});

	});
});
