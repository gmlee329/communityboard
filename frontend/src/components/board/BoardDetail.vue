<template>
  <v-container>
    <v-card elevation="10" outlined width="100%" class="mx-auto">
      <v-card-title>
        <span class="mr-2">글 상세보기</span>
      </v-card-title>
      <v-card-text>
        <v-row>
          <v-col>
            <v-text-field label="제목" readonly :value="title" />
          </v-col>
        </v-row>
        <v-row>
          <v-col>
            <v-text-field label="작성자" readonly dense :value="writer" />
          </v-col>
          <v-col>
            <v-text-field
              label="등록일"
              readonly
              dense
              :value="regDttm"
            />
          </v-col>
          <v-col>
            <v-text-field label="조회수" readonly dense :value="viewCount" />
          </v-col>
        </v-row>
        내용<br />
        <div style="height:300px;"><Viewer ref="viewer" /><br /></div>
        댓글 ({{ replyCount }})<br />
        <v-simple-table dense>
          <tbody>
          <tr v-for="(reply, index) in replies" :key="index">
            <td style="width:110px; padding: 0;">
              <v-icon small>
                mdi-account
              </v-icon>
              {{ reply.writer }}
            </td>
            <td style="padding: 0;">{{ reply.comment }}</td>
            <td style="width:140px; padding: 0;">
              {{ reply.regDttm }}
            </td>
            <td style="width:30px; padding: 0;">
              <Button
                @click="replyEdit(reply.replyNo, reply.comment)"
                color="grey"
                icon
                x-small
                iconName="mdi-pencil"
              />
            </td>
            <td style="width:30px; padding: 0;">
              <Button
                @click="replyDel(reply.replyNo)"
                color="red"
                icon
                x-small
                iconName="mdi-close"
              />
            </td>
          </tr>
          </tbody>
        </v-simple-table>
        <v-divider></v-divider>
        <v-row>
          <v-col cols="12" md="11" style="padding: 0px 12px;">
            <v-textarea
              clearable
              clear-icon="mdi-close-circle"
              rows="2"
              no-resize
              full-width
              v-model="comment"
            ></v-textarea>
          </v-col>
          <v-col md="1" align-self="center" style="padding: 0px 10px;">
            <Button
              @click="replySave"
              color="indigo"
              rounded
              small
              iconName="mdi-pencil"
              btnName="등록"
            ></Button>
          </v-col>
        </v-row>
      </v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>
        <Button
          @click="movePage(`/board/${docNo}/edit`)"
          color="warning"
          rounded
          small
          iconName="mdi-pencil"
          btnName="편집"
        ></Button>
        <Button
          @click="deleteBoard"
          color="error"
          rounded
          small
          iconName="mdi-delete-forever"
          btnName="삭제"
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
import Viewer from '@/components/common/Viewer.vue';
import {
  getBoardByIdAPI,
  deleteBoardAPI,
  getReplyListAPI,
  postReplyAPI,
  patchReplyAPI,
  deleteReplyAPI,
} from '@/api/index';

export default {
  components: {
    Viewer,
  },
  data() {
    return {
      docNo: 0,
      title: '',
      writer: '',
      regDttm: '',
      viewCount: 0,
      replyCount: 0,
      replies: null,
      comment: '',
    };
  },
  mounted() {
    getBoardByIdAPI(this.$route.params.docNo)
      .then((response) => {
        this.docNo = response.data.docNo;
        this.title = response.data.title;
        this.$refs.viewer.setContent(response.data.content);
        this.writer = response.data.writer;
        this.regDttm = response.data.regDttm;
        this.viewCount = response.data.viewCount;
        this.replyCount = response.data.replyCount;
      })
      .catch((error) => {
        console.log(error);
      });
    getReplyListAPI(this.$route.params.docNo)
      .then((response) => {
        this.replies = response.data;
      })
      .catch((error) => {
        console.log(error);
      });
  },
  methods: {
    async deleteBoard() {
      const res = await this.confirmDialog(
        '글 삭제',
        '삭제 하시겠습니까?',
      );
      if (res) {
        deleteBoardAPI(this.docNo)
          .then((response) => {
            if (response.data > 0) {
              this.$store.commit('SET_SNACKBAR', {
                show: true,
                msg: 'Delete Complete',
                color: 'error',
              });
              this.movePage('/board');
            }
          })
          .catch((error) => {
            console.log(error);
          });
      }
    },
    replySave() {
      if (this.comment !== null && this.comment.trim() !== null) {
        postReplyAPI(this.docNo,
          {
            comment: this.comment,
          })
          .then((response) => {
            if (response.data > 0) {
              this.refresh();
            }
          })
          .catch((error) => {
            console.log(error);
          });
      }
    },
    async replyEdit(replyNo, comment) {
      const res = await this.promptDialog('댓글 수정', '내용', comment);
      if (res) {
        patchReplyAPI(this.docNo, replyNo,
          {
            comment: res,
          })
          .then((response) => {
            if (response.data > 0) {
              this.refresh();
            }
          })
          .catch((error) => {
            console.log(error);
          });
      }
    },
    async replyDel(replyNo) {
      const res = await this.confirmDialog(
        '댓글 삭제',
        '삭제 하시겠습니까?',
      );
      if (res) {
        deleteReplyAPI(this.docNo, replyNo)
          .then((response) => {
            if (response.data > 0) {
              this.refresh();
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
