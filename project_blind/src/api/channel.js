/**
 * 杨易达
 * @email: y51288033@outlook.com
 */
import http from "@/utils/httpRequest";

/**
 * 将文件插入通道
 * @param {*} data 
 * @returns 
 */
export function insertFileToChannel(data){
    return http({
        url: "/file/pagingToGetData",
        method: "post",
        data: data
    })
}


/**
 * 获取当前时间可用通道
 */
export function currentTimeData(){
    return http({
        url: "/channels/currentTimeData",
        method: "get",
    })
}

/**
 * 获取当前时间可用通道
 */
export function channelsPagination(){
    return http({
        url: "/channels/channelsPagination",
        method: "post",
    })
}

/**
 * 分页获取列表
 * @param {*} channels 
 * @returns 
 */
export function getDataByPage(channels) {
    return http({
        url: "/channels/queryByPage",
        method: "post",
        data: channels
    })
}

/**
 * 新增
 * @param {*} carousel {}
 * @returns 
 */
export function addChannels(channels) {
    return http({
        url: `/channels/add`,
        method: "post",
        data:channels
    })
}

/**
 * 根据ID获取
 * @param {number} id 
 * @returns 
 */
export function selectById(id) {
    return http({
        url: `/channels/queryById/${id}`,
        method: "get"
    })
}

/**
 * 更新channels
 * @param {*} channels {}
 * @returns 
 */
export function updateChannels(channels) {
    return http({
        url: `/channels/edit`,
        method: "post",
        data: channels
    })
}

/**
 * deleteById
 * @param {*} id 
 * @returns 
 */
export function deleteById(id) {
    return http({
        url: `/channels/deleteById/${id}`,
        method: "post"
    })
}