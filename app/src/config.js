export default {
  okta: {
    clientId: process.env.VUE_APP_OKTA_CLIENT_ID,
    issuer: process.env.VUE_APP_OKTA_ISSUER,
    redirectUri: `${window.location.origin}/implicit/callback`,
    scopes: ['openid', 'profile', 'email'],
  },
  api: {
    uri: `${process.env.VUE_APP_API_SERVER}/api`,
  },
};
