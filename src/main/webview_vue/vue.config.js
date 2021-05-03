module.exports = {
  lintOnSave : true,
  css : {
    sourceMap : true
  },
  devServer : {
    proxy:{
      "/api":{
        target:"http://localhost:8081",
        changerOrigin: true,
        secure:false,
        pathRewrite:{
          '^/api/':''
        }
      }
    }
  },
  assetsDir:"./assets/",
  outputDir:"../../main/resources/static/",
  transpileDependencies : ['vuetify']
}
