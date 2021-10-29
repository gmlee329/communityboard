import axios from 'axios';

const http = axios.create({
  baseURL: 'http://13.209.77.8',
});

function getBoardListAPI(params) {
  return http.get('/boards', params);
}

function getBoardByIdAPI(docNo) {
  return http.get(`/boards/${docNo}`);
}

function postBoardAPI(body) {
  return http.post('/boards', body);
}

function patchBoardAPI(docNo, body) {
  return http.patch(`/boards/${docNo}`, body);
}

function deleteBoardAPI(docNo) {
  return http.delete(`/boards/${docNo}`);
}

function getReplyListAPI(docNo) {
  return http.get(`/boards/${docNo}/replies`);
}

function postReplyAPI(docNo, body) {
  return http.post(`/boards/${docNo}/replies`, body);
}

function patchReplyAPI(docNo, replyNo, body) {
  return http.patch(`/boards/${docNo}/replies/${replyNo}`, body);
}

function deleteReplyAPI(docNo, replyNo) {
  return http.delete(`/boards/${docNo}/replies/${replyNo}`);
}

export {
  getBoardListAPI,
  getBoardByIdAPI,
  postBoardAPI,
  patchBoardAPI,
  deleteBoardAPI,
  getReplyListAPI,
  postReplyAPI,
  patchReplyAPI,
  deleteReplyAPI,
};
