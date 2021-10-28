<template>
  <v-app>
    <v-app-bar app>
      <AppHeader></AppHeader>
    </v-app-bar>

    <v-main>
      <router-view></router-view>
    </v-main>
    <Snackbar></Snackbar>
  </v-app>
</template>

<script>
import AppHeader from '@/components/common/AppHeader.vue';
import Snackbar from '@/components/common/Snackbar.vue';

export default {
  name: 'App',
  components: {
    AppHeader,
    Snackbar,
  },
  data: () => ({
    //
  }),
};
</script>
