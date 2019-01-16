// pages/comment.js
const app = getApp();
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

    //被评价人信息
    name:'',
    dept:'',
    count:0,

    //是否前台部门
    isFront:true,
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
    this.setData({
      isFront:options.isFront
    })
    this.updateData();
  },


  updateData:function(){

    //最后一个
    if(this.data.count>=31){
      wx.redirectTo({
        url: './final',
      })
    }
    else{
      let countTemp = this.data.count;
      this.setData({ count: countTemp + 1 })

      let _this = this;
      wx.request({
        url: app.globalData.serverUrl + 'emp/' + this.data.count,
        method: 'GET',
        success: function (res) {
          _this.setData({
            name: res.data.data.name,
            dept: res.data.data.dept,
            //init
            total: 0,
            value1: 1,
            value2: 1,
            value3: 1,
            value4: 1,
            value5: 1,
          })
        }
      })
    }

    
  },

  /**
   * 点击按钮得到下一个被评价者信息
   */
  nextEmp:function(){
    let str='';
    let _this=this;
    if(this.data.isFront==='true'){
      str='addFrontMark';
    }
    else{
      str='addBackMark';
    }

    let result={
      mark: _this.data.total
    };

    console.log(result);
  
    //post data
    wx.request({
      url: app.globalData.serverUrl + 'emp/' + this.data.count+'/'+str+'/'+_this.data.total,
      method:'POST',
      data:{},
      header:{
        'content-type': 'application/x-www-form-urlencoded'
      },
      success:function(){
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