<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js app" :test="test" />
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue';

export default {
  name: 'Home',
  components: {
    HelloWorld,
  },
  data() {
    return {
      test: '',
    };
  },
  created() {
    this.axios.get('/test')
      .then(
        (res) => {
          this.test = res.data.test;
        },
      )
      .catch(
        (error) => {
          console.log(error);
        },
      );
  },
};
</script>
