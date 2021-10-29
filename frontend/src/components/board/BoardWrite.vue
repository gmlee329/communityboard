<template>
  <v-container>
    <v-card elevation="10" outlined width="100%" class="mx-auto">
      <v-card-title>
        <span class="mr-2">글쓰기</span>
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
          @click="save"
          color="success"
          rounded
          small
          iconName="mdi-content-save-all"
          btnName="저장"
        ></Button>
        <Button
          @click="movePage('/board')"
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
import { postBoardAPI } from '@/api/index';

export default {
  components: {
    Editor,
  },
  data: () => ({
    rules: [
      (value) => !!value || 'Required.',
      (value) => (value && value.length >= 3) || 'Min 3 characters',
    ],
    title: '',
  }),
  methods: {
    async save() {
      const content = this.$refs.editor.getContent();
      const { title } = this;
      const res = await this.confirmDialog(
        '글 저장',
        '저장 하시겠습니까?',
      );
      if (res) {
        postBoardAPI({
          title,
          content,
        })
          .then((response) => {
            if (response.data > 0) {
              this.$store.commit('setSnackbar', {
                show: true,
                msg: '저장 완료',
                color: 'success',
              });
              this.movePage(`/board/${response.data}`);
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
