//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    isFinish:false,
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse){
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true,
      isLogin:true
    })
  },


  /**
   * 点击开始
   */
  toStart:function(){
    this.judge();
    if(this.data.hasUserInfo){
      this.addCommentPerson(this.data.userInfo.nickName);
    }
   
    wx.navigateTo({
      url: '../classification',
    })
  },


  /**
   * 记录已评价人的微信名称
   */
  addCommentPerson:function(name){
    wx.request({
      url: 'http://154.8.162.147:8080/addPerson/'+name,
      method:POST,
      data: {},
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
    })
  },


  /**
   * 判断该用户是否进行评价
   */
  judge:function(name){
    let _this=this;
    wx.request({
      url: 'http://154.8.162.147:8080/judge/' + name,
      method:GET,
      success:function(){
        _this.setData({hasUserInfo:false})
      }
    })
  }
})
