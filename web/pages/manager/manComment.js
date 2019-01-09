// pages/manager/manComment.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    total: 0,
    value1: 1,
    value2: 1,
    value3: 1,
    value4: 1,
    value5: 1,
    value6: 1,
    value7: 1,
    value8: 1,
    value9: 1,
    value10: 1,

    //被评价部门信息
    name:'',
    managerName:'',
    isAd:true,
    count:0,
  },

  changeSlider1: function (e) {
    this.data.value1 = e.detail.value;
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

  changeSlider6: function (e) {
    this.data.value6 = e.detail.value;
    this.calTotal();
  },

  changeSlider7: function (e) {
    this.data.value7 = e.detail.value;
    this.calTotal();
  },

  changeSlider8: function (e) {
    this.data.value8 = e.detail.value;
    this.calTotal();
  },

  changeSlider9: function (e) {
    this.data.value9 = e.detail.value;
    this.calTotal();
  },

  changeSlider10: function (e) {
    this.data.value10 = e.detail.value;
    this.calTotal();
  },

  calTotal: function () {
    let totalTemp = this.data.value1 + this.data.value2 + this.data.value3 + this.data.value4 + this.data.value5 + this.data.value6 + this.data.value7 + this.data.value8 + this.data.value9 + this.data.value10;

    this.setData({ 
      total: totalTemp,
     });
  },



  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({isAd:options.isAd})
    this.updateData();
  },


  /**
   * 更新当前页面数据
   */
  updateData:function(){
    //最后一个
    if (this.data.count >= 14) {
      wx.navigateTo({
        url: '../final',
      })
    }
    else {
      let countTemp = this.data.count;
      this.setData({ count: countTemp + 1 })

      let _this = this;
      wx.request({
        url: 'http://118.126.89.104:8080/dept/' + this.data.count,
        method: 'GET',
        success: function (res) {
          _this.setData({
            name: res.data.data.name,
            managerName: res.data.data.managerName,
            //init
            total: 0,
            value1: 1,
            value2: 1,
            value3: 1,
            value4: 1,
            value5: 1,
            value6: 1,
            value7: 1,
            value8: 1,
            value9: 1,
            value10: 1,
          })
        }
      })
    }

  },



  nextDept:function(){
    console.log(this.data.isAd);
    let str = '';
    let _this = this;
    if (this.data.isAd === 'true') {
      str = 'addAdMark';
    }
    else {
      str = 'addNotAdMark';
    }

    console.log(str);

    //post data
    wx.request({
      url: 'http://118.126.89.104:8080/dept/' + this.data.count + '/' + str + '/' + _this.data.total,
      method: 'POST',
      data: {},
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success: function () {
        _this.updateData();
      }
    })
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