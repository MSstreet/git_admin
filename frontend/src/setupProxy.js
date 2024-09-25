const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function (app) {
    app.use(
        '/api',  // 프록시로 전달할 API 엔드포인트를 지정합니다.
        createProxyMiddleware({
            target: 'http://localhost:8082',  // API 서버의 기본 URL을 지정합니다.
            changeOrigin: true,
        })
    );
};