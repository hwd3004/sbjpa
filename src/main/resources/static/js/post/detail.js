$(() => {
  const app = Vue.createApp({});

  const board = {
    data() {
      return {
        board: {
          user: {
            userName: "",
          },
        },
        storages: {},
      };
    },
    mounted() {
      // console.log(location.href);
      // console.log(location.pathname);
      $.ajax({
        url: `/api${location.pathname}`,
        type: "get",

        success: (response) => {
          console.log(response);
          this.board = response.board;
          this.storages = response.storages;
        },
        error: (error) => {
          alert("에러");
          console.log(error);
        },
      });
    },
    template: `
    <div>
      <p>제목 : {{this.board.title}}</p>
      <p>작성자 : {{this.board.user.userName}}</p>
      <p>내용 : {{this.board.content}}</p>
      <p>작성일 : {{this.board.createdAt}}</p>
      <hr />
      <div v-for="(storage, index) in this.storages" v-bind:key="index">
        <input class="storageId" type="text" v-bind:value="storage.id" />
        <p>{{storage.path}}</p>
        <a class="download" href="#">{{storage.filename}}</a>
        <br />
      </div>
    </div>
    `,
    updated() {
      // const download = document.getElementsByTagName("a");
      const download = document.querySelectorAll(".download");

      const storageId = document.querySelectorAll(".storageId");

      for (let index = 0; index < download.length; index++) {
        const id = storageId[index].value;
        const filename = download[index].innerText;
        
        download[index].href = `/download/${id}`;
      }
    },
  };

  app.component("board", board);

  app.mount("#app");
});
