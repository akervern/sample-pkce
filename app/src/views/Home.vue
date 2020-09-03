<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png" />
    <HelloWorld msg="Welcome to Your Vue.js App" />

    <CCard color="primary" text-color="white" class="text-center py-5 d-md-down-none" body-wrapper>
      <CCardBody>
        <h2>Sign up</h2>
        <p>
          Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
          incididunt ut labore et dolore magna aliqua.
        </p>
        <CButton color="light" variant="outline" size="lg">Register Now!</CButton>
      </CCardBody>
    </CCard>
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
};
</script>
