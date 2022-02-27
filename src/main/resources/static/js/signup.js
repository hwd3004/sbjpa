$(function () {
  $("#form").submit(function (e) {
    e.preventDefault();

    const formdata = new FormData(this);

    console.log(formdata);

    $.ajax({
      type: "POST",
      url: "/api/signup",
      data: formdata,
      cache: false,
      contentType: false,
      processData: false,
    })
      .done(function (response) {
        console.log("response : ", response);
        location.href = "/";
        alert("회원가입 완료");
      })
      .fail(function (error) {
        console.log("error : ", error);
        alert("회원가입에 실패");
      });
  });

  //   $("#signupSubmit").click(function (e) {
  //     e.preventDefault();

  //     const data = {
  //       userId: $("#userId").val(),
  //       userName: $("#userName").val(),
  //       password: $("#password").val(),
  //     };

  //     $.ajax({
  //       type: "POST",
  //       url: "/api/signup",
  //       data: JSON.stringify(data),
  //       contentType: "application/json; charset=utf-8",
  //       dataType: "json",
  //     })
  //       .done(function (response) {
  //         console.log("response : ", response);
  //         location.href = "/";
  //         alert("회원가입 완료");
  //       })
  //       .fail(function (error) {
  //         console.log("error : ", error);
  //         alert("회원가입에 실패");
  //       });
  //   });
});
