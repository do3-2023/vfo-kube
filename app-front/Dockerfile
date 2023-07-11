FROM node:19-alpine
WORKDIR /home
COPY . .
RUN npm ci

LABEL org.opencontainers.image.source="https://github.com/do3-2023/vfo-kube"

RUN npm run build
ENV NODE_ENV production
EXPOSE 4173
CMD [ "npm", "run", "serve" ]