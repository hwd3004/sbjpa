$(() => {
  console.log("post create.js");

  $("#form").submit(function (e) {
    e.preventDefault();

    const formdata = new FormData(this);

    console.log(formdata);

    $.ajax({
      url: window.location.pathname,
      type: "POST",
      data: formdata,
      cache: false,
      contentType: false,
      processData: false,
      success: (response) => {
        console.log(response);
      },
      error: (error) => {
        alert("에러");
        console.log(error);
      },
    });
  });
});
