<template>
  <div>
    <Editor
      ref="toastEditor"
      initialEditType="wysiwyg"
      height="500px"
      previewStyle="vertical"
    />
  </div>
</template>

<script>
import { Editor } from '@toast-ui/vue-editor';
// eslint-disable-next-line import/no-extraneous-dependencies
import 'codemirror/lib/codemirror.css';
// eslint-disable-next-line import/no-extraneous-dependencies
import '@toast-ui/editor/dist/toastui-editor.css';

export default {
  components: {
    Editor,
  },
  methods: {
    getContent() {
      return this.$refs.toastEditor.invoke('getMarkdown');
    },
    setContent(content) {
      this.$refs.toastEditor.invoke('setMarkdown', content);
    },
  },
};
</script>
