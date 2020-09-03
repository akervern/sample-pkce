<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Homy</router-link>
      | <router-link to="/about">Aboul</router-link>
      | <router-link to="/api">API</router-link>
    </div>
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'app',
  data() {
    return {
      authenticated: false,
    };
  },
  created() {
    this.isAuthenticated();
  },
  watch: {
    // Everytime the route changes, check for auth status
    $route: 'isAuthenticated',
  },
  methods: {
    async isAuthenticated() {
      this.authenticated = await this.$auth.isAuthenticated();
    },
    async logout() {
      await this.$auth.logout();
      await this.isAuthenticated();

      // Navigate back to home
      this.$router.push({ path: '/' });
    },
  },
};
</script>

<style lang="scss">
// Import Main styles for this application
@import "assets/scss/style";

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
