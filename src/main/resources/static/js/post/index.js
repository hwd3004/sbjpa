$(() => {
  //   console.log(location.href);
  //   console.log(location.pathname);
  //   console.log(location.search);

  //   https://developer.mozilla.org/ko/docs/Web/API/URLSearchParams

  const paramString = location.search;

  const searchParams = new URLSearchParams(paramString);

  for (const iterator of searchParams) {
    console.log(iterator);
  }

  //   console.log("page : ", searchParams.get("page"));

  const page = parseInt(searchParams.get("page")) || 0;

  $.ajax({
    url: `api/post/index`,
    type: "get",
    data: {
      page,
    },
    success: (response) => {
      console.log(response);
    },
    error: (error) => {
      alert("에러");
      console.log(error);
    },
  });
});
