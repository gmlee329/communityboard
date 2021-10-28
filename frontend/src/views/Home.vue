<template>
  <div>
    <v-container>
      <v-card class="mx-auto" max-width="660" tile>
        <v-card-title>
          Vue + Spring Boot + MariaDB
        </v-card-title>
        <v-card-text>
          <hr />
          <br />
          <h2>Architecture</h2>
        </v-card-text>
        <v-img height="100%" src="../assets/architecture.png" />
        <v-card-text>
          <hr />
          <br />
          <h2>개발 환경</h2>
          <br />
          <h3>Vue (Client)</h3>
          <ul>
            <li>Vue</li>
            <li>Vuetify</li>
            <li>Vuex</li>
            <li>Vue-Router</li>
            <li>Axios</li>
          </ul>
          <br />
          <h3>Spring Boot (Server)</h3>
          <ul>
            <li>SpringBoot</li>
            <li>MyBatis</li>
          </ul>
          <br />
          <h3>MariaDB (Database)</h3>
          <ul>
            <li>AWS RDS</li>
          </ul>
        </v-card-text>
      </v-card>
    </v-container>
  </div>
</template>

<script>
export default {
  name: 'Home',
  components: {},
};
</script>

<style scoped>
div {
  text-decoration: none;
}
</style>
