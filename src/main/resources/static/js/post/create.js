$(() => {
	$("form").submit(function(e) {
		e.preventDefault();

		const formdata = new FormData(this);

		$.ajax({
			url: `/api${window.location.pathname}`,
			type: "POST",
			data: formdata,
			cache: false,
			contentType: false,
			processData: false,
			success: (res) => {
				console.log(res);
				if (res.status == 200) {
					//location.href = "/";
				} else {
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
