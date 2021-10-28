<template>
  <v-app-bar app color="blue-grey darken-1" dark>
    <v-card-title>
      <v-btn @click="movePage('/home')" text>
        <span class="main">Community</span>
      </v-btn>
    </v-card-title>
    <v-divider class="mx-4" inset vertical></v-divider>
    <v-btn @click="movePage('/home')" text>
      <span class="mr-2">Intro</span>
    </v-btn>
    <v-divider class="mx-4" inset vertical></v-divider>
    <v-btn @click="movePage('/board')" text>
      <span class="mr-2">Board</span>
    </v-btn>
    <v-divider class="mx-4" inset vertical></v-divider>
  </v-app-bar>
</template>

<script>

export default {
  name: 'AppHeader',
  components: {
  },
};
</script>
<style scoped>
.main {
  font-size: 1.3rem;
}
</style>
