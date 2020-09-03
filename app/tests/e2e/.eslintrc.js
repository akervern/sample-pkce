module.exports = {
  plugins: ['wdio'],
  extends: 'plugin:wdio/recommended',
  env: {
    mocha: true,
    browser: true,
  },
  rules: {
    strict: 'off',
    'class-methods-use-this': 'off'
  },
};
