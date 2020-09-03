# Build Stage
FROM node:12-alpine as build-stage
WORKDIR /app
COPY package*.json ./
RUN yarn install

# XXX To see how we can run webdriverio tests here.
# See: https://hub.docker.com/r/selenium/standalone-chrome/
COPY . .
RUN yarn build:prod

# Production St
FROM nginx:stable-alpine as production-stage
COPY docker/nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=build-stage /app/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
