// pages/comment.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    total:0,
    value1:1,
    value2:1,
    value3:1,
    value4:1,
    value5:1,
  },

  changeSlider1:function(e){
    this.data.value1=e.detail.value;
    this.calTotal();
  },

  changeSlider2: function (e) {
    this.data.value2 = e.detail.value;
    this.calTotal();
  },

  changeSlider3: function (e) {
    this.data.value3 = e.detail.value;
    this.calTotal();
  },

  changeSlider4: function (e) {
    this.data.value4 = e.detail.value;
    this.calTotal();
  },

  changeSlider5: function (e) {
    this.data.value5 = e.detail.value;
    this.calTotal();
  },

  calTotal:function(){
    let totalTemp = this.data.value1 + this.data.value2 + this.data.value3 + this.data.value4 + this.data.value5;
    this.setData({total:totalTemp});
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
  
  }
})