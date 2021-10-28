<template>
  <v-btn class="white--text" v-on="$listeners" v-bind="$attrs">
    <v-icon small>
      {{ iconName }}
    </v-icon>
    <span style="width: 5px" v-if="btnName"></span>
    {{ btnName }}
  </v-btn>
</template>

<script>

export default {
  props: {
    iconName: String,
    btnName: String,
  },
};
</script>

<style></style>
