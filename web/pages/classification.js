// pages/classification.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isShowModal:false,
    input:{},
  },

  /**
  * 弹出密码验证窗口
  */
  inputPass:function(){
    this.setData({ isShowModal: true, input: ''})
  },

  /**
   * 取消验证
   */
  cancel:function(){
    this.setData({
      isShowModal:false})
  },

  /**
   * 确认输入
   */
  confirm:function(){
    console.log(this.data.input)
    if(this.data.input==="123456"){
      wx.navigateTo({
        url: './manager/managerClassification',
      })
    }
    else{
      wx.showToast({
        title: '验证码错误',
        mask:true,
        icon:'none',
        duration:2000,
      })
    }
  },

  /**
   * 得到输入内容
   */
  getInput:function(e){
    this.setData({
      input:e.detail.value,
    });
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  },

  toComment:function(){
    wx.navigateTo({
      url: './comment',
    })
  }
})