import React from 'react'
import { Input, Button, Swiper } from 'zent'
import RestService from '../rest/RestService'

const rest = new RestService()
const pages = [
    'https://img01.yzcdn.cn/upload_files/2021/05/27/Fia31Ey50reDa0zFeTYSdsYActN4.jpg'
    ]

export default class SecondPage extends React.Component {
    constructor(...args) {
        super(...args)
        this.state = {
            kdtId: sessionStorage.getItem('kdtId') || '',
            status: true,
            activityName: ''
        }
    }

    componentWillMount() {
        let token = this.getQueryVariable('newUserToken')
        if (token) {
            rest.getAESToken(token, this.handleTokenResult)
        } else {
            token = window.newUserToken
            rest.getAESToken(token, this.handleTokenResult)
        }
        this.refresh(sessionStorage.getItem('kdtId'))
    }

    onClickSave = (activityName, kdtId) => {
        rest.insertActivity({kdtId: kdtId, name: activityName}, this.handleStatus)
    }

    onClickDelete = (kdtId) => {
        rest.deleteActivity(kdtId, this.handleStatus)
        this.setState({
            activityName: ''
        })
    }

    getQueryVariable = (variable) => {
        let query = window.location.search.substring(1)
        let vars = query.split("&")
        for (let i = 0; i < vars.length; i++) {
            let pair = vars[i].split("=")
            if (pair[0] === variable) {
                return pair[1]
            }
        }
        return false
    }

    refresh = (kdtId) => {
        rest.getKdtInfo(kdtId, this.handleRefresh)
    }

    handleRefresh = (res) => {
        let name = res.data.gameInfo?.name
        if (name) {
            this.setState({
                activityName: name,
                status: true
            })
        } else {
            this.setState({
                status: false
            })
        }
    }

    handleTokenResult = (res) => {
        let kdtId = res.data?.kdtId
        if (kdtId) {
            sessionStorage.setItem('kdtId', kdtId)
            this.refresh(sessionStorage.getItem('kdtId'))
        }
    }

    handleStatus = (status) => {
        this.setState({
            status: status
        })
    }

    render() {
        const { activityName, status, kdtId } = this.state
        return (
            <div style={{display: "flex", flexItems:'center', padding:"16px 16px"}}>

                <div style={{width:'360px',height:'780px',minWidth:'360px'}}>
                    <Swiper
                        autoplay
                    >
                        {
                            pages.map((item, index) => {
                                return (
                                    <div key={index}>
                                        <img src={item} style={{float:'left',height:'100%',width:'100%'}} />
                                    </div>)
                            })
                        }
                    </Swiper>
                </div>

                <div style={{marginLeft:'16px',flexGrow:1}}>
                    <legend style={{fontSize:'14px',fontWeight:700,borderBottom:"1px solid #ebedf0",paddingBottom:"8px"}}>基本信息</legend>

                    <div style={{display: "flex", alignItems: "center", marginTop: "24px"}}>
                        <div  style={{display: "inline-block", width: "130px", textAlign:"right"}}>
                            <em style={{color:'red',fontSize:'16px',verticalAlign:'middle',marginRight:'6px'}}>*</em>
                            游戏名称：
                        </div>
                        <Input value={activityName}
                               placeholder="最多11个字"
                               style={{width:'180px',marginLeft:"8px"}}
                               onChange={e => this.setState({activityName: e.target.value})}
                        />
                    </div>

                    <div>
                        <div style={{display: "flex", justifyContent: "left", marginLeft:'60px', marginTop: '24px'}}>
                            小程序链接地址：packages/dy/game/index
                        </div>
                    </div>

                    <div>
                        <div style={{display: "flex", justifyContent: "left", marginLeft:'200px', marginTop: '24px'}}>
                            {
                                status? (
                                    <div>
                                        <Button disabled type="primary" onClick={() => this.onClickSave(activityName, kdtId)}>保存</Button>
                                        <Button type="danger" onClick={() => this.onClickDelete(kdtId)}>删除</Button>
                                    </div>
                               
                                ) : (
                                   <div>
                                        <Button type="primary" onClick={() => this.onClickSave(activityName, kdtId)}>保存</Button>
                                        <Button disabled type="danger" onClick={() => this.onClickDelete(kdtId)}>删除</Button>
                                   </div>
                                )
                            }
                        </div>

                    </div>
                </div>
            </div>
        )
    }
}
