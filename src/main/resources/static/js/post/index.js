$(() => {
  const app = Vue.createApp({});

  const boards = {
    data() {
      return {
        boards: [],
        loading: true,
      };
    },
    mounted() {
      //   console.log(location.href);
      //   console.log(location.pathname);
      //   console.log(location.search);

      //   https://developer.mozilla.org/ko/docs/Web/API/URLSearchParams

      const paramString = location.search;

      const searchParams = new URLSearchParams(paramString);

      // for (const iterator of searchParams) {
      //   console.log(iterator);
      // }

      //   console.log("page : ", searchParams.get("page"));

      const page = parseInt(searchParams.get("page")) || 0;

      $.ajax({
        url: `/api/post/index`,
        type: "get",
        data: {
          page,
        },
        success: (response) => {
          console.log(response);
          this.boards = response.boards;

          this.loading = false;
        },
        error: (error) => {
          alert("에러");
          console.log(error);
        },
      });
    },
    template: `
    <div>
      <p v-if="this.loading == true">Loading...</p>
      <table>
        <thead>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
        </thead>
        <tbody>
          <tr v-for="(board, index) in this.boards" v-bind:key="index">
            <td>{{board.id}}</td>
            <td class="boardTitle">{{board.title}}</td>
            <td>{{board.user.userName}}</td>
          </tr>
        </tbody>
      </table>
    </div>
    `,
    updated() {
      const boardTItle = document.querySelectorAll(".boardTitle");

      for (let index = 0; index < boardTItle.length; index++) {
        boardTItle[index].addEventListener("click", function (e) {
          // console.log(this.parentNode.children[0].innerText)

          const id = this.parentNode.children[0].innerText;

          location.href = `/post/${id}`;
        });
      }
    },
  };

  app.component("boards", boards);

  app.mount("#app");
});
