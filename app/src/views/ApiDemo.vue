<template>
  <div>
    <CCard>
      <CCardHeader>
        <CButton v-on:click="execute" color="light" title="Hello">Execute</CButton>
      </CCardHeader>
      <CCardBody>
        <p
          class="text-left text-monospace"
          style="white-space: pre;"
        >{{ JSON.stringify(response, undefined, 2) }}</p>
      </CCardBody>
    </CCard>
  </div>
</template>

<script>
/* eslint-disable max-len,no-return-assign */
import axios from 'axios';
import config from '@/config';

export default {
  name: 'ApiDemo',
  data() {
    return {
      response: {},
    };
  },
  methods: {
    async execute() {
      this.response = {};
      // axios.defaults.headers.common.Authorization = `Bearer ${await this.$auth.getAccessToken()}`;

      axios
        .get(config.api.uri, {
          headers: {
            Authorization: `Bearer ${await this.$auth.getAccessToken()}`,
          },
        })
        .then((response) => (this.response = response))
        .catch((err) => (this.response = err));
    },
  },
};
</script>
