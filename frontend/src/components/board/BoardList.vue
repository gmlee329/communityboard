<template>
  <v-container>
    <v-card elevation="10" outlined width="100%" class="mx-auto">
      <v-card-title>
        게시판
      </v-card-title>
      <v-card-text>
        <v-row>
          <v-col align-self="end" cols="12" md="2">
            <v-select
              v-model="schType"
              label="검색조건"
              :items="conditions"
            ></v-select>
          </v-col>
          <v-col cols="12" md="8">
            <v-text-field
              v-model="schVal"
              label="검색어"
              single-line
              @keypress.enter.prevent="getBoardList"
            ></v-text-field>
          </v-col>
          <v-col align-self="center">
            <Button
              @click="getBoardList"
              color="blue-grey darken-1"
              rounded
              small
              block
              iconName="mdi-magnify"
              btnName="검색"
            ></Button>
          </v-col>
        </v-row>
        <v-row>
          <v-col>
            <v-data-table
              class="elevation-1"
              @click:row="onClickRow"
              :headers="headers"
              :items="document"
              :options.sync="options"
              :server-items-length="totalCount"
              :footer-props="footerOptions"
              :loading="loading"
            >
              <template slot="items" slot-scope="props">
                <td>{{ props.item.docNo }}</td>
                <td>{{ props.item.title }}</td>
                <td>{{ props.item.writer }}</td>
                <td>{{ props.item.regDttm }}</td>
                <td>{{ props.item.viewCount }}</td>
                <td>{{ props.item.replyCount }}</td>
              </template>
            </v-data-table>
          </v-col>
        </v-row>
      </v-card-text>
      <v-card-text align="right">
        <Button
          @click="movePage('/board/write')"
          color="green"
          rounded
          small
          iconName="mdi-pencil"
          btnName="글쓰기"
        ></Button>
      </v-card-text>
    </v-card>
  </v-container>
</template>

<script>
import { mapState, mapMutations } from 'vuex';
import { getBoardListAPI } from '@/api/index';

export default {
  data() {
    return {
      headers: [
        { text: '글 번호', align: 'center', value: 'docNo' },
        { text: '제목', align: 'start', value: 'title' },
        { text: '작성자', align: 'center', value: 'writer' },
        { text: '작성일시', align: 'center', value: 'regDttm' },
        { text: '조회수', align: 'center', value: 'viewCount' },
        { text: '댓글수', align: 'center', value: 'replyCount' },
      ],
      document: [],
      options: {
        multiSort: true,
        sortBy: [],
        sortDesc: [],
        page: 1,
        itemsPerPage: 5,
      },
      footerOptions: {
        'items-per-page-options': [5, 10, 20, 30, 50],
      },
      totalCount: 0,
      loading: false,
      conditions: [
        { text: '글 번호', value: 'docNo' },
        { text: '제목', value: 'title' },
        { text: '작성자', value: 'writer' },
      ],
      schType: '',
      schVal: '',
    };
  },
  mounted() {
    this.getBoardList();
  },
  watch: {
    options: {
      handler() {
        this.getBoardList();
      },
      deep: true,
    },
  },
  methods: {
    getBoardDataFromAPI(page, itemsPerPage, sort) {
      return getBoardListAPI({
        params: {
          schType: this.schType,
          schVal: this.schVal,
          page,
          rows: itemsPerPage,
          sort: encodeURIComponent(sort),
        },
      })
        .then((response) => response.data)
        .catch((error) => {
          console.log(error);
        });
    },
    getBoardList() {
      if (this.$store.state.blo.isFromDetail) {
        this.options = this.$store.state.blo.options;
        this.schType = this.$store.state.blo.schType;
        this.schVal = this.$store.state.blo.schVal;
      }
      const vm = this;
      this.loading = true;
      // eslint-disable-next-line
      return new Promise((resolve, reject) => {
        const {
          sortBy, sortDesc, page, itemsPerPage,
        } = this.options;
        const sort = [];
        if (sortBy.length > 0) {
          // eslint-disable-next-line
          sortBy.forEach((value, index) => {
            sort.push(
              `${value
                .replace(/[A-Z]/g, (str) => `_${str[0]}`)
                .toUpperCase()
              } ${
                sortDesc[index] ? 'desc' : 'asc'}`,
            );
          });
        } else {
          sort.push('DOC_NO desc');
        }
        this.getBoardDataFromAPI(page, itemsPerPage, sort).then(
          (response) => {
            const items = response.data;
            const { total } = response;
            vm.loading = false;
            this.document = items;
            this.totalCount = total;
          },
        );
        this.$store.state.blo.isFromDetail = false;
      });
    },
    onClickRow(event, data) {
      this.$store.state.blo.options = this.options;
      this.$store.state.blo.schType = this.schType;
      this.$store.state.blo.schVal = this.schVal;
      this.$store.state.blo.isFromDetail = true;
      const newBlo = this.blo;
      this.setBoardListOptions(newBlo);
      this.movePage(`/board/${data.item.docNo}`);
    },
    ...mapMutations({
      setBoardListOptions: 'setBoardListOptions',
    }),
  },
  computed: {
    ...mapState([
      'blo',
    ]),
  },
};
</script>
