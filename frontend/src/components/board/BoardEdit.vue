<template>
  <v-container>
    <v-card elevation="10" outlined width="100%" class="mx-auto">
      <v-card-title>
        <span class="mr-2">글 수정</span>
      </v-card-title>
      <v-card-text>
        <v-text-field
          label="제목"
          :rules="rules"
          :counter="100"
          v-model="title"
        ></v-text-field>
        <Editor ref="editor" />
      </v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>
        <Button
          @click="edit"
          color="warning"
          rounded
          small
          iconName="mdi-pencil"
          btnName="수정"
        ></Button>
        <Button
          @click="prevPage()"
          color="grey darken-1"
          rounded
          small
          iconName="mdi-arrow-left"
          btnName="이전"
        ></Button>
      </v-card-actions>
    </v-card>
  </v-container>
</template>

<script>
import Editor from '@/components/common/Editor.vue';
import { getBoardByIdAPI, patchBoardAPI } from '@/api/index';

export default {
  components: {
    Editor,
  },
  data: () => ({
    rules: [
      (value) => !!value || 'Required.',
      (value) => (value && value.length >= 3) || 'Min 3 characters',
    ],
    docNo: '',
    title: '',
    writer: '',
  }),
  mounted() {
    getBoardByIdAPI(this.$route.params.docNo)
      .then((response) => {
        this.docNo = response.data.docNo;
        this.title = response.data.title;
        this.$refs.editor.setContent(response.data.content);
        // this.writer = response.data.writer
      })
      .catch((error) => {
        console.log(error);
      });
  },
  methods: {
    async edit() {
      const { docNo } = this;
      const { title } = this;
      const content = this.$refs.editor.getContent();
      const res = await this.confirmDialog(
        '글 수정',
        '수정 하시겠습니까?',
      );
      if (res) {
        patchBoardAPI(docNo,
          {
            title,
            content,
          })
          .then((response) => {
            if (response.data > 0) {
              this.$store.commit('SET_SNACKBAR', {
                show: true,
                msg: 'Edit Complete',
                color: 'warning',
              });
              this.movePage(`/board/${docNo}`);
            }
          })
          .catch((error) => {
            console.log(error);
          });
      }
    },
  },
};
</script>

<style></style>
