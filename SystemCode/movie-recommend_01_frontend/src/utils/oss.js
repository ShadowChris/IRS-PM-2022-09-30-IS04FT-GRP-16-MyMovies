//配置连接oss
let OSS = require('ali-oss')
// export let client = new OSS({
//     // region: '1',
//     // accessKeyId: '1',
//     // accessKeySecret: '1',
//     // bucket: '1'
// })

//单独标记每个文件
export function getCurrentDateTime(){
    const year = new Date().getFullYear();
    const month = new Date().getMonth()+1<10?"0"+new Date().getMonth()+1:new Date().getMonth()+1;
    const date =  new Date().getDate()<10?"0"+new Date().getDate():new Date().getDate();
    const hh = new Date().getHours()<10?"0"+new Date().getHours():new Date().getHours();
    const mm = new Date().getMinutes()<10?"0"+new Date().getMinutes():new Date().getMinutes();
    const ss = new Date().getSeconds()<10?"0"+new Date().getSeconds():new Date().getSeconds();
    const dateTime = year + month + date + hh + mm + ss ;
    return dateTime;
}

