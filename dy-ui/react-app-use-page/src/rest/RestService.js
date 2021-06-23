import axios from 'axios'

// https://dy.isv-dev.youzan.com
const host = ''

class RestService {

  // 删除游戏
  deleteActivity = (obj, callBack) => {
    axios.get(host + `/game/infoDelete?kdtId=${obj}`).then(
      (res) => {
        callBack(false)
      }
    ).catch(
      (error) => {
        callBack('error')
      }
    )
  }

  // 创建游戏
  insertActivity = (obj, callBack) => {
    axios.post(host + '/game/info', obj).then(
      (res) => {
        callBack(true)
      }
    ).catch(
      (error) => {
        callBack('error')
      }
    )
  }

  // 获取AES解密数据
  getAESToken = (obj, callBack) => {
      axios.get(host + `/kdt/info?newUserToken=${obj}`).then(
          (res) => {
              callBack(res.data)
          }
      ).catch(
          (error) => {
              callBack('error')
          }
      )
  }

  // 查询游戏
  getKdtInfo = (obj, callBack) => {
    axios.get(host + `/kdt/info?kdtId=${obj}`).then(
        (res) => {
            callBack(res.data)
        }
    ).catch(
        (error) => {
            callBack('error')
        }
    )
  }
}

export default RestService
