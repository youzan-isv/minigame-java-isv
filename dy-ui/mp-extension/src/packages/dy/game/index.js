import request from 'src/third-utils/request.js';

Page({
  data: {
    carWidth: '', //卡片宽度
    number: 999, // 每日翻盘次数
    gameName : "",//游戏名称
    cardData: [{
      animationData: {},
      front: 'https://img01.yzcdn.cn/upload_files/2021/05/16/FnkF6onXKVqzNcPxu3uxDZit37J0.png',
      back: 'https://img01.yzcdn.cn/upload_files/2021/05/16/FsskgmSZi5Z3By8fHnB7sgWIEGi5.png',
      id: '1',
      showClass: false,  // 控制翻转
      opacity: false, // 控制翻转过来以后的 opacity
      point: 10,
      disabled: false,  // disabled 属性，控制手速点击过快，导致多个牌被翻开, 默认为false 可以点击
    },
    {
      animationData: {},
      front: 'https://img01.yzcdn.cn/upload_files/2021/05/16/FnkF6onXKVqzNcPxu3uxDZit37J0.png',
      back: 'https://img01.yzcdn.cn/upload_files/2021/05/16/FghuI6HCePJD3IErdKEDLiLxeYTC.png',
      id: '2',
      showClass: false,
      opacity: false,
      point: 20,
      disabled: false,
    },
    {
      animationData: {},
      front: 'https://img01.yzcdn.cn/upload_files/2021/05/16/FnkF6onXKVqzNcPxu3uxDZit37J0.png',
      back: 'https://img01.yzcdn.cn/upload_files/2021/05/16/FpZPnhWS2NYwJ_Uwr3QJzkdd3KxW.png',
      id: '3',
      showClass: false,
      opacity: false,
      point: 30,
      disabled: false,
    },
    {
      animationData: {},
      front: 'https://img01.yzcdn.cn/upload_files/2021/05/16/FnkF6onXKVqzNcPxu3uxDZit37J0.png',
      back: 'https://img01.yzcdn.cn/upload_files/2021/05/16/Fgm_U7OgTwd0sQ5092i83SQUfCKi.png',
      id: '4',
      showClass: false,
      opacity: false,
      point: 40,
      disabled: false,
    },
    {
      animationData: {},
      front: 'https://img01.yzcdn.cn/upload_files/2021/05/16/FnkF6onXKVqzNcPxu3uxDZit37J0.png',
      back: 'https://img01.yzcdn.cn/upload_files/2021/05/16/FvOYIJecKjCPYD9csDraJVoAiwk8.png',
      id: '5',
      showClass: false,
      opacity: false,
      point: 50,
      disabled: false,
    },
    {
      animationData: {},
      front: 'https://img01.yzcdn.cn/upload_files/2021/05/16/FnkF6onXKVqzNcPxu3uxDZit37J0.png',
      back: 'https://img01.yzcdn.cn/upload_files/2021/05/16/FsITSViKwx2Gu6Uj5uAGcdz0_peO.png',
      id: '6',
      showClass: false,
      opacity: false,
      point: 60,
      disabled: false,
    },
    {
      animationData: {},
      front: 'https://img01.yzcdn.cn/upload_files/2021/05/16/FnkF6onXKVqzNcPxu3uxDZit37J0.png',
      back: 'https://img01.yzcdn.cn/upload_files/2021/05/16/FmBAnKQBOGg_Owck-Z1Bhkky3yq5.png',
      id: '7',
      showClass: false,
      opacity: false,
      point: 70,
      disabled: false,
    },
    {
      animationData: {},
      front: 'https://img01.yzcdn.cn/upload_files/2021/05/16/FnkF6onXKVqzNcPxu3uxDZit37J0.png',
      back: 'https://img01.yzcdn.cn/upload_files/2021/05/16/FimQk70hAVM-XiLJ69HWyoetWutB.png',
      id: '8',
      showClass: false,
      opacity: false,
      point: 80,
      disabled: false,
    },
    {
      animationData: {},
      front: 'https://img01.yzcdn.cn/upload_files/2021/05/16/FnkF6onXKVqzNcPxu3uxDZit37J0.png',
      back: 'https://img01.yzcdn.cn/upload_files/2021/05/16/Ftskl8N6Tp4dPgqTV0JyasnmMXv7.png',
      id: '9',
      showClass: false,
      opacity: false,
      point: 90,
      disabled: false,
    },
    ]
  },

  onLoad() {

    //初始化游戏信息
    this.getGameInfo();


    let carWidth = 0;
    const { cardData } = this.data;
    this.addPosition(cardData); // 数组添加移动坐标位置
    wx.getSystemInfo({
      success(res) {
        carWidth = parseInt((res.windowWidth - 40) / 3);
      }
    })
    this.setData({
      carWidth
    })
    this.allMove()
  },

  // 数组添加移动坐标值 并且把所有的disabled 状态还原会false 
  addPosition(cardData){
    const lineTotal = 3 // 单行数
    cardData.map((item, index) => {
      let x = index % lineTotal
      let y = parseInt(index / lineTotal)
      item.twoArry = { x, y }
      item.disabled = false;   // 还原所有的disabled 状态
    })
    this.setData({cardData})
  },

  //全部翻转
  allChange() {
    const { cardData } = this.data
    cardData.map(item => {
      if (!item.showClass) {
        item.showClass = true;
      }
    })
    this.setData({
      cardData
    })
  },

  //洗牌
  allMove() {
    const { carWidth, cardData } = this.data;
    // 110 是卡牌宽度加边距
    this.shuffle(carWidth) //移动到中心,  110 是牌的宽度，加上外边距边框
    let timer = setTimeout(() => {
      // 每次移动到中心位置以后，先打乱数组顺序，给数组每一项重新添加移动坐标值，setData({cardData}) 然后在散开
      cardData.sort(this.randomsort);
      this.addPosition(cardData)
      clearTimeout(timer)
      this.shuffle(0) // 间隔1秒钟，移动到原来位置
    }, 1000)
  },

  // 洗牌函数
  shuffle(translateUnit) {
    let { cardData } = this.data;
    cardData.map((item, index) => {
      let animation = wx.createAnimation({
        duration: 500,
        timingFunction: 'ease'
      })
      animation.export()
      const translateUnitX = translateUnit * (1 - item.twoArry.x)
      const translateUnitY = translateUnit * (1 - item.twoArry.y)
      animation.translate(translateUnitX, translateUnitY).step()
      item.animationData = animation.export()
      item.opacity = false;
      if (item.showClass) {
        item.showClass = false;
      }
    })
    this.setData({
      cardData
    })
  },




  // 打乱数组顺序
  randomsort(a, b) {
    return Math.random()>.5 ? -1 : 1;
    //用Math.random()函数生成0~1之间的随机数与0.5比较，返回-1或1
  },



  // 处理单个点击翻转
  handleCurClick(event) {
    let { cardData, number, carWidth } = this.data;
    if (number <= 0) {
      wx.showModal({
        title: '提示',
        content: '您今日已经没有抽奖机会了！',
        confirmText: "确定",
        showCancel: false
      });
      return;
    }
    let curId = event.currentTarget.dataset.id;
    // 每次点击时获取被点击拍的disable 属性，
    let disabled = event.currentTarget.dataset.disabled;
    //如果为true 就返回不继续向下执行
    if(disabled){
      return; 
    }
    let point = '';
    cardData.forEach(item => {
      item.disabled = true;  // 点击一张拍以后，把所有的牌的disabled 属性改成true ，
      if (item.id === curId) {
        item.showClass = true;
        point = item.point;
      }else {
        item.opacity = true
      }
    })
    number -= 1;
    this.setData({
      cardData, 
      number
    })
    setTimeout(() => {
      this.allChange()
    }, 1000);
    let _this = this;
    setTimeout(() => {
      wx.showModal({
        title: '提示',
        content: '恭喜您获得'+ point +'积分！',
        cancelText: '去看看',
        confirmText: '再翻一次',
        success(res) {
          if (res.confirm) {
            console.log('用户点击确定')
            _this.sendPoint(point)
            _this.shuffle(carWidth) //移动到中心,  110 是牌的宽度，加上外边距边框
            wx.showLoading({
              title: '获取数据中...',
            })
            // 这里去请求接口重新获取数据，获取成功以后调用 this.shuffle(0) 这里用
            setTimeout(() => {
              wx.hideLoading()
              // 每次移动到中心位置以后，先打乱数组顺序，给数组每一项重新添加移动坐标值，setData({cardData}) 然后在散开
              cardData.sort(_this.randomsort);
              _this.addPosition(cardData)
              _this.shuffle(0)
            }, 3000)
          } else if (res.cancel) {
            console.log('用户点击取消')
            _this.sendPoint(point)
            //https://doc.youzanyun.com/resource/front/40177/41712
            //页面跳转
            let redirectUrl = "/packages/dy/game/index"
            getApp().getYouZanYunSdk().navigate('pointCenter', {redirectUrl:redirectUrl}, 'redirectTo')
          }
        }
      })
    }, 3000);
  },

//获取店铺配置的游戏内容
  getGameInfo(){

    //小程序SDK使用指南
    //https://doc.youzanyun.com/resource/front/40177/41496
    let yunSdk = getApp().getYouZanYunSdk();
    //全局数据----获取店铺信息
    //https://doc.youzanyun.com/resource/front/40177/41711
    let kdtId = yunSdk.app.shop.kdtId;

    //小程序前端扩展----接口请求
    //https://doc.youzanyun.com/resource/front/40177/41713
    request({
      appName:"dy",
      path: 'kdt/info?kdtId=' + kdtId,
      method: 'GET',
      succeed: (res) => {
        console.log('res:', res);
        let gameName = res.data.gameInfo.name;
        this.setData({ gameName : gameName });
      },
      failed: (err) => {
        wx.showToast({
          title: "获取游戏信息失败！",
          icon: "error"
        })
        console.log('err:', err);
      }
    })
  },


  // 发放积分
  sendPoint(integralNum) {



    //小程序SDK使用指南
    //https://doc.youzanyun.com/resource/front/40177/41496
    let yunSdk = getApp().getYouZanYunSdk();
    //全局数据----获取店铺信息
    //https://doc.youzanyun.com/resource/front/40177/41711
    let kdtId = yunSdk.app.shop.kdtId;


    // 获取用户基本信息
    yunSdk.app.getUserInfo().then(({ userInfo, state }) => {
      console.log('getUserInfo:', userInfo);
      console.log('state:', state);
    }).catch((e) => {
          // e 错误对象
          // e.msg 错误信息
        });



    //小程序前端扩展----接口请求
    //https://doc.youzanyun.com/resource/front/40177/41713
    yunSdk.app.getUserInfo().then(({ userInfo, state }) => {
      let yzOpenId = userInfo.userOpenId;
      let data = {
        integralNum: integralNum,
        kdtId: kdtId,
        yzOpenId: yzOpenId
      };
      console.log('data:', data);
      request({
        //isv: 'dy.isv-dev.youzan.com',
        appName:"dy",
        path: 'integral/info',
        method: 'POST',
        data: data,
        succeed: (res) => {
            console.log('res:', res);
        }, 
        failed: (err) => {
            console.log('err:', err);
        }
      })
    }).catch(err => {
      wx.showToast({
        title: "发放积分失败！",
        icon: "error"
      })
    });
  },






});

