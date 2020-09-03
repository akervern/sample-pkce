<template>
  <div class="about">
    <h1>This is an about page</h1>
    <CCard>
      <table class="ui table">
        <thead>
          <tr>
            <th>Claim</th>
            <th>Value</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(claim, index) in claims" :key="index">
            <td>{{claim.claim}}</td>
            <td :id="'claim-' + claim.claim">{{claim.value}}</td>
          </tr>
        </tbody>
      </table>
    </CCard>
  </div>
</template>

<script>
export default {
  name: 'About',
  data() {
    return {
      claims: [],
    };
  },
  async created() {
    this.claims = await Object.entries(
      await this.$auth.getUser(),
    ).map((entry) => ({ claim: entry[0], value: entry[1] }));
  },
};
</script>
